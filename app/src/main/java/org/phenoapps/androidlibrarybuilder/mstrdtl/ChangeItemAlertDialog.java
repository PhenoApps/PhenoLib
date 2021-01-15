package org.phenoapps.androidlibrarybuilder.mstrdtl;

import org.phenoapps.mstrdtl.TestItem;

/**
 * Uses:
 * android.app.Activity
 * android.annotation.SuppressLint
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.EditText
 *
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.javalib.mstrdtl.TestItem
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 * org.wheatgenetics.androidlibrary.Utils
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 */
class ChangeItemAlertDialog extends org.phenoapps.androidlibrary.AlertDialog
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"})
    public interface Handler { public abstract void handleChangeItemDone(); }

    // region Fields
    private final org.phenoapps.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog.Handler
        handler;

    private android.widget.EditText                    itemEditText   ;
    private TestItem testItem = null;
    // endregion

    private void handleChangeItemDone()
    {
        if (null != this.testItem && null != this.itemEditText) this.testItem.setContent(
            org.phenoapps.androidlibrary.Utils.getText(this.itemEditText));
        this.cancelAlertDialog();
        if (null != this.handler) this.handler.handleChangeItemDone();
    }

    ChangeItemAlertDialog(@androidx.annotation.NonNull final android.app.Activity activity,
    final org.phenoapps.androidlibrarybuilder.mstrdtl.ChangeItemAlertDialog.Handler handler)
    { super(activity); this.handler = handler; }

    @java.lang.Override public void configure()
    {
        this.setTitle("Change Item");
        {
            @android.annotation.SuppressLint({"InflateParams"})
            final android.view.View view = this.layoutInflater().inflate(
                org.phenoapps.androidlibrarybuilder.R.layout.alert_dialog_change_item,
                null);
            if (null != view && null == this.itemEditText) this.itemEditText = view.findViewById(
                org.phenoapps.androidlibrarybuilder.R.id.itemEditText);
            this.setView(view);
        }
        this.setOKPositiveButton(null).setCancelNegativeButton();
    }

    void show(final TestItem testItem)
    {
        if (null != testItem && null != this.itemEditText)
        {
            this.testItem = testItem; this.itemEditText.setText(this.testItem.getContent());

            this.show();
            if (!this.positiveOnClickListenerHasBeenReplaced()) this.replacePositiveOnClickListener(
                new android.view.View.OnClickListener()
                {
                    @java.lang.Override public void onClick(final android.view.View v)
                    {
                        org.phenoapps.androidlibrarybuilder.mstrdtl
                            .ChangeItemAlertDialog.this.handleChangeItemDone();
                    }
                });
        }
    }
}