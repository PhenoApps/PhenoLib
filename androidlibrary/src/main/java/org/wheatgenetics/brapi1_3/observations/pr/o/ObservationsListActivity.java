package org.wheatgenetics.brapi1_3.observations.pr.o;

/**
 * Uses:
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.observations.pr.o.Observation
 * org.wheatgenetics.brapi1_3.observations.pr.o.Observations
 * org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog
 * org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.observations.pr.o.ObservationOnePaneAdapter
 */
public class ObservationsListActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items               itemsInstance = null; // lazy load
    private org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog
        observationAlertDialogInstance = null;                                          // lazy load
    // endregion

    private org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog
    observationAlertDialog()
    {
        if (null == this.observationAlertDialogInstance) this.observationAlertDialogInstance =
            new org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog(this,
                new org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog.Handler()
                {
                    @java.lang.Override public void handleDone()
                    {
                        org.wheatgenetics.brapi1_3.observations.pr.o.ObservationsListActivity
                            .this.refreshSinceItemHasChanged();
                    }
                });
        return this.observationAlertDialogInstance;
    }

    // region Overridden Methods
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override @androidx.annotation.NonNull
    protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance) this.itemsInstance =
            new org.wheatgenetics.brapi1_3.observations.pr.o.Observations().fromJson(
                this.getJson());
        return this.itemsInstance;
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    {
        return new org.wheatgenetics.brapi1_3.observations.pr.o.ObservationOnePaneAdapter(
            this.items());
    }

    @java.lang.Override public void change(
    @androidx.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.observationAlertDialog().show(
            (org.wheatgenetics.brapi1_3.observations.pr.o.Observation) item);
    }
    // endregion
}