package org.phenoapps.usb.camera

import android.app.Activity
import android.hardware.usb.UsbDevice
import android.os.Build
import android.util.Log
import android.view.Surface
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.serenegiant.SimpleUVCCameraTextureView
import com.serenegiant.usb.IFrameCallback
import com.serenegiant.usb.USBMonitor
import com.serenegiant.usb.UVCCamera
import org.phenoapps.interfaces.usb.camera.UsbCameraInterface
import java.nio.ByteBuffer

/***
 * Tested Pixel 6 API 12  -- working
*         Pixel 4a API 11 -- crashes entire phone
*         Pixel 3  API 9      -- working
 */
open class UsbCameraHelper(private val activity: Activity) {

    companion object {
        private var TAG = UsbCameraHelper::class.simpleName
        const val DISPLAY_MODE_PREVIEW = 0
        const val DISPLAY_MODE_MAX = 1
    }

    private var controller: UsbCameraInterface.AspectRatioController? = null

    private var monitor: USBMonitor? = null

    private var camera: UVCCamera? = null

    private var displayMode = DISPLAY_MODE_PREVIEW

    private var previewLayoutParams: ViewGroup.LayoutParams? = null

    private var previewSurface: Surface? = null

    private var lastFrame: ByteBuffer? = null

    var aspectRatio: Double = UVCCamera.DEFAULT_PREVIEW_WIDTH / UVCCamera.DEFAULT_PREVIEW_HEIGHT.toDouble()

    var view: SimpleUVCCameraTextureView? = null

    private val frameCallback = IFrameCallback {
        lastFrame = it
    }

    private val listener = object : USBMonitor.OnDeviceConnectListener {

        override fun onAttach(device: UsbDevice?) {

            Log.d(TAG, "Attach")

            monitor?.requestPermission(device)

        }

        override fun onDetach(device: UsbDevice?) {
            Log.d(TAG, "Detach")
        }

        override fun onConnect(
            device: UsbDevice?,
            ctrlBlock: USBMonitor.UsbControlBlock?,
            createNew: Boolean
        ) {
            Log.d(TAG, "Connect createNew: $createNew")

            ctrlBlock?.let { control ->

                Log.d(TAG, "Connecting")

                connect(control)

            }
        }

        override fun onDisconnect(
            device: UsbDevice?,
            ctrlBlock: USBMonitor.UsbControlBlock?
        ) {

            Log.d(TAG, "Disconnect")

        }

        override fun onCancel(device: UsbDevice?) {

            Log.d(TAG, "Cancel")

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
                Log.d(TAG, "ABI: $abi")
            }

            supported32BitABIS?.forEach { abi ->
                Log.d(TAG, "ABI32: $abi")
            }

            supported64BitABIS?.forEach { abi ->
                Log.d(TAG, "ABI64: $abi")
            }
        }
    }

    fun init(tv: SimpleUVCCameraTextureView, controller: UsbCameraInterface.AspectRatioController) {

        this.controller = controller

        monitor?.unregister()
        monitor?.destroy()
        camera?.close()
        camera?.destroy()

        view = tv

        view?.let { v ->

            v.setAspectRatio(aspectRatio)

            previewLayoutParams = v.layoutParams

            previewSurface = Surface(v.surfaceTexture)
        }

        Log.d(TAG, "Register opening")

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

    fun switchDisplayMode(): Int {

        displayMode = when (displayMode) {
            DISPLAY_MODE_PREVIEW -> {
                setMax()
                DISPLAY_MODE_MAX
            }
            else -> {
                setMin()
                DISPLAY_MODE_PREVIEW
            }
        }

        return displayMode
    }

    open fun getAutoFocus(): Boolean = camera?.autoFocus ?: true
    open fun getZoom(): Int = camera?.zoom ?: 0
    open fun setZoom(zoom: Int) {

        camera?.zoom = zoom

    }

    open fun setFocus() {

        camera?.autoFocus = !(camera?.autoFocus ?: true)

    }

    open fun setMax() {
        view?.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, 512)
    }

    open fun setMin() {
        view?.layoutParams = previewLayoutParams
    }

    private fun resetMonitor() {

        Log.d(TAG, "Resetting monitor.")

        monitor = USBMonitor(activity, listener)

        monitor?.register()

    }

    private fun connect(ctrlBlock: USBMonitor.UsbControlBlock) {

        Log.d(TAG, "Running on ui thread")

        try {

            camera?.close()

            Log.d(TAG, "Opening camera")

            camera = UVCCamera()

            camera?.open(ctrlBlock)

            camera?.supportedSizeList?.forEach { size ->

                Log.d(TAG, "Supported size: width: ${size.width} height: ${size.height} aspect ratio: ${size.width/size.height} fps: ${size.fps}")

            }

            camera?.supportedSizeList?.maxByOrNull { it.height*it.width }?.let { size ->

                Log.d(TAG, "Preview size: width: ${size.width} height: ${size.height}")

                camera?.setPreviewSize(size.width, size.height)

                aspectRatio = size.width / size.height.toDouble()

                this.controller?.refreshCameraAspectRatio(aspectRatio)

            }

            camera?.setFrameCallback(frameCallback, UVCCamera.PIXEL_FORMAT_YUV)

            camera?.setPreviewDisplay(previewSurface)

            camera?.startPreview()

            camera?.startCapture(previewSurface)

        } catch (e: Exception) {

            Log.d(TAG, "Error during camera setup.")

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