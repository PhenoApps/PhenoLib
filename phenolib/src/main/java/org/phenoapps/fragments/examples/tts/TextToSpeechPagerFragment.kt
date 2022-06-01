package org.phenoapps.fragments.examples.tts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.androidlibrary.R
import org.phenoapps.fragments.tts.LocaleListFragment

/**
 * Pager example for choosing a locale and testing TTS type-to-speech
 */
class TextToSpeechPagerFragment: Fragment(R.layout.fragment_pager) {

    private val pages = 2

    private var pager: ViewPager2? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pager = view.findViewById(R.id.frag_p2v)

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        pager?.adapter = pagerAdapter

    }

    private inner class ScreenSlidePagerAdapter(fm: Fragment) : FragmentStateAdapter(fm) {

        override fun getItemCount(): Int {
            return pages
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> LocaleListFragment(pager)
                else -> TypeToSpeechFragment(pager)
            }
        }
    }
}