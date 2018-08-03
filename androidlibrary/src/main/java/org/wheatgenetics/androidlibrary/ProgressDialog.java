package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.app.ProgressDialog
 * android.content.Context
 * android.content.DialogInterface.OnCancelListener
 * android.support.annotation.StringRes
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject", "WeakerAccess"})
public class ProgressDialog extends java.lang.Object
{
    // region Fields
    private final android.content.Context                          context         ;
    private final android.content.DialogInterface.OnCancelListener onCancelListener;

    private java.lang.CharSequence     title, initialMessage        ;
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

    // region Constructors
    @java.lang.SuppressWarnings({"unused"}) private ProgressDialog(
    final android.content.Context                          context         ,
    final android.content.DialogInterface.OnCancelListener onCancelListener)
    { super(); this.context = context; this.onCancelListener = onCancelListener; }

    @java.lang.SuppressWarnings({"unused"}) public ProgressDialog(
    final android.content.Context context, final java.lang.CharSequence title,
    final java.lang.CharSequence initialMessage,
    final android.content.DialogInterface.OnCancelListener onCancelListener)
    { this(context, onCancelListener); this.title = title; this.initialMessage = initialMessage; }

    @java.lang.SuppressWarnings({"unused"}) public ProgressDialog(
                                          final android.content.Context context         ,
    @android.support.annotation.StringRes final int                     title           ,
    @android.support.annotation.StringRes final int                     initialMessage  ,
    final android.content.DialogInterface.OnCancelListener              onCancelListener)
    {
        this(context, onCancelListener);

        assert null != this.context;
        this.title          = this.context.getString(title         );
        this.initialMessage = this.context.getString(initialMessage);
    }
    // endregion

    // region Public Methods
    @java.lang.SuppressWarnings({"unused"}) public void show() { this.progressDialog().show(); }

    @java.lang.SuppressWarnings({"WeakerAccess"})
    public void setMessage(final java.lang.CharSequence message)
    { this.progressDialog().setMessage(message); }

    @java.lang.SuppressWarnings({"unused"})
    public void setMessage(@android.support.annotation.StringRes final int message)
    { assert null != this.context; this.setMessage(this.context.getString(message)); }

    @java.lang.SuppressWarnings({"unused"}) public void dismiss()
    {
        if (null != this.progressDialogInstance)
            if (this.progressDialogInstance.isShowing()) this.progressDialogInstance.dismiss();
    }
    // endregion
}