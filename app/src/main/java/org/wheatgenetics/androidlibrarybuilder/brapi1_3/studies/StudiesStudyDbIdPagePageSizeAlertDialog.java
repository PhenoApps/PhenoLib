package org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies;

/**
 * Uses:
 * android.app.Activity
 * android.view.View
 * android.widget.EditText
 *
 * org.wheatgenetics.brapi1_3.PagedAlertDialog
 * org.wheatgenetics.brapi1_3.PagedAlertDialog.Handler
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 */
class StudiesStudyDbIdPagePageSizeAlertDialog extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    static class Parameters
    {
        // region Fields
        private java.lang.String  studyDbId     ;
        private java.lang.Integer page, pageSize;
        // endregion

        // region Getter Package Methods
        java.lang.String getStudyDbId() { return this.studyDbId; }

        java.lang.Integer getPage    () { return this.page    ; }
        java.lang.Integer getPageSize() { return this.pageSize; }
        // endregion
    }

    // region Fields
    private java.lang.String        title            ;
    private android.widget.EditText studyDbIdEditText;

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdPagePageSizeAlertDialog.Parameters parameters = null;
    // endregion

    StudiesStudyDbIdPagePageSizeAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.PagedAlertDialog.Handler handler, final java.lang.String title)
    { super(activity, handler); this.title = title; }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(this.title);
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_studies_studydbid_page_pagesize);

            assert null != view; if (null == this.studyDbIdEditText) this.studyDbIdEditText =
                view.findViewById(org.wheatgenetics.androidlibrarybuilder
                    .R.id.studiesStudyDbIdPagePageSizeStudyDbIdEditText);
            this.findPageEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                .R.id.studiesStudyDbIdPagePageSizePageEditText);
            this.findPageSizeEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                .R.id.studiesStudyDbIdPagePageSizePageSizeEditText);

            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.parameters)
        {
            this.parameters.studyDbId = org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdPagePageSizeAlertDialog.getEditTextStringText(
                    this.studyDbIdEditText);
            this.parameters.page     = this.getPageEditTextIntText    ();
            this.parameters.pageSize = this.getPageSizeEditTextIntText();

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .StudiesStudyDbIdPagePageSizeAlertDialog.Parameters parameters)
    {
        if (null != parameters)
        {
            this.parameters = parameters;

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdPagePageSizeAlertDialog.setEditTextText(
                    this.studyDbIdEditText, this.parameters.getStudyDbId());
            this.setPageEditTextText    (this.parameters.getPage    ());
            this.setPageSizeEditTextText(this.parameters.getPageSize());

            this.show();
        }
    }
}