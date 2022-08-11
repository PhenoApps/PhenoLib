package org.phenoapps.interfaces.usb.camera

import org.phenoapps.usb.camera.UsbCameraHelper

interface UsbCameraInterface {

    fun getCameraHelper(): UsbCameraHelper?

    fun interface AspectRatioController {

        fun refreshCameraAspectRatio(ratio: Double)

    }
}