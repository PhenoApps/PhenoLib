package org.phenoapps.security

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import org.phenoapps.interfaces.security.SecureFragmentInterface
import org.phenoapps.interfaces.security.SecureOpenDocumentTree
import kotlin.properties.ReadOnlyProperty

class Security {

    private val TAG = "SecureType"

    private var secureFragment: SecureFragmentImpl? = null
    private var secureOpenDocument: SecureOpenDocumentImpl? = null
    private var secureDocument: SecureDefineDocumentTreeImpl? = null
    private var secureBluetooth: SecureBluetoothImpl? = null

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    fun secureBluetooth(): ReadOnlyProperty<Fragment, SecureBluetoothImpl> =
        ReadOnlyProperty { thisRef, property ->
            Log.d(TAG, "$thisRef has utilized Bluetooth security by ${property.name}")
            if (secureBluetooth == null) {
                secureBluetooth = SecureBluetoothImpl(thisRef)
            }
            secureBluetooth!!
        }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun secureDocumentTree(): ReadOnlyProperty<Fragment, SecureDefineDocumentTreeImpl> =
        ReadOnlyProperty { thisRef, property ->
            Log.d(TAG, "$thisRef has utilized folder definer security by ${property.name}")
            if (secureDocument == null) {
                secureDocument = SecureDefineDocumentTreeImpl(thisRef)
            }
            secureDocument!!
        }

    fun secureOpenDocument(): ReadOnlyProperty<Fragment, SecureOpenDocumentImpl> =
        ReadOnlyProperty { thisRef, property ->
            Log.d(TAG, "$thisRef has utilized open document security by ${property.name}")
            if (secureOpenDocument == null) {
                secureOpenDocument = SecureOpenDocumentImpl(thisRef)
            }
            secureOpenDocument!!
        }

    fun secureOpenDocument(frag: Fragment): ReadOnlyProperty<SecureFragmentInterface, SecureOpenDocumentImpl> =
        ReadOnlyProperty { _, property ->
            Log.d(TAG, "$frag has utilized open document security by ${property.name}")
            if (secureOpenDocument == null) {
                secureOpenDocument = SecureOpenDocumentImpl(frag)
            }
            secureOpenDocument!!
        }

    fun secureFragment(): ReadOnlyProperty<Fragment, SecureFragmentImpl> =
        ReadOnlyProperty { thisRef, property ->
            Log.d(TAG, "$thisRef has utilized permission requests by ${property.name}")
            if (secureFragment == null) {
                secureFragment = SecureFragmentImpl(thisRef)
            }
            secureFragment!!
        }

    fun secureFragment(frag: Fragment): ReadOnlyProperty<SecureFragmentInterface, SecureFragmentImpl> =
        ReadOnlyProperty { _, property ->
            Log.d(TAG, "$frag has utilized permission requests by ${property.name}")
            if (secureFragment == null) {
                secureFragment = SecureFragmentImpl(frag)
            }
            secureFragment!!
        }

}