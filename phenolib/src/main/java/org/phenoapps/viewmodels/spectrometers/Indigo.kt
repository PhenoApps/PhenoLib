package org.phenoapps.viewmodels.spectrometers

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import org.phenoapps.interfaces.spectrometers.Spectrometer

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class Indigo: IndigoViewModel(), Spectrometer {

    override fun scan(context: Context, manual: Boolean?): LiveData<List<Frame>?> {
        if (manual != true) {
            triggerSingleCapture()
        }
        return interpolatedData()
    }

    override fun getDeviceError(): String {
        return "None"
    }

    override fun setEventListener(onClick: () -> Unit): LiveData<String> = liveData {

        onClickScanButton = onClick

        emit("DONE")
    }
}