package org.phenoapps.models.bluetooth

import android.bluetooth.BluetoothDevice

data class BluetoothDeviceModel(
    var device: BluetoothDevice,
    var rssi: Int? = null
) {
    override fun equals(other: Any?): Boolean {
        return if (other is BluetoothDeviceModel) {
            device.name == other.device.name
        } else false
    }

    override fun hashCode(): Int {
        var result = device.hashCode()
        result = 31 * result + (rssi ?: 0)
        return result
    }
}