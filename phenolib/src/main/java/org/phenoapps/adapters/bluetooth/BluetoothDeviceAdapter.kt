package org.phenoapps.adapters.bluetooth

import android.bluetooth.BluetoothDevice
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.phenoapps.androidlibrary.R
import org.phenoapps.interfaces.security.OnClickListItem
import org.phenoapps.models.bluetooth.BluetoothDeviceModel

/**
 * Reference:
 * https://developer.android.com/guide/topics/ui/layout/recyclerview
 */
class BluetoothDeviceAdapter(private val listener: OnClickListItem,
    private val bondedString: String = "Bonded",
    private val bondingString: String = "Bonding",
    private val notBondedString: String = "Not Bonded") :
        ListAdapter<BluetoothDeviceModel, BluetoothDeviceAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.list_item_bluetooth_device_name_tv)
        val addressTextView: TextView = view.findViewById(R.id.list_item_bluetooth_device_address_tv)
        val stateTextView: TextView = view.findViewById(R.id.list_item_bluetooth_device_state_tv)
        val signalTextView: TextView = view.findViewById(R.id.list_item_bluetooth_device_signal_tv)

        init {
            // Define click listener for the ViewHolder's View.
            view.setOnClickListener {
                listener.onItemClicked(view.tag as BluetoothDeviceModel)
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item_bluetooth_device, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        with(currentList[position]) {
            viewHolder.addressTextView.text = device.address
            viewHolder.nameTextView.text = device.name
            viewHolder.stateTextView.text = when (device.bondState) {
                BluetoothDevice.BOND_BONDED -> bondedString
                BluetoothDevice.BOND_BONDING -> bondingString
                BluetoothDevice.BOND_NONE -> notBondedString
                else -> "NA"
            }
            if (rssi != null) {
                viewHolder.signalTextView.text = "$rssi dBm"
            }

            viewHolder.itemView.tag = this
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = currentList.size

    class DiffCallback : DiffUtil.ItemCallback<BluetoothDeviceModel>() {

        override fun areItemsTheSame(oldItem: BluetoothDeviceModel, newItem: BluetoothDeviceModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BluetoothDeviceModel, newItem: BluetoothDeviceModel): Boolean {
            return oldItem == newItem
        }
    }
}