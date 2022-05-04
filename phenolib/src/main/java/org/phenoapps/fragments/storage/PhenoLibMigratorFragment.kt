package org.phenoapps.fragments.storage

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.*
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.documentfile.provider.DocumentFile
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.*
import org.phenoapps.androidlibrary.R
import org.phenoapps.security.Security
import org.phenoapps.utils.BaseDocumentTreeUtil.Companion.breadthCopy

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
open class PhenoLibMigratorFragment: Fragment(R.layout.fragment_storage_migrator),
    CoroutineScope by MainScope() {

    private val mHandlerThread = HandlerThread("migrator")

    private val openAdvisor by Security().secureOpenDocument()

    open val actionEnd: NavDirections? = null

    open var directories: Array<String>? = null

    open val migrateButtonColor: Int? = null

    open val migrateButtonTextColor: Int? = null

    open val skipButtonColor: Int? = null

    open val skipButtonTextColor: Int? = null

    open val backgroundColor: Int? = null

    private var mProgressBar: ProgressBar? = null

    init {

        openAdvisor.initialize()

        mHandlerThread.looper
        mHandlerThread.start()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (directories == null) {

            directories = resources.getStringArray(R.array.directories)

        }
    }

    open fun onUpdateUri(from: DocumentFile, to: DocumentFile) {
        /* not implemented */
    }

    /**
     * Copy all folders from old uri to new uri.
     */
    open fun migrateStorage(from: DocumentFile, to: DocumentFile) {

        context?.let { ctx ->

            directories?.let { dirs ->

                runBlocking {

                    to.breadthCopy(ctx, dirs, to.uri, from) { from, to ->

                        onUpdateUri(from, to)
                    }
                }
            }
        }
    }

    private fun onMigrate(uri: Uri) {

        context?.let { ctx ->

            val flags = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION

            with (ctx.contentResolver) {

                if (persistedUriPermissions.isNotEmpty()) {

                    persistedUriPermissions.first().uri?.let { newRoot ->

                        //add new uri to persistable that the user just picked
                        takePersistableUriPermission(uri, flags)

                        DocumentFile.fromTreeUri(ctx, uri)?.let { oldTree ->

                            DocumentFile.fromTreeUri(ctx, newRoot)?.let { newTree ->

                                migrateStorage(oldTree, newTree)

                            }
                        }

                        //release old storage directory from persistable if it exists
                        if (persistedUriPermissions.isNotEmpty()) {
                            persistedUriPermissions.forEach {
                                if (it.uri != newRoot) {
                                    releasePersistableUriPermission(it.uri,
                                        Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val migrateButton = view.findViewById<Button>(R.id.frag_storage_migrator_choose_dir_btn)
        val skipButton = view.findViewById<Button>(R.id.frag_storage_migrator_skip_btn)
        mProgressBar = view.findViewById(R.id.frag_migrator_pb)

        migrateButton?.setOnClickListener { _ ->

            openAdvisor.openTree { uri ->

                mProgressBar?.visibility = View.VISIBLE
                migrateButton.isEnabled = false
                skipButton.isEnabled = false

                Handler(mHandlerThread.looper).postDelayed({

                    onMigrate(uri)

                    navigateEnd()

                }, 500)
            }
        }

        skipButton?.setOnClickListener {

            navigateEnd()
        }

        migrateButtonColor?.let { color ->

            migrateButton?.setBackgroundColor(color)
        }

        migrateButtonTextColor?.let { color ->

            migrateButton?.setTextColor(color)
        }

        skipButtonColor?.let { color ->

            skipButton?.setBackgroundColor(color)
        }

        skipButtonTextColor?.let { color ->

            skipButton?.setTextColor(color)
        }

        backgroundColor?.let { color ->

            view.setBackgroundColor(color)
        }

    }

    open fun navigateEnd() {
        activity?.runOnUiThread {

            Toast.makeText(context, R.string.frag_migrator_status_complete,
                Toast.LENGTH_SHORT).show()

            if (actionEnd != null) {
                findNavController().navigate(actionEnd!!)
            } else {
                findNavController().popBackStack(R.id.storage_definer, inclusive = true)
            }
        }
    }
}