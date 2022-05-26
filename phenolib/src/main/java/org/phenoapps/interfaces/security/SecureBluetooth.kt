package org.phenoapps.interfaces.security

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission

/**
 * https://developer.android.com/guide/topics/connectivity/bluetooth/permissions
 */
interface SecureBluetooth: SecureFragmentInterface {
    fun withAdapter(function: (adapter: BluetoothAdapter) -> Unit)
    fun connectWith(function: (device: Set<BluetoothDevice>) -> Unit)
    fun discoverWith(function: (adapter: BluetoothAdapter) -> Unit)
    fun discoverWithBackground(function: (adapter: BluetoothAdapter) -> Unit)
    fun advertiseWith(function: (adapter: BluetoothAdapter) -> Unit)
    fun withNearby(function: (adapter: BluetoothAdapter) -> Unit)
}