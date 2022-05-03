package org.phenoapps.fragments.examples

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.fragments.bluetooth.BluetoothListFragment
import org.phenoapps.fragments.toolbar.PopOnBackToolbarFragment

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
class BluetoothDevicePage(pager: ViewPager2? = null): PopOnBackToolbarFragment(pager) {

    override val containedFragment = BluetoothListFragment()

    override val isTopToolbarEnabled = true

    override val title = "Bluetooth Paired Devices"

}