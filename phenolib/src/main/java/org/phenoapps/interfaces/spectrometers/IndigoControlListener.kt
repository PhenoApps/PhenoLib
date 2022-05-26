package org.phenoapps.interfaces.spectrometers

import androidx.lifecycle.LiveData
import org.phenoapps.viewmodels.spectrometers.Frame

interface IndigoControlListener {
    fun onBatteryCritical()
    fun onTemperatureEvent()
    fun onGpioOne()
    fun onGpioTwo()
    fun onGpioThree()
    fun onPowerButton()

    fun readRawData(): LiveData<List<Frame>?>

    fun triggerSingleCapture()
    fun triggerContinuousCapture()
    fun stopContinuousCapture()
    fun triggerPowerDown()
    fun loadConfigFromFlash()
    fun saveActiveConfigInFlash()
    fun getFactoryConfigInFlash()
    fun pushParametersToCamera()
    fun disableBoardLed()
    fun enableBoardLed()
    fun startAutoCalibration()
    fun switchToPixelMode()
    fun switchToLambdaMode()
    fun disableIntensityCalibrationFilter()
    fun enableIntensityCalibrationFilter()
    fun disableLowMtuMode()
    fun enableLowMtuMode()
}