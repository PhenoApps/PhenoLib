package org.phenoapps.permissions;

/**
 * Uses:
 * org.wheatgenetics.javalib.Dir
 */
public abstract class PermissionDirBase extends Dir
{
    @java.lang.SuppressWarnings({"unused"})
    public PermissionDirBase(final java.io.File path, final java.lang.String blankHiddenFileName)
    { super(path, blankHiddenFileName); this.setPermissionRequiredToTrue(); }

    @java.lang.SuppressWarnings({"unused"}) public PermissionDirBase(final java.io.File parent,
                                                                     final java.lang.String child, final java.lang.String blankHiddenFileName)
    { super(parent, child, blankHiddenFileName); this.setPermissionRequiredToTrue(); }

    @java.lang.SuppressWarnings({"unused"})
    public PermissionDirBase(final Dir parent, final java.lang.String child)
    { super(parent, child); this.setPermissionRequiredToTrue(); }
}