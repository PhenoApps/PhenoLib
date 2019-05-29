package org.wheatgenetics.brapi1_3.studies;

/**
 * Uses:
 * android.app.Activity
 * android.view.View
 *
 * io.swagger.client.model.NewObservationUnitRequest
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 */
public class NewObservationUnitRequestAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog//TODO
{
    private io.swagger.client.model.NewObservationUnitRequest newObservationUnitRequest = null;

    public NewObservationUnitRequestAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.studies.NewObservationUnitRequestAlertDialog.Handler handler)
    { super(activity, handler); }

    @Override
    public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary
            .R.string.NewObservationUnitRequestAlertDialogTitle);
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrary
                .R.layout.new_observation_unit_request_alert_dialog);
            if (null != view)
            {
                ;
            }
            this.setView(view);
        }
        super.configure();
    }

    public void show(
    final io.swagger.client.model.NewObservationUnitRequest newObservationUnitRequest)
    {
        if (null != newObservationUnitRequest)
        {
            this.newObservationUnitRequest = newObservationUnitRequest;

            ;

            this.show();
        }
    }
}