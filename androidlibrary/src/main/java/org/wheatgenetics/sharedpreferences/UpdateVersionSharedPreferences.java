package org.wheatgenetics.sharedpreferences;

/**
 * Uses:
 * android.content.SharedPreferences
 * org.wheatgenetics.sharedpreferences.SharedPreferences
 */

public class UpdateVersionSharedPreferences
extends org.wheatgenetics.sharedpreferences.SharedPreferences
{
    private static final java.lang.String UPDATE_VERSION = "UpdateVersion";

    private int getUpdateVersion()
    {
        return this.getInt(
            org.wheatgenetics.sharedpreferences.UpdateVersionSharedPreferences.UPDATE_VERSION);
    }

    public UpdateVersionSharedPreferences(final android.content.SharedPreferences sharedPreferences)
    { super(sharedPreferences); }

    public boolean updateVersionIsSet(final int newUpdateVersion)
    { return this.getUpdateVersion() >= newUpdateVersion; }

    public void setUpdateVersion(final int newUpdateVersion)
    {
        if (this.getUpdateVersion() != newUpdateVersion) this.setInt(
            org.wheatgenetics.sharedpreferences.UpdateVersionSharedPreferences.UPDATE_VERSION,
            newUpdateVersion                                                                 );
    }
}