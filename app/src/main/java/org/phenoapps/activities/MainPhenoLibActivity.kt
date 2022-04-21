package org.phenoapps.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainPhenoLibActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(org.phenoapps.androidlibrary.R.layout.activity_define_storage)
    }
}