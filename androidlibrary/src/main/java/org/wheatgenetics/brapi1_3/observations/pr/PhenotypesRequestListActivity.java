package org.wheatgenetics.brapi1_3.observations.pr;

/**
 * Uses:
 * android.app.Activity
 * android.content.Intent
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Consts
 * org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.observations.pr.o.Observations
 * org.wheatgenetics.brapi1_3.observations.pr.o.Utils
 *
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog.ActivityHandler
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataOnePaneAdapter
 */
public class PhenotypesRequestListActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
{
    private static final int REQUEST_CODE = 1;

    // region Fields
    private org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog
        phenotypesRequestDataAlertDialogInstance = null;                                // lazy load
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
    // endregion

    // region Private Methods
    private void showObservationsListActivity(
    final org.wheatgenetics.brapi1_3.observations.pr.o.Observations observations)
    {
        org.wheatgenetics.brapi1_3.observations.pr.o.Utils.showObservationsListActivity(
            /* activity    => */this,
            /* items       => */ observations,
            /* requestCode => */ org.wheatgenetics.brapi1_3.observations
                .pr.PhenotypesRequestListActivity.REQUEST_CODE);
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
                            org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestListActivity
                                .this.refreshSinceItemHasChanged();
                        }
                    }, new org.wheatgenetics.brapi1_3.observations.pr
                    .PhenotypesRequestDataAlertDialog.ActivityHandler()
                    {
                        @java.lang.Override public void showObservationsListActivity(final
                        org.wheatgenetics.brapi1_3.observations.pr.o.Observations observations)
                        {
                            org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestListActivity
                                .this.showObservationsListActivity(observations);
                        }
                    });
        return this.phenotypesRequestDataAlertDialogInstance;
    }
    // endregion

    // region Overridden Methods
    @java.lang.Override protected void onActivityResult(final int requestCode, final int resultCode,
    @android.support.annotation.Nullable final android.content.Intent data)
    {
        if (android.app.Activity.RESULT_OK == resultCode && null != data)
            if (null != this.phenotypesRequestDataAlertDialogInstance)
            {
                final boolean dataHasJson; final java.lang.String json;
                {
                    final java.lang.String JSON_KEY =
                        org.wheatgenetics.androidlibrary.mstrdtl.Consts.JSON_KEY;
                    dataHasJson = data.hasExtra(JSON_KEY)                           ;
                    json        = dataHasJson ? data.getStringExtra(JSON_KEY) : null;
                }

                // noinspection SwitchStatementWithTooFewBranches
                switch (requestCode)
                {
                    case org.wheatgenetics.brapi1_3.observations.pr
                    .PhenotypesRequestListActivity.REQUEST_CODE:
                        if (dataHasJson)
                            this.phenotypesRequestDataAlertDialogInstance.setObservations(json);
                        else
                            this.phenotypesRequestDataAlertDialogInstance.clearObservations();
                        break;
                }
            }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override @android.support.annotation.NonNull
    protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance) this.itemsInstance =
            new org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest().fromJson(
                this.getJson());
        return this.itemsInstance;
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    {
        return new org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataOnePaneAdapter(
            this.items());
    }

    @java.lang.Override public void change(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.phenotypesRequestDataAlertDialog().show(
            (org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData) item);
    }
    // endregion
}