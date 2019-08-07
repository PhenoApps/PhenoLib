package org.wheatgenetics.androidlibrarybuilder.mstrdtl;

/**
 * Uses:
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.TestItem
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.BaseItemActivity
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableListActivity
 */
public class ChangeableItemActivity
extends    org.wheatgenetics.androidlibrarybuilder.mstrdtl.BaseItemActivity
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
                            .ChangeableItemActivity.this.refreshSinceItemHasChanged();
                    }
                });
        return this.changeItemAlertDialogInstance;
    }

    // region Overridden Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableListActivity.class; }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Method
    @java.lang.Override public void change(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    { this.changeItemAlertDialog().show((org.wheatgenetics.javalib.mstrdtl.TestItem) item); }
    // endregion
    // endregion
}