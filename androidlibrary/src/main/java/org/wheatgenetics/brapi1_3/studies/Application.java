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
 * org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequests
 * org.wheatgenetics.brapi1_3.studies.StudyLayoutRequest
 */
public class Application extends android.app.Application
implements org.wheatgenetics.javalib.mstrdtl.ItemsProvider
{
    private org.wheatgenetics.javalib.mstrdtl.Items items = null;

    // region org.wheatgenetics.javalib.mstrdtl.ItemsProvider Overridden Method
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Items mstrdtlItems()
    { return this.items; }
    // endregion

    // region Public Methods
    public void makeStudyLayoutRequest(
    final io.swagger.client.model.ObservationUnitPositionsResponse observationUnitPositionsResponse)
    {
        this.items = new
            org.wheatgenetics.brapi1_3.studies.StudyLayoutRequest(observationUnitPositionsResponse);
    }

    public void makeNewObservationsRequest(
    final io.swagger.client.model.ObservationsResponse observationsResponse)
    {
        this.items =
            new org.wheatgenetics.brapi1_3.studies.NewObservationsRequest(observationsResponse);
    }

    public void makeNewObservationUnitRequests(
    final io.swagger.client.model.ObservationUnitsResponse1 observationUnitsResponse1)
    {
        this.items = new org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequests(
            observationUnitsResponse1);
    }
    // endregion
}