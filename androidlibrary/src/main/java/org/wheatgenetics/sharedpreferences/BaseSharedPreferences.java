package org.wheatgenetics.sharedpreferences;

/**
 * Uses:
 * android.content.SharedPreferences
 * android.content.SharedPreferences.Editor
 *
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.Utils
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public abstract class BaseSharedPreferences extends java.lang.Object
{
    @androidx.annotation.NonNull private final android.content.SharedPreferences sharedPreferences;

    private void setBoolean(@androidx.annotation.NonNull final java.lang.String key,
    final boolean value)
    {
        if (this.getBoolean(key) != value)
        {
            final android.content.SharedPreferences.Editor editor = this.sharedPreferences.edit();
            if (null != editor) { editor.putBoolean(key, value); editor.apply(); }
        }
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"}) protected void validateStringKey(
    @androidx.annotation.NonNull final java.lang.String key)
    { throw new java.lang.AssertionError(key + " is not a valid key."); }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public BaseSharedPreferences(
    @androidx.annotation.NonNull final android.content.SharedPreferences sharedPreferences)
    { super(); this.sharedPreferences = sharedPreferences; }

    // region Public Methods
    // region String Public Methods
    @java.lang.SuppressWarnings({"WeakerAccess", "RedundantSuppression"})
    public java.lang.String getString(@androidx.annotation.NonNull final java.lang.String key)
    { return this.sharedPreferences.getString(key,""); }

    @java.lang.SuppressWarnings({"unused"}) public java.lang.String getString(
    @androidx.annotation.NonNull final java.lang.String key, final boolean validateKey)
    {
        if (validateKey) this.validateStringKey(key);
        return this.getString(key);
    }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public void setString(
    @androidx.annotation.NonNull final java.lang.String key        ,
    @androidx.annotation.NonNull final java.lang.String oldValue   ,
                                       java.lang.String newValue   ,
                                 final boolean          validateKey)
    {
        newValue = org.wheatgenetics.javalib.Utils.makeEmptyIfNull(newValue);
        if (!oldValue.equals(newValue))
        {
            if (validateKey) this.validateStringKey(key);

            final android.content.SharedPreferences.Editor editor = this.sharedPreferences.edit();
            if (null != editor) { editor.putString(key, newValue); editor.apply(); }
        }
    }

    @java.lang.SuppressWarnings({"unused"})
    public void setString(@androidx.annotation.NonNull final java.lang.String key     ,
                          @androidx.annotation.NonNull final java.lang.String oldValue,
                                                       final java.lang.String newValue)
    { this.setString(key, oldValue, newValue, /* validateKey => */false); }
    // endregion

    // region Integer Public Methods
    @java.lang.SuppressWarnings({"WeakerAccess"})
    public int getInt(@androidx.annotation.NonNull final java.lang.String key)
    { return this.sharedPreferences.getInt(key,-1); }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public void setInt(
    @androidx.annotation.NonNull final java.lang.String key, final int newInt)
    {
        if (this.getInt(key) != newInt)
        {
            final android.content.SharedPreferences.Editor editor = this.sharedPreferences.edit();
            if (null != editor) { editor.putInt(key, newInt); editor.apply(); }
        }
    }
    // endregion

    // region Long Public Methods
    @java.lang.SuppressWarnings({"WeakerAccess"})
    public long getLong(@androidx.annotation.NonNull final java.lang.String key)
    { return this.sharedPreferences.getLong(key,-1); }

    @java.lang.SuppressWarnings({"unused"}) public void setLong(
    @androidx.annotation.NonNull final java.lang.String key, final long newLong)
    {
        if (this.getLong(key) != newLong)
        {
            final android.content.SharedPreferences.Editor editor = this.sharedPreferences.edit();
            if (null != editor) { editor.putLong(key, newLong); editor.apply(); }
        }
    }
    // endregion

    // region Boolean Public Methods
    @java.lang.SuppressWarnings({"WeakerAccess"}) public java.lang.Boolean getBoolean(
    @androidx.annotation.NonNull final java.lang.String key)
    { return this.sharedPreferences.getBoolean(key,false); }

    @java.lang.SuppressWarnings({"unused"}) public void setBooleanToTrue(
    @androidx.annotation.NonNull final java.lang.String key) { this.setBoolean(key, true); }

    @java.lang.SuppressWarnings({"unused"}) public void setBooleanToFalse(
    @androidx.annotation.NonNull final java.lang.String key) { this.setBoolean(key, false); }
    // endregion
    // endregion
}