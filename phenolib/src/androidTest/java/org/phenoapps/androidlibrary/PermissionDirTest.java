package org.phenoapps.androidlibrary;

import org.phenoapps.permissions.Dir;
import org.phenoapps.permissions.PermissionDir;

/**
 * Uses:
 * org.junit.Test
 *
 * org.wheatgenetics.javalib.Dir
 *
 * org.wheatgenetics.androidlibrary.PermissionDir
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class PermissionDirTest extends java.lang.Object
{
    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void firstConstructorFailsDueToNullActivity()
    {
        new PermissionDir(
            null,"name","blankHiddenFileName");
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void secondConstructorFailsDueToNullActivity()
    {
        final java.lang.String tmpdir = java.lang.System.getProperty("java.io.tmpdir");
        new PermissionDir(
            /* activity => */null,
            /* parent   => */ new Dir(
                /* path                => */ null == tmpdir ? null : new java.io.File(tmpdir),
                /* blankHiddenFileName => */"blankHiddenFileName"),
            /* name => */"name");
    }
}