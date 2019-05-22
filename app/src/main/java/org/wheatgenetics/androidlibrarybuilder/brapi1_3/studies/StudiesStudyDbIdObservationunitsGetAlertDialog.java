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
class StudiesStudyDbIdObservationunitsGetAlertDialog
extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    static class Parameters
    {
        // region Fields
        private java.lang.String  studyDbId, observationLevel;
        private java.lang.Integer page     , pageSize        ;
        // endregion

        // region Getter Package Methods
        java.lang.String  getStudyDbId       () { return this.studyDbId       ; }
        java.lang.String  getObservationLevel() { return this.observationLevel; }
        java.lang.Integer getPage            () { return this.page            ; }
        java.lang.Integer getPageSize        () { return this.pageSize        ; }
        // endregion
    }

    // region Fields
    private android.widget.EditText studyDbIdEditText, observationLevelEditText;

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdObservationunitsGetAlertDialog.Parameters parameters = null;
    // endregion

    StudiesStudyDbIdObservationunitsGetAlertDialog(final android.app.Activity activity, final
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdObservationunitsGetAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle("StudiesApi.studiesStudyDbIdObservationunitsGet()");
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_studies_studies_studydbid_observationunits_get);
            if (null != view)
            {
                if (null == this.studyDbIdEditText) this.studyDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id
                        .studiesStudiesStudyDbIdObservationunitsGetStudyDbIdEditText);
                if (null == this.observationLevelEditText) this.observationLevelEditText =
                    view.findViewById(org.wheatgenetics.androidlibrarybuilder.R.id
                        .studiesStudiesStudyDbIdObservationunitsGetObservationLevelEditText);
                this.findPageEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                    .R.id.studiesStudiesStudyDbIdObservationunitsGetPageEditText);
                this.findPageSizeEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                    .R.id.studiesStudiesStudyDbIdObservationunitsGetPageSizeEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.parameters)
        {
            this.parameters.studyDbId = org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.StudiesStudyDbIdObservationunitsGetAlertDialog.getEditTextStringText(
                    this.studyDbIdEditText);
            this.parameters.observationLevel = org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.StudiesStudyDbIdObservationunitsGetAlertDialog.getEditTextStringText(
                    this.observationLevelEditText);
            this.parameters.page     = this.getPageEditTextIntText    ();
            this.parameters.pageSize = this.getPageSizeEditTextIntText();

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .StudiesStudyDbIdObservationunitsGetAlertDialog.Parameters parameters)
    {
        if (null != parameters)
        {
            this.parameters = parameters;

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdObservationunitsGetAlertDialog.setEditTextText(
                    this.studyDbIdEditText, this.parameters.getStudyDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .StudiesStudyDbIdObservationunitsGetAlertDialog.setEditTextText(
                    this.observationLevelEditText, this.parameters.getObservationLevel());
            this.setPageEditTextText    (this.parameters.getPage    ());
            this.setPageSizeEditTextText(this.parameters.getPageSize());

            this.show();
        }
    }
}