package org.phenoapps.security

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.phenoapps.annotations.Experimental
import org.phenoapps.interfaces.security.SecureBluetooth
import org.phenoapps.interfaces.security.SecureLocation

@Experimental
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
class SecureBluetoothActivityImpl(private val act: FragmentActivity): SecureBluetooth, SecureLocation {

    companion object {

        //never set this to 0 or else device will always be discoverable
        private const val DISCOVERABLE_SECONDS = 300

        fun discoverIntent() = Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE).apply {
            putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, DISCOVERABLE_SECONDS)
        }
    }

    private val advisor by Security().secureActivity(act)

    private val mBluetoothManager: BluetoothManager? by lazy {
        act.getBluetoothService()
    }

    private fun Context.getBluetoothService() =
        getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

    override fun withAdapter(function: (adapter: BluetoothAdapter) -> Unit) {

        mBluetoothManager?.let { manager ->

            function(manager.adapter)

        }
    }

    /**
     * Implements required permissions to communicate with already paired bluetooth devices.
     */
    override fun connectWith(function: (device: Set<BluetoothDevice>) -> Unit) = withAdapter { adapter ->

        //communicating with devices on API >= 12 requires connect runtime permisssions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {

            withPermission(arrayOf(
                Manifest.permission.BLUETOOTH_CONNECT)) {

                function(adapter.bondedDevices)
            }

        } else { //android 11 and lower requires BLUETOOTH and FINE/COARSE location

            withPermission(arrayOf(
                Manifest.permission.BLUETOOTH,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION)) {

                function(adapter.bondedDevices)
            }
        }
    }

    /**
     * Calls the defined callback with the bluetooth adapter after checking runtime permissions.
     */
    override fun discoverWith(function: (adapter: BluetoothAdapter) -> Unit) = withAdapter { adapter ->

        //discovering new devices on API >= 12 requires SCAN permissions runtime check
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {

            withPermission(arrayOf(
                Manifest.permission.BLUETOOTH_SCAN)) {

                function(adapter)
            }

        } else { //android 11 and lower requires BLUETOOTH ADMIN

            withPermission(arrayOf(
                Manifest.permission.BLUETOOTH_ADMIN)) {

                function(adapter)
            }
        }
    }

    /**
     * Function that only applies to Android 10/11
     * Documentation is not very clear on this but it should be used if discovering devices
     * with a background service.
     */
    override fun discoverWithBackground(function: (adapter: BluetoothAdapter) -> Unit) = withAdapter { adapter ->

        //discovering new devices on API >= 12 requires SCAN permissions runtime check
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

            withPermission(arrayOf(
                Manifest.permission.ACCESS_BACKGROUND_LOCATION)) {

                function(adapter)
            }
        }
    }

    /**
     * To make the device discoverable use this function
     */
    override fun advertiseWith(function: (adapter: BluetoothAdapter) -> Unit) = withAdapter { adapter ->

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {

            withPermission(arrayOf(Manifest.permission.BLUETOOTH_ADVERTISE)) {

                function(adapter)
            }

        } else function(adapter)
    }

    /**
     * Grants all permissions for connecting/advertising/discovering.
     */
    override fun withNearby(function: (adapter: BluetoothAdapter) -> Unit) = withLocation {

        connectWith {

            discoverWith {

                advertiseWith { adapter ->

                    function(adapter)
                }
            }
        }
    }

    override fun initialize() {
        advisor.initialize()
    }

    override fun withPermission(permissions: Array<String>, onResult: () -> Unit) {
        advisor.withPermission(permissions, onResult)
    }

    override fun withLocation(onResult: () -> Unit) {

        withPermission(arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION)) {

           onResult()
        }
    }
}