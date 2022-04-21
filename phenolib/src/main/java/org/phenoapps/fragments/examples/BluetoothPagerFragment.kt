package org.phenoapps.fragments.examples

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.androidlibrary.R

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class BluetoothPagerFragment: Fragment(R.layout.fragment_bluetooth_pager) {

    private val pages = 3

    private lateinit var mPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPager = view.findViewById(R.id.frag_bluetooth_p2v)

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        mPager.adapter = pagerAdapter

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
                0 -> BluetoothDevicePage(mPager)
                1 -> BluetoothAdvertisePage(mPager)
                else -> BluetoothDiscoverPage(mPager)
            }
        }
    }
}