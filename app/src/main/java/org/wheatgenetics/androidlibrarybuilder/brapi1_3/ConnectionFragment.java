package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.content.Context
 * android.os.Bundle
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.view.LayoutInflater
 * android.view.View
 * android.view.View.OnClickListener
 * android.view.ViewGroup
 * android.widget.Button
 * android.widget.EditText
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
        public abstract void                   setBasePath       (java.lang.String basePath);
    }

    private android.widget.EditText basePathEditText;

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

    private java.lang.CharSequence testServerBasePath()
    {
        final org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier
            connectionFragmentSupplier = this.getConnectionFragmentSupplier();
        return null == connectionFragmentSupplier ? null :
            connectionFragmentSupplier.testServerBasePath();
    }

    private void autofillWithTestServer()
    { if (null != this.basePathEditText) this.basePathEditText.setText(this.testServerBasePath()); }

    private void setBasePath()
    {
        final org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier
            connectionFragmentSupplier = this.getConnectionFragmentSupplier();
        if (null != connectionFragmentSupplier) connectionFragmentSupplier.setBasePath(
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.getString(
                this.basePathEditText));
    }
    // endregion

    public ConnectionFragment() {}

    // region Overridden Methods
    @java.lang.Override public void onAttach(final android.content.Context context)
    {
        super.onAttach(context);

        if (context instanceof
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier)
            this.setSupplier(
                (org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier)
                    context);
        else
            this.failSupplier(context);
    }

    @java.lang.Override @android.support.annotation.Nullable public android.view.View onCreateView(
    @android.support.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @android.support.annotation.Nullable final android.view.ViewGroup      container         ,
    @android.support.annotation.Nullable final android.os.Bundle           savedInstanceState)
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
        }

        return rootView;
    }
    // endregion
}