package org.wheatgenetics.brapi1_3;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.IdRes
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.widget.EditText
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 */
public abstract class PagedAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    private android.widget.EditText pageEditText, pageSizeEditText;

    // region Protected Methods
    // region setEditTextText() Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected void setPageEditTextText(final java.lang.Integer page)
    { org.wheatgenetics.brapi1_3.PagedAlertDialog.setEditTextText(this.pageEditText, page); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected void setPageSizeEditTextText(final java.lang.Integer pageSize)
    {
        org.wheatgenetics.brapi1_3.PagedAlertDialog.setEditTextText(
            this.pageSizeEditText, pageSize);
    }
    // endregion

    // region getEditTextText() Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected java.lang.Integer getPageEditTextIntText()
    { return org.wheatgenetics.brapi1_3.PagedAlertDialog.getEditTextIntText(this.pageEditText); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected java.lang.Integer getPageSizeEditTextIntText()
    {
        return org.wheatgenetics.brapi1_3.PagedAlertDialog.getEditTextIntText(
            this.pageSizeEditText);
    }
    // endregion

    // region findEditTextById() Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected void findPageEditTextById(
    @android.support.annotation.NonNull final android.view.View view,
    @android.support.annotation.IdRes   final int               id  )
    { if (null == this.pageEditText) this.pageEditText = view.findViewById(id); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected void findPageSizeEditTextById(
    @android.support.annotation.NonNull final android.view.View view,
    @android.support.annotation.IdRes   final int               id  )
    { if (null == this.pageSizeEditText) this.pageSizeEditText = view.findViewById(id); }
    // endregion
    // endregion

    public PagedAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.PagedAlertDialog.Handler handler) { super(activity, handler); }
}