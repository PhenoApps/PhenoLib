package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.app.Activity
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.EditText
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.Utils
 */
public class GetExportFileNameAlertDialog extends org.wheatgenetics.androidlibrary.AlertDialog
{
    @java.lang.SuppressWarnings("UnnecessaryInterfaceModifier")
    public interface Handler
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
            assert null != this.handler; this.handler.handleGetFileNameDone(fileName);
        }
    }

    public GetExportFileNameAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.androidlibrary.GetExportFileNameAlertDialog.Handler handler)
    { super(activity); this.handler = handler; }

    @java.lang.Override
    public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.getExportFileNameAlertDialogTitle);

        {
            final android.view.View view = this.layoutInflater().inflate(
                org.wheatgenetics.androidlibrary.R.layout.get_export_file_name_alert_dialog, null);

            if (null == this.editText)
            {
                assert null != view; this.editText = (android.widget.EditText)
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id.editText);
            }

            this.setView(view);
        }

        this.setOKPositiveButton(null).setCancelNegativeButton();
    }

    public void show(final java.lang.String initialFileName)
    {
        assert null != this.editText;
        this.editText.setText(initialFileName); this.editText.selectAll();

        this.show();
        if (!this.positiveOnClickListenerHasBeenReplaced()) this.replacePositiveOnClickListener(
            new android.view.View.OnClickListener()
            {
                @java.lang.Override
                public void onClick(final android.view.View view)
                {
                    org.wheatgenetics.androidlibrary
                        .GetExportFileNameAlertDialog.this.handleGetFileNameDone();
                }
            });
    }
}