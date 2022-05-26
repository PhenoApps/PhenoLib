package org.phenoapps.models.bluetooth.gatt

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattService
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
data class BluetoothGattModel(
    var gatt: BluetoothGatt,
    var service: BluetoothGattService
) {
    override fun equals(other: Any?): Boolean {
        return if (other is BluetoothGattModel) {
            other.service.uuid == service.uuid
        } else false
    }

    override fun hashCode(): Int {
        var result = gatt.hashCode()
        result = 31 * result + service.hashCode()
        return result
    }
}