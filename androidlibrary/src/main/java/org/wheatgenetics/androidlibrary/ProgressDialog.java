package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.app.ProgressDialog
 * android.content.Context
 * android.content.DialogInterface.OnCancelListener
 */
public class ProgressDialog extends java.lang.Object
{
    // region Fields
    private final android.content.Context                          context              ;
    private final java.lang.CharSequence                           title, initialMessage;
    private final android.content.DialogInterface.OnCancelListener onCancelListener     ;

    private android.app.ProgressDialog progressDialogInstance = null;
    // endregion

    private android.app.ProgressDialog progressDialog()
    {
        if (null == this.progressDialogInstance)
        {
            this.progressDialogInstance = new android.app.ProgressDialog(this.context);
            this.progressDialogInstance.setTitle           (this.title           );
            this.progressDialogInstance.setMessage         (this.initialMessage  );
            this.progressDialogInstance.setCancelable      (true                 );
            this.progressDialogInstance.setOnCancelListener(this.onCancelListener);
        }
        return this.progressDialogInstance;
    }

    // region Public Methods
    public ProgressDialog(final android.content.Context context, final java.lang.CharSequence title,
    final java.lang.CharSequence initialMessage,
    final android.content.DialogInterface.OnCancelListener onCancelListener)
    {
        super();

        this.context        = context       ; this.title            = title           ;
        this.initialMessage = initialMessage; this.onCancelListener = onCancelListener;
    }

    public void show() { this.progressDialog().show(); }

    public void setMessage(final java.lang.CharSequence message)
    { this.progressDialog().setMessage(message); }

    public void setMessage(final int message)
    { assert null != this.context; this.setMessage(this.context.getString(message)); }

    public void dismiss()
    {
        if (null != this.progressDialogInstance)
            if (this.progressDialogInstance.isShowing()) this.progressDialogInstance.dismiss();
    }
    // endregion
}