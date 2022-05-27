package org.phenoapps.interfaces.security

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.documentfile.provider.DocumentFile
import org.phenoapps.utils.BaseDocumentTreeUtil
import java.io.File

interface TestIntentUtil {

    fun startActivity(context: Context?, intent: Intent)

    //file sharing
    fun shareFile(context: Context?, uri: Uri, subject: String?, text: String?)
    fun shareFileChooser(context: Context?, uri: Uri, title: String, subject: String?, text: String?)
    fun shareFileChooserIntent(uri: Uri, title: String, subject: String?, text: String?): Intent
    fun shareFileIntent(uri: Uri, subject: String?, text: String?): Intent

    //ask system functionality
    fun askSystemLocation(context: Context?)
    fun askSystemBluetooth(context: Context?)

    fun testSystemLocation(context: Context?) {

        context?.let { ctx ->

            askSystemLocation(ctx)
        }
    }

    fun testSystemBluetooth(context: Context?) {

        context?.let { ctx ->

            askSystemBluetooth(ctx)
        }
    }

    //to be used in pheno lib app examples, requires defined storage
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun appTestShareFileChooser(context: Context?) {

        context?.let { ctx ->

            if (BaseDocumentTreeUtil.isEnabled(ctx)) {

                BaseDocumentTreeUtil.getRoot(ctx)?.createFile("*/*", "temp")?.let { temp ->

                    ctx.contentResolver.openOutputStream(temp.uri).use { output ->

                        output?.write(0xDEADBEEF.toInt())

                    }

                    shareFileChooser(ctx, temp.uri,
                        title = "Choose where to share the file",
                        subject = "Test Subject",
                        text = "Test text")

                }

            } else {

                Toast.makeText(ctx, "Please define document storage first.", Toast.LENGTH_SHORT).show()

            }
        }
    }

    //to be used in pheno lib app examples, requires defined storage
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun appTestShareFile(context: Context?) {

        context?.let { ctx ->

            if (BaseDocumentTreeUtil.isEnabled(ctx)) {

                BaseDocumentTreeUtil.getRoot(ctx)?.createFile("*/*", "temp")?.let { temp ->

                    ctx.contentResolver.openOutputStream(temp.uri).use { output ->

                        output?.write(0xCAFE)

                    }

                    shareFile(ctx, temp.uri, "Test Subject", "Test text")

                }

            } else {

                Toast.makeText(ctx, "Please define document storage first.", Toast.LENGTH_SHORT).show()

            }
        }
    }

    //to be used in test suites
    fun testShareFileChooser(context: Context?) {

        context?.let { ctx ->

            DocumentFile.fromFile(File(ctx.cacheDir, "temp")).let { temp ->

                ctx.contentResolver.openOutputStream(temp.uri).use { output ->

                    output?.write(0xDEADBEEF.toInt())

                }

                shareFileChooser(ctx, temp.uri,
                    title = "Choose where to share the file",
                    subject = "Test Subject",
                    text = "Test text")

            }
        }
    }

    //to be used in test suites
    fun testShareFile(context: Context?) {

        context?.let { ctx ->

            DocumentFile.fromFile(File(ctx.cacheDir, "temp")).let { temp ->

                temp.createFile("*/*", "temp.txt")?.let { t ->

                    ctx.contentResolver.openOutputStream(t.uri).use { output ->

                        output?.write(0xCAFE)

                    }

                    shareFile(ctx, temp.uri, "Test Subject", "Test text")
                }
            }
        }
    }
}