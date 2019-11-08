package org.wheatgenetics.brapi1_3.observations.pr.o;

/**
 * Uses:
 * android.app.Activity
 * android.content.Intent
 *
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Utils
 *
 * org.wheatgenetics.brapi1_3.observations.pr.o.ObservationsListActivity
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Utils extends java.lang.Object
{
    private static android.content.Intent OBSERVATIONS_LIST_INTENT_INSTANCE = null;     // lazy load

    private static android.content.Intent observationsListIntent(
    final android.app.Activity activity, final org.wheatgenetics.javalib.mstrdtl.Items items)
    {
        if (null ==
        org.wheatgenetics.brapi1_3.observations.pr.o.Utils.OBSERVATIONS_LIST_INTENT_INSTANCE)
            org.wheatgenetics.brapi1_3.observations.pr.o.Utils.OBSERVATIONS_LIST_INTENT_INSTANCE =
                new android.content.Intent(activity,
                    org.wheatgenetics.brapi1_3.observations.pr.o.ObservationsListActivity.class);
        return org.wheatgenetics.androidlibrary.mstrdtl.Utils.putJsonIntoIntent(items,
            org.wheatgenetics.brapi1_3.observations.pr.o.Utils.OBSERVATIONS_LIST_INTENT_INSTANCE);
    }

    public static void showObservationsListActivity(
    @androidx.annotation.NonNull final android.app.Activity activity,
    final org.wheatgenetics.javalib.mstrdtl.Items items, final int requestCode)
    {
        activity.startActivityForResult(
            org.wheatgenetics.brapi1_3.observations.pr.o.Utils.observationsListIntent(
                activity, items),
            requestCode);
    }
}