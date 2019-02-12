package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.DeviceReader
 * org.wheatgenetics.usb.DeviceReader.DataSource
 * org.wheatgenetics.usb.DeviceReader.Handler
 * org.wheatgenetics.usb.Scale
 */
public class ScaleReader extends org.wheatgenetics.usb.DeviceReader
{
    // region Fields
    private final android.app.Activity        activity            ;
    private       org.wheatgenetics.usb.Scale scaleInstance = null;
    // endregion

    // region Private Methods
    private org.wheatgenetics.usb.Scale scale()
    {
        if (null == this.scaleInstance)
            this.scaleInstance = new org.wheatgenetics.usb.Scale(this.activity);
        return this.scaleInstance;
    }

    private java.lang.String formattedRead() throws org.wheatgenetics.usb.Device.Exception
    { return this.scale().formattedRead(); }
    // endregion

    @java.lang.SuppressWarnings({"WeakerAccess"}) public ScaleReader(
    @android.support.annotation.NonNull final android.app.Activity                       activity,
    @android.support.annotation.NonNull final org.wheatgenetics.usb.DeviceReader.Handler handler )
    {
        super(handler); this.activity = activity;
        this.setDataSource(new org.wheatgenetics.usb.DeviceReader.DataSource()
            {
                @java.lang.Override public java.lang.String formattedRead()
                throws org.wheatgenetics.usb.Device.Exception
                { return org.wheatgenetics.usb.ScaleReader.this.formattedRead(); }
            });
    }

    @java.lang.Override public boolean cancel()
    { final boolean result = super.cancel(); this.scaleInstance = null; return result; }
}