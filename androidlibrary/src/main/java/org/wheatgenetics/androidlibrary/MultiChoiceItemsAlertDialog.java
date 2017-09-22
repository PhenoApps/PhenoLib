package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.app.Activity
 * android.content.DialogInterface.OnMultiChoiceClickListener
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 */
public abstract class MultiChoiceItemsAlertDialog extends org.wheatgenetics.androidlibrary.AlertDialog
{
    public MultiChoiceItemsAlertDialog(final android.app.Activity activity) { super(activity); }

    @java.lang.Override
    public void configure() { this.setNegativeButton(); }

    public void show(final java.lang.String items[], final boolean checkedItems[],
    final android.content.DialogInterface.OnMultiChoiceClickListener listener)
    {
        if (null != items && null != checkedItems)
        {
            this.setMultiChoiceItems(items, checkedItems, listener);
            this.createShow();
        }
    }
}