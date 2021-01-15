package org.phenoapps.usb;

/**
 * Uses:
 * android.app.Activity
 *
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.DeviceReader
 * org.wheatgenetics.usb.DeviceReader.DataSource
 * org.wheatgenetics.usb.DeviceReader.Handler
 * org.wheatgenetics.usb.Scale
 */
public class ScaleReader extends org.phenoapps.usb.DeviceReader
{
    // region Fields
    @androidx.annotation.NonNull private final android.app.Activity activity;

    private org.phenoapps.usb.Scale scaleInstance = null;                           // lazy load
    // endregion

    // region Private Methods
    private org.phenoapps.usb.Scale scale()
    {
        if (null == this.scaleInstance)
            this.scaleInstance = new org.phenoapps.usb.Scale(this.activity);
        return this.scaleInstance;
    }

    private java.lang.String formattedRead() throws org.phenoapps.usb.Device.Exception
    { return this.scale().formattedRead(); }
    // endregion

    public ScaleReader(
    @androidx.annotation.NonNull final android.app.Activity                       activity,
    @androidx.annotation.NonNull final org.phenoapps.usb.DeviceReader.Handler handler )
    {
        super(handler); this.activity = activity;
        this.setDataSource(new org.phenoapps.usb.DeviceReader.DataSource()
            {
                @java.lang.Override public java.lang.String formattedRead()
                throws org.phenoapps.usb.Device.Exception
                { return org.phenoapps.usb.ScaleReader.this.formattedRead(); }
            });
    }

    @java.lang.Override public boolean cancel()
    { final boolean result = super.cancel(); this.scaleInstance = null; return result; }
}