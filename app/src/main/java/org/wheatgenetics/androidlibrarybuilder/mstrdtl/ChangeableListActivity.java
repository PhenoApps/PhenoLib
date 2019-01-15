package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

/**
 * Uses:
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.BaseListActivity
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableOnePaneAdapter
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.Item
 */
public class ChangeableListActivity
extends    org.wheatgenetics.androidlibrarybuilder.mstrdtl.BaseListActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
{
    private org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog           // lazy
        changeItemAlertDialogInstance = null;                                               //  load

    private org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog
    changeItemAlertDialog()
    {
        if (null == this.changeItemAlertDialogInstance) this.changeItemAlertDialogInstance =
            new org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog(this,
                new org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog.Handler()
                {
                    @java.lang.Override public void handleChangeItemDone()
                    {
                        org.wheatgenetics.androidlibrarybuilder.mstrdtl
                            .ChangeableListActivity.this.refreshSinceItemHasChanged();
                    }
                });
        return this.changeItemAlertDialogInstance;
    }

    // region Overridden Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    {
        return new org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableOnePaneAdapter(
            this.items());
    }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Method
    @java.lang.Override public void change(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.changeItemAlertDialog().show(
            (org.wheatgenetics.androidlibrarybuilder.mstrdtl.Item) item);
    }
    // endregion
    // endregion
}