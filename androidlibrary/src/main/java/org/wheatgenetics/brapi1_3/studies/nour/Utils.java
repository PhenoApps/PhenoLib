package org.wheatgenetics.brapi1_3.studies.nour;

/**
 * Uses:
 * android.app.Application
 * android.support.annotation.IntRange
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.ItemsProvider
 *
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
 * org.wheatgenetics.brapi1_3.studies.nour.Observations
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
class Utils extends java.lang.Object
{
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
}