package org.phenoapps.interfaces.security

import android.net.Uri
import java.io.File

interface SecureDefineDocumentTree: SecureFragmentInterface {
    companion object {
        const val TAG = "${SecureFragmentInterface.TAG}/DefineDoc"
    }
    fun setDefaultAppName(name: String = "PhenoApp") = Unit
    fun defineDocumentTree(onSuccess: (uri: Uri) -> Unit, onFail: (uri: Uri?) -> Unit)
    fun defineFolder(function: (file: File) -> Unit) = Unit //define this folder API < KITKAT
}