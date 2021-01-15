package org.phenoapps.androidlibrarybuilder.mstrdtl;

import org.phenoapps.mstrdtl.Items;

/**
 * Uses:
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ItemActivity
 */
class OnePaneAdapter extends org.phenoapps.mstrdtl.OnePaneAdapter
{
    OnePaneAdapter(final Items items) { super(items); }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class concreteItemActivityClass()
    { return org.phenoapps.androidlibrarybuilder.mstrdtl.ItemActivity.class; }
}