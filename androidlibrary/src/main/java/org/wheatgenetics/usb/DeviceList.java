package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.content.Context
 * android.hardware.usb.UsbDevice
 * android.hardware.usb.UsbManager
 * android.support.annotation.NonNull
 * android.support.annotation.Size
 *
 * org.wheatgenetics.javalib.Utils
 *
 * org.wheatgenetics.usb.Device
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
class DeviceList extends java.lang.Object
{
    private final java.util.ArrayList<org.wheatgenetics.usb.Device> arrayList;

    DeviceList(@android.support.annotation.NonNull final android.app.Activity activity)
    {
        super();

        final android.hardware.usb.UsbManager usbManager = (android.hardware.usb.UsbManager)
            activity.getSystemService(android.content.Context.USB_SERVICE);

        assert null != usbManager;
        final java.util.HashMap<java.lang.String, android.hardware.usb.UsbDevice> deviceHashMap =
            usbManager.getDeviceList();

        assert null != deviceHashMap;
        // noinspection Convert2Diamond
        this.arrayList =
            new java.util.ArrayList<org.wheatgenetics.usb.Device>(deviceHashMap.size());

        for (final android.hardware.usb.UsbDevice usbDevice: deviceHashMap.values())
            if (null != usbDevice)
                this.arrayList.add(new org.wheatgenetics.usb.Device(usbDevice, usbManager));
    }

    @android.support.annotation.NonNull @java.lang.Override public java.lang.String toString()
    {
        final java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
        {
            boolean firstDevice = true;
            assert null != this.arrayList;
            for (final org.wheatgenetics.usb.Device device: this.arrayList)
            {
                if (firstDevice) firstDevice = false; else stringBuilder.append('\n');
                stringBuilder.append(device.toString());
            }
        }
        return org.wheatgenetics.javalib.Utils.replaceIfNull(
            stringBuilder.toString(), super.toString());
    }

    // region Package Methods
    int size() { return null == this.arrayList ? 0 : this.arrayList.size(); }

    java.lang.String information()
    {
        final java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
        {
            boolean firstDevice = true;
            assert null != this.arrayList;
            for (final org.wheatgenetics.usb.Device device: this.arrayList)
            {
                if (firstDevice) firstDevice = false; else stringBuilder.append('\n');
                stringBuilder.append(device.information());
            }
        }
        return stringBuilder.toString();
    }

    org.wheatgenetics.usb.Device get(final int vendorId,

    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
        @android.support.annotation.Size(min = 1) final int productIds[])
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