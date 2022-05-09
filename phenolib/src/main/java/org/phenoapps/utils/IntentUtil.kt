package org.phenoapps.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

class IntentUtil {

    companion object {

        /**
         * Starts a share file intent.
         * @param uri the uri to grant permission and share
         * @param subject displayed subject title
         * @param text displayed message during share
         */
        fun shareFile(context: Context?, uri: Uri, subject: String?, text: String?) {
            context?.let { ctx ->

                try {

                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "*/*"
                        flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                        subject?.let { putExtra(Intent.EXTRA_SUBJECT, it) }
                        text?.let { putExtra(Intent.EXTRA_TEXT, it) }
                        putExtra(Intent.EXTRA_STREAM, uri)
                    }

                    ctx.startActivity(intent)

                } catch (e: Exception) {

                    e.printStackTrace()

                }
            }
        }
    }
}