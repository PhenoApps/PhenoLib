package org.wheatgenetics.brapi1_3.studies.nour;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.widget.EditText
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 */
class ObservationAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    // region Fields
    private android.widget.EditText germplasmDbIdEditText, germplasmNameEditText,
        observationDbIdEditText, observationLevelEditText, observationTimeStampEditText,
        observationUnitDbIdEditText, observationUnitNameEditText, observationVariableDbIdEditText,
        observationVariableNameEditText, operatorEditText;
    // TODO
    private android.widget.EditText studyDbIdEditText, uploadedByEditText, valueEditText;

    private io.swagger.client.model.Observation observation;
    // endregion

    ObservationAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.Handler handler)
    { super(activity, handler);}

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.ObservationAlertDialogTitle);
        {
            final android.view.View view = this.inflate(
                org.wheatgenetics.androidlibrary.R.layout.alert_dialog_brapi1_3_observation);
            if (null != view)
            {
                if (null == this.germplasmDbIdEditText) this.germplasmDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationsGermplasmDbIdEditText);
                if (null == this.germplasmNameEditText) this.germplasmNameEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationsGermplasmNameEditText);
                if (null == this.observationDbIdEditText) this.observationDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationsObservationDbIdEditText);
                if (null == this.observationLevelEditText) this.observationLevelEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationsObservationLevelEditText);
                if (null == this.observationTimeStampEditText) this.observationTimeStampEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationsObservationTimeStampEditText);
                if (null == this.observationUnitDbIdEditText) this.observationUnitDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationsObservationUnitDbIdEditText);
                if (null == this.observationUnitNameEditText) this.observationUnitNameEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesObservationsObservationUnitNameEditText);
                if (null == this.observationVariableDbIdEditText)
                    this.observationVariableDbIdEditText = view.findViewById(org.wheatgenetics
                        .androidlibrary.R.id.studiesObservationsObservationVariableDbIdEditText);
                if (null == this.observationVariableNameEditText)
                    this.observationVariableNameEditText = view.findViewById(org.wheatgenetics
                        .androidlibrary.R.id.studiesObservationsObservationVariableNameEditText);
                if (null == this.operatorEditText) this.operatorEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesObservationsOperatorEditText);
                // TODO
                if (null == this.studyDbIdEditText) this.studyDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesObservationsStudyDbIdEditText);
                if (null == this.uploadedByEditText) this.uploadedByEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesObservationsUploadedByEditText);
                if (null == this.valueEditText) this.valueEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesObservationsValueEditText);
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
            this.observation.setGermplasmDbId(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextStringText(this.germplasmDbIdEditText));
            this.observation.setGermplasmName(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextStringText(this.germplasmNameEditText));
            this.observation.setObservationDbId(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextStringText(this.observationDbIdEditText));
            this.observation.setObservationLevel(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextStringText(this.observationLevelEditText));
            this.observation.setObservationTimeStamp(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextTimeStampText(this.observationTimeStampEditText));
            this.observation.setObservationUnitDbId(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextStringText(this.observationUnitDbIdEditText));
            this.observation.setObservationUnitName(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextStringText(this.observationUnitNameEditText));
            this.observation.setObservationVariableDbId(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextStringText(this.observationVariableDbIdEditText));
            this.observation.setObservationVariableName(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextStringText(this.observationVariableNameEditText));
            this.observation.setOperator(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextStringText(this.operatorEditText));
            // TODO
            this.observation.setStudyDbId(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextStringText(this.studyDbIdEditText));
            this.observation.setUploadedBy(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextStringText(this.uploadedByEditText));
            this.observation.setValue(org.wheatgenetics.brapi1_3.studies.nour
                .ObservationAlertDialog.getEditTextStringText(this.valueEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    public void show(final io.swagger.client.model.Observation observation)
    {
        if (null != observation)
        {
            this.observation = observation;

            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.germplasmDbIdEditText, this.observation.getGermplasmDbId());
            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.germplasmNameEditText, this.observation.getGermplasmName());
            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.observationDbIdEditText, this.observation.getObservationDbId());
            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.observationLevelEditText, this.observation.getObservationLevel());
            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.observationTimeStampEditText, this.observation.getObservationTimeStamp());
            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.observationUnitDbIdEditText, this.observation.getObservationUnitDbId());
            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.observationUnitNameEditText, this.observation.getObservationUnitName());
            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.observationVariableDbIdEditText         ,
                this.observation.getObservationVariableDbId());
            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.observationVariableNameEditText         ,
                this.observation.getObservationVariableName());
            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.operatorEditText, this.observation.getOperator());
            // TODO
            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.studyDbIdEditText, this.observation.getStudyDbId());
            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.uploadedByEditText, this.observation.getUploadedBy());
            org.wheatgenetics.brapi1_3.studies.nour.ObservationAlertDialog.setEditTextText(
                this.valueEditText, this.observation.getValue());

            this.show();
        }
    }
}