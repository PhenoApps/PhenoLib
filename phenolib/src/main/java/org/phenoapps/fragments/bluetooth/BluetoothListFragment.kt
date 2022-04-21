package org.phenoapps.fragments.bluetooth

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.phenoapps.adapters.BluetoothDeviceAdapter
import org.phenoapps.androidlibrary.R
import org.phenoapps.security.Security

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
class BluetoothListFragment: Fragment(R.layout.fragment_bluetooth_devices_list) {

    private val advisor by Security().secureBluetooth()

    private lateinit var mRecyclerView: RecyclerView

    init {
        advisor.initialize()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRecyclerView = view.findViewById(R.id.frag_bt_display_rv)

        mRecyclerView.layoutManager = LinearLayoutManager(context)

        advisor.connectWith { devices ->

            Toast.makeText(context, "Loading ${devices.size} devices...", Toast.LENGTH_SHORT).show()

            mRecyclerView.adapter = BluetoothDeviceAdapter(devices.toTypedArray())

        }
    }
}