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
class StudiesStudyDbIdObservationunitsPutAlertDialog
extends org.wheatgenetics.brapi1_3.AlertDialog
{
    static class Parameters
    {
        private java.lang.String operator, uploadedBy;

        // region Getter Package Methods
        java.lang.String getOperator  () { return this.operator  ; }
        java.lang.String getUploadedBy() { return this.uploadedBy; }
        // endregion
    }

    // region Fields
    private android.widget.EditText operatorEditText, uploadedByEditText;

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdObservationunitsPutAlertDialog.Parameters parameters = null;
    // endregion

    StudiesStudyDbIdObservationunitsPutAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdObservationunitsPutAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle("StudiesApi.studiesStudyDbIdObservationunitsPut()");
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_studies_studies_studydbid_observationunits_put);
            if (null != view)
            {
                if (null == this.operatorEditText) this.operatorEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id
                        .studiesStudiesStudyDbIdObservationunitsPutOperatorEditText);
                if (null == this.uploadedByEditText) this.uploadedByEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id
                        .studiesStudiesStudyDbIdObservationunitsPutUploadedByEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.parameters)
        {
            this.parameters.operator = org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.StudiesStudyDbIdObservationunitsPutAlertDialog.getEditTextStringText(
                    this.operatorEditText);
            this.parameters.uploadedBy = org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.StudiesStudyDbIdObservationunitsPutAlertDialog.getEditTextStringText(
                    this.uploadedByEditText);

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .StudiesStudyDbIdObservationunitsPutAlertDialog.Parameters parameters)
    {
        if (null != parameters)
        {
            this.parameters = parameters;

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdObservationunitsPutAlertDialog.setEditTextText(
                    this.operatorEditText, this.parameters.getOperator());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdObservationunitsPutAlertDialog.setEditTextText(
                    this.uploadedByEditText, this.parameters.getUploadedBy());

            this.show();
        }
    }
}