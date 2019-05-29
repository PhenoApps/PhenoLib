package org.wheatgenetics.androidlibrarybuilder.brapi1_3.observationvariables;

/**
 * Uses:
 * android.os.Bundle
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.view.LayoutInflater
 * android.view.View
 * android.view.View.OnClickListener
 * android.view.ViewGroup
 * android.widget.Button
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
 */
public class Fragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
{
    private void showMethodsGetAlertDialog() {}

    @java.lang.Override @android.support.annotation.Nullable public android.view.View onCreateView(
    @android.support.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @android.support.annotation.Nullable final android.view.ViewGroup      container         ,
    @android.support.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = this.inflate(inflater, container, org.wheatgenetics
            .androidlibrarybuilder.R.layout.fragment_brapi1_3_observationvariables);
        if (null != rootView)
        {
            // The following ? ids are from fragment_brapi1_3_observationvariables.xml.      // TODO
            {
                final android.widget.Button methodsGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.methodsGetButton);
                if (null != methodsGetButton) methodsGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observationvariables
                                .Fragment.this.showMethodsGetAlertDialog();
                        }
                    });
            }
        }
        return rootView;
    }
}