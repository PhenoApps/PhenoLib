package org.phenoapps.utils

import android.bluetooth.BluetoothGattCharacteristic
import android.os.Build
import androidx.annotation.RequiresApi
import org.phenoapps.viewmodels.spectrometers.IndigoViewModel
import java.lang.StringBuilder

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
class GattUtil {

    companion object {

        fun Int.toBitString() = StringBuilder().apply {
            for (i in 1..8) {
                val mask = 1 shl i
                append(if (this@toBitString and mask == 1) "1" else "0")
            }
        }.toString()

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun ByteArray.toPixelWave() = IndigoViewModel.LambdaReference(
            pix = toUnsignedInt16(this[0], this[1]),
            wave = toUnsignedInt16(this[2], this[3])
        )

        fun Array<ByteArray?>.toUnsignedInt8Array() = arrayListOf<Int>().apply {
            this@toUnsignedInt8Array.map { bytes ->
                bytes?.map { byte ->
                    add(byte.toInt() and 0xff)
                }
            }
        }

        fun String.toHexByteArray(): ByteArray = chunked(2).map { it.toInt(16).toByte() }.toByteArray()

        /**
         * Convert two bytes to little endian 16 bit unsigned integer
         * lsb = 3F msb = 00 => 0x003F => 63
         */
        fun toUnsignedInt16(lsb: Byte, msb: Byte) = ((msb.toInt() and 0xff) shl 8) or (lsb.toInt() and 0xff)


        fun BluetoothGattCharacteristic.isIndicatable(): Boolean =
            containsProperty(BluetoothGattCharacteristic.PROPERTY_INDICATE)

        fun BluetoothGattCharacteristic.isNotifiable(): Boolean =
            containsProperty(BluetoothGattCharacteristic.PROPERTY_NOTIFY)

        fun BluetoothGattCharacteristic.isReadable(): Boolean =
            containsProperty(BluetoothGattCharacteristic.PROPERTY_READ)

        fun BluetoothGattCharacteristic.isWritable(): Boolean =
            containsProperty(BluetoothGattCharacteristic.PROPERTY_WRITE)

        fun BluetoothGattCharacteristic.isWritableWithoutResponse(): Boolean =
            containsProperty(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE)

        fun BluetoothGattCharacteristic.containsProperty(property: Int): Boolean {
            return properties and property != 0
        }

        fun ByteArray.toHexString(): String =
            joinToString(separator = " ", prefix = "0x") { String.format("%02X", it) }
    }
}