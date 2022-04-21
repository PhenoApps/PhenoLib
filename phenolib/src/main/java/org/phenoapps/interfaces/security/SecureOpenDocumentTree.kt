package org.phenoapps.interfaces.security

import android.net.Uri
import java.io.File

interface SecureOpenDocumentTree: SecureFragmentInterface {
    companion object {
        const val TAG = "${SecureFragmentInterface.TAG}/OpenDoc"
    }
    fun openTree(onSuccess: (uri: Uri) -> Unit)
    fun defineFolder(function: (file: File) -> Unit) = Unit //define this folder API < KITKAT
}