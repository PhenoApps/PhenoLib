package org.wheatgenetics.brapi1_3.studies.nour.o;               // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.annotation.SuppressLint
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.Button
 * android.widget.EditText
 * android.widget.TextView
 *
 * io.swagger.client.model.Observation
 * io.swagger.client.model.Season
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 *
 * org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog
 * org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog.Handler
 */
class ObservationAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    // region Fields
    private android.widget.EditText germplasmDbIdEditText, germplasmNameEditText,
        observationDbIdEditText, observationLevelEditText, observationTimeStampEditText,
        observationUnitDbIdEditText, observationUnitNameEditText, observationVariableDbIdEditText,
        observationVariableNameEditText, operatorEditText;
    private android.widget.TextView seasonTextView                                      ;
    private android.widget.EditText studyDbIdEditText, uploadedByEditText, valueEditText;

    private io.swagger.client.model.Observation observation = null;

    private org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog
        seasonAlertDialogInstance = null;                                               // lazy load
    // endregion

    // region Private Methods
    @android.annotation.SuppressLint({"DefaultLocale"})
    private void setSeasonTextViewText(final io.swagger.client.model.Season season)
    {
        if (null != this.seasonTextView) this.seasonTextView.setText(
            null == season ? "null" : java.lang.String.format("%s, %s, %s",
                season.getSeason(), season.getSeasonDbId(), season.getYear()));
    }

    private void setSeasonTextViewText()
    { if (null != this.observation) this.setSeasonTextViewText(this.observation.getSeason()); }

    private org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog seasonAlertDialog()
    {
        if (null == this.seasonAlertDialogInstance) this.seasonAlertDialogInstance =
            new org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog(this.activity(),
                new org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog.Handler()
                {
                    @java.lang.Override public void handleDone()
                    {
                        org.wheatgenetics.brapi1_3.studies.nour.o
                            .ObservationAlertDialog.this.setSeasonTextViewText();
                    }
                });
        return this.seasonAlertDialogInstance;
    }

    private void showSeasonAlertDialog()
    { if (null != this.observation) this.seasonAlertDialog().show(this.observation.getSeason()); }
    // endregion

    ObservationAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.ObservationAlertDialogTitle);
        {
            final android.view.View view = this.inflate(org.wheatgenetics
                .androidlibrary.R.layout.alert_dialog_brapi1_3_studies_observation);
            if (null != view)
            {
                if (null == this.germplasmDbIdEditText) this.germplasmDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationGermplasmDbIdEditText);
                if (null == this.germplasmNameEditText) this.germplasmNameEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationGermplasmNameEditText);
                if (null == this.observationDbIdEditText) this.observationDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationObservationDbIdEditText);
                if (null == this.observationLevelEditText) this.observationLevelEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationObservationLevelEditText);
                if (null == this.observationTimeStampEditText) this.observationTimeStampEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationObservationTimeStampEditText);
                if (null == this.observationUnitDbIdEditText) this.observationUnitDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationObservationUnitDbIdEditText);
                if (null == this.observationUnitNameEditText) this.observationUnitNameEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationObservationUnitNameEditText);
                if (null == this.observationVariableDbIdEditText)
                    this.observationVariableDbIdEditText = view.findViewById(org.wheatgenetics
                        .androidlibrary.R.id.studiesObservationObservationVariableDbIdEditText);
                if (null == this.observationVariableNameEditText)
                    this.observationVariableNameEditText = view.findViewById(org.wheatgenetics
                        .androidlibrary.R.id.studiesObservationObservationVariableNameEditText);
                if (null == this.operatorEditText) this.operatorEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesObservationOperatorEditText);

                if (null == this.seasonTextView) this.seasonTextView = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesObservationSeasonValueTextView);
                {
                    final android.widget.Button changeSeasonButton = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id.studiesObservationChangeSeasonButton);
                    if (null != changeSeasonButton) changeSeasonButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.brapi1_3.studies.nour.o
                                    .ObservationAlertDialog.this.showSeasonAlertDialog();
                            }
                        });
                }

                if (null == this.studyDbIdEditText) this.studyDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesObservationStudyDbIdEditText);
                if (null == this.uploadedByEditText) this.uploadedByEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesObservationUploadedByEditText);
                if (null == this.valueEditText) this.valueEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesObservationValueEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.observation)
        {
            this.observation.setGermplasmDbId(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextStringText(this.germplasmDbIdEditText));
            this.observation.setGermplasmName(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextStringText(this.germplasmNameEditText));
            this.observation.setObservationDbId(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextStringText(this.observationDbIdEditText));
            this.observation.setObservationLevel(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextStringText(this.observationLevelEditText));
            this.observation.setObservationTimeStamp(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextTimeStampText(
                    this.observationTimeStampEditText));
            this.observation.setObservationUnitDbId(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextStringText(this.observationUnitDbIdEditText));
            this.observation.setObservationUnitName(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextStringText(this.observationUnitNameEditText));
            this.observation.setObservationVariableDbId(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextStringText(
                    this.observationVariableDbIdEditText));
            this.observation.setObservationVariableName(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextStringText(
                    this.observationVariableNameEditText));
            this.observation.setOperator(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextStringText(this.operatorEditText));
            this.observation.setStudyDbId(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextStringText(this.studyDbIdEditText));
            this.observation.setUploadedBy(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextStringText(this.uploadedByEditText));
            this.observation.setValue(org.wheatgenetics.brapi1_3.studies.nour.o
                .ObservationAlertDialog.getEditTextStringText(this.valueEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final io.swagger.client.model.Observation observation)
    {
        if (null != observation)
        {
            this.observation = observation;

            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.germplasmDbIdEditText, this.observation.getGermplasmDbId());
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.germplasmNameEditText, this.observation.getGermplasmName());
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.observationDbIdEditText, this.observation.getObservationDbId());
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.observationLevelEditText, this.observation.getObservationLevel());
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.observationTimeStampEditText, this.observation.getObservationTimeStamp());
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.observationUnitDbIdEditText, this.observation.getObservationUnitDbId());
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.observationUnitNameEditText, this.observation.getObservationUnitName());
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.observationVariableDbIdEditText         ,
                this.observation.getObservationVariableDbId());
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.observationVariableNameEditText         ,
                this.observation.getObservationVariableName());
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.operatorEditText, this.observation.getOperator());
            this.setSeasonTextViewText();
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.studyDbIdEditText, this.observation.getStudyDbId());
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.uploadedByEditText, this.observation.getUploadedBy());
            org.wheatgenetics.brapi1_3.studies.nour.o.ObservationAlertDialog.setEditTextText(
                this.valueEditText, this.observation.getValue());

            this.show();
        }
    }
}