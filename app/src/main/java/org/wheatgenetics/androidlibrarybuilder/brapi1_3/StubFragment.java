package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.os.Bundle
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.view.LayoutInflater
 * android.view.View
 * android.view.ViewGroup
 * android.widget.TextView
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
 */
public class StubFragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
{
    private static final java.lang.String ARGUMENT_KEY = "resource_name";

    public StubFragment() {}

    @android.support.annotation.Nullable @java.lang.Override public android.view.View onCreateView(
    @android.support.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @android.support.annotation.Nullable final android.view.ViewGroup      container         ,
    @android.support.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = this.inflate(inflater, container,
            org.wheatgenetics.androidlibrarybuilder.R.layout.fragment_brapi1_3_stub);
        {
            final java.lang.String resourceName;
            assert null != rootView; final android.widget.TextView textView = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.stubTextView);      // From fragment_-
            {                                                                    //  brapi_stub.xml.
                final java.lang.String ARGUMENT_KEY =
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.ARGUMENT_KEY;
                final android.os.Bundle arguments = this.getArguments();
                resourceName = null == arguments ? "ERROR" : arguments.containsKey(ARGUMENT_KEY) ?
                    arguments.getString(ARGUMENT_KEY) : "ERROR";
            }
            assert null != textView; textView.setText(this.getString(
                org.wheatgenetics.androidlibrarybuilder.R.string.stubTextViewFormatString,
                resourceName                                                             ));
        }
        return rootView;
    }

    static org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment instantiate(
    @android.support.annotation.NonNull final java.lang.String resourceName)
    {
        final org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment result =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment();
        {
            final android.os.Bundle arguments = new android.os.Bundle();
            arguments.putString(
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.ARGUMENT_KEY,
                resourceName                                                              );
            result.setArguments(arguments);
        }
        return result;
    }
}