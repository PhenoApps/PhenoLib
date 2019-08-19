package org.wheatgenetics.brapi1_3.studies.slr;                           // slr: StudyLayoutRequest

/**
 * Uses:
 * android.app.Application
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.StudyLayoutRequestLayout
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.ItemsProvider
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger
 * org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
 * org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutOnePaneAdapter
 */
public class StudyLayoutRequestListActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items itemsInstance = null;               // lazy load
    private org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
        studyLayoutRequestLayoutAlertDialogInstance = null;                             // lazy load
    // endregion

    private org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
    studyLayoutRequestLayoutAlertDialog()
    {
        if (null == this.studyLayoutRequestLayoutAlertDialogInstance)
            this.studyLayoutRequestLayoutAlertDialogInstance =
                new org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog(
                    this, new org.wheatgenetics.brapi1_3.studies
                    .slr.StudyLayoutRequestLayoutAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestListActivity
                                .this.refreshSinceItemHasChanged();
                        }
                    });
        return this.studyLayoutRequestLayoutAlertDialogInstance;
    }

    // region Overridden Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance)
        {
            final android.app.Application application = this.getApplication();
            if (application instanceof org.wheatgenetics.javalib.mstrdtl.ItemsProvider)
                this.itemsInstance =
                    ((org.wheatgenetics.javalib.mstrdtl.ItemsProvider) application).mstrdtlItems();
        }
        return this.itemsInstance;
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    {
        return new org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutOnePaneAdapter(
            this.items());
    }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger Overridden Methods
    @java.lang.Override public void moveUp(@android.support.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {                                                                   // TODO: Move to superclass.
        final org.wheatgenetics.javalib.mstrdtl.Items items = this.items();
        if (null != items) { items.moveUp(position); this.refreshSinceItemsHaveChanged(); }
    }

    @java.lang.Override public void moveDown(@android.support.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {                                                                   // TODO: Move to superclass.
        final org.wheatgenetics.javalib.mstrdtl.Items items = this.items();
        if (null != items) { items.moveDown(position); this.refreshSinceItemsHaveChanged(); }
    }

    @java.lang.Override public void change(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.studyLayoutRequestLayoutAlertDialog().show(
            (io.swagger.client.model.StudyLayoutRequestLayout) item);
    }
    // endregion
    // endregion
}