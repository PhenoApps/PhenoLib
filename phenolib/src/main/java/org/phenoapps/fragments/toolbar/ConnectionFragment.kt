package org.phenoapps.fragments.toolbar

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.androidlibrary.R
import org.phenoapps.interfaces.iot.Device

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
abstract class ConnectionFragment(pager: ViewPager2? = null): PopOnBackToolbarFragment(pager) {

    companion object {
        const val TOOLBAR_REFRESH_RATE_MS = 1500L
    }

    override val isTopToolbarEnabled = true

    override val topToolbarMenuId = R.menu.spectrometer_connection_menu

    private val mConnectionHandlerThread = HandlerThread("connection check")

    private fun startTimer() {
        Handler(mConnectionHandlerThread.looper).postDelayed({

            activity?.runOnUiThread {

                if (isAdded) {

                    with(mTopToolbar) {

                        this?.menu?.findItem(R.id.action_connection)
                            ?.setIcon(
                                if (isConnected()) R.drawable.ic_vector_link
                                else R.drawable.ic_vector_difference_ab
                            )

                    }
                }
            }

            startTimer()

        }, TOOLBAR_REFRESH_RATE_MS)
    }

    private fun initiate() {

        if (!mConnectionHandlerThread.isAlive) {
            mConnectionHandlerThread.start()
            mConnectionHandlerThread.looper
        }

        startTimer()
    }

    open fun connect() {
        /* not implemented */
    }

    open fun disconnect() {
        /* not implemented */
    }

    open fun isConnected(): Boolean {
        return false
    }

    open fun onConnectionIconClicked() {
        if (isConnected()) {
            disconnect()
        } else connect()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTopToolbar?.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_connection -> {
                    onConnectionIconClicked()
                }
            }

            true
        }
    }

    override fun onResume() {
        super.onResume()

        initiate()
    }

    override fun onDestroy() {
        super.onDestroy()

        mConnectionHandlerThread.quit()

    }
}