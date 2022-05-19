package org.phenoapps.androidlibrary

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.phenoapps.utils.IntentUtil

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

            IntentUtil.testShareFile(mContext)

        } catch (e: Exception) {

            e.printStackTrace()

            assert(false)
        }
    }

    @Test
    fun testShareFileChooser() {

        try {

            IntentUtil.testShareFileChooser(mContext)

        } catch (e: Exception) {

            e.printStackTrace()

            assert(false)
        }
    }
}