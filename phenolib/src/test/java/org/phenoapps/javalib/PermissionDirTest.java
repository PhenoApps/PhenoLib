package org.phenoapps.javalib;

import org.phenoapps.permissions.Dir;
import org.phenoapps.permissions.PermissionDirBase;

/**
 * Uses:
 * org.junit.Assert
 * org.junit.Test
 *
 * org.wheatgenetics.javalib.Dir.PermissionException
 * org.wheatgenetics.javalib.PermissionDir
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class PermissionDirTest extends java.lang.Object
{
    private static class PermissionDir extends PermissionDirBase
    {
        private PermissionDir()
        {
            super(
                /* path => */ new java.io.File(java.lang.System.getProperty("java.io.tmpdir")),
                /* blankHiddenFileName => */null);
        }
    }

    private final org.phenoapps.javalib.PermissionDirTest.PermissionDir tmpPermissionDir =
        new org.phenoapps.javalib.PermissionDirTest.PermissionDir();

    // region Public Method Tests
    @org.junit.Test(expected = Dir.PermissionException.class)
    public void getExistsWorks() throws Dir.PermissionException
    {
        org.junit.Assert.assertTrue(this.tmpPermissionDir.getExists()
            /* throws org.wheatgenetics.javalib.Dir.PermissionException */);
    }

    @org.junit.Test(expected = Dir.PermissionException.class)
    public void createIfMissingWorks()
    throws java.io.IOException, Dir.PermissionException
    {
        this.tmpPermissionDir.createIfMissing() /* throws java.io.IOException,
            org.wheatgenetics.javalib.Dir.PermissionException */;
    }

    @org.junit.Test(expected = Dir.PermissionException.class)
    public void makeFileWorks()
    throws java.io.IOException, Dir.PermissionException
    {
        this.tmpPermissionDir.makeFile("abc") /* throws java.io.IOException,
            org.wheatgenetics.javalib.Dir.PermissionException */;
    }

    @org.junit.Test(expected = Dir.PermissionException.class)
    public void createNewFileWorks()
    throws java.io.IOException, Dir.PermissionException
    {
        this.tmpPermissionDir.createNewFile("abc") /* throws java.io.IOException,
            org.wheatgenetics.javalib.Dir.PermissionException */;
    }

    @org.junit.Test(expected = Dir.PermissionException.class)
    public void createNewDirWorks() throws Dir.PermissionException
    { this.tmpPermissionDir.createNewDir("abc"); }        // throws org.wheatgenetics.java-
                                                                   //  lib.Dir.PermissionException

    @org.junit.Test(expected = Dir.PermissionException.class)
    public void listWorks() throws Dir.PermissionException
    { this.tmpPermissionDir.list() /* throws org.wheatgenetics.javalib.Dir.PermissionException */; }
    // endregion
}