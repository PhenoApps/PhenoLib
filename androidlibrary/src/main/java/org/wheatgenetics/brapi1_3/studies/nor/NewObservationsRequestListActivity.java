package org.wheatgenetics.brapi1_3.studies.nor;                       // nor: NewObservationsRequest

/**
 * Uses:
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.NewObservationsRequestObservations
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsAlertDialog
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsOnePaneAdapter
 */
public class NewObservationsRequestListActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
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
                                .NewObservationsRequestListActivity
                                .this.refreshSinceItemHasChanged();
                        }
                    });
        return this.newObservationsRequestObservationsAlertDialogInstance;
    }

    // region Overridden Methods
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override @androidx.annotation.NonNull
    protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance) this.itemsInstance =
            new org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest().fromJson(
                this.getJson());
        return this.itemsInstance;
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    {
        return new
            org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequestObservationsOnePaneAdapter(
                this.items());
    }

    @java.lang.Override public void change(
    @androidx.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.newObservationsRequestObservationsAlertDialog().show(
            (io.swagger.client.model.NewObservationsRequestObservations) item);
    }
    // endregion
}