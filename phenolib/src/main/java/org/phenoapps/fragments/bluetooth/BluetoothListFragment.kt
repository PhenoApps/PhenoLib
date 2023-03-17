package org.phenoapps.fragments.bluetooth

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.adapters.bluetooth.BluetoothDeviceAdapter
import org.phenoapps.androidlibrary.R
import org.phenoapps.interfaces.security.OnClickListItem
import org.phenoapps.models.bluetooth.BluetoothDeviceModel

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
open class BluetoothListFragment(open val pager: ViewPager2? = null):
    BluetoothFragment(R.layout.fragment_recycler_list), OnClickListItem {

    protected lateinit var mRecyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRecyclerView = view.findViewById(R.id.frag_rv)

        mRecyclerView.layoutManager = LinearLayoutManager(context)

        onDefineAdapter()

    }

    override fun onResume() {
        super.onResume()

        onRecyclerReady()
    }

    open fun onDefineAdapter() {

        mRecyclerView.adapter = BluetoothDeviceAdapter(this)

    }

    open fun onRecyclerReady() {

        advisor.connectWith { devices ->

            //Toast.makeText(context, "Loading ${devices.size} devices...", Toast.LENGTH_SHORT).show()

            (mRecyclerView.adapter as? BluetoothDeviceAdapter)
                ?.submitList(devices.map { BluetoothDeviceModel(it) })

        }
    }

    override fun onReceiveSignal(name: String?, rssi: Int) = Unit

    override fun onItemClicked(model: Any) {
        if (model is BluetoothDeviceModel) {
            onItemClicked(model)
        }
    }

    open fun onItemClicked(model: BluetoothDeviceModel) {
        //Toast.makeText(context, model.toString(), Toast.LENGTH_SHORT).show()

        mPrefs.edit().putString(mKeys.argBluetoothDeviceAddress, model.device.address).apply()

        pager?.let { viewPager ->
            if (viewPager.currentItem < (viewPager.adapter?.itemCount ?: 0) - 1) {
                viewPager.currentItem = viewPager.currentItem + 1
            }
        }
    }
}