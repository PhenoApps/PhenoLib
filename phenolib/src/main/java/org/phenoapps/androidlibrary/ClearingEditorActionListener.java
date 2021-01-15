package org.phenoapps.androidlibrary;

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
extends org.phenoapps.androidlibrary.DebuggingEditorActionListener
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Receiver
    extends org.phenoapps.androidlibrary.DebuggingEditorActionListener.Receiver
    { public abstract void clearText(); }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"}) protected void clearText()
    {
        final org.phenoapps.androidlibrary.ClearingEditorActionListener.Receiver receiver =
            (org.phenoapps.androidlibrary.ClearingEditorActionListener.Receiver)
                this.getReceiver();
        if (null != receiver) receiver.clearText();
    }

    public ClearingEditorActionListener(
    @androidx.annotation.NonNull  final android.widget.EditText editText,
    @androidx.annotation.Nullable
        final org.phenoapps.androidlibrary.ClearingEditorActionListener.Receiver receiver,
    final boolean debug) { super(editText, receiver, debug); }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void process(final java.lang.String text)
    {
        if (org.phenoapps.androidlibrary.ClearingEditorActionListener.isEmpty(text))
            this.clearText();
        else
            this.sendText(text);
    }
}