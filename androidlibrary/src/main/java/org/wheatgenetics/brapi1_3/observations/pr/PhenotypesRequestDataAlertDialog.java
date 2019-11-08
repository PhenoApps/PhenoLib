package org.wheatgenetics.brapi1_3.observations.pr;

/**
 * Uses:
 * android.annotation.SuppressLint
 * android.app.Activity
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.Button
 * android.widget.EditText
 * android.widget.TextView
 *
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.PhenotypesRequestObservation
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 *
 * org.wheatgenetics.brapi1_3.observations.pr.o.Observations
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData
 */
class PhenotypesRequestDataAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) interface ActivityHandler
    {
        public abstract void showObservationsListActivity(
        org.wheatgenetics.brapi1_3.observations.pr.o.Observations phenotypesRequestData);
    }

    // region Fields
    private final
        org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog.ActivityHandler
            activityHandler;

    private android.widget.EditText observationUnitDbIdEditText, studyDbIdEditText;
    private android.widget.TextView observationsTextView                          ;

    private org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData
        permanentPhenotypesRequestData = null, temporaryPhenotypesRequestData = null;
    // endregion

    // region Private Methods
    private void showObservationsListActivity()
    {
        this.activityHandler.showObservationsListActivity(
            null == this.temporaryPhenotypesRequestData ? null :
                this.temporaryPhenotypesRequestData.getObservationsAsItems());
    }

    @android.annotation.SuppressLint({"DefaultLocale"}) private void setObservationsTextViewText(
    final java.util.List<io.swagger.client.model.PhenotypesRequestObservation> observations)
    {
        if (null != this.observationsTextView)
            this.observationsTextView.setText(null == observations ? "null" :
                java.lang.String.format("%d observation(s)", observations.size()));
    }

    private void setObservationsTextViewText()
    {
        this.setObservationsTextViewText(null == this.temporaryPhenotypesRequestData ?
            null : this.temporaryPhenotypesRequestData.getObservations());
    }
    // endregion

    PhenotypesRequestDataAlertDialog(final android.app.Activity activity, final
    org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog.Handler handler,
    @androidx.annotation.NonNull final
        org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog.ActivityHandler
        activityHandler) { super(activity, handler); this.activityHandler = activityHandler; }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(
            org.wheatgenetics.androidlibrary.R.string.PhenotypesRequestDataAlertDialogTitle);
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrary.R.layout
                .alert_dialog_brapi1_3_observations_phenotypes_request_data);
            if (null != view)
            {
                if (null == this.observationUnitDbIdEditText) this.observationUnitDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .observationsPhenotypesRequestDataObservationUnitDbIdEditText);

                if (null == this.observationsTextView) this.observationsTextView =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .observationsPhenotypesRequestDataObservationsValueTextView);
                {
                    final android.widget.Button changeObservationsButton = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .observationsPhenotypesRequestDataChangeObservationsButton);
                    if (null != changeObservationsButton)
                        changeObservationsButton.setOnClickListener(
                            new android.view.View.OnClickListener()
                            {
                                @java.lang.Override
                                public void onClick(final android.view.View view)
                                {
                                    org.wheatgenetics.brapi1_3.observations.pr
                                        .PhenotypesRequestDataAlertDialog.this
                                        .showObservationsListActivity();
                                }
                            });
                }

                if (null == this.studyDbIdEditText) this.studyDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .observationsPhenotypesRequestDataStudyDbIdEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.permanentPhenotypesRequestData)
        {
            this.permanentPhenotypesRequestData.setObservationUnitDbId(org.wheatgenetics.brapi1_3
                .observations.pr.PhenotypesRequestDataAlertDialog.getEditTextStringText(
                    this.observationUnitDbIdEditText));
            this.permanentPhenotypesRequestData.setObservationsAsItems(
                this.temporaryPhenotypesRequestData.getObservationsAsItems());
            this.permanentPhenotypesRequestData.setStudyDbId(org.wheatgenetics.brapi1_3.observations
                .pr.PhenotypesRequestDataAlertDialog.getEditTextStringText(this.studyDbIdEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    // region Package Methods
    void setObservations(final java.lang.String json)
    {
        if (null != this.temporaryPhenotypesRequestData)
            this.temporaryPhenotypesRequestData.setObservationsAsItems(json);
        this.setObservationsTextViewText();
    }

    void clearObservations()
    {
        if (null != this.temporaryPhenotypesRequestData)
            this.temporaryPhenotypesRequestData.clearObservationsAsItems();
        this.setObservationsTextViewText();
    }

    void show(final org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData
    permanentPhenotypesRequestData)
    {
        if (null != permanentPhenotypesRequestData)
        {
            this.permanentPhenotypesRequestData = permanentPhenotypesRequestData;
            this.temporaryPhenotypesRequestData =
                new org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData(
                    this.permanentPhenotypesRequestData);

            org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog
                .setEditTextText(this.observationUnitDbIdEditText,
                    this.temporaryPhenotypesRequestData.getObservationUnitDbId());
            this.setObservationsTextViewText();
            org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog
                .setEditTextText(this.studyDbIdEditText,
                    this.temporaryPhenotypesRequestData.getStudyDbId());

            this.show();
        }
    }
    // endregion
}