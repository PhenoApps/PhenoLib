package org.wheatgenetics.androidlibrary;

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
        new org.wheatgenetics.androidlibrary.PermissionDir(
            null,"name","blankHiddenFileName");
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void secondConstructorFailsDueToNullActivity()
    {
        final java.lang.String tmpdir = java.lang.System.getProperty("java.io.tmpdir");
        new org.wheatgenetics.androidlibrary.PermissionDir(
            /* activity => */null,
            /* parent   => */ new org.wheatgenetics.javalib.Dir(
                /* path                => */ null == tmpdir ? null : new java.io.File(tmpdir),
                /* blankHiddenFileName => */"blankHiddenFileName"),
            /* name => */"name");
    }
}