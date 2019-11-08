package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

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
class ChangeableOnePaneAdapter extends org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
{
    ChangeableOnePaneAdapter(final org.wheatgenetics.javalib.mstrdtl.Items items) { super(items); }

    @java.lang.Override protected java.lang.Class concreteItemActivityClass()
    { return org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItemActivity.class; }
}