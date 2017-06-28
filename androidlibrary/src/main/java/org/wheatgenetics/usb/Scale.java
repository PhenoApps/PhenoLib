package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.ExtraDevice
 */

class Scale extends org.wheatgenetics.usb.ExtraDevice
{
    // region Types
    static class Exception extends org.wheatgenetics.usb.Device.Exception
    { Exception(final java.lang.String message) { super(message); }}

    static class BadLength extends org.wheatgenetics.usb.Scale.Exception
    { BadLength() { super("Length of data read() is not equal to 6."); }}

    static class BadReport extends org.wheatgenetics.usb.Scale.Exception
    {
        BadReport(final byte report, final byte status)
        {
            super(java.lang.String.format(
                "report is %d (not 3) and status is %d.", report, status));
        }
    }

    static class Fault extends org.wheatgenetics.usb.Scale.Exception
    { Fault() { super("Scale reports FAULT!\n"); }}

    static class UnderZero extends org.wheatgenetics.usb.Scale.Exception
    { UnderZero() { super("Scale reports Under Zero"); }}

    static class OverWeight extends org.wheatgenetics.usb.Scale.Exception
    { OverWeight() { super("Scale reports Over Weight!"); }}

    static class CalibrationNeeded extends org.wheatgenetics.usb.Scale.Exception
    { CalibrationNeeded() { super("Scale reports Calibration Needed!"); }}

    static class RezeroingNeeded extends org.wheatgenetics.usb.Scale.Exception
    { RezeroingNeeded() { super("Scale reports Re-zeroing Needed!\n"); }}

    static class UnknownStatus extends org.wheatgenetics.usb.Scale.Exception
    { UnknownStatus() { super("Unknown status code"); }}
    // endregion

    private double weight;

    Scale(@android.support.annotation.NonNull final android.app.Activity activity)
    { super(activity, 513); }

    // region Overridden Methods
    @java.lang.Override
    int read(final byte buffer[]) throws org.wheatgenetics.usb.Device.Exception
    {
        final int length = super.read(buffer);

        if (6 == length)
        {
            final byte report = buffer[0], status = buffer[1];
            if (3 == report)
                switch (status)
                {
                    case 1: throw new org.wheatgenetics.usb.Scale.Fault();

                    case 2: case 3: case 4:
                        final byte LSB = buffer[4], MSB = buffer[5];
                        this.weight = MSB * 256.0 + LSB;
                        break;

                    case 5 : throw new org.wheatgenetics.usb.Scale.UnderZero        ();
                    case 6 : throw new org.wheatgenetics.usb.Scale.OverWeight       ();
                    case 7 : throw new org.wheatgenetics.usb.Scale.CalibrationNeeded();
                    case 8 : throw new org.wheatgenetics.usb.Scale.RezeroingNeeded  ();
                    default: throw new org.wheatgenetics.usb.Scale.UnknownStatus    ();
                }
            else throw new org.wheatgenetics.usb.Scale.BadReport(report, status);
        }
        else throw new org.wheatgenetics.usb.Scale.BadLength();

        return length;
    }

    @java.lang.Override
    java.lang.String formattedRead() throws org.wheatgenetics.usb.Device.Exception
    {
        super.formattedRead();
        return java.lang.Double.toString(this.weight);
    }
    // endregion
}