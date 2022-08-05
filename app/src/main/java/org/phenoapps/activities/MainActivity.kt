package org.phenoapps.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import org.phenoapps.androidlibrarybuilder.R
import org.phenoapps.fragments.examples.PhenoLibIndexFragment
import org.phenoapps.usb.camera.UsbCameraHelper
import org.phenoapps.usb.camera.UsbCameraInterface

class MainActivity: AppCompatActivity(), UsbCameraInterface {

    companion object {
        private var TAG = this::class.simpleName
    }

    private var helper: UsbCameraHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        helper = UsbCameraHelper(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        helper?.destroy()
    }

    override fun getCameraHelper(): UsbCameraHelper? = helper

}