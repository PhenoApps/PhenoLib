package org.phenoapps.fragments.examples

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.phenoapps.androidlibrary.R
import org.phenoapps.fragments.toolbar.IndexNavFragment
import org.phenoapps.fragments.toolbar.ToolbarsFragment

class PhenoLibIndexHomeFragment(
    override val navMenuId: Int = R.menu.menu_phenolib_index,
    override val selectedActionId: Int = R.id.index_home_action,
    override val navMap: Map<Int, NavDirections> =
        mapOf(R.id.index_preference_action to PhenoLibIndexHomeFragmentDirections
            .globalActionToPreferencesFragment())
) : IndexNavFragment() {

    override val containedFragment: Fragment = PhenoLibIndexHomeFragment()

    companion object class PhenoLibIndexHomeFragment: Fragment(R.layout.fragment_phenolib_index_home) {

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val bluetoothHardwareButton = view.findViewById<Button>(R.id.frag_main_hardware_bluetooth_btn)
            bluetoothHardwareButton.setOnClickListener {

                findNavController().navigate(PhenoLibIndexHomeFragmentDirections
                    .actionFromIndexToBluetoothHardwareFragment())
            }
        }
    }
}