package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.AlertDialog
 * android.app.AlertDialog.Builder
 * android.content.Context
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.Device.UsbDeviceIsNull
 */

class ScaleExceptionAlertDialog extends java.lang.Object
{
    interface Handler
    {
        public abstract void tryAgain();
        public abstract void ignore  ();
    }

    // region Fields
    private final android.content.Context                                 context;
    private final org.wheatgenetics.usb.ScaleExceptionAlertDialog.Handler handler;

    private android.app.AlertDialog.Builder builder     = null;
    private android.app.AlertDialog         alertDialog = null;
    // endregion

    // region Private Methods
    private void tryAgain()
    {
        assert null != this.handler;
        this.handler.tryAgain();
    }

    private void ignore()
    {
        assert null != this.handler;
        this.handler.ignore();
    }
    // endregion

    // region Package Methods
    ScaleExceptionAlertDialog(
    @android.support.annotation.NonNull final android.content.Context context,
    @android.support.annotation.NonNull
        final org.wheatgenetics.usb.ScaleExceptionAlertDialog.Handler handler)
    {
        super();

        assert null != context;
        this.context = context;

        assert null != handler;
        this.handler = handler;
    }

    void show(@android.support.annotation.NonNull final org.wheatgenetics.usb.Device.Exception e)
    {
        if (null != e)
        {
            if (null == this.alertDialog)
            {
                if (null == this.builder)
                {
                    this.builder = new android.app.AlertDialog.Builder(this.context);
                    this.builder.setTitle(org.wheatgenetics.androidlibrary.
                            R.string.scaleExceptionAlertDialogTitle)
                        .setCancelable    (false)
                        .setPositiveButton(
                            org.wheatgenetics.androidlibrary.
                                R.string.scaleExceptionAlertDialogPositiveButtonText,
                            new android.content.DialogInterface.OnClickListener()
                            {
                                @java.lang.Override
                                public void onClick(final android.content.DialogInterface dialog,
                                final int which)
                                { org.wheatgenetics.usb.ScaleExceptionAlertDialog.this.tryAgain(); }
                            })
                        .setNegativeButton(
                            org.wheatgenetics.androidlibrary.
                                R.string.scaleExceptionAlertDialogNegativeButtonText,
                            new android.content.DialogInterface.OnClickListener()
                            {
                                @java.lang.Override
                                public void onClick(final android.content.DialogInterface dialog,
                                final int which)
                                { org.wheatgenetics.usb.ScaleExceptionAlertDialog.this.ignore(); }
                            });
                }
                this.alertDialog = this.builder.create();
                assert null != this.alertDialog;
            }

            java.lang.String message;
            if (e instanceof org.wheatgenetics.usb.Device.UsbDeviceIsNull)
            {
                assert null != this.context;
                message = e.getMessage() + "  " + this.context.getString(
                    org.wheatgenetics.androidlibrary.R.string.scaleExceptionAlertDialogMessage);
            }
            else message = e.getMessage();
            this.alertDialog.setMessage(message);

            this.alertDialog.show();
        }
    }
    // endregion
}