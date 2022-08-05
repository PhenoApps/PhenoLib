package org.phenoapps.usb.camera

interface UsbCameraController {

    fun refreshCameraAspectRatio(ratio: Double)

    fun onMaximize()
}