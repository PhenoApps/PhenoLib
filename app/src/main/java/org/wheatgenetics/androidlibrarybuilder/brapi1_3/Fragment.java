package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.app.Activity
 * android.content.Context
 * android.text.Editable
 * android.view.LayoutInflater
 * android.view.View
 * android.view.ViewGroup
 * android.widget.EditText
 * android.widget.TextView
 *
 * androidx.annotation.IdRes
 * androidx.annotation.LayoutRes
 * androidx.annotation.NonNull
 * androidx.annotation.Nullable
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 * androidx.fragment.app.Fragment
 *
 * io.swagger.client.ApiException
 * io.swagger.client.ApiCallback
 * io.swagger.client.ApiClient
 */
public abstract class Fragment extends androidx.fragment.app.Fragment
{
    // region Types
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) interface Supplier
    {
        @androidx.annotation.NonNull public abstract io.swagger.client.ApiClient apiClient();
                                     public abstract java.lang.String        authorization();
    }

    @java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"}) protected abstract class
    ApiCallback<T> extends java.lang.Object implements io.swagger.client.ApiCallback<T>
    {
        private void setResponseTextViewText(final T result)
        {
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.this
                .setResponseTextViewTextFromThread(null == result ? "null" : result.toString());
        }

        @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
        protected void handleSuccess(final T result) { this.setResponseTextViewText(result); }

        // region Overridden Methods
        @java.lang.Override public void onFailure(final io.swagger.client.ApiException e,
        final int                                                               statusCode     ,
        final java.util.Map<java.lang.String, java.util.List<java.lang.String>> responseHeaders)
        {
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
                .this.setResponseTextViewTextFromThread(e);
        }

        @java.lang.Override public void onSuccess(final T result, final int statusCode,
        final java.util.Map<java.lang.String, java.util.List<java.lang.String>> responseHeaders)
        { this.handleSuccess(result) /* polymorphism */; }

        @java.lang.Override public void onUploadProgress(
        final long bytesWritten, final long contentLength, final boolean done) {}

        @java.lang.Override public void onDownloadProgress(
        final long bytesRead, final long contentLength, final boolean done) {}
        // endregion
    }
    // endregion

    // region Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier supplier            ;
    private android.widget.TextView                                         responseTextView = null;
    // endregion

    // region Private Methods
    private void clearSupplier() { this.setSupplier(null); }

    private void setResponseTextViewText(final java.lang.String text)
    { if (null != this.responseTextView) this.responseTextView.setText(text); }

    private void setResponseTextViewTextFromThread(final java.lang.String text)
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
    // endregion

    // region Package Methods
    // region Supplier Package Methods
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    void setSupplier(final android.content.Context context)
    {
        this.supplier =
            (org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier) context;
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    void failSupplier(final android.content.Context context)
    {
        this.clearSupplier();
        throw new java.lang.RuntimeException(null == context ?
            "context" : context.toString() + " must implement Supplier");
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier getSupplier()
    { return this.supplier; }
    // endregion

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
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
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @androidx.annotation.Nullable  protected android.view.View inflate(
    @androidx.annotation.NonNull   final android.view.LayoutInflater inflater        ,
    @androidx.annotation.Nullable  final android.view.ViewGroup      container       ,
    @androidx.annotation.LayoutRes final int                         layoutResourceId)
    { return inflater.inflate(layoutResourceId, container,false); }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    protected void findResponseTextViewById(
    @androidx.annotation.NonNull final android.view.View rootView,
    @androidx.annotation.IdRes   final int               id      )
    { this.responseTextView = rootView.findViewById(id); }

    // region setResponseTextViewText() Protected Methods
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"})
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
            {
                final java.lang.String trimmedMessage = message.trim();
                this.setResponseTextViewText(
                    trimmedMessage.equals("") ? throwableAsString : trimmedMessage);
            }
        }
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
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
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @androidx.annotation.Nullable protected io.swagger.client.ApiClient apiClient()
    {
        final org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier supplier =
            this.getSupplier();
        return null == supplier ? null : supplier.apiClient();
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @androidx.annotation.Nullable protected java.lang.String authorization()
    {
        final org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier supplier =
            this.getSupplier();
        return null == supplier ? null : supplier.authorization();
    }
    // endregion
    // endregion

    // region Overridden Methods
    @java.lang.Override public void onAttach(
    @androidx.annotation.NonNull final android.content.Context context)
    {
        super.onAttach(context);

        if (context instanceof org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier)
            this.setSupplier(context);
        else
            this.failSupplier(context);
    }

    @java.lang.Override public void onDetach() { this.clearSupplier(); super.onDetach(); }
    // endregion
}