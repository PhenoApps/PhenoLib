package org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies;

/**
 * Uses:
 * android.app.Activity
 * android.view.View
 * android.widget.EditText
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.brapi1_3.PagedAlertDialog
 */
class StudiesStudyDbIdObservationsGetAlertDialog extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    static class Parameters
    {
        // region Fields
        private java.lang.String                 studyDbId               ;
        private java.util.List<java.lang.String> observationVariableDbIds;
        private java.lang.Integer                page, pageSize          ;
        // endregion

        // region Getter Package Methods
        java.lang.String getStudyDbId() { return this.studyDbId; }

        java.util.List<java.lang.String> getObservationVariableDbIds()
        { return this.observationVariableDbIds; }

        java.lang.Integer getPage    () { return this.page    ; }
        java.lang.Integer getPageSize() { return this.pageSize; }
        // endregion
    }

    // region Fields
    private android.widget.EditText studyDbIdEditText, observationVariableDbIdsEditText;

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdObservationsGetAlertDialog.Parameters parameters = null;
    // endregion

    StudiesStudyDbIdObservationsGetAlertDialog(final android.app.Activity activity, final
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdObservationsGetAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle("StudiesApi.studiesStudyDbIdObservationsGet()");
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_studies_studies_studydbid_observations_get);
            if (null != view)
            {
                if (null == this.studyDbIdEditText) this.studyDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id
                        .studiesStudiesStudyDbIdObservationsGetStudyDbIdEditText);
                if (null == this.observationVariableDbIdsEditText)
                    this.observationVariableDbIdsEditText = view.findViewById(
                        org.wheatgenetics.androidlibrarybuilder.R.id
                            .studiesStudiesStudyDbIdObservationsGetObservationVariableDbIdsEditText
                            );
                this.findPageEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                    .R.id.studiesStudiesStudyDbIdObservationsGetPageEditText);
                this.findPageSizeEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                    .R.id.studiesStudiesStudyDbIdObservationsGetPageSizeEditText);
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
                .StudiesStudyDbIdObservationsGetAlertDialog.getEditTextStringText(
                    this.studyDbIdEditText);
            this.parameters.observationVariableDbIds =
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .StudiesStudyDbIdObservationsGetAlertDialog.getEditTextStringListText(
                        this.observationVariableDbIdsEditText);
            this.parameters.page     = this.getPageEditTextIntText    ();
            this.parameters.pageSize = this.getPageSizeEditTextIntText();

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .StudiesStudyDbIdObservationsGetAlertDialog.Parameters parameters)
    {
        if (null != parameters)
        {
            this.parameters = parameters;

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdObservationsGetAlertDialog.setEditTextText(
                    this.studyDbIdEditText, this.parameters.getStudyDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdObservationsGetAlertDialog.setEditTextText(
                    this.observationVariableDbIdsEditText        ,
                    this.parameters.getObservationVariableDbIds());
            this.setPageEditTextText    (this.parameters.getPage    ());
            this.setPageSizeEditTextText(this.parameters.getPageSize());

            this.show();
        }
    }
}