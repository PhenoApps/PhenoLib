package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
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
 */
@android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
abstract class Fragment extends android.support.v4.app.Fragment
{
    private static final java.lang.String ARGUMENT_KEY = "base_path";

    // region Fields
    private java.lang.String                          basePath              = null;
    private android.widget.TextView                   responseTextView      = null;
    //private com.android.volley.Response.ErrorListener errorListenerInstance = null;
    // endregion

    // region Private Methods
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

    // region setResponseTextViewText() Private Methods
    private void setResponseTextViewText(final java.lang.Exception exception,
    final java.lang.String nameIfNull)
    {
        if (null == exception)
            this.setResponseTextViewText(nameIfNull + " is null.");
        else
        {
            final java.lang.String message = exception.getMessage();
            this.setResponseTextViewText(null == message ? exception.toString() : message);
        }
    }

    //private void setResponseTextViewText(final com.android.volley.VolleyError volleyError)
    //{ this.setResponseTextViewText(volleyError,"volleyError"); }
    // endregion
    // endregion

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
            final java.lang.String text = editText.getText().toString();
            return text.equals("") ? null : text;
        }
    }

    // region setResponseTextViewText() Package Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void setResponseTextViewText(final java.lang.String text)
    { if (null != this.responseTextView) this.responseTextView.setText(text); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void setResponseTextViewText(final java.lang.Exception exception)
    { this.setResponseTextViewText(exception,"exception"); }
    // endregion

    /*@android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    com.android.volley.Response.ErrorListener errorListener()
    {
        if (null == this.errorListenerInstance) this.errorListenerInstance =
            new com.android.volley.Response.ErrorListener()
            {
                @java.lang.Override
                public void onErrorResponse(final com.android.volley.VolleyError error)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
                        .this.setResponseTextViewText(error);
                }
            };
        return this.errorListenerInstance;
    }*/
    // endregion
}