package org.phenoapps.fragments.gopro

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import kotlinx.coroutines.*
import org.phenoapps.interfaces.bridge.GattBridge
import org.phenoapps.interfaces.gatt.GattCallbackInterface
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import java.util.*

/**
 * This class is responsible for communicating with the GoPro camera via Bluetooth.
 * https://gopro.github.io/OpenGoPro/
 * https://github.com/sepp89117/GoEasyPro_Android/blob/master/app/src/main/java/com/sepp89117/goeasypro_android
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)
class GoProGatt(private val controller: GoProGattController):
    GoProGattInterface,
    GattCallbackInterface,
    CoroutineScope by MainScope() {

    interface GoProGattController {
        fun onApRequested()
        fun onCredentialsAcquired()
        fun onModelId(modelID: Int)
        fun onModelName(modelName: String)
        fun onBoardType(boardType: String)
        fun onFirmware(firmware: String)
        fun onSerialNumber(serialNumber: String)
        fun onSsid(wifiSSID: String)
        fun onBssid(wifiBSSID: String)
    }

    companion object {
        const val TAG = "GoProGatt"
    }

    private val queryUUID = "b5f90076-aa8d-11e3-9046-0002a5d5c51b" // Query [WRITE]
    private val queryRespUUID = "b5f90077-aa8d-11e3-9046-0002a5d5c51b" // Query response [NOTIFY]

    private var queryCharacteristic: BluetoothGattCharacteristic? = null
    private var queryResponseCharacteristic: BluetoothGattCharacteristic? = null

    private val wifiServiceUUID = "b5f90001-aa8d-11e3-9046-0002a5d5c51b" // GoPro WiFi Access Point
    private val wifiSsidUUID = "b5f90002-aa8d-11e3-9046-0002a5d5c51b" // Wifi [READ | WRITE]
    private val wifiPwUUID = "b5f90003-aa8d-11e3-9046-0002a5d5c51b" // Wifi [READ | WRITE]

    private val controlServiceUUID = "0000fea6-0000-1000-8000-00805f9b34fb" // Cam control service
    private val commandUUID = "b5f90072-aa8d-11e3-9046-0002a5d5c51b" // Command [WRITE]
    private val commandResponseUUID = "b5f90073-aa8d-11e3-9046-0002a5d5c51b"

    private var commandCharacteristic: BluetoothGattCharacteristic? = null
    private var commandResponseCharacteristic: BluetoothGattCharacteristic? = null

    var bssid: String? = null

    val callback by lazy { GattBridge.gattBridge(this) }

    var ssid: String? = null
    var password: String? = null
    var gatt: BluetoothGatt? = null

    var readCredentialsJob: Job? = null

    override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
        super.onServicesDiscovered(gatt, status)

        if (status == BluetoothGatt.GATT_SUCCESS) {

            this.gatt = gatt

            readCredentialsJob?.cancel()

            readCredentialsJob = launch {

                withContext(Dispatchers.IO) {

                    Log.d(TAG, "Discovering services...")

                    val controlService = gatt?.services?.find { it.uuid.toString() == controlServiceUUID }

                    commandCharacteristic = controlService?.getCharacteristic(UUID.fromString(commandUUID))
                    queryCharacteristic = controlService?.getCharacteristic(UUID.fromString(queryUUID))
                    commandResponseCharacteristic = controlService?.getCharacteristic(UUID.fromString(commandResponseUUID))
                    queryResponseCharacteristic = controlService?.getCharacteristic(UUID.fromString(queryRespUUID))

                    val wifiService = gatt?.services?.find { it.uuid.toString() == wifiServiceUUID }

                    val ssidCharacteristic = wifiService?.getCharacteristic(UUID.fromString(wifiSsidUUID))
                    val pwCharacteristic = wifiService?.getCharacteristic(UUID.fromString(wifiPwUUID))

                    gatt?.readCharacteristic(ssidCharacteristic)

                    delay(1500L)

                    gatt?.readCharacteristic(pwCharacteristic)

                    delay(1500L)

                    //force camera into image capture mode
                    setImageCaptureMode()

                    delay(1500L)

                    startNotification(commandResponseCharacteristic)

                    delay(1500L)

                    startNotification(queryResponseCharacteristic)

                    delay(1500L)

                    gatt?.writeCharacteristic(commandCharacteristic.also {
                        it?.value = byteArrayOf(0x01, 0x3C)
                    })

                    delay(1500L)

                    queryStatusValues()

                    delay(1500L)

                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                        controller.onCredentialsAcquired()
                    }
                }
            }
        }
    }

    private fun startNotification(char: BluetoothGattCharacteristic?) {

        gatt?.setCharacteristicNotification(char, true)

        val desc = char?.descriptors?.get(0)
        desc?.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE

        gatt?.writeDescriptor(desc)
    }

    override fun onCharacteristicWrite(
        gatt: BluetoothGatt?,
        characteristic: BluetoothGattCharacteristic?,
        status: Int
    ) {
        super.onCharacteristicWrite(gatt, characteristic, status)

        if (status == BluetoothGatt.GATT_SUCCESS) {

            when (characteristic?.uuid.toString()) {

                commandUUID -> {

                    if (characteristic?.value.contentEquals(byteArrayOf(0x03, 0x17, 0x01, 0x01))) {

                        Log.i(TAG, "WiFi AP Enabled Success")

                    } else if (characteristic?.value.contentEquals(byteArrayOf(0x05, 0x03, 0x01, 0x01, 0x01, 0x01))) {

                        Log.d(TAG, "Image capture mode set success")

                    } else if (characteristic?.value.contentEquals(byteArrayOf(0x03, 0x17, 0x01, 0x00))) {

                        Log.i(TAG, "WiFi AP Disabled Success")

                    } else if (characteristic?.value.contentEquals(byteArrayOf(0x01, 0x3C))) {

                        Log.d(TAG, "Hardware Characteristic Write Success")

                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCharacteristicRead(
        gatt: BluetoothGatt?,
        characteristic: BluetoothGattCharacteristic?,
        status: Int
    ) {
        super.onCharacteristicRead(gatt, characteristic, status)

        if (status == BluetoothGatt.GATT_SUCCESS) {

            parseBluetoothData(characteristic, false)
        }
    }

    override fun onConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {
        super.onConnectionStateChange(gatt, status, newState)

        if (status == BluetoothGatt.GATT_SUCCESS) {

            if (newState == BluetoothGatt.STATE_CONNECTED) {

                Log.d(TAG, "Connected to GoPro GATT")

                gatt?.discoverServices()

            } else if (newState == BluetoothGatt.STATE_DISCONNECTED) {

                Log.d(TAG, "Disconnected from GoPro GATT")

            }
        }
    }

    fun clear() {

        readCredentialsJob?.cancel()

        packBuffer?.clear()
        packBuffer = null

        gatt?.close()

    }

    private fun writeCharacteristic(char: BluetoothGattCharacteristic?, value: ByteArray) {

        char?.value = value

        gatt?.writeCharacteristic(char)

    }

    override fun enableAp() {

        writeCharacteristic(commandCharacteristic, byteArrayOf(0x03, 0x17, 0x01, 0x01))

        Log.d(TAG, "Enabling Wifi AP for GoPro...")
    }

    override fun disableAp() {

        writeCharacteristic(commandCharacteristic, byteArrayOf(0x03, 0x17, 0x01, 0x00))

        Log.d(TAG, "Disabling Wifi AP for GoPro...")
    }

    override fun shutterOn() {

        writeCharacteristic(commandCharacteristic, byteArrayOf(0x03, 0x01, 0x01, 0x01))

        Log.d(TAG, "Shutter On")
    }

    override fun shutterOff() {

        writeCharacteristic(commandCharacteristic, byteArrayOf(0x03, 0x01, 0x01, 0x00))

        Log.d(TAG, "Shutter Off")
    }

    private fun setImageCaptureMode() {

        writeCharacteristic(commandCharacteristic, byteArrayOf(0x04, 0x3e, 0x02, 0x03, 0xe9.toByte()))

        Log.d(TAG, "Image Capture On")
    }

    private fun queryStatusValues() {

        writeCharacteristic(queryCharacteristic, byteArrayOf(0x01, 0x53))

        Log.d(TAG, "Querying Status Values")
    }

    var packBuffer: ByteBuffer? = null

    private fun parseBluetoothData(char: BluetoothGattCharacteristic?, onChanged: Boolean) {

        if (onChanged) {

            val bytes = char?.value ?: byteArrayOf()

            val isContPack: Boolean = (bytes[0].toInt() and 128) > 0

            //Log.d(TAG, "Pack continued: $isContPack")

            if (isContPack) {
                val msgLen: Int = bytes.size - 1
                if (packBuffer != null) {
                    try {
                        val putLen = packBuffer?.remaining()?.coerceAtMost(msgLen) ?: 0
                        if (putLen != msgLen) Log.e(
                            TAG,
                            "Message length is " + (msgLen - putLen) + " larger than the buffer"
                        )
                        packBuffer?.put(bytes, 1, putLen)
                    } catch (e: Exception) {
                        Log.e(TAG, "Error: $e")
                        return
                    }
                    if ((packBuffer?.remaining() ?: 0) <= 0) {
                        //all data received
                        parseBtResponsePack()
                    }
                }
            } else try {

                val header = GoHeader(bytes)

                packBuffer = ByteBuffer.allocate(header.msgLength)
                packBuffer?.put(bytes, header.headerLength, bytes.size - header.headerLength)

                if (packBuffer!!.remaining() <= 0) {

                    //all data received
                    parseBtResponsePack()

                    if (char?.uuid.toString() == queryRespUUID) {

                        //Log.d(TAG, "Query Notification Received")

                        handleQueryNotification(bytes)

                    }
                }
            } catch (ignore: Exception) {
                ignore.printStackTrace()
            }

        } else { //on read

            when (char?.uuid.toString()) {

                wifiSsidUUID -> {

                    this.ssid = char?.getStringValue(0)

                }

                wifiPwUUID -> {

                    this.password = char?.getStringValue(0)

                }
            }
        }
    }

    override fun onCharacteristicChanged(
        gatt: BluetoothGatt?,
        characteristic: BluetoothGattCharacteristic?
    ) {
        super.onCharacteristicChanged(gatt, characteristic)
        when (characteristic?.uuid ?: "") {
            commandResponseUUID -> {
                Log.i(TAG, "Response: ${characteristic?.uuid?.toString()}")

                Log.i(TAG, characteristic?.value?.contentEquals(byteArrayOf(0x02, 0x01, 0x00)).toString())

            }
        }
        parseBluetoothData(characteristic, true)
    }

    private fun handleQueryNotification(bytes: ByteArray) {

        val header = GoHeader(bytes)

        val headerLength = header.headerLength
        val commandId: Int = bytes[headerLength].toInt()

        if (commandId == 0x93.toByte().toInt()) { // Multi-Value query response

            //Log.d(TAG, "Multi-Value Query Response")

            var nextLen: Int
            var index = headerLength
            while (index < bytes.size) {
                val statusID: Int = bytes[index].toInt() and 0xff
                nextLen = if (bytes.size > index + 1) bytes[index + 1].toInt() else break
                if (nextLen > 0) {
                    val byteBuffer = ByteBuffer.allocate(nextLen)
                    byteBuffer.put(bytes, index + 2, nextLen)
                    handleStatusData(statusID, byteBuffer)
                }
                index += nextLen + 2
            }
        }
    }

    private fun parseBtResponsePack() {

        //Log.d(TAG, "Parsing BT Response Pack")

        val bytes = packBuffer?.array() ?: byteArrayOf()

        packBuffer?.clear()
        packBuffer = null

        if (bytes.isNotEmpty()) {

            val commandId = bytes[0].toInt()
            val error = bytes[1].toInt()
            var nextStart = 2

            if (error == 0) {

                if (commandId == 60) {

                    var nextLen: Int = bytes[nextStart].toInt()

                    // Model ID
                    var byteBuffer = ByteBuffer.allocate(nextLen)
                    byteBuffer.put(bytes, nextStart + 1, nextLen)
                    byteBuffer.flip()
                    val modelID = byteBuffer.int

                    Log.d(TAG, "Model ID: $modelID")

                    controller.onModelId(modelID)

                    nextStart += 1 + nextLen
                    nextLen = bytes[nextStart].toInt()

                    // model name
                    byteBuffer = ByteBuffer.allocate(nextLen)
                    byteBuffer.put(bytes, nextStart + 1, nextLen)
                    val modelName = String(byteBuffer.array(), StandardCharsets.UTF_8).trim { it <= ' ' }
                    Log.d(TAG, "Model Name: $modelName")

                    controller.onModelName(modelName)

                    nextStart += 1 + nextLen
                    nextLen = bytes[nextStart].toInt()

                    // board type
                    byteBuffer = ByteBuffer.allocate(nextLen)
                    byteBuffer.put(bytes, nextStart + 1, nextLen)
                    val boardType = String(byteBuffer.array(), StandardCharsets.UTF_8).trim { it <= ' ' }

                    Log.d(TAG, "Board Type: $boardType")

                    controller.onBoardType(boardType)

                    nextStart += 1 + nextLen
                    nextLen = bytes.get(nextStart).toInt()

                    // firmware
                    byteBuffer = ByteBuffer.allocate(nextLen)
                    byteBuffer.put(bytes, nextStart + 1, nextLen)
                    val firmware = String(byteBuffer.array(), StandardCharsets.UTF_8).trim { it <= ' ' }
                    Log.d(TAG, "Firmware: $firmware")

                    controller.onFirmware(firmware)

                    nextStart += 1 + nextLen
                    nextLen = bytes[nextStart].toInt()

                    // serial number
                    byteBuffer = ByteBuffer.allocate(nextLen)
                    byteBuffer.put(bytes, nextStart + 1, nextLen)
                    val serialNumber = String(byteBuffer.array(), StandardCharsets.UTF_8).trim { it <= ' ' }
                    Log.d(TAG, "Serial Number: $serialNumber")

                    controller.onSerialNumber(serialNumber)

                    nextStart += 1 + nextLen
                    nextLen = bytes[nextStart].toInt()

                    // AP SSID
                    byteBuffer = ByteBuffer.allocate(nextLen)
                    byteBuffer.put(bytes, nextStart + 1, nextLen)
                    val wifiSSID = String(byteBuffer.array(), StandardCharsets.UTF_8).trim { it <= ' ' }
                    Log.d(TAG, "SSID: $wifiSSID")

                    controller.onSsid(wifiSSID)

                    nextStart += 1 + nextLen
                    nextLen = bytes[nextStart].toInt()

                    // AP MAC Address
                    byteBuffer = ByteBuffer.allocate(nextLen)
                    byteBuffer.put(bytes, nextStart + 1, nextLen)
                    val sb = StringBuilder(
                        String(
                            byteBuffer.array(),
                            StandardCharsets.UTF_8
                        ).trim { it <= ' ' })
                    sb.insert(2, ':')
                    sb.insert(5, ':')
                    sb.insert(8, ':')
                    sb.insert(11, ':')
                    sb.insert(14, ':')
                    val wifiBSSID = sb.toString().uppercase(Locale.getDefault())

                    Log.d(TAG, "BSSID: $wifiBSSID")

                    controller.onBssid(wifiBSSID)

                    bssid = wifiBSSID

                    if (ssid?.isNotBlank() == true && password?.isNotBlank() == true && bssid?.isNotBlank() == true) {

                        //check version is above q
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            controller.onCredentialsAcquired()
                        }
                    }
                }
                else if (commandId == 19) {
                    var nextLen: Int
                    var index = nextStart
                    while (index < bytes.size) {
                        val statusID: Int = bytes[index].toInt() and 0xff
                        nextLen = if (bytes.size > index + 1) bytes.get(index + 1).toInt() else break
                        if (nextLen > 0) {
                            Log.d(TAG, "Status ID: $statusID")
                            val byteBuffer = ByteBuffer.allocate(nextLen)
                            byteBuffer.put(bytes, index + 2, nextLen)
                            handleStatusData(statusID, byteBuffer)
                        }
                        index += nextLen + 2
                    }
                }
            }
        }
    }

    var isCharging = false
    var isHot: Boolean = false
    var isCold: Boolean = false
    var isBusy: Boolean = false
    var isRecording: Boolean = false

    private fun handleStatusData(statusID: Int, buffer: ByteBuffer) {

        //Log.d(TAG, "Status ID: $statusID")

        when (statusID) {
            2 -> {
                isCharging = buffer[0].toInt() == 4
                //Log.d(TAG, "isCharging: $isCharging")
            }
            6 -> {
                isHot = buffer[0].toInt() != 0
                //Log.d(TAG, "isHot: $isHot")
            }
            13 -> {
                buffer.flip()
                val videoProgress = buffer.int
                isRecording = videoProgress != 0
                //Log.d(TAG, "isRecording: $isRecording")
            }
            85 -> {
                isCold = buffer[0].toInt() != 0
                //Log.d(TAG, "isCold: $isCold")
            }
            8 -> {
                isBusy = buffer[0].toInt() != 0
                //Log.d(TAG, "isBusy: $isBusy")
            }
        }
    }
}