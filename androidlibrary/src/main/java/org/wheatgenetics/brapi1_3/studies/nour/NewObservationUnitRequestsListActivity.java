package org.wheatgenetics.brapi1_3.studies.nour;                 // nour: NewObservationUnitRequests

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
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 * org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.nour.o.ObservationsListActivity
 * org.wheatgenetics.brapi1_3.studies.nour.o.Utils
 *
 * org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatmentsListActivity
 * org.wheatgenetics.brapi1_3.studies.nour.ot.Utils
 *
 * org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefListActivity
 * org.wheatgenetics.brapi1_3.studies.nour.oux.Utils
 *
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog.ActivityHandler
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestOnePaneAdapter
 * org.wheatgenetics.brapi1_3.studies.nour.Utils
 */
public class NewObservationUnitRequestsListActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
        newObservationUnitRequestAlertDialogInstance = null;                            // lazy load
    // endregion

    // region Private Methods
    // region showListActivity() Private Methods
    private void showObservationUnitXrefListActivity(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        org.wheatgenetics.brapi1_3.studies.nour.oux.Utils.showObservationUnitXrefListActivity(
            this, position);
    }

    private void showObservationsListActivity(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position)
    {
        org.wheatgenetics.brapi1_3.studies.nour.o.Utils.showObservationsListActivity(
            this, position);
    }

    private void showObservationTreatmentsListActivity(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position)
    {
        org.wheatgenetics.brapi1_3.studies.nour.ot.Utils.showObservationTreatmentsListActivity(
            this, position);
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
                                .NewObservationUnitRequestsListActivity
                                .this.refreshSinceItemHasChanged();
                        }
                    }, new org.wheatgenetics.brapi1_3.studies.nour
                    .NewObservationUnitRequestAlertDialog.ActivityHandler()
                    {
                        @java.lang.Override public void showObservationUnitXrefListActivity(
                        @android.support.annotation.IntRange(from =
                            org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
                        {
                            org.wheatgenetics.brapi1_3.studies.nour
                                .NewObservationUnitRequestsListActivity
                                .this.showObservationUnitXrefListActivity(position);
                        }

                        @java.lang.Override public void showObservationsListActivity(
                        @android.support.annotation.IntRange(from =
                            org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
                        {
                            org.wheatgenetics.brapi1_3.studies.nour
                                .NewObservationUnitRequestsListActivity
                                .this.showObservationsListActivity(position);
                        }

                        @java.lang.Override public void showObservationTreatmentsListActivity(
                        @android.support.annotation.IntRange(from =
                            org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
                        {
                            org.wheatgenetics.brapi1_3.studies.nour
                                .NewObservationUnitRequestsListActivity
                                .this.showObservationTreatmentsListActivity(position);
                        }
                    });
        return this.newObservationUnitRequestAlertDialogInstance;
    }
    // endregion

    // region Overridden Methods
    @java.lang.Override protected void onActivityResult(final int requestCode, final int resultCode,
    @android.support.annotation.Nullable final android.content.Intent data)
    {
        if (null != this.newObservationUnitRequestAlertDialogInstance) switch (requestCode)
        {
            case org.wheatgenetics.brapi1_3.studies.nour.oux
            .ObservationUnitXrefListActivity.REQUEST_CODE:
                this.newObservationUnitRequestAlertDialogInstance.updateObservationUnitXref();
                break;

            case org.wheatgenetics.brapi1_3.studies.nour.o.ObservationsListActivity.REQUEST_CODE:
                this.newObservationUnitRequestAlertDialogInstance.updateObservations(); break;

            case org.wheatgenetics.brapi1_3.studies.nour.ot
            .ObservationTreatmentsListActivity.REQUEST_CODE:
                this.newObservationUnitRequestAlertDialogInstance.updateObservationTreatments();
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

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
        return new org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestOnePaneAdapter(
            this.items());
    }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Method
    @java.lang.Override public void change(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.newObservationUnitRequestAlertDialog().show(
            (org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest) item);
    }
    // endregion
    // endregion
}