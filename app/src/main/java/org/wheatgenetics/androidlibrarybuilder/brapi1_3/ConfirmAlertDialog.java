package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.Nullable
 * android.view.View
 * android.widget.TextView
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 * org.wheatgenetics.brapi1_3.AlertDialog.Handler
 */
public class ConfirmAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"})
    public interface Handler extends org.wheatgenetics.brapi1_3.AlertDialog.Handler
    { public abstract java.lang.String getConfirmTextViewText(); }

    // region Fields
    private final java.lang.String title;

    private android.widget.TextView textView;
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConfirmAlertDialog.Handler
        specificHandlerInstance = null;                                                 // lazy load
    // endregion

    // region Private Methods
    @android.support.annotation.Nullable private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConfirmAlertDialog.Handler specificHandler()
    {
        if (null == this.specificHandlerInstance)
        {
            final org.wheatgenetics.brapi1_3.AlertDialog.Handler genericHandler = this.getHandler();
            if (genericHandler instanceof
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConfirmAlertDialog.Handler)
                this.specificHandlerInstance = (org.wheatgenetics.androidlibrarybuilder
                    .brapi1_3.ConfirmAlertDialog.Handler) genericHandler;
        }
        return this.specificHandlerInstance;
    }

    private void setTextViewText()
    {
        if (null != this.textView)
        {
            final org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConfirmAlertDialog.Handler
                specificHandler = this.specificHandler();
            if (null != specificHandler)
                this.textView.setText(specificHandler.getConfirmTextViewText());
        }
    }
    // endregion

    public ConfirmAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConfirmAlertDialog.Handler handler,
    final java.lang.String title) { super(activity, handler); this.title = title; }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(this.title);
        {
            final android.view.View view = this.inflate(
                org.wheatgenetics.androidlibrarybuilder.R.layout.alert_dialog_brapi1_3_confirm);
            if (null != view) if (null == this.textView) this.textView = view.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.confirmTextView);
            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override public void show() { this.setTextViewText(); super.show(); }
    // endregion
}