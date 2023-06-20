package org.phenoapps.fragments.gopro

/**
 * various go pro gatt commands required for image capture and stream preview
 */
interface GoProGattInterface {
        fun enableAp()
        fun disableAp()
        fun shutterOn()
        fun shutterOff()
}