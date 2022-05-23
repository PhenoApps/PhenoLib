package org.phenoapps.interfaces.spectrometers

import android.content.Context
import androidx.lifecycle.LiveData
import org.phenoapps.interfaces.iot.Device
import org.phenoapps.viewmodels.spectrometers.Frame

interface Spectrometer: Device {
    fun scan(context: Context, manual: Boolean? = false): LiveData<List<Frame>?>
}