package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.ExtraDevice
 */

public class ScaleTester extends java.lang.Object
{
    private final android.app.Activity              activity                  ;
    private       org.wheatgenetics.usb.ExtraDevice extraDeviceInstance = null;

    private org.wheatgenetics.usb.ExtraDevice extraDevice()
    {
        if (null == this.extraDeviceInstance)
            this.extraDeviceInstance = new org.wheatgenetics.usb.ExtraDevice(this.activity, 513);
        return this.extraDeviceInstance;
    }

    public ScaleTester(@android.support.annotation.NonNull final android.app.Activity activity)
    {
        super();

        assert null != activity;
        this.activity = activity;
    }

    public java.lang.String information() { return this.extraDevice().information(); }

    public java.lang.String read()
    {
              int  length                  ;
        final byte buffer[] = new byte[128];
        try { length = this.extraDevice().read(buffer); }
        catch (final org.wheatgenetics.usb.Device.Exception e) { return e.getMessage(); }
        return java.lang.String.format("length: %d, buffer: %s", length, buffer.toString());
    }
}