package org.wheatgenetics.sharedpreferences;

/**
 * Uses:
 * android.content.SharedPreferences
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.sharedpreferences.BaseSharedPreferences
 */

public class UpdateVersionSharedPreferences
extends org.wheatgenetics.sharedpreferences.BaseSharedPreferences
{
    private static final java.lang.String UPDATE_VERSION = "UpdateVersion";

    private int getUpdateVersion()
    {
        return this.getInt(
            org.wheatgenetics.sharedpreferences.UpdateVersionSharedPreferences.UPDATE_VERSION);
    }

    // region Public Methods
    public UpdateVersionSharedPreferences(@android.support.annotation.NonNull
    final android.content.SharedPreferences sharedPreferences) { super(sharedPreferences); }

    public boolean updateVersionIsSet(final int newUpdateVersion)
    { return this.getUpdateVersion() >= newUpdateVersion; }

    public void setUpdateVersion(final int newUpdateVersion)
    {
        if (this.getUpdateVersion() != newUpdateVersion) this.setInt(
            org.wheatgenetics.sharedpreferences.UpdateVersionSharedPreferences.UPDATE_VERSION,
            newUpdateVersion                                                                 );
    }
    // endregion
}
