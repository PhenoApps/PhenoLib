package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.DeviceReader
 * org.wheatgenetics.usb.DeviceReader.Handler
 * org.wheatgenetics.usb.Scale
 */

public class ScaleReader extends org.wheatgenetics.usb.DeviceReader
{
    public interface Handler
    {
        public abstract void publish        (java.lang.String data   );
        public abstract void reportException(java.lang.String message);
    }

    // region Fields
    private final android.app.Activity                      activity;
    private final org.wheatgenetics.usb.ScaleReader.Handler handler ;

    private org.wheatgenetics.usb.Scale scaleInstance = null;
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

    private void publish(final java.lang.String data)
    {
        assert null != this.handler;
        this.handler.publish(data);
    }

    private void reportException(final java.lang.String message)
    {
        assert null != this.handler;
        this.handler.reportException(message);
    }
    // endregion

    public ScaleReader(@android.support.annotation.NonNull final android.app.Activity activity,
    @android.support.annotation.NonNull final org.wheatgenetics.usb.ScaleReader.Handler handler)
    {
        super();

        assert null != activity;
        this.activity = activity;

        assert null != handler;
        this.handler = handler;

        this.setHandler(new org.wheatgenetics.usb.DeviceReader.Handler()
            {
                @java.lang.Override
                public java.lang.String formattedRead()
                throws org.wheatgenetics.usb.Device.Exception
                { return org.wheatgenetics.usb.ScaleReader.this.formattedRead(); }

                @java.lang.Override
                public void publish(final java.lang.String data)
                { org.wheatgenetics.usb.ScaleReader.this.publish(data); }

                @java.lang.Override
                public void reportException(final java.lang.String message)
                { org.wheatgenetics.usb.ScaleReader.this.reportException(message); }
            });
    }
}