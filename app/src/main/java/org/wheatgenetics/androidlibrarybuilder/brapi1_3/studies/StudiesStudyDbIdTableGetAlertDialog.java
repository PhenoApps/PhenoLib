package org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies;

/**
 * Uses:
 * android.app.Activity
 * android.view.View
 * android.widget.EditText
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 */
class StudiesStudyDbIdTableGetAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    static class Parameters
    {
        private java.lang.String studyDbId, format;

        // region Getter Package Methods
        java.lang.String getStudyDbId() { return this.studyDbId; }
        java.lang.String getFormat   () { return this.format   ; }
        // endregion
    }

    // region Fields
    private android.widget.EditText studyDbIdEditText, formatEditText;

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdTableGetAlertDialog.Parameters parameters = null;
    // endregion

    StudiesStudyDbIdTableGetAlertDialog(final android.app.Activity activity, final org.wheatgenetics
        .androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdTableGetAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle("StudiesApi.studiesStudyDbIdTableGet()");
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_studies_studies_studydbid_table_get);
            if (null != view)
            {
                if (null == this.studyDbIdEditText) this.studyDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudiesStudyDbIdTableGetStudyDbIdEditText);
                if (null == this.formatEditText) this.formatEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudiesStudyDbIdTableGetFormatEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.parameters)
        {
            this.parameters.studyDbId = org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdTableGetAlertDialog.getEditTextStringText(this.studyDbIdEditText);
            this.parameters.format = org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdTableGetAlertDialog.getEditTextStringText(this.formatEditText);

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .StudiesStudyDbIdTableGetAlertDialog.Parameters parameters)
    {
        if (null != parameters)
        {
            this.parameters = parameters;

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdTableGetAlertDialog.setEditTextText(
                this.studyDbIdEditText, this.parameters.getStudyDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdTableGetAlertDialog.setEditTextText(
                    this.formatEditText, this.parameters.getFormat());

            this.show();
        }
    }
}