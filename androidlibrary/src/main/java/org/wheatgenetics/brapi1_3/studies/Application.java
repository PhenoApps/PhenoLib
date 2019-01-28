package org.wheatgenetics.brapi1_3.studies;

/**
 * Uses:
 * android.app.Application
 *
 * io.swagger.client.model.ObservationUnitPositionsResponse
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.ItemsProvider
 *
 * org.wheatgenetics.brapi1_3.studies.StudyLayoutRequest
 */
public class Application extends android.app.Application
implements org.wheatgenetics.javalib.mstrdtl.ItemsProvider
{
    private org.wheatgenetics.brapi1_3.studies.StudyLayoutRequest studyLayoutRequest = null;

    // region org.wheatgenetics.javalib.mstrdtl.ItemsProvider Overridden Method
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Items mstrdtlItems()
    { return this.studyLayoutRequest; }
    // endregion

    public void makeStudyLayoutRequest(
    final io.swagger.client.model.ObservationUnitPositionsResponse observationUnitPositionsResponse)
    {
        this.studyLayoutRequest = new
            org.wheatgenetics.brapi1_3.studies.StudyLayoutRequest(observationUnitPositionsResponse);
    }
}