package org.phenoapps.androidlibrarybuilder.mstrdtl;

import org.phenoapps.mstrdtl.Item;
import org.phenoapps.mstrdtl.Items;
import org.phenoapps.mstrdtl.OnePaneAdapter;
import org.phenoapps.mstrdtl.TestItem;
import org.phenoapps.mstrdtl.TestItems;

/**
 * Uses:
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.TestItem
 * org.wheatgenetics.javalib.mstrdtl.TestItems
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableOnePaneAdapter
 */
public class ChangeableListActivity
extends org.phenoapps.mstrdtl.ChangeableListActivity
{
    // region Fields
    private Items itemsInstance = null; // lazy load
    private org.phenoapps.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog
        changeItemAlertDialogInstance = null;                                           // lazy load
    // endregion

    private org.phenoapps.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog
    changeItemAlertDialog()
    {
        if (null == this.changeItemAlertDialogInstance) this.changeItemAlertDialogInstance =
            new org.phenoapps.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog(this,
                new org.phenoapps.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog.Handler()
                {
                    @java.lang.Override public void handleChangeItemDone()
                    {
                        org.phenoapps.androidlibrarybuilder.mstrdtl
                            .ChangeableListActivity.this.refreshSinceItemHasChanged();
                    }
                });
        return this.changeItemAlertDialogInstance;
    }

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
    protected OnePaneAdapter makeOnePaneAdapter()
    {
        return new org.phenoapps.androidlibrarybuilder.mstrdtl.ChangeableOnePaneAdapter(
            this.items());
    }

    @java.lang.Override public void change(
    @androidx.annotation.NonNull final Item item)
    { this.changeItemAlertDialog().show((TestItem) item); }
    // endregion
}