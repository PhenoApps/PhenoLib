package org.phenoapps.interfaces.spectrometers

import android.content.Context
import androidx.lifecycle.LiveData
import org.phenoapps.interfaces.iot.Device
import org.phenoapps.viewmodels.spectrometers.Frame

interface Spectrometer: Device {
    companion object {
        /**
         * Device Types (internal unique strings used to classify which device was used for a given experiment/scan)
         */
        const val DEVICE_TYPE_LS1 = "LinkSquare"

        const val DEVICE_TYPE_NIR = "LinkSquareNIR"

        const val DEVICE_TYPE_NANO = "InnoSpectra Nano"

        const val DEVICE_TYPE_INDIGO = "Indigo"
    }

    fun scan(context: Context, manual: Boolean? = false): LiveData<List<Frame>?>
}