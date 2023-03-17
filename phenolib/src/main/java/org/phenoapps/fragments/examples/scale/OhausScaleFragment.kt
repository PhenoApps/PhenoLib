package org.phenoapps.fragments.examples.scale

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.phenoapps.androidlibrary.R
import org.phenoapps.viewmodels.scales.OhausViewModel
import org.phenoapps.viewmodels.spectrometers.Indigo
import org.phenoapps.fragments.bluetooth.BluetoothFragment

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class OhausScaleFragment: BluetoothFragment(R.layout.fragment_ohaus_scale) {

    private val viewModel by activityViewModels<OhausViewModel>()

    private var tv: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv = view.findViewById(R.id.frag_ohaus_scale_tv)

        startConnection()
    }

    private fun startConnection() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (!viewModel.isConnected()) {
                advisor.withNearby { adapter ->
                    viewModel.connect(adapter, requireContext())
                }
                startConnection()
            } else {
                startObserving()
            }
        }, 2000L)
    }

    private fun startObserving() {

        viewModel.scaleReading.observe(viewLifecycleOwner) { scaleReading ->

            if (scaleReading != null && scaleReading.isNotBlank()) {

                val readable = scaleReading.replace(" ", "").trim()

                if (readable.endsWith("g") && !readable.startsWith("g")) {
                    println(readable)
                    tv?.setText("Reading: $readable")
                }
            }
        }
    }
}