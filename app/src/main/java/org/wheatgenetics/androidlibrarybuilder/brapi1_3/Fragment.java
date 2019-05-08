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
 * io.swagger.client.ApiClient
 */
public abstract class Fragment extends android.support.v4.app.Fragment
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) interface Supplier
    { @android.support.annotation.NonNull public abstract io.swagger.client.ApiClient apiClient(); }

    // region Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier supplier       ;
    private android.widget.TextView                                    responseTextView = null;
    // endregion

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
    void setResponseTextViewText(final java.lang.String text)
    { if (null != this.responseTextView) this.responseTextView.setText(text); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @android.support.annotation.NonNull protected io.swagger.client.ApiClient apiClient()
    {
        final org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier supplier =
            this.getSupplier();
        // noinspection ConstantConditions
        return null == supplier ? null : supplier.apiClient();
    }

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

    // region Public Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @android.support.annotation.Nullable  public android.view.View inflate(
    @android.support.annotation.NonNull   final android.view.LayoutInflater inflater        ,
    @android.support.annotation.Nullable  final android.view.ViewGroup      container       ,
    @android.support.annotation.LayoutRes final int                         layoutResourceId)
    { return inflater.inflate(layoutResourceId, container,false); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    public void findResponseTextViewById(
    @android.support.annotation.NonNull final android.view.View rootView,
    @android.support.annotation.IdRes   final int               id      )
    { this.responseTextView = rootView.findViewById(id); }

    // region setResponseTextViewText() Public Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    public void setResponseTextViewTextFromThread(final java.lang.String text)
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
    public void setResponseTextViewText(final java.lang.Throwable throwable)
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
    public void setResponseTextViewTextFromThread(final java.lang.Throwable throwable)
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