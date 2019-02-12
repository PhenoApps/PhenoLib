package org.wheatgenetics.usb;

/**
 * Uses:
 * android.hardware.usb.UsbDevice
 * android.hardware.usb.UsbDeviceConnection
 * android.hardware.usb.UsbEndpoint
 * android.hardware.usb.UsbInterface
 * android.hardware.usb.UsbManager
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.javalib.Utils
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Device extends java.lang.Object
{
    // region Types
    public abstract static class Exception extends java.lang.Exception
    { Exception(final java.lang.String message) { super(message); } }

    static class UsbDeviceIsNull extends org.wheatgenetics.usb.Device.Exception
    {
                UsbDeviceIsNull(final java.lang.String message) { super(message); }
        private UsbDeviceIsNull()       { this("Device.this.usbDevice is null."); }
    }

    private static class GetInterfaceFailed extends org.wheatgenetics.usb.Device.Exception
    {
        private GetInterfaceFailed()
        { super("Device.this.usbDevice.getInterface(0) returned null."); }
    }

    private static class UsbManagerIsNull extends org.wheatgenetics.usb.Device.Exception
    { private UsbManagerIsNull() { super("Device.this.usbManager is null."); } }

    private static class OpenDeviceFailed extends org.wheatgenetics.usb.Device.Exception
    {
        private OpenDeviceFailed(final java.lang.String message)               { super(message); }
        private OpenDeviceFailed() { this("Device.this.usbManager.openDevice() returned null."); }
    }

    private static class OpenDeviceLacksPermission
    extends org.wheatgenetics.usb.Device.OpenDeviceFailed
    {
        private OpenDeviceLacksPermission()
        { super("Device.this.usbManager.openDevice() lacks permission."); }
    }
    // endregion

    // region Fields
    private       android.hardware.usb.UsbDevice  usbDevice ;
    private final android.hardware.usb.UsbManager usbManager;

    private android.hardware.usb.UsbInterface        usbInterface        = null;
    private android.hardware.usb.UsbEndpoint         usbEndpoint         = null;
    private android.hardware.usb.UsbDeviceConnection usbDeviceConnection = null;
    // endregion

    // region Private Methods
    private java.lang.String getDeviceName()
    { return this.usbDeviceIsNull() ? null : this.usbDevice.getDeviceName(); }

    private int getVendorId() { return this.usbDeviceIsNull() ? 0 : this.usbDevice.getVendorId(); }

    private int getProductId()
    { return this.usbDeviceIsNull() ? 0 : this.usbDevice.getProductId(); }

    @java.lang.SuppressWarnings({"UnusedReturnValue"}) private boolean close()
    {
        final boolean released;
        if (null == this.usbDeviceConnection)
            released = true;
        else
        {
            released = this.usbDeviceConnection.releaseInterface(this.usbInterface);
            this.usbDeviceConnection.close();
            this.usbDeviceConnection = null;
        }
        this.usbEndpoint = null; this.usbInterface = null;
        return released;
    }
    // endregion

    Device(
                                        final android.hardware.usb.UsbDevice  usbDevice ,
    @android.support.annotation.NonNull final android.hardware.usb.UsbManager usbManager)
    { super(); this.usbDevice = usbDevice; this.usbManager = usbManager; }

    // region Overridden Methods
    @android.support.annotation.NonNull @java.lang.Override public java.lang.String toString()
    {
        return org.wheatgenetics.javalib.Utils.replaceIfNull(
            this.getDeviceName(), super.toString());
    }

    @java.lang.Override protected void finalize() throws java.lang.Throwable
    { this.close(); super.finalize(); }
    // endregion

    // region Package Methods
    // region DeviceList Package Methods
    @java.lang.SuppressWarnings({"DefaultLocale"}) java.lang.String information()
    {
        return this.usbDeviceIsNull() ? null : java.lang.String.format("name=%s id=%d " +
                "productId=%d vendorId=%d class=%d subClass=%d protocol=%d interfaceCount=%d",
            this.getDeviceName              (), this.usbDevice.getDeviceId      (),
            this.getProductId               (), this.getVendorId                (),
            this.usbDevice.getDeviceClass   (), this.usbDevice.getDeviceSubclass(),
            this.usbDevice.getDeviceProtocol(), this.usbDevice.getInterfaceCount());
    }

    boolean idsAreEqual(final int vendorId, final int productId)
    {
        if (this.usbDeviceIsNull())
            return false;
        else
            // noinspection SimplifiableConditionalExpression
            return 0 == vendorId || 0 == productId ? false :
                this.getVendorId() == vendorId && this.getProductId() == productId;
    }
    // endregion

    // region ExtraDevice Package Methods
    boolean usbDeviceIsNull() { return null == this.usbDevice; }

    void setUsbDevice(final org.wheatgenetics.usb.Device device)
    { if (null != device) this.usbDevice = device.usbDevice; }
    // endregion

    int read(final byte buffer[]) throws org.wheatgenetics.usb.Device.Exception
    {
        try
        {
            if (this.usbDeviceIsNull())
                throw new org.wheatgenetics.usb.Device.UsbDeviceIsNull();
            else
            {
                if (null == this.usbInterface)                                         // Lazy load.
                {
                    this.usbInterface = this.usbDevice.getInterface(0);
                    // noinspection ConstantConditions
                    if (null == this.usbInterface)
                        throw new org.wheatgenetics.usb.Device.GetInterfaceFailed();
                }

                if (null == this.usbEndpoint)                                          // Lazy load.
                    this.usbEndpoint = this.usbInterface.getEndpoint(0);

                if (null == this.usbDeviceConnection)                                  // Lazy load.
                {
                    if (null == this.usbManager)
                        throw new org.wheatgenetics.usb.Device.UsbManagerIsNull();

                    this.usbDeviceConnection = this.usbManager.openDevice(this.usbDevice);
                    if (null == this.usbDeviceConnection)
                        if (this.usbManager.hasPermission(this.usbDevice))
                            throw new org.wheatgenetics.usb.Device.OpenDeviceFailed();
                        else
                            throw new org.wheatgenetics.usb.Device.OpenDeviceLacksPermission();
                    else
                        this.usbDeviceConnection.claimInterface(
                            this.usbInterface, /* force => */true);
                }

                return this.usbDeviceConnection.bulkTransfer(
                    /* endpoint => */ this.usbEndpoint                  ,
                    /* buffer   => */ buffer                            ,
                    /* length   => */ null == buffer ? 0 : buffer.length,
                    /* timeout  => */2000 /* milliseconds */);
            }
        }
        catch (final org.wheatgenetics.usb.Device.Exception e) { this.close(); throw e; }
    }

    @java.lang.SuppressWarnings({"DefaultLocale"})
    java.lang.String formattedRead() throws org.wheatgenetics.usb.Device.Exception
    {
        final int length; final java.lang.String data;
        {
            final byte buffer[] = new byte[128];
            length = this.read(buffer);             // throws org.wheatgenetics.usb.Device.Exception
            data   = org.wheatgenetics.javalib.Utils.convert(buffer, length);
        }
        return java.lang.String.format("length: %d, data: %s", length, data);
    }
    // endregion
}