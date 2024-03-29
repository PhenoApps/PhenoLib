package org.phenoapps.fragments.usb.camera

import android.graphics.Bitmap
import android.graphics.SurfaceTexture
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.serenegiant.usb.UVCCamera
import org.phenoapps.androidlibrary.R
import org.phenoapps.androidlibrary.databinding.UsbCameraFullscreenFragmentBinding
import org.phenoapps.usb.camera.UsbCameraHelper
import org.phenoapps.interfaces.usb.camera.UsbCameraInterface
import java.io.File
import java.util.*
import kotlin.math.abs

class UsbCameraFullScreenFragment : Fragment() {

    companion object {
        private var TAG = this::class.simpleName
    }

    private var previewLayoutParams: ViewGroup.LayoutParams? = null
    private var _binding: UsbCameraFullscreenFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var helper: UsbCameraHelper? = null

    private var bmp: Bitmap? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = UsbCameraFullscreenFragmentBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }

    private fun setup() {

        activity?.let { act ->

            helper = (act as? UsbCameraInterface)?.getCameraHelper()

            previewLayoutParams = binding.usbCameraFragmentTv.layoutParams

            binding.usbCameraFragmentPreviewGroup.visibility = View.VISIBLE

            binding.usbCameraFragmentTb.setNavigationOnClickListener {

                findNavController().navigate(UsbCameraFullScreenFragmentDirections
                    .actionFromFullscreenToPreview(fromFull = true))

            }

            binding.usbCameraFragmentTv.surfaceTextureListener = object : TextureView.SurfaceTextureListener {
                override fun onSurfaceTextureAvailable(p0: SurfaceTexture, p1: Int, p2: Int) {

                    binding.usbCameraFragmentPreviewGroup.visibility = View.VISIBLE

                    helper?.init(binding.usbCameraFragmentTv) { ratio ->

                        activity?.runOnUiThread {
                            binding.usbCameraFragmentTv.setAspectRatio(ratio)
                            binding.usbCameraFragmentCaptureBtn.invalidate()
                        }
                    }

                    binding.usbCameraFragmentCaptureBtn.setOnClickListener {

                        saveBitmapToCache(bmp)
                    }
                }

                override fun onSurfaceTextureSizeChanged(p0: SurfaceTexture, p1: Int, p2: Int) {}
                override fun onSurfaceTextureDestroyed(p0: SurfaceTexture): Boolean { return true }
                override fun onSurfaceTextureUpdated(p0: SurfaceTexture) {

                    bmp = binding.usbCameraFragmentTv.bitmap

                    binding.usbCameraFragmentIv.setImageBitmap(Bitmap.createScaledBitmap(bmp!!, bmp!!.width*2, bmp!!.height*2, true))

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        helper?.destroy()
    }

    private fun saveBitmapToCache(bmp: Bitmap?) {

        context?.externalCacheDir?.let {

            val photos = File(it, "Photos")

            if (!photos.exists()) photos.mkdirs()

            val fileName = "${UUID.randomUUID()}.png"

            val newFile = File(photos, fileName)

            context?.contentResolver?.openOutputStream(newFile.toUri())?.let { output ->

                bmp?.compress(Bitmap.CompressFormat.PNG, 100, output)

                createThumbnail(photos, fileName, bmp)
            }
        }
    }

    private fun createThumbnail(photos: File, name: String, bitmap: Bitmap?) {

        bitmap?.let { bmp ->

            context?.externalCacheDir?.let {

                val thumbnails = File(photos, ".thumbnails")

                if (!thumbnails.exists()) thumbnails.mkdirs()

                var thumbnailWidth = resources.getInteger(R.integer.thumbnailWidth)
                var thumbnailHeight = resources.getInteger(R.integer.thumbnailHeight)
                var aspectRatio = helper?.aspectRatio ?: (UVCCamera.DEFAULT_PREVIEW_WIDTH / UVCCamera.DEFAULT_PREVIEW_HEIGHT).toDouble()

                val aspectKeys = resources.getStringArray(R.array.aspect_ratio_keys)
                val aspectValues = resources.getStringArray(R.array.aspect_ratio_values)
                aspectKeys.minByOrNull { abs(it.toDouble() - aspectRatio) }?.let { closest ->
                    val index = aspectKeys.indexOf(closest)
                    if (index < aspectValues.size) {
                        val (width, height) = aspectValues[index].split("x")
                        thumbnailWidth = width.toInt()
                        thumbnailHeight = height.toInt()
                        aspectRatio = thumbnailWidth / thumbnailHeight.toDouble()

                        Log.d(TAG, "Chosen thumbnail: $thumbnailWidth x $thumbnailHeight a.r: $aspectRatio")
                    }
                }

                val thumbnail = Bitmap.createScaledBitmap(bmp, thumbnailWidth, thumbnailHeight, true)

                val thumbFile = File(thumbnails, name)

                context?.contentResolver?.openOutputStream(thumbFile.toUri())?.use { output ->

                    thumbnail.compress(Bitmap.CompressFormat.PNG, 100, output)

                }
            }
        }
    }
}