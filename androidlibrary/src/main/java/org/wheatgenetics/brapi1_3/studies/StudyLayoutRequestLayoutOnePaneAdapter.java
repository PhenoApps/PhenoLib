package org.wheatgenetics.brapi1_3.studies;             // TODO: Move to StudyLayoutRequest package.

/**
 * Uses:
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.StudyLayoutRequestLayoutItemActivity
 */
class StudyLayoutRequestLayoutOnePaneAdapter
extends org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
{
    StudyLayoutRequestLayoutOnePaneAdapter(final org.wheatgenetics.javalib.mstrdtl.Items items)
    { super(items); }

    @java.lang.Override protected java.lang.Class concreteItemActivityClass()
    { return org.wheatgenetics.brapi1_3.studies.StudyLayoutRequestLayoutItemActivity.class; }
}