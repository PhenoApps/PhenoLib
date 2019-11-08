package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.widget.EditText
 *
 * androidx.annotation.NonNull
 * androidx.annotation.Nullable
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.androidlibrary.DebuggingEditorActionListener
 * org.wheatgenetics.androidlibrary.DebuggingEditorActionListener.Receiver
 */
@java.lang.SuppressWarnings({"unused"}) public class ClearingEditorActionListener
extends org.wheatgenetics.androidlibrary.DebuggingEditorActionListener
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Receiver
    extends org.wheatgenetics.androidlibrary.DebuggingEditorActionListener.Receiver
    { public abstract void clearText(); }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"}) protected void clearText()
    {
        final org.wheatgenetics.androidlibrary.ClearingEditorActionListener.Receiver receiver =
            (org.wheatgenetics.androidlibrary.ClearingEditorActionListener.Receiver)
                this.getReceiver();
        assert null != receiver; receiver.clearText();
    }

    public ClearingEditorActionListener(
    @androidx.annotation.NonNull  final android.widget.EditText editText,
    @androidx.annotation.Nullable
        final org.wheatgenetics.androidlibrary.ClearingEditorActionListener.Receiver receiver,
    final boolean debug) { super(editText, receiver, debug); }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void process(final java.lang.String text)
    {
        if (org.wheatgenetics.androidlibrary.ClearingEditorActionListener.isEmpty(text))
            this.clearText();
        else
            this.sendText(text);
    }
}