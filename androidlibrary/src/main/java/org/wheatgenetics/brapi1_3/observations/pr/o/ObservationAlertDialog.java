package org.wheatgenetics.brapi1_3.observations.pr.o;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.widget.EditText
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 *
 * org.wheatgenetics.brapi1_3.observations.pr.o.Observation
 */
class ObservationAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    // region Fields
    private android.widget.EditText collectorEditText, observationDbIdEditText,
        observationTimeStampEditText, observationVariableDbIdEditText,
        observationVariableNameEditText, seasonEditText, valueEditText;

    private org.wheatgenetics.brapi1_3.observations.pr.o.Observation outsideObservation = null;
    // endregion

    ObservationAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.PRObservationAlertDialogTitle);
        {
            final android.view.View view = this.inflate(org.wheatgenetics
                .androidlibrary.R.layout.alert_dialog_brapi1_3_observations_probservation);
            if (null != view)
            {
                if (null != this.collectorEditText) this.collectorEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.observationsObservationCollectorEditText);
                if (null != this.observationDbIdEditText) this.observationDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .observationsObservationObservationDbIdEditText);
                if (null != this.observationTimeStampEditText) this.observationTimeStampEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .observationsObservationObservationTimeStampEditText);
                if (null != this.observationVariableDbIdEditText)
                    this.observationVariableDbIdEditText = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .observationsObservationObservationVariableDbIdEditText);
                if (null != this.observationVariableNameEditText)
                    this.observationVariableNameEditText = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .observationsObservationObservationVariableNameEditText);
                if (null != this.seasonEditText) this.seasonEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.observationsObservationSeasonEditText);
                if (null != this.valueEditText) this.valueEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.observationsObservationValueEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.outsideObservation)
        {
            this.outsideObservation.setCollector(org.wheatgenetics.brapi1_3.observations.pr.o
                .ObservationAlertDialog.getEditTextStringText(this.collectorEditText));
            this.outsideObservation.setObservationDbId(org.wheatgenetics.brapi1_3.observations.pr.o
                .ObservationAlertDialog.getEditTextStringText(this.observationDbIdEditText));
            this.outsideObservation.setObservationTimeStamp(org.wheatgenetics.brapi1_3
                .observations.pr.o.ObservationAlertDialog.getEditTextTimeStampText(
                    this.observationTimeStampEditText));
            this.outsideObservation.setObservationVariableDbId(org.wheatgenetics.brapi1_3
                .observations.pr.o.ObservationAlertDialog.getEditTextStringText(
                    this.observationVariableDbIdEditText));
            this.outsideObservation.setObservationVariableName(org.wheatgenetics.brapi1_3
                .observations.pr.o.ObservationAlertDialog.getEditTextStringText(
                    this.observationVariableNameEditText));
            this.outsideObservation.setSeason(org.wheatgenetics.brapi1_3.observations.pr.o
                .ObservationAlertDialog.getEditTextStringText(this.seasonEditText));
            this.outsideObservation.setValue(org.wheatgenetics.brapi1_3.observations.pr.o
                .ObservationAlertDialog.getEditTextStringText(this.valueEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final org.wheatgenetics.brapi1_3.observations.pr.o.Observation outsideObservation)
    {
        if (null != outsideObservation)
        {
            this.outsideObservation = outsideObservation;
            final org.wheatgenetics.brapi1_3.observations.pr.o.Observation insideObservation =
                new org.wheatgenetics.brapi1_3.observations.pr.o.Observation(
                    this.outsideObservation);

            org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog.setEditTextText(
                this.collectorEditText, insideObservation.getCollector());
            org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog.setEditTextText(
                this.observationDbIdEditText, insideObservation.getObservationDbId());
            org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog.setEditTextText(
                this.observationTimeStampEditText, insideObservation.getObservationTimeStamp());
            org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog.setEditTextText(
                this.observationVariableDbIdEditText          ,
                insideObservation.getObservationVariableDbId());
            org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog.setEditTextText(
                this.observationVariableNameEditText           ,
                insideObservation.getObservationVariableName());
            org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog.setEditTextText(
                this.seasonEditText, insideObservation.getSeason());
            org.wheatgenetics.brapi1_3.observations.pr.o.ObservationAlertDialog.setEditTextText(
                this.valueEditText, insideObservation.getValue());
            
            this.show();
        }
    }
}