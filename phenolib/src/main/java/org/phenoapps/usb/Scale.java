package org.phenoapps.usb;

/**
 * Uses:
 * android.app.Activity
 * android.util.Log
 *
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.javalib.Utils
 *
 * org.wheatgenetics.androidlibrary.BuildConfig
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.ExtraDevice
 */
class Scale extends org.phenoapps.usb.ExtraDevice
{
    // region Types
    private static abstract class Exception extends org.phenoapps.usb.Device.Exception
    { private Exception(final java.lang.String message) { super(message); } }

    private static class BadLength extends org.phenoapps.usb.Scale.Exception
    { private BadLength() { super("Length of data read() is not equal to 6."); } }

    private static class BadReport extends org.phenoapps.usb.Scale.Exception
    {
        @java.lang.SuppressWarnings({"DefaultLocale"})
        private BadReport(final byte report, final byte status)
        {
            super(java.lang.String.format(
                "report is %d (not 3) and status is %d.", report, status));
        }
    }

    private static class Fault extends org.phenoapps.usb.Scale.Exception
    { private Fault() { super("Scale reports FAULT!\n"); } }

    private static class OverWeight extends org.phenoapps.usb.Scale.Exception
    { private OverWeight() { super("Scale reports Over Weight!"); } }

    private static class CalibrationNeeded extends org.phenoapps.usb.Scale.Exception
    { private CalibrationNeeded() { super("Scale reports Calibration Needed!"); } }

    private static class RezeroingNeeded extends org.phenoapps.usb.Scale.Exception
    { private RezeroingNeeded() { super("Scale reports Re-zeroing Needed!\n"); } }

    private static class UnknownStatus extends org.phenoapps.usb.Scale.Exception
    { private UnknownStatus() { super("Unknown status code"); } }
    // endregion

    // region Constants
            static final int ELANEVendorId            = 31612                                  ;
    private static final int ELANEUSBPlus5kgProductId =   513, ELANEUSBPS20005kgProductId = 519;
    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"}) static final int ELANEProductIds[] = {
        ELANEUSBPS20005kgProductId, ELANEUSBPlus5kgProductId};
    // endregion

    private double weight;

    // region Private Methods
    private static void sendDebugLogMsg(final java.lang.String msg)
    { android.util.Log.d("Scale", msg); }

    private static void sendDebugLogMsg(final java.lang.String label, final int unsignedByte)
    {
        org.phenoapps.usb.Scale.sendDebugLogMsg(java.lang.String.format(label + ":%8s|%3d",
            java.lang.Integer.toBinaryString(unsignedByte), unsignedByte).replace(
                ' ','0'));
    }

    private static void sendDebugLogMsg(final byte MSB, final byte LSB)
    {
        {
            final int unsignedMSB = org.phenoapps.androidlibrary.Utils.interpretAsUnsigned(MSB);
            org.phenoapps.usb.Scale.sendDebugLogMsg("MSB===>", unsignedMSB);
            org.phenoapps.usb.Scale.sendDebugLogMsg("MSB*256",
                unsignedMSB * 256);
        }
        org.phenoapps.usb.Scale.sendDebugLogMsg("LSB===>",
            org.phenoapps.androidlibrary.Utils.interpretAsUnsigned(LSB));
        org.phenoapps.usb.Scale.sendDebugLogMsg("=====================");
    }
    // endregion

    Scale(@androidx.annotation.NonNull final android.app.Activity activity)
    {
        super(activity, org.phenoapps.usb.Scale.ELANEVendorId,
            org.phenoapps.usb.Scale.ELANEProductIds);
    }

    // region Overridden Methods
    @java.lang.Override int read(@androidx.annotation.NonNull
    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"}) final byte buffer[])
    throws org.phenoapps.usb.Device.Exception
    {
        final int length = super.read(buffer);      // throws org.wheatgenetics.usb.Device.Exception

        if (6 == length)
        {
            final byte report = buffer[0], status = buffer[1];
            if (3 == report)
                switch (status)
                {
                    case 1: throw new org.phenoapps.usb.Scale.Fault();

                    case 2: case 3: case 4: case 5: // 3: weighing; 2,4: final weight; 5: under zero
                        {
                            final boolean underZero = 5 == status;
                            {
                                final byte
                                    LSB = underZero ? (byte) (1 + ~buffer[4]) : buffer[4],
                                    MSB = underZero ? (byte)      ~buffer[5]  : buffer[5];

                                if (org.phenoapps.androidlibrary.BuildConfig.DEBUG)
                                    org.phenoapps.usb.Scale.sendDebugLogMsg(MSB, LSB);

                                this.weight =
                                    org.phenoapps.androidlibrary.Utils.interpretAsUnsigned(MSB) * 256 +
                                    org.phenoapps.androidlibrary.Utils.interpretAsUnsigned(LSB);
                            }
                            if (underZero) this.weight *= -1.0;
                        }
                        if (this.idsAreEqual(org.phenoapps.usb.Scale.ELANEVendorId,
                        org.phenoapps.usb.Scale.ELANEUSBPS20005kgProductId))
                            this.weight /= 10.0;
                        break;

                    case 6 : throw new org.phenoapps.usb.Scale.OverWeight       ();
                    case 7 : throw new org.phenoapps.usb.Scale.CalibrationNeeded();
                    case 8 : throw new org.phenoapps.usb.Scale.RezeroingNeeded  ();
                    default: throw new org.phenoapps.usb.Scale.UnknownStatus    ();
                }
            else throw new org.phenoapps.usb.Scale.BadReport(report, status);
        }
        else throw new org.phenoapps.usb.Scale.BadLength();

        return length;
    }

    @java.lang.Override
    java.lang.String formattedRead() throws org.phenoapps.usb.Device.Exception
    {
        super.formattedRead();                      // throws org.wheatgenetics.usb.Device.Exception
        return java.lang.Double.toString(this.weight);
    }
    // endregion
}