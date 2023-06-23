package org.phenoapps.fragments.gopro

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGattCallback
import android.net.Network
import androidx.appcompat.app.AlertDialog

interface GoProController {

        //register/unregister receivers to find bluetooth devices
        fun registerReceivers()
        fun unregisterReceivers()

        //BLE connect and initialization
        //check that system bluetooth is enabled
        fun isBluetoothEnabled(adapter: BluetoothAdapter): Boolean
        //(Optional) create a list of available GoPro bluetooth devices found nearby
        //call onSelected(null) if dialog is ui medium is canceled
        fun scanForGoPros(activity: Activity, onSelected: (BluetoothDevice?) -> Unit) = Unit
        //connect to a GoPro bluetooth device
        fun connectToGoPro(device: BluetoothDevice, callback: BluetoothGattCallback)

        //http connect and initialization
        fun checkWifiEnabled(): Boolean
        //enabled wifi
        fun enableWifi(): Boolean

        //(Optional) await gopro AP to be available
        fun awaitGoProAp(ssid: String?, pass: String?, bssid: String, onConnected: (Network) -> Unit) = Unit
        //connect to GoPro wifi
        fun connectToGoProWifi(dialog: AlertDialog, ssid: String, password: String, bssid: String?, onConnected: (Network) -> Unit)

        //HTTP commands
        //stop stream
        fun stopStream()
        //start stream
        fun startStream()
        //start recording
        fun shutterOff()
        //query for media
        fun queryMedia(data: Map<String, String> = mapOf())
}