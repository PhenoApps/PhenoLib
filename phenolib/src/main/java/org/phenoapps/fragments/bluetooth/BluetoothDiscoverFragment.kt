package org.phenoapps.fragments.bluetooth

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import org.phenoapps.androidlibrary.R
import org.phenoapps.security.SecureBluetoothImpl
import org.phenoapps.security.Security

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
class BluetoothDiscoverFragment: Fragment(R.layout.fragment_bluetooth_discover) {

    private val advisor by Security().secureBluetooth()

    init {

        advisor.initialize()

    }

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->


    }

    fun startDiscovery() {

        advisor.discoverWith { adapter ->

            resultLauncher.launch(SecureBluetoothImpl.discoverIntent())

        }
    }

    fun stopDiscovery() {

        advisor.discoverWith { adapter ->

            adapter.cancelDiscovery()

        }
    }
}