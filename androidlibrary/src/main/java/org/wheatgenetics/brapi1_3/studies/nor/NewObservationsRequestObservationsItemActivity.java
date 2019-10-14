package org.wheatgenetics.brapi1_3.studies.nor;                       // nor: NewObservationsRequest

/**
 * Uses:
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.NewObservationsRequestObservations
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ChangeableItemActivity
 *
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestListActivity
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsAlertDialog
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsAlertDialog.Handler
 */
public class NewObservationsRequestObservationsItemActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ChangeableItemActivity
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items               itemsInstance = null; // lazy load
    private org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsAlertDialog
        newObservationsRequestObservationsAlertDialogInstance = null;                   // lazy load
    // endregion

    private org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsAlertDialog
    newObservationsRequestObservationsAlertDialog()
    {
        if (null == this.newObservationsRequestObservationsAlertDialogInstance)
            this.newObservationsRequestObservationsAlertDialogInstance = new org.wheatgenetics
                .brapi1_3.studies.nor.NewObservationsRequestObservationsAlertDialog(
                    this, new org.wheatgenetics.brapi1_3.studies.nor
                    .NewObservationsRequestObservationsAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.brapi1_3.studies.nor
                                .NewObservationsRequestObservationsItemActivity
                                .this.refreshSinceItemHasChanged();
                        }
                    });
        return this.newObservationsRequestObservationsAlertDialogInstance;
    }

    // region Overridden Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override @android.support.annotation.NonNull
    protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance) this.itemsInstance =
            new org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest().fromJson(
                this.getJson());
        return this.itemsInstance;
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class listActivityClass()
    { return org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestListActivity.class; }

    @java.lang.Override public void change(
    @android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.newObservationsRequestObservationsAlertDialog().show(
            (io.swagger.client.model.NewObservationsRequestObservations) item);
    }
    // endregion
}