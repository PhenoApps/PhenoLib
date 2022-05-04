package org.phenoapps.utils

import android.content.Context
import android.net.Uri
import android.os.Build
import android.provider.OpenableColumns
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.documentfile.provider.DocumentFile
import androidx.preference.PreferenceManager
import org.phenoapps.androidlibrary.R
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.lang.UnsupportedOperationException
import java.util.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
open class BaseDocumentTreeUtil {

    /**
     * Static functions to be used to handle exports.
     * These functions will attempt to create these directories if they do not exist.
     */
    companion object {

        const val TAG = "DocumentTreeUtil"

        fun Uri.getStem(context: Context?): String {
            Log.d(TAG, "Getting stem for ${toString()}")
            var stem = try {
                getFileStem()
            } catch (e: Exception) {
                e.printStackTrace()
                toString()
            }
            if (scheme == "content") {
                try {
                    context?.contentResolver?.query(this, null, null, null, null).use { c ->
                        if (c != null && c.moveToFirst()) {
                            val index: Int = c.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                            if (index > 0) {
                                stem = c.getString(index)
                            }
                        }
                    }
                } catch (e: Exception) {

                    e.printStackTrace()

                }
            }
            if (stem.contains(".")) {
                val dotIndex = stem.lastIndexOf(".")
                stem = stem.substring(0, dotIndex)
            }
            return stem
        }

        private fun Uri.getFileStem(): String {
            val path = toString()
            //uri separated by query param separator %2F, not encoded with keys
            val token = "%2F"
            val tokenSize = token.length
            val first = path.lastIndexOf(token) + tokenSize
            val last = path.lastIndexOf(".")
            return if (first >= 0 && last >= 0) path.substring(first, last)
            else path
        }

        fun DocumentFile.breadthCopy(context: Context, directories: Array<String>,
                                             root: Uri, file: DocumentFile,
                                             updateUri: ((DocumentFile, DocumentFile) -> Unit)?) {
            file.listFiles().forEach { f ->
                copy(context, directories, root, this, f, updateUri)
            }
        }

        fun copy(context: Context, directories: Array<String>,
                         root: Uri, output: DocumentFile, file: DocumentFile,
                         updateUri: ((DocumentFile, DocumentFile) -> Unit)? = null) {

            if (root != file.uri) { //do not permit infinite recursion

                file.name?.let { name ->

                    if (!file.isDirectory) {

                        val checkDoc = output.findFile(name)
                        if (checkDoc == null || !checkDoc.exists()) {

                            output.createFile("*/*", name)?.let { docFile ->

                                context.contentResolver.openInputStream(file.uri)?.use { input ->

                                    context.contentResolver.openOutputStream(docFile.uri)?.use { output ->

                                        input.copyTo(output)

                                    }
                                }

                                updateUri?.invoke(file, docFile)

                            }

                        } else updateUri?.invoke(file, checkDoc)

                    } else {

                        val dir = output.findFile(name)

                        if (dir == null || !dir.isDirectory) {

                            val isFbPlotMedia = file.parentFile?.name == "plot_data"
                            val isFbMediaDir = file.name in setOf("audio", "photos")
                            if (dir?.name in directories || isFbPlotMedia || isFbMediaDir) {

                                output.createDirectory(name)?.breadthCopy(context, directories, root, file, updateUri)

                            } else return

                        } else dir.breadthCopy(context, directories, root, file, updateUri)
                    }
                }
            }
        }

        /**
         * Creates the root directory structure.
         * @param context: The org.phenoapps.fragments/activity's context this function checks for null
         * @param uri: must be a tree uri from DocumentFile
         * @param directories: the array of directory names to define in the root folder
         *
         * Used in BaseStorageDefinerFragment, asks user to define a folder which creates a tree uri
         * this tree uri is passed here to create the folder structure.
         * @return docFile this can be null
         */
        fun defineRootStructure(context: Context?, uri: Uri, directories: Array<String>): DocumentFile? {

            context?.let { ctx ->

                DocumentFile.fromTreeUri(ctx, uri)?.let { tree ->

                    directories.forEach { dir ->

                        val dirFile = tree.findFile(dir.lowercase(Locale.getDefault()))
                        if (dirFile == null || !dirFile.exists()) {
                            tree.createDirectory(dir)
                        }
                    }

                    return tree
                }
            }

            return null

        }

        /**
         * Copies one document file to another.
         */
        fun copy(context: Context?, from: DocumentFile?, to: DocumentFile?) {
            context?.let { ctx ->

                try {
                    to?.let { toFile ->
                        from?.let { fromFile ->
                            with (ctx.contentResolver) {
                                openOutputStream(toFile.uri)?.use { output ->
                                    openInputStream(fromFile.uri)?.use { input ->
                                        input.copyTo(output)
                                    }
                                }
                            }
                        }
                    }

                } catch (f: FileNotFoundException) {

                    f.printStackTrace()

                }
            }
        }

        /**
         * Returns a document file based on its name and folder resource id.
         */
        fun getFile(context: Context?, dir: Int, fileName: String): DocumentFile? {

            context?.let { ctx ->

                getDirectory(ctx, dir)?.let { dir ->

                    dir.findFile(fileName)?.let { file ->

                        return file
                    }
                }
            }

            return null
        }

        /**
         * Returns the input stream for a given uri
         */
        fun getUriInputStream(context: Context?, uri: Uri): InputStream? {

            try {

                return context?.contentResolver?.openInputStream(uri)

            } catch (e: FileNotFoundException) {

                e.printStackTrace()

            }

            return null
        }

        /**
         * Returns the input stream for a given file
         */
        fun getFileInputStream(context: Context?, dir: Int, fileName: String): InputStream? {

            try {

                getFile(context, dir, fileName)?.let { file ->

                    return context?.contentResolver?.openInputStream(file.uri)

                }

            } catch (e: FileNotFoundException) {

                e.printStackTrace()

            }

            return null
        }

        /**
         * Returns an output stream for the given file.
         */
        fun getFileOutputStream(context: Context?, dir: Int, fileName: String): OutputStream? {

            try {

                getFile(context, dir, fileName)?.let { file ->

                    return context?.contentResolver?.openOutputStream(file.uri)
                }

            } catch (e: FileNotFoundException) {

                e.printStackTrace()

            }

            return null
        }

        /**
         * Returns one of the main sub directories within the app.
         */
        fun getDirectory(context: Context?, id: Int): DocumentFile? {

            context?.let { ctx ->

                val directoryName = ctx.getString(id)

                return createDir(ctx, directoryName)
            }

            return null
        }

        /**
         * Checks whether a persisted uri has been saved; therefore, defined by the user.
         */
        fun isEnabled(ctx: Context): Boolean {
            val persists = ctx.contentResolver.persistedUriPermissions
            return if (persists.isNotEmpty()) {
                DocumentFile.fromTreeUri(ctx, persists[0].uri)?.exists() == true
            } else false
        }

        /**
         * Function that checks if the persisted folder exists.
         * If it does not exist, show a dialog asking the user to define it.
         * @param ctx the calling context
         * @param function the callback, true if the user selects to define a storage
         */
        fun checkDir(context: Context?, function: (Boolean) -> Unit) {

            if (getRoot(context)?.exists() != true) {

                context?.let { ctx ->

                    AlertDialog.Builder(ctx)
                        .setNegativeButton(android.R.string.no) { dialog, which ->

                            dialog.dismiss()

                            function(false)

                        }
                        .setPositiveButton(android.R.string.yes) { dialog, which ->

                            dialog.dismiss()

                            function(true)
                        }
                        .setTitle(R.string.document_tree_undefined)
                        .create()
                        .show()
                }

            } else {

                function(false)
            }
        }

        fun Uri.isVolumeRoot() = toString().endsWith("%3A")

        /**
         * Obtains the root directory defined in storage definer
         * If the user has chosen a root volume directory, this will be stored in
         * preferences with defaultTreeUri key.
         */
        fun getRoot(context: Context?): DocumentFile? {
            context?.let { ctx ->
                val persists = ctx.contentResolver.persistedUriPermissions
                if (persists.isNotEmpty()) {
                    val prefs = PreferenceManager.getDefaultSharedPreferences(ctx)
                    val default = prefs.getString(KeyUtil(ctx).defaultTreeUri, null)
                    val uri = persists.first().uri
                    Log.d(TAG, "Checking volume uri $uri: $default")
                    return DocumentFile.fromTreeUri(ctx,
                        if (uri.isVolumeRoot()) Uri.parse(default)
                        else uri)
                }
            }
            return null
        }

        /**
         * Function to copy asset files to SAF dir
         */
        fun copyAsset(context: Context?, assetName: String, assetDir: String, dirId: Int) {

            context?.let { ctx ->

                try {

                    ctx.assets.list(assetDir)?.forEach { file ->

                        if (file.toString() == assetName) {

                            getDirectory(ctx, dirId)?.let { dir ->

                                if (dir.exists()) {

                                    try {

                                        if (dir.findFile(file)?.exists() != true) {
                                            dir.createFile("*/*", file)?.let {

                                                Log.d(TAG, "Copying sample ${it.name} from $assetDir/$file to ${it.uri}")

                                                context.contentResolver.openOutputStream(it.uri)?.use { outputStream ->
                                                    context.assets.open("$assetDir/$file").use { input ->
                                                        input.copyTo(outputStream)
                                                    }
                                                }
                                            }
                                        }

                                    } catch (e: UnsupportedOperationException) {

                                        e.printStackTrace()

                                    } catch (f: FileNotFoundException) {

                                        f.printStackTrace()

                                    } catch (io: IOException) {

                                        io.printStackTrace()

                                    }
                                }
                            }
                        }
                    }

                } catch (fnf: FileNotFoundException) {

                    fnf.printStackTrace()

                }
            }
        }

        /**
         * Used to create or return a document file by name.
         */
        fun DocumentFile.getOrCreate(name: String): DocumentFile? {

            try {

                val dir = findFile(name)
                return if (dir == null || !dir.exists()) {
                    createDirectory(name)
                } else dir

            } catch (e: UnsupportedOperationException) {

                e.printStackTrace()

            }

            return null
        }

        /**
         * Logs whether or not the file exists
         */
        fun DocumentFile?.logDirectoryExists(ctx: Context, name: String) {

            if (this == null || !exists()) {

                Log.d(TAG, ctx.getString(R.string.error_dtu_dir_not_created, name))
            }
        }

        /**
         * Creates a child directory within a parent directory.
         */
        fun createDir(ctx: Context, parent: String, child: String): DocumentFile? {

            val file = createDir(ctx, parent)
            return if (file?.findFile(child)?.isDirectory == true) {
                file.findFile(child)
            } else file?.createDirectory(child)
        }

        /**
         * Finds the persisted uri and creates the basic coordinate file structure if it doesn't exist.
         */
        private fun createDir(ctx: Context, parent: String) = getRoot(ctx)?.getOrCreate(parent)

    }
}