package org.phenoapps.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.phenoapps.androidlibrary.R
import org.phenoapps.interfaces.security.OnClickListItem
import java.util.*

/**
 * Reference:
 * https://developer.android.com/guide/topics/ui/layout/recyclerview
 */
class LocaleAdapter(private val listener: OnClickListItem) :
        ListAdapter<Locale, LocaleAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val languageTextView: TextView = view.findViewById(R.id.list_item_language_tv)

        init {
            // Define click listener for the ViewHolder's View.
            view.setOnClickListener {
                listener.onItemClicked(view.tag as Locale)
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item_locale, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        with(currentList[position]) {
            viewHolder.languageTextView.text = displayLanguage

            viewHolder.itemView.tag = this
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = currentList.size

    class DiffCallback : DiffUtil.ItemCallback<Locale>() {

        override fun areItemsTheSame(oldItem: Locale, newItem: Locale): Boolean {
            return oldItem.language == newItem.language && oldItem.country == oldItem.country
        }

        override fun areContentsTheSame(oldItem: Locale, newItem: Locale): Boolean {
            return oldItem.language == newItem.language && oldItem.country == oldItem.country
        }
    }
}