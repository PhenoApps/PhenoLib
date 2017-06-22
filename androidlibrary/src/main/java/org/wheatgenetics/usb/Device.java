package org.wheatgenetics.usb;

/**
 * Uses:
 * android.hardware.usb.UsbDevice
 */

class Device extends java.lang.Object
{
    private android.hardware.usb.UsbDevice usbDevice;

    // region Private Methods
    private java.lang.String getDeviceName()
    {
        assert null != this.usbDevice;
        return this.usbDevice.getDeviceName();
    }

    private int getProductId()
    {
        assert null != this.usbDevice;
        return this.usbDevice.getProductId();
    }
    // endregion

    Device(final android.hardware.usb.UsbDevice usbDevice)
    {
        super();
        this.usbDevice = usbDevice;
    }

    @java.lang.Override
    public java.lang.String toString() { return this.getDeviceName(); }

    // Package Methods
    // DeviceList Package Methods
    java.lang.String information()
    {
        assert null != this.usbDevice;
        return java.lang.String.format("name=%s id=%d productId=%d vendorId=%d " +
                "class=%d subClass=%d protocol=%d interfaceCount=%d",
            this.getDeviceName()              , this.usbDevice.getDeviceId      (),
            this.getProductId ()              , this.usbDevice.getVendorId      (),
            this.usbDevice.getDeviceClass   (), this.usbDevice.getDeviceSubclass(),
            this.usbDevice.getDeviceProtocol(), this.usbDevice.getInterfaceCount());
    }

    boolean productIdsAreEqual(final int productId) { return this.getProductId() == productId; }
    // endregion

    // region ExtraDevice Package Methods
    boolean usbDeviceIsNull() { return null == this.usbDevice; }

    void setUsbDevice(final org.wheatgenetics.usb.Device device)
    { this.usbDevice = device.usbDevice; }
    // endregion
    // endregion
}