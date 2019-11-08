package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.widget.EditText
 *
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
 */
abstract class IntegerFragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
{
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    static java.lang.Integer getInteger(final android.widget.EditText editText)
    {
        final java.lang.String text =
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.IntegerFragment.getString(editText);
        return null == text ? null : java.lang.Integer.parseInt(text);
    }
}