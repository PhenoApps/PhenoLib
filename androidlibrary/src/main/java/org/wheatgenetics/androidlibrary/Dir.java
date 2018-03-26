package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.content.Context
 * android.net.Uri
 * android.os.Environment
 * android.support.annotation.RestrictTo.Scope
 * android.support.annotation.RestrictTo.Scope.SUBCLASSES
 *
 * org.wheatgenetics.javalib.Dir
 *
 * org.wheatgenetics.androidlibrary.Utils
 */
public class Dir extends org.wheatgenetics.javalib.Dir
{
    private final android.content.Context context;

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected android.content.Context getContext() { return this.context; }

    // region Constructors
    public Dir(final android.content.Context context, final java.lang.String name,
    final java.lang.String blankHiddenFileName)
    {
        super(
            /* parent              => */ android.os.Environment.getExternalStorageDirectory(),
            /* child               => */ name                                                ,
            /* blankHiddenFileName => */ blankHiddenFileName                                 );
        this.context = context;
    }

    public Dir(final android.content.Context context, final org.wheatgenetics.javalib.Dir parent,
    final java.lang.String name)
    { super(/* parent => */ parent, /* child => */ name); this.context = context; }
    // endregion

    @java.lang.Override public java.io.File createIfMissing() throws java.io.IOException
    {
        final java.io.File blankHiddenFile = super.createIfMissing();  // throws java.io.IOException
        org.wheatgenetics.androidlibrary.Utils.makeFileDiscoverable(this.context, blankHiddenFile);
        return blankHiddenFile;
    }

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