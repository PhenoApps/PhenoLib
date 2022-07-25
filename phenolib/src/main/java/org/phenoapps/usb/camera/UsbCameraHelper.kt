package org.phenoapps.usb.camera

import android.app.Activity
import android.hardware.usb.UsbDevice
import android.os.Build
import android.util.Log
import android.view.Surface
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.serenegiant.SimpleUVCCameraTextureView
import com.serenegiant.usb.USBMonitor
import com.serenegiant.usb.UVCCamera

/***
 * Tested Pixel 6 API 12  -- working
*         Pixel 4a API 11 -- crashes entire phone
*         Pixel 3  API 9      -- working
 */
open class UsbCameraHelper(private val activity: Activity) {

    private var monitor: USBMonitor? = null

    private var camera: UVCCamera? = null

    private var displayMode = 0

    private var previewLayoutParams: ViewGroup.LayoutParams? = null

    private var previewSurface: Surface? = null

    var view: SimpleUVCCameraTextureView? = null

    private var maxWidth = 512
    private var maxHeight = 512

    private val listener = object : USBMonitor.OnDeviceConnectListener {

        override fun onAttach(device: UsbDevice?) {

            Log.d("Monitor", "Attach")

            monitor?.requestPermission(device)

        }

        override fun onDetach(device: UsbDevice?) {
            Log.d("Monitor", "Detach")
        }

        override fun onConnect(
            device: UsbDevice?,
            ctrlBlock: USBMonitor.UsbControlBlock?,
            createNew: Boolean
        ) {
            Log.d("Monitor", "Connect createNew: $createNew")

            ctrlBlock?.let { control ->

                Log.d("Monitor", "Connecting")

                connect(control)

            }
        }

        override fun onDisconnect(
            device: UsbDevice?,
            ctrlBlock: USBMonitor.UsbControlBlock?
        ) {

            Log.d("Monitor", "Disconnect")

        }

        override fun onCancel(device: UsbDevice?) {

            Log.d("Monitor", "Cancel")

        }
    }

    init {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            val supportedABIS =
                Build.SUPPORTED_ABIS // Return an ordered list of ABIs supported by this device.

            val supported32BitABIS =
                Build.SUPPORTED_32_BIT_ABIS // Return an ordered list of 32 bit ABIs supported by this device.

            val supported64BitABIS =
                Build.SUPPORTED_64_BIT_ABIS // Return an ordered list of 64 bit ABIs supported by this device.

            supportedABIS?.forEach { abi ->
                Log.d("ABI", abi)
            }

            supported32BitABIS?.forEach { abi ->
                Log.d("ABI32", abi)
            }

            supported64BitABIS?.forEach { abi ->
                Log.d("ABI64", abi)
            }
        }
    }

    fun init(min: SimpleUVCCameraTextureView, width: Int, height: Int) {

        maxWidth = width
        maxHeight = height

        previewLayoutParams = min.layoutParams

        monitor?.unregister()
        monitor?.destroy()
        camera?.close()
        camera?.destroy()

        view = min

        view?.let { v ->

            previewSurface = Surface(v.surfaceTexture)

        }

        Log.d("Monitor", "Register opening")

        resetMonitor()
    }

    fun disconnect() {
        camera?.close()
        resetMonitor()
    }

    fun close() {
        monitor?.unregister()
        camera?.close()
    }

    fun destroy() {
        monitor?.destroy()
        camera?.close()
        camera?.destroy()
    }

    fun switchDisplayMode() {

        displayMode = when (displayMode) {
            0 -> {
                setMax()
                1
            }
            else -> {
                setMin()
                0
            }
        }
    }

    open fun setMax() {
        view?.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, maxHeight)
    }

    open fun setMin() {
        view?.layoutParams = previewLayoutParams
    }

    fun getBitmap() = when (displayMode) { 0 -> view?.bitmap else -> view?.bitmap }

    private fun resetMonitor() {

        Log.d("Monitor", "Resetting monitor.")

        monitor = USBMonitor(activity, listener)

        monitor?.register()

    }

    private fun connect(ctrlBlock: USBMonitor.UsbControlBlock) {

        Log.d("Monitor", "Running on ui thread")

        try {

            camera?.close()

            Log.d("Monitor", "Opening camera")

            camera = UVCCamera()

            camera?.open(ctrlBlock)

            camera?.supportedSizeList?.maxByOrNull { it.height*it.width }?.let { size ->

                camera?.setPreviewSize(size.width, size.height)

            }

            camera?.setPreviewDisplay(previewSurface)

//            val sizeList = camera?.supportedSizeList
//            val minSize = sizeList?.minByOrNull { it.height }
//            val maxSize = sizeList?.maxByOrNull { it.height }
//
//            if (minSize != null) {
//                minView?.minimumWidth = minSize.width
//                minView?.minimumHeight = minSize.height
//            }
//
//            if (maxSize != null) {
//                maxView?.minimumWidth = maxSize.width
//                maxView?.minimumHeight = maxSize.height
//            }

            camera?.startPreview()

        } catch (e: Exception) {

            Log.d("Monitor", "Error during camera setup.")

            e.printStackTrace()

        }
    }

//    fun chooseListDevices() {
//
//        val devices = monitor?.deviceList
//        val names = devices?.mapNotNull { it.deviceName }?.toTypedArray()
//        val dialog = AlertDialog.Builder(activity)
//            .setTitle("Choose your camera")
//            .setItems(names) { _, which ->
//                devices?.get(which)?.let { device ->
//                    monitor?.requestPermission(device)
//                }
//            }
//            .create()
//
//        activity.runOnUiThread {
//
//            if (!dialog.isShowing) {
//
//                dialog.show()
//            }
//        }
//    }
}