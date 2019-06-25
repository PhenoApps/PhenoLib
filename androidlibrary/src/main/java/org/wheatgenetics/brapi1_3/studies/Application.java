package org.wheatgenetics.brapi1_3.studies;

/**
 * Uses:
 * android.app.Application
 * android.support.annotation.IntRange
 *
 * io.swagger.client.model.ObservationUnitPositionsResponse
 * io.swagger.client.model.ObservationUnitsResponse1
 * io.swagger.client.model.ObservationsResponse
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.ItemsProvider
 *
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest
 *
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
 * org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefs
 * org.wheatgenetics.brapi1_3.studies.nour.o.Observations
 * org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments
 *
 * org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequest
 */
public class Application extends android.app.Application
implements org.wheatgenetics.javalib.mstrdtl.ItemsProvider
{
    private enum LastMadeItems { NONE, SLR, NOR, NOUR }

    // region Fields
    private org.wheatgenetics.brapi1_3.studies.Application.LastMadeItems lastMadeItems =
        org.wheatgenetics.brapi1_3.studies.Application.LastMadeItems.NONE;
    private org.wheatgenetics.javalib.mstrdtl.Items items = null;

    private org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefs
        observationUnitXrefsAsItemsInstance = null;
    private org.wheatgenetics.brapi1_3.studies.nour.o.Observations
        observationsAsItemsInstance = null;
    private org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments
        observationTreatmentsAsItemsInstance = null;
    // endregion

    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
    newObservationUnitRequest(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        final org.wheatgenetics.javalib.mstrdtl.Item item;
        {
            final org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
                newObservationUnitRequests =
                    (org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests)
                        this.mstrdtlItems();                    // throws java.lang.RuntimeException
            item = newObservationUnitRequests.get(position);
        }
        if (item instanceof org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest)
            return (org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest) item;
        else
            return null;
    }

    // region org.wheatgenetics.javalib.mstrdtl.ItemsProvider Overridden Method
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Items mstrdtlItems()
    {
        switch (this.lastMadeItems)
        {
            case NONE: if (null == this.items) return this.items;

            case SLR:
                if (this.items instanceof org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequest)
                    return this.items;

            case NOR: if (this.items instanceof
                org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest)
                    return this.items;

            case NOUR: if (this.items instanceof
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests)
                    return this.items;
        }
        throw new java.lang.RuntimeException(
            "Proper make*() was not called before mstrdtlItems() was called");
    }
    // endregion

    // region Public Methods
    public void makeStudyLayoutRequest(
    final io.swagger.client.model.ObservationUnitPositionsResponse observationUnitPositionsResponse)
    {
        this.items = new org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequest(
            observationUnitPositionsResponse);
        this.lastMadeItems = org.wheatgenetics.brapi1_3.studies.Application.LastMadeItems.SLR;
    }

    public void makeNewObservationsRequest(
    final io.swagger.client.model.ObservationsResponse observationsResponse)
    {
        this.items = new org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest(
            observationsResponse);
        this.lastMadeItems = org.wheatgenetics.brapi1_3.studies.Application.LastMadeItems.NOR;
    }

    // region nour Public Methods
    public void makeNewObservationUnitRequests(
    final io.swagger.client.model.ObservationUnitsResponse1 observationUnitsResponse1)
    {
        this.items = new org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests(
            observationUnitsResponse1);
        this.lastMadeItems = org.wheatgenetics.brapi1_3.studies.Application.LastMadeItems.NOUR;
    }

    // region nour.oux Public Methods
    public org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefs
    getObservationUnitXrefsAsItems(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        final org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
            newObservationUnitRequest = this.newObservationUnitRequest(position);
        this.observationUnitXrefsAsItemsInstance = null == newObservationUnitRequest ?
            null : newObservationUnitRequest.getObservationUnitXrefsAsItems();
        return this.observationUnitXrefsAsItemsInstance;
    }

    public org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefs
    getObservationsUnitXrefsAsItems() { return this.observationUnitXrefsAsItemsInstance; }
    // endregion

    // region nour.o Public Methods
    public org.wheatgenetics.brapi1_3.studies.nour.o.Observations getObservationsAsItems(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        final org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
            newObservationUnitRequest = this.newObservationUnitRequest(position);
        this.observationsAsItemsInstance = null == newObservationUnitRequest ?
            null : newObservationUnitRequest.getObservationsAsItems();
        return this.observationsAsItemsInstance;
    }

    public org.wheatgenetics.brapi1_3.studies.nour.o.Observations getObservationsAsItems()
    { return this.observationsAsItemsInstance; }
    // endregion

    // region nour.o Public Methods
    public org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments
    getObservationTreatmentsAsItems(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        final org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
            newObservationUnitRequest = this.newObservationUnitRequest(position);
        this.observationTreatmentsAsItemsInstance = null == newObservationUnitRequest ?
            null : newObservationUnitRequest.getTreatmentsAsItems();
        return this.observationTreatmentsAsItemsInstance;
    }

    public org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments
    getObservationTreatmentsAsItems() { return this.observationTreatmentsAsItemsInstance; }
    // endregion
    // endregion
    // endregion
}