package org.phenoapps.viewmodels.spectrometers

/**
 * Represents data returned from a spectrometer.
 */
data class Frame(
    var length: Int? = null,
    var lightSource: Int? = null,
    var frameIndex: Int? = null,
    var deviceType: String? = null,
    var data: FloatArray? = null,
    var wavelengths: String? = null,
    var rawData: String? = null,
    var rawDataMap: Map<String, String>? = null
) {

    companion object {
        const val LIGHT_SOURCE_NONE = -1
        const val LIGHT_SOURCE_LED = 0
        const val LIGHT_SOURCE_BULB = 1
        const val LIGHT_SOURCE_UV = 2
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Frame

        if (length != other.length) return false
        if (lightSource != other.lightSource) return false
        if (frameIndex != other.frameIndex) return false
        if (deviceType != other.deviceType) return false
        if (data != null) {
            if (other.data == null) return false
            if (!data.contentEquals(other.data)) return false
        } else if (other.data != null) return false
        if (rawData != other.rawData) return false
        if (rawDataMap != other.rawDataMap) return false

        return true
    }

    override fun hashCode(): Int {
        var result = length ?: 0
        result = 31 * result + (lightSource ?: 0)
        result = 31 * result + (frameIndex ?: 0)
        result = 31 * result + (deviceType?.hashCode() ?: 0)
        result = 31 * result + (data?.contentHashCode() ?: 0)
        result = 31 * result + (rawData?.hashCode() ?: 0)
        result = 31 * result + (rawDataMap?.hashCode() ?: 0)
        return result
    }
}