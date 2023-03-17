package org.phenoapps.viewmodels.scales

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.preference.PreferenceManager
import org.phenoapps.utils.KeyUtil
import org.phenoapps.viewmodels.bluetooth.gatt.GattViewModel
import java.util.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
open class OhausViewModel: GattViewModel() {

    companion object {

        val OHAUS_COMMAND_CHAR_UUID = UUID.fromString("2456e1b9-26e2-8f83-e744-f34f01e9d703")
        val OHAUS_SERVICE_UUID = UUID.fromString("2456e1b9-26e2-8f83-e744-f34f01e9d701")

        //ohaus command to set scale to 'grams'
        val SET2GRAM = "1U".toByteArray()

        //continuous print command
        val CONTINUOUS = "CP".toByteArray()

    }

    var scaleReading = MutableLiveData<String?>()

    var connected = false

    /**
     * When services are discovered, a higher MTU value is requested to allow
     * for the entire raw data to be read. Optimal value seems to be 205 to get entire data.
     */
    override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
        super.onServicesDiscovered(gatt, status)
        notify(OHAUS_SERVICE_UUID.toString(), OHAUS_COMMAND_CHAR_UUID.toString())
        write(OHAUS_SERVICE_UUID.toString(), OHAUS_COMMAND_CHAR_UUID.toString(), SET2GRAM)
        write(OHAUS_SERVICE_UUID.toString(), OHAUS_COMMAND_CHAR_UUID.toString(), CONTINUOUS)
    }

    override fun onCharacteristicChanged(
        gatt: BluetoothGatt?,
        characteristic: BluetoothGattCharacteristic?
    ) {
        super.onCharacteristicChanged(gatt, characteristic)
        scaleReading.postValue(characteristic?.getStringValue(0))
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