package org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations;

/**
 * Uses:
 * android.app.Activity
 * android.content.Context
 * android.content.Intent
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
 * io.swagger.client.model.NewObservationDbIdsResponse
 * io.swagger.client.model.ObservationLevelsResponse
 * io.swagger.client.model.ObservationUnitsResponse
 * io.swagger.client.model.WSMIMEDataTypes
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Consts
 * org.wheatgenetics.androidlibrary.mstrdtl.Utils
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest
 * org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestListActivity
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Parameters
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Utils
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.ObservationunitsGetAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.ObservationunitsGetAlertDialog
 *     .Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.ObservationunitsGetAlertDialog
 *     .Parameters
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.PhenotypesPostAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.PhenotypesPostAlertDialog.Handler
 */
public class Fragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Helper
    {
        public abstract org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest
        getPhenotypesRequest();

        public abstract void setPhenotypesRequest(
        org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest phenotypesRequest);

        public abstract io.swagger.client.model.WSMIMEDataTypes getFormat();
        public abstract void setFormat(io.swagger.client.model.WSMIMEDataTypes format);
    }

    private static final int PHENOTYPES_REQUEST_LIST_ACTIVITY_REQUEST_CODE = 1;

    // region Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.Helper helper;
    private io.swagger.client.api.ObservationsApi       observationsApiInstance = null; // lazy load

    // region observationlevelsGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.ApiCallback<
        io.swagger.client.model.ObservationLevelsResponse>
            observationLevelsResponseCallbackInstance = null;                           // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog
        observationlevelsGetAlertDialogInstance = null;                                 // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Parameters
        observationlevelsGetParametersInstance = null;                                  // lazy load
    // endregion

    // region observationunitsGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.ApiCallback<
        io.swagger.client.model.ObservationUnitsResponse>
            observationUnitsResponseCallbackInstance = null;                            // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
        .ObservationunitsGetAlertDialog observationunitsGetAlertDialogInstance = null;  // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations               // lazy load
        .ObservationunitsGetAlertDialog.Parameters observationunitsGetParametersInstance = null;
    // endregion

    // region phenotypesPost() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.ApiCallback<
        io.swagger.client.model.NewObservationDbIdsResponse>
            observationsPhenotypesPostCallbackInstance = null;                          // lazy load
    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.PhenotypesPostAlertDialog
            phenotypesPostAlertDialogInstance = null;                                   // lazy load
    private org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest phenotypesRequest;
    private android.content.Intent          phenotypesRequestListIntentInstance = null; // lazy load
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

    // region phenotypesPost() Private Methods
    private org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest getPhenotypesRequest()
    { return null == this.helper ? null : this.helper.getPhenotypesRequest(); }

    private void setPhenotypesRequest(
    final org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest phenotypesRequest)
    { if (null != this.helper) this.helper.setPhenotypesRequest(phenotypesRequest); }

    private io.swagger.client.model.WSMIMEDataTypes getFormat()
    { return null == this.helper ? null : this.helper.getFormat(); }

    private void setFormat(final io.swagger.client.model.WSMIMEDataTypes format)
    { if (null != this.helper) this.helper.setFormat(format); }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.ApiCallback<
    io.swagger.client.model.NewObservationDbIdsResponse> observationsPhenotypesPostCallback()
    {
        if (null == this.observationsPhenotypesPostCallbackInstance)
            this.observationsPhenotypesPostCallbackInstance = new
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.ApiCallback<
                    io.swagger.client.model.NewObservationDbIdsResponse>() {};
        return this.observationsPhenotypesPostCallbackInstance;
    }

    private void phenotypesPost()
    {
        this.setPhenotypesRequest(this.phenotypesRequest);
        this.setFormat(null == this.phenotypesPostAlertDialogInstance ?
            null : this.phenotypesPostAlertDialogInstance.getFormat());
        try
        {
            this.observationsApi().phenotypesPostAsync(
                /* body          => */ this.getPhenotypesRequest              (),
                /* format        => */ this.getFormat                         (),
                /* authorization => */ this.authorization                     (),
                /* callback      => */ this.observationsPhenotypesPostCallback());
        }
        catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private java.lang.String getPhenotypesRequestAsString()
    {
        return org.wheatgenetics.androidlibrarybuilder.brapi1_3.Utils.getNullableAsString(
            this.phenotypesRequest);
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.PhenotypesPostAlertDialog
    phenotypesPostAlertDialog()
    {
        if (null == this.phenotypesPostAlertDialogInstance) this.phenotypesPostAlertDialogInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .observations.PhenotypesPostAlertDialog(this.getActivity(), new org.wheatgenetics
                    .androidlibrarybuilder.brapi1_3.observations.PhenotypesPostAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .observations.Fragment.this.phenotypesPost();
                        }

                        @java.lang.Override public String getConfirmTextViewText()
                        {
                            return org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .observations.Fragment.this.getPhenotypesRequestAsString();
                        }
                    });
        return this.phenotypesPostAlertDialogInstance;
    }

    private void showPhenotypesPostAlertDialog()
    { this.phenotypesPostAlertDialog().show(this.getFormat()); }

    private void setPhenotypesRequest(
    @android.support.annotation.Nullable final java.lang.String json)
    {
        if (null == json)
            this.phenotypesRequest = null;
        else
        {
            final java.lang.String trimmedJson = json.trim();
            if (trimmedJson.length() <= 0)
                this.phenotypesRequest = null;
            else
            {
                if (null == this.phenotypesRequest) this.phenotypesRequest =
                    new org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequest();
                this.phenotypesRequest.fromJson(trimmedJson);
            }
        }
    }

    private android.content.Intent phenotypesRequestListIntent()
    {
        if (null == this.phenotypesRequestListIntentInstance)
            this.phenotypesRequestListIntentInstance = new android.content.Intent(
                this.getActivity()                                                            ,
                org.wheatgenetics.brapi1_3.observations.pr.PhenotypesRequestListActivity.class);
        return org.wheatgenetics.androidlibrary.mstrdtl.Utils.putJsonIntoIntent(
            this.getPhenotypesRequest(), this.phenotypesRequestListIntentInstance);
    }

    private void showPhenotypesRequestListActivity()
    {
        this.startActivityForResult(
            /* intent      => */ this.phenotypesRequestListIntent(),
            /* requestCode => */ org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .observations.Fragment.PHENOTYPES_REQUEST_LIST_ACTIVITY_REQUEST_CODE);
    }
    // endregion
    // endregion

    // region Overridden Methods
    @java.lang.Override public void onAttach(final android.content.Context context)
    {
        super.onAttach(context);

        if (context instanceof
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.Helper)
            this.helper =
                (org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment.Helper)
                    context;
        else
            throw new java.lang.RuntimeException(null == context ?
                "context" : context.toString() + " must implement Helper");
    }

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
            {
                final android.widget.Button phenotypesPostButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.observationsPhenotypesPostButton);
                if (null != phenotypesPostButton) phenotypesPostButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View view)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
                                .Fragment.this.showPhenotypesRequestListActivity();
                        }
                    });
            }
            this.findResponseTextViewById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.observationsResponseTextView);
        }
        return rootView;
    }

    @java.lang.Override public void onActivityResult(final int requestCode,
    final int resultCode, final android.content.Intent data)
    {
        if (android.app.Activity.RESULT_OK == resultCode && null != data)
        {
            final boolean dataHasJson; final java.lang.String json;
            {
                final java.lang.String JSON_KEY =
                    org.wheatgenetics.androidlibrary.mstrdtl.Consts.JSON_KEY;
                dataHasJson = data.hasExtra(JSON_KEY)                           ;
                json        = dataHasJson ? data.getStringExtra(JSON_KEY) : null;
            }

            // noinspection SwitchStatementWithTooFewBranches
            switch (requestCode)
            {
                case org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment
                .PHENOTYPES_REQUEST_LIST_ACTIVITY_REQUEST_CODE:
                    if (dataHasJson)
                        this.setPhenotypesRequest(json);
                    else
                        this.phenotypesRequest = null;
                    this.showPhenotypesPostAlertDialog(); break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @java.lang.Override public void onDetach() { this.helper = null; super.onDetach(); }
    // endregion
}