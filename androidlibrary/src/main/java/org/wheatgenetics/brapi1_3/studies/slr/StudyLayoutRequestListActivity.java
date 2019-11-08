package org.wheatgenetics.brapi1_3.studies.slr;                           // slr: StudyLayoutRequest

/**
 * Uses:
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.StudyLayoutRequestLayout
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequest
 * org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
 * org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutOnePaneAdapter
 */
public class StudyLayoutRequestListActivity
extends org.wheatgenetics.androidlibrary.mstrdtl.ChangeableListActivity
{
    // region Fields
    private org.wheatgenetics.javalib.mstrdtl.Items               itemsInstance = null; // lazy load
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
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override @androidx.annotation.NonNull
    protected org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        if (null == this.itemsInstance) this.itemsInstance =
            new org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequest().fromJson(
                this.getJson());
        return this.itemsInstance;
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter()
    {
        return new org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutOnePaneAdapter(
            this.items());
    }

    @java.lang.Override public void change(
    @androidx.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    {
        this.studyLayoutRequestLayoutAlertDialog().show(
            (io.swagger.client.model.StudyLayoutRequestLayout) item);
    }
    // endregion
}