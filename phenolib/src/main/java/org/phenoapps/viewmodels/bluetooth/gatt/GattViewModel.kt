package org.phenoapps.viewmodels.bluetooth.gatt

import android.bluetooth.*
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import org.phenoapps.interfaces.bridge.GattBridge
import org.phenoapps.interfaces.gatt.GattCallbackInterface
import org.phenoapps.models.bluetooth.gatt.BluetoothGattCharacteristicModel
import org.phenoapps.models.bluetooth.gatt.BluetoothGattModel
import java.util.UUID

/**
 * View model extended class for handling ble gatt server communication.
 * Uses kotlin coroutine channel object to handle producer/consumer queue for GATT commands.
 * BLE commands are never 100% successful and servers should not be flooded with commands, therefore
 * typically a delay is used after each command.
 *
 * Processing happens within a defined coroutine scope use liveContext.
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
open class GattViewModel: ViewModel(), GattCallbackInterface {

    companion object {

        const val LIVE_DATA_DELAY_MS = 5000L

        const val LIVE_READ_DATA_DELAY_MS = 2000L

        const val BLE_COMMAND_QUEUE_DELAY = 500L

        const val CCC_DESCRIPTOR_UUID = "00002902-0000-1000-8000-00805f9b34fb"

    }

    private var mGatt: BluetoothGatt? = null

    private var mConnectionStatus: Int = BluetoothGatt.STATE_DISCONNECTED

    //helper that delegates callbacks to GattCallbackInterface implementation
    private val gattCallback by lazy { GattBridge.gattBridge(this) }

    //producer/consumer channel
    private val channel = Channel<BluetoothGatt?.() -> Unit>()

    private var isRegistered = false

    //live data, ble server channel communication coroutine scope
    private var liveJob = Job()
    protected var liveContext = CoroutineScope(Dispatchers.IO + liveJob)

    protected var mServiceList = hashSetOf<BluetoothGattModel>()

    protected fun isGattConnected() = mConnectionStatus == BluetoothGatt.STATE_CONNECTED

    private suspend fun receive() {

        Log.d("Gatt", "Gatt command invoking.")

        channel.receive().invoke(mGatt)
    }

    fun clearServices() {
        synchronized(mServiceList) {
            mServiceList.clear()
        }
    }

    open fun connectGatt(context: Context, device: BluetoothDevice, callback: BluetoothGattCallback) {
        mGatt = device.connectGatt(context, false, gattCallback)
    }

    /**
     * Connects the gatt server to the client.
     * Starts consuming channel messages.
     */
    fun register(adapter: BluetoothAdapter, context: Context, address: String) {

        Log.d("Gatt", "Registering... $address")

        isRegistered = true

        connectGatt(context, adapter.getRemoteDevice(address), gattCallback)

        viewModelScope.launch(liveContext.coroutineContext) {

            while(isActive && isRegistered) {

                receive()

                delay(BLE_COMMAND_QUEUE_DELAY)
            }
        }
    }

    /**
     * Disconnects gatt server and clears memory.
     */
    fun unregister() {

        Log.d("Gatt", "Unregistering...")

        isRegistered = false

        mConnectionStatus = BluetoothGatt.STATE_DISCONNECTED

        mGatt?.disconnect()

        mGatt?.close()

        mGatt = null

        clearServices()

        resetContext()

        //viewModelScope.cancel()
    }

    /**
     * Resets coroutine context.
     */
    fun resetContext() {
        liveContext.cancel()
        liveJob.cancel()
        liveJob = Job()
        liveContext = CoroutineScope(Dispatchers.IO + liveJob)
    }

    /**
     * Emits a list of services that have been discovered.
     */
    fun services() = liveData(liveContext.coroutineContext) {

        while(true) {

            delay(LIVE_DATA_DELAY_MS)

            emit(mServiceList.toList())
        }
    }

    /**
     * Emit all characteristics.
     */
    fun characteristics(serviceUuid: String) = liveData(liveContext.coroutineContext) {

        while (true) {

            val charsList = arrayListOf<BluetoothGattCharacteristicModel>()

            synchronized(mServiceList) {

                mServiceList.find { it.service.uuid.toString() == serviceUuid }?.service?.characteristics?.forEach { characteristic ->

                    if (!charsList.any { it.characteristic.uuid == characteristic.uuid }) {

                        BluetoothGattCharacteristicModel(characteristic).also { model ->
                            charsList.add(model)
                        }
                    }
                }
            }

            emit(charsList.toList())

            delay(LIVE_DATA_DELAY_MS)

        }
    }

    /**
     * Requests a new mtu from the server.
     */
    fun requestMtu(mtu: Int) {

        viewModelScope.launch(liveContext.coroutineContext) {

            channel.send {

                this?.requestMtu(mtu)
            }
        }
    }

    /**
     * Enables notification for a given characteristic.
     */
    private fun notify(model: BluetoothGattCharacteristicModel) {

        viewModelScope.launch(liveContext.coroutineContext) {

            channel.send {

                if (this?.setCharacteristicNotification(model.characteristic, true) == false) {

                    Log.d("Gatt", "Notification failed to enable.")

                } else {

                    Log.d("Gatt", "Notification descriptor sending.")

                    val desc = model.characteristic.getDescriptor(UUID.fromString(CCC_DESCRIPTOR_UUID))

                    desc.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE

                    this?.writeDescriptor(desc)
                }
            }
        }
    }

    /**
     * Writes a byte array to a characteristic.
     */
    private fun write(model: BluetoothGattCharacteristicModel, writeValue: ByteArray) {

        viewModelScope.launch(liveContext.coroutineContext) {

            channel.send {

                this?.writeCharacteristic(model.characteristic.apply {
                    writeType = BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                    value = writeValue
                })
            }
        }
    }

    fun read(model: BluetoothGattCharacteristicModel) {

        viewModelScope.launch(liveContext.coroutineContext) {

            channel.send {

                this?.readCharacteristic(model.characteristic)

            }
        }
    }

    /**
     * Public wrapper of notify that allows developer to give a service/characteristic uuid pair.
     */
    fun notify(service: String, characteristic: String) {

        synchronized(mServiceList) {
            mServiceList.find { it.service.uuid.toString() == service }
                ?.service?.characteristics?.find { it.uuid.toString() == characteristic }?.let { model ->

                    notify(BluetoothGattCharacteristicModel(model))
                }
        }
    }

    /**
     * public wrapper of write.
     */
    fun write(service: String, characteristic: String, value: ByteArray) {

        synchronized(mServiceList) {
            mServiceList.find { it.service.uuid.toString() == service }
                ?.service?.characteristics?.find { it.uuid.toString() == characteristic }?.let { model ->

                    write(BluetoothGattCharacteristicModel(model), value)
                }
        }
    }

    /**
     * public wrapper of read
     */
    fun read(service: String, characteristic: String) {

        synchronized(mServiceList) {
            mServiceList.find { it.service.uuid.toString() == service }
                ?.service?.characteristics?.find { it.uuid.toString() == characteristic }?.let { model ->

                    read(BluetoothGattCharacteristicModel(model))
                }
        }
    }

    /**
     * When lifecycle ends, automatically disconnect server and clear memory.
     */
    override fun onCleared() {
        super.onCleared()
        unregister()
    }

    /**
     * Override for connection state callback that will start discovering services.
     * Also handles gatt closing if disconnection happens.
     */
    override fun onConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {

        when (newState) {
            BluetoothGatt.STATE_CONNECTED -> {
                Log.d("Gatt", "Connected")
                mGatt = gatt
                viewModelScope.launch(liveContext.coroutineContext) {
                    delay(BLE_COMMAND_QUEUE_DELAY)
                    mGatt?.discoverServices()
                }
                mConnectionStatus = newState
            }
            BluetoothGatt.STATE_DISCONNECTING -> {
                Log.d("Gatt", "Disconnecting...")

            }
            BluetoothGatt.STATE_DISCONNECTED -> {
                Log.d("Gatt", "Disconnected.")
                mGatt?.close()
                mGatt = null
                mConnectionStatus = newState
            }
            else -> {
                Log.d("Gatt", "Connecting...")

            }
        }
    }

    /**
     * Saves discovered services into memory.
     */
    override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
        if (status == BluetoothGatt.GATT_SUCCESS) {

            Log.d("Gatt", "Service Discovery success.")

            gatt?.let { gattModel ->

                gattModel.services?.forEach { service ->

                    Log.d("Gatt", "Service Discovered: ${service.uuid}")

                    synchronized(mServiceList) {
                        if (!mServiceList.any { it.service.uuid == service.uuid }) {
                            mServiceList.add(
                                BluetoothGattModel(
                                    gattModel,
                                    service
                                )
                            )
                        }
                    }
                }
            }

        } else {

            Log.d("Gatt", "Service discovery failed, retrying.")

            mGatt?.discoverServices()
        }
    }
}