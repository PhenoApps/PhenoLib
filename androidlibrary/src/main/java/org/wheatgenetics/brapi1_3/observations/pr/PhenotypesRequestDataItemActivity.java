package org.wheatgenetics.brapi1_3.observations.pr;

/**
 * Uses:
 * android.app.Application
 * android.content.Intent
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.ItemsProvider
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 *
 * org.wheatgenetics.brapi1_3.observations.pr.o.Utils
 *
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog.ActivityHandler
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestListActivity
 */
public class PhenotypesRequestDataItemActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
    private org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog
        phenotypesRequestDataAlertDialogInstance = null;                                // lazy load
    // endregion

    // region Private Methods
    private void showObservationsListActivity()
    { org.wheatgenetics.brapi1_3.observations.pr.o.Utils.showObservationsListActivity(this); }

    private org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog
    phenotypesRequestDataAlertDialog()
    {
        if (null == this.phenotypesRequestDataAlertDialogInstance)
            this.phenotypesRequestDataAlertDialogInstance =
                new org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog(
                    this, new org.wheatgenetics.brapi1_3.observations.pr
                    .PhenotypesRequestDataAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.brapi1_3.observations.pr
                                .PhenotypesRequestDataItemActivity.this
                                .refreshSinceItemHasChanged();
                        }
                    }, new org.wheatgenetics.brapi1_3.observations.pr
                    .PhenotypesRequestDataAlertDialog.ActivityHandler()
                    {
                        @java.lang.Override public void showObservationsListActivity()
                        {
                            org.wheatgenetics.brapi1_3.observations.pr
                                .PhenotypesRequestDataItemActivity.this
                                .showObservationsListActivity();
                        }
                    });
        return this.phenotypesRequestDataAlertDialogInstance;
    }
    // endregion

    // region Overridden Methods
    @java.lang.Override protected void onActivityResult(final int requestCode, final int resultCode,
    @android.support.annotation.Nullable final android.content.Intent data)
    {
        if (requestCode ==
        org.wheatgenetics.brapi1_3.observations.pr.o.Utils.OBSERVATIONS_LIST_ACTIVITY_REQUEST_CODE)
            if (null != this.phenotypesRequestDataAlertDialogInstance)
                this.phenotypesRequestDataAlertDialogInstance.updateObservations();
        super.onActivityResult(requestCode, resultCode, data);
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestListActivity.class; }

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

    @java.lang.Override public void moveUp(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        final org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest phenotypesRequest =
            (org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest) this.itemsInstance;
        if (null != phenotypesRequest)
            { phenotypesRequest.moveUp(position); this.refreshSinceItemsHaveChanged(); }
    }

    @java.lang.Override public void moveDown(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        final org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest phenotypesRequest =
            (org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest) this.itemsInstance;
        if (null != phenotypesRequest)
            { phenotypesRequest.moveDown(position); this.refreshSinceItemsHaveChanged(); }
    }

    @java.lang.Override public void change(
    @android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.phenotypesRequestDataAlertDialog().show(
            (org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData) item);
    }
    // endregion
    // endregion
}