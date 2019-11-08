package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.view.View
 * android.widget.EditText
 *
 * androidx.annotation.IdRes
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.IntegerFragment
 */
abstract class PagedFragment
extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.IntegerFragment
{
    private android.widget.EditText pageSizeEditText, pageEditText;

    // region Package Methods
    // region findEditTextById() Package Methods
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    void findPageSizeEditTextById(
    @androidx.annotation.NonNull final android.view.View view,
    @androidx.annotation.IdRes   final int               id  )
    { if (null == this.pageSizeEditText) this.pageSizeEditText = view.findViewById(id); }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    void findPageEditTextById(
    @androidx.annotation.NonNull final android.view.View view,
    @androidx.annotation.IdRes   final int               id  )
    { if (null == this.pageEditText) this.pageEditText = view.findViewById(id); }
    // endregion

    // region getEditTextIntText() Package Methods
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    java.lang.Integer getPageSizeEditTextIntText()
    {
        return org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment.getInteger(
            this.pageSizeEditText);
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    java.lang.Integer getPageEditTextIntText()
    {
        return org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment.getInteger(
            this.pageEditText);
    }
    // endregion
    // endregion
}