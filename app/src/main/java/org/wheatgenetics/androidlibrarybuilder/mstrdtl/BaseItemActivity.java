package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

/**
 * Uses:
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.TestItems
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 */
abstract class BaseItemActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
{
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance)
        {
            final org.wheatgenetics.javalib.mstrdtl.TestItems testItems =
                new org.wheatgenetics.javalib.mstrdtl.TestItems();
            this.itemsInstance = testItems.fromJson(this.getJson());
            if (null == this.itemsInstance) this.itemsInstance = testItems;
        }
        return this.itemsInstance;
    }
}