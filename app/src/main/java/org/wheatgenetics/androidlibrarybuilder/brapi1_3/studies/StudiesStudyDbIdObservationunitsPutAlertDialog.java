package org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.Nullable
 * android.view.View
 * android.widget.EditText
 * android.widget.TextView
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 * org.wheatgenetics.brapi1_3.AlertDialog.Handler
 */
class StudiesStudyDbIdObservationunitsPutAlertDialog
extends org.wheatgenetics.brapi1_3.AlertDialog
{
    // region Types
    static class Parameters
    {
        private java.lang.String operator, uploadedBy;

        // region Getter Package Methods
        java.lang.String getOperator  () { return this.operator  ; }
        java.lang.String getUploadedBy() { return this.uploadedBy; }
        // endregion
    }

    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"})
    interface Handler extends org.wheatgenetics.brapi1_3.AlertDialog.Handler
    { public abstract java.lang.String getNewObservationUnitRequestsAsString(); }
    // endregion

    // region Fields
    private android.widget.EditText operatorEditText, uploadedByEditText;
    private android.widget.TextView debugTextView                       ;

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdObservationunitsPutAlertDialog.Parameters parameters = null;
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdObservationunitsPutAlertDialog.Handler specificHandlerInstance = null;// ll
    // endregion

    // region Private Methods
    @android.support.annotation.Nullable private org.wheatgenetics.androidlibrarybuilder.brapi1_3
    .studies.StudiesStudyDbIdObservationunitsPutAlertDialog.Handler specificHandler()
    {
        if (null == this.specificHandlerInstance)
        {
            final org.wheatgenetics.brapi1_3.AlertDialog.Handler genericHandler = this.getHandler();
            if (genericHandler instanceof org.wheatgenetics.androidlibrarybuilder
            .brapi1_3.studies.StudiesStudyDbIdObservationunitsPutAlertDialog.Handler)
                this.specificHandlerInstance = (org.wheatgenetics.androidlibrarybuilder.brapi1_3
                    .studies.StudiesStudyDbIdObservationunitsPutAlertDialog.Handler) genericHandler;
        }
        return this.specificHandlerInstance;
    }

    private void showNewObservationUnitRequests()
    {
        if (null != this.debugTextView)
        {
            final org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdObservationunitsPutAlertDialog.Handler specificHandler =
                    this.specificHandler();
            if (null != specificHandler)
                this.debugTextView.setText(specificHandler.getNewObservationUnitRequestsAsString());
        }
    }
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
                if (null == this.debugTextView) this.debugTextView = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id
                        .studiesStudiesStudyDbIdObservationunitsPutDebugTextView);
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
            this.showNewObservationUnitRequests();

            this.show();
        }
    }
}