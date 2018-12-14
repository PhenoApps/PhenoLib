package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

/**
 * Uses:
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.DummyItem
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class DummyItems extends java.lang.Object
implements org.wheatgenetics.javalib.mstrdtl.Items
{
    private java.util.List<org.wheatgenetics.androidlibrarybuilder.mstrdtl.DummyItem>
        dummyItems = null;                                                              // lazy load

    @android.support.annotation.NonNull @java.lang.SuppressWarnings({"Convert2Diamond"})
    private java.util.List<org.wheatgenetics.androidlibrarybuilder.mstrdtl.DummyItem> dummyItems()
    {
        if (null == this.dummyItems) this.dummyItems =
            new java.util.ArrayList<org.wheatgenetics.androidlibrarybuilder.mstrdtl.DummyItem>();
        return this.dummyItems;
    }

    // region Overridden Methods
    @java.lang.Override
    public void add(@android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    { this.dummyItems().add((org.wheatgenetics.androidlibrarybuilder.mstrdtl.DummyItem) item); }

    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
    @java.lang.Override public int size()
    { return null == this.dummyItems ? 0 : this.dummyItems.size(); }

    @android.support.annotation.Nullable @java.lang.Override
    public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        if (position < org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
            throw new java.lang.IllegalArgumentException(
                org.wheatgenetics.javalib.mstrdtl.Item.TOO_SMALL_POSITION_MESSAGE);
        return null == this.dummyItems ? null : this.dummyItems.get(position);
    }
    // endregion
}