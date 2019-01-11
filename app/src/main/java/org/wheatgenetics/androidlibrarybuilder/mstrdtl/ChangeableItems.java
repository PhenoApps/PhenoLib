package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

/**
 * Uses:
 * _android.support.annotation.IntRange
 * _android.support.annotation.RestrictTo
 * _android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItem
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.Items
 */
class ChangeableItems extends org.wheatgenetics.androidlibrarybuilder.mstrdtl.Items
{
    private static org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItems          // lazy
        ITEMS_INSTANCE = null;                                                              //  load

    static org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItems ITEMS()
    {
        if (null == ITEMS_INSTANCE)
        {
            ITEMS_INSTANCE = new org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItems();

            final int
                MIN_POSITION =
                    org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItem.MIN_POSITION,
                MAX_POSITION =
                    org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItems.MAX_POSITION;
            for (int position = MIN_POSITION; position <= MAX_POSITION; position++)
                ITEMS_INSTANCE.add(
                    new org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableItem(position));
        }
        return ITEMS_INSTANCE;
    }
}