package org.phenoapps.fragments.examples.gatt

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.androidlibrary.R
import org.phenoapps.fragments.examples.BluetoothAdvertisePage

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class GattPagerFragment: Fragment(R.layout.fragment_pager) {

    private val pages = 3

    private var pager: ViewPager2? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pager = view.findViewById(R.id.frag_p2v)

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        pager?.adapter = pagerAdapter

    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fm: Fragment) : FragmentStateAdapter(fm) {

        override fun getItemCount(): Int {
            return pages
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> BluetoothAdvertisePage(pager)
                1 -> GattServicePage(pager)
                else -> GattCharacteristicPage(pager)
            }
        }
    }
}