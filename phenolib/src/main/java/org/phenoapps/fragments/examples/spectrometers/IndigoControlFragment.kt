package org.phenoapps.fragments.examples.spectrometers

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import org.phenoapps.androidlibrary.R
import org.phenoapps.fragments.bluetooth.BluetoothFragment
import org.phenoapps.viewmodels.spectrometers.Indigo
import org.phenoapps.utils.GattUtil.Companion.toPixelWave
import org.phenoapps.viewmodels.spectrometers.IndigoViewModel

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class IndigoControlFragment(private val pager: ViewPager2? = null):
    BluetoothFragment(R.layout.fragment_indigo) {

    private val viewModel by activityViewModels<Indigo>()

    fun connect() {

        context?.let { ctx ->

            val deviceAddress = mPrefs.getString(mKeys.argBluetoothDeviceAddress, null)

            if (deviceAddress != null) {

                advisor.withNearby { adapter ->

                    viewModel.register(adapter, ctx, deviceAddress)

                }
            }
        }
    }

    fun disconnect() {

        context?.let { ctx ->

            viewModel.unregister()

        }
    }

    fun isConnected() = viewModel.isConnected()

    private fun enableScans(view: View) {
        view.findViewById<Button>(R.id.frag_indigo_scan_btn)?.setOnClickListener {

            viewModel.triggerSingleCapture()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scanTextView = view.findViewById<TextView>(R.id.frag_indigo_scan_tv)

        viewModel.loadParameters().observe(viewLifecycleOwner) { params ->
            if (params == IndigoViewModel.REFERENCE_LAMBDA_SIZE) {
                Toast.makeText(context, "Parameters loaded.", Toast.LENGTH_SHORT).show()
                enableScans(view)
            }
        }

        viewModel.interpolatedData().observe(viewLifecycleOwner) { frames ->

            Log.d("Gatt", "interpolated data size: ${frames?.size}")

            scanTextView.text = frames?.joinToString(" ") { "$it" }

        }

        viewModel.setEventListener {

            Log.d("Indigo", "Scan event started...")
        }

        viewModel.services().observe(viewLifecycleOwner) { services ->

            val system = services.find { it.service.uuid.toString() == IndigoViewModel.SYSTEM_SERVICE }?.service

            val wave1 = system?.characteristics?.find { it.uuid.toString() == IndigoViewModel.SYSTEM_LAMBDA_1 }
            val wave2 = system?.characteristics?.find { it.uuid.toString() == IndigoViewModel.SYSTEM_LAMBDA_2 }
            val wave3 = system?.characteristics?.find { it.uuid.toString() == IndigoViewModel.SYSTEM_LAMBDA_3 }
            val wave4 = system?.characteristics?.find { it.uuid.toString() == IndigoViewModel.SYSTEM_LAMBDA_4 }

            wave1?.value?.let { bytes ->
                Log.d("Gatt", "wave1 ${bytes.toPixelWave()}")
            }

            wave2?.value?.let { bytes ->
                Log.d("Gatt", "wave2 ${bytes.toPixelWave()}")
            }

            wave3?.value?.let { bytes ->
                Log.d("Gatt", "wave3 ${bytes.toPixelWave()}")
            }

            wave4?.value?.let { bytes ->
                Log.d("Gatt", "wave4 ${bytes.toPixelWave()}")
            }
        }
    }
}