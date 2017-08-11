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
public class ScaleExceptionAlertDialog extends java.lang.Object
{
    public interface Handler
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

    // region Public Methods
    public ScaleExceptionAlertDialog(
    @android.support.annotation.NonNull final android.content.Context context,
    @android.support.annotation.NonNull
        final org.wheatgenetics.usb.ScaleExceptionAlertDialog.Handler handler)
    {
        super();

        this.context = context;
        this.handler = handler;
    }

    public void show(
    @android.support.annotation.NonNull final org.wheatgenetics.usb.Device.Exception e)
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
                                {
                                    org.wheatgenetics.usb.ScaleExceptionAlertDialog.this.ignore();
                                    assert null != dialog;
                                    dialog.cancel();
                                }
                            });
                }
                this.alertDialog = this.builder.create();
                assert null != this.alertDialog;
            }

            {
                java.lang.String message = e.getMessage();
                if (e instanceof org.wheatgenetics.usb.Device.UsbDeviceIsNull)
                {
                    assert null != this.context;
                    message += "  " + this.context.getString(
                        org.wheatgenetics.androidlibrary.R.string.scaleExceptionAlertDialogMessage);
                }
                this.alertDialog.setMessage(message);
            }

            this.alertDialog.show();
        }
    }
    // endregion
}