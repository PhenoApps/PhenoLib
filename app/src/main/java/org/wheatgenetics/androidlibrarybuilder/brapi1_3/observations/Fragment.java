package org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations;

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
 * io.swagger.client.api.ObservationsApi
 * io.swagger.client.model.ObservationLevelsResponse
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
 */
public class Fragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
{
    // region Fields
    private io.swagger.client.api.ObservationsApi observationsApiInstance = null;       // lazy load

    // region observationlevelsGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations                   // lazy
        .ObservationlevelsGetAlertDialog observationlevelsGetAlertDialogInstance = null;    //  load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations               // lazy load
        .ObservationlevelsGetAlertDialog.Parameters observationlevelsGetParametersInstance = null;
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.ApiCallback<
        io.swagger.client.model.ObservationLevelsResponse>
            observationLevelsResponseCallbackInstance = null;                           // lazy load
    // endregion
    // endregion

    // region Private Methods
    private io.swagger.client.api.ObservationsApi observationsApi()
    {
        if (null == this.observationsApiInstance) this.observationsApiInstance =
            new io.swagger.client.api.ObservationsApi(this.apiClient());
        return this.observationsApiInstance;
    }

    // region observationlevelsGet() Private Methods
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.ApiCallback<
    io.swagger.client.model.ObservationLevelsResponse> observationLevelsResponseCallback()
    {
        if (null == this.observationLevelsResponseCallbackInstance)
            this.observationLevelsResponseCallbackInstance = new
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.ApiCallback<
                    io.swagger.client.model.ObservationLevelsResponse>() {};
        return this.observationLevelsResponseCallbackInstance;
    }

    private void observationlevelsGet()
    {
        if (null != this.observationlevelsGetParametersInstance)
            try
            {
                this.observationsApi().observationlevelsGetAsync(
                    /* page     => */ this.observationlevelsGetParametersInstance.getPage    (),
                    /* pageSize => */ this.observationlevelsGetParametersInstance.getPageSize(),
                    /* authorization => */ this.authorization                    (),
                    /* callback      => */ this.observationLevelsResponseCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.ObservationlevelsGetAlertDialog
    observationlevelsGetAlertDialog()
    {
        if (null == this.observationlevelsGetAlertDialogInstance)
            this.observationlevelsGetAlertDialogInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                    .ObservationlevelsGetAlertDialog(this.getActivity(),
                        new org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                            .ObservationlevelsGetAlertDialog.Handler()
                            {
                                @java.lang.Override public void handleDone()
                                {
                                    org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                        .observations.Fragment.this.observationlevelsGet();
                                }
                            },"ObservationsApi.observationlevelsGet()");
        return this.observationlevelsGetAlertDialogInstance;
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
    .ObservationlevelsGetAlertDialog.Parameters observationlevelsGetParameters()
    {
        if (null == this.observationlevelsGetParametersInstance)
            this.observationlevelsGetParametersInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                    .ObservationlevelsGetAlertDialog.Parameters();
        return this.observationlevelsGetParametersInstance;
    }

    private void showObservationlevelsGetAlertDialog()
    { this.observationlevelsGetAlertDialog().show(this.observationlevelsGetParameters()); }
    // endregion
    // endregion

    @java.lang.Override @android.support.annotation.Nullable public android.view.View onCreateView(
    @android.support.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @android.support.annotation.Nullable final android.view.ViewGroup      container         ,
    @android.support.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = this.inflate(inflater, container,
            org.wheatgenetics.androidlibrarybuilder.R.layout.fragment_brapi1_3_observations);
        if (null != rootView)
        {
            // The following ? ids are from fragment_brapi1_3_observationss.xml.             // TODO
            {
                final android.widget.Button observationlevelsGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.observationlevelsGetButton);
                if (null != observationlevelsGetButton)
                    observationlevelsGetButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                                    .Fragment.this.showObservationlevelsGetAlertDialog();
                            }
                        });
            }
            this.findResponseTextViewById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.observationsResponseTextView);
        }
        return rootView;
    }
}