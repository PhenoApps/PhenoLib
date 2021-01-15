package org.phenoapps.androidlibrarybuilder.mstrdtl;

import org.phenoapps.mstrdtl.Items;
import org.phenoapps.mstrdtl.OnePaneAdapter;

/**
 * Uses:
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItemActivity
 */
class ChangeableOnePaneAdapter extends OnePaneAdapter
{
    ChangeableOnePaneAdapter(final Items items) { super(items); }

    @java.lang.Override protected java.lang.Class concreteItemActivityClass()
    { return org.phenoapps.androidlibrarybuilder.mstrdtl.ChangeableItemActivity.class; }
}