package org.wheatgenetics.usb;

/**
 * Uses:
 * android.app.Activity
 * android.content.Context
 * android.hardware.usb.UsbDevice
 * android.hardware.usb.UsbManager
 *
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device
 * org.wheatgenetics.usb.DeviceList
 */
class ExtraDevice extends org.wheatgenetics.usb.Device
{
    ExtraDevice(
    @androidx.annotation.NonNull                            final android.app.Activity activity    ,
                                                            final int                  vendorId    ,
    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"}) final int                  productIds[])
    {
        super(
            /* usbDevice => */ (android.hardware.usb.UsbDevice) activity.getIntent()
                .getParcelableExtra(android.hardware.usb.UsbManager.EXTRA_DEVICE),
            /* usbManager => */ (android.hardware.usb.UsbManager) activity.getSystemService(
                android.content.Context.USB_SERVICE));

        if (this.usbDeviceIsNull()) this.setUsbDevice(
            new org.wheatgenetics.usb.DeviceList(activity).get(vendorId, productIds));
    }
}