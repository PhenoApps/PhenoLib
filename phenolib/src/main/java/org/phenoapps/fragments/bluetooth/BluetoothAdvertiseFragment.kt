package org.phenoapps.fragments.bluetooth

import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.size
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.delay
import org.phenoapps.adapters.bluetooth.BluetoothDeviceAdapter
import org.phenoapps.androidlibrary.R
import org.phenoapps.interfaces.security.OnClickListItem
import org.phenoapps.models.bluetooth.BluetoothDeviceModel

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class BluetoothAdvertiseFragment(override val pager: ViewPager2? = null): BluetoothListFragment(pager) {

    companion object {
        const val LIVE_DATA_DELAY_MS = 2000L
    }

    private var mSignalMap = hashMapOf<String, Int>()
    private var mDeviceSet = hashSetOf<BluetoothDeviceModel>()

    private val mScanCallback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult?) {
            super.onScanResult(callbackType, result)

            result?.device?.let { d ->

                if (d.address !in mDeviceSet.map { it.device.address }) {

                    //Toast.makeText(context, "Found new device: ${d.address}.", Toast.LENGTH_SHORT).show()

                    mDeviceSet.add(BluetoothDeviceModel(d))
                }
            }
        }
    }

    override fun onRecyclerReady() {

        liveDeviceData().observe(viewLifecycleOwner) { devices ->

            (mRecyclerView.adapter as? BluetoothDeviceAdapter)
                ?.submitList(devices.toList())

        }
    }

    override fun onReceiveSignal(name: String?, rssi: Int) {

        name?.let { device ->

            mSignalMap[device] = rssi

        }
    }

    private fun mergeDeviceInfo() {
        mDeviceSet.forEach { model ->
            val name = model.device.name
            if (name in mSignalMap.keys) {
                model.rssi = mSignalMap[name]
            }
        }
    }

    private fun liveDeviceData() = liveData<Set<BluetoothDeviceModel>> {

        while (true) {

            delay(LIVE_DATA_DELAY_MS)

            mergeDeviceInfo()

            emit(mDeviceSet)

        }
    }

    fun startAdvertise() = advisor.withNearby { adapter ->

        adapter.startDiscovery()

        adapter.bluetoothLeScanner.startScan(mScanCallback)
    }

    fun stopAdvertise() = advisor.withNearby { adapter ->

        adapter.cancelDiscovery()

        adapter.bluetoothLeScanner.stopScan(mScanCallback)

    }

    override fun onItemClicked(model: Any) {

        if (model is BluetoothDeviceModel) {

            Toast.makeText(context, model.toString(), Toast.LENGTH_SHORT).show()

            mPrefs.edit().putString(mKeys.argBluetoothDeviceAddress, model.device.address).apply()

            pager?.let { viewPager ->
                if (viewPager.currentItem < (viewPager.adapter?.itemCount ?: 0) - 1) {
                    viewPager.currentItem = viewPager.currentItem + 1
                }
            }
        }
    }
}