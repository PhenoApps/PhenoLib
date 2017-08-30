package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.content.Context
 * android.net.Uri
 * android.os.Environment
 *
 * org.wheatgenetics.javalib.Dir
 *
 * org.wheatgenetics.androidlibrary.Utils
 */
public class Dir extends org.wheatgenetics.javalib.Dir
{
    private final android.content.Context context;

    // region Public Methods
    public Dir(final android.content.Context context, final java.lang.String name,
    final java.lang.String blankHiddenFileName)
    {
        super(android.os.Environment.getExternalStorageDirectory(), name, blankHiddenFileName);
        this.context = context;
    }

    @java.lang.Override
    public java.io.File createIfMissing()
    {
        final java.io.File blankHiddenFile = super.createIfMissing();
        org.wheatgenetics.androidlibrary.Utils.makeFileDiscoverable(this.context, blankHiddenFile);
        return blankHiddenFile;
    }

    public android.net.Uri parse(final java.lang.String fileName)
    { assert null != this.path; return android.net.Uri.parse(this.path.toString() + fileName); }
    // endregion
}