package org.wheatgenetics.sharedpreferences;

/**
 * Uses:
 * android.content.SharedPreferences
 * android.content.SharedPreferences.Editor
 */

public abstract class BaseSharedPreferences extends java.lang.Object
{
    private final android.content.SharedPreferences sharedPreferences;

    public BaseSharedPreferences(final android.content.SharedPreferences sharedPreferences)
    {
        super();

        assert null != sharedPreferences;
        this.sharedPreferences = sharedPreferences;
    }

    // region Package Methods
    // region String Package Methods
    void validateStringKey(final java.lang.String key) {};                // Meant to be overridden.

    java.lang.String getString(final java.lang.String key, final boolean validateKey)
    {
        if (validateKey) this.validateStringKey(key);

        assert null != this.sharedPreferences;
        return this.sharedPreferences.getString(key, "");
    }

    java.lang.String getString(final java.lang.String key) { return this.getString(key, false); }

    void setString(final java.lang.String key, final java.lang.String oldValue,
    java.lang.String newValue, final boolean validateKey)
    {
        assert null != oldValue;
        if (null == newValue) newValue = "";
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

    void setString(final java.lang.String key, final java.lang.String oldValue,
    final java.lang.String newValue) { this.setString(key, oldValue, newValue, false); }
    // endregion

    // region Integer Package Methods
    int getInt(final java.lang.String key)
    {
        assert null != this.sharedPreferences;
        return this.sharedPreferences.getInt(key, -1);
    }

    void setInt(final java.lang.String key, final int newInt)
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

    // region Boolean Package Methods
    java.lang.Boolean getBoolean(final java.lang.String key)
    {
        assert null != this.sharedPreferences;
        return this.sharedPreferences.getBoolean(key, false);
    }

    void setBooleanToTrue(final java.lang.String key)
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