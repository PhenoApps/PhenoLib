package org.phenoapps.interfaces.iot

import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.preference.PreferenceManager

interface Device {

    data class DeviceInfo(val softwareVersion: String,
        val hardwareVersion: String,
        val deviceId: String,
        val alias: String,
        val opMode: String,
        val deviceType: String,
        val serialNumber: String? = null,
        val humidity: String? = null,
        val temperature: String? = null)

    fun manager(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun connect(adapter: BluetoothAdapter, context: Context, address: String) = Unit

    suspend fun connect(context: Context) = Unit

    fun disconnect(context: Context): Int? = -1

    fun disconnect() = Unit

    fun isConnected(): Boolean

    fun reset(context: Context?) = Unit

    fun getDeviceError(): String?

    fun getDeviceInfo(): DeviceInfo

    fun setEventListener(onClick: () -> Unit): LiveData<String>

}