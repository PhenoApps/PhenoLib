package org.phenoapps.models.bluetooth.gatt

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattService
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
data class BluetoothGattCharacteristicModel(
    var characteristic: BluetoothGattCharacteristic,
    var value: String? = null
) {

}