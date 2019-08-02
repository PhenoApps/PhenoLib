package org.wheatgenetics.brapi1_3.observations.pr;

/**
 * Uses:
 * android.annotation.SuppressLint
 * android.app.Application
 * android.app.Activity
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.Button
 * android.widget.EditText
 * android.widget.TextView
 *
 * io.swagger.client.model.PhenotypesRequestObservation
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 * org.wheatgenetics.brapi1_3.Application
 *
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData
 */
class PhenotypesRequestDataAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) interface ActivityHandler
    { public abstract void showObservationsListActivity(); }

    // region Fields
    private final
        org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog.ActivityHandler
            activityHandler;

    private android.widget.EditText observationUnitDbIdEditText, studyDbIdEditText;
    private android.widget.TextView observationsTextView                          ;

    private org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData
        phenotypesRequestData = null;
    // endregion

    // region Private Methods
    private boolean setPhenotypesRequestDataPosition()
    {
        final boolean success;
        {
            final android.app.Activity activity = this.activity();
            if (null == activity)
                success = false;
            else
            {
                final android.app.Application androidApplication = activity.getApplication();
                if (androidApplication instanceof org.wheatgenetics.brapi1_3.Application)
                {
                    final org.wheatgenetics.brapi1_3.Application brapi1_3Application =
                        (org.wheatgenetics.brapi1_3.Application) androidApplication;
                    if (null == this.phenotypesRequestData)
                        success = false;
                    else
                    {
                        brapi1_3Application.setPhenotypesRequestDataPosition(
                            this.phenotypesRequestData.getPosition());
                        success = true;
                    }
                }
                else success = false;
            }
        }
        return success;
    }

    private void showObservationsListActivity()
    {
        if (this.setPhenotypesRequestDataPosition())
            this.activityHandler.showObservationsListActivity();
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
        if (null != this.phenotypesRequestData)
            this.setObservationsTextViewText(this.phenotypesRequestData.getObservations());
    }
    // endregion

    PhenotypesRequestDataAlertDialog(final android.app.Activity activity, final
    org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog.Handler handler,
    @android.support.annotation.NonNull final
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

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.phenotypesRequestData)
        {
            this.phenotypesRequestData.setObservatioUnitDbId(org.wheatgenetics.brapi1_3.observations
                .pr.PhenotypesRequestDataAlertDialog.getEditTextStringText(
                    this.observationUnitDbIdEditText));
            this.phenotypesRequestData.setStudyDbId(org.wheatgenetics.brapi1_3.observations
                .pr.PhenotypesRequestDataAlertDialog.getEditTextStringText(this.studyDbIdEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    // region Package Methods
    void show(final
    org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestData phenotypesRequestData)
    {
        if (null != phenotypesRequestData)
        {
            this.phenotypesRequestData = phenotypesRequestData;

            org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog
                .setEditTextText(this.observationUnitDbIdEditText,
                    this.phenotypesRequestData.getObservatioUnitDbId());
            this.setObservationsTextViewText();
            org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestDataAlertDialog
                .setEditTextText(this.studyDbIdEditText,
                    this.phenotypesRequestData.getStudyDbId());

            this.show();
        }
    }

    void updateObservations() { this.setObservationsTextViewText(); }
    // endregion
}