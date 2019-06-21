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
 * io.swagger.client.model.ObservationUnitXref
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.nour.Utils
 */
class ObservationUnitXrefListActivity extends org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
{
    static final int REQUEST_CODE = 2000;

    // region Fields
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        private int position;
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
    // endregion

    // region Overridden Methods
    @java.lang.Override protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        final android.content.Intent intent = this.getIntent();
        if (null != intent)
        {
            final android.os.Bundle extras = intent.getExtras();
            if (null != extras) this.position = extras.getInt(
                org.wheatgenetics.brapi1_3.studies.nour.Utils.POSITION_KEY);
        }
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        /*if (null == this.itemsInstance) this.itemsInstance =
            org.wheatgenetics.brapi1_3.studies.nour.Utils.getObservationUnitXrefAsItems(
                this.getApplication(), this.position);*/
        return this.itemsInstance;
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    { return new org.wheatgenetics.brapi1_3.studies.nour.ObservationOnePaneAdapter(this.items()); }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger Overridden Method
    /*@java.lang.Override public void change(
    @android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.observationUnitXrefAlertDialog().show(
            (io.swagger.client.model.ObservationUnitXref) item);
    }*/
    // endregion
    // endregion
}