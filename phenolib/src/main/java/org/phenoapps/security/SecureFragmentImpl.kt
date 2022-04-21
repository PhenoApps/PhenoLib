package org.phenoapps.security

import android.app.Activity
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import org.phenoapps.androidlibrary.R
import org.phenoapps.interfaces.security.SecureFragmentInterface

open class SecureFragmentImpl(private val fragment: Fragment): SecureFragmentInterface {

    private var mOnResultCallback: () -> Unit = { /* not implemented */ }

    private var mPermissions: ActivityResultLauncher<Array<String>>? = null

    override fun initialize() {
        if (mPermissions == null) {
            mPermissions = fragment.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
                result?.let { permissions ->
                    if (!permissions.containsValue(false)) {
                        mOnResultCallback()
                    } else {
                        Toast.makeText(fragment.context, R.string.frag_secure_permission_not_granted, Toast.LENGTH_SHORT).show()
                        fragment.activity?.setResult(Activity.RESULT_CANCELED)
                        fragment.activity?.finish()
                    }
                }
            }
        }
    }

    override fun withPermission(permissions: Array<String>, onResult: () -> Unit) {

        //set the callback if permissions are not already granted
        mOnResultCallback = onResult

        fragment.context?.let { ctx ->

            //check permission that aren't granted which are needed
            val needed = permissions.associateBy {
                ActivityCompat.checkSelfPermission(ctx, it) == PackageManager.PERMISSION_GRANTED
            }.filter { !it.key }
                .map { it.value }

            if (needed.isNotEmpty()) {

                mPermissions?.launch(needed.toTypedArray())

            } else mOnResultCallback()
        }
    }
}