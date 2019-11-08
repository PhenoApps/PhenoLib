package org.wheatgenetics.brapi1_3.studies.nour.ot;              // nour: NewObservationUnitRequests

/**
 * Uses:
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.ObservationTreatment
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments
 * org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatmentAlertDialog
 * org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatmentAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatmentOnePaneAdapter
 */
public class ObservationTreatmentsListActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items               itemsInstance = null; // lazy load
    private org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatmentAlertDialog
        treatmentAlertDialogInstance = null;                                            // lazy load
    // endregion

    private org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatmentAlertDialog
    treatmentAlertDialog()
    {
        if (null == this.treatmentAlertDialogInstance) this.treatmentAlertDialogInstance =
            new org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatmentAlertDialog(
                this, new
                org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatmentAlertDialog.Handler()
                {
                    @java.lang.Override public void handleDone()
                    {
                        org.wheatgenetics.brapi1_3.studies.nour.ot
                            .ObservationTreatmentsListActivity.this.refreshSinceItemHasChanged();
                    }
                });
        return this.treatmentAlertDialogInstance;
    }

    // region Overridden Methods
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override @androidx.annotation.NonNull
    protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance) this.itemsInstance =
            new org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments().fromJson(
                this.getJson());
        return this.itemsInstance;
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    {
        return new org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatmentOnePaneAdapter(
            this.items());
    }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger Overridden Method
    @java.lang.Override public void change(
    @androidx.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    { this.treatmentAlertDialog().show((io.swagger.client.model.ObservationTreatment) item); }
    // endregion
    // endregion
}