package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

/**
 * Uses:
 * android.support.annotation.IntRange
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.TestItems
 */
abstract class BaseItemActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper
{
    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper Overridden Methods
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    { return org.wheatgenetics.androidlibrarybuilder.mstrdtl.TestItems.TEST_ITEMS().get(position); }

    @java.lang.Override public void moveUp(@android.support.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        org.wheatgenetics.androidlibrarybuilder.mstrdtl.TestItems.TEST_ITEMS().moveUp(position);
        this.refreshSinceItemsHaveChanged();
    }

    @java.lang.Override public void moveDown(@android.support.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        org.wheatgenetics.androidlibrarybuilder.mstrdtl.TestItems.TEST_ITEMS().moveDown(position);
        this.refreshSinceItemsHaveChanged();
    }
    // endregion
}