package org.wheatgenetics.brapi1_3.studies.nour.ot;              // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.app.Application
 * android.content.Intent
 * android.os.Bundle
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
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 * org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.Application
 *
 * org.wheatgenetics.brapi1_3.studies.nour.Consts
 *
 * org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatmentAlertDialog
 * org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatmentAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentOnePaneAdapter
 */
public class ObservationTreatmentsListActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
{
    public static final int REQUEST_CODE = 2002;

    // region Fields
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        private int position;
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
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
    @java.lang.Override protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        final android.content.Intent intent = this.getIntent();
        if (null != intent)
        {
            final android.os.Bundle extras = intent.getExtras();
            if (null != extras) this.position = extras.getInt(
                org.wheatgenetics.brapi1_3.studies.nour.Consts.POSITION_KEY);
        }
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance)
        {
            final android.app.Application application = this.getApplication();
            if (application instanceof org.wheatgenetics.brapi1_3.studies.Application)
                this.itemsInstance = ((org.wheatgenetics.brapi1_3.studies.Application) application)
                    .getObservationTreatmentsAsItems(this.position);
        }
        return this.itemsInstance;
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    { return new org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentOnePaneAdapter(this.items()); }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Method
    @java.lang.Override public void change(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    { this.treatmentAlertDialog().show((io.swagger.client.model.ObservationTreatment) item); }
    // endregion
    // endregion
}