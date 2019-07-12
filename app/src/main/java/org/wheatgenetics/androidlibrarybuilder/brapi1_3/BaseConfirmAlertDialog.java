package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.IdRes
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.widget.TextView
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 * org.wheatgenetics.brapi1_3.AlertDialog.Handler
 */
public abstract class BaseConfirmAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"})
    public interface Handler extends org.wheatgenetics.brapi1_3.AlertDialog.Handler
    { public abstract java.lang.String getConfirmTextViewText(); }

    // region Fields
    private final java.lang.String title;

    private android.widget.TextView textView;
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.BaseConfirmAlertDialog.Handler
        specificHandlerInstance = null;                                                 // lazy load
    // endregion

    // region Private Methods
    @android.support.annotation.Nullable
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.BaseConfirmAlertDialog.Handler
    specificHandler()
    {
        if (null == this.specificHandlerInstance)
        {
            final org.wheatgenetics.brapi1_3.AlertDialog.Handler genericHandler = this.getHandler();
            if (genericHandler instanceof
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.BaseConfirmAlertDialog.Handler)
                this.specificHandlerInstance = (org.wheatgenetics.androidlibrarybuilder
                    .brapi1_3.BaseConfirmAlertDialog.Handler) genericHandler;
        }
        return this.specificHandlerInstance;
    }

    private void setTextViewText()
    {
        if (null != this.textView)
        {
            final org.wheatgenetics.androidlibrarybuilder.brapi1_3.BaseConfirmAlertDialog.Handler
                specificHandler = this.specificHandler();
            if (null != specificHandler)
                this.textView.setText(specificHandler.getConfirmTextViewText());
        }
    }
    // endregion

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected void configure(         final android.view.View view      ,
    @android.support.annotation.IdRes final int               textViewId)
    {
        this.setTitle(this.title);
        if (null != view) if (null == this.textView) this.textView = view.findViewById(textViewId);
        this.setView(view);
        super.configure();
    }

    public BaseConfirmAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.androidlibrarybuilder.brapi1_3.BaseConfirmAlertDialog.Handler handler,
    final java.lang.String title) { super(activity, handler); this.title = title; }

    @java.lang.Override public void show() { this.setTextViewText(); super.show(); }
}