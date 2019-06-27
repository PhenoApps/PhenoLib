package org.wheatgenetics.brapi1_3.studies.nour;                 // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.annotation.SuppressLint
 * android.app.Activity
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.Button
 * android.widget.EditText
 * android.widget.TextView
 *
 * io.swagger.client.model.Observation
 * io.swagger.client.model.ObservationTreatment
 * io.swagger.client.model.ObservationUnitXref
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 */
class NewObservationUnitRequestAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) interface ActivityHandler
    {
        public abstract void showObservationUnitXrefListActivity(
        @android.support.annotation.IntRange(
            from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);
        public abstract void showObservationsListActivity(@android.support.annotation.IntRange(
            from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);
        public abstract void showObservationTreatmentsListActivity(
        @android.support.annotation.IntRange(
            from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);
    }

    // region Fields
    private final
        org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog.ActivityHandler
            activityHandler;

    private android.widget.EditText blockNumberEditText, entryNumberEditText, entryTypeEditText,
        germplasmDbIdEditText, observationLevelEditText, observationUnitDbIdEditText,
        observationUnitNameEditText;
    private android.widget.TextView observationUnitXrefTextView, observationsTextView;
    private android.widget.EditText plantNumberEditText, plotNumberEditText,
        positionCoordinateXEditText;
    // TODO
    private android.widget.EditText positionCoordinateYEditText;
    // TODO
    private android.widget.EditText replicateEditText, studyDbIdEditText;
    private android.widget.TextView observationTreatmentsTextView       ;

    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
        newObservationUnitRequest = null;
    // endregion

    // region Private Methods
    // region observationUnitXref Private Methods
    @android.annotation.SuppressLint({"DefaultLocale"})
    private void setObservationUnitXrefTextViewText(@android.support.annotation.Nullable
    final java.util.List<io.swagger.client.model.ObservationUnitXref> observationUnitXref)
    {
        if (null != this.observationUnitXrefTextView) this.observationUnitXrefTextView.setText(
            null == observationUnitXref ? "null" : java.lang.String.format(
                "%d observationUnitXref(s)", observationUnitXref.size()));
    }

    private void setObservationUnitXrefTextViewText()
    {
        if (null != this.newObservationUnitRequest) this.setObservationUnitXrefTextViewText(
            this.newObservationUnitRequest.getObservationUnitXref());
    }

    private void showObservationUnitXrefListActivity()
    {
        if (null != this.newObservationUnitRequest)
            this.activityHandler.showObservationUnitXrefListActivity(
                this.newObservationUnitRequest.getPosition());
    }
    // endregion

    // region observations Private Methods
    @android.annotation.SuppressLint({"DefaultLocale"}) private void setObservationsTextViewText(
    @android.support.annotation.Nullable
    final java.util.List<io.swagger.client.model.Observation> observations)
    {
        if (null != this.observationsTextView) this.observationsTextView.setText(
            null == observations ? "null" : java.lang.String.format(
                "%d observation(s)", observations.size()));
    }

    private void setObservationsTextViewText()
    {
        if (null != this.newObservationUnitRequest) this.setObservationsTextViewText(
            this.newObservationUnitRequest.getObservations());
    }

    private void showObservationsListActivity()
    {
        if (null != this.newObservationUnitRequest)
            this.activityHandler.showObservationsListActivity(
                this.newObservationUnitRequest.getPosition());
    }
    // endregion

    // region observationTreatments Private Methods
    @android.annotation.SuppressLint({"DefaultLocale"})
    private void setObservationTreatmentsTextViewText(@android.support.annotation.Nullable
    final java.util.List<io.swagger.client.model.ObservationTreatment> observationTreatments)
    {
        if (null != this.observationTreatmentsTextView) this.observationTreatmentsTextView.setText(
            null == observationTreatments ? "null" : java.lang.String.format(
                "%d observationTreatment(s)", observationTreatments.size()));
    }

    private void setObservationTreatmentsTextViewText()
    {
        if (null != this.newObservationUnitRequest) this.setObservationTreatmentsTextViewText(
            this.newObservationUnitRequest.getTreatments());
    }

    private void showObservationTreatmentsListActivity()
    {
        if (null != this.newObservationUnitRequest)
            this.activityHandler.showObservationTreatmentsListActivity(
                this.newObservationUnitRequest.getPosition());
    }
    // endregion
    // endregion

    NewObservationUnitRequestAlertDialog(final android.app.Activity activity, final
        org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog.Handler
            handler,
    final @android.support.annotation.NonNull
        org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog.ActivityHandler
            activityHandler) { super(activity, handler); this.activityHandler = activityHandler; }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary
            .R.string.NewObservationUnitRequestAlertDialogTitle);
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrary
                .R.layout.alert_dialog_brapi1_3_studies_new_observation_unit_request);
            if (null != view)
            {
                if (null == this.blockNumberEditText) this.blockNumberEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestBlockNumberEditText);
                if (null == this.entryNumberEditText) this.entryNumberEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestEntryNumberEditText);
                if (null == this.entryTypeEditText) this.entryTypeEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestEntryTypeEditText);
                if (null == this.germplasmDbIdEditText) this.germplasmDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestGermplasmDbIdEditText);
                if (null == this.observationLevelEditText) this.observationLevelEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestObservationLevelEditText);
                if (null == this.observationUnitDbIdEditText) this.observationUnitDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestObservationUnitDbIdEditText);
                if (null == this.observationUnitNameEditText) this.observationUnitNameEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestObservationUnitNameEditText);

                if (null == this.observationUnitXrefTextView) this.observationUnitXrefTextView =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestObservationUnitXrefValueTextView);
                {
                    final android.widget.Button changeObservationUnitXrefButton = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .studiesNewObservationUnitRequestChangeObservationUnitXrefButton);
                    if (null != changeObservationUnitXrefButton)
                        changeObservationUnitXrefButton.setOnClickListener(
                            new android.view.View.OnClickListener()
                            {
                                @java.lang.Override public void onClick(final android.view.View v)
                                {
                                    org.wheatgenetics.brapi1_3.studies.nour
                                        .NewObservationUnitRequestAlertDialog
                                        .this.showObservationUnitXrefListActivity();
                                }
                            });
                }

                if (null == this.observationsTextView) this.observationsTextView =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestObservationsValueTextView);
                {
                    final android.widget.Button changeObservationsButton = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .studiesNewObservationUnitRequestChangeObservationsButton);
                    if (null != changeObservationsButton)
                        changeObservationsButton.setOnClickListener(
                            new android.view.View.OnClickListener()
                            {
                                @java.lang.Override public void onClick(final android.view.View v)
                                {
                                    org.wheatgenetics.brapi1_3.studies.nour
                                        .NewObservationUnitRequestAlertDialog
                                        .this.showObservationsListActivity();
                                }
                            });
                }

                if (null == this.plantNumberEditText) this.plantNumberEditText = view.findViewById
                    (org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestPlantNumberEditText);
                if (null == this.plotNumberEditText) this.plotNumberEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestPlotNumberEditText);
                if (null == this.positionCoordinateXEditText) this.positionCoordinateXEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestPositionCoordinateXEditText);

                // TODO

                if (null == this.positionCoordinateYEditText) this.positionCoordinateYEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestPositionCoordinateYEditText);

                // TODO

                if (null == this.replicateEditText) this.replicateEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestReplicateEditText);
                if (null == this.studyDbIdEditText) this.studyDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestStudyDbIdEditText);

                if (null == this.observationTreatmentsTextView) this.observationTreatmentsTextView =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestObservationTreatmentsValueTextView);
                {
                    final android.widget.Button changeObservationTreatmentsButton =
                        view.findViewById(org.wheatgenetics.androidlibrary.R.id
                            .studiesNewObservationUnitRequestChangeObservationTreatmentsButton);
                    if (null != changeObservationTreatmentsButton)
                        changeObservationTreatmentsButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.brapi1_3.studies.nour
                                    .NewObservationUnitRequestAlertDialog
                                    .this.showObservationTreatmentsListActivity();
                            }
                        });
                }
            }
            this.setView(view);
        }
        super.configure();
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.newObservationUnitRequest)
        {
            this.newObservationUnitRequest.setBlockNumber(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.blockNumberEditText));
            this.newObservationUnitRequest.setEntryNumber(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.entryNumberEditText));
            this.newObservationUnitRequest.setEntryType(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.entryTypeEditText));
            this.newObservationUnitRequest.setGermplasmDbId(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.germplasmDbIdEditText));
            this.newObservationUnitRequest.setObservationLevel(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.observationLevelEditText));
            this.newObservationUnitRequest.setObservationUnitDbId(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.observationUnitDbIdEditText));
            this.newObservationUnitRequest.setObservationUnitName(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.observationUnitNameEditText));
            this.newObservationUnitRequest.setPlantNumber(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.plantNumberEditText));
            this.newObservationUnitRequest.setPlotNumber(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.plotNumberEditText));
            this.newObservationUnitRequest.setPositionCoordinateX(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.positionCoordinateXEditText));
            // TODO
            this.newObservationUnitRequest.setPositionCoordinateY(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.positionCoordinateYEditText));
            // TODO
            this.newObservationUnitRequest.setReplicate(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.replicateEditText));
            this.newObservationUnitRequest.setStudyDbId(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.studyDbIdEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    // region Package Methods
    void show(final
    org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest newObservationUnitRequest)
    {
        if (null != newObservationUnitRequest)
        {
            this.newObservationUnitRequest = newObservationUnitRequest;

            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.blockNumberEditText,
                    this.newObservationUnitRequest.getBlockNumber());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.entryNumberEditText,
                    this.newObservationUnitRequest.getEntryNumber());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.entryTypeEditText,
                    this.newObservationUnitRequest.getEntryType());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.germplasmDbIdEditText,
                    this.newObservationUnitRequest.getGermplasmDbId());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.observationLevelEditText,
                    this.newObservationUnitRequest.getObservationLevel());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.observationUnitDbIdEditText,
                    this.newObservationUnitRequest.getObservationUnitDbId());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.observationUnitNameEditText,
                    this.newObservationUnitRequest.getObservationUnitName());
            this.setObservationUnitXrefTextViewText();
            this.setObservationsTextViewText       ();
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.plantNumberEditText,
                    this.newObservationUnitRequest.getPlantNumber());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.plotNumberEditText,
                    this.newObservationUnitRequest.getPlotNumber());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.positionCoordinateXEditText,
                    this.newObservationUnitRequest.getPositionCoordinateX());
            // TODO
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.positionCoordinateYEditText,
                    this.newObservationUnitRequest.getPositionCoordinateY());
            // TODO
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.replicateEditText,
                    this.newObservationUnitRequest.getReplicate());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.studyDbIdEditText,
                    this.newObservationUnitRequest.getStudyDbId());
            this.setObservationTreatmentsTextViewText();

            this.show();
        }
    }

    // region update() Package Methods
    void updateObservationUnitXref  () { this.setObservationUnitXrefTextViewText  (); }
    void updateObservations         () { this.setObservationsTextViewText         (); }
    void updateObservationTreatments() { this.setObservationTreatmentsTextViewText(); }
    // endregion
    // endregion
}