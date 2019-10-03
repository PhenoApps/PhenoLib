package org.wheatgenetics.brapi1_3.observations.pr.o;

/**
 * Uses:
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger
 *
 * org.wheatgenetics.brapi1_3.observations.pr.o.Observation
 * org.wheatgenetics.brapi1_3.observations.pr.o.Observations
 * org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog
 * org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.observations.pr.o.ObservationsListActivity
 */
public class ObservationItemActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
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
                        org.wheatgenetics.brapi1_3.observations.pr.o.ObservationItemActivity
                            .this.refreshSinceItemHasChanged();
                    }
                });
        return this.observationAlertDialogInstance;
    }

    // region Overridden Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.brapi1_3.observations.pr.o.ObservationsListActivity.class; }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override @android.support.annotation.NonNull
    protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance) this.itemsInstance =
            new org.wheatgenetics.brapi1_3.observations.pr.o.Observations().fromJson(
                this.getJson());
        return this.itemsInstance;
    }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger Overridden Method
    @java.lang.Override public void change(
    @android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.observationAlertDialog().show(
            (org.wheatgenetics.brapi1_3.observations.pr.o.Observation) item);
    }
    // endregion
    // endregion
}