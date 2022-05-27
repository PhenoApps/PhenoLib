package org.phenoapps.utils

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import org.phenoapps.androidlibrary.R
import org.phenoapps.interfaces.security.TestIntentUtil

class IntentUtil {

    companion object : TestIntentUtil {

        /**
         * Calls start activity on a given intent.
         */
        override fun startActivity(context: Context?, intent: Intent) {

            context?.let { ctx ->

                try {

                    ctx.startActivity(intent)

                } catch (e: Exception) {

                    e.printStackTrace()

                }
            }
        }

        /**
         * Starts a share file intent.
         * @param uri the uri to grant permission and share
         * @param subject displayed subject title
         * @param text displayed message during share
         */
        override fun shareFile(context: Context?, uri: Uri, subject: String?, text: String?) {

            startActivity(context, shareFileIntent(uri, subject, text))
        }

        /**
         * Starts a share file intent with a chooser.
         * @param uri the uri to grant permission and share
         * @param subject displayed subject title
         * @param text displayed message during share
         */
        override fun shareFileChooser(context: Context?, uri: Uri, title: String, subject: String?, text: String?) {

            startActivity(context, shareFileChooserIntent(uri, title, subject, text))
        }

        /**
         * Creates the share file chooser.
         */
        override fun shareFileChooserIntent(uri: Uri, title: String, subject: String?, text: String?): Intent =
            Intent.createChooser(shareFileIntent(uri, subject, text), title)

        /**
         * Similar to shareFile but returns the intent
         */
        override fun shareFileIntent(uri: Uri, subject: String?, text: String?) = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            subject?.let { putExtra(Intent.EXTRA_SUBJECT, it) }
            text?.let { putExtra(Intent.EXTRA_TEXT, it) }
            putExtra(Intent.EXTRA_STREAM, uri)
        }

        /**
         * Checks context's location providers for network or gps.
         * If neither are enabled, shows a dialog that will navigate the user to system location prefs.
         */
        override fun askSystemLocation(context: Context?) {

            context?.let { ctx ->

                var gps = false
                var net = false

                (ctx.getSystemService(Context.LOCATION_SERVICE) as? LocationManager)?.let { manager ->

                    try {

                        gps = manager.isProviderEnabled(LocationManager.GPS_PROVIDER)

                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    try {

                        net = manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    if (!(gps or net)) {

                        AlertDialog.Builder(ctx)
                            .setTitle(R.string.location_provider_not_enabled_title)
                            .setMessage(R.string.location_provider_not_enabled)
                            .setPositiveButton(android.R.string.ok) { _, _ ->
                                startActivity(ctx, Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                            }
                            .setNegativeButton(android.R.string.cancel) { _, _ -> }
                            .show()
                    }
                }
            }
        }

        /**
         * Checks context's location providers for network or gps.
         * If neither are enabled, shows a dialog that will navigate the user to system location prefs.
         */
        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
        override fun askSystemBluetooth(context: Context?) {

            context?.let { ctx ->

                (ctx.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager)?.let { manager ->

                    if (manager.adapter?.isEnabled != true) {

                        AlertDialog.Builder(ctx)
                            .setTitle(R.string.bluetooth_not_enabled_title)
                            .setMessage(R.string.bluetooth_not_enabled)
                            .setPositiveButton(android.R.string.ok) { _, _ ->
                                startActivity(ctx, Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE))
                            }
                            .setNegativeButton(android.R.string.cancel) { _, _ -> }
                            .show()
                    }
                }
            }
        }
    }
}