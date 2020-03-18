package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.app.Activity
 * android.content.DialogInterface.OnMultiChoiceClickListener
 *
 * androidx.annotation.NonNull
 * androidx.annotation.Size
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 */
@java.lang.SuppressWarnings({"unused"}) public abstract class MultiChoiceItemsAlertDialog
extends org.wheatgenetics.androidlibrary.AlertDialog
{
    public MultiChoiceItemsAlertDialog(@androidx.annotation.NonNull
    final android.app.Activity activity) { super(activity); }

    @java.lang.Override public void configure() { this.setCancelNegativeButton(); }

    public void show(@java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
    @androidx.annotation.Size(min = 1) final java.lang.String items[],

    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"}) final boolean checkedItems[],

    final android.content.DialogInterface.OnMultiChoiceClickListener listener)
    {
        if (null != items)
            { this.setMultiChoiceItems(items, checkedItems, listener); this.createShow(); }
    }
}