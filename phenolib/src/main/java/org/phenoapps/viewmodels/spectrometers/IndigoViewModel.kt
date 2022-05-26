package org.phenoapps.viewmodels.spectrometers

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.preference.PreferenceManager
import kotlinx.coroutines.*
import org.phenoapps.interfaces.iot.Device
import org.phenoapps.interfaces.spectrometers.IndigoControlListener
import org.phenoapps.interfaces.spectrometers.Spectrometer.Companion.DEVICE_TYPE_INDIGO
import org.phenoapps.utils.GattUtil.Companion.toHexByteArray
import org.phenoapps.utils.GattUtil.Companion.toHexString
import org.phenoapps.utils.GattUtil.Companion.toPixelWave
import org.phenoapps.utils.GattUtil.Companion.toUnsignedInt8Array
import org.phenoapps.utils.KeyUtil
import org.phenoapps.viewmodels.bluetooth.gatt.GattViewModel
import kotlin.math.min

/** Indigo NIR ATT Definitions:
 * Services
"00001801-0000-1000-8000-00805f9b34fb" -> "Generic Goya Attribute Service"
"00001800-0000-1000-8000-00805f9b34fb" -> "Generic Goya Access Service"
"d973f1e0-b19e-11e2-9e96-0800200c9a66" -> "Goya Sensor Service"
"d973f2e0-b19e-11e2-9e96-0800200c9a66" -> "Goya Sample Service"
"d973f3e0-b19e-11e2-9e96-0800200c9a66" -> "Goya Control Service"
"d973f4e0-b19e-11e2-9e96-0800200c9a66" -> "Goya System Service"
 */

/**
 * Characteristics

//Goya Attribute Service Chars
"00002a05-0000-1000-8000-00805f9b34fb" -> "Goya Service Changed"

//Goya Access Service Chars
"00002a00-0000-1000-8000-00805f9b34fb" -> "Goya Device Name"
"00002a01-0000-1000-8000-00805f9b34fb" -> "Goya Appearance"
"00002a04-0000-1000-8000-00805f9b34fb" -> "Goya Lab Device"

//Goya Sample Service Chars
"d973f2e1-b19e-11e2-9e96-0800200c9a66" -> "Transmit"
"d973f2e2-b19e-11e2-9e96-0800200c9a66" -> "Receive"

//Goya Sensor Service Chars
"d973f1e1-b19e-11e2-9e96-0800200c9a66" -> "Row Start"
"d973f1e2-b19e-11e2-9e96-0800200c9a66" -> "Col Start"
"d973f1e3-b19e-11e2-9e96-0800200c9a66" -> "Row Size"
"d973f1e4-b19e-11e2-9e96-0800200c9a66" -> "Col Size"
"d973f1e5-b19e-11e2-9e96-0800200c9a66" -> "Horizontal Blank"
"d973f1e6-b19e-11e2-9e96-0800200c9a66" -> "Vertical Blank"
"d973f1e7-b19e-11e2-9e96-0800200c9a66" -> "Shutter Width"
"d973f1e8-b19e-11e2-9e96-0800200c9a66" -> "Global Gain"
"d973f1e9-b19e-11e2-9e96-0800200c9a66" -> "Cal Threshold"
"d973f1ea-b19e-11e2-9e96-0800200c9a66" -> "Cal Control"
"d973f1eb-b19e-11e2-9e96-0800200c9a66" -> "Unused"
"d973f1ec-b19e-11e2-9e96-0800200c9a66" -> "Temp Cam"
"d973f1ed-b19e-11e2-9e96-0800200c9a66" -> "V. Battery"

//Goya Control Service Chars
"d973f3e1-b19e-11e2-9e96-0800200c9a66" -> "Control Transmit"
//Notifications:
B -> battery event critical
T -> temperature event
1, 2, 3 -> GPIO # event
D -> Power down event
"d973f3e2-b19e-11e2-9e96-0800200c9a66" -> "Control Receive"
//Writes
C -> Trigger single scan
L -> Trigger continuous scan
E -> stop continuous scan
D -> Power down request
F -> Load config from flash
S -> save config in flash
R -> get factory config in flash
P -> push parameters to camera
... and more

//Goya System Service Chars
"d973f4e0-b19e-11e2-9e96-0800200c9a66" -> "Sensor System Service"
"d973f4e1-b19e-11e2-9e96-0800200c9a66" -> "Firmware Version"
"d973f4e2-b19e-11e2-9e96-0800200c9a66" -> "Hardware Version"
"d973f4e3-b19e-11e2-9e96-0800200c9a66" -> "Serial Number"
"d973f4e4-b19e-11e2-9e96-0800200c9a66" -> "IndiGo Header"
"d973f4e5-b19e-11e2-9e96-0800200c9a66" -> "Lambda 1"
"d973f4e6-b19e-11e2-9e96-0800200c9a66" -> "Lambda 2"
"d973f4e7-b19e-11e2-9e96-0800200c9a66" -> "Lambda 3"
"d973f4e8-b19e-11e2-9e96-0800200c9a66" -> "Lambda 4"
"d973f4e9-b19e-11e2-9e96-0800200c9a66" -> "Custom data"

 This class extends a base gatt view model for working with an Indigo NIR spectrometer.
 See interface IndigoControlListener for indigo-specific functions.
 See GatViewModel for how gatt services/characteristics are handled.
 */

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
open class IndigoViewModel: GattViewModel(), IndigoControlListener {

    companion object {
        const val INDIGO_SAMPLE_VECTOR_SIZE = 6
        const val REFERENCE_LAMBDA_SIZE = 4
        const val DEVICE_INFO_SIZE = 3

        const val RAW_DATA_SIZE = 1206

        const val SYSTEM_SERVICE = "d973f4e0-b19e-11e2-9e96-0800200c9a66"
        const val SYSTEM_FIRMWARE = "d973f4e1-b19e-11e2-9e96-0800200c9a66"
        const val SYSTEM_HARDWARE = "d973f4e2-b19e-11e2-9e96-0800200c9a66"
        const val SYSTEM_SERIAL_NUMBER = "d973f4e3-b19e-11e2-9e96-0800200c9a66"
        const val SYSTEM_LAMBDA_1 = "d973f4e5-b19e-11e2-9e96-0800200c9a66"
        const val SYSTEM_LAMBDA_2 = "d973f4e6-b19e-11e2-9e96-0800200c9a66"
        const val SYSTEM_LAMBDA_3 = "d973f4e7-b19e-11e2-9e96-0800200c9a66"
        const val SYSTEM_LAMBDA_4 = "d973f4e8-b19e-11e2-9e96-0800200c9a66"
        const val SYSTEM_LAMBDA_5 = "d973f4e9-b19e-11e2-9e96-0800200c9a66"

        const val SAMPLE_SERVICE = "d973f2e0-b19e-11e2-9e96-0800200c9a66"
        const val SAMPLE_TRANSMIT = "d973f2e1-b19e-11e2-9e96-0800200c9a66"

        const val CONTROL_SERVICE = "d973f3e0-b19e-11e2-9e96-0800200c9a66"
        const val CONTROL_TRANSMIT = "d973f3e1-b19e-11e2-9e96-0800200c9a66"
        const val CONTROL_RECEIVE = "d973f3e2-b19e-11e2-9e96-0800200c9a66"
        const val RECEIVE_DISABLE_UV = "06"
        const val RECEIVE_ENABLE_UV = "16"
        const val RECEIVE_SINGLE_SCAN = "C"
        const val RECEIVE_DISABLE_LOW_MTU = "21"
        const val TRANSMIT_GPIO_1 = "1"
        const val TRANSMIT_GPIO_2 = "2"
        const val TRANSMIT_GPIO_3 = "3"

        const val MTU_SIZE_RAW_PIXEL_MODE = 205

        const val SCAN_DELAY_MS = 5000L

        const val ALLOWED_NUM_FAILS = 16
    }

    data class WaveVal(var wave: Double, var value: Double) {
        override fun toString(): String {
            return "($wave,$value)"
        }
    }

    /**
     * Pair of wavelength to pixel index used in Indigo interpolation.
     */
    data class LambdaReference(var wave: Int, var pix: Int)

    private var scanArray = arrayOfNulls<ByteArray>(INDIGO_SAMPLE_VECTOR_SIZE)
    private var referenceArray = arrayOfNulls<LambdaReference>(REFERENCE_LAMBDA_SIZE)
    private var infoArray = arrayOfNulls<String>(DEVICE_INFO_SIZE)
    var onClickScanButton: () -> Unit = {}

    private var adapter: BluetoothAdapter? = null

    fun isConnected(): Boolean {
        return if (!((referenceArray.mapNotNull { it }.size == REFERENCE_LAMBDA_SIZE) and
            (infoArray.mapNotNull { it }.size == DEVICE_INFO_SIZE))) {
                if (referenceArray[0] == null) read(SYSTEM_SERVICE, SYSTEM_LAMBDA_1)
                if (referenceArray[1] == null) read(SYSTEM_SERVICE, SYSTEM_LAMBDA_2)
                if (referenceArray[2] == null) read(SYSTEM_SERVICE, SYSTEM_LAMBDA_3)
                if (referenceArray[3] == null) read(SYSTEM_SERVICE, SYSTEM_LAMBDA_4)
                if (infoArray[0] == null) read(SYSTEM_SERVICE, SYSTEM_FIRMWARE)
                if (infoArray[1] == null) read(SYSTEM_SERVICE, SYSTEM_HARDWARE)
                if (infoArray[2] == null) read(SYSTEM_SERVICE, SYSTEM_SERIAL_NUMBER)
            false
        } else {
            super.isGattConnected()
        }
    }

    fun isConnectedLive() = liveData {
        while (!isConnected()) {
            emit(isConnected())

            read(SYSTEM_SERVICE, SYSTEM_LAMBDA_1)
            read(SYSTEM_SERVICE, SYSTEM_LAMBDA_2)
            read(SYSTEM_SERVICE, SYSTEM_LAMBDA_3)
            read(SYSTEM_SERVICE, SYSTEM_LAMBDA_4)
            read(SYSTEM_SERVICE, SYSTEM_FIRMWARE)
            read(SYSTEM_SERVICE, SYSTEM_HARDWARE)
            read(SYSTEM_SERVICE, SYSTEM_SERIAL_NUMBER)

            delay(LIVE_DATA_DELAY_MS)
        }
        emit(isConnected())
    }

    fun getDeviceInfo(): Device.DeviceInfo {

        val soft = infoArray[0]
        val hard = infoArray[1]
        val deviceId = infoArray[2]
        return Device.DeviceInfo(
            soft ?: "?",
            hard ?: "?",
            deviceId?.replace("\"", "")?.replace(" ", "") ?: "?",
            "?",
            "?",
            DEVICE_TYPE_INDIGO,
            "?",
            "?",
            "?")
    }

    /**
     * load parameters must be called first
     * Live data that spits out interpolated wavelength / value data.
     * Converts data to unsigned 8 bit integers and interpolates data once
     * all reference points are found.
     */
    fun interpolatedData(): LiveData<List<Frame>?> = liveData(liveContext.coroutineContext) {

        var fails = 0
        while (true) {

            val references = referenceArray.mapNotNull { it }

            if (references.size == REFERENCE_LAMBDA_SIZE) {

                val uint8Data = scanArray.toUnsignedInt8Array().toIntArray()

                Log.d("Gatt", "uint8 data size: ${uint8Data.size}")

                if (uint8Data.size == RAW_DATA_SIZE) {

                    emit(listOf(Frame().apply {
                        val data = interpolate(uint8Data, references.toTypedArray()).associate {
                            it.wave.toString() to it.value.toString()
                        }
                        wavelengths = data.keys.joinToString(" ") { it }
                        rawData = data.values.joinToString(" ") { it }
                    }))

                    //clear scan array
                    (0 until INDIGO_SAMPLE_VECTOR_SIZE).forEach { scanArray[it] = null }

                    fails = 0

                } else if (++fails >= ALLOWED_NUM_FAILS) {

                    requestMtu(MTU_SIZE_RAW_PIXEL_MODE)

                    emit(listOf(Frame().apply { length = -1 }))

                    fails = 0
                }
            }

            delay(LIVE_READ_DATA_DELAY_MS)

        }
    }

    /**
     * load parameters must be called first
     *
     */
    override fun readRawData(): LiveData<List<Frame>?> = liveData(liveContext.coroutineContext) {

        while (true) {

            val frames = scanArray.map { byteArray ->
                Frame(rawData = arrayListOf<Int>().apply {
                    byteArray?.forEach { byte ->
                        //convert each signed byte to unsigned 2^8
                        add(byte.toInt() and 0xFF)
                    }
                }.joinToString(" ") { "$it" })
            }

            emit(frames)

            //clear scan array
            (0 until INDIGO_SAMPLE_VECTOR_SIZE).forEach { scanArray[it] = null }

            delay(LIVE_DATA_DELAY_MS)
        }
    }

    /**
     * Uses three characteristic writes to perform an NIR scan.
     * First: enable UV light
     * Second: start scan
     * Third: disable UV light
     *
     * Control is limited by a flag so multiple events cannot be passed to the device.
     * Each command has a delay to not flood the BLE server.
     */
    var isScanning = false
    override fun triggerSingleCapture() {
        if (!isScanning) {
            isScanning = true
            viewModelScope.launch(liveContext.coroutineContext) {
                requestMtu(MTU_SIZE_RAW_PIXEL_MODE)
                delay(BLE_COMMAND_QUEUE_DELAY)
                notify(SAMPLE_SERVICE, SAMPLE_TRANSMIT)
                delay(BLE_COMMAND_QUEUE_DELAY)
                write(CONTROL_SERVICE, CONTROL_RECEIVE, RECEIVE_ENABLE_UV.toHexByteArray())
                delay(BLE_COMMAND_QUEUE_DELAY)
                write(CONTROL_SERVICE, CONTROL_RECEIVE, RECEIVE_SINGLE_SCAN.toByteArray())
                delay(SCAN_DELAY_MS)
                write(CONTROL_SERVICE, CONTROL_RECEIVE, RECEIVE_DISABLE_UV.toHexByteArray())
                delay(BLE_COMMAND_QUEUE_DELAY)
                isScanning = false
            }
        }
    }

    /**
     * Listens for raw data and device events.
     * Raw data comes in 6 notify vectors where the first byte is an index.
     * Raw data sized is limited by the MTU of the BLE server.
     */
    override fun onCharacteristicChanged(
        gatt: BluetoothGatt?,
        characteristic: BluetoothGattCharacteristic?
    ) {
        characteristic?.value?.let { bytes ->
            Log.d("Gatt", "Char change. ${String(bytes)}")
        }

        when (characteristic?.uuid?.toString()) {
            //raw data
            SAMPLE_TRANSMIT -> {

                val data = characteristic.value

                if (data != null && data.isNotEmpty()) {

                    //first byte is the encoded index from 0-5
                    val index = data.first().toInt()

                    //drop first index byte and add all other data to scan array
                    scanArray[index] = data.drop(1).toByteArray()
                }
            }
            //Goya Control Notify
            CONTROL_TRANSMIT -> {

                val nibble1 = characteristic.value.toHexString()
                Log.d("Gatt", "Control notify detected nibble: $nibble1")

                when (nibble1) {
                    "B" -> onBatteryCritical()
                    "T" -> onTemperatureEvent()
                    "1" -> onGpioOne()
                    "2" -> onGpioTwo()
                    "3" -> onGpioThree()
                    "D" -> onPowerButton()
                }
            }
        }
    }

    /**
     * When services are discovered, a higher MTU value is requested to allow
     * for the entire raw data to be read. Optimal value seems to be 205 to get entire data.
     */
    override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
        super.onServicesDiscovered(gatt, status)
        notify(SAMPLE_SERVICE, SAMPLE_TRANSMIT)
        //TODO Control transmit notifications are not working!
        //notify(CONTROL_SERVICE, CONTROL_TRANSMIT)
        disableLowMtuMode()
        requestMtu(MTU_SIZE_RAW_PIXEL_MODE)
    }

    /**
     * Linear interpolation to find y when known points a and b are used.
     * y = y1 + (x - x1) * ((y2 - y1) / (x2 - x1))
     *
     * Input: @param values: list of pixel values @param knowns: known pixel index / wavelength pairs read from device
     * Output: list of interpolated wavelength / pixel value pairs
     *
     * Method:
     */
    private fun interpolate(values: IntArray, knowns: Array<LambdaReference>) = arrayListOf<WaveVal>().apply {

        //wave boundary is defined a little before and after the model's defined range
        val minBoundaryWave = 700
        val maxBoundaryWave = 1100

        //indices are defined around the values array
        val minBoundaryIndex = 0
        val maxBoundaryIndex = values.size + 1

        if (knowns.size == REFERENCE_LAMBDA_SIZE) {

            val n = listOf(LambdaReference(minBoundaryWave, minBoundaryIndex)) + knowns.toMutableList() + listOf(LambdaReference(maxBoundaryWave, maxBoundaryIndex))

            //for each  pixel in the raw data, find a wavelength interpolated from the known points
            //generate a new wave/value pair based on the linear interpolation between knownA and knownB
            values.forEachIndexed { index, value ->

                //find the closest point before the pixel
                val knownA = n.filter { k -> index >= k.pix }
                    .maxByOrNull { it.pix }?.let { x ->
                        WaveVal(x.wave.toDouble(), x.pix.toDouble())
                    }

                //find the closest point after the pixel
                val knownB = n.filter { k -> index < k.pix }
                    .minByOrNull { it.pix }?.let { y ->
                        WaveVal(y.wave.toDouble(), y.pix.toDouble())
                    }

                //if both points are found, draw a line between the points with the known pixel index
                if (knownA != null && knownB != null) {

                    val wavelength = knownA.wave + (index - knownA.value) * ((knownB.wave - knownA.wave) / (knownB.value - knownA.value))

                    //trim and add generated point to output
                    val waveString = wavelength.toString()
                    val trimWave = try {
                        val dot = waveString.indexOf(".") + 1
                        val pre = waveString.substring(0, dot)
                        val sig = waveString.substring(dot, waveString.length)
                        val post = sig.substring(0, min(sig.length, 4))
                        "$pre$post".toDouble()
                    } catch (e: Exception) {
                        wavelength
                    }

                    add(WaveVal(trimWave, value.toDouble()))
                }
            }
        }
    }

    /**
     * Overrides callback to save lambdas into memory when they are read.
     */
    override fun onCharacteristicRead(
        gatt: BluetoothGatt?,
        characteristic: BluetoothGattCharacteristic?,
        status: Int
    ) {
        super.onCharacteristicRead(gatt, characteristic, status)
        with (characteristic!!) {
            when (characteristic.uuid?.toString()) {
                SYSTEM_LAMBDA_1 -> referenceArray[0] = value?.toPixelWave()
                SYSTEM_LAMBDA_2 -> referenceArray[1] = value?.toPixelWave()
                SYSTEM_LAMBDA_3 -> referenceArray[2] = value?.toPixelWave()
                SYSTEM_LAMBDA_4 -> referenceArray[3] = value?.toPixelWave()
                SYSTEM_FIRMWARE -> infoArray[0] = String(value)
                SYSTEM_HARDWARE -> infoArray[1] = String(value)
                else -> infoArray[2] = String(value)
            }
        }
    }

    open fun connect(adapter: BluetoothAdapter, context: Context) {
        this.adapter = adapter
        val libKeys = KeyUtil(context)
        val address = PreferenceManager.getDefaultSharedPreferences(context)
            .getString(libKeys.argBluetoothDeviceAddress, null)
        if (address != null) {
            register(adapter, context, address)
        }
    }

    open fun reset(adapter: BluetoothAdapter?, context: Context?) {
        clear()
        unregister()

        viewModelScope.launch(liveContext.coroutineContext) {
            delay(LIVE_DATA_DELAY_MS)
            adapter?.let { a ->
                context?.let { ctx ->
                    connect(a, ctx)
                }
            }
        }
    }

    /**
     * Override for connection state callback that will start discovering services.
     * Also handles gatt closing if disconnection happens.
     */
    override fun onConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {
        super.onConnectionStateChange(gatt, status, newState)
        when (newState) {
            BluetoothGatt.STATE_DISCONNECTED -> {
                clear()
                unregister()
            }
        }
    }

    fun clear() {
        scanArray = arrayOfNulls(INDIGO_SAMPLE_VECTOR_SIZE)
        referenceArray = arrayOfNulls(REFERENCE_LAMBDA_SIZE)
        infoArray = arrayOfNulls(DEVICE_INFO_SIZE)
    }

    fun forceViewModelDisconnect() {
        clear()
        unregister()
    }

    override fun disableLowMtuMode() {
        write(CONTROL_SERVICE, CONTROL_RECEIVE, RECEIVE_DISABLE_LOW_MTU.toByteArray())
    }

    override fun getFactoryConfigInFlash() {
        write(CONTROL_SERVICE, CONTROL_RECEIVE, "R".toByteArray())
    }

    override fun onGpioOne() {
        onClickScanButton()
        Log.d("Gatt", "On GPIO Pressed 1")
    }

    override fun onGpioTwo() {
        onClickScanButton()
        Log.d("Gatt", "On GPIO Pressed 2")
    }

    override fun onGpioThree() {
        onClickScanButton()
        Log.d("Gatt", "On GPIO Pressed 3")
    }

    override fun onBatteryCritical() {
        TODO("Not yet implemented")
    }

    override fun onTemperatureEvent() {
        TODO("Not yet implemented")
    }

    override fun onPowerButton() {
        TODO("Not yet implemented")
    }

    override fun triggerContinuousCapture() {
        TODO("Not yet implemented")
    }

    override fun stopContinuousCapture() {
        TODO("Not yet implemented")
    }

    override fun triggerPowerDown() {
        TODO("Not yet implemented")
    }

    override fun loadConfigFromFlash() {
        TODO("Not yet implemented")
    }

    override fun saveActiveConfigInFlash() {
        TODO("Not yet implemented")
    }

    override fun pushParametersToCamera() {
        TODO("Not yet implemented")
    }

    override fun disableBoardLed() {
        TODO("Not yet implemented")
    }

    override fun enableBoardLed() {
        TODO("Not yet implemented")
    }

    override fun startAutoCalibration() {
        TODO("Not yet implemented")
    }

    override fun switchToPixelMode() {
        TODO("Not yet implemented")
    }

    override fun switchToLambdaMode() {
        TODO("Not yet implemented")
    }

    override fun disableIntensityCalibrationFilter() {
        TODO("Not yet implemented")
    }

    override fun enableIntensityCalibrationFilter() {
        TODO("Not yet implemented")
    }

    override fun enableLowMtuMode() {
        TODO("Not yet implemented")
    }
}