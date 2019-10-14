package org.wheatgenetics.brapi1_3.studies.nour;                 // nour: NewObservationUnitRequests

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
 * org.wheatgenetics.androidlibrary.mstrdtl.ChangeableItemActivity
 *
 * org.wheatgenetics.brapi1_3.studies.nour.o.Observations
 * org.wheatgenetics.brapi1_3.studies.nour.o.Utils
 *
 * org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments
 * org.wheatgenetics.brapi1_3.studies.nour.ot.Utils
 *
 * org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefs
 * org.wheatgenetics.brapi1_3.studies.nour.oux.Utils
 *
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog.ActivityHandler
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestsListActivity
 */
public class NewObservationUnitRequestItemActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ChangeableItemActivity
{
    private static final int
        OBSERVATION_UNIT_XREF_LIST_ACTIVITY_REQUEST_CODE  = 1,
        OBSERVATIONS_LIST_ACTIVITY_REQUEST_CODE           = 2,
        OBSERVATION_TREATMENTS_LIST_ACTIVITY_REQUEST_CODE = 3;

    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items               itemsInstance = null; // lazy load
    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
        newObservationUnitRequestAlertDialogInstance = null;                            // lazy load
    // endregion

    // region Private Methods
    // region showListActivity() Private Methods
    private void showObservationUnitXrefListActivity(
    final org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefs observationUnitXrefs)
    {
        org.wheatgenetics.brapi1_3.studies.nour.oux.Utils.showObservationUnitXrefListActivity(
            /* activity    => */this,
            /* items       => */ observationUnitXrefs,
            /* requestCode => */
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestItemActivity
                    .OBSERVATION_UNIT_XREF_LIST_ACTIVITY_REQUEST_CODE);
    }

    private void showObservationsListActivity(
    final org.wheatgenetics.brapi1_3.studies.nour.o.Observations observations)
    {
        org.wheatgenetics.brapi1_3.studies.nour.o.Utils.showObservationsListActivity(
            /* activity    => */this,
            /* items       => */ observations,
            /* requestCode => */
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestItemActivity
                    .OBSERVATIONS_LIST_ACTIVITY_REQUEST_CODE);
    }

    private void showObservationTreatmentsListActivity(
    final org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments observationTreatments)
    {
        org.wheatgenetics.brapi1_3.studies.nour.ot.Utils.showObservationTreatmentsListActivity(
            /* activity    => */this,
            /* items       => */ observationTreatments,
            /* requestCode => */
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestItemActivity
                    .OBSERVATION_TREATMENTS_LIST_ACTIVITY_REQUEST_CODE);
    }
    // endregion

    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
    newObservationUnitRequestAlertDialog()
    {
        if (null == this.newObservationUnitRequestAlertDialogInstance)
            this.newObservationUnitRequestAlertDialogInstance =
                new org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog(
                    this, new org.wheatgenetics.brapi1_3.studies
                    .nour.NewObservationUnitRequestAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.brapi1_3.studies.nour
                                .NewObservationUnitRequestItemActivity
                                .this.refreshSinceItemHasChanged();
                        }
                    }, new org.wheatgenetics.brapi1_3.studies.nour
                    .NewObservationUnitRequestAlertDialog.ActivityHandler()
                    {
                        @java.lang.Override public void showObservationUnitXrefListActivity(final
                        org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefs
                        observationUnitXrefs)
                        {
                            org.wheatgenetics.brapi1_3.studies.nour
                                .NewObservationUnitRequestItemActivity.this
                                .showObservationUnitXrefListActivity(observationUnitXrefs);
                        }

                        @java.lang.Override public void showObservationsListActivity(
                        final org.wheatgenetics.brapi1_3.studies.nour.o.Observations observations)
                        {
                            org.wheatgenetics.brapi1_3.studies.nour
                                .NewObservationUnitRequestItemActivity.this
                                .showObservationsListActivity(observations);
                        }

                        @java.lang.Override public void showObservationTreatmentsListActivity(final
                        org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments
                        observationTreatments)
                        {
                            org.wheatgenetics.brapi1_3.studies.nour
                                .NewObservationUnitRequestItemActivity.this
                                .showObservationTreatmentsListActivity(observationTreatments);
                        }
                    });
        return this.newObservationUnitRequestAlertDialogInstance;
    }
    // endregion

    // region Overridden Methods
    @java.lang.Override protected void onActivityResult(final int requestCode, final int resultCode,
    @android.support.annotation.Nullable final android.content.Intent data)
    {
        if (android.app.Activity.RESULT_OK == resultCode && null != data)
            if (null != this.newObservationUnitRequestAlertDialogInstance)
            {
                final boolean dataHasJson; final java.lang.String json;
                {
                    final java.lang.String JSON_KEY =
                        org.wheatgenetics.androidlibrary.mstrdtl.Consts.JSON_KEY;
                    dataHasJson = data.hasExtra(JSON_KEY)                           ;
                    json        = dataHasJson ? data.getStringExtra(JSON_KEY) : null;
                }

                switch (requestCode)
                {
                    case
                    org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestItemActivity
                    .OBSERVATION_UNIT_XREF_LIST_ACTIVITY_REQUEST_CODE:
                        if (dataHasJson)
                            this.newObservationUnitRequestAlertDialogInstance
                                .setObservationUnitXrefs(json);
                        else
                            this.newObservationUnitRequestAlertDialogInstance
                                .clearObservationUnitXrefs();
                        break;

                    case
                    org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestItemActivity
                    .OBSERVATIONS_LIST_ACTIVITY_REQUEST_CODE:
                        if (dataHasJson)
                            this.newObservationUnitRequestAlertDialogInstance.setObservations(json);
                        else
                            this.newObservationUnitRequestAlertDialogInstance.clearObservations();
                        break;

                    case
                    org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestItemActivity
                    .OBSERVATION_TREATMENTS_LIST_ACTIVITY_REQUEST_CODE:
                        if (dataHasJson)
                            this.newObservationUnitRequestAlertDialogInstance
                                .setObservationTreatments(json);
                        else
                            this.newObservationUnitRequestAlertDialogInstance
                                .clearObservationTreatments();
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
            new org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests().fromJson(
                this.getJson());
        return this.itemsInstance;
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestsListActivity.class; }

    @java.lang.Override public void change(
    @android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.newObservationUnitRequestAlertDialog().show(
            (org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest) item);
    }
    // endregion
}