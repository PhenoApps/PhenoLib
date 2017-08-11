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
 *
 * org.wheatgenetics.usb.Device
 */
class DeviceList extends java.lang.Object
{
    private final java.util.ArrayList<org.wheatgenetics.usb.Device> arrayList;

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
        this.arrayList = new java.util.ArrayList<org.wheatgenetics.usb.Device>(deviceList.size());

        for (final android.hardware.usb.UsbDevice usbDevice: deviceList.values())
            if (null != usbDevice)
                this.arrayList.add(new org.wheatgenetics.usb.Device(usbDevice, usbManager));
    }

    @java.lang.Override
    public java.lang.String toString()
    {
        java.lang.String result = null;
        {
            java.lang.Boolean firstDevice = true;
            assert null != this.arrayList;
            for (final org.wheatgenetics.usb.Device device: this.arrayList)
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
    int size() { return null == this.arrayList ? 0 : this.arrayList.size(); }

    java.lang.String information()
    {
        java.lang.String result = null;
        {
            java.lang.Boolean firstDevice = true;
            assert null != this.arrayList;
            for (final org.wheatgenetics.usb.Device device: this.arrayList)
                if (firstDevice)
                {
                    result = device.information();
                    firstDevice = false;
                }
                else result += '\n' + device.information();
        }
        return result;
    }

    org.wheatgenetics.usb.Device get(final int vendorId, final int productIds[])
    {
        if (null == this.arrayList || null == productIds)
            return null;
        else
            if (productIds.length <= 0)
                return null;
            else
            {
                for (final int productId: productIds)
                    for (final org.wheatgenetics.usb.Device device: this.arrayList)
                        if (device.idsAreEqual(vendorId, productId)) return device;
                return null;
            }
    }
    // endregion
}