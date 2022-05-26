package org.phenoapps.fragments.bluetooth.gatt

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.adapters.bluetooth.gatt.CharacteristicAdapter
import org.phenoapps.fragments.bluetooth.BluetoothListFragment
import org.phenoapps.models.bluetooth.gatt.BluetoothGattCharacteristicModel
import org.phenoapps.viewmodels.bluetooth.gatt.GattViewModel
import java.util.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class CharacteristicListFragment(override val pager: ViewPager2? = null):
    BluetoothListFragment(pager) {

    private val viewModel by activityViewModels<GattViewModel>()

    override fun onPause() {
        super.onPause()
        viewModel.resetContext()
    }

    override fun onDefineAdapter() {
        mRecyclerView.adapter = CharacteristicAdapter(this)
    }

    override fun onRecyclerReady() {

        val serviceAddress = mPrefs.getString(mKeys.argBluetoothServiceAddress, null)

        if (serviceAddress == null) findNavController().popBackStack()
        else {

            val id = UUID.randomUUID().toString()
            viewModel.characteristics(serviceAddress).observe(viewLifecycleOwner) { chars ->

                chars.forEach(viewModel::read)

                Log.d("Gatt", "Loading char $id")

                (mRecyclerView.adapter as? CharacteristicAdapter)
                    ?.submitList(chars.sortedBy { it.characteristic.uuid.toString() })

                (mRecyclerView.adapter as? CharacteristicAdapter)
                    ?.notifyItemRangeChanged(0, chars.size)

            }
        }
    }

    override fun onItemClicked(model: Any) {

        if (model is BluetoothGattCharacteristicModel) {

            Log.d("Gatt", "Characteristic: ${model.characteristic.uuid}")
        }
    }
}