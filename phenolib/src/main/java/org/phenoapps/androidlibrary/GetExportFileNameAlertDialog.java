package org.phenoapps.androidlibrary;

/**
 * Uses:
 * android.annotation.SuppressLint
 * android.app.Activity
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.EditText
 *
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.Utils
 */
@java.lang.SuppressWarnings({"unused"})
public class GetExportFileNameAlertDialog extends org.phenoapps.androidlibrary.AlertDialog
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Handler
    { public abstract void handleGetFileNameDone(java.lang.String fileName); }

    // region Fields
    private final org.phenoapps.androidlibrary.GetExportFileNameAlertDialog.Handler handler ;
    private       android.widget.EditText                                               editText;
    // endregion

    private void handleGetFileNameDone()
    {
        final java.lang.String fileName =
            org.phenoapps.androidlibrary.Utils.getText(this.editText);
        if (fileName.length() < 1)
            this.showToast(
                org.phenoapps.androidlibrary.R.string.getExportFileNameAlertDialogToast);
        else
        {
            this.cancelAlertDialog();
            if (null != this.handler) this.handler.handleGetFileNameDone(fileName);
        }
    }

    public GetExportFileNameAlertDialog(@androidx.annotation.NonNull
    final android.app.Activity                                                  activity,
    final org.phenoapps.androidlibrary.GetExportFileNameAlertDialog.Handler handler )
    { super(activity); this.handler = handler; }

    @java.lang.Override public void configure()
    {
        this.setTitle(org.phenoapps.androidlibrary.R.string.getExportFileNameAlertDialogTitle);

        {
            @android.annotation.SuppressLint({"InflateParams"})
            final android.view.View view = this.layoutInflater().inflate(
                org.phenoapps.androidlibrary.R.layout.alert_dialog_get_export_file_name,
                null);

            if (null != view) if (null == this.editText) this.editText = view.findViewById(
                org.phenoapps.androidlibrary.R.id.editText);

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
                        org.phenoapps.androidlibrary.GetExportFileNameAlertDialog
                            .this.handleGetFileNameDone();
                    }
                });
        }
    }
}