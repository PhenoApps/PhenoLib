package org.wheatgenetics.usb;

/**
 * Uses:
 * android.hardware.usb.UsbDevice
 * android.hardware.usb.UsbDeviceConnection
 * android.hardware.usb.UsbEndpoint
 * android.hardware.usb.UsbInterface
 * android.hardware.usb.UsbManager
 * android.os.AsyncTask
 * android.support.annotation.NonNull
 */

class Device extends java.lang.Object
{
//    private static class AsyncTask
//    extends android.os.AsyncTask<java.lang.Void, java.lang.Double, java.lang.Void>
//    {
//        @java.lang.Override
//        protected java.lang.Void doInBackground(final java.lang.Void... params) { return null; }
//    }

    private       android.hardware.usb.UsbDevice  usbDevice ;
    private final android.hardware.usb.UsbManager usbManager;

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

    Device(final android.hardware.usb.UsbDevice usbDevice,
    @android.support.annotation.NonNull final android.hardware.usb.UsbManager usbManager)
    {
        super();

        this.usbDevice = usbDevice;

        assert null != usbManager;
        this.usbManager = usbManager;
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

    int read(final byte buffer[])
    {
        if (this.usbDeviceIsNull())
            return -1;
        else
        {
            android.hardware.usb.UsbEndpoint         usbEndpoint        ;
            android.hardware.usb.UsbDeviceConnection usbDeviceConnection;
            {
                final android.hardware.usb.UsbInterface usbInterface =
                    this.usbDevice.getInterface(0);
                assert null != usbInterface;
                usbEndpoint         = usbInterface.getEndpoint(0)               ;
                usbDeviceConnection = this.usbManager.openDevice(this.usbDevice);

                assert usbDeviceConnection != null;
                usbDeviceConnection.claimInterface(usbInterface, true);
            }
            return usbDeviceConnection.bulkTransfer(usbEndpoint, buffer,
                null == buffer ? 0 : buffer.length, /* timeout => */ 2000);
        }
    }
    // endregion
}