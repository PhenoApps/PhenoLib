package org.wheatgenetics.brapi1_3.observations.pr.o;

/**
 * Uses:
 * android.app.Application
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 *
 * org.wheatgenetics.brapi1_3.Application
 *
 * org.wheatgenetics.brapi1_3.observations.pr.o.Observation
 * org.wheatgenetics.brapi1_3.observations.pr.o.Observations
 * org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog
 * org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.observations.pr.o.ObservationsListActivity
 */
public class ObservationItemActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ItemActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
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

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Methods
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        if (null == this.itemsInstance)
        {
            final android.app.Application application = this.getApplication();
            if (application instanceof org.wheatgenetics.brapi1_3.Application)
                this.itemsInstance = ((org.wheatgenetics.brapi1_3.Application) application)
                    .getPRObservationsAsItems();
        }
        return null == this.itemsInstance ? null : this.itemsInstance.get(position);
    }

    @java.lang.Override public void moveUp(@android.support.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        final org.wheatgenetics.brapi1_3.observations.pr.o.Observations observations =
            (org.wheatgenetics.brapi1_3.observations.pr.o.Observations) this.itemsInstance;
        if (null != observations)
            { observations.moveUp(position); this.refreshSinceItemsHaveChanged(); }
    }

    @java.lang.Override public void moveDown(@android.support.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        final org.wheatgenetics.brapi1_3.observations.pr.o.Observations observations =
            (org.wheatgenetics.brapi1_3.observations.pr.o.Observations) this.itemsInstance;
        if (null != observations)
            { observations.moveDown(position); this.refreshSinceItemsHaveChanged(); }
    }

    @java.lang.Override public void change(
    @android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.observationAlertDialog().show(
            (org.wheatgenetics.brapi1_3.observations.pr.o.Observation) item);
    }
    // endregion
    // endregion
}