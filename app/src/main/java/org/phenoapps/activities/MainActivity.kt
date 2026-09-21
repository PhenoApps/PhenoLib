package org.phenoapps.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.phenoapps.androidlibrarybuilder.R

class MainActivity: AppCompatActivity() {

    companion object {
        private var TAG = this::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

}
