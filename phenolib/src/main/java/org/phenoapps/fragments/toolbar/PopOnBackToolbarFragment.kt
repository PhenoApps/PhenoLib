package org.phenoapps.fragments.toolbar

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.androidlibrary.R

open class PopOnBackToolbarFragment(open val pager: ViewPager2? = null) : ToolbarsFragment() {

    protected var mTopToolbar: Toolbar? = null

    override val isTopToolbarEnabled = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTopToolbar = view.findViewById(R.id.frag_toolbars_tl)

        mTopToolbar?.setNavigationOnClickListener {

            if (onBackCheck()) {

                if (pager != null) {

                    if (pager!!.currentItem > 0) {

                        pager!!.currentItem = pager!!.currentItem - 1

                    } else findNavController().popBackStack()

                } else {

                    findNavController().popBackStack()

                }
            }
        }
    }

    open fun onBackCheck() = true
}