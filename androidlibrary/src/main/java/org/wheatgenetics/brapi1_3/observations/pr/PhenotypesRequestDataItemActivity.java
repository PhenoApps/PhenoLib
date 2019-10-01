package org.wheatgenetics.brapi1_3.observations.pr;

/**
 * Uses:
 * android.app.Application
 * android.content.Intent
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
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger
 *
 * org.wheatgenetics.brapi1_3.observations.pr.o.Utils
 *
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog.ActivityHandler
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestListActivity
 */
public class PhenotypesRequestDataItemActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger
{
    private static final int REQUEST_CODE = 1;

    // region Fields
    private org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog
        phenotypesRequestDataAlertDialogInstance = null;                                // lazy load
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
    // endregion

    // region Private Methods
    private void showObservationsListActivity()
    {
        org.wheatgenetics.brapi1_3.observations.pr.o.Utils.showObservationsListActivity(
            this, org.wheatgenetics.brapi1_3.observations
                .pr.PhenotypesRequestDataItemActivity.REQUEST_CODE);
    }

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
        if (
        org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataItemActivity.REQUEST_CODE
        == requestCode)
            if (null != this.phenotypesRequestDataAlertDialogInstance)
                this.phenotypesRequestDataAlertDialogInstance.updateObservations();
        super.onActivityResult(requestCode, resultCode, data);
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestListActivity.class; }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override @android.support.annotation.NonNull
    protected org.wheatgenetics.javalib.mstrdtl.Items items()
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

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger Overridden Method
    @java.lang.Override public void change(
    @android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.phenotypesRequestDataAlertDialog().show(
            (org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData) item);
    }
    // endregion
    // endregion
}