package org.phenoapps.fragments.usb.camera

import android.app.Activity
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.SurfaceTexture
import android.hardware.usb.UsbManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.constraintlayout.widget.Group
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.serenegiant.SimpleUVCCameraTextureView
import com.serenegiant.usb.UVCCamera
import org.phenoapps.adapters.ImageAdapter
import org.phenoapps.androidlibrary.R
import org.phenoapps.androidlibrary.databinding.UsbCameraPreviewFragmentBinding
import org.phenoapps.interfaces.usb.camera.CameraSurfaceListener
import org.phenoapps.receivers.UsbPermissionReceiver
import org.phenoapps.security.Security
import org.phenoapps.usb.camera.UsbCameraHelper
import org.phenoapps.interfaces.usb.camera.UsbCameraInterface
import java.io.File
import java.util.*
import kotlin.math.abs

class UsbCameraPreviewFragment : Fragment(), ImageAdapter.ImageItemHandler {

    companion object {
        private var TAG = this::class.simpleName
    }

    private val advisor by Security().secureFragment()

    private var previewLayoutParams: ViewGroup.LayoutParams? = null
    private var _binding: UsbCameraPreviewFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var bmp: Bitmap? = null

    private var helper: UsbCameraHelper? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = UsbCameraPreviewFragmentBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val filter = IntentFilter(UsbPermissionReceiver.ACTION_USB_PERMISSION)
        context.registerReceiver(UsbPermissionReceiver {
            setup()
        }, filter)

        advisor.initialize()

        assert(activity is UsbCameraInterface)

        helper = (activity as UsbCameraInterface).getCameraHelper()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCacheAdapter()

        val fromFull = arguments?.get("fromFull")

        if (fromFull != true) {

            binding.usbCameraFragmentConnectBtn.setOnClickListener {

                advisor.withPermission(arrayOf(android.Manifest.permission.CAMERA)) {

                    advisor.withPermission(arrayOf(android.Manifest.permission.RECORD_AUDIO)) {

                        context?.let { ctx ->

                            val manager = ctx.getSystemService(Context.USB_SERVICE) as UsbManager

                            val permissionIntent = PendingIntent.getBroadcast(
                                ctx,
                                0,
                                Intent(UsbPermissionReceiver.ACTION_USB_PERMISSION),
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
                            )

                            val devices = manager.deviceList.map { it.value }

                            devices.forEach {
                                manager.requestPermission(it, permissionIntent)
                            }
                        }
                    }
                }
            }

            binding.usbCameraFragmentTv.setOnClickListener {
                helper?.setFocus()
            }

            binding.usbCameraFragmentSlider.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    helper?.setZoom(progress)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

        } else setup()
    }

    private fun setup() {

        previewLayoutParams = binding.usbCameraFragmentTv.layoutParams

        binding.usbCameraFragmentConnectBtn.visibility = View.GONE

        binding.usbCameraFragmentPreviewGroup.visibility = View.VISIBLE

        binding.usbCameraFragmentTv.surfaceTextureListener = object : CameraSurfaceListener {

            override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {

                initPreview()
            }

            override fun onSurfaceTextureUpdated(surfaceTexture: SurfaceTexture) {
                bmp = binding.usbCameraFragmentTv.bitmap

                binding.usbCameraFragmentIv.setImageBitmap(bmp)
            }
        }
    }

    private fun initPreview() {

        (activity as? UsbCameraInterface)?.let { cameraInterface ->

            binding.usbCameraFragmentPreviewGroup.visibility = View.VISIBLE

            cameraInterface.getCameraHelper()?.init(binding.usbCameraFragmentTv) { ratio ->
                activity?.runOnUiThread {
                    binding.usbCameraFragmentTv.setAspectRatio(ratio)
                    binding.usbCameraFragmentCaptureBtn.invalidate()
                }
            }

            binding.usbCameraFragmentCaptureBtn.setOnClickListener {

                saveBitmapToCache(bmp)
            }

            binding.usbCameraFragmentExpandBtn.setOnClickListener {

                findNavController().navigate(
                    UsbCameraPreviewFragmentDirections
                        .actionFromPreviewToFullscreen()
                )
            }
        }
    }

    private fun setupCacheAdapter() {

        context?.externalCacheDir?.let {

            val photos = File(it, "Photos")

            if (!photos.exists()) photos.mkdirs()

            val thumbnails = File(photos, ".thumbnails")

            if (!thumbnails.exists()) thumbnails.mkdirs()

            val files = thumbnails.listFiles()

            if (files != null) {

                binding.usbCameraFragmentRv.adapter = ImageAdapter(this).also { adapter ->

                    adapter.submitList(files
                        .filter { it.extension == "png" }
                        .map { ImageAdapter.Model(it.name, BitmapFactory.decodeFile(it.path)) })

                }
            }
        }
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

        setupCacheAdapter()
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

    override fun onItemClicked(model: ImageAdapter.Model) {

        Toast.makeText(context, "This will open ${model.uri}", Toast.LENGTH_SHORT).show()

    }

    override fun onItemDeleted(model: ImageAdapter.Model) {

        Toast.makeText(context, "This will delete ${model.uri}", Toast.LENGTH_SHORT).show()
    }
}