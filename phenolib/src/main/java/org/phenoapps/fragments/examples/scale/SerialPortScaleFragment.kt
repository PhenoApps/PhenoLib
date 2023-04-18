package org.phenoapps.fragments.examples.scale

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import org.phenoapps.androidlibrary.R
import org.phenoapps.fragments.bluetooth.BluetoothFragment
import org.phenoapps.utils.KeyUtil
import org.phenoapps.viewmodels.scales.SerialPortViewModel
import androidx.fragment.app.activityViewModels

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class SerialPortScaleFragment: BluetoothFragment(R.layout.fragment_ohaus_scale) {

    private val viewModel by activityViewModels<SerialPortViewModel>()

    private var tv: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv = view.findViewById(R.id.frag_ohaus_scale_tv)

        Handler().postDelayed({
            startConnection()
        }, 5000)
    }

    @SuppressLint("MissingPermission")
    private fun startConnection() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (!viewModel.isConnected()) {
                advisor.withNearby { adapter ->
                    viewModel.connect(adapter, requireContext())
                    val libKeys = KeyUtil(context)
//                    val address = PreferenceManager.getDefaultSharedPreferences(context)
//                        .getString(libKeys.argBluetoothDeviceAddress, null)
//                    if (address != null) {
//                        val device = adapter.getRemoteDevice(address)
//                        sdmHandler.connect(address, device.name)
//
//                    }
                }
                startConnection()
            } else {
                startObserving()
            }
        }, 2000L)
//        advisor.withNearby { adapter ->
//            //viewModel.connect(adapter, requireContext())
//            val libKeys = KeyUtil(context)
//            val address = PreferenceManager.getDefaultSharedPreferences(context)
//                .getString(libKeys.argBluetoothDeviceAddress, null)
//            if (address != null) {
//                val device = adapter.getRemoteDevice(address)
//                sdmHandler.connect(address, device.name)
//
//            }
//        }
    }

    private fun startObserving() {

        viewModel.scaleReading.observe(viewLifecycleOwner) { scaleReading ->

            Log.d("SERIALIO", scaleReading ?: "")

            if (scaleReading != null && scaleReading.isNotBlank()) {

                tv?.text = scaleReading

//                val readable = scaleReading.replace(" ", "").trim()
//
//                if (readable.endsWith("g") && !readable.startsWith("g")) {
//                    println(readable)
//                    tv?.setText("Reading: $readable")
//                }
            }
        }
    }
}