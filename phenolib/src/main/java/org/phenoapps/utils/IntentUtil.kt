package org.phenoapps.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import org.phenoapps.interfaces.security.TestIntentUtil

class IntentUtil {

    companion object : TestIntentUtil {

        /**
         * Calls start activity on a given intent.
         */
        override fun startActivity(context: Context?, intent: Intent) {

            context?.let { ctx ->

                try {

                    ctx.startActivity(intent)

                } catch (e: Exception) {

                    e.printStackTrace()

                }
            }
        }

        /**
         * Starts a share file intent.
         * @param uri the uri to grant permission and share
         * @param subject displayed subject title
         * @param text displayed message during share
         */
        override fun shareFile(context: Context?, uri: Uri, subject: String?, text: String?) {

            startActivity(context, shareFileIntent(uri, subject, text))
        }

        /**
         * Starts a share file intent with a chooser.
         * @param uri the uri to grant permission and share
         * @param subject displayed subject title
         * @param text displayed message during share
         */
        override fun shareFileChooser(context: Context?, uri: Uri, title: String, subject: String?, text: String?) {

            startActivity(context, shareFileChooserIntent(uri, title, subject, text))
        }

        /**
         * Creates the share file chooser.
         */
        override fun shareFileChooserIntent(uri: Uri, title: String, subject: String?, text: String?): Intent =
            Intent.createChooser(shareFileIntent(uri, subject, text), title)

        /**
         * Similar to shareFile but returns the intent
         */
        override fun shareFileIntent(uri: Uri, subject: String?, text: String?) = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            subject?.let { putExtra(Intent.EXTRA_SUBJECT, it) }
            text?.let { putExtra(Intent.EXTRA_TEXT, it) }
            putExtra(Intent.EXTRA_STREAM, uri)
        }
    }
}