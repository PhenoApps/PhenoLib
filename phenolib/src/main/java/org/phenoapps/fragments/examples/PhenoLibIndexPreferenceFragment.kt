package org.phenoapps.fragments.examples

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import org.phenoapps.androidlibrary.R
import org.phenoapps.fragments.preferences.PreferencesFragment
import org.phenoapps.fragments.toolbar.IndexNavFragment

class PhenoLibIndexPreferenceFragment(
    override val navMenuId: Int = R.menu.menu_phenolib_index,
    override val selectedActionId: Int = R.id.index_preference_action,
    override val navMap: Map<Int, NavDirections> = mapOf(
        R.id.index_home_action to PhenoLibIndexHomeFragmentDirections
            .globalActionToHomeFragment()
    )
) : IndexNavFragment() {

    override val containedFragment: Fragment = PreferencesFragment()

}