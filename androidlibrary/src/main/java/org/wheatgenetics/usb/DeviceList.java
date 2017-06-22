package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.content.Context
 * android.hardware.usb.UsbDevice
 * android.hardware.usb.UsbManager
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device
 */

class DeviceList extends java.lang.Object
{
    private final java.util.ArrayList<org.wheatgenetics.usb.Device> deviceArrayList;

    DeviceList(@android.support.annotation.NonNull final android.app.Activity activity)
    {
        super();

        assert null != activity;
        final android.hardware.usb.UsbManager usbManager = (android.hardware.usb.UsbManager)
            activity.getSystemService(android.content.Context.USB_SERVICE);

        assert null != usbManager;
        final java.util.HashMap<java.lang.String, android.hardware.usb.UsbDevice> deviceList =
            usbManager.getDeviceList();

        assert null != deviceList;
        this.deviceArrayList = new java.util.ArrayList<org.wheatgenetics.usb.Device>(
            deviceList.size());

        for (final android.hardware.usb.UsbDevice usbDevice: deviceList.values())
            if (null != usbDevice)
                this.deviceArrayList.add(new org.wheatgenetics.usb.Device(usbDevice));
    }

    @java.lang.Override
    public java.lang.String toString()
    {
        java.lang.String returnValue = null;
        {
            java.lang.Boolean firstDevice = true;
            assert null != this.deviceArrayList;
            for (final org.wheatgenetics.usb.Device device : this.deviceArrayList)
                if (firstDevice)
                {
                    returnValue = device.toString();
                    firstDevice = false;
                }
                else returnValue += '\n' + device.toString();
        }
        if (null == returnValue) returnValue = super.toString();
        return returnValue;
    }

    int size()
    {
        assert null != this.deviceArrayList;
        return this.deviceArrayList.size();
    }

    java.lang.String information()
    {
        java.lang.String returnValue = null;
        {
            java.lang.Boolean firstDevice = true;
            assert null != this.deviceArrayList;
            for (final org.wheatgenetics.usb.Device device : this.deviceArrayList)
                if (firstDevice)
                {
                    returnValue = device.information();
                    firstDevice = false;
                }
                else returnValue += '\n' + device.information();
        }
        return returnValue;
    }
}