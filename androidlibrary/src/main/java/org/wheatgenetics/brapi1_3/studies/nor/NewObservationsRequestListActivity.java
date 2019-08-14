package org.wheatgenetics.brapi1_3.studies.nor;                       // nor: NewObservationsRequest

/**
 * Uses:
 * android.app.Application
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.NewObservationsRequestObservations
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.ItemsProvider
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 * org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsAlertDialog
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsOnePaneAdapter
 */
public class NewObservationsRequestListActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
    private org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsAlertDialog
        newObservationsRequestObservationsAlertDialogInstance = null;                   // lazy load
    // endregion

    private org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsAlertDialog
    newObservationsRequestObservationsAlertDialog()
    {
        if (null == this.newObservationsRequestObservationsAlertDialogInstance)
            this.newObservationsRequestObservationsAlertDialogInstance = new org.wheatgenetics
                .brapi1_3.studies.nor.NewObservationsRequestObservationsAlertDialog(
                    this, new org.wheatgenetics.brapi1_3.studies.nor
                    .NewObservationsRequestObservationsAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.brapi1_3.studies.nor
                                .NewObservationsRequestListActivity
                                .this.refreshSinceItemHasChanged();
                        }
                    });
        return this.newObservationsRequestObservationsAlertDialogInstance;
    }

    // region Overridden Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance)
        {
            final android.app.Application application = this.getApplication();
            if (application instanceof org.wheatgenetics.javalib.mstrdtl.ItemsProvider)
                this.itemsInstance =
                    ((org.wheatgenetics.javalib.mstrdtl.ItemsProvider) application).mstrdtlItems();
        }
        return this.itemsInstance;
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    {
        return new
            org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsOnePaneAdapter(
                this.items());
    }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Methods
    @java.lang.Override public void moveUp(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        final org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest newObservationsRequest =
            (org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest) this.items();
        if (null != newObservationsRequest)
            { newObservationsRequest.moveUp(position); this.refreshSinceItemsHaveChanged(); }
    }

    @java.lang.Override public void moveDown(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        final org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest newObservationsRequest =
            (org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest) this.items();
        if (null != newObservationsRequest)
            { newObservationsRequest.moveDown(position); this.refreshSinceItemsHaveChanged(); }
    }

    @java.lang.Override public void change(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.newObservationsRequestObservationsAlertDialog().show(
            (io.swagger.client.model.NewObservationsRequestObservations) item);
    }
    // endregion
    // endregion
}