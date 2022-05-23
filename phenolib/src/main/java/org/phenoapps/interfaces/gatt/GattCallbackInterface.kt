package org.phenoapps.interfaces.gatt

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor

interface GattCallbackInterface {

    fun onCharacteristicChanged(
        gatt: BluetoothGatt?,
        characteristic: BluetoothGattCharacteristic?) = Unit

    fun onCharacteristicRead(
        gatt: BluetoothGatt?,
        characteristic: BluetoothGattCharacteristic?,
        status: Int
    ) = Unit

    fun onCharacteristicWrite(
        gatt: BluetoothGatt?,
        characteristic: BluetoothGattCharacteristic?,
        status: Int
    ) = Unit

    fun onConnectionStateChange(
        gatt: BluetoothGatt?,
        status: Int,
        newState: Int) = Unit

    fun onDescriptorRead(
        gatt: BluetoothGatt?,
        descriptor: BluetoothGattDescriptor?,
        status: Int
    ) = Unit

    fun onDescriptorWrite(
        gatt: BluetoothGatt?,
        descriptor: BluetoothGattDescriptor?,
        status: Int
    ) = Unit

    fun onMtuChanged(gatt: BluetoothGatt?, mtu: Int, status: Int) = Unit
    fun onPhyRead(gatt: BluetoothGatt?, txPhy: Int, rxPhy: Int, status: Int) = Unit
    fun onPhyUpdate(gatt: BluetoothGatt?, txPhy: Int, rxPhy: Int, status: Int) = Unit
    fun onReadRemoteRssi(gatt: BluetoothGatt?, rssi: Int, status: Int) = Unit
    fun onReliableWriteCompleted(gatt: BluetoothGatt?, status: Int) = Unit
    fun onServiceChanged(gatt: BluetoothGatt) = Unit
    fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) = Unit
}