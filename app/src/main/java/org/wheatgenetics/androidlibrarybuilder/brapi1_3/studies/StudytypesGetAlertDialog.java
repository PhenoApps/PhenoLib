package org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies;

/**
 * Uses:
 * android.app.Activity
 * android.view.View
 * android.widget.EditText
 *
 * org.wheatgenetics.brapi1_3.PagedAlertDialog
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 */
class StudytypesGetAlertDialog extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    static class Parameters
    {
        // region Fields
        private java.lang.String  studyTypeDbId;
        private java.lang.Integer page, pageSize;
        // endregion

        // region Getter Package Methods
        java.lang.String getStudyTypeDbId() { return this.studyTypeDbId; }

        java.lang.Integer getPage    () { return this.page    ; }
        java.lang.Integer getPageSize() { return this.pageSize; }
        // endregion
    }

    // region Fields
    private android.widget.EditText studyTypeDbIdEditText;

    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudytypesGetAlertDialog.Parameters
            parameters = null;
    // endregion

    StudytypesGetAlertDialog(final android.app.Activity activity, final
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudytypesGetAlertDialog.Handler
        handler) { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle("StudiesApi.studytypesGet()");
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_studies_studytypes_get);
            if (null != view)
            {
                if (null == this.studyTypeDbIdEditText) this.studyTypeDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrarybuilder
                        .R.id.studytypesGetStudyTypeDbIdEditText);
                this.findPageEditTextById(view,
                    org.wheatgenetics.androidlibrarybuilder.R.id.studytypesGetPageEditText);
                this.findPageSizeEditTextById(view,
                    org.wheatgenetics.androidlibrarybuilder.R.id.studytypesGetPageSizeEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.parameters)
        {
            this.parameters.studyTypeDbId = org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudytypesGetAlertDialog.getEditTextStringText(this.studyTypeDbIdEditText);
            this.parameters.page     = this.getPageEditTextIntText    ();
            this.parameters.pageSize = this.getPageSizeEditTextIntText();

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudytypesGetAlertDialog.Parameters
        parameters)
    {
        if (null != parameters)
        {
            this.parameters = parameters;

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudytypesGetAlertDialog
                .setEditTextText(this.studyTypeDbIdEditText, this.parameters.getStudyTypeDbId());
            this.setPageEditTextText    (this.parameters.getPage    ());
            this.setPageSizeEditTextText(this.parameters.getPageSize());

            this.show();
        }
    }
}