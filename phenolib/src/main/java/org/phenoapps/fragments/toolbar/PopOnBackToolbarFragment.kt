package org.phenoapps.fragments.toolbar

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.androidlibrary.R

open class PopOnBackToolbarFragment(private val pager: ViewPager2? = null) : ToolbarsFragment() {

    override val isTopToolbarEnabled = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.frag_toolbars_tl)

        toolbar.setNavigationOnClickListener {

            if (onBackCheck()) {

                if (pager != null) {

                    if (pager.currentItem > 0) {

                        pager.currentItem = pager.currentItem - 1

                    } else findNavController().popBackStack()

                } else {

                    findNavController().popBackStack()

                }
            }
        }
    }

    open fun onBackCheck() = true
}