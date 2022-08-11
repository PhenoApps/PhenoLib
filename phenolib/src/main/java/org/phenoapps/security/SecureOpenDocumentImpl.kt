package org.phenoapps.security

import android.net.Uri
import android.os.Build
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import org.phenoapps.interfaces.security.SecureDefineDocumentTree
import org.phenoapps.interfaces.security.SecureOpenDocumentTree

class SecureOpenDocumentImpl(private val fragment: Fragment) : SecureOpenDocumentTree {

    companion object {
        const val TAG = SecureOpenDocumentTree.TAG
    }

    private val advisor by Security().secureFragment(fragment)

    private var mOnTreePicked: (Uri) -> Unit = { _ -> /* not implemented */ }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private var mDocumentTree: ActivityResultLauncher<Uri?>? = null

    override fun openTree(onSuccess: (uri: Uri) -> Unit) {

        mOnTreePicked = onSuccess

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            withPermission(arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                mDocumentTree?.launch(null)
            }

        } else {

            //TODO implement for devices < LOLLIPOP

        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initialize() {

        advisor.initialize()

        if (mDocumentTree == null) {
            mDocumentTree = fragment.registerForActivityResult(ActivityResultContracts.OpenDocumentTree()) { uri ->

                uri?.let { nonNullUri ->

                    mOnTreePicked(nonNullUri)
                }
            }
        }
    }

    override fun withPermission(permissions: Array<String>, onResult: () -> Unit) {
        advisor.withPermission(permissions, onResult)
    }
}