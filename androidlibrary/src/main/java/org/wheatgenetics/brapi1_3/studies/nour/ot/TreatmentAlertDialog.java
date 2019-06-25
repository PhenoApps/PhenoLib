package org.wheatgenetics.brapi1_3.studies.nour.ot;              // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.widget.EditText
 *
 * io.swagger.client.model.ObservationTreatment
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 */
class TreatmentAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    // region Fields
    private android.widget.EditText                      factorEditText, modalityEditText;
    private io.swagger.client.model.ObservationTreatment observationTreatment = null     ;
    // endregion

    TreatmentAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.TreatmentAlertDialogTitle);
        {
            final android.view.View view = this.inflate(
                org.wheatgenetics.androidlibrary.R.layout.alert_dialog_brapi1_3_treatment);
            if (null != view)
            {
                if (null == this.factorEditText) this.factorEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesTreatmentFactorEditText);
                if (null == this.modalityEditText) this.modalityEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesTreatmentModalityEditText);

            }
            this.setView(view);
        }
        super.configure();
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.observationTreatment)
        {
            this.observationTreatment.setFactor(org.wheatgenetics.brapi1_3.studies.nour.ot
                .TreatmentAlertDialog.getEditTextStringText(this.factorEditText));
            this.observationTreatment.setModality(org.wheatgenetics.brapi1_3.studies.nour.ot
                .TreatmentAlertDialog.getEditTextStringText(this.modalityEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final io.swagger.client.model.ObservationTreatment observationTreatment)
    {
        if (null != observationTreatment)
        {
            this.observationTreatment = observationTreatment;

            org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentAlertDialog.setEditTextText(
                this.factorEditText, this.observationTreatment.getFactor());
            org.wheatgenetics.brapi1_3.studies.nour.ot.TreatmentAlertDialog.setEditTextText(
                this.modalityEditText, this.observationTreatment.getModality());

            this.show();
        }
    }
}