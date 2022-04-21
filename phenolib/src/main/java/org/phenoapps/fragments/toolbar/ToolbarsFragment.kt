package org.phenoapps.fragments.toolbar

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.phenoapps.androidlibrary.R

open class ToolbarsFragment: Fragment(R.layout.fragment_toolbars) {

    open val containedFragment: Fragment? = null

    open val title: String? = null

    open val isTopToolbarEnabled = false

    open val isBottomToolbarEnabled = false

    open val topToolbarMenuId: Int? = null

    open val bottomToolbarMenuId: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        containedFragment?.let { frag ->
            childFragmentManager.beginTransaction()
                .replace(R.id.frag_toolbars_cv, frag)
                .commit()
        }

        setupTopToolbar(view)
        setupBottomToolbar(view)
    }

    private fun setupBottomToolbar(view: View) {

        val toolbar = view.findViewById<BottomNavigationView>(R.id.frag_toolbars_bl)

        if (isBottomToolbarEnabled) {

            bottomToolbarMenuId?.let { menuId ->

                toolbar.inflateMenu(menuId)

            }

            toolbar.visibility = View.VISIBLE

        } else {

            toolbar.visibility = View.GONE
        }
    }

    private fun setupTopToolbar(view: View) {

        val toolbar = view.findViewById<Toolbar>(R.id.frag_toolbars_tl)

        if (isTopToolbarEnabled) {

            topToolbarMenuId?.let { menuId ->

                toolbar.inflateMenu(menuId)

            }

            toolbar.visibility = View.VISIBLE

        } else {

            toolbar.visibility = View.GONE
        }

        title?.let { t ->

            toolbar.title = t

        }
    }
}