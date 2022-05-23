package org.phenoapps.fragments.bluetooth

import android.bluetooth.BluetoothDevice
import android.content.IntentFilter
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import org.phenoapps.receivers.BluetoothSignalReceiver
import org.phenoapps.security.Security
import org.phenoapps.utils.KeyUtil

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
abstract class BluetoothFragment(layoutId: Int): Fragment(layoutId) {

    protected val advisor by Security().secureBluetooth()

    protected val mPrefs: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(context)
    }

    protected val mKeys by lazy { KeyUtil(context) }

    init {
        advisor.initialize()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.registerReceiver(BluetoothSignalReceiver(::onReceiveSignal),
            IntentFilter(BluetoothDevice.ACTION_FOUND))
    }

    open fun onReceiveSignal(name: String?, rssi: Int) = Unit
}