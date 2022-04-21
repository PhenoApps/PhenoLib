package org.phenoapps.fragments.examples

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import org.phenoapps.androidlibrary.R
import org.phenoapps.fragments.toolbar.ToolbarsFragment

class MainPhenoLibFragment: ToolbarsFragment() {

    override val containedFragment = PhenoLibIndexFragment()

    override val isTopToolbarEnabled = true

    override val title = "PhenoLib Test App"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topToolbar = view.findViewById<Toolbar>(R.id.frag_toolbars_tl)
        topToolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }
}