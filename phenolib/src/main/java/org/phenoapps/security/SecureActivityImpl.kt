package org.phenoapps.security

import android.app.Activity
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import org.phenoapps.androidlibrary.R
import org.phenoapps.annotations.Experimental
import org.phenoapps.interfaces.security.SecureFragmentInterface

@Experimental
open class SecureActivityImpl(private val activity: FragmentActivity): SecureFragmentInterface {

    private var mOnResultCallback: () -> Unit = { /* not implemented */ }

    private var mPermissions: ActivityResultLauncher<Array<String>>? = null

    override fun initialize() {
        if (mPermissions == null) {
            mPermissions = activity.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
                result?.let { permissions ->
                    if (!permissions.containsValue(false)) {
                        mOnResultCallback()
                    } else {
                        Toast.makeText(activity, R.string.frag_secure_permission_not_granted, Toast.LENGTH_SHORT).show()
                        activity.setResult(Activity.RESULT_CANCELED)
                        activity.finish()
                    }
                }
            }
        }
    }

    override fun withPermission(permissions: Array<String>, onResult: () -> Unit) {

        //set the callback if permissions are not already granted
        mOnResultCallback = onResult

        //check permission that aren't granted which are needed
        val needed = permissions.associateBy {
            ActivityCompat.checkSelfPermission(activity, it) == PackageManager.PERMISSION_GRANTED
        }.filter { !it.key }
            .map { it.value }

        if (needed.isNotEmpty()) {

            mPermissions?.launch(needed.toTypedArray())

        } else mOnResultCallback()
    }
}