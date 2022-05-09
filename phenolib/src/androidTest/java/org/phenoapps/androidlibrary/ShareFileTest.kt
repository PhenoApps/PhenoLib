package org.phenoapps.androidlibrary

import android.content.Context
import androidx.core.net.toUri
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.phenoapps.utils.BaseDocumentTreeUtil
import org.phenoapps.utils.IntentUtil
import java.io.File
import java.io.FileWriter

@RunWith(AndroidJUnit4::class)
class ShareFileTest {

    private var mContext: Context? = null

    @Before
    fun before() {
        mContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun testShareFile() {

        try {

            shareFile()

        } catch (e: Exception) {

            e.printStackTrace()

            assert(false)
        }
    }

    private fun shareFile() {

        mContext?.let { ctx ->

            BaseDocumentTreeUtil.createDir(ctx, "test")?.let { dir ->

                dir.createFile("*/*", "temp.txt")?.let { temp ->

                    ctx.contentResolver.openOutputStream(temp.uri).use { output ->

                        output?.write(1)

                    }

                    IntentUtil.shareFile(ctx, temp.uri, "Test Subject", "Test text")

                    temp.delete()
                }
            }
        }
    }
}