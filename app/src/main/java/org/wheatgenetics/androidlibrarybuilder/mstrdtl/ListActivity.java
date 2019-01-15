package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

/**
 * Uses:
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.BaseListActivity
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.OnePaneAdapter
 */
public class ListActivity extends org.wheatgenetics.androidlibrarybuilder.mstrdtl.BaseListActivity
{
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    { return new org.wheatgenetics.androidlibrarybuilder.mstrdtl.OnePaneAdapter(this.items()); }
}