package org.phenoapps.security

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.documentfile.provider.DocumentFile
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import org.phenoapps.interfaces.security.SecureDefineDocumentTree
import org.phenoapps.utils.BaseDocumentTreeUtil
import org.phenoapps.utils.BaseDocumentTreeUtil.Companion.isVolumeRoot
import org.phenoapps.utils.KeyUtil

class SecureDefineDocumentTreeImpl(private val fragment: Fragment) : SecureDefineDocumentTree {

    companion object {
        const val TAG = SecureDefineDocumentTree.TAG
    }

    private var mDefaultAppName: String = "PhenoApp"

    private val advisor by Security().secureOpenDocument(fragment)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun defineDocumentTree(onSuccess: (uri: Uri) -> Unit, onFail: (uri: Uri?) -> Unit) {

        advisor.openTree { uri ->

            fragment.context?.let { ctx ->

                persistSinglePermission(ctx, uri)

                //check if the chosen uri is valid
                //older devices can choose the root directory which should fail here
                if (uri.isVolumeRoot()) {

                    Log.d(TAG, "User chose an invalid directory: $uri")

                    DocumentFile.fromTreeUri(ctx, uri)?.let { root ->

                        root.createDirectory(mDefaultAppName)?.uri?.let { defaultUri ->

                            val prefs = PreferenceManager.getDefaultSharedPreferences(ctx)
                            prefs.edit().putString(KeyUtil(ctx).defaultTreeUri,
                                defaultUri.toString()).apply()

                            onSuccess(defaultUri)
                        }
                    }

                } else {

                    onSuccess(uri)

                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun persistSinglePermission(ctx: Context, uri: Uri) {

        val flags =
            Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION

        with(ctx.contentResolver) {

            //add new uri to persistable that the user just picked
            this?.takePersistableUriPermission(uri, flags)

            //release old storage directory from persistable if it exists
            val oldPermitted = this?.persistedUriPermissions
            if (oldPermitted != null && oldPermitted.isNotEmpty()) {
                this?.persistedUriPermissions?.forEach {
                    if (it.uri != uri) {
                        releasePersistableUriPermission(
                            it.uri,
                            Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                        )
                    }
                }
            }
        }
    }

    override fun setDefaultAppName(name: String) {
        super.setDefaultAppName(name)
        mDefaultAppName = name
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initialize() {

        advisor.initialize()

    }

    override fun withPermission(permissions: Array<String>, onResult: () -> Unit) {
        advisor.withPermission(permissions, onResult)
    }
}