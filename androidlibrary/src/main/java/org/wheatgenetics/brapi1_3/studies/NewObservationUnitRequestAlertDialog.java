package org.wheatgenetics.brapi1_3.studies;     // TODO: Move to package NewObservationUnitRequests.

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.widget.EditText
 *
 * io.swagger.client.model.NewObservationUnitRequest
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 */
class NewObservationUnitRequestAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    // region Fields
    private android.widget.EditText blockNumberEditText, entryNumberEditText, entryTypeEditText,
        germplasmDbIdEditText, observationLevelEditText, observationUnitDbIdEditText,
        observationUnitNameEditText;
    private io.swagger.client.model.NewObservationUnitRequest newObservationUnitRequest = null;
    // endregion

    NewObservationUnitRequestAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary
            .R.string.NewObservationUnitRequestAlertDialogTitle);
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrary
                .R.layout.new_observation_unit_request_alert_dialog);               // TODO: Rename.
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
                // TODO
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
                org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.blockNumberEditText));
            this.newObservationUnitRequest.setEntryNumber(
                org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.entryNumberEditText));
            this.newObservationUnitRequest.setEntryType(
                org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.entryTypeEditText));
            this.newObservationUnitRequest.setGermplasmDbId(
                org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.germplasmDbIdEditText));
            this.newObservationUnitRequest.setObservationLevel(
                org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.observationLevelEditText));
            this.newObservationUnitRequest.setObservationUnitDbId(
                org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.observationUnitDbIdEditText));
            this.newObservationUnitRequest.setObservationUnitName(
                org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.observationUnitNameEditText));
            // TODO

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    public void show(
    final io.swagger.client.model.NewObservationUnitRequest newObservationUnitRequest)
    {
        if (null != newObservationUnitRequest)
        {
            this.newObservationUnitRequest = newObservationUnitRequest;

            org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.blockNumberEditText,
                    this.newObservationUnitRequest.getBlockNumber());
            org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.entryNumberEditText,
                    this.newObservationUnitRequest.getEntryNumber());
            org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.entryTypeEditText,
                    this.newObservationUnitRequest.getEntryType());
            org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.germplasmDbIdEditText,
                    this.newObservationUnitRequest.getGermplasmDbId());
            org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.observationLevelEditText,
                    this.newObservationUnitRequest.getObservationLevel());
            org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.observationUnitDbIdEditText,
                    this.newObservationUnitRequest.getObservationUnitDbId());
            org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.observationUnitNameEditText,
                    this.newObservationUnitRequest.getObservationUnitName());
            // TODO

            this.show();
        }
    }
}