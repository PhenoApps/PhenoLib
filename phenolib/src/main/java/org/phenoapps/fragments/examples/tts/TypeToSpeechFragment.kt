package org.phenoapps.fragments.examples.tts

import android.widget.Button
import android.widget.EditText
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.androidlibrary.R
import org.phenoapps.fragments.tts.TextToSpeechFragment
import org.phenoapps.utils.TextToSpeechHelper

/**
 * Example fragment that lets user type text to speech.
 */
class TypeToSpeechFragment(pager: ViewPager2? = null): TextToSpeechFragment(R.layout.fragment_tts_test) {

    override fun onTtsReady() {

        mPrefs.getInt(mKeys.argTtsLocale, -1).also { lang ->

            TextToSpeechHelper.availableLocales.first { it.hashCode() == lang.hashCode() }?.let { locale ->

                tts?.setLanguage(locale)

            }
        }

        setup()
    }

    private fun setup() {

        val textView = view?.findViewById<EditText>(R.id.frag_tts_test_et)
        val button = view?.findViewById<Button>(R.id.frag_tts_test_btn)

        button?.setOnClickListener {

            val text = textView?.text.toString()

            if (text.isNotBlank()) {

                tts?.speak(text)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        onTtsReady()
    }
}