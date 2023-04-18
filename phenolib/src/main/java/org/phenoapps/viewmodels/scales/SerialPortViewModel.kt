package org.phenoapps.viewmodels.scales

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.preference.PreferenceManager
import org.phenoapps.utils.KeyUtil
import org.phenoapps.viewmodels.bluetooth.gatt.GattViewModel
import java.nio.ByteBuffer
import java.util.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
open class SerialPortViewModel: GattViewModel() {

    companion object {

        /**
         * notification uuid
         * attributes.put("0000181d-0000-1000-8000-00805f9b34fb", "WEIGHT_SCALE_SERVICE");
        attributes.put("00002a9e-0000-1000-8000-00805f9b34fb", "CHARACTERISTIC_WEIGHT_SCALE_FEATURE");
        attributes.put("00002a9d-0000-1000-8000-00805f9b34fb", "CHARACTERISTIC_WEIGHT_SCALE_MEASURE");
         */

        //tru connect tx (transmit from server)
        val SERIAL_IO_SCALE_CHAR = UUID.fromString("cacc07ff-ffff-4c48-8fae-a9ef71b75e26")

        //tru connect rx (receive from server)
        val SERIAL_IO_RX_CHAR = UUID.fromString("1cce1ea8-bd34-4813-a00a-c76e028fadcb")

        val SERIAL_IO_WEIGHT_SERVICE = UUID.fromString("175f8f23-a570-49bd-9627-815a6a27de2a")
        val SERIAL_IO_MODE = UUID.fromString("20b9794f-da1a-4d14-8014-a0fb9cefb2f7")
    }

    var scaleReading = MutableLiveData<String?>()

    var connected = false

    override fun onCharacteristicRead(
        gatt: BluetoothGatt?,
        characteristic: BluetoothGattCharacteristic?,
        status: Int
    ) {
        super.onCharacteristicRead(gatt, characteristic, status)
        //Log.d("READ", characteristic?.getStringValue(0) ?: "null")
        Log.d("CSIZE", characteristic?.value?.size?.toString()!!)
        Log.d("CREAD", characteristic?.value?.toUByteArray().toString())

    }

    override fun onDescriptorRead(
        gatt: BluetoothGatt?,
        descriptor: BluetoothGattDescriptor?,
        status: Int
    ) {
        super.onDescriptorRead(gatt, descriptor, status)
        Log.d("DREAD", descriptor?.value?.toString() ?: "")

    }

    override fun onDescriptorWrite(
        gatt: BluetoothGatt?,
        descriptor: BluetoothGattDescriptor?,
        status: Int
    ) {
        super.onDescriptorWrite(gatt, descriptor, status)
        Log.d("DWRITE", descriptor?.value?.toString() ?: "")
    }

    override fun onCharacteristicWrite(
        gatt: BluetoothGatt?,
        characteristic: BluetoothGattCharacteristic?,
        status: Int
    ) {
        super.onCharacteristicWrite(gatt, characteristic, status)
        Log.d("WRITE", characteristic?.getStringValue(0) ?: "null")
    }
    /**
     * When services are discovered, a higher MTU value is requested to allow
     * for the entire raw data to be read. Optimal value seems to be 205 to get entire data.
     */
    override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
        super.onServicesDiscovered(gatt, status)

        notify(SERIAL_IO_WEIGHT_SERVICE.toString(), SERIAL_IO_SCALE_CHAR.toString())

        connected = true
    }

    override fun onCharacteristicChanged(
        gatt: BluetoothGatt?,
        characteristic: BluetoothGattCharacteristic?
    ) {
        super.onCharacteristicChanged(gatt, characteristic)

        if (characteristic?.uuid == SERIAL_IO_SCALE_CHAR) {

            //https://dmx.ohaus.com/WorkArea/showcontent.aspx?id=30234

            val bytes = characteristic!!.value

            //input on Defender 5000 looks like this: A0 A0 A0 A0 30 2E 30 36 36 A0 EB E7 8D 0A 8D 0A
            //A0 are null data 'spaces' (can also be 20), first token is UTF8 string encoded hex value: 30 2E 30 36 36 which when decoded from hex is 0e066 so 0.066
            //second token is probably an ohaus id for unit E7 is gram and EBE7 is kg
            //if starts with 2D its negative so actual output will skip "2" and just have "D" like "D11" for "-11"
            //final string has an "E" for the decimal places
            //if content -> num is selected parse E7 for g and EBE7 for kg (so depending on for loop below this will be 7 or b7 ending)

            //translate bytes to hex
            val hex = bytes.map { String.format("%02X", it.toInt() and 0xFF) }.map { if (it == "20") "A0" else it }

            //join to string and split by A0 null data, grab the first token of data (data is between A0's)
            //replace "20" with "A0" they are both "spaces"
            //ranger 3000 uses ascii 32 == "20" in hex for separator
            //other ranger seems to use "A0" which is space " "
            val readable = hex.joinToString("").split("A0").filter { it.isNotEmpty() }

            var measure = readable[0]

            // E7 -> (g), EB E7 -> (kg)
            //val units = readable[1].split("8D")[0]

            var isNegative = false
            if (measure.startsWith("2D")) {
                isNegative = true
                measure = measure.substring(2)
            }

            val builder = StringBuilder()
            for (i in 1 until measure.length step 2) {
                builder.append(measure[i])
            }

            //final string has an "E" for the decimal places
            measure = builder.toString()
            measure = measure.replace("E", ".")

            if (isNegative) {
                measure = "-$measure"
            }

            scaleReading.postValue(measure)

        }

        connected = true
    }

    open fun connect(adapter: BluetoothAdapter, context: Context) {
        val libKeys = KeyUtil(context)
        val address = PreferenceManager.getDefaultSharedPreferences(context)
            .getString(libKeys.argBluetoothDeviceAddress, null)
        if (address != null) {
            register(adapter, context, address)
        }
    }

    fun isConnected(): Boolean = connected

}