package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.app.Activity
 * android.content.Context
 * android.support.annotation.IdRes
 * android.support.annotation.LayoutRes
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.support.v4.app.Fragment
 * android.text.Editable
 * android.view.LayoutInflater
 * android.view.View
 * android.view.ViewGroup
 * android.widget.EditText
 * android.widget.TextView
 *
 * io.swagger.client.ApiException
 * io.swagger.client.ApiCallback
 * io.swagger.client.ApiClient
 */
public abstract class Fragment extends android.support.v4.app.Fragment
{
    // region Types
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) interface Supplier
    {
                                            public abstract java.lang.String        authorization();
        @android.support.annotation.NonNull public abstract io.swagger.client.ApiClient apiClient();
    }

    @java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
    protected abstract class ApiCallback<T> extends java.lang.Object
    implements io.swagger.client.ApiCallback<T>
    {
        void setResponseTextViewText(final T result)
        {
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.this
                .setResponseTextViewTextFromThread(null == result ? "null" : result.toString());
        }

        // region Overridden Methods
        @java.lang.Override public void onFailure(final io.swagger.client.ApiException e,
        final int                                                               statusCode     ,
        final java.util.Map<java.lang.String, java.util.List<java.lang.String>> responseHeaders)
        {
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.this
                .setResponseTextViewTextFromThread(e);
        }

        @java.lang.Override public void onSuccess(final T result, final int statusCode,
        final java.util.Map<java.lang.String, java.util.List<java.lang.String>> responseHeaders)
        { this.setResponseTextViewText(result); }

        @java.lang.Override public void onUploadProgress(
        final long bytesWritten, final long contentLength, final boolean done) {}

        @java.lang.Override public void onDownloadProgress(
        final long bytesRead, final long contentLength, final boolean done) {}
        // endregion
    }
    // endregion

    // region Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier supplier       ;
    private android.widget.TextView                                    responseTextView = null;
    // endregion

    private void setResponseTextViewText(final java.lang.String text)
    { if (null != this.responseTextView) this.responseTextView.setText(text); }

    // region Package Methods
    // region Supplier Package Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void setSupplier(
    final org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier supplier)
    { this.supplier = supplier; }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier getSupplier()
    { return this.supplier; }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void failSupplier(final android.content.Context context)
    {
        this.setSupplier(null);
        throw new java.lang.RuntimeException(null == context ?
            "context" : context.toString() + " must implement Supplier");
    }
    // endregion

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
    // endregion

    // region Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @android.support.annotation.Nullable  protected android.view.View inflate(
    @android.support.annotation.NonNull   final android.view.LayoutInflater inflater        ,
    @android.support.annotation.Nullable  final android.view.ViewGroup      container       ,
    @android.support.annotation.LayoutRes final int                         layoutResourceId)
    { return inflater.inflate(layoutResourceId, container,false); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected void findResponseTextViewById(
    @android.support.annotation.NonNull final android.view.View rootView,
    @android.support.annotation.IdRes   final int               id      )
    { this.responseTextView = rootView.findViewById(id); }

    // region setResponseTextViewText() Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected void setResponseTextViewTextFromThread(final java.lang.String text)
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
    protected void setResponseTextViewText(final java.lang.Throwable throwable)
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
    protected void setResponseTextViewTextFromThread(final java.lang.Throwable throwable)
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

    // region Supplier Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @android.support.annotation.NonNull protected io.swagger.client.ApiClient apiClient()
    {
        final org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier supplier =
            this.getSupplier();
        // noinspection ConstantConditions
        return null == supplier ? null : supplier.apiClient();
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected java.lang.String authorization()
    {
        final org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier supplier =
            this.getSupplier();
        return null == supplier ? null : supplier.authorization();
    }
    // endregion
    // endregion

    // region Overridden Methods
    @java.lang.Override public void onAttach(final android.content.Context context)
    {
        super.onAttach(context);

        if (context instanceof org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier)
            this.setSupplier(
                (org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier) context);
        else
            this.failSupplier(context);
    }

    @java.lang.Override public void onDetach() { this.setSupplier(null); super.onDetach(); }
    // endregion
}