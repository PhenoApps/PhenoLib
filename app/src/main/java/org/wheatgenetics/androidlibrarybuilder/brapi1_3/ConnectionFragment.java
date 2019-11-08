package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.content.Context
 * android.os.Bundle
 * android.view.LayoutInflater
 * android.view.View
 * android.view.View.OnClickListener
 * android.view.ViewGroup
 * android.widget.Button
 * android.widget.EditText
 *
 * androidx.annotation.NonNull
 * androidx.annotation.Nullable
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier
 */
public class ConnectionFragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) interface Supplier
    extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier
    {
        public abstract java.lang.CharSequence testServerBasePath();

        public abstract void setBasePath     (java.lang.String basePath     );
        public abstract void setAuthorization(java.lang.String authorization);
    }

    private static final java.lang.String BEARER_XXXX_AUTHORIZATION = "Bearer XXXX";

    private android.widget.EditText basePathEditText, authorizationEditText;

    // region Private Methods
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier
    getConnectionFragmentSupplier()
    {
        final org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment.Supplier supplier =
            this.getSupplier();
        if (null == supplier)
            return null;
        else
            if (supplier instanceof
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier)
                return
                    (org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier)
                        supplier;
            else
                return null;
    }

    // region basePath Private Methods
    private java.lang.CharSequence testServerBasePath()
    {
        final org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier
            connectionFragmentSupplier = this.getConnectionFragmentSupplier();
        return null == connectionFragmentSupplier ? null :
            connectionFragmentSupplier.testServerBasePath();
    }

    private void autofillBasePath(final java.lang.String text)
    { if (null != this.basePathEditText) this.basePathEditText.setText(text); }

    private void autofillWithTestServer()
    { this.autofillBasePath((java.lang.String) this.testServerBasePath()); }

    private void autofillWithCasavaBase()
    { this.autofillBasePath("https://cassava-test.sgn.cornell.edu"); }

    private void setBasePath()
    {
        final org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier
            connectionFragmentSupplier = this.getConnectionFragmentSupplier();
        if (null != connectionFragmentSupplier) connectionFragmentSupplier.setBasePath(
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.getString(
                this.basePathEditText));
    }
    // endregion

    // region authorization Private Methods
    private void autofillAuthorization(@androidx.annotation.NonNull final java.lang.String text)
    { if (null != this.authorizationEditText) this.authorizationEditText.setText(text); }

    private void autofillWithBearerXXXX()
    {
        this.autofillAuthorization(org.wheatgenetics.androidlibrarybuilder
            .brapi1_3.ConnectionFragment.BEARER_XXXX_AUTHORIZATION);
    }

    private void autofillWithBearerYYYY() { this.autofillAuthorization("Bearer YYYY"); }

    private void setAuthorization()
    {
        final org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier
            connectionFragmentSupplier = this.getConnectionFragmentSupplier();
        if (null != connectionFragmentSupplier) connectionFragmentSupplier.setAuthorization(
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.getString(
                this.authorizationEditText));
    }
    // endregion
    // endregion

    public ConnectionFragment() {}

    // region Overridden Methods
    @java.lang.Override public void onAttach(final android.content.Context context)
    {
        super.onAttach(context);

        if (context instanceof
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier)
            this.setSupplier(context);
        else
            this.failSupplier(context);
    }

    @java.lang.Override @androidx.annotation.Nullable public android.view.View onCreateView(
    @androidx.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @androidx.annotation.Nullable final android.view.ViewGroup      container         ,
    @androidx.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = this.inflate(inflater, container,
            org.wheatgenetics.androidlibrarybuilder.R.layout.fragment_brapi1_3_connection);

        if (null != rootView)
        {
            this.basePathEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.basePathEditText);
            if (null != this.basePathEditText)
                this.basePathEditText.setHint(this.testServerBasePath());

            {
                final android.widget.Button testServerAutofillButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.testServerAutofillButton);
                if (null != testServerAutofillButton) testServerAutofillButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .ConnectionFragment.this.autofillWithTestServer();
                        }
                    });
            }

            {
                final android.widget.Button casavaBaseAutofillButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.cassavaBaseAutofillButton);
                if (null != casavaBaseAutofillButton) casavaBaseAutofillButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .ConnectionFragment.this.autofillWithCasavaBase();
                        }
                    });
            }

            {
                final android.widget.Button setBasePathButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.setBasePathButton);
                if (null != setBasePathButton) setBasePathButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .ConnectionFragment.this.setBasePath();
                        }
                    });
            }

            this.authorizationEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.authorizationEditText);
            if (null != this.authorizationEditText) this.authorizationEditText.setHint(
                org.wheatgenetics.androidlibrarybuilder.brapi1_3
                    .ConnectionFragment.BEARER_XXXX_AUTHORIZATION);

            {
                final android.widget.Button bearerXXXXAutofillButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.bearerXXXXAutofillButton);
                if (null != bearerXXXXAutofillButton) bearerXXXXAutofillButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .ConnectionFragment.this.autofillWithBearerXXXX();
                        }
                    });
            }

            {
                final android.widget.Button bearerYYYYAutofillButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.bearerYYYYAutofillButton);
                if (null != bearerYYYYAutofillButton) bearerYYYYAutofillButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .ConnectionFragment.this.autofillWithBearerYYYY();
                        }
                    });
            }

            {
                final android.widget.Button setAuthorizationButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.setAuthorizationButton);
                if (null != setAuthorizationButton) setAuthorizationButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .ConnectionFragment.this.setAuthorization();
                        }
                    });
            }
        }

        return rootView;
    }
    // endregion
}