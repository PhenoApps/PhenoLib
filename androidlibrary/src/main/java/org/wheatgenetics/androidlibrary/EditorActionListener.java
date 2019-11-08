package org.wheatgenetics.androidlibrary;

/**
 * This class clears its editText's text when done.
 *
 * Uses:
 * android.os.Handler
 * android.widget.EditText
 *
 * androidx.annotation.NonNull
 * androidx.annotation.Nullable
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.androidlibrary.DebuggingEditorActionListener
 */
class EditorActionListener extends org.wheatgenetics.androidlibrary.DebuggingEditorActionListener
{
    // region Fields
    private final java.lang.Runnable runnable = new java.lang.Runnable()
    {
        @java.lang.Override public void run()
        { org.wheatgenetics.androidlibrary.EditorActionListener.this.clearEditText(); }
    };
    private final android.os.Handler handler = new android.os.Handler();
    // endregion

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"}) protected void clearEditTextText()
    { this.handler.postDelayed(this.runnable, /* delayMillis => */100); }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public EditorActionListener(
    @androidx.annotation.NonNull  final android.widget.EditText editText,
    @androidx.annotation.Nullable final
        org.wheatgenetics.androidlibrary.EditorActionListener.Receiver receiver,
    final boolean debug) { super(editText, receiver, debug); }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void preprocess() { this.clearEditTextText(); }
}