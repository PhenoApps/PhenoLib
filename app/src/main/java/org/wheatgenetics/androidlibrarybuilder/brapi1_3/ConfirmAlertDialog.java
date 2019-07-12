package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.app.Activity
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.BaseConfirmAlertDialog
 */
public class ConfirmAlertDialog
extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.BaseConfirmAlertDialog
{
    public ConfirmAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConfirmAlertDialog.Handler handler,
    final java.lang.String title) { super(activity, handler, title); }

    @java.lang.Override public void configure()
    {
        this.configure(
            /* view => */ this.inflate(
                org.wheatgenetics.androidlibrarybuilder.R.layout.alert_dialog_brapi1_3_confirm),
            /* textViewId => */ org.wheatgenetics.androidlibrarybuilder.R.id.confirmTextView);
    }
}