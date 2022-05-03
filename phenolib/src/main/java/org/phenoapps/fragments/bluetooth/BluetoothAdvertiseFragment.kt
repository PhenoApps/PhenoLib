package org.phenoapps.fragments.bluetooth

import android.bluetooth.BluetoothDevice
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.delay
import org.phenoapps.adapters.BluetoothDeviceAdapter
import org.phenoapps.androidlibrary.R
import org.phenoapps.security.Security

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class BluetoothAdvertiseFragment: Fragment(R.layout.fragment_bluetooth_devices_list) {

    companion object {
        const val LIVE_DATA_DELAY_MS = 2000L
    }

    private val advisor by Security().secureBluetooth()

    private lateinit var mRecyclerView: RecyclerView

    private var mDeviceSet = hashSetOf<BluetoothDevice>()

    init {
        advisor.initialize()
    }

    private val mScanCallback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult?) {
            super.onScanResult(callbackType, result)

            result?.device?.let { d ->

                if (d.address !in mDeviceSet.map { it.address }) {

                    Toast.makeText(context, "Found new device: ${d.address}.", Toast.LENGTH_SHORT).show()

                    mDeviceSet.add(d)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRecyclerView = view.findViewById(R.id.frag_bt_display_rv)

        mRecyclerView.layoutManager = LinearLayoutManager(context)

        liveDeviceData().observe(viewLifecycleOwner) { devices ->

            mRecyclerView.adapter = BluetoothDeviceAdapter(devices.toTypedArray())

        }
    }

    private fun liveDeviceData() = liveData<Set<BluetoothDevice>> {

        while (true) {

            delay(LIVE_DATA_DELAY_MS)

            emit(mDeviceSet)

        }
    }

    fun startAdvertise() = advisor.advertiseWith { adapter ->

        adapter.bluetoothLeScanner.startScan(mScanCallback)
    }


    fun stopAdvertise() = advisor.advertiseWith { adapter ->

        adapter.bluetoothLeScanner.stopScan(mScanCallback)
    }
}