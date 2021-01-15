package org.phenoapps.usb;

/**
 * Uses:
 * android.app.Activity
 *
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.DeviceReader
 * org.wheatgenetics.usb.ScaleReader
 * org.wheatgenetics.usb.ScaleReader.Handler
 * org.wheatgenetics.usb.ScaleExceptionAlertDialog
 * org.wheatgenetics.usb.ScaleExceptionAlertDialog.Handler
 *
 * org.wheatgenetics.usb.DeviceReaderTester
 * org.wheatgenetics.usb.DeviceReaderTester.Publisher
 */
public class ScaleReaderTester extends org.phenoapps.usb.DeviceReaderTester
{
    private org.phenoapps.usb.ScaleExceptionAlertDialog scaleExceptionAlertDialog = null;

    private void reportException(final org.phenoapps.usb.Device.Exception e)
    {
        this.cancelReader();
        if (null == this.scaleExceptionAlertDialog) this.scaleExceptionAlertDialog =
            new org.phenoapps.usb.ScaleExceptionAlertDialog(this.getActivity(),
                new org.phenoapps.usb.ScaleExceptionAlertDialog.Handler()
                {
                    @java.lang.Override public void tryAgain()
                    { org.phenoapps.usb.ScaleReaderTester.this.executeReader(); }

                    @java.lang.Override public void ignore() {}
                });
        this.scaleExceptionAlertDialog.testingShow(e);
    }

    @java.lang.Override org.phenoapps.usb.DeviceReader deviceReader()
    {
        if (null == this.deviceReaderInstance)
            this.deviceReaderInstance = new org.phenoapps.usb.ScaleReader(this.getActivity(),
                /* handler => */ new org.phenoapps.usb.ScaleReader.Handler()
                    {
                        @java.lang.Override public void publish(final java.lang.String data)
                        { org.phenoapps.usb.ScaleReaderTester.this.publish(data); }

                        @java.lang.Override
                        public void reportException(final org.phenoapps.usb.Device.Exception e)
                        { org.phenoapps.usb.ScaleReaderTester.this.reportException(e); }
                    });
        return this.deviceReaderInstance;
    }

    public ScaleReaderTester(
    @androidx.annotation.NonNull final android.app.Activity                               activity ,
    @androidx.annotation.NonNull final org.phenoapps.usb.DeviceReaderTester.Publisher publisher)
    { super(activity, publisher); }
}