package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.app.Activity
 * android.content.DialogInterface.OnClickListener
 * android.support.annotation.Size
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 */
public abstract class ItemsAlertDialog extends org.wheatgenetics.androidlibrary.AlertDialog
{
    private android.content.DialogInterface.OnClickListener onClickListener;

    public ItemsAlertDialog(final android.app.Activity activity) { super(activity); }

    // region Public Methods
    public void setOnClickListener(
    final android.content.DialogInterface.OnClickListener onClickListener)
    { this.onClickListener = onClickListener; }

    public void show(@android.support.annotation.Size(min = 1) final java.lang.String items[])
    { if (null != items) { this.setItems(items, this.onClickListener); this.createShow(); } }

    public void show(@android.support.annotation.Size(min = 1) final int items[])
    { if (null != items) { this.setItems(items, this.onClickListener); this.createShow(); } }
    // endregion
}