package org.wheatgenetics.brapi1_3.studies.nour.ot;              // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.app.Activity
 * android.content.Intent
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatmentsListActivity
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Utils extends java.lang.Object
{
    private static android.content.Intent TREATMENTS_LIST_INTENT_INSTANCE = null;       // lazy load

    private static android.content.Intent observationTreatmentsListIntent(
    final android.app.Activity activity)
    {
        if (null ==
        org.wheatgenetics.brapi1_3.studies.nour.ot.Utils.TREATMENTS_LIST_INTENT_INSTANCE)
            org.wheatgenetics.brapi1_3.studies.nour.ot.Utils.TREATMENTS_LIST_INTENT_INSTANCE =
                new android.content.Intent(activity, org.wheatgenetics.brapi1_3
                    .studies.nour.ot.ObservationTreatmentsListActivity.class);
        return
            org.wheatgenetics.brapi1_3.studies.nour.ot.Utils.TREATMENTS_LIST_INTENT_INSTANCE;
    }

    public static void showObservationTreatmentsListActivity(
    @android.support.annotation.NonNull final android.app.Activity activity, final int requestCode)
    {
        activity.startActivityForResult(
            org.wheatgenetics.brapi1_3.studies.nour.ot.Utils.observationTreatmentsListIntent(
                activity),
            requestCode);
    }
}