package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.content.Context
 * android.hardware.usb.UsbDevice
 * android.hardware.usb.UsbManager
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.javalib.Utils
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
                this.deviceArrayList.add(new org.wheatgenetics.usb.Device(usbDevice, usbManager));
    }

    @java.lang.Override
    public java.lang.String toString()
    {
        java.lang.String result = null;
        {
            java.lang.Boolean firstDevice = true;
            assert null != this.deviceArrayList;
            for (final org.wheatgenetics.usb.Device device : this.deviceArrayList)
                if (firstDevice)
                {
                    result = device.toString();
                    firstDevice = false;
                }
                else result += '\n' + device.toString();
        }
        return org.wheatgenetics.javalib.Utils.replaceIfNull(result, super.toString());
    }

    // region Package Methods
    int size()
    { return null == this.deviceArrayList ? 0 : this.deviceArrayList.size(); }

    java.lang.String information()
    {
        java.lang.String result = null;
        {
            java.lang.Boolean firstDevice = true;
            assert null != this.deviceArrayList;
            for (final org.wheatgenetics.usb.Device device : this.deviceArrayList)
                if (firstDevice)
                {
                    result = device.information();
                    firstDevice = false;
                }
                else result += '\n' + device.information();
        }
        return result;
    }

    org.wheatgenetics.usb.Device get(final int productId)
    {
        if (null == this.deviceArrayList)
            return null;
        else
        {
            for (final org.wheatgenetics.usb.Device device : this.deviceArrayList)
                if (device.productIdsAreEqual(productId)) return device;
            return null;
        }
    }
    // endregion
}