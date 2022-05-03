package org.phenoapps.fragments.toolbar

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.phenoapps.androidlibrary.R
import org.phenoapps.fragments.toolbar.ToolbarsFragment

abstract class IndexNavFragment: ToolbarsFragment() {

    override val isBottomToolbarEnabled = true

    abstract val navMenuId: Int

    abstract val selectedActionId: Int

    abstract val navMap: Map<Int, NavDirections>

    private var bottomToolbar: BottomNavigationView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomToolbar = view.findViewById(R.id.frag_toolbars_bl)

        bottomToolbar?.inflateMenu(navMenuId)

        setupBottomToolbarNavigation()
    }

    private fun setupBottomToolbarNavigation() {

        bottomToolbar?.setOnItemSelectedListener(null)

        bottomToolbar?.selectedItemId = selectedActionId

        bottomToolbar?.setOnItemSelectedListener { item ->

            if (item.itemId in navMap.keys) {

                navMap[item.itemId]?.let { findNavController().navigate(it) }
            }

            true
        }
    }

    override fun onResume() {
        super.onResume()
        setupBottomToolbarNavigation()
    }
}