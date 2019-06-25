package org.wheatgenetics.brapi1_3.studies.nour.o;               // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.app.Activity
 * android.content.Intent
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.brapi1_3.studies.nour.Consts
 *
 * org.wheatgenetics.brapi1_3.studies.nour.o.ObservationsListActivity
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Utils extends java.lang.Object
{
    private static android.content.Intent OBSERVATIONS_LIST_INTENT_INSTANCE = null;     // lazy load

    private static android.content.Intent observationsListIntent(
    final android.app.Activity activity)
    {
        if (null ==
        org.wheatgenetics.brapi1_3.studies.nour.o.Utils.OBSERVATIONS_LIST_INTENT_INSTANCE)
            org.wheatgenetics.brapi1_3.studies.nour.o.Utils.OBSERVATIONS_LIST_INTENT_INSTANCE =
                new android.content.Intent(activity,
                    org.wheatgenetics.brapi1_3.studies.nour.o.ObservationsListActivity.class);
        return
            org.wheatgenetics.brapi1_3.studies.nour.o.Utils.OBSERVATIONS_LIST_INTENT_INSTANCE;
    }

    public static void showObservationsListActivity(
    @android.support.annotation.NonNull final android.app.Activity activity,
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        final android.content.Intent observationsListIntent =
            org.wheatgenetics.brapi1_3.studies.nour.o.Utils.observationsListIntent(activity);
        if (null != observationsListIntent) observationsListIntent.putExtra(
            org.wheatgenetics.brapi1_3.studies.nour.Consts.POSITION_KEY, position);
        activity.startActivityForResult(observationsListIntent,
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationsListActivity.REQUEST_CODE);
    }
}