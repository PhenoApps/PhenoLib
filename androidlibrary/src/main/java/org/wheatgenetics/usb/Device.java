package org.wheatgenetics.usb;

/**
 * Uses:
 * android.hardware.usb.UsbDevice
 * android.support.annotation.NonNull
 */

class Device extends java.lang.Object
{
    private final android.hardware.usb.UsbDevice usbDevice;

    Device(@android.support.annotation.NonNull final android.hardware.usb.UsbDevice usbDevice)
    {
        super();

        assert null != usbDevice;
        this.usbDevice = usbDevice;
    }

    @java.lang.Override
    public java.lang.String toString()
    {
        assert null != this.usbDevice;
        return java.lang.String.format("name=%s id=%d productId=%d vendorId=%d " +
                "class=%d subClass=%d protocol=%d interfaceCount=%d",
            this.usbDevice.getDeviceName    (), this.usbDevice.getDeviceId      (),
            this.usbDevice.getProductId     (), this.usbDevice.getVendorId      (),
            this.usbDevice.getDeviceClass   (), this.usbDevice.getDeviceSubclass(),
            this.usbDevice.getDeviceProtocol(), this.usbDevice.getInterfaceCount());
    }
}