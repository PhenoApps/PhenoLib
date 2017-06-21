package org.wheatgenetics.usb;

/**
 * Uses:
 * android.hardware.usb.UsbDevice
 * android.hardware.usb.UsbManager
 * android.support.annotation.NonNull
 */

class DeviceList extends java.lang.Object
{
    private final java.util.HashMap<java.lang.String, android.hardware.usb.UsbDevice> deviceList;

    DeviceList(@android.support.annotation.NonNull final android.hardware.usb.UsbManager usbManager)
    {
        super();

        assert null != usbManager;
        this.deviceList = usbManager.getDeviceList();
    }

    int size()
    {
        assert null != this.deviceList;
        return this.deviceList.size();
    }
}