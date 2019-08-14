package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

/**
 * Uses:
 * android.support.annotation.IntRange
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.TestItems
 */
abstract class BaseListActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
{
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected org.wheatgenetics.javalib.mstrdtl.Items items()
    { return org.wheatgenetics.androidlibrarybuilder.mstrdtl.TestItems.TEST_ITEMS(); }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter Overridden Methods
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