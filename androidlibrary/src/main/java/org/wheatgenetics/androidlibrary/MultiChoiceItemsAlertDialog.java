package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.app.Activity
 * android.content.DialogInterface.OnMultiChoiceClickListener
 * android.support.annotation.Size
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 */
public abstract class MultiChoiceItemsAlertDialog
extends org.wheatgenetics.androidlibrary.AlertDialog
{
    @java.lang.SuppressWarnings({"unused"}) public MultiChoiceItemsAlertDialog(
    final android.app.Activity activity) { super(activity); }

    @java.lang.SuppressWarnings({"unused"}) @java.lang.Override public void configure()
    { this.setCancelNegativeButton(); }

    @java.lang.SuppressWarnings({"unused"}) public void show(
    @android.support.annotation.Size(min = 1) final java.lang.String items       [],
                                              final boolean          checkedItems[],
    final android.content.DialogInterface.OnMultiChoiceClickListener listener      )
    {
        if (null != items)
            { this.setMultiChoiceItems(items, checkedItems, listener); this.createShow(); }
    }
}