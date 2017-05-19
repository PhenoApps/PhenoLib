package org.wheatgenetics.androidlibrarybuilder;

/**
 * Uses:
 * android.content.res.Resources
 * android.os.Bundle
 * android.support.v7.app.AppCompatActivity
 * android.view.View
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 * org.wheatgenetics.changelog.ChangeLogAlertDialog
 */

public class MainActivity extends android.support.v7.app.AppCompatActivity
{
    private org.wheatgenetics.changelog.ChangeLogAlertDialog changeLogAlertDialog = null;

    @java.lang.Override
    protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibrarybuilder.R.layout.activity_main);
    }

    public void onClick(final android.view.View view) throws java.io.IOException
    {
        if (this.changeLogAlertDialog == null)
        {
            java.io.InputStreamReader inputStreamReader;
            {
                final android.content.res.Resources resources = this.getResources();

                assert resources != null;
                inputStreamReader = new java.io.InputStreamReader(resources.openRawResource(
                    org.wheatgenetics.androidlibrarybuilder.R.raw.changelog));
            }
            this.changeLogAlertDialog = new org.wheatgenetics.changelog.ChangeLogAlertDialog(
                /* context            => */ this             ,
                /* inputStreamReader  => */ inputStreamReader);
        }
        this.changeLogAlertDialog.show();
    }
}