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
 * io.swagger.client.model.ObservationUnitsResponse
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Parameters
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.ObservationunitsGetAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.ObservationunitsGetAlertDialog
 *     .Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.ObservationunitsGetAlertDialog
 *     .Parameters
 */
public class Fragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
{
    // region Fields
    private io.swagger.client.api.ObservationsApi observationsApiInstance = null;       // lazy load

    // region observationlevelsGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Parameters
        observationlevelsGetParametersInstance = null;                                  // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog
        observationlevelsGetAlertDialogInstance = null;                                 // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.ApiCallback<
        io.swagger.client.model.ObservationLevelsResponse>
            observationLevelsResponseCallbackInstance = null;                           // lazy load
    // endregion

    // region observationunitsGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations               // lazy load
        .ObservationunitsGetAlertDialog.Parameters observationunitsGetParametersInstance = null;
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
        .ObservationunitsGetAlertDialog observationunitsGetAlertDialogInstance = null;  // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.ApiCallback<
        io.swagger.client.model.ObservationUnitsResponse>
            observationUnitsResponseCallbackInstance = null;                            // lazy load
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

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog
    observationlevelsGetAlertDialog()
    {
        if (null == this.observationlevelsGetAlertDialogInstance)
            this.observationlevelsGetAlertDialogInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog(
                    this.getActivity(), new org.wheatgenetics.androidlibrarybuilder
                        .brapi1_3.PagePageSizeAlertDialog.Handler()
                        {
                            @java.lang.Override public void handleDone()
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                    .observations.Fragment.this.observationlevelsGet();
                            }
                        },"ObservationsApi.observationlevelsGet()");
        return this.observationlevelsGetAlertDialogInstance;
    }

    private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Parameters
    observationlevelsGetParameters()
    {
        if (null == this.observationlevelsGetParametersInstance)
            this.observationlevelsGetParametersInstance =
                new org.wheatgenetics.androidlibrarybuilder
                    .brapi1_3.PagePageSizeAlertDialog.Parameters();
        return this.observationlevelsGetParametersInstance;
    }

    private void showObservationlevelsGetAlertDialog()
    { this.observationlevelsGetAlertDialog().show(this.observationlevelsGetParameters()); }
    // endregion

    // region observationunitsGet() Private Methods
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.ApiCallback<
    io.swagger.client.model.ObservationUnitsResponse> observationUnitsResponseCallback()
    {
        if (null == this.observationUnitsResponseCallbackInstance)
            this.observationUnitsResponseCallbackInstance = new
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.ApiCallback<
                    io.swagger.client.model.ObservationUnitsResponse>() {};
        return this.observationUnitsResponseCallbackInstance;
    }

    private void observationunitsGet()
    {
        if (null != this.observationunitsGetParametersInstance)
            try
            {
                this.observationsApi().observationunitsGetAsync(
                    /* germplasmDbId => */
                        this.observationunitsGetParametersInstance.getGermplasmDbId(),
                    /* observationVariableDbId => */
                        this.observationunitsGetParametersInstance.getObservationVariableDbId(),
                    /* studyDbId    => */ this.observationunitsGetParametersInstance.getStudyDbId(),
                    /* locationDbId => */
                        this.observationunitsGetParametersInstance.getLocationDbId(),
                    /* trialDbId   => */ this.observationunitsGetParametersInstance.getTrialDbId(),
                    /* programDbId => */
                        this.observationunitsGetParametersInstance.getProgramDbId(),
                    /* seasonDbId => */ this.observationunitsGetParametersInstance.getSeasonDbId(),
                    /* observationLevel => */
                        this.observationunitsGetParametersInstance.getObservationLevel(),

                    /* observationTimeStampRangeStart => */ this
                        .observationunitsGetParametersInstance.getObservationTimeStampRangeStart(),
                    /* observationTimeStampRangeEnd => */ this
                        .observationunitsGetParametersInstance.getObservationTimeStampRangeEnd(),

                    /* page     => */ this.observationunitsGetParametersInstance.getPage    (),
                    /* pageSize => */ this.observationunitsGetParametersInstance.getPageSize(),

                    /* authorization => */ this.authorization                   (),
                    /* callback      => */ this.observationUnitsResponseCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
    .ObservationunitsGetAlertDialog observationunitsGetAlertDialog()
    {
        if (null == this.observationunitsGetAlertDialogInstance)
            this.observationunitsGetAlertDialogInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                    .ObservationunitsGetAlertDialog(this.getActivity(),
                        new org.wheatgenetics.brapi1_3.AlertDialog.Handler()
                        {
                            @java.lang.Override public void handleDone()
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                    .observations.Fragment.this.observationunitsGet();
                            }
                        });
        return this.observationunitsGetAlertDialogInstance;
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
    .ObservationunitsGetAlertDialog.Parameters observationunitsGetParameters()
    {
        if (null == this.observationunitsGetParametersInstance)
            this.observationunitsGetParametersInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                    .ObservationunitsGetAlertDialog.Parameters();
        return this.observationunitsGetParametersInstance;
    }

    private void showObservationunitsGetAlertDialog()
    { this.observationunitsGetAlertDialog().show(this.observationunitsGetParameters()); }
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
            // The following ? ids are from fragment_brapi1_3_observations.xml.              // TODO
            {
                final android.widget.Button observationlevelsGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id
                        .observationsObservationlevelsGetButton);
                if (null != observationlevelsGetButton)
                    observationlevelsGetButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View view)
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                                    .Fragment.this.showObservationlevelsGetAlertDialog();
                            }
                        });
            }
            {
                final android.widget.Button observationunitsGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id
                        .observationsObservationunitsGetButton);
                if (null != observationunitsGetButton) observationunitsGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View view)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                                .Fragment.this.showObservationunitsGetAlertDialog();
                        }
                    });
            }
            this.findResponseTextViewById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.observationsResponseTextView);
        }
        return rootView;
    }
}
