package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.support.annotation.IdRes
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.widget.EditText
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.IntegerFragment
 */
@android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
abstract class PagedFragment
extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.IntegerFragment
{
    private android.widget.EditText pageSizeEditText, pageEditText;

    // region Package Methods
    // region findEditTextById() Package Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void findPageSizeEditTextById(
    @android.support.annotation.NonNull final android.view.View view,
    @android.support.annotation.IdRes   final int               id  )
    { if (null == this.pageSizeEditText) this.pageSizeEditText = view.findViewById(id); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void findPageEditTextById(
    @android.support.annotation.NonNull final android.view.View view,
    @android.support.annotation.IdRes   final int               id  )
    { if (null == this.pageEditText) this.pageEditText = view.findViewById(id); }
    // endregion

    // region getEditTextIntText() Package Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    java.lang.Integer getPageSizeEditTextIntText()
    {
        return org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment.getInteger(
            this.pageSizeEditText);
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    java.lang.Integer getPageEditTextIntText()
    {
        return org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment.getInteger(
            this.pageEditText);
    }
    // endregion
    // endregion
}