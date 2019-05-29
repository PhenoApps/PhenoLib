package org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations;

/**
 * Uses:
 * android.view.View
 * android.widget.EditText
 *
 * org.threeten.bp.OffsetDateTime
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.brapi1_3.PagedAlertDialog
 */
class ObservationunitsGetAlertDialog extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    static class Parameters
    {
        // region Fields
        private java.lang.String germplasmDbId, observationVariableDbId, studyDbId,
            locationDbId,trialDbId, programDbId, seasonDbId, observationLevel;
        private org.threeten.bp.OffsetDateTime observationTimeStampRangeStart,
            observationTimeStampRangeEnd;
        private java.lang.Integer page, pageSize;
        // endregion

        // region Getter Package Methods
        java.lang.String getGermplasmDbId          () { return this.germplasmDbId          ; }
        java.lang.String getObservationVariableDbId() { return this.observationVariableDbId; }
        java.lang.String getStudyDbId              () { return this.studyDbId              ; }
        java.lang.String getLocationDbId           () { return this.locationDbId           ; }
        java.lang.String getTrialDbId              () { return this.trialDbId              ; }
        java.lang.String getProgramDbId            () { return this.programDbId            ; }
        java.lang.String getSeasonDbId             () { return this.seasonDbId             ; }
        java.lang.String getObservationLevel       () { return this.observationLevel       ; }

        org.threeten.bp.OffsetDateTime getObservationTimeStampRangeStart()
        { return this.observationTimeStampRangeStart; }

        org.threeten.bp.OffsetDateTime getObservationTimeStampRangeEnd()
        { return this.observationTimeStampRangeEnd; }

        java.lang.Integer getPage    () { return this.page    ; }
        java.lang.Integer getPageSize() { return this.pageSize; }
        // endregion
    }

    // region Fields
    private android.widget.EditText germplasmDbIdEditText, observationVariableDbIdEditText,
        studyDbIdEditText, locationDbIdEditText, trialDbIdEditText, programDbIdEditText,
        seasonDbIdEditText, observationLevelEditText, observationTimeStampRangeStartEditText,
        observationTimeStampRangeEndEditText;

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
        .ObservationunitsGetAlertDialog.Parameters parameters = null;
    // endregion

    ObservationunitsGetAlertDialog(final android.app.Activity activity, final org.wheatgenetics
    .androidlibrarybuilder.brapi1_3.observations.ObservationunitsGetAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle("ObservationsApi.observationunitsGet()");
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_observations_observationunits_get);
            if (null != view)
            {
                if (null == this.germplasmDbIdEditText) this.germplasmDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrarybuilder.R.id
                        .observationsObservationunitsGetGermplasmDbIdEditText);
                if (null == this.observationVariableDbIdEditText)
                    this.observationVariableDbIdEditText = view.findViewById(
                        org.wheatgenetics.androidlibrarybuilder.R.id
                            .observationsObservationunitsGetObservationVariableDbIdEditText);
                if (null == this.studyDbIdEditText) this.studyDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id
                        .observationsObservationunitsGetStudyDbIdEditText);
                if (null == this.locationDbIdEditText) this.locationDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrarybuilder.R.id
                        .observationsObservationunitsGetLocationDbIdEditText);
                if (null == this.trialDbIdEditText) this.trialDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id
                        .observationsObservationunitsGetTrialDbIdEditText);
                if (null == this.programDbIdEditText) this.programDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id
                        .observationsObservationunitsGetProgramDbIdEditText);
                if (null == this.seasonDbIdEditText) this.seasonDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id
                        .observationsObservationunitsGetSeasonDbIdEditText);
                if (null == this.observationLevelEditText) this.observationLevelEditText =
                    view.findViewById(org.wheatgenetics.androidlibrarybuilder.R.id
                        .observationsObservationunitsGetObservationLevelEditText);

                if (null == this.observationTimeStampRangeStartEditText)
                    this.observationTimeStampRangeStartEditText = view.findViewById(
                        org.wheatgenetics.androidlibrarybuilder.R.id
                            .observationsObservationunitsGetObservationTimeStampRangeStartEditText);
                if (null == this.observationTimeStampRangeEndEditText)
                    this.observationTimeStampRangeEndEditText = view.findViewById(
                        org.wheatgenetics.androidlibrarybuilder.R.id
                            .observationsObservationunitsGetObservationTimeStampRangeEndEditText);

                this.findPageEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                    .R.id.observationsObservationunitsGetPageEditText);
                this.findPageSizeEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                    .R.id.observationsObservationunitsGetPageSizeEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.parameters)
        {
            this.parameters.germplasmDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.observations.ObservationunitsGetAlertDialog.getEditTextStringText(
                    this.germplasmDbIdEditText);
            this.parameters.observationVariableDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.observations.ObservationunitsGetAlertDialog.getEditTextStringText(
                    this.observationVariableDbIdEditText);
            this.parameters.studyDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.observations.ObservationunitsGetAlertDialog.getEditTextStringText(
                    this.studyDbIdEditText);
            this.parameters.locationDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.observations.ObservationunitsGetAlertDialog.getEditTextStringText(
                    this.locationDbIdEditText);
            this.parameters.trialDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.observations.ObservationunitsGetAlertDialog.getEditTextStringText(
                    this.trialDbIdEditText);
            this.parameters.programDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.observations.ObservationunitsGetAlertDialog.getEditTextStringText(
                    this.programDbIdEditText);
            this.parameters.seasonDbId = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.observations.ObservationunitsGetAlertDialog.getEditTextStringText(
                    this.seasonDbIdEditText);
            this.parameters.observationLevel = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.observations.ObservationunitsGetAlertDialog.getEditTextStringText(
                    this.observationLevelEditText);

            this.parameters.observationTimeStampRangeStart = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.observations.ObservationunitsGetAlertDialog.getEditTextTimeStampText(
                    this.observationTimeStampRangeStartEditText);
            this.parameters.observationTimeStampRangeEnd = org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.observations.ObservationunitsGetAlertDialog.getEditTextTimeStampText(
                    this.observationTimeStampRangeEndEditText);

            this.parameters.page     = this.getPageEditTextIntText    ();
            this.parameters.pageSize = this.getPageSizeEditTextIntText();

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
    .ObservationunitsGetAlertDialog.Parameters parameters)
    {
        if (null != parameters)
        {
            this.parameters = parameters;

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                .ObservationunitsGetAlertDialog.setEditTextText(
                    this.germplasmDbIdEditText, this.parameters.getGermplasmDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                .ObservationunitsGetAlertDialog.setEditTextText(
                    this.observationVariableDbIdEditText        ,
                    this.parameters.getObservationVariableDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                .ObservationunitsGetAlertDialog.setEditTextText(
                    this.studyDbIdEditText, this.parameters.getStudyDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                .ObservationunitsGetAlertDialog.setEditTextText(
                    this.locationDbIdEditText, this.parameters.getLocationDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                .ObservationunitsGetAlertDialog.setEditTextText(
                    this.trialDbIdEditText, this.parameters.getTrialDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                .ObservationunitsGetAlertDialog.setEditTextText(
                    this.programDbIdEditText, this.parameters.getProgramDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                .ObservationunitsGetAlertDialog.setEditTextText(
                    this.seasonDbIdEditText, this.parameters.getSeasonDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                .ObservationunitsGetAlertDialog.setEditTextText(
                    this.observationLevelEditText, this.parameters.getObservationLevel());

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                .ObservationunitsGetAlertDialog.setEditTextText(
                    this.observationTimeStampRangeStartEditText        ,
                    this.parameters.getObservationTimeStampRangeStart());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                .ObservationunitsGetAlertDialog.setEditTextText(
                    this.observationTimeStampRangeEndEditText        ,
                    this.parameters.getObservationTimeStampRangeEnd());

            this.setPageEditTextText    (this.parameters.getPage    ());
            this.setPageSizeEditTextText(this.parameters.getPageSize());

            this.show();
        }
    }
}