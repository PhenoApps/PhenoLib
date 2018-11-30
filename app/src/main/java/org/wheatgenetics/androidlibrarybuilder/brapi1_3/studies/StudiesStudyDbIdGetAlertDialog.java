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
 * org.wheatgenetics.brapi1_3.AlertDialog.Handler
 */
class StudiesStudyDbIdGetAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    static class StudyDbIdGetParameters
    {
        private java.lang.String studyDbId;

        java.lang.String getStudyDbId() { return this.studyDbId; }
    }

    // region Fields
    private android.widget.EditText studyDbIdEditText;
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdGetAlertDialog.StudyDbIdGetParameters studyDbIdGetParameters = null;
    // endregion

    StudiesStudyDbIdGetAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.AlertDialog.Handler handler) { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle("StudiesApi.studiesStudyDbIdGet()");
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_studies_studies_studydbid_get);

            assert null != view;
            if (null == this.studyDbIdEditText) this.studyDbIdEditText = view.findViewById(
                org.wheatgenetics.androidlibrarybuilder
                    .R.id.studiesStudiesStudyDbIdGetStudyDbIdEditText);

            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.studyDbIdGetParameters)
        {
            this.studyDbIdGetParameters.studyDbId = org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.StudiesStudyDbIdGetAlertDialog.getEditTextStringText(
                    this.studyDbIdEditText);

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .StudiesStudyDbIdGetAlertDialog.StudyDbIdGetParameters studyDbIdGetParameters)
    {
        if (null != studyDbIdGetParameters)
        {
            this.studyDbIdGetParameters = studyDbIdGetParameters;

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdGetAlertDialog
                .setEditTextText(this.studyDbIdEditText,
                    this.studyDbIdGetParameters.getStudyDbId());

            this.show();
        }
    }
}