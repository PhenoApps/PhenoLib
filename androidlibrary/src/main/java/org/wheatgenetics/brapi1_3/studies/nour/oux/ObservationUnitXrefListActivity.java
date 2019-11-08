package org.wheatgenetics.brapi1_3.studies.nour.oux;             // nour: NewObservationUnitRequests

/**
 * Uses:
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.ObservationUnitXref
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefs
 * org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefAlertDialog
 * org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefOnePaneAdapter
 */
public class ObservationUnitXrefListActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items               itemsInstance = null; // lazy load
    private org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefAlertDialog
        observationUnitXrefAlertDialogInstance = null;                                  // lazy load
    // endregion

    private org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefAlertDialog
    observationUnitXrefAlertDialog()
    {
        if (null == this.observationUnitXrefAlertDialogInstance)
            this.observationUnitXrefAlertDialogInstance =
                new org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefAlertDialog(
                    this, new org.wheatgenetics.brapi1_3.studies
                    .nour.oux.ObservationUnitXrefAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.brapi1_3.studies.nour.oux
                                .ObservationUnitXrefListActivity.this.refreshSinceItemHasChanged();
                        }
                    });
        return this.observationUnitXrefAlertDialogInstance;
    }

    // region Overridden Methods
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override @androidx.annotation.NonNull
    protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance) this.itemsInstance =
            new org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefs().fromJson(
                this.getJson());
        return this.itemsInstance;
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    {
        return new org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefOnePaneAdapter(
            this.items());
    }

    @java.lang.Override public void change(
    @androidx.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.observationUnitXrefAlertDialog().show(
            (io.swagger.client.model.ObservationUnitXref) item);
    }
    // endregion
}