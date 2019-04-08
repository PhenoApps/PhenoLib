package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.widget.EditText
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

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"}) protected void clearText()
    {
        final org.wheatgenetics.androidlibrary.ClearingEditorActionListener.Receiver receiver =
            (org.wheatgenetics.androidlibrary.ClearingEditorActionListener.Receiver)
                this.getReceiver();
        assert null != receiver; receiver.clearText();
    }

    public ClearingEditorActionListener(
    @android.support.annotation.NonNull  final android.widget.EditText editText,
    @android.support.annotation.Nullable
        final org.wheatgenetics.androidlibrary.ClearingEditorActionListener.Receiver receiver,
    final boolean debug) { super(editText, receiver, debug); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void process(final java.lang.String text)
    {
        if (org.wheatgenetics.androidlibrary.DebuggingEditorActionListener.isEmpty(text))
            this.clearText();
        else
            this.sendText(text);
    }
}