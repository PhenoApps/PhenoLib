package org.phenoapps.receivers

import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BluetoothSignalReceiver(private val function: ((String?, Int) -> Unit)?) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {
        val action = intent.action
        if (BluetoothDevice.ACTION_FOUND == action) {
            val rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, Short.MIN_VALUE).toInt()
            val name = intent.getStringExtra(BluetoothDevice.EXTRA_NAME)
            function?.invoke(name, rssi)
        }
    }
}