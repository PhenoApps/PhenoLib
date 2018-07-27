package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.app.Activity
 * android.content.pm.PackageManager
 * android.Manifest.permission
 * android.net.Uri
 * android.os.Environment
 * android.support.annotation.RestrictTo.Scope
 * android.support.annotation.RestrictTo.Scope.SUBCLASSES
 * android.support.v4.content.ContextCompat
 *
 * org.wheatgenetics.javalib.Dir
 * org.wheatgenetics.javalib.PermissionDir
 *
 * org.wheatgenetics.androidlibrary.Utils
 */
public class PermissionDir extends org.wheatgenetics.javalib.PermissionDir
{
    private final android.app.Activity activity;

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected android.app.Activity getActivity() { return this.activity; }

    // region Constructors
    public PermissionDir(final android.app.Activity activity, final java.lang.String name,
    final java.lang.String blankHiddenFileName)
    {
        super(
            /* parent              => */ android.os.Environment.getExternalStorageDirectory(),
            /* child               => */ name                                                ,
            /* blankHiddenFileName => */ blankHiddenFileName                                 );
        this.activity = activity;
    }

    public PermissionDir(final android.app.Activity activity,
    final org.wheatgenetics.javalib.Dir parent, final java.lang.String name)
    { super(/* parent => */ parent, /* child => */ name); this.activity = activity; }
    // endregion

    // region Overridden Methods
    @java.lang.Override protected boolean permissionGranted()
    {
        return android.support.v4.content.ContextCompat.checkSelfPermission(
                /* context    => */ this.getActivity()                                ,
                /* permission => */ android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == android.content.pm.PackageManager.PERMISSION_GRANTED;
    }

    @java.lang.Override public java.io.File createIfMissing() throws java.io.IOException
    {
        final java.io.File blankHiddenFile = super.createIfMissing();  // throws java.io.IOException
        org.wheatgenetics.androidlibrary.Utils.makeFileDiscoverable(
            this.getActivity(), blankHiddenFile);
        return blankHiddenFile;
    }
    // endregion

    // region Public Methods
    public android.net.Uri parse(final java.lang.String fileName)
    {
        final java.io.File path = this.getPath();
        assert null != path; return android.net.Uri.parse(path.toString() + "/" + fileName);
    }

    public android.net.Uri parse(final java.io.File file)
    { assert null != file; return this.parse(file.getName()); }
    // endregion
}