package org.phenoapps.androidlibrarybuilder.mstrdtl;

import org.phenoapps.mstrdtl.Items;
import org.phenoapps.mstrdtl.TestItems;

/**
 * Uses:
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.TestItems
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ListActivity
 */
public class ItemActivity extends org.phenoapps.mstrdtl.ItemActivity
{
    private Items itemsInstance = null;               // lazy load

    // region Overridden Methods
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override @androidx.annotation.NonNull
    protected Items items()
    {
        if (null == this.itemsInstance) this.itemsInstance =
            new TestItems().fromJson(this.getJson());
        return this.itemsInstance;
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.phenoapps.androidlibrarybuilder.mstrdtl.ListActivity.class; }
    // endregion
}