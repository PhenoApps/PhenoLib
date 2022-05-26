package org.phenoapps.fragments.examples.spectrometers

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.fragments.toolbar.ConnectionFragment

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class IndigoControlPage(pager: ViewPager2? = null): ConnectionFragment(pager) {

    override val containedFragment = IndigoControlFragment(pager)

    override val title = "IndiGo Control"

    override fun isConnected() = containedFragment.isConnected()

    override fun connect() = containedFragment.connect()

    override fun disconnect() = containedFragment.disconnect()

}
