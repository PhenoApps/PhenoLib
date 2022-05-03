package org.phenoapps.fragments.preferences

import androidx.preference.PreferenceFragmentCompat
import android.os.Bundle
import android.view.View
import androidx.core.app.NavUtils
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import org.phenoapps.androidlibrary.R
import org.phenoapps.utils.KeyUtil

class PreferencesFragment : PreferenceFragmentCompat() {

    private val keys by lazy { KeyUtil(context) }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDefinerPreference()
    }

    private fun setupDefinerPreference() {

        with (findPreference<Preference>(keys.prefDefiner))  {
            this?.setOnPreferenceClickListener {
                findNavController().navigate(R.id.storage_definer_graph)

                true
            }
        }
    }
}