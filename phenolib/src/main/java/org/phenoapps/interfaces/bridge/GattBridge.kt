package org.phenoapps.interfaces.bridge

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import org.phenoapps.interfaces.gatt.GattCallbackInterface

/**
 * Delegate pattern for passing BluetoothGattCallback messages to an implementation of GattCallbackInterface.
 */
class GattBridge {

    companion object {

        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
        fun gattBridge(implementation: GattCallbackInterface) = object : BluetoothGattCallback() {

            override fun onCharacteristicChanged(
                gatt: BluetoothGatt?,
                characteristic: BluetoothGattCharacteristic?
            ) {
                super.onCharacteristicChanged(gatt, characteristic)
                //Log.d("Gatt", "Characteristic changed.")
                implementation.onCharacteristicChanged(gatt, characteristic)
            }

            override fun onCharacteristicRead(
                gatt: BluetoothGatt?,
                characteristic: BluetoothGattCharacteristic?,
                status: Int
            ) {
                super.onCharacteristicRead(gatt, characteristic, status)
                when (status) {
                    BluetoothGatt.GATT_SUCCESS -> {
                        //Log.d("Gatt", "Characteristic read success.")
                    }
                    BluetoothGatt.GATT_READ_NOT_PERMITTED -> {
                        //Log.d("Gatt", "Char read not permitted")
                    }
                    else -> {
                        //Log.d("Gatt", "Char read failed.")
                    }
                }
                implementation.onCharacteristicRead(gatt, characteristic, status)
            }

            override fun onCharacteristicWrite(
                gatt: BluetoothGatt?,
                characteristic: BluetoothGattCharacteristic?,
                status: Int
            ) {
                super.onCharacteristicWrite(gatt, characteristic, status)
                when (status) {
                    BluetoothGatt.GATT_SUCCESS -> {
                        //Log.d("Gatt", "Characteristic write success.")
                    }
                    BluetoothGatt.GATT_WRITE_NOT_PERMITTED -> {
                        //Log.d("Gatt", "Characteristic write not permitted.")
                    }
                    else -> {
                        //Log.d("Gatt", "Characteristic write failed.")
                    }
                }
                implementation.onCharacteristicWrite(gatt, characteristic, status)
            }

            override fun onConnectionStateChange(
                gatt: BluetoothGatt?,
                status: Int,
                newState: Int
            ) {
                super.onConnectionStateChange(gatt, status, newState)
                //Log.d("Gatt", "Connection state changed.")
                implementation.onConnectionStateChange(gatt, status, newState)
            }

            override fun onDescriptorRead(
                gatt: BluetoothGatt?,
                descriptor: BluetoothGattDescriptor?,
                status: Int
            ) {
                super.onDescriptorRead(gatt, descriptor, status)
                when (status) {
                    BluetoothGatt.GATT_SUCCESS -> {
                        //Log.d("Gatt", "Descriptor read success.")
                    }
                    BluetoothGatt.GATT_READ_NOT_PERMITTED -> {
                        //Log.d("Gatt", "Descriptor read not permitted.")
                    }
                    else -> {
                        //Log.d("Gatt", "Descriptor read failed.")
                    }
                }
                implementation.onDescriptorRead(gatt, descriptor, status)
            }

            override fun onDescriptorWrite(
                gatt: BluetoothGatt?,
                descriptor: BluetoothGattDescriptor?,
                status: Int
            ) {
                super.onDescriptorWrite(gatt, descriptor, status)
                when (status) {
                    BluetoothGatt.GATT_SUCCESS -> {
                        //Log.d("Gatt", "Descriptor write success.")
                    }
                    BluetoothGatt.GATT_WRITE_NOT_PERMITTED -> {
                        //Log.d("Gatt", "Descriptor write not permitted.")
                    }
                    else -> {
                        //Log.d("Gatt", "Descriptor write failed.")
                    }
                }
                implementation.onDescriptorWrite(gatt, descriptor, status)
            }

            override fun onMtuChanged(gatt: BluetoothGatt?, mtu: Int, status: Int) {
                super.onMtuChanged(gatt, mtu, status)
                //Log.d("Gatt", "Mtu changed.")
                implementation.onMtuChanged(gatt, mtu, status)
            }

            override fun onPhyRead(gatt: BluetoothGatt?, txPhy: Int, rxPhy: Int, status: Int) {
                super.onPhyRead(gatt, txPhy, rxPhy, status)
                //Log.d("Gatt", "Phy read.")
                implementation.onPhyRead(gatt, txPhy, rxPhy, status)
            }

            override fun onPhyUpdate(
                gatt: BluetoothGatt?,
                txPhy: Int,
                rxPhy: Int,
                status: Int
            ) {
                super.onPhyUpdate(gatt, txPhy, rxPhy, status)
               // Log.d("Gatt", "Phy updated.")
                implementation.onPhyUpdate(gatt, txPhy, rxPhy, status)
            }

            override fun onReadRemoteRssi(gatt: BluetoothGatt?, rssi: Int, status: Int) {
                super.onReadRemoteRssi(gatt, rssi, status)
                //Log.d("Gatt", "Remote rssi read.")
                implementation.onReadRemoteRssi(gatt, rssi, status)
            }

            override fun onReliableWriteCompleted(gatt: BluetoothGatt?, status: Int) {
                super.onReliableWriteCompleted(gatt, status)
                //Log.d("Gatt", "Reliable write completed.")
                implementation.onReliableWriteCompleted(gatt, status)
            }

            override fun onServiceChanged(gatt: BluetoothGatt) {
                super.onServiceChanged(gatt)
                //Log.d("Gatt", "Service changed.")
                implementation.onServiceChanged(gatt)
            }

            override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
                super.onServicesDiscovered(gatt, status)
                //Log.d("Gatt", "Service discovered.")
                implementation.onServicesDiscovered(gatt, status)
            }
        }
    }
}
