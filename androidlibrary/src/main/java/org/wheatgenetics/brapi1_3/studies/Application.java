package org.wheatgenetics.brapi1_3.studies;

/**
 * Uses:
 * android.app.Application
 *
 * io.swagger.client.model.ObservationUnitPositionsResponse
 * io.swagger.client.model.ObservationUnitsResponse1
 * io.swagger.client.model.ObservationsResponse
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.ItemsProvider
 *
 * org.wheatgenetics.brapi1_3.studies.NewObservationsRequest
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
 * org.wheatgenetics.brapi1_3.studies.StudyLayoutRequest
 */
public class Application extends android.app.Application
implements org.wheatgenetics.javalib.mstrdtl.ItemsProvider
{
    private enum LastMadeItems { NONE, SLR, NOR, NOUR }

    // region Fields
    private org.wheatgenetics.brapi1_3.studies.Application.LastMadeItems lastMadeItems =
        org.wheatgenetics.brapi1_3.studies.Application.LastMadeItems.NONE;
    private org.wheatgenetics.javalib.mstrdtl.Items items = null;
    // endregion

    // region org.wheatgenetics.javalib.mstrdtl.ItemsProvider Overridden Method
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Items mstrdtlItems()
    {
        switch (this.lastMadeItems)
        {
            case NONE: if (null == this.items) return this.items;

            case SLR:
                if (this.items instanceof org.wheatgenetics.brapi1_3.studies.StudyLayoutRequest)
                    return this.items;

            case NOR:
                if (this.items instanceof org.wheatgenetics.brapi1_3.studies.NewObservationsRequest)
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
        this.items = new org.wheatgenetics.brapi1_3.studies.StudyLayoutRequest(
            observationUnitPositionsResponse);
        this.lastMadeItems = org.wheatgenetics.brapi1_3.studies.Application.LastMadeItems.SLR;
    }

    public void makeNewObservationsRequest(
    final io.swagger.client.model.ObservationsResponse observationsResponse)
    {
        this.items = new org.wheatgenetics.brapi1_3.studies.NewObservationsRequest(
            observationsResponse);
        this.lastMadeItems = org.wheatgenetics.brapi1_3.studies.Application.LastMadeItems.NOR;
    }

    public void makeNewObservationUnitRequests(
    final io.swagger.client.model.ObservationUnitsResponse1 observationUnitsResponse1)
    {
        this.items = new org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests(
            observationUnitsResponse1);
        this.lastMadeItems = org.wheatgenetics.brapi1_3.studies.Application.LastMadeItems.NOUR;
    }
    // endregion
}