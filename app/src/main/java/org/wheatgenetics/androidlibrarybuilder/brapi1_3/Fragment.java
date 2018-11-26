package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.app.Activity
 * android.os.Bundle
 * android.support.annotation.IdRes
 * android.support.annotation.LayoutRes
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.support.v4.app.Fragment
 * android.view.LayoutInflater
 * android.view.View
 * android.view.ViewGroup
 * android.widget.EditText
 * android.widget.TextView
 *
 * io.swagger.client.ApiException
 */
@android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
abstract class Fragment extends android.support.v4.app.Fragment
{
    private static final java.lang.String ARGUMENT_KEY = "base_path";

    // region Fields
    private java.lang.String        basePath         = null;
    private android.widget.TextView responseTextView = null;
    // endregion

    private void initializeBasePath()
    {
        final android.os.Bundle arguments = this.getArguments();
        if (null == arguments)
            this.basePath = null;
        else
        {
            final java.lang.String ARGUMENT_KEY =
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.ARGUMENT_KEY;
            this.basePath =
                arguments.containsKey(ARGUMENT_KEY) ? arguments.getString(ARGUMENT_KEY) : null;
        }
    }

    // region Package Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @android.support.annotation.Nullable  android.view.View inflate(
    @android.support.annotation.NonNull   final android.view.LayoutInflater inflater        ,
    @android.support.annotation.Nullable  final android.view.ViewGroup      container       ,
    @android.support.annotation.LayoutRes final int                         layoutResourceId)
    {
        this.initializeBasePath();
        return inflater.inflate(layoutResourceId, container,false);
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void findResponseTextViewById(
    @android.support.annotation.NonNull final android.view.View rootView,
    @android.support.annotation.IdRes   final int               id      )
    { this.responseTextView = rootView.findViewById(id); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    java.lang.String getBasePath() { return this.basePath; }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    static java.lang.String getString(final android.widget.EditText editText)
    {
        if (null == editText)
            return null;
        else
        {
            final android.text.Editable text = editText.getText();
            if (null == text)
                return null;
            else
            {
                final java.lang.String string = text.toString();
                return string.equals("") ? null : string;
            }
        }
    }

    // region setResponseTextViewText() Package Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void setResponseTextViewText(final java.lang.String text)
    { if (null != this.responseTextView) this.responseTextView.setText(text); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void setResponseTextViewTextFromThread(final java.lang.String text)
    {
        final android.app.Activity activity = this.getActivity();
        if (null != activity) activity.runOnUiThread(new java.lang.Runnable()
             {
                 @java.lang.Override public void run()
                 {
                     org.wheatgenetics.androidlibrarybuilder.brapi1_3
                         .Fragment.this.setResponseTextViewText(text);
                 }
             });
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void setResponseTextViewText(final java.lang.Throwable throwable)
    {
        if (null == throwable)
            this.setResponseTextViewTextFromThread("throwable is null.");
        else
        {
            final java.lang.String message, throwableAsString;
            if (throwable instanceof io.swagger.client.ApiException)
            {
                final io.swagger.client.ApiException apiException =
                    (io.swagger.client.ApiException) throwable;
                message           = apiException.getResponseBody();
                throwableAsString = apiException.toString       ();
            }
            else
                { message = throwable.getMessage(); throwableAsString = throwable.toString(); }

            if (null == message)
                this.setResponseTextViewText(throwableAsString);
            else
                this.setResponseTextViewText(
                    message.trim().equals("") ? throwableAsString : message);
        }
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void setResponseTextViewTextFromThread(final java.lang.Throwable throwable)
    {
        final android.app.Activity activity = this.getActivity();
        if (null != activity) activity.runOnUiThread(new java.lang.Runnable()
        {
            @java.lang.Override public void run()
            {
                org.wheatgenetics.androidlibrarybuilder.brapi1_3
                    .Fragment.this.setResponseTextViewText(throwable);
            }
        });
    }
    // endregion
    // endregion
}