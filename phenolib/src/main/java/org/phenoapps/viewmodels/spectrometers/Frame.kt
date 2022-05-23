package org.phenoapps.viewmodels.spectrometers

/**
 * Represents data returned from a spectrometer.
 */
data class Frame(
    var rawData: String? = null,
    var rawDataMap: Map<String, String>? = null
)