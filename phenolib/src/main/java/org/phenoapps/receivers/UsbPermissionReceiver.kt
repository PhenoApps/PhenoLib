package org.phenoapps.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import android.util.Log

/**
 * Android Developers USB Permission receiver.
 * Added a function parameter to call after a message is received.
 */
class UsbPermissionReceiver(private val f: ((Boolean) -> Unit)? = null): BroadcastReceiver() {

    companion object {
        val TAG = "UsbBR"
        val ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION"
    }

    override fun onReceive(context: Context, intent: Intent) {

        if (ACTION_USB_PERMISSION == intent.action) {

            synchronized(this) {

                val device: UsbDevice? = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE)

                if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {

                    Log.d(TAG, "permission granted for device $device")

                    f?.invoke(true)

                } else {

                    f?.invoke(false)

                    Log.d(TAG, "permission denied for device $device")
                }
            }
        }
    }
}