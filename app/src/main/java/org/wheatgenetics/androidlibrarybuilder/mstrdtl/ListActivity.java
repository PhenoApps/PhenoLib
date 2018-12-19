package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

/**
 * Uses:
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.Items
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.OnePaneAdapter
 */
public class ListActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
{
    // region Overridden Methods
    @java.lang.Override protected org.wheatgenetics.javalib.mstrdtl.Items items()
    { return org.wheatgenetics.androidlibrarybuilder.mstrdtl.Items.ITEMS(); }

    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    { return new org.wheatgenetics.androidlibrarybuilder.mstrdtl.OnePaneAdapter(this.items()); }
    // endregion
}