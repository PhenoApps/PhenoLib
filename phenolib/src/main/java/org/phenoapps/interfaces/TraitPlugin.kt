package org.phenoapps.interfaces

import android.view.View
import android.view.ViewGroup

interface TraitPlugin {
    /**
     * Creates a new instance of the custom view and adds it to the specified ViewGroup.
     * @param parent The ViewGroup where the custom view should be added.
     * @param width The width of the custom view.
     * @param height The height of the custom view.
     * @return The created custom view.
     */
    fun createCustomView(parent: ViewGroup?, width: Int, height: Int): View?

    /**
     * Sets the data to be displayed in the custom view.
     * @param view The custom view.
     * @param data The data to be displayed.
     */
    fun setCustomViewData(view: View?, data: String?)

    /**
     * Callback interface for handling events in the custom view.
     */
    interface CustomViewListener {
        /**
         * Called when the custom view is clicked.
         * @param view The custom view that was clicked.
         */
        fun onCustomViewClicked(view: View?)

        /**
         * Called when the custom view is long-clicked.
         * @param view The custom view that was long-clicked.
         */
        fun onCustomViewLongClicked(view: View?)
    }

    /**
     * Sets a listener to handle events in the custom view.
     * @param view The custom view.
     * @param listener The listener to handle events.
     */
    fun setCustomViewListener(view: View?, listener: CustomViewListener?)
}