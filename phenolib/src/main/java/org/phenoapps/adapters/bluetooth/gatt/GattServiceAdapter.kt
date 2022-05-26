package org.phenoapps.adapters.bluetooth.gatt

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.phenoapps.androidlibrary.R
import org.phenoapps.interfaces.security.OnClickListItem
import org.phenoapps.models.bluetooth.gatt.BluetoothGattModel

/**
 * Reference:
 * https://developer.android.com/guide/topics/ui/layout/recyclerview
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class GattServiceAdapter(private val listener: OnClickListItem):
        ListAdapter<BluetoothGattModel, GattServiceAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.list_item_gatt_service_device_name_tv)
        val addressTextView: TextView = view.findViewById(R.id.list_item_gatt_service_uuid_tv)

        init {
            // Define click listener for the ViewHolder's View.
            view.setOnClickListener {
                listener.onItemClicked(view.tag as BluetoothGattModel)
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item_gatt_service, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        with (currentList[position]) {
            viewHolder.addressTextView.text = gatt.device.name
            viewHolder.nameTextView.text = when (val id = service.uuid.toString()) {
                "00001801-0000-1000-8000-00805f9b34fb" -> "Generic Goya Attribute Service"
                "00001800-0000-1000-8000-00805f9b34fb" -> "Generic Goya Access Service"
                "d973f1e0-b19e-11e2-9e96-0800200c9a66" -> "Goya Sensor Service"
                "d973f2e0-b19e-11e2-9e96-0800200c9a66" -> "Goya Sample Service"
                "d973f3e0-b19e-11e2-9e96-0800200c9a66" -> "Goya Control Service"
                "d973f4e0-b19e-11e2-9e96-0800200c9a66" -> "Goya System Service"
                else -> id
            }
            viewHolder.itemView.tag = this
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = currentList.size

    class DiffCallback : DiffUtil.ItemCallback<BluetoothGattModel>() {

        override fun areItemsTheSame(oldItem: BluetoothGattModel, newItem: BluetoothGattModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BluetoothGattModel, newItem: BluetoothGattModel): Boolean {
            return oldItem == newItem
        }
    }
}