package org.wheatgenetics.sharedpreferences;

/**
 * Uses:
 * android.content.SharedPreferences
 * android.content.SharedPreferences.Editor
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.javalib.Utils
 */

public abstract class BaseSharedPreferences extends java.lang.Object
{
    private final android.content.SharedPreferences sharedPreferences;

    public BaseSharedPreferences(@android.support.annotation.NonNull
    final android.content.SharedPreferences sharedPreferences)
    {
        super();

        assert null != sharedPreferences;
        this.sharedPreferences = sharedPreferences;
    }

    // region Package Methods
    // region String Package Methods
    /**
     * Meant to be overridden.
     */
    void validateStringKey(@android.support.annotation.NonNull final java.lang.String key) {};

    java.lang.String getString(@android.support.annotation.NonNull final java.lang.String key,
    final boolean validateKey)
    {
        if (validateKey) this.validateStringKey(key);

        assert null != this.sharedPreferences;
        return this.sharedPreferences.getString(key, "");
    }

    java.lang.String getString(@android.support.annotation.NonNull final java.lang.String key)
    { return this.getString(key, /* validateKey => */ false); }

    void setString(@android.support.annotation.NonNull final java.lang.String key,
    @android.support.annotation.NonNull final java.lang.String oldValue,
    java.lang.String newValue, final boolean validateKey)
    {
        assert null != oldValue;
        newValue = org.wheatgenetics.javalib.Utils.makeEmptyIfNull(newValue);
        if (!oldValue.equals(newValue))
        {
            if (validateKey) this.validateStringKey(key);

            assert null != this.sharedPreferences;
            final android.content.SharedPreferences.Editor editor = this.sharedPreferences.edit();

            assert null != editor;
            editor.putString(key, newValue);
            editor.apply();
        }
    }

    void setString(@android.support.annotation.NonNull final java.lang.String key,
    @android.support.annotation.NonNull final java.lang.String oldValue,
    final java.lang.String newValue)
    { this.setString(key, oldValue, newValue, /* validateKey => */ false); }
    // endregion

    // region Integer Package Methods
    int getInt(@android.support.annotation.NonNull final java.lang.String key)
    {
        assert null != this.sharedPreferences;
        return this.sharedPreferences.getInt(key, -1);
    }

    void setInt(@android.support.annotation.NonNull final java.lang.String key, final int newInt)
    {
        if (this.getInt(key) != newInt)
        {
            assert null != this.sharedPreferences;
            final android.content.SharedPreferences.Editor editor = this.sharedPreferences.edit();

            assert null != editor;
            editor.putInt(key, newInt);
            editor.apply();
        }
    }
    // endregion

    // region Long Package Methods
    long getLong(@android.support.annotation.NonNull final java.lang.String key)
    {
        assert null != this.sharedPreferences;
        return this.sharedPreferences.getLong(key, -1);
    }

    void setLong(@android.support.annotation.NonNull final java.lang.String key, final long newLong)
    {
        if (this.getLong(key) != newLong)
        {
            assert null != this.sharedPreferences;
            final android.content.SharedPreferences.Editor editor = this.sharedPreferences.edit();

            assert null != editor;
            editor.putLong(key, newLong);
            editor.apply();
        }
    }
    // endregion

    // region Boolean Package Methods
    java.lang.Boolean getBoolean(@android.support.annotation.NonNull final java.lang.String key)
    {
        assert null != this.sharedPreferences;
        return this.sharedPreferences.getBoolean(key, false);
    }

    void setBooleanToTrue(@android.support.annotation.NonNull final java.lang.String key)
    {
        if (!this.getBoolean(key))
        {
            assert null != this.sharedPreferences;
            final android.content.SharedPreferences.Editor editor = this.sharedPreferences.edit();

            assert null != editor;
            editor.putBoolean(key, true);
            editor.apply();
        }
    }
    // endregion
    // endregion
}