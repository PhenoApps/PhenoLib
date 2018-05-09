package org.wheatgenetics.androidlibrarybuilder;

/**
 * Uses:
 * android.os.Bundle
 * android.support.v7.app.AppCompatActivity
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 */
public class MainActivity extends android.support.v7.app.AppCompatActivity
{
    @java.lang.Override protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibrarybuilder.R.layout.activity_main);
    }
}