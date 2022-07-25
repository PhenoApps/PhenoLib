package org.phenoapps.fragments.usb.camera

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.hardware.usb.UsbManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.serenegiant.usb.UVCCamera
import org.phenoapps.androidlibrary.databinding.UsbCameraFragmentBinding
import org.phenoapps.interfaces.security.SecureFragmentInterface
import org.phenoapps.receivers.UsbPermissionReceiver
import org.phenoapps.security.Security
import org.phenoapps.usb.camera.UsbCameraHelper
import org.phenoapps.usb.camera.UsbCameraInterface

class UsbCameraFragment : Fragment(), UsbCameraInterface {

    companion object {
        private const val savedFileName = "test.png"
    }

    private val advisor by Security().secureFragment()

    private var _binding: UsbCameraFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var helper: UsbCameraHelper? = null

    private var bmp: Bitmap? = null

    private val saveLauncher = registerForActivityResult(ActivityResultContracts.CreateDocument()) { uriResult ->

        uriResult?.let { uri ->

            bmp?.let { bitmap ->

                context?.let { ctx ->

                    ctx.contentResolver.openOutputStream(uri)?.let { output ->

                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, output)
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = UsbCameraFragmentBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val filter = IntentFilter(UsbPermissionReceiver.ACTION_USB_PERMISSION)
        context.registerReceiver(UsbPermissionReceiver {
            setup()
        }, filter)

        advisor.initialize()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textureView.setAspectRatio(UVCCamera.DEFAULT_PREVIEW_WIDTH / UVCCamera.DEFAULT_PREVIEW_HEIGHT.toDouble())
        binding.maxTextureView.setAspectRatio(UVCCamera.DEFAULT_PREVIEW_WIDTH / UVCCamera.DEFAULT_PREVIEW_HEIGHT.toDouble())

        binding.buttonThird.setOnClickListener {

            helper?.disconnect()

        }

        binding.buttonDevices.setOnClickListener {

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
    }

    private fun setup() {

        activity?.let { act ->

            helper = UsbCameraHelper(act)
            helper?.init(binding.textureView, 512, 512)

            binding.buttonFirst.setOnClickListener {

                bmp = helper?.getBitmap()

                saveLauncher.launch(savedFileName)
            }

            binding.buttonSecond.setOnClickListener {

                binding.buttonSecond.isEnabled = false
                it.postDelayed({
                    helper?.switchDisplayMode()
                    binding.buttonSecond.isEnabled = true
                }, 1000)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        helper?.destroy()
    }

    override fun getCameraHelper(): UsbCameraHelper? = helper
}