package org.phenoapps.usb;

/**
 * Uses:
 * android.app.Activity
 *
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.usb.Device.Exception
 * org.wheatgenetics.usb.DeviceReader
 * org.wheatgenetics.usb.DeviceReader.DataSource
 * org.wheatgenetics.usb.DeviceReader.Handler
 * org.wheatgenetics.usb.ExtraDevice
 * org.wheatgenetics.usb.Scale
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class DeviceReaderTester extends java.lang.Object
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Publisher
    { public abstract void publish(java.lang.String data); }

    // region Fields
    private final android.app.Activity                               activity ;
    private final org.phenoapps.usb.DeviceReaderTester.Publisher publisher;

            org.phenoapps.usb.DeviceReader deviceReaderInstance = null;
    private org.phenoapps.usb.ExtraDevice  extraDevice          = null;
    // endregion

    private java.lang.String formattedRead() throws org.phenoapps.usb.Device.Exception
    {
        if (null == this.extraDevice) this.extraDevice = new org.phenoapps.usb.ExtraDevice(
            this.getActivity()                         ,
            org.phenoapps.usb.Scale.ELANEVendorId  ,
            org.phenoapps.usb.Scale.ELANEProductIds);
        return this.extraDevice.formattedRead();
    }

    public DeviceReaderTester(
    @androidx.annotation.NonNull final android.app.Activity                               activity ,
    @androidx.annotation.NonNull final org.phenoapps.usb.DeviceReaderTester.Publisher publisher)
    { super(); this.activity = activity; this.publisher = publisher; }

    // region Package Methods
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    void publish(final java.lang.String data)
    { assert null != this.publisher; this.publisher.publish(data); }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    android.app.Activity getActivity() { return this.activity; }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    org.phenoapps.usb.DeviceReader deviceReader()
    {
        if (null == this.deviceReaderInstance)
            this.deviceReaderInstance = new org.phenoapps.usb.DeviceReader(
                /* handler => */ new org.phenoapps.usb.DeviceReader.Handler()
                    {
                        @java.lang.Override public void publish(final java.lang.String data)
                        { org.phenoapps.usb.DeviceReaderTester.this.publish(data); }

                        @java.lang.Override
                        public void reportException(final org.phenoapps.usb.Device.Exception e)
                        {
                            assert null != e;
                            org.phenoapps.usb.DeviceReaderTester.this.publish(e.getMessage());
                        }
                    },
                /* dataSource => */ new org.phenoapps.usb.DeviceReader.DataSource()
                    {
                        @java.lang.Override public java.lang.String formattedRead()
                        throws org.phenoapps.usb.Device.Exception
                        { return org.phenoapps.usb.DeviceReaderTester.this.formattedRead(); }
                    });
        return this.deviceReaderInstance;
    }
    // endregion

    // region Public Methods
    public void executeReader() { this.deviceReader().execute(); }

    @java.lang.SuppressWarnings({"UnusedReturnValue"}) public boolean cancelReader()
    { return this.deviceReader().cancel(); }
    // endregion
}