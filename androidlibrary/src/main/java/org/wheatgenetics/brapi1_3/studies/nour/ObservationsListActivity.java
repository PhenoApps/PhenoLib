package org.wheatgenetics.brapi1_3.studies.nour;

/**
 * Uses:
 * android.content.Intent
 * android.os.Bundle
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.Observation
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
 * org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog
 * org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.studies.nour.ObservationOnePaneAdapter
 * org.wheatgenetics.brapi1_3.studies.nour.Utils
 */
public class ObservationsListActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
{
    // region Constants
    static final java.lang.String POSITION_KEY                            = "position";
    static final int              OBSERVATIONS_LIST_ACTIVITY_REQUEST_CODE = 2000      ;
    // endregion

    // region Fields
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        private int position;
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
    private org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog
        observationAlertDialogInstance = null;                                          // lazy load
    // endregion

    private org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog observationAlertDialog()
    {
        if (null == this.observationAlertDialogInstance) this.observationAlertDialogInstance =
            new org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog(this,
                new org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.Handler()
                {
                    @java.lang.Override public void handleDone()
                    {
                        org.wheatgenetics.brapi1_3.studies.nour.ObservationsListActivity
                            .this.refreshSinceItemHasChanged();
                    }
                });
        return this.observationAlertDialogInstance;
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
                org.wheatgenetics.brapi1_3.studies.nour.ObservationsListActivity.POSITION_KEY);
        }
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance) this.itemsInstance =
            org.wheatgenetics.brapi1_3.studies.nour.Utils.getObservationsAsItems(
                this.getApplication(), this.position);
        return this.itemsInstance;
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    { return new org.wheatgenetics.brapi1_3.studies.nour.ObservationOnePaneAdapter(this.items()); }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Method
    @java.lang.Override public void change(
    @android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    { this.observationAlertDialog().show((io.swagger.client.model.Observation) item); }
    // endregion
    // endregion
}