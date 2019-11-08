package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * Uses:
 * android.app.Activity
 *
 * androidx.annotation.IntRange
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger
 */
public abstract class ChangeableItemActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger
{
    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger Overridden Methods
    @java.lang.Override public void moveUp(@androidx.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    { this.items().moveUp(position); this.refreshSinceItemsHaveChanged(); }

    @java.lang.Override public void moveDown(@androidx.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    { this.items().moveDown(position); this.refreshSinceItemsHaveChanged(); }

    @java.lang.Override public void delete(@androidx.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        this.items().delete(position);
        this.setResultFromJson(android.app.Activity.RESULT_FIRST_USER);
        this.finish();
    }
    // endregion
}