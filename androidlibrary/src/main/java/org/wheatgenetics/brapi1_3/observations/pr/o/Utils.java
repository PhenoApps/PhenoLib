package org.wheatgenetics.brapi1_3.observations.pr.o;

/**
 * Uses:
 * android.app.Activity
 * android.content.Intent
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.brapi1_3.observations.pr.o.ObservationsListActivity
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Utils extends java.lang.Object
{
    public static final int OBSERVATIONS_LIST_ACTIVITY_REQUEST_CODE =
        org.wheatgenetics.brapi1_3.observations.pr.o.ObservationsListActivity.REQUEST_CODE;

    private static android.content.Intent OBSERVATIONS_LIST_INTENT_INSTANCE = null;     // lazy load

    private static android.content.Intent observationsListIntent(
    final android.app.Activity activity)
    {
        if (null ==
        org.wheatgenetics.brapi1_3.observations.pr.o.Utils.OBSERVATIONS_LIST_INTENT_INSTANCE)
            org.wheatgenetics.brapi1_3.observations.pr.o.Utils.OBSERVATIONS_LIST_INTENT_INSTANCE =
                new android.content.Intent(activity,
                    org.wheatgenetics.brapi1_3.observations.pr.o.ObservationsListActivity.class);
        return
            org.wheatgenetics.brapi1_3.observations.pr.o.Utils.OBSERVATIONS_LIST_INTENT_INSTANCE;
    }

    public static void showObservationsListActivity(
    @android.support.annotation.NonNull final android.app.Activity activity)
    {
        activity.startActivityForResult(
            org.wheatgenetics.brapi1_3.observations.pr.o.Utils.observationsListIntent(activity),
            org.wheatgenetics.brapi1_3.observations.pr.o.ObservationsListActivity.REQUEST_CODE);
    }
}