package org.wheatgenetics.brapi1_3.studies.nour;

/**
 * Uses:
 * android.app.Activity
 * android.content.Intent
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.brapi1_3.studies.nour.ObservationUnitXrefListActivity
 * org.wheatgenetics.brapi1_3.studies.nour.TreatmentsListActivity
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Utils extends java.lang.Object
{
    public static final java.lang.String POSITION_KEY = "position";

    private static android.content.Intent OBSERVATIONUNITXREF_LIST_INTENT_INSTANCE = null,  // lazy
        TREATMENTS_LIST_INTENT_INSTANCE = null;                                             // loads

    // region Private Methods
    private static android.content.Intent observationUnitXrefListIntent(
    final android.app.Activity activity)
    {
        if (null ==
        org.wheatgenetics.brapi1_3.studies.nour.Utils.OBSERVATIONUNITXREF_LIST_INTENT_INSTANCE)
            org.wheatgenetics.brapi1_3.studies.nour.Utils.OBSERVATIONUNITXREF_LIST_INTENT_INSTANCE =
                new android.content.Intent(activity,
                    org.wheatgenetics.brapi1_3.studies.nour.ObservationUnitXrefListActivity.class);
        return
            org.wheatgenetics.brapi1_3.studies.nour.Utils.OBSERVATIONUNITXREF_LIST_INTENT_INSTANCE;
    }

    private static android.content.Intent treatmentsListIntent(final android.app.Activity activity)
    {
        if (null == org.wheatgenetics.brapi1_3.studies.nour.Utils.TREATMENTS_LIST_INTENT_INSTANCE)
            org.wheatgenetics.brapi1_3.studies.nour.Utils.TREATMENTS_LIST_INTENT_INSTANCE =
                new android.content.Intent(activity,
                    org.wheatgenetics.brapi1_3.studies.nour.TreatmentsListActivity.class);
        return
            org.wheatgenetics.brapi1_3.studies.nour.Utils.TREATMENTS_LIST_INTENT_INSTANCE;
    }
    // endregion

    // region Package Methods
    static void showObservationUnitXrefListActivity(
    @android.support.annotation.NonNull final android.app.Activity activity,
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        final android.content.Intent observationUnitXrefListIntent =
            org.wheatgenetics.brapi1_3.studies.nour.Utils.observationUnitXrefListIntent(activity);
        if (null != observationUnitXrefListIntent) observationUnitXrefListIntent.putExtra(
            org.wheatgenetics.brapi1_3.studies.nour.Utils.POSITION_KEY, position);
        activity.startActivityForResult(observationUnitXrefListIntent,
            org.wheatgenetics.brapi1_3.studies.nour.ObservationUnitXrefListActivity.REQUEST_CODE);
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
    // endregion
}