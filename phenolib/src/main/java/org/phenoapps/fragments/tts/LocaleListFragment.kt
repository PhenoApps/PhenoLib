package org.phenoapps.fragments.tts

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.adapters.LocaleAdapter
import org.phenoapps.androidlibrary.R
import org.phenoapps.interfaces.security.OnClickListItem
import org.phenoapps.utils.TextToSpeechHelper
import java.util.*

/**
 * Recycler list of available TTS languages (EN, SP, IT, GE, FR)
 */
open class LocaleListFragment(open val pager: ViewPager2? = null):
    TextToSpeechFragment(R.layout.fragment_recycler_list), OnClickListItem {

    private lateinit var mRecyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRecyclerView = view.findViewById(R.id.frag_rv)

        mRecyclerView.layoutManager = LinearLayoutManager(context)

        onDefineAdapter()

    }

    open fun onDefineAdapter() {

        mRecyclerView.adapter = LocaleAdapter(this)

    }

    override fun onTtsReady() {

        (mRecyclerView.adapter as? LocaleAdapter)
            ?.submitList(TextToSpeechHelper.availableLocales.toList())
    }

    override fun onItemClicked(model: Any) {
        if (model is Locale) {
            onItemClicked(model)
        }
    }

    open fun onItemClicked(model: Locale) {
        Toast.makeText(context, model.toString(), Toast.LENGTH_SHORT).show()

        mPrefs.edit().putInt(mKeys.argTtsLocale, model.hashCode()).apply()

        pager?.let { viewPager ->
            if (viewPager.currentItem < (viewPager.adapter?.itemCount ?: 0) - 1) {
                viewPager.currentItem = viewPager.currentItem + 1
            }
        }
    }
}