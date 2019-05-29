package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.app.Activity
 * android.content.pm.PackageManager
 * android.Manifest.permission
 * android.net.Uri
 * android.os.Environment
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.support.v4.content.ContextCompat
 * android.util.Log
 *
 * org.wheatgenetics.javalib.Dir
 * org.wheatgenetics.javalib.Dir.PermissionException
 * org.wheatgenetics.javalib.PermissionDir
 *
 * org.wheatgenetics.androidlibrary.Utils
 */
public class PermissionDir extends org.wheatgenetics.javalib.PermissionDir
{
    private final android.app.Activity activity;

    private static android.app.Activity nonNullActivity(final android.app.Activity activity)
    {
        if (null == activity)
            throw new java.lang.IllegalArgumentException("activity must not be null");
        else
            return activity;
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"})
    protected android.app.Activity getActivity() { return this.activity; }

    // region Constructors
    public PermissionDir(final android.app.Activity activity, final java.lang.String name,
    final java.lang.String blankHiddenFileName)
    {
        super(
            /* parent              => */ android.os.Environment.getExternalStorageDirectory(),
            /* child               => */ name                                                ,
            /* blankHiddenFileName => */ blankHiddenFileName                                 );
        this.activity = org.wheatgenetics.androidlibrary.PermissionDir.nonNullActivity(activity);
    }

    @java.lang.SuppressWarnings({"WeakerAccess"})
    public PermissionDir(final android.app.Activity activity,
    final org.wheatgenetics.javalib.Dir parent, final java.lang.String name)
    {
        super(/* parent => */ parent, /* child => */ name);
        this.activity = org.wheatgenetics.androidlibrary.PermissionDir.nonNullActivity(activity);
    }
    // endregion

    // region Overridden Methods
    @java.lang.Override protected void log(final java.lang.String msg)
    { android.util.Log.d("Dir",this.label() + msg); }

    @java.lang.Override protected boolean permissionGranted()
    {
        return android.support.v4.content.ContextCompat.checkSelfPermission(
                /* context    => */ this.getActivity()                                ,
                /* permission => */ android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == android.content.pm.PackageManager.PERMISSION_GRANTED;
    }

    @java.lang.Override public java.io.File createIfMissing()
    throws java.io.IOException, org.wheatgenetics.javalib.Dir.PermissionException
    {
        final java.io.File blankHiddenFile = super.createIfMissing(); // throws java.io.IOException,
        org.wheatgenetics.androidlibrary.Utils.makeFileDiscoverable(  //  org.wheatgenetics.javalib-
            this.getActivity(), blankHiddenFile);                     //  .Dir.PermissionException
        return blankHiddenFile;
    }
    // endregion

    // region Public Methods
    @java.lang.SuppressWarnings({"WeakerAccess"})
    public android.net.Uri parse(final java.lang.String fileName)
    {
        final java.io.File path = this.getPath();
        return null == path ? null : android.net.Uri.parse(path.toString() + "/" + fileName);
    }

    @java.lang.SuppressWarnings({"unused"}) public android.net.Uri parse(final java.io.File file)
    { return null == file ? null : this.parse(file.getName()); }
    // endregion
}