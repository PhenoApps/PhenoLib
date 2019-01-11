package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

/**
 * Uses:
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 * org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItem
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItems
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableOnePaneAdapter
 */
public class ChangeableListActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
{
    // region Overridden Methods
    @java.lang.Override protected org.wheatgenetics.javalib.mstrdtl.Items items()
    { return org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItems.ITEMS(); }

    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    {
        return new org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableOnePaneAdapter(
            this.items());
    }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Method
    @java.lang.Override
    public void change(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        ((org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItem) item).setContent(
            "changed in two-pane mode");
    }
    // endregion
    // endregion
}