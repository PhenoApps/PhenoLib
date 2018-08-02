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
    public void firstConstructorFails()
    {
        new org.wheatgenetics.androidlibrary.PermissionDir(
            null,"name","blankHiddenFileName");
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void secondConstructorFails()
    {
        new org.wheatgenetics.androidlibrary.PermissionDir(
            /* activity => */null,
            /* parent   => */ new org.wheatgenetics.javalib.Dir(
                /* path => */ new java.io.File(java.lang.System.getProperty("java.io.tmpdir")),
                /* blankHiddenFileName => */"blankHiddenFileName"),
            /* name => */"name");
    }
}