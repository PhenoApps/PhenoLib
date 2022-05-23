package org.phenoapps.adapters.bluetooth.gatt

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
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
import org.phenoapps.models.bluetooth.gatt.BluetoothGattCharacteristicModel
import org.phenoapps.models.bluetooth.gatt.BluetoothGattModel
import java.util.*

/**
 * Reference:
 * https://developer.android.com/guide/topics/ui/layout/recyclerview
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class CharacteristicAdapter(private val listener: OnClickListItem):
        ListAdapter<BluetoothGattCharacteristicModel, CharacteristicAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val uuidTextView: TextView = view.findViewById(R.id.list_item_char_uuid_tv)
        val valueTv: TextView = view.findViewById(R.id.list_item_char_value_tv)
        val readableTv: TextView = view.findViewById(R.id.list_item_char_readable_tv)
        val writableTv: TextView = view.findViewById(R.id.list_item_char_writable_tv)
        val writeNoRespTv: TextView = view.findViewById(R.id.list_item_char_write_no_response_tv)
        val notifiableTv: TextView = view.findViewById(R.id.list_item_char_notifiable_tv)
        val indicatableTv: TextView = view.findViewById(R.id.list_item_char_indicatable_tv)

        init {
            // Define click listener for the ViewHolder's View.
            view.setOnClickListener {
                listener.onItemClicked(view.tag as BluetoothGattCharacteristicModel)
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item_characteristic, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        with (currentList[position]) {

                this.characteristic.value?.let { v ->
                    viewHolder.valueTv.text = String(v)
                }

                viewHolder.uuidTextView.text = when (val id = this.characteristic.uuid.toString()) {

                //Goya Attribute Service Chars
                "00002a05-0000-1000-8000-00805f9b34fb" -> "Goya Service Changed"

                //Goya Access Service Chars
                "00002a00-0000-1000-8000-00805f9b34fb" -> "Goya Device Name"
                "00002a01-0000-1000-8000-00805f9b34fb" -> "Goya Appearance"
                "00002a04-0000-1000-8000-00805f9b34fb" -> {

                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.toHexString()
                    }

                    "Goya Lab Device"
                }

                //Goya Sample Service Chars
                "d973f3e1-b19e-11e2-9e96-0800200c9a66" -> "Transmit"
                "d973f3e2-b19e-11e2-9e96-0800200c9a66" -> "Receive"

                //Goya Sensor Service Chars
                "d973f1e1-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "Row Start"
                }
                "d973f1e2-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "Col Start"
                }
                "d973f1e3-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "Row Size"
                }
                "d973f1e4-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "Col Size"
                }
                "d973f1e5-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "Horizontal Blank"
                }
                "d973f1e6-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "Vertical Blank"
                }
                "d973f1e7-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "Shutter Width"
                }
                "d973f1e8-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "Global Gain"
                }
                "d973f1e9-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "Cal Threshold"
                }
                "d973f1ea-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "Cal Control"
                }
                "d973f1eb-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "Unused"
                }
                "d973f1ec-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "Temp Cam"
                }
                "d973f1ed-b19e-11e2-9e96-0800200c9a66" -> {
                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = version.fromTwoOctet().toString()
                    }
                    "V. Battery"
                }

                //Goya Control Service Chars
                "d973f2e1-b19e-11e2-9e96-0800200c9a66" -> "Control Transmit"
                "d973f2e2-b19e-11e2-9e96-0800200c9a66" -> "Control Receive"

                //Goya System Service Chars
                "d973f4e0-b19e-11e2-9e96-0800200c9a66" -> "Sensor System Service"
                "d973f4e1-b19e-11e2-9e96-0800200c9a66" -> {

                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = String(version)
                    }

                    "Firmware Version"
                }
                "d973f4e2-b19e-11e2-9e96-0800200c9a66" -> {

                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = String(version)
                    }

                    "Hardware Version"
                }
                "d973f4e3-b19e-11e2-9e96-0800200c9a66" -> {

                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = String(version)
                    }

                    "Serial Number"
                }
                "d973f4e4-b19e-11e2-9e96-0800200c9a66" -> {

                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = String(version)
                    }

                    "IndiGo Header"
                }
                "d973f4e5-b19e-11e2-9e96-0800200c9a66" -> {

                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = String(version)
                    }

                    "Lambda 1"
                }
                "d973f4e6-b19e-11e2-9e96-0800200c9a66" -> {

                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = String(version)
                    }

                    "Lambda 2"
                }
                "d973f4e7-b19e-11e2-9e96-0800200c9a66" -> {

                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = String(version)
                    }

                    "Lambda 3"
                }
                "d973f4e8-b19e-11e2-9e96-0800200c9a66" -> {

                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = String(version)
                    }

                    "Lambda 4"
                }
                "d973f4e9-b19e-11e2-9e96-0800200c9a66" -> {

                    this.characteristic.value?.let { version ->
                        viewHolder.valueTv.text = String(version)
                    }

                    "Custom data"
                }

                else -> id
            }

            viewHolder.writableTv.visibility = if (this.characteristic.isWritable()) View.VISIBLE else View.GONE
            viewHolder.readableTv.visibility = if (this.characteristic.isReadable()) View.VISIBLE else View.GONE
            viewHolder.writeNoRespTv.visibility = if (this.characteristic.isWritableWithoutResponse()) View.VISIBLE else View.GONE
            viewHolder.notifiableTv.visibility = if (this.characteristic.isNotifiable()) View.VISIBLE else View.GONE
            viewHolder.indicatableTv.visibility = if (this.characteristic.isIndicatable()) View.VISIBLE else View.GONE
            viewHolder.itemView.tag = this
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = currentList.size

    fun BluetoothGattCharacteristic.isIndicatable(): Boolean =
        containsProperty(BluetoothGattCharacteristic.PROPERTY_INDICATE)

    fun BluetoothGattCharacteristic.isNotifiable(): Boolean =
        containsProperty(BluetoothGattCharacteristic.PROPERTY_NOTIFY)

    fun BluetoothGattCharacteristic.isReadable(): Boolean =
        containsProperty(BluetoothGattCharacteristic.PROPERTY_READ)

    fun BluetoothGattCharacteristic.isWritable(): Boolean =
        containsProperty(BluetoothGattCharacteristic.PROPERTY_WRITE)

    fun BluetoothGattCharacteristic.isWritableWithoutResponse(): Boolean =
        containsProperty(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE)

    fun BluetoothGattCharacteristic.containsProperty(property: Int): Boolean {
        return properties and property != 0
    }

    private fun readBatteryLevel(gatt: BluetoothGatt) {
        val batteryServiceUuid = UUID.fromString("d973f1e0-b19e-11e2-9e96-0800200c9a66")
        val batteryLevelCharUuid = UUID.fromString("d973f1ed-b19e-11e2-9e96-0800200c9a66")
        val batteryLevelChar = gatt.getService(batteryServiceUuid)?.let { battery ->
            battery.getCharacteristic(batteryLevelCharUuid)
        }
        if (batteryLevelChar?.isReadable() == true) {
            gatt.readCharacteristic(batteryLevelChar)
        }
    }

    fun ByteArray.fromTwoOctet() =
        ((this[0].toUInt() and 0xFFu)) or ((this[1].toUInt() and 0xFFu) shl 8)

    fun ByteArray.toHexString(): String =
        joinToString(separator = " ", prefix = "0x") { String.format("%02X", it) }

    class DiffCallback : DiffUtil.ItemCallback<BluetoothGattCharacteristicModel>() {

        override fun areItemsTheSame(oldItem: BluetoothGattCharacteristicModel, newItem: BluetoothGattCharacteristicModel): Boolean {
            return oldItem.characteristic.uuid == newItem.characteristic.uuid
        }

        override fun areContentsTheSame(oldItem: BluetoothGattCharacteristicModel, newItem: BluetoothGattCharacteristicModel): Boolean {
            return oldItem.characteristic.uuid == newItem.characteristic.uuid
        }
    }
}