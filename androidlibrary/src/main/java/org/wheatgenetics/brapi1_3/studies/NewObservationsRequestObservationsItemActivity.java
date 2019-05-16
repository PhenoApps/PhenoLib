package org.wheatgenetics.brapi1_3.studies;

/**
 * Uses:
 * android.app.Application
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 *
 * _io.swagger.client.model.NewObservationsRequestObservations
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.ItemsProvider
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 *
 * org.wheatgenetics.brapi1_3.studies.NewObservationsRequestListActivity
 * org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
 * org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog.Handler
 */
public class NewObservationsRequestObservationsItemActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
    private org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
        newObservationsRequestObservationsAlertDialogInstance = null;                   // lazy load
    // endregion

    private org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
    newObservationsRequestObservationsAlertDialog()
    {
        if (null == this.newObservationsRequestObservationsAlertDialogInstance)
            this.newObservationsRequestObservationsAlertDialogInstance = new
                org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog(
                    this, new org.wheatgenetics.brapi1_3.studies
                    .NewObservationsRequestObservationsAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.brapi1_3.studies
                                .NewObservationsRequestObservationsItemActivity
                                .this.refreshSinceItemHasChanged();
                        }
                    });
        return this.newObservationsRequestObservationsAlertDialogInstance;
    }

    // region Overridden Methods
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.brapi1_3.studies.NewObservationsRequestListActivity.class; }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Methods
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        if (null == this.itemsInstance)
        {
            final android.app.Application application = this.getApplication();
            if (application instanceof org.wheatgenetics.javalib.mstrdtl.ItemsProvider)
                this.itemsInstance =
                    ((org.wheatgenetics.javalib.mstrdtl.ItemsProvider) application).mstrdtlItems();
        }
        return null == this.itemsInstance ? null : this.itemsInstance.get(position);
    }

    @java.lang.Override public void change(
    @android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.newObservationsRequestObservationsAlertDialog().show(
            (io.swagger.client.model.NewObservationsRequestObservations) item);
    }
    // endregion
    // endregion
}