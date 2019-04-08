package org.wheatgenetics.androidlibrary;

/**
 * This class provides optional debug logging.
 *
 * Uses:
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.util.Log
 * android.view.KeyEvent
 * android.view.inputmethod.EditorInfo
 * android.widget.EditText
 * android.widget.TextView
 * android.widget.TextView.OnEditorActionListener
 *
 * org.wheatgenetics.androidlibrary.Utils
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
abstract class DebuggingEditorActionListener extends java.lang.Object
implements android.widget.TextView.OnEditorActionListener
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Receiver
    { public abstract void receiveText(java.lang.String text); }

    // region Fields
    @android.support.annotation.NonNull  private final android.widget.EditText editText;
    @android.support.annotation.Nullable private final
        org.wheatgenetics.androidlibrary.DebuggingEditorActionListener.Receiver receiver;
    private final boolean debug;
    // endregion

    private void clearEditTextTextAfterDelay() { this.editText.setText(""); }

    // region Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
    protected static int log(final java.lang.String msg)
    { return android.util.Log.d("EditorActionListener", msg); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess", "SimplifiableConditionalExpression"})
    protected static boolean isEmpty(final java.lang.String text)
    { return null == text ? true : text.length() <= 0; }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected void preprocess() {}

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"})
    protected void sendText(final java.lang.String text)
    {
        if (this.debug) org.wheatgenetics.androidlibrary.DebuggingEditorActionListener.log(text);
        if (null != this.receiver) this.receiver.receiveText(text);
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"})
    protected void process(final java.lang.String text)
    {
        if (!org.wheatgenetics.androidlibrary.DebuggingEditorActionListener.isEmpty(text))
            { this.preprocess(); this.sendText(text); }
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"}) protected void clearEditText()
    { this.editText.setText(""); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"}) @android.support.annotation.Nullable
    protected org.wheatgenetics.androidlibrary.DebuggingEditorActionListener.Receiver getReceiver()
    { return this.receiver; }
    // endregion

    DebuggingEditorActionListener(
    @android.support.annotation.NonNull  final android.widget.EditText editText,
    @android.support.annotation.Nullable final
        org.wheatgenetics.androidlibrary.DebuggingEditorActionListener.Receiver receiver,
    final boolean debug)
    {
        super();

        this.editText = editText; this.editText.setOnEditorActionListener(this);
        this.receiver = receiver; this.debug = debug;
    }

    // region android.widget.TextView.OnEditorActionListener Overridden Method
    @java.lang.Override public boolean onEditorAction(final android.widget.TextView v,
    final int actionId, final android.view.KeyEvent event)
    {
        if (this.debug)
        {
            final java.lang.StringBuilder stringBuilder =
                new java.lang.StringBuilder("actionId == ");
            switch (actionId)
            {
                case android.view.inputmethod.EditorInfo.IME_ACTION_NEXT:
                    stringBuilder.append("IME_ACTION_NEXT"); break;

                case android.view.inputmethod.EditorInfo.IME_ACTION_DONE:
                    stringBuilder.append("IME_ACTION_DONE"); break;

                case android.view.inputmethod.EditorInfo.IME_NULL:
                    stringBuilder.append("IME_NULL"); break;

                default: stringBuilder.append(actionId); break;
            }

            stringBuilder.append(", event == ");
            if (null != event) stringBuilder.append("not "); stringBuilder.append("null");

            if (android.view.inputmethod.EditorInfo.IME_NULL == actionId && null != event)
            {
                final int action = event.getAction();
                switch (action)
                {
                    case android.view.KeyEvent.ACTION_DOWN: case android.view.KeyEvent.ACTION_UP:
                        stringBuilder.append(", event.getAction() == ACTION_");
                        switch (action)
                        {
                            case android.view.KeyEvent.ACTION_DOWN:
                                stringBuilder.append("DOWN"); break;

                            case android.view.KeyEvent.ACTION_UP: stringBuilder.append("UP"); break;
                        } break;
                }
            }

            org.wheatgenetics.androidlibrary.DebuggingEditorActionListener.log(
                stringBuilder.toString());
        }

        switch (actionId)
        {
            case android.view.inputmethod.EditorInfo.IME_NULL:
                assert null != event;
                if (event.getAction() == android.view.KeyEvent.ACTION_DOWN) return true;
                // break statement is intentionally omitted here.

            case android.view.inputmethod.EditorInfo.IME_ACTION_DONE:
                this.process(org.wheatgenetics.androidlibrary.Utils.getText(this.editText));
                return true;

            default: return false;
        }
    }
    // endregion
}