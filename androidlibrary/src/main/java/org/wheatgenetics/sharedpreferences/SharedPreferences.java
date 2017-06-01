package org.wheatgenetics.sharedpreferences;

/**
 * Uses:
 * android.content.SharedPreferences
 * android.content.SharedPreferences.Editor
 */

abstract class SharedPreferences extends java.lang.Object
{
    // region Private Field
    private final android.content.SharedPreferences sharedPreferences;
    // endregion

    // region Package Methods
    // region Constructor Package Method
    SharedPreferences(final android.content.SharedPreferences sharedPreferences)
    {
        super();

        assert null != sharedPreferences;
        this.sharedPreferences = sharedPreferences;
    }
    // endregion

    // region String Package Methods
    void validateStringKey(final java.lang.String key) {};

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