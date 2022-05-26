package org.phenoapps.fragments.examples.gatt

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.fragments.bluetooth.gatt.ServiceListFragment
import org.phenoapps.fragments.toolbar.PopOnBackToolbarFragment

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class GattServicePage(pager: ViewPager2? = null): PopOnBackToolbarFragment(pager) {

    override val containedFragment = ServiceListFragment(pager)

    override val title = "Service List"
}