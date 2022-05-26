package org.phenoapps.fragments.examples.gatt

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.fragments.bluetooth.gatt.CharacteristicListFragment
import org.phenoapps.fragments.toolbar.PopOnBackToolbarFragment

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class GattCharacteristicPage(pager: ViewPager2? = null): PopOnBackToolbarFragment(pager) {

    override val containedFragment = CharacteristicListFragment(pager)

    override val title = "Characteristic Page"
}