package org.wheatgenetics.brapi1_3.studies;         // TODO: Move to NewObservationsRequest package.

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.widget.EditText
 *
 * io.swagger.client.model.NewObservationsRequestObservations
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 */
class NewObservationsRequestObservationsAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    // region Fields
    private android.widget.EditText collectorEditText, observationDbIdEditText,
        observationTimeStampEditText, observationUnitDbIdEditText, observationVariableDbIdEditText,
        valueEditText;
    private io.swagger.client.model.NewObservationsRequestObservations
        newObservationsRequestObservations = null;
    // endregion

    NewObservationsRequestObservationsAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog.Handler
        handler) { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary
            .R.string.NewObservationsRequestObservationsAlertDialogTitle);
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrary
                .R.layout.alert_dialog_brapi1_3_new_observations_request_observations);
            if (null != view)
            {
                if (null == this.collectorEditText) this.collectorEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationsRequestObservationsCollectorEditText);
                if (null == this.observationDbIdEditText) this.observationDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationsRequestObservationsObservationDbIdEditText);
                if (null == this.observationTimeStampEditText) this.observationTimeStampEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationsRequestObservationsObservationTimeStampEditText);
                if (null == this.observationUnitDbIdEditText) this.observationUnitDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationsRequestObservationsObservationUnitDbIdEditText);
                if (null == this.observationVariableDbIdEditText)
                    this.observationVariableDbIdEditText = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .studiesNewObservationsRequestObservationsObservationVariableDbIdEditText);
                if (null == this.valueEditText) this.valueEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationsRequestObservationsValueEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.newObservationsRequestObservations)
        {
            this.newObservationsRequestObservations.setCollector(
                org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
                    .getEditTextStringText(this.collectorEditText));
            this.newObservationsRequestObservations.setObservationDbId(
                org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
                    .getEditTextStringText(this.observationDbIdEditText));
            this.newObservationsRequestObservations.setObservationTimeStamp(
                org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
                    .getEditTextTimeStampText(this.observationTimeStampEditText));
            this.newObservationsRequestObservations.setObservationUnitDbId(
                org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
                    .getEditTextStringText(this.observationUnitDbIdEditText));
            this.newObservationsRequestObservations.setObservationVariableDbId(
                org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
                    .getEditTextStringText(this.observationVariableDbIdEditText));
            this.newObservationsRequestObservations.setValue(
                org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
                    .getEditTextStringText(this.valueEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final io.swagger.client.model.NewObservationsRequestObservations
        newObservationsRequestObservations)
    {
        if (null != newObservationsRequestObservations)
        {
            this.newObservationsRequestObservations = newObservationsRequestObservations;

            org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
                .setEditTextText(this.collectorEditText,
                    this.newObservationsRequestObservations.getCollector());
            org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
                .setEditTextText(this.observationDbIdEditText,
                    this.newObservationsRequestObservations.getObservationDbId());
            org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
                .setEditTextText(this.observationTimeStampEditText,
                    this.newObservationsRequestObservations.getObservationTimeStamp());
            org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
                .setEditTextText(this.observationUnitDbIdEditText,
                    this.newObservationsRequestObservations.getObservationUnitDbId());
            org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
                .setEditTextText(this.observationVariableDbIdEditText,
                    this.newObservationsRequestObservations.getObservationVariableDbId());
            org.wheatgenetics.brapi1_3.studies.NewObservationsRequestObservationsAlertDialog
                .setEditTextText(this.valueEditText,
                    this.newObservationsRequestObservations.getValue());

            this.show();
        }
    }
}