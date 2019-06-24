package org.wheatgenetics.brapi1_3.studies.nour;                 // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.app.Activity
 * android.content.Intent
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.brapi1_3.studies.nour.TreatmentsListActivity
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Utils extends java.lang.Object
{
    public static final java.lang.String POSITION_KEY = "position";

    private static android.content.Intent TREATMENTS_LIST_INTENT_INSTANCE = null;       // lazy load

    private static android.content.Intent treatmentsListIntent(final android.app.Activity activity)
    {
        if (null == org.wheatgenetics.brapi1_3.studies.nour.Utils.TREATMENTS_LIST_INTENT_INSTANCE)
            org.wheatgenetics.brapi1_3.studies.nour.Utils.TREATMENTS_LIST_INTENT_INSTANCE =
                new android.content.Intent(activity,
                    org.wheatgenetics.brapi1_3.studies.nour.TreatmentsListActivity.class);
        return
            org.wheatgenetics.brapi1_3.studies.nour.Utils.TREATMENTS_LIST_INTENT_INSTANCE;
    }

    static void showTreatmentsListActivity(
    @android.support.annotation.NonNull final android.app.Activity activity,
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        final android.content.Intent treatmentsListIntent =
            org.wheatgenetics.brapi1_3.studies.nour.Utils.treatmentsListIntent(activity);
        if (null != treatmentsListIntent) treatmentsListIntent.putExtra(
            org.wheatgenetics.brapi1_3.studies.nour.Utils.POSITION_KEY, position);
        activity.startActivityForResult(treatmentsListIntent,
            org.wheatgenetics.brapi1_3.studies.nour.TreatmentsListActivity.REQUEST_CODE);
    }
}