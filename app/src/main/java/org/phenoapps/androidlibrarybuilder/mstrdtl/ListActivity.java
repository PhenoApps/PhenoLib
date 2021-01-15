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
 * org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.OnePaneAdapter
 */
public class ListActivity extends org.phenoapps.mstrdtl.ListActivity
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
    @java.lang.Override
    protected org.phenoapps.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    { return new org.phenoapps.androidlibrarybuilder.mstrdtl.OnePaneAdapter(this.items()); }
    // endregion
}