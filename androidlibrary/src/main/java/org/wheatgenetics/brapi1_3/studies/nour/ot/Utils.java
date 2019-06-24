package org.wheatgenetics.brapi1_3.studies.nour.ot;              // nour: NewObservationUnitRequests

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
 * org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments
 *
 * org.wheatgenetics.brapi1_3.studies.nour.Consts
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
 *
 * org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentsListActivity
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Utils extends java.lang.Object
{
    private static android.content.Intent TREATMENTS_LIST_INTENT_INSTANCE = null;       // lazy load

    private static android.content.Intent treatmentsListIntent(final android.app.Activity activity)
    {
        if (null ==
        org.wheatgenetics.brapi1_3.studies.nour.ot.Utils.TREATMENTS_LIST_INTENT_INSTANCE)
            org.wheatgenetics.brapi1_3.studies.nour.ot.Utils.TREATMENTS_LIST_INTENT_INSTANCE =
                new android.content.Intent(activity,
                    org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentsListActivity.class);
        return
            org.wheatgenetics.brapi1_3.studies.nour.ot.Utils.TREATMENTS_LIST_INTENT_INSTANCE;
    }

    static org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments getTreatmentsAsItems(
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
                    return newObservationUnitRequest.getTreatmentsAsItems();
                }
                else return null;
            }
            else return null;
        }
        else return null;
    }

    public static void showTreatmentsListActivity(
    @android.support.annotation.NonNull final android.app.Activity activity,
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        final android.content.Intent treatmentsListIntent =
            org.wheatgenetics.brapi1_3.studies.nour.ot.Utils.treatmentsListIntent(activity);
        if (null != treatmentsListIntent) treatmentsListIntent.putExtra(
            org.wheatgenetics.brapi1_3.studies.nour.Consts.POSITION_KEY, position);
        activity.startActivityForResult(treatmentsListIntent,
            org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentsListActivity.REQUEST_CODE);
    }
}