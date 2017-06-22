package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.hardware.usb.UsbDevice
 * android.hardware.usb.UsbManager
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device
 * org.wheatgenetics.usb.DeviceList
 */

class ExtraDevice extends org.wheatgenetics.usb.Device
{
    ExtraDevice(@android.support.annotation.NonNull final android.app.Activity activity,
    final int productId)
    {
        super((android.hardware.usb.UsbDevice) activity.getIntent().getParcelableExtra(
            android.hardware.usb.UsbManager.EXTRA_DEVICE));

        if (this.usbDeviceIsNull())
        {
            final org.wheatgenetics.usb.Device device;
            {
                final org.wheatgenetics.usb.DeviceList deviceList =
                    new org.wheatgenetics.usb.DeviceList(activity);
                device = deviceList.get(productId);
            }
            this.setUsbDevice(device);
        }
    }
}