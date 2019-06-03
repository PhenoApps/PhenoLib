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
 * io.swagger.client.api.ObservationVariablesApi
 * io.swagger.client.model.MethodsResponse
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Parameters
 */
public class Fragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
{
    // region Fields
    private io.swagger.client.api.ObservationVariablesApi
        observationVariablesApiInstance = null;                                         // lazy load

    // region methodsGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog
        methodsGetAlertDialogInstance = null;                                           // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Parameters
        methodsGetParametersInstance = null;                                            // lazy load
    private                                                                             // lazy load
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.observationvariables.Fragment.ApiCallback<
            io.swagger.client.model.MethodsResponse> methodsResponseCallbackInstance = null;
    // endregion
    // endregion

    // region Private Methods
    private io.swagger.client.api.ObservationVariablesApi observationVariablesApi()
    {
        if (null == this.observationVariablesApiInstance) this.observationVariablesApiInstance =
            new io.swagger.client.api.ObservationVariablesApi();
        return this.observationVariablesApiInstance;
    }

    // region methodsGet() Private Methods
    private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.observationvariables.Fragment.ApiCallback<
    io.swagger.client.model.MethodsResponse> methodsResponseCallback()
    {
        if (null == this.methodsResponseCallbackInstance) this.methodsResponseCallbackInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.observationvariables
                .Fragment.ApiCallback<io.swagger.client.model.MethodsResponse>() {};
        return this.methodsResponseCallbackInstance;
    }

    private void methodsGet()
    {
        if (null != this.methodsGetParametersInstance)
            try
            {
                this.observationVariablesApi().methodsGetAsync(
                    /* page          => */ this.methodsGetParametersInstance.getPage    (),
                    /* pageSize      => */ this.methodsGetParametersInstance.getPageSize(),
                    /* authorization => */ this.authorization                           (),
                    /* callback      => */ this.methodsResponseCallback                 ());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog
    methodsGetAlertDialog()
    {
        if (null == this.methodsGetAlertDialogInstance) this.methodsGetAlertDialogInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog(
                this.getActivity(), new org.wheatgenetics.brapi1_3.AlertDialog.Handler()
                {
                    @java.lang.Override public void handleDone()
                    {
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3
                            .observationvariables.Fragment.this.methodsGet();
                    }
                },"ObservationVariablesApi.methodsGet()");
        return this.methodsGetAlertDialogInstance;
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Parameters
    methodsGetParameters()
    {
        if (null == this.methodsGetParametersInstance) this.methodsGetParametersInstance = new
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Parameters();
        return this.methodsGetParametersInstance;
    }

    private void showMethodsGetAlertDialog()
    { this.methodsGetAlertDialog().show(this.methodsGetParameters()); }
    // endregion
    // endregion

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
            this.findResponseTextViewById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.observationVariablesResponseTextView);
        }
        return rootView;
    }
}