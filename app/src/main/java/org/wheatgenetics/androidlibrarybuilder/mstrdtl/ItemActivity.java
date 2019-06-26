package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

/**
 * Uses:
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.BaseItemActivity
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ListActivity
 */
public class ItemActivity extends org.wheatgenetics.androidlibrarybuilder.mstrdtl.BaseItemActivity
{
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.androidlibrarybuilder.mstrdtl.ListActivity.class; }
}