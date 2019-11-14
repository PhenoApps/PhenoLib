package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.annotation.SuppressLint
 * android.app.Activity
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.EditText
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.Utils
 */
@java.lang.SuppressWarnings({"unused"})
public class GetExportFileNameAlertDialog extends org.wheatgenetics.androidlibrary.AlertDialog
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Handler
    { public abstract void handleGetFileNameDone(java.lang.String fileName); }

    // region Fields
    private final org.wheatgenetics.androidlibrary.GetExportFileNameAlertDialog.Handler handler ;
    private       android.widget.EditText                                               editText;
    // endregion

    private void handleGetFileNameDone()
    {
        final java.lang.String fileName =
            org.wheatgenetics.androidlibrary.Utils.getText(this.editText);
        if (0 == fileName.length())
            this.showToast(
                org.wheatgenetics.androidlibrary.R.string.getExportFileNameAlertDialogToast);
        else
        {
            this.cancelAlertDialog();
            if (null != this.handler) this.handler.handleGetFileNameDone(fileName);
        }
    }

    public GetExportFileNameAlertDialog(final android.app.Activity              activity,
    final org.wheatgenetics.androidlibrary.GetExportFileNameAlertDialog.Handler handler )
    { super(activity); this.handler = handler; }

    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.getExportFileNameAlertDialogTitle);

        {
            @android.annotation.SuppressLint({"InflateParams"})
            final android.view.View view = this.layoutInflater().inflate(
                org.wheatgenetics.androidlibrary.R.layout.alert_dialog_get_export_file_name,
                null);

            if (null != view) if (null == this.editText) this.editText = view.findViewById(
                org.wheatgenetics.androidlibrary.R.id.editText);

            this.setView(view);
        }

        this.setOKPositiveButton(null).setCancelNegativeButton();
    }

    public void show(final java.lang.String initialFileName)
    {
        if (null != this.editText)
        {
            this.editText.setText(initialFileName); this.editText.selectAll();

            this.show();
            if (!this.positiveOnClickListenerHasBeenReplaced()) this.replacePositiveOnClickListener(
                new android.view.View.OnClickListener()
                {
                    @java.lang.Override public void onClick(final android.view.View view)
                    {
                        org.wheatgenetics.androidlibrary.GetExportFileNameAlertDialog
                            .this.handleGetFileNameDone();
                    }
                });
        }
    }
}