package org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations;

/**
 * Uses:
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.Button
 * android.widget.TextView
 *
 * io.swagger.client.model.WSMIMEDataTypes
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.BaseConfirmAlertDialog
 */
class PhenotypesPostAlertDialog
extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.BaseConfirmAlertDialog
{
    // region Fields
    private android.widget.TextView                 formatTextView;
    private io.swagger.client.model.WSMIMEDataTypes format = null ;
    // endregion

    // region Private Methods
    private void showFormatAlertDialog() { /* TODO */ }

    private void setFormatTextViewText()
    {
        if (null != this.formatTextView)
            this.formatTextView.setText(null == this.format ? "null" : this.format.toString());
    }
    // endregion

    PhenotypesPostAlertDialog(final android.app.Activity activity, final
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.PhenotypesPostAlertDialog.Handler
        handler) { super(activity, handler,"ObservationsApi.phenotypesPost()");}

    @java.lang.Override public void configure()
    {
        final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
            .R.layout.alert_dialog_brapi1_3_observations_phenotypes_post);
        if (null != view)
        {
            if (null == this.formatTextView) this.formatTextView = view.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id
                    .observationsPhenotypesPostFormatValueTextView);
            {
                final android.widget.Button changeFormatButton = view.findViewById(org.wheatgenetics
                    .androidlibrarybuilder.R.id.observationsPhenotypesPostChangeFormatButton);
                if (null != changeFormatButton) changeFormatButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View view)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                                .PhenotypesPostAlertDialog.this.showFormatAlertDialog();
                        }
                    });
            }
        }
        this.configure(
            /* view       => */ view,
            /* textViewId => */ org.wheatgenetics.androidlibrarybuilder.R.id
                .observationsPhenotypesPostConfirmTextView);
    }

    // region Package Methods
    void show(final io.swagger.client.model.WSMIMEDataTypes format)
    { this.format = format; this.setFormatTextViewText(); this.show(); }

    io.swagger.client.model.WSMIMEDataTypes getFormat() { return this.format; }
    // endregion
}