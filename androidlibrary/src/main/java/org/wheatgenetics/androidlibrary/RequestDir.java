package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.app.Activity
 * android.Manifest.permission
 * android.support.v4.app.ActivityCompat
 *
 * org.wheatgenetics.javalib.Utils
 *
 * org.wheatgenetics.androidlibrary.PermissionDir
 */
public class RequestDir extends org.wheatgenetics.androidlibrary.PermissionDir
{
    private final int requestCode;

    // region Constructors
    public RequestDir(final android.app.Activity activity, final java.lang.String name,
    final java.lang.String blankHiddenFileName, final int requestCode)
    { super(activity, name, blankHiddenFileName); this.requestCode = requestCode; }

    @java.lang.SuppressWarnings({"unused"}) public RequestDir(final android.app.Activity activity,
    final org.wheatgenetics.javalib.Dir parent, final java.lang.String name, final int requestCode)
    { super(activity, parent, name); this.requestCode = requestCode; }
    // endregion

    @java.lang.Override protected boolean requestPermission()
    {
        if (!this.permissionGranted()) android.support.v4.app.ActivityCompat.requestPermissions(
            /* activity    => */ this.getActivity(),
            /* permissions => */ org.wheatgenetics.javalib.Utils.stringArray(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            /* requestCode => */ this.requestCode);

        return true;
    }
}