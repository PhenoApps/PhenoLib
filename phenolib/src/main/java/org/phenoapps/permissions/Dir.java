package org.phenoapps.permissions;

/**
 * Uses:
 * org.wheatgenetics.javalib.IndentationStack
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Dir extends java.lang.Object
{
    // region Types
    @java.lang.SuppressWarnings({"UnnecessaryEnumModifier"})
    private static enum PermissionCheck { PERMITTED, REQUESTED, DENIED }


    public static class PermissionException extends java.lang.Exception
    { private PermissionException(final java.lang.String message) { super(message); } }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public static class PermissionRequestedException
    extends Dir.PermissionException
    { private PermissionRequestedException() { super("Permission requested"); } }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public static class PermissionDeniedException
    extends Dir.PermissionException
    { private PermissionDeniedException() { super("Permission denied"); } }
    // endregion

    // region Fields
    private final java.io.File                               path               ;
    private final java.lang.String                           blankHiddenFileName;
    private final IndentationStack indentationStack =
        new IndentationStack();

    private boolean permissionRequired, existsHasBeenSet = false, exists;
    // endregion

    // region Private Methods
    private static void throwIfNotPermitted(
    final Dir.PermissionCheck permissionCheck)
    throws Dir.PermissionException
    {
        switch (permissionCheck)
        {
            case REQUESTED: throw new Dir.PermissionRequestedException();
            case DENIED   : throw new Dir.PermissionDeniedException   ();
        }
    }

    private static void createNewDir(final java.io.File parent, final java.lang.String child)
    {
        if (null != parent)
        {
            final java.io.File dir = null == child ? parent : new java.io.File(parent, child);
            if (!dir.exists())
                // noinspection ResultOfMethodCallIgnored
                dir.mkdirs();
        }
    }

    private java.lang.String status()
    {
        return java.lang.String.format(
            "permissionRequired: %b, existsHasBeenSet: %b, exists: %b",
            this.permissionRequired, this.existsHasBeenSet, this.exists);
    }

    private Dir.PermissionCheck checkPermission()
    {
        this.indentationStack.push("checkPermission()");
        try
        {
            final java.lang.StringBuilder statusStringBuilder =
                new java.lang.StringBuilder(this.status());
            this.log("entered");
            try
            {
                if (this.permissionRequired)
                {
                    final boolean permissionGranted = this.permissionGranted();
                    statusStringBuilder.append(java.lang.String.format(
                        ", permissionGranted(): %b", permissionGranted));
                    if (permissionGranted)
                        return Dir.PermissionCheck.PERMITTED;
                    else
                    {
                        final boolean requestPermission = requestPermission();
                        statusStringBuilder.append(java.lang.String.format(
                            ", requestPermission(): %b", requestPermission));
                        return requestPermission ?
                            Dir.PermissionCheck.REQUESTED :
                            Dir.PermissionCheck.DENIED    ;
                    }
                }
                else return Dir.PermissionCheck.PERMITTED;
            }
            finally { this.log("leaving: " + statusStringBuilder.toString()); }
        }
        finally { this.indentationStack.pop(); }
    }

    private Dir.PermissionCheck setExists()
    {
        this.indentationStack.push("setExists()");
        try
        {
            this.log("entered");
            try
            {
                final Dir.PermissionCheck result = this.checkPermission();
                if (Dir.PermissionCheck.PERMITTED == result)
                {
                    final java.io.File path = this.getPath();
                    assert null != path; this.exists = path.exists();
                    this.existsHasBeenSet = true;
                }
                return result;
            }
            finally { this.log("leaving"); }
        }
        finally { this.indentationStack.pop(); }
    }

    private void setPermissionRequired(final boolean permissionRequired)
    { this.permissionRequired = permissionRequired; }
    // endregion

    void setPermissionRequiredToTrue() { this.setPermissionRequired(true); }

    // region Protected Methods
    protected java.io.File getPath() { return this.path; }

    /**
     * The purpose of this method is to log a message.  In this class the method doesn't do its job
     * (because it can't -- this must be done at the Android (not the Java) layer).  When this
     * method is overridden the subclass that makes this method do its job should send msg to the
     * message log.
     */
    @java.lang.SuppressWarnings({"WeakerAccess", "EmptyMethod"})
    protected void log(@java.lang.SuppressWarnings({"unused"}) final java.lang.String msg) {}

    @java.lang.SuppressWarnings({"unused"}) protected java.lang.String label()
    { return this.indentationStack.label(); }

    /**
     * The purpose of this method is to find out if permission to write to external public storage
     * has been granted.  In this class the method doesn't do its job (because it can't -- this must
     * be done at the Android (not the Java) layer).  Since it doesn't do its job it returns the
     * value false.  When this method is overridden the subclass that makes this method do its job
     * should determine if this permission has been granted and return true if it has been and false
     * if it has not been.
     */
    @java.lang.SuppressWarnings({"WeakerAccess", "SameReturnValue"})
    protected boolean permissionGranted() { return false; }

    /**
     * The purpose of this method is to request permission.  In this class the method doesn't do its
     * job (because it can't -- this must be done at the Android (not the Java) layer).  Since it
     * doesn't do its job it returns the value false.  When this method is overridden the subclass
     * that makes this method do its job should request permission then return the value true.
     */
    @java.lang.SuppressWarnings({"WeakerAccess", "SameReturnValue"})
    protected boolean requestPermission() { return false; }
    // endregion

    // region Constructors
    public Dir(final java.io.File path, final java.lang.String blankHiddenFileName)
    {
        super();

        if (null == path)
            throw new java.lang.IllegalArgumentException("path must not be null");
        else
        {
            this.path                = path;
            this.blankHiddenFileName =
                null == blankHiddenFileName ? null : blankHiddenFileName.trim();

            this.setPermissionRequired(false);
        }
    }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public Dir(final java.io.File parent,
    final java.lang.String child, final java.lang.String blankHiddenFileName)
    { this(new java.io.File(parent, child), blankHiddenFileName); }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public Dir(
            final Dir parent, final java.lang.String child)
    { this(parent.getPath(), child, parent.blankHiddenFileName); }
    // endregion

    // region Public Methods
    @java.lang.SuppressWarnings({"WeakerAccess"}) public java.lang.String getPathAsString()
    { final java.io.File path = this.getPath(); return null == path ? null : path.getPath(); }

    @java.lang.SuppressWarnings({"WeakerAccess"})
    public boolean getExists() throws Dir.PermissionException
    {
        this.indentationStack.push("getExists()");
        try
        {
            this.log("entered: " + this.status());
            try
            {
                if (!this.existsHasBeenSet)
                    Dir.throwIfNotPermitted(  // throws org.wheatgenetics-
                        this.setExists());                              //  .javalib.Dir.Permission-
                return this.exists;                                     //  Exception
            }
            finally { this.log("leaving: " + this.status()); }
        }
        finally { this.indentationStack.pop(); }
    }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public java.io.File createIfMissing()
    throws java.io.IOException, Dir.PermissionException
    {
        this.indentationStack.push("createIfMissing()");
        try
        {
            this.log("entered");
            try
            {
                final java.io.File path = this.getPath();
                if (!this.getExists())   // throws org.wheatgenetics.javalib.Dir.PermissionException
                {
                    Dir.throwIfNotPermitted(                     // throws
                        this.checkPermission());
                    Dir.createNewDir       (path,null);
                    Dir.throwIfNotPermitted(this.setExists());   // throws
                }

                if (!this.getExists())   // throws org.wheatgenetics.javalib.Dir.PermissionException
                    throw new java.io.IOException(this.getPathAsString() + " does not exist");
                else
                    if (null == this.blankHiddenFileName)
                        return null;
                    else
                        if (this.blankHiddenFileName.length() <= 0)
                            return null;
                        else
                        {
                            final java.io.File blankHiddenFile =
                                new java.io.File(path, this.blankHiddenFileName);

                            Dir.throwIfNotPermitted(             // throws
                                this.checkPermission());

                            if (!blankHiddenFile.exists())
                                // noinspection ResultOfMethodCallIgnored
                                blankHiddenFile.createNewFile();       // throws java.io.IOException

                            return blankHiddenFile;
                        }
            }
            finally { this.log("leaving"); }
        }
        finally { this.indentationStack.pop(); }
    }

    @java.lang.SuppressWarnings({"WeakerAccess"})
    public java.io.File makeFile(final java.lang.String fileName)
    throws java.io.IOException, Dir.PermissionException
    {
        if (this.getExists())            // throws org.wheatgenetics.javalib.Dir.PermissionException
            return new java.io.File(/* parent => */ this.getPath(), /* child => */ fileName);
        else
            throw new java.io.IOException(this.getPathAsString() + " does not exist");
    }

    @java.lang.SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
    public java.io.File createNewFile(final java.lang.String fileName)
    throws java.io.IOException, Dir.PermissionException
    {
        final java.io.File file = this.makeFile(fileName);     // throws java.io.IOException, org.-
                                                               //  wheatgenetics.javalib.Dir.Permis-
                                                               //  sionException
        Dir.throwIfNotPermitted(     // throws org.wheatgenetics.java-
            this.checkPermission());                           //  lib.Dir.PermissionException

        assert null != file;
        // noinspection ResultOfMethodCallIgnored
        file.createNewFile();                                          // throws java.io.IOException

        return file;
    }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public void createNewDir(
    final java.lang.String dirName) throws Dir.PermissionException
    {
        Dir.throwIfNotPermitted(         // throws org.wheatgenetics.java-
            this.checkPermission());                               //  lib.Dir.PermissionException
        Dir.createNewDir(this.getPath(), dirName);
    }

    public java.lang.String[] list() throws Dir.PermissionException
    {
        this.indentationStack.push("list()");
        try
        {
            this.log("entered");
            try
            {
                final java.io.File path = this.getPath();
                if (null == path)
                    return null;
                else
                    if (this.getExists())                          // throws org.wheatgenetics.java-
                    {                                              //  lib.Dir.PermissionException
                        Dir.throwIfNotPermitted(  // throws org.wheatgene-
                            this.checkPermission());                        //  tics.javalib.Dir-
                        return path.isDirectory() ? path.list() : null;     //  .PermissionException
                    }
                    else return null;
            }
            finally { this.log("leaving"); }
        }
        finally { this.indentationStack.pop(); }
    }

    public java.lang.String[] list(final java.lang.String regex)
    throws Dir.PermissionException
    {
        // noinspection CStyleArrayDeclaration
        final java.lang.String unfilteredList[] = this.list();     // throws org.wheatgenetics.java-
        if (null == unfilteredList)                                //   lib.Dir.PermissionException
            return null;
        else
            if (unfilteredList.length < 1)
                return unfilteredList;
            else
            {
                // noinspection Convert2Diamond
                final java.util.ArrayList<java.lang.String> arrayList =
                    new java.util.ArrayList<java.lang.String>();
                {
                    final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
                    for (final java.lang.String l: unfilteredList)
                        if (pattern.matcher(l).matches()) arrayList.add(l);
                }

                final int arrayListSize = arrayList.size();
                if (arrayListSize <= 0)
                    return null;
                else
                {
                    // noinspection CStyleArrayDeclaration
                    final java.lang.String filteredList[] = new java.lang.String[arrayListSize];
                    return arrayList.toArray(filteredList);
                }
            }
    }
    // endregion
}