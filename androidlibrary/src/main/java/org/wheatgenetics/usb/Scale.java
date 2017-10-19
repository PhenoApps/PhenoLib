package org.wheatgenetics.usb;

/**
 * Uses:
 * android.annotation.SuppressLint
 * android.app.Activity
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.javalib.Utils
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.ExtraDevice
 */
class Scale extends org.wheatgenetics.usb.ExtraDevice
{
    // region Exceptions
    private static abstract class Exception extends org.wheatgenetics.usb.Device.Exception
    { private Exception(final java.lang.String message) { super(message); } }

    private static class BadLength extends org.wheatgenetics.usb.Scale.Exception
    { private BadLength() { super("Length of data read() is not equal to 6."); } }

    private static class BadReport extends org.wheatgenetics.usb.Scale.Exception
    {
        @android.annotation.SuppressLint("DefaultLocale")
        private BadReport(final byte report, final byte status)
        {
            super(java.lang.String.format(
                "report is %d (not 3) and status is %d.", report, status));
        }
    }

    private static class Fault extends org.wheatgenetics.usb.Scale.Exception
    { private Fault() { super("Scale reports FAULT!\n"); } }

    private static class UnderZero extends org.wheatgenetics.usb.Scale.Exception
    { private UnderZero() { super("Scale reports Under Zero"); } }

    private static class OverWeight extends org.wheatgenetics.usb.Scale.Exception
    { private OverWeight() { super("Scale reports Over Weight!"); } }

    private static class CalibrationNeeded extends org.wheatgenetics.usb.Scale.Exception
    { private CalibrationNeeded() { super("Scale reports Calibration Needed!"); } }

    private static class RezeroingNeeded extends org.wheatgenetics.usb.Scale.Exception
    { private RezeroingNeeded() { super("Scale reports Re-zeroing Needed!\n"); } }

    private static class UnknownStatus extends org.wheatgenetics.usb.Scale.Exception
    { private UnknownStatus() { super("Unknown status code"); } }
    // endregion

    // region Constants
            static final int ELANEVendorId            = 31612                                  ;
    private static final int ELANEUSBPlus5kgProductId =   513, ELANEUSBPS20005kgProductId = 519;
            static final int ELANEProductIds[]        =
        { ELANEUSBPS20005kgProductId, ELANEUSBPlus5kgProductId };
    // endregion

    private double weight;

    Scale(@android.support.annotation.NonNull final android.app.Activity activity)
    {
        super(activity, org.wheatgenetics.usb.Scale.ELANEVendorId,
            org.wheatgenetics.usb.Scale.ELANEProductIds);
    }

    // region Overridden Methods
    @java.lang.Override
    int read(final byte buffer[]) throws org.wheatgenetics.usb.Device.Exception
    {
        final int length = super.read(buffer);      // throws org.wheatgenetics.usb.Device.Exception

        if (6 == length)
        {
            assert null != buffer; final byte report = buffer[0], status = buffer[1];
            if (3 == report)
                switch (status)
                {
                    case 1: throw new org.wheatgenetics.usb.Scale.Fault();

                    case 2: case 3: case 4:                  // 3 == weighing;  2, 4 == final weight
                        {
                            final byte LSB  = buffer[4] , MSB = buffer[5];

                            this.weight =
                                org.wheatgenetics.javalib.Utils.interpretAsUnsigned(MSB) * 256 +
                                org.wheatgenetics.javalib.Utils.interpretAsUnsigned(LSB);
                        }
                        if (this.idsAreEqual(org.wheatgenetics.usb.Scale.ELANEVendorId,
                        org.wheatgenetics.usb.Scale.ELANEUSBPS20005kgProductId))
                            this.weight /= 10.0;
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
        super.formattedRead();                      // throws org.wheatgenetics.usb.Device.Exception
        return java.lang.Double.toString(this.weight);
    }
    // endregion
}