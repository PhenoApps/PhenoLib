package org.phenoapps.fragments.examples

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.fragments.bluetooth.BluetoothListFragment
import org.phenoapps.fragments.toolbar.PopOnBackToolbarFragment

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class BluetoothDevicePage(override val pager: ViewPager2? = null): PopOnBackToolbarFragment(pager) {

    override val containedFragment = BluetoothListFragment(pager)

    override val isTopToolbarEnabled = true

    override val title = "Bluetooth Paired Devices"

}