package org.phenoapps.fragments.examples

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.phenoapps.androidlibrary.R
import org.phenoapps.fragments.bluetooth.BluetoothDiscoverFragment
import org.phenoapps.fragments.toolbar.PopOnBackToolbarFragment

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
class BluetoothDiscoverPage(pager: ViewPager2?): PopOnBackToolbarFragment(pager) {

    override val containedFragment = BluetoothDiscoverFragment()

    override val title = "Bluetooth Discovery"

    override val isBottomToolbarEnabled = true

    override val bottomToolbarMenuId = R.menu.bluetooth_discover_menu

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomToolbar = view.findViewById<BottomNavigationView>(R.id.frag_toolbars_bl)

        bottomToolbar.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.bluetooth_discover_action_on -> {

                    containedFragment.startDiscovery()

                }

                else -> {

                    containedFragment.stopDiscovery()
                }
            }

            true
        }
    }
}