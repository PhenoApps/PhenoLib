package org.wheatgenetics.brapi1_3;

/**
 * Uses:
 * android.app.Application
 * android.support.annotation.IntRange
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.ItemsProvider
 *
 * org.wheatgenetics.brapi1_3.observations.pr.o.Observations
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData
 */
public class Application extends android.app.Application
implements org.wheatgenetics.javalib.mstrdtl.ItemsProvider
{
    private enum LastMadeItems { NONE, PR }

    // region Fields
    private org.wheatgenetics.brapi1_3.Application.LastMadeItems lastMadeItems =
        org.wheatgenetics.brapi1_3.Application.LastMadeItems.NONE;
    private org.wheatgenetics.javalib.mstrdtl.Items items = null;

    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
    private int phenotypesRequestDataPosition;
    // endregion

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

    // region org.wheatgenetics.javalib.mstrdtl.ItemsProvider Overridden Method
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Items mstrdtlItems()
    {
        switch (this.lastMadeItems)
        {
            case NONE: if (null == this.items) return this.items;

            case PR: if (this.items instanceof
            org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest) return this.items;
        }
        throw new java.lang.RuntimeException(
            "Proper make*() was not called before mstrdtlItems() was called");
    }
    // endregion

    // region Public Methods
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
}