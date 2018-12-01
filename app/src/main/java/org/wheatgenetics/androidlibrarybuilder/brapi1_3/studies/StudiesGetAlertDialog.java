package org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.IdRes
 * android.view.View
 * android.widget.EditText
 * android.widget.RadioGroup
 *
 * org.wheatgenetics.brapi1_3.PagedAlertDialog
 * org.wheatgenetics.brapi1_3.PagedAlertDialog.Handler
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 */
class StudiesGetAlertDialog extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    static class Parameters
    {
        // region Fields
        private java.lang.String commonCropName, studyType, studyTypeDbId, programDbId,
            locationDbId, seasonDbId, trialDbId, studyDbId;
        private java.util.ArrayList<java.lang.String> germplasmDbIds, observationVariableDbIds;
        private java.lang.Boolean                     active                                  ;
        private java.lang.String                      sortBy        , sortOrder               ;
        private java.lang.Integer                     page          , pageSize                ;
        // endregion

        // region Getter Package Methods
        java.lang.String getCommonCropName() { return this.commonCropName; }
        java.lang.String getStudyType     () { return this.studyType     ; }
        java.lang.String getStudyTypeDbId () { return this.studyTypeDbId ; }
        java.lang.String getProgramDbId   () { return this.programDbId   ; }
        java.lang.String getLocationDbId  () { return this.locationDbId  ; }
        java.lang.String getSeasonDbId    () { return this.seasonDbId    ; }
        java.lang.String getTrialDbId     () { return this.trialDbId     ; }
        java.lang.String getStudyDbId     () { return this.studyDbId     ; }

        java.util.List<java.lang.String> getGermplasmDbIds() { return this.germplasmDbIds; }

        java.util.List<java.lang.String> getObservationVariableDbIds()
        { return this.observationVariableDbIds; }

        java.lang.Boolean getActive() { return this.active; }

        java.lang.String getSortBy   () { return this.sortBy   ; }
        java.lang.String getSortOrder() { return this.sortOrder; }

        java.lang.Integer getPage    () { return this.page    ; }
        java.lang.Integer getPageSize() { return this.pageSize; }
        // endregion
    }

    // region Fields
    private android.widget.EditText commonCropNameEditText, studyTypeEditText,
        studyTypeDbIdEditText, programDbIdEditText, locationDbIdEditText, seasonDbIdEditText,
        trialDbIdEditText, studyDbIdEditText, germplasmDbIdsEditText,
        observationVariableDbIdsEditText;
    private android.widget.RadioGroup activeRadioGroup                 ;
    private android.widget.EditText   sortByEditText, sortOrderEditText;

    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog.Parameters
            parameters = null;
    // endregion

    // region Private Methods
    private static void setRadioGroup(final android.widget.RadioGroup radioGroup,
    final java.lang.Boolean active)
    {
        if (null != radioGroup)
        {
            final @android.support.annotation.IdRes int id;
            if (null == active)
                id = org.wheatgenetics.androidlibrarybuilder
                    .R.id.studiesStudiesGetNullActiveRadioButton;
            else
                id = active ?
                    org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudiesGetTrueActiveRadioButton :
                    org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudiesGetFalseActiveRadioButton;
            radioGroup.check(id);
        }
    }

    private static java.lang.Boolean getRadioGroupChecked(
    final android.widget.RadioGroup radioGroup)
    {
        if (null == radioGroup)
            return null;
        else
            switch (radioGroup.getCheckedRadioButtonId())
            {
                case org.wheatgenetics.androidlibrarybuilder
                    .R.id.studiesStudiesGetFalseActiveRadioButton: return false;

                case org.wheatgenetics.androidlibrarybuilder
                    .R.id.studiesStudiesGetTrueActiveRadioButton: return true;

                default: return null;
            }
    }
    // endregion

    StudiesGetAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.PagedAlertDialog.Handler handler) { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle("StudiesApi.studiesGet()");
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_studies_studies_get);

            assert null != view;
            if (null == this.commonCropNameEditText)
                this.commonCropNameEditText = view.findViewById(org.wheatgenetics
                    .androidlibrarybuilder.R.id.studiesStudiesGetCommonCropNameEditText);
            if (null == this.studyTypeEditText) this.studyTypeEditText = view.findViewById(org
                .wheatgenetics.androidlibrarybuilder.R.id.studiesStudiesGetStudyTypeEditText);
            if (null == this.studyTypeDbIdEditText) this.studyTypeDbIdEditText = view.findViewById(
                org.wheatgenetics.androidlibrarybuilder
                    .R.id.studiesStudiesGetStudyTypeDbIdEditText);
            if (null == this.programDbIdEditText) this.programDbIdEditText = view.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudiesGetProgramDbIdEditText);
            if (null == this.locationDbIdEditText) this.locationDbIdEditText = view.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudiesGetLocationDbIdEditText);
            if (null == this.seasonDbIdEditText) this.seasonDbIdEditText = view.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudiesGetSeasonDbIdEditText);
            if (null == this.trialDbIdEditText) this.trialDbIdEditText = view.findViewById(org
                .wheatgenetics.androidlibrarybuilder.R.id.studiesStudiesGetTrialDbIdEditText);
            if (null == this.studyDbIdEditText) this.studyDbIdEditText = view.findViewById(org
                .wheatgenetics.androidlibrarybuilder.R.id.studiesStudiesGetStudyDbIdEditText);
            if (null == this.germplasmDbIdsEditText)
                this.germplasmDbIdsEditText = view.findViewById(org.wheatgenetics
                    .androidlibrarybuilder.R.id.studiesStudiesGetGermplasmDbIdsEditText);
            if (null == this.observationVariableDbIdsEditText)
                this.observationVariableDbIdsEditText = view.findViewById(org.wheatgenetics
                    .androidlibrarybuilder.R.id.studiesStudiesGetObservationVariableDbIdsEditText);

            if (null == this.activeRadioGroup) this.activeRadioGroup = view.findViewById(org
                .wheatgenetics.androidlibrarybuilder.R.id.studiesStudiesGetActiveRadioGroup);

            if (null == this.sortByEditText) this.sortByEditText = view.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudiesGetSortByEditText);
            if (null == this.sortOrderEditText) this.sortOrderEditText = view.findViewById(org
                .wheatgenetics.androidlibrarybuilder.R.id.studiesStudiesGetSortOrderEditText);

            this.findPageEditTextById(view,
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudiesGetPageEditText);
            this.findPageSizeEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                .R.id.studiesStudiesGetPageSizeEditText);

            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.parameters)
        {
            this.parameters.commonCropName = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getEditTextStringText(
                    this.commonCropNameEditText);
            this.parameters.studyType = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getEditTextStringText(
                    this.studyTypeEditText);
            this.parameters.studyTypeDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getEditTextStringText(
                    this.studyTypeDbIdEditText);
            this.parameters.programDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getEditTextStringText(
                    this.programDbIdEditText);
            this.parameters.locationDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getEditTextStringText(
                    this.locationDbIdEditText);
            this.parameters.seasonDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getEditTextStringText(
                    this.seasonDbIdEditText);
            this.parameters.trialDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getEditTextStringText(
                    this.trialDbIdEditText);
            this.parameters.studyDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getEditTextStringText(
                    this.studyDbIdEditText);

            this.parameters.germplasmDbIds = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getEditTextStringListText(
                    this.germplasmDbIdsEditText);
            this.parameters.observationVariableDbIds = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getEditTextStringListText(
                    this.observationVariableDbIdsEditText);

            this.parameters.active = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getRadioGroupChecked(this.activeRadioGroup);

            this.parameters.sortBy = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getEditTextStringText(this.sortByEditText);
            this.parameters.sortOrder = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudiesGetAlertDialog.getEditTextStringText(
                    this.sortOrderEditText);

            this.parameters.page     = this.getPageEditTextIntText    ();
            this.parameters.pageSize = this.getPageSizeEditTextIntText();

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(
    final org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog.Parameters
        parameters)
    {
        if (null != parameters)
        {
            this.parameters = parameters;

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setEditTextText(this.commonCropNameEditText, this.parameters.getCommonCropName());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setEditTextText(this.studyTypeEditText, this.parameters.getStudyType());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setEditTextText(this.studyTypeDbIdEditText, this.parameters.getStudyTypeDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setEditTextText(this.programDbIdEditText, this.parameters.getProgramDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setEditTextText(this.locationDbIdEditText, this.parameters.getLocationDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setEditTextText(this.seasonDbIdEditText, this.parameters.getSeasonDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setEditTextText(this.trialDbIdEditText, this.parameters.getTrialDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setEditTextText(this.studyDbIdEditText, this.parameters.getStudyDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setEditTextText(this.germplasmDbIdsEditText, this.parameters.getGermplasmDbIds());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setEditTextText(this.observationVariableDbIdsEditText,
                    this.parameters.getObservationVariableDbIds());

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setRadioGroup(this.activeRadioGroup, this.parameters.getActive());

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setEditTextText(this.sortByEditText, this.parameters.getSortBy());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
                .setEditTextText(this.sortOrderEditText, this.parameters.getSortOrder());

            this.setPageEditTextText    (this.parameters.getPage    ());
            this.setPageSizeEditTextText(this.parameters.getPageSize());

            this.show();
        }
    }
}