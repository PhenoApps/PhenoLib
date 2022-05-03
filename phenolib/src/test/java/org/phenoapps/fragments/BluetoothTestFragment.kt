package org.phenoapps.fragments

import android.os.Bundle
import android.view.View
import org.phenoapps.androidlibrary.R

class BluetoothTestFragment: BluetoothFragment(R.layout.fragment_storage_definer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        withAdapter { adapter ->

            adapter.address
        }

        withDevices { devices ->

            devices.filter { it.address == "1111-222-4444" }
        }
    }
}