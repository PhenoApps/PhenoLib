package org.phenoapps.usb;

/**
 * Uses:
 * android.app.Activity
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 *
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.Device.UsbDeviceIsNull
 */
public class ScaleExceptionAlertDialog extends org.phenoapps.androidlibrary.AlertDialog
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Handler
    {
        public abstract void tryAgain();
        public abstract void ignore  ();
    }

    @androidx.annotation.NonNull
    private final org.phenoapps.usb.ScaleExceptionAlertDialog.Handler handler;

    // region Private Methods
    private void tryAgain() { this.handler.tryAgain(); }
    private void ignore  () { this.handler.ignore  (); }
    // endregion

    public ScaleExceptionAlertDialog(
    @androidx.annotation.NonNull final android.app.Activity activity,
    @androidx.annotation.NonNull
        final org.phenoapps.usb.ScaleExceptionAlertDialog.Handler handler)
    { super(activity); this.handler = handler; }

    @java.lang.Override public void configure()
    {
        this.setTitle(org.phenoapps.androidlibrary.R.string.scaleExceptionAlertDialogTitle)
            .setCancelableToFalse().setPositiveButton(org.phenoapps.androidlibrary.
                    R.string.scaleExceptionAlertDialogPositiveButtonText,
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override public void onClick(
                    final android.content.DialogInterface dialog, final int which)
                    { org.phenoapps.usb.ScaleExceptionAlertDialog.this.tryAgain(); }
                })
            .setNegativeButton(org.phenoapps.androidlibrary.
                    R.string.scaleExceptionAlertDialogNegativeButtonText,
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override public void onClick(
                    final android.content.DialogInterface dialog, final int which)
                    { org.phenoapps.usb.ScaleExceptionAlertDialog.this.ignore(); }
                });
    }

    // region Public Methods
    public void testingShow(
    @androidx.annotation.NonNull final org.phenoapps.usb.Device.Exception e)
    { this.setMessage(e.getMessage()); this.createShow(); }

    public void show(@androidx.annotation.NonNull final org.phenoapps.usb.Device.Exception e)
    {
        if (e instanceof org.phenoapps.usb.Device.UsbDeviceIsNull)
        {
            class PolishedUsbDeviceIsNull extends org.phenoapps.usb.Device.UsbDeviceIsNull
            {
                private PolishedUsbDeviceIsNull(final java.lang.String message)
                { super(message); }
            }
            this.testingShow(new PolishedUsbDeviceIsNull(this.getString(
                org.phenoapps.androidlibrary.R.string.scaleExceptionAlertDialogMessage)));
        }
        else this.testingShow(e);
    }
    // endregion
}