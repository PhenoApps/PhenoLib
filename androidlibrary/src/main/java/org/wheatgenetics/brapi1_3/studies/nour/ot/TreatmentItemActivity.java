package org.wheatgenetics.brapi1_3.studies.nour.ot;              // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.app.Application
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.ObservationTreatment
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 *
 * org.wheatgenetics.brapi1_3.studies.Application
 *
 * org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentAlertDialog
 * org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentsListActivity
 */
public class TreatmentItemActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
    private org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentAlertDialog
        treatmentAlertDialogInstance = null;                                            // lazy load
    // endregion

    private org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentAlertDialog treatmentAlertDialog()
    {
        if (null == this.treatmentAlertDialogInstance) this.treatmentAlertDialogInstance =
            new org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentAlertDialog(this,
                new org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentAlertDialog.Handler()
                {
                    @java.lang.Override public void handleDone()
                    {
                        org.wheatgenetics.brapi1_3.studies.nour.ot
                            .TreatmentItemActivity.this.refreshSinceItemHasChanged();
                    }
                });
        return this.treatmentAlertDialogInstance;
    }

    // region Overridden Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentsListActivity.class; }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Methods
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        if (null == this.itemsInstance)
        {
            final android.app.Application application = this.getApplication();
            if (application instanceof org.wheatgenetics.brapi1_3.studies.Application)
                this.itemsInstance = ((org.wheatgenetics.brapi1_3.studies.Application) application)
                    .getObservationTreatmentsAsItems();
        }
        return null == this.itemsInstance ? null : this.itemsInstance.get(position);
    }

    @java.lang.Override public void change(
    @android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    { this.treatmentAlertDialog().show((io.swagger.client.model.ObservationTreatment) item); }
    // endregion
    // endregion
}