package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.Device.UsbDeviceIsNull
 */
public class ScaleExceptionAlertDialog extends org.wheatgenetics.androidlibrary.AlertDialog
{
    public interface Handler { public abstract void tryAgain(); public abstract void ignore(); }

    private final org.wheatgenetics.usb.ScaleExceptionAlertDialog.Handler handler;

    // region Private Methods
    private void tryAgain() { assert null != this.handler; this.handler.tryAgain(); }
    private void ignore  () { assert null != this.handler; this.handler.ignore  (); }
    // endregion

    public ScaleExceptionAlertDialog(
    @android.support.annotation.NonNull final android.app.Activity activity,
    @android.support.annotation.NonNull
        final org.wheatgenetics.usb.ScaleExceptionAlertDialog.Handler handler)
    { super(activity); this.handler = handler; }

    @java.lang.Override
    public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.scaleExceptionAlertDialogTitle)
            .setCancelableToFalse()
            .setPositiveButton(org.wheatgenetics.androidlibrary.
                    R.string.scaleExceptionAlertDialogPositiveButtonText,
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override
                    public void onClick(final android.content.DialogInterface dialog,
                    final int which)
                    { org.wheatgenetics.usb.ScaleExceptionAlertDialog.this.tryAgain(); }
                })
            .setNegativeButton(org.wheatgenetics.androidlibrary.
                    R.string.scaleExceptionAlertDialogNegativeButtonText,
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override
                    public void onClick(final android.content.DialogInterface dialog,
                    final int which)
                    { org.wheatgenetics.usb.ScaleExceptionAlertDialog.this.ignore(); }
                });
    }

    public void show(
    @android.support.annotation.NonNull final org.wheatgenetics.usb.Device.Exception e)
    {
        if (null != e)
        {
            {
                java.lang.String message = e.getMessage();
                if (e instanceof org.wheatgenetics.usb.Device.UsbDeviceIsNull)
                    message +=  "  " +  this.getString(
                        org.wheatgenetics.androidlibrary.R.string.scaleExceptionAlertDialogMessage);
                this.setMessage(message);
            }
            this.createShow();
        }
    }
}