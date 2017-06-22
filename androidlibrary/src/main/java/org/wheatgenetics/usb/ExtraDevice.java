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
        super(
            (android.hardware.usb.UsbDevice) activity.getIntent().getParcelableExtra(
                android.hardware.usb.UsbManager.EXTRA_DEVICE),
            (android.hardware.usb.UsbManager) activity.getSystemService(
                android.content.Context.USB_SERVICE));

        if (this.usbDeviceIsNull())
            this.setUsbDevice(new org.wheatgenetics.usb.DeviceList(activity).get(productId));
    }
}