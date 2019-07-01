package org.wheatgenetics.brapi1_3.studies.nour.oux;             // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.app.Activity
 * android.content.Intent
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefListActivity
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Utils extends java.lang.Object
{
    private static android.content.Intent OBSERVATIONUNITXREF_LIST_INTENT_INSTANCE = null;     // ll

    private static android.content.Intent observationUnitXrefListIntent(
    final android.app.Activity activity)
    {
        if (null ==
        org.wheatgenetics.brapi1_3.studies.nour.oux.Utils.OBSERVATIONUNITXREF_LIST_INTENT_INSTANCE)
            org.wheatgenetics.brapi1_3.studies.nour.oux.Utils
                .OBSERVATIONUNITXREF_LIST_INTENT_INSTANCE = new android.content.Intent(activity,
                    org.wheatgenetics.brapi1_3.studies.nour.oux
                        .ObservationUnitXrefListActivity.class);
        return org.wheatgenetics.brapi1_3.studies.nour.oux
            .Utils.OBSERVATIONUNITXREF_LIST_INTENT_INSTANCE;
    }

    public static void showObservationUnitXrefListActivity(
    @android.support.annotation.NonNull final android.app.Activity activity)
    {
        activity.startActivityForResult(
            org.wheatgenetics.brapi1_3.studies.nour.oux.Utils.observationUnitXrefListIntent(
                activity),
            org.wheatgenetics.brapi1_3.studies.nour.oux
                .ObservationUnitXrefListActivity.REQUEST_CODE);
    }
}