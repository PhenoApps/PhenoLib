package org.phenoapps.usb;

/**
 * Uses:
 * android.app.Activity
 * android.content.Context
 * android.hardware.usb.UsbDevice
 * android.hardware.usb.UsbManager
 *
 * androidx.annotation.NonNull
 * androidx.annotation.Size
 *
 * org.wheatgenetics.javalib.Utils
 *
 * org.wheatgenetics.usb.Device
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
class DeviceList extends java.lang.Object
{
    private final java.util.ArrayList<org.phenoapps.usb.Device> arrayList;

    DeviceList(@androidx.annotation.NonNull final android.app.Activity activity)
    {
        super();

        final android.hardware.usb.UsbManager usbManager = (android.hardware.usb.UsbManager)
            activity.getSystemService(android.content.Context.USB_SERVICE);

        final java.util.HashMap<java.lang.String, android.hardware.usb.UsbDevice> deviceHashMap =
            null == usbManager ? null : usbManager.getDeviceList();

        if (null == deviceHashMap)
            this.arrayList = null;
        else
        {
            // noinspection Convert2Diamond
            this.arrayList =
                new java.util.ArrayList<org.phenoapps.usb.Device>(deviceHashMap.size());

            for (final android.hardware.usb.UsbDevice usbDevice: deviceHashMap.values())
                if (null != usbDevice)
                    this.arrayList.add(new org.phenoapps.usb.Device(usbDevice, usbManager));
        }
    }

    @androidx.annotation.NonNull @java.lang.Override public java.lang.String toString()
    {
        final java.lang.String string;
        if (null == this.arrayList)
            string = null;
        else
        {
            final java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
            {
                boolean firstDevice = true;
                for (final org.phenoapps.usb.Device device: this.arrayList)
                {
                    if (firstDevice) firstDevice = false; else stringBuilder.append('\n');
                    stringBuilder.append(device.toString());
                }
            }
            string = stringBuilder.toString();
        }
        return org.phenoapps.androidlibrary.Utils.replaceIfNull(string, super.toString());
    }

    // region Package Methods
    int size() { return null == this.arrayList ? 0 : this.arrayList.size(); }

    java.lang.String information()
    {
        final java.lang.String result;
        if (null == this.arrayList)
            result = null;
        else
        {
            final java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
            {
                boolean firstDevice = true;
                for (final org.phenoapps.usb.Device device: this.arrayList)
                {
                    if (firstDevice) firstDevice = false; else stringBuilder.append('\n');
                    stringBuilder.append(device.information());
                }
            }
            result = stringBuilder.toString();
        }
        return result;
    }

    org.phenoapps.usb.Device get(final int vendorId,

                                 @java.lang.SuppressWarnings({"CStyleArrayDeclaration"}) @androidx.annotation.Size(min = 1)
        final int productIds[])
    {
        if (null == this.arrayList || null == productIds)
            return null;
        else
            if (productIds.length <= 0)
                return null;
            else
            {
                for (final int productId: productIds)
                    for (final org.phenoapps.usb.Device device: this.arrayList)
                        if (device.idsAreEqual(vendorId, productId)) return device;
                return null;
            }
    }
    // endregion
}