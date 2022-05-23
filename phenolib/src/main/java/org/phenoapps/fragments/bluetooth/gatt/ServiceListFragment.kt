package org.phenoapps.fragments.bluetooth.gatt

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.adapters.bluetooth.gatt.GattServiceAdapter
import org.phenoapps.fragments.bluetooth.BluetoothListFragment
import org.phenoapps.models.bluetooth.gatt.BluetoothGattModel
import org.phenoapps.viewmodels.bluetooth.gatt.GattViewModel

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ServiceListFragment(override val pager: ViewPager2? = null): BluetoothListFragment(pager) {

    private val viewModel by activityViewModels<GattViewModel>()

    override fun onDefineAdapter() {
        mRecyclerView.adapter = GattServiceAdapter(this)
    }

    override fun onResume() {
        super.onResume()

        viewModel.clearServices()
    }

    override fun onRecyclerReady() {

        val deviceAddress = mPrefs.getString(mKeys.argBluetoothDeviceAddress, null)

        if (deviceAddress == null) findNavController().popBackStack()
        else {
            advisor.withNearby { adapter ->

                viewModel.register(adapter, requireContext(), deviceAddress)
            }
        }

        viewModel.services().observe(viewLifecycleOwner) { services ->

            (mRecyclerView.adapter as? GattServiceAdapter)
                ?.submitList(services.sortedBy { it.service.uuid.toString() })

            (mRecyclerView.adapter as? GattServiceAdapter)
                ?.notifyItemRangeChanged(0, services.size)

        }
    }

    override fun onItemClicked(model: Any) {

        if (model is BluetoothGattModel) {

            Log.d("Gatt", "Service : ${model.service.uuid}")
            model.service.characteristics.forEach {
                Log.d("Gatt", "Characteristic: ${it.uuid}")
            }

            mPrefs.edit().putString(mKeys.argBluetoothServiceAddress, model.service.uuid.toString()).apply()

            pager?.let { viewPager ->
                if (viewPager.currentItem < (viewPager.adapter?.itemCount ?: 0) - 1) {
                    viewPager.currentItem = viewPager.currentItem + 1
                }
            }
        }
    }
}