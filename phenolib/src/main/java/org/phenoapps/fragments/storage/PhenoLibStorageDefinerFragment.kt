package org.phenoapps.fragments.storage

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.phenoapps.androidlibrary.R
import org.phenoapps.fragments.storage.PhenoLibStorageDefinerFragmentDirections
import org.phenoapps.interfaces.security.SecureFragmentInterface.Companion.TAG
import org.phenoapps.security.Security
import org.phenoapps.utils.BaseDocumentTreeUtil
import org.phenoapps.utils.KeyUtil

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
open class PhenoLibStorageDefinerFragment: Fragment(R.layout.fragment_storage_definer) {

    data class AssetSample(val dir: String, val name: String)

    open val defaultAppName = "PhenoApp"

    private val documentAdvisor by Security().secureDocumentTree()

    private var mDefineBtn: Button? = null

    open var directories: Array<String>? = null

    open val actionToMigrator = PhenoLibStorageDefinerFragmentDirections
        .actionStorageDefinerToStorageMigrator()

    open val samples: Map<AssetSample, Int> = mapOf()

    open val buttonColor: Int? = null

    open val buttonTextColor: Int? = null

    open val backgroundColor: Int? = null

    private var mProgressBar: ProgressBar? = null

    private val mHandlerThread = HandlerThread("definer")

    init {

        mHandlerThread.looper
        mHandlerThread.start()
    }

    /**
     * Define this if this fragment should skip the migrator after defining a folder,
     * and that folder contains a file with this name.
     */
    open val migrateChecker: String? = null

    private val mKeyUtil by lazy {
        KeyUtil(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        documentAdvisor.initialize()
        documentAdvisor.setDefaultAppName(defaultAppName)

        mDefineBtn = view.findViewById(R.id.frag_storage_definer_choose_dir_btn)
        mProgressBar = view.findViewById(R.id.frag_storage_definer_pb)

        Log.d("FBProgressF", mProgressBar?.visibility?.toString() ?: "Null")

        mDefineBtn?.setOnClickListener { _ ->

            launchDefiner()
        }

        buttonColor?.let { color ->

            mDefineBtn?.setBackgroundColor(color)
        }

        buttonTextColor?.let { color ->

            mDefineBtn?.setTextColor(color)
        }

        backgroundColor?.let { color ->

            view.setBackgroundColor(color)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (directories == null) {

            directories = resources.getStringArray(R.array.directories)

        }
    }

    private fun launchDefiner() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            documentAdvisor.defineDocumentTree({ treeUri ->

                mProgressBar?.visibility = View.VISIBLE

                Log.d("FBProgress", mProgressBar?.visibility?.toString() ?: "Null")

                mDefineBtn?.isEnabled = false

                Handler(mHandlerThread.looper).postDelayed({
                    onTreeDefined(treeUri)
                }, 500)

            }) {

                Toast.makeText(context, R.string.frag_storage_definer_failed_uri_choice,
                    Toast.LENGTH_SHORT).show()
            }

        } else {

            Toast.makeText(context, R.string.frag_storage_definer_need_higher_api,
                Toast.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    open fun onTreeDefined(treeUri: Uri) {

        val prefs = PreferenceManager.getDefaultSharedPreferences(context)

        runBlocking {

            directories?.let { dirs ->

                BaseDocumentTreeUtil.defineRootStructure(context, treeUri, dirs)?.let { root ->

                    samples.entries.forEach { entry ->

                        val sampleAsset = entry.key
                        val dir = entry.value

                        BaseDocumentTreeUtil.copyAsset(context, sampleAsset.name, sampleAsset.dir, dir)
                    }

                    if (migrateChecker != null) {
                        root.listFiles().forEach {
                            if (it.name == migrateChecker) {
                                prefs.edit().putBoolean(mKeyUtil.enableMigrator, false).apply()
                            }
                        }
                    }
                }
            }
        }

        actionAfterDefine()
    }

    open fun actionNoMigrate() {
        findNavController().popBackStack()
    }

    open fun actionAfterDefine() {
        activity?.runOnUiThread {
            val prefs = PreferenceManager.getDefaultSharedPreferences(context)
            if (prefs.getBoolean(mKeyUtil.enableMigrator, true)) {
                findNavController().navigate(actionToMigrator)
            } else actionNoMigrate()

            if (migrateChecker != null) { //reset enable migrator check
                prefs.edit().putBoolean(mKeyUtil.enableMigrator, true).apply()
            }
        }
    }
}