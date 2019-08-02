package org.wheatgenetics.brapi1_3;

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
 * org.wheatgenetics.brapi1_3.observations.pr.o.Observations
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData
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
    private enum LastMadeItems { NONE, SLR, NOR, NOUR, PR }

    // region Fields
    private org.wheatgenetics.brapi1_3.Application.LastMadeItems lastMadeItems =
        org.wheatgenetics.brapi1_3.Application.LastMadeItems.NONE;
    private org.wheatgenetics.javalib.mstrdtl.Items items = null;

    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        private int newObservationUnitRequestPosition, phenotypesRequestDataPosition;
    // endregion

    // region Private Methods
    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
    newObservationUnitRequest()
    {
        final org.wheatgenetics.javalib.mstrdtl.Item item;
        {
            final org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
                newObservationUnitRequests =
                    (org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests)
                        this.mstrdtlItems();                    // throws java.lang.RuntimeException
            item = newObservationUnitRequests.get(this.newObservationUnitRequestPosition);
        }
        if (item instanceof org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest)
            return (org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest) item;
        else
            return null;
    }

    private org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData phenotypesRequestData()
    {
        final org.wheatgenetics.javalib.mstrdtl.Item item;
        {
            final org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest phenotypesRequest =
                (org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest)
                    this.mstrdtlItems();                        // throws java.lang.RuntimeException
            item = phenotypesRequest.get(this.phenotypesRequestDataPosition);
        }
        if (item instanceof org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData)
            return (org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData) item;
        else
            return null;
    }
    // endregion

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

            case PR: if (this.items instanceof
                org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest)
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
        this.lastMadeItems = org.wheatgenetics.brapi1_3.Application.LastMadeItems.SLR;
    }

    public void makeNewObservationsRequest(
    final io.swagger.client.model.ObservationsResponse observationsResponse)
    {
        this.items = new org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest(
            observationsResponse);
        this.lastMadeItems = org.wheatgenetics.brapi1_3.Application.LastMadeItems.NOR;
    }

    // region studies.nour Public Methods
    public void makeNewObservationUnitRequests(
    final io.swagger.client.model.ObservationUnitsResponse1 observationUnitsResponse1)
    {
        this.items = new org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests(
            observationUnitsResponse1);
        this.lastMadeItems = org.wheatgenetics.brapi1_3.Application.LastMadeItems.NOUR;
    }

    public void setNewObservationUnitRequestPosition(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int newObservationUnitRequestPosition)
    { this.newObservationUnitRequestPosition = newObservationUnitRequestPosition; }

    public org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefs
    getObservationUnitXrefsAsItems()
    {
        final org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
            newObservationUnitRequest = this.newObservationUnitRequest();
        return null == newObservationUnitRequest ? null :
            newObservationUnitRequest.getObservationUnitXrefsAsItems();
    }

    public org.wheatgenetics.brapi1_3.studies.nour.o.Observations getNOURObservationsAsItems()
    {
        final org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
            newObservationUnitRequest = this.newObservationUnitRequest();
        return null == newObservationUnitRequest ? null :
            newObservationUnitRequest.getObservationsAsItems();
    }

    public org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments
    getObservationTreatmentsAsItems()
    {
        final org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
            newObservationUnitRequest = this.newObservationUnitRequest();
        return null == newObservationUnitRequest ? null :
            newObservationUnitRequest.getObservationTreatmentsAsItems();
    }
    // endregion

    // region observations.pr Public Methods
    public void makePhenotypesRequest(
    final org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest phenotypesRequest)
    {
        if (null == phenotypesRequest)
            this.items = new org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest();
        else
            this.items = phenotypesRequest;
        this.lastMadeItems = org.wheatgenetics.brapi1_3.Application.LastMadeItems.PR;
    }

    public void setPhenotypesRequestDataPosition(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int phenotypesRequestDataPosition)
    { this.phenotypesRequestDataPosition = phenotypesRequestDataPosition; }

    public org.wheatgenetics.brapi1_3.observations.pr.o.Observations getPRObservationsAsItems()
    {
        final org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData
            phenotypesRequestData = this.phenotypesRequestData();
        return null == phenotypesRequestData ? null :
            phenotypesRequestData.getObservationsAsItems();
    }
    // endregion
    // endregion
}