package org.wheatgenetics.brapi1_3.studies.nour.oux;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.widget.EditText
 *
 * io.swagger.client.model.ObservationUnitXref
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 */
class ObservationUnitXrefAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    // region Fields
    private android.widget.EditText                     idEditText, sourceEditText;
    private io.swagger.client.model.ObservationUnitXref observationUnitXref = null;
    // endregion

    ObservationUnitXrefAlertDialog(final android.app.Activity activity, final
    org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(
            org.wheatgenetics.androidlibrary.R.string.ObservationUnitXrefAlertDialogTitle);
        {
            final android.view.View view = this.inflate(org.wheatgenetics
                .androidlibrary.R.layout.alert_dialog_brapi1_3_studies_observationunitxref);
            if (null != view)
            {
                if (null == this.idEditText) this.idEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesObservationUnitXrefIdEditText);
                if (null == this.sourceEditText) this.sourceEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesObservationUnitXrefSourceEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.observationUnitXref)
        {
            this.observationUnitXref.setId(org.wheatgenetics.brapi1_3.studies.nour.oux
                .ObservationUnitXrefAlertDialog.getEditTextStringText(this.idEditText));
            this.observationUnitXref.setSource(org.wheatgenetics.brapi1_3.studies.nour.oux
                .ObservationUnitXrefAlertDialog.getEditTextStringText(this.sourceEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final io.swagger.client.model.ObservationUnitXref observationUnitXref)
    {
        if (null != observationUnitXref)
        {
            this.observationUnitXref = observationUnitXref;

            org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefAlertDialog
                .setEditTextText(this.idEditText, this.observationUnitXref.getId());
            org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefAlertDialog
                .setEditTextText(this.sourceEditText, this.observationUnitXref.getSource());

            this.show();
        }
    }
}