package org.wheatgenetics.brapi1_3.studies;

/**
 * Uses:
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsItemActivity
 */
class NewObservationsRequestObservationsOnePaneAdapter
extends org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
{
    NewObservationsRequestObservationsOnePaneAdapter(
    final org.wheatgenetics.javalib.mstrdtl.Items items) { super(items); }

    @java.lang.Override protected java.lang.Class concreteItemActivityClass()
    {
        return org.wheatgenetics.brapi1_3.studies
            .NewObservationsRequestObservationsItemActivity.class;
    }
}