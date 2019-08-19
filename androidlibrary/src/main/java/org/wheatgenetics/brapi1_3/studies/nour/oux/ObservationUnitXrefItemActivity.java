package org.wheatgenetics.brapi1_3.studies.nour.oux;             // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.app.Application
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.ObservationUnitXref
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger
 *
 * org.wheatgenetics.brapi1_3.Application
 *
 * org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefAlertDialog
 * org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefListActivity
 */
public class ObservationUnitXrefItemActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
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
                                .ObservationUnitXrefItemActivity.this.refreshSinceItemHasChanged();
                        }
                    });
        return this.observationUnitXrefAlertDialogInstance;
    }

    // region Overridden Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefListActivity.class; }

    @java.lang.Override protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance)
        {
            final android.app.Application application = this.getApplication();
            if (application instanceof org.wheatgenetics.brapi1_3.Application)
                this.itemsInstance = ((org.wheatgenetics.brapi1_3.Application) application)
                    .getObservationUnitXrefsAsItems();
        }
        return this.itemsInstance;
    }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger Overridden Method
    @java.lang.Override public void change(
    @android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.observationUnitXrefAlertDialog().show(
            (io.swagger.client.model.ObservationUnitXref) item);
    }
    // endregion
    // endregion
}