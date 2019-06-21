package org.wheatgenetics.brapi1_3.studies.nour;

/**
 * Uses:
 * android.app.Activity
 * android.app.Application
 * android.content.Intent
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.ItemsProvider
 *
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
 * org.wheatgenetics.brapi1_3.studies.nour.Observations
 * org.wheatgenetics.brapi1_3.studies.nour.ObservationUnitXrefListActivity
 * org.wheatgenetics.brapi1_3.studies.nour.ObservationsListActivity
 * org.wheatgenetics.brapi1_3.studies.nour.TreatmentsListActivity
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"}) class Utils extends java.lang.Object
{
    static final java.lang.String POSITION_KEY = "position";

    private static android.content.Intent OBSERVATIONUNITXREF_LIST_INTENT_INSTANCE = null,  // lazy
        OBSERVATIONS_LIST_INTENT_INSTANCE = null, TREATMENTS_LIST_INTENT_INSTANCE = null;   // loads

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

    private static android.content.Intent observationsListIntent(
    final android.app.Activity activity)
    {
        if (null == org.wheatgenetics.brapi1_3.studies.nour.Utils.OBSERVATIONS_LIST_INTENT_INSTANCE)
            org.wheatgenetics.brapi1_3.studies.nour.Utils.OBSERVATIONS_LIST_INTENT_INSTANCE =
                new android.content.Intent(activity,
                    org.wheatgenetics.brapi1_3.studies.nour.ObservationsListActivity.class);
        return
            org.wheatgenetics.brapi1_3.studies.nour.Utils.OBSERVATIONS_LIST_INTENT_INSTANCE;
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
    // region showListActivity() Package Methods
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

    static void showObservationsListActivity(
    @android.support.annotation.NonNull final android.app.Activity activity,
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
    final int position)
    {
        final android.content.Intent observationsListIntent =
            org.wheatgenetics.brapi1_3.studies.nour.Utils.observationsListIntent(activity);
        if (null != observationsListIntent) observationsListIntent.putExtra(
            org.wheatgenetics.brapi1_3.studies.nour.Utils.POSITION_KEY, position);
        activity.startActivityForResult(observationsListIntent,
            org.wheatgenetics.brapi1_3.studies.nour.ObservationsListActivity.REQUEST_CODE);
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

    static org.wheatgenetics.brapi1_3.studies.nour.Observations getObservationsAsItems(
    final android.app.Application application,
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        if (application instanceof org.wheatgenetics.javalib.mstrdtl.ItemsProvider)
        {
            final org.wheatgenetics.javalib.mstrdtl.Items items;
            {
                final org.wheatgenetics.javalib.mstrdtl.ItemsProvider itemsProvider =
                    (org.wheatgenetics.javalib.mstrdtl.ItemsProvider) application;
                items = itemsProvider.mstrdtlItems();
            }
            if (items instanceof org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests)
            {
                final org.wheatgenetics.javalib.mstrdtl.Item item;
                {
                    final org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
                        newObservationUnitRequests =
                            (org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests)
                                items;
                    item = newObservationUnitRequests.get(position);
                }
                if (item instanceof
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest)
                {
                    final org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
                        newObservationUnitRequest =
                            (org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest)
                                item;
                    return newObservationUnitRequest.getObservationsAsItems();
                }
                else return null;
            }
            else return null;
        }
        else return null;
    }
    // endregion
}