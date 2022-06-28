package org.phenoapps.fragments.tts

import android.content.SharedPreferences
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import org.phenoapps.utils.KeyUtil
import org.phenoapps.utils.TextToSpeechHelper

/**
 * Base class to extend that handles TTS initialization.
 */
open class TextToSpeechFragment(layoutId: Int): Fragment(layoutId) {

    protected var tts: TextToSpeechHelper? = null

    protected val mPrefs: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(context)
    }

    protected val mKeys by lazy {
        KeyUtil(context)
    }

    private val checkLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

        if (result.resultCode != TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {

            installLauncher.launch(TextToSpeechHelper.installTtsIntent)

        } else {

            setup()
        }
    }

    private val installLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        setup()

    }

    private fun initialize() {

        checkLauncher.launch(TextToSpeechHelper.checkTtsPresenceIntent)

    }

    private fun setup() {

        context?.let { ctx ->

            tts = TextToSpeechHelper(ctx) {

                onTtsReady()

            }
        }
    }

    open fun onTtsReady() { /* not implemented */ }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()

    }

    override fun onDestroy() {
        super.onDestroy()
        tts?.close()
    }
}