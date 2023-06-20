package org.phenoapps.fragments.bluetooth

import android.app.AlertDialog
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.*
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import androidx.preference.R
import org.phenoapps.receivers.BluetoothSignalReceiver
import org.phenoapps.security.Security
import org.phenoapps.utils.KeyUtil

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
abstract class BluetoothFragment(layoutId: Int): Fragment(layoutId) {

    protected val advisor by Security().secureBluetooth()

    protected val mPrefs: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(requireContext())
    }

    protected val mKeys by lazy { KeyUtil(context) }

    init {
        advisor.initialize()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        advisor.withAdapter { adapter ->
            if (!adapter.isEnabled) context.startActivity(
                Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.registerReceiver(BluetoothSignalReceiver(::onReceiveSignal),
            IntentFilter(BluetoothDevice.ACTION_FOUND))
    }

    open fun onReceiveSignal(name: String?, rssi: Int) = Unit
}