package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

/**
 * Uses:
 * android.support.annotation.IntRange
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.Items
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ListActivity
 */
public class ItemActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter
{
    // region Overridden Methods
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.androidlibrarybuilder.mstrdtl.ListActivity.class; }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter Overridden Method
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    { return org.wheatgenetics.androidlibrarybuilder.mstrdtl.Items.ITEMS().get(position); }
    // endregion
    // endregion
}