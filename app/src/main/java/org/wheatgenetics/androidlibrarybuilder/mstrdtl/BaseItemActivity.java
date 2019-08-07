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
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.TestItems
 */
abstract class BaseItemActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter
{
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    { return org.wheatgenetics.androidlibrarybuilder.mstrdtl.TestItems.TEST_ITEMS().get(position); }
}