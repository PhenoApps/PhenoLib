package org.wheatgenetics.brapi1_3.studies;     // TODO: Move to package NewObservationUnitRequests.

/**
 * Uses:
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestItemActivity
 */
class NewObservationUnitRequestOnePaneAdapter
extends org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
{
    NewObservationUnitRequestOnePaneAdapter(final org.wheatgenetics.javalib.mstrdtl.Items items)
    { super(items); }

    @java.lang.Override protected java.lang.Class concreteItemActivityClass()
    { return org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestItemActivity.class; }
}