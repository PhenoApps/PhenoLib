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

class Device extends java.lang.Object
{
    static abstract class Exception extends java.lang.Exception
    { Exception(final java.lang.String message) { super(message); }}

    static class UsbDeviceIsNull extends org.wheatgenetics.usb.Device.Exception
    { UsbDeviceIsNull() { super("Device.this.usbDevice is still null."); }}

    static class GetInterfaceFailed extends org.wheatgenetics.usb.Device.Exception
    { GetInterfaceFailed() { super("Device.this.usbDevice.getInterface(0) returned null."); }}

    static class OpenDeviceFailed extends org.wheatgenetics.usb.Device.Exception
    {
        OpenDeviceFailed() { super("Device.this.usbManager.openDevice() returned null."); }
        OpenDeviceFailed(final java.lang.String message) { super(message); }
    }

    static class OpenDeviceLacksPermission extends org.wheatgenetics.usb.Device.OpenDeviceFailed
    {
        OpenDeviceLacksPermission()
        { super("Device.this.usbManager.openDevice() lacks permission."); }
    }

    // region Fields
    private       android.hardware.usb.UsbDevice  usbDevice ;
    private final android.hardware.usb.UsbManager usbManager;

    private android.hardware.usb.UsbInterface        usbInterface        = null;
    private android.hardware.usb.UsbEndpoint         usbEndpoint         = null;
    private android.hardware.usb.UsbDeviceConnection usbDeviceConnection = null;
    // endregion

    // region Private Methods
    private java.lang.String getDeviceName()
    { return null == this.usbDevice ? null : this.usbDevice.getDeviceName(); }

    private int getProductId()
    { return null == this.usbDevice ? 0 : this.usbDevice.getProductId(); }

    private boolean close()
    {
        boolean released;

        if (null == this.usbDeviceConnection)
            released = true;
        else
        {
            released = this.usbDeviceConnection.releaseInterface(this.usbInterface);
            this.usbDeviceConnection.close();
            this.usbDeviceConnection = null;
        }

        this.usbEndpoint  = null;
        this.usbInterface = null;

        return released;
    }
    // endregion

    Device(final android.hardware.usb.UsbDevice usbDevice,
    @android.support.annotation.NonNull final android.hardware.usb.UsbManager usbManager)
    {
        super();

        this.usbDevice = usbDevice;

        assert null != usbManager;
        this.usbManager = usbManager;
    }

    // region Overridden Methods
    @java.lang.Override
    public java.lang.String toString()
    {
        java.lang.String returnValue = this.getDeviceName();
        if (null == returnValue) returnValue = super.toString();
        return returnValue;
    }

    @java.lang.Override
    protected void finalize() throws java.lang.Throwable
    {
        this.close();
        super.finalize();
    }
    // endregion

    // region Package Methods
    // region DeviceList Package Methods
    java.lang.String information()
    {
        if (this.usbDeviceIsNull())
            return null;
        else
            return java.lang.String.format("name=%s id=%d productId=%d vendorId=%d " +
                    "class=%d subClass=%d protocol=%d interfaceCount=%d",
                this.getDeviceName()              , this.usbDevice.getDeviceId      (),
                this.getProductId ()              , this.usbDevice.getVendorId      (),
                this.usbDevice.getDeviceClass   (), this.usbDevice.getDeviceSubclass(),
                this.usbDevice.getDeviceProtocol(), this.usbDevice.getInterfaceCount());
    }

    boolean productIdsAreEqual(final int productId)
    {
        if (this.usbDeviceIsNull())
            return false;
        else
            return 0 == productId ? false : this.getProductId() == productId;
    }
    // endregion

    // region ExtraDevice Package Methods
    boolean usbDeviceIsNull() { return null == this.usbDevice; }

    void setUsbDevice(final org.wheatgenetics.usb.Device device)
    { if (null != device) this.usbDevice = device.usbDevice; }
    // endregion

    int read(final byte buffer[]) throws org.wheatgenetics.usb.Device.Exception
    {
        if (this.usbDeviceIsNull())
            throw new org.wheatgenetics.usb.Device.UsbDeviceIsNull();
        else
        {
            if (null == this.usbInterface)
            {
                this.usbInterface = this.usbDevice.getInterface(0);
                if (null == this.usbInterface)
                    throw new org.wheatgenetics.usb.Device.GetInterfaceFailed();
            }

            if (null == this.usbEndpoint) this.usbEndpoint = this.usbInterface.getEndpoint(0);

            if (null == this.usbDeviceConnection)
            {
                this.usbDeviceConnection = this.usbManager.openDevice(this.usbDevice);
                if (null == this.usbDeviceConnection)
                    if (this.usbManager.hasPermission(this.usbDevice))
                        throw new org.wheatgenetics.usb.Device.OpenDeviceFailed();
                    else
                        throw new org.wheatgenetics.usb.Device.OpenDeviceLacksPermission();
                else
                    this.usbDeviceConnection.claimInterface(this.usbInterface, /* force => */ true);
            }

            return this.usbDeviceConnection.bulkTransfer(this.usbEndpoint, buffer,
                null == buffer ? 0 : buffer.length, /* timeout => */ 2000);
        }
    }

    java.lang.String formattedRead() throws org.wheatgenetics.usb.Device.Exception
    {
        int              length     ;
        java.lang.String data   = "";
        {
            final byte buffer[] = new byte[128];
            length = this.read(buffer);             // throws org.wheatgenetics.usb.Device.Exception
            data = org.wheatgenetics.javalib.Utils.convert(buffer);
        }
        return java.lang.String.format("length: %d, data: %s", length, data);
    }
    // endregion
}
