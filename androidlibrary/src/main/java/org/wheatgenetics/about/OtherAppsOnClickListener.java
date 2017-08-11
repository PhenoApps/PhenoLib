package org.wheatgenetics.about;

/**
 * Uses:
 * android.content.Context
 * android.view.View
 * android.view.View.OnClickListener
 *
 * org.wheatgenetics.about.OtherApps.Index
 * org.wheatgenetics.about.OtherAppsAlertDialog
 */
public class OtherAppsOnClickListener extends java.lang.Object
implements android.view.View.OnClickListener
{
    // region Fields
    private final android.content.Context                 context      ;
    private final org.wheatgenetics.about.OtherApps.Index suppressIndex;

    private org.wheatgenetics.about.OtherAppsAlertDialog otherAppsAlertDialog = null;
    // endregion

    public OtherAppsOnClickListener(final android.content.Context context,
    final org.wheatgenetics.about.OtherApps.Index suppressIndex)
    {
        super();

        this.context       = context      ;
        this.suppressIndex = suppressIndex;
    }

    @java.lang.Override
    public void onClick(final android.view.View v)
    {
        if (null == this.otherAppsAlertDialog) this.otherAppsAlertDialog =
            new org.wheatgenetics.about.OtherAppsAlertDialog(this.context, this.suppressIndex);
        this.otherAppsAlertDialog.show();
    }
}