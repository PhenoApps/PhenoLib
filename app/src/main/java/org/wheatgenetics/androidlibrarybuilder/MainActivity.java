package org.wheatgenetics.androidlibrarybuilder;

/**
 * Uses:
 * android.os.Bundle
 * android.support.v7.app.AppCompatActivity
 * android.view.Menu
 * android.view.MenuInflater
 * android.widget.TextView
 *
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrarybuilder.R
 * org.wheatgenetics.javalib.Utils
 */

public class MainActivity extends android.support.v7.app.AppCompatActivity
{
    @java.lang.Override
    protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibrarybuilder.R.layout.activity_main);

        final int                     number   = 2;
        final android.widget.TextView textView = (android.widget.TextView)
            this.findViewById(org.wheatgenetics.androidlibrarybuilder.R.id.textView);
        assert null != textView;
        textView.setText(java.lang.String.format("doubleOf(doubleOf(%d)) is %d", number,
            org.wheatgenetics.androidlibrary.Utils.doubleOf(
                org.wheatgenetics.javalib.Utils.doubleOf(number))));
    }

    @java.lang.Override
    public boolean onCreateOptionsMenu(final android.view.Menu menu)
    {
        new android.view.MenuInflater(this).inflate(
            org.wheatgenetics.androidlibrary.R.menu.camera_options_menu, menu);
        assert null != menu;
        menu.findItem(org.wheatgenetics.androidlibrary.R.id.cameraOptionsMenuItem).setVisible(true);
        return true;
    }

}