package org.wheatgenetics.brapi1_3.studies.nour.ot;              // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentItemActivity
 */
class TreatmentOnePaneAdapter extends org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
{
    TreatmentOnePaneAdapter(final org.wheatgenetics.javalib.mstrdtl.Items items) { super(items); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class concreteItemActivityClass()
    { return org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentItemActivity.class; }
}