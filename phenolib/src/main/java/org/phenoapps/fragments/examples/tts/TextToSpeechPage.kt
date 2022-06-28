package org.phenoapps.fragments.examples.tts

import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.fragments.toolbar.PopOnBackToolbarFragment

class TextToSpeechPage(pager: ViewPager2? = null): PopOnBackToolbarFragment(pager) {

    override val containedFragment = TypeToSpeechFragment(pager)

    override val title = "Type To Speech"

}