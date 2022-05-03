package org.phenoapps.adapters

import android.bluetooth.BluetoothDevice
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.phenoapps.androidlibrary.R

/**
 * Reference:
 * https://developer.android.com/guide/topics/ui/layout/recyclerview
 */
class BluetoothDeviceAdapter(private val dataSet: Array<BluetoothDevice>,
    private val bondedString: String = "Bonded",
    private val bondingString: String = "Bonding",
    private val notBondedString: String = "Not Bonded") :
        RecyclerView.Adapter<BluetoothDeviceAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.list_item_bluetooth_device_name_tv)
        val addressTextView: TextView = view.findViewById(R.id.list_item_bluetooth_device_address_tv)
        val stateTextView: TextView = view.findViewById(R.id.list_item_bluetooth_device_state_tv)

        init {
            // Define click listener for the ViewHolder's View.
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
        viewHolder.addressTextView.text = dataSet[position].address
        viewHolder.nameTextView.text = dataSet[position].name
        viewHolder.stateTextView.text = when (dataSet[position].bondState) {
            BluetoothDevice.BOND_BONDED -> bondedString
            BluetoothDevice.BOND_BONDING -> bondingString
            BluetoothDevice.BOND_NONE -> notBondedString
            else -> "NA"
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}