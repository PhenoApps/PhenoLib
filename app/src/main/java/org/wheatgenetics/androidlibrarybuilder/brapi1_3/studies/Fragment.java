package org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies;

/**
 * Uses:
 * android.app.Activity
 * android.app.Application
 * android.content.Intent
 * android.os.Bundle
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.support.v4.app.FragmentActivity
 * android.view.LayoutInflater
 * android.view.View
 * android.view.View.OnClickListener
 * android.view.ViewGroup
 * android.widget.Button
 *
 * io.swagger.client.api.StudiesApi
 * io.swagger.client.model.GermplasmSummaryListResponse
 * io.swagger.client.model.NewObservationsRequest
 * io.swagger.client.model.ObservationUnitPositionsResponse
 * io.swagger.client.model.ObservationUnitsResponse1
 * io.swagger.client.model.ObservationsResponse
 * io.swagger.client.model.SeasonsResponse
 * io.swagger.client.model.StudiesResponse
 * io.swagger.client.model.StudyLayoutRequest
 * io.swagger.client.model.StudyObservationVariablesResponse
 * io.swagger.client.model.StudyResponse
 * io.swagger.client.model.StudySearchRequest
 * io.swagger.client.model.StudyTypesResponse
 * io.swagger.client.model.SuccessfulSearchResponse
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.ItemsProvider
 *
 * org.wheatgenetics.brapi1_3.studies.Application
 * org.wheatgenetics.brapi1_3.studies.NewObservationsRequestListActivity
 * org.wheatgenetics.brapi1_3.studies.StudyLayoutRequestListActivity
 * org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog
 * org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.Handler
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .SearchStudiesSearchResultsDbIdGetAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .SearchStudiesSearchResultsDbIdGetAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .SearchStudiesSearchResultsDbIdGetAlertDialog.Parameters
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog.Parameters
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog.Parameters
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdGetAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdGetAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .StudiesStudyDbIdGetAlertDialog.Parameters
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .StudiesStudyDbIdObservationsGetAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .StudiesStudyDbIdObservationsGetAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .StudiesStudyDbIdObservationsGetAlertDialog.Parameters
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .StudiesStudyDbIdObservationunitsGetAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .StudiesStudyDbIdObservationunitsGetAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .StudiesStudyDbIdObservationunitsGetAlertDialog.Parameters
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .StudyDbIdPagePageSizeAlertDialog.Parameters
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudytypesGetAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudytypesGetAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudytypesGetAlertDialog.Parameters
 */
public class Fragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
{
    // region Types
    private class StudiesStudyDbIdLayoutsPutCallback
    extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
    io.swagger.client.model.ObservationUnitPositionsResponse> {}

    private class StudiesStudyDbIdLayoutsGetCallback extends org.wheatgenetics
    .androidlibrarybuilder.brapi1_3.studies.Fragment.StudiesStudyDbIdLayoutsPutCallback
    {
        @java.lang.Override @android.support.annotation.RestrictTo(
            android.support.annotation.RestrictTo.Scope.SUBCLASSES)
        protected void handleSuccess(final io.swagger.client.model.ObservationUnitPositionsResponse
            result)
        {
            {
                final boolean enableStudiesStudyDbIdLayoutsPutButton;
                {
                    final org.wheatgenetics.brapi1_3.studies.Application application =
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3
                            .studies.Fragment.this.application();
                    if (null == application)
                        enableStudiesStudyDbIdLayoutsPutButton = false;
                    else
                    {
                        application.makeStudyLayoutRequest(result);

                        final org.wheatgenetics.javalib.mstrdtl.Items items =
                            application.mstrdtlItems();
                        // noinspection SimplifiableConditionalExpression
                        enableStudiesStudyDbIdLayoutsPutButton =
                            null == items ? false : items.size() > 0;
                    }
                }
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.
                    Fragment.this.setStudiesStudyDbIdLayoutsPutButtonEnabled(
                        enableStudiesStudyDbIdLayoutsPutButton);
            }
            super.handleSuccess(result);
        }
    }
    // endregion

    private static final int
        STUDY_LAYOUT_REQUEST_LIST_ACTIVITY_REQUEST_CODE     = 1000,
        NEW_OBSERVATIONS_REQUEST_LIST_ACTIVITY_REQUEST_CODE = 1010;

    // region Fields
    private io.swagger.client.api.StudiesApi               studiesApiInstance  = null;  // lazy load
    private org.wheatgenetics.brapi1_3.studies.Application applicationInstance = null;  // lazy load

    // region searchStudiesPost() Fields
    private org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog
        studySearchRequestAlertDialogInstance = null;                                   // lazy load
    private io.swagger.client.model.StudySearchRequest studySearchRequestInstance = null;      // ll
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
        io.swagger.client.model.SuccessfulSearchResponse>
            successfulSearchResponseCallbackInstance = null;                            // lazy load
    // endregion

    // region searchStudiesSearchResultsDbIdGet() and studiesGet() Field
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
        io.swagger.client.model.StudiesResponse> studiesResponseCallbackInstance = null;// lazy load
    // endregion

    // region searchStudiesSearchResultsDbIdGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .SearchStudiesSearchResultsDbIdGetAlertDialog
            searchStudiesSearchResultsDbIdGetAlertDialogInstance = null;                // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .SearchStudiesSearchResultsDbIdGetAlertDialog.Parameters
            searchStudiesSearchResultsDbIdGetParametersInstance = null;                 // lazy load
    // endregion

    // region seasonsGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog
        seasonsGetAlertDialogInstance = null;                                           // lazy load
    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog.Parameters
            seasonsGetAlertDialogParametersInstance = null;                             // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
        io.swagger.client.model.SeasonsResponse> seasonsResponseCallbackInstance = null;// lazy load
    // endregion

    // region studiesGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
        studiesGetAlertDialogInstance = null;                                           // lazy load
    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog.Parameters
            studiesGetAlertDialogParametersInstance = null;                             // lazy load
    // endregion

    // region studiesStudyDbIdGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdGetAlertDialog
        studiesStudyDbIdGetAlertDialogInstance = null;                                  // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdGetAlertDialog.Parameters studiesStudyDbIdGetParametersInstance = null;//ll
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
        io.swagger.client.model.StudyResponse> studyResponseCallbackInstance = null;    // lazy load
    // endregion

    // region studiesStudyDbIdGermplasmGet() and studiesStudyDbIdLayoutsGet() Field
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies                    // lazy load
        .StudyDbIdPagePageSizeAlertDialog.Parameters studyDbIdPagePageSizeParametersInstance = null;
    // endregion

    // region studiesStudyDbIdGermplasmGet() Fields
    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog
            studiesStudyDbIdGermplasmGetAlertDialogInstance = null;                     // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
        io.swagger.client.model.GermplasmSummaryListResponse>
            germplasmSummaryListResponseCallbackInstance = null;                        // lazy load
    // endregion

    // region studiesStudyDbIdLayoutsGet() Fields
    private android.widget.Button studiesStudyDbIdLayoutsPutButton;
    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog
            studiesStudyDbIdLayoutsGetAlertDialogInstance = null;                       // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
        .StudiesStudyDbIdLayoutsGetCallback studiesStudyDbIdLayoutsGetCallbackInstance = null; // ll
    // endregion

    // region studiesStudyDbIdLayoutsPut() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
        .StudiesStudyDbIdLayoutsPutCallback studiesStudyDbIdLayoutsPutCallbackInstance = null; // ll
    private android.content.Intent studyLayoutRequestListIntentInstance = null;         // lazy load
    // endregion

    // region studiesStudyDbIdObservationsGet() Fields
    private android.widget.Button studiesStudyDbIdObservationsPutButton;
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdObservationsGetAlertDialog
            studiesStudyDbIdObservationsGetAlertDialogInstance = null;                  // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdObservationsGetAlertDialog.Parameters
            studiesStudyDbIdObservationsGetParametersInstance = null;                   // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
        io.swagger.client.model.ObservationsResponse>
            observationsResponseCallbackInstance = null;                                // lazy load
    // endregion

    // region studiesStudyDbIdObservationsPut() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
        io.swagger.client.model.NewObservationDbIdsResponse>
            newObservationDbIdsResponseCallbackInstance = null;                         // lazy load
    private android.content.Intent newObservationsRequestListIntentInstance = null;     // lazy load
    // endregion

    // region studiesStudyDbIdObservationunitsGet() Fields
    private android.widget.Button studiesStudyDbIdObservationunitsPutButton;
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdObservationunitsGetAlertDialog
            studiesStudyDbIdObservationunitsGetAlertDialogInstance = null;              // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdObservationunitsGetAlertDialog.Parameters
            studiesStudyDbIdObservationunitsGetParametersInstance = null;               // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
        io.swagger.client.model.ObservationUnitsResponse1>
            observationUnitsResponse1CallbackInstance = null;                           // lazy load
    // endregion

    // region studiesStudyDbIdObservationvariablesGet() Fields
    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog
            studiesStudyDbIdObservationvariablesGetAlertDialogInstance = null;          // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
        io.swagger.client.model.StudyObservationVariablesResponse>
            studyObservationVariablesResponseCallbackInstance = null;                   // lazy load
    // endregion

    // region studytypesGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudytypesGetAlertDialog
        studytypesGetAlertDialogInstance = null;                                        // lazy load
    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudytypesGetAlertDialog.Parameters
            studytypesGetParametersInstance = null;                                     // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
        io.swagger.client.model.StudyTypesResponse> studyTypesResponseCallbackInstance = null; // ll
    // endregion
    // endregion

    // region Private Methods
    private io.swagger.client.api.StudiesApi studiesApi()
    {
        if (null == this.studiesApiInstance)
            this.studiesApiInstance = new io.swagger.client.api.StudiesApi(this.apiClient());
        return this.studiesApiInstance;
    }

    private org.wheatgenetics.brapi1_3.studies.Application application()
    {
        if (null == this.applicationInstance)
        {
            final android.app.Application application;
            {
                final android.support.v4.app.FragmentActivity fragmentActivity =
                    this.getActivity();
                application = null == fragmentActivity ? null : fragmentActivity.getApplication();
            }
            if (application instanceof org.wheatgenetics.javalib.mstrdtl.ItemsProvider)
                this.applicationInstance =
                    (org.wheatgenetics.brapi1_3.studies.Application) application;
        }
        return this.applicationInstance;
    }

    private org.wheatgenetics.javalib.mstrdtl.Items items()
    {
        final org.wheatgenetics.brapi1_3.studies.Application application = this.application();
        return null == application ? null : application.mstrdtlItems();
    }

    private void setPutButtonEnabled(
    @android.support.annotation.Nullable final android.widget.Button putButton,
                                         final boolean               enabled  )
    {
        if (null != putButton)
        {
            final android.app.Activity activity = this.getActivity();
            if (null != activity) activity.runOnUiThread(new java.lang.Runnable()
            { @java.lang.Override public void run() { putButton.setEnabled(enabled); } });
        }
    }

    private void disablePutButton(
    @android.support.annotation.Nullable final android.widget.Button putButton)
    { this.setPutButtonEnabled(putButton,false); }

    // region searchStudiesPost() Private Methods
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
    io.swagger.client.model.SuccessfulSearchResponse> successfulSearchResponseCallback()
    {
        if (null == this.successfulSearchResponseCallbackInstance)
            this.successfulSearchResponseCallbackInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
                    io.swagger.client.model.SuccessfulSearchResponse>() {};
        return this.successfulSearchResponseCallbackInstance;
    }

    private void searchStudiesPost()
    {
        try
        {
            this.studiesApi().searchStudiesPostAsync(
                /* body          => */ this.studySearchRequestInstance        ,
                /* authorization => */ this.authorization                   (),
                /* callback      => */ this.successfulSearchResponseCallback());
        }
        catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog
    studySearchRequestAlertDialog()
    {
        if (null == this.studySearchRequestAlertDialogInstance)
            this.studySearchRequestAlertDialogInstance =
                new org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog(
                    this.getActivity(),
                    new org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                .Fragment.this.searchStudiesPost();
                        }
                    });
        return this.studySearchRequestAlertDialogInstance;
    }

    private io.swagger.client.model.StudySearchRequest studySearchRequest()
    {
        if (null == this.studySearchRequestInstance) this.studySearchRequestInstance =
            new io.swagger.client.model.StudySearchRequest();
        return this.studySearchRequestInstance;
    }

    private void showStudySearchRequestAlertDialog()
    { this.studySearchRequestAlertDialog().show(this.studySearchRequest()); }
    // endregion

    // region searchStudiesSearchResultsDbIdGet() and studiesGet() Private Method
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
    io.swagger.client.model.StudiesResponse> studiesResponseCallback()
    {
        if (null == this.studiesResponseCallbackInstance) this.studiesResponseCallbackInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
                io.swagger.client.model.StudiesResponse>() {};
        return this.studiesResponseCallbackInstance;
    }
    // endregion

    // region searchStudiesSearchResultsDbIdGet() Private Methods
    private void searchStudiesSearchResultsDbIdGet()
    {
        if (null != this.searchStudiesSearchResultsDbIdGetParametersInstance)
            try
            {
                this.studiesApi().searchStudiesSearchResultsDbIdGetAsync(
                    /* searchResultsDbId => */ this
                        .searchStudiesSearchResultsDbIdGetParametersInstance.getSearchResultsDbId(),
                    /* page => */
                        this.searchStudiesSearchResultsDbIdGetParametersInstance.getPage(),
                    /* pageSize => */
                        this.searchStudiesSearchResultsDbIdGetParametersInstance.getPageSize(),
                    /* authorization => */ this.authorization          (),
                    /* callback      => */ this.studiesResponseCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .SearchStudiesSearchResultsDbIdGetAlertDialog searchStudiesSearchResultsDbIdGetAlertDialog()
    {
        if (null == this.searchStudiesSearchResultsDbIdGetAlertDialogInstance)
            this.searchStudiesSearchResultsDbIdGetAlertDialogInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .SearchStudiesSearchResultsDbIdGetAlertDialog(this.getActivity(),
                        new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                            .SearchStudiesSearchResultsDbIdGetAlertDialog.Handler()
                            {
                                @java.lang.Override public void handleDone()
                                {
                                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                        .Fragment.this.searchStudiesSearchResultsDbIdGet();
                                }
                            });
        return this.searchStudiesSearchResultsDbIdGetAlertDialogInstance;
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .SearchStudiesSearchResultsDbIdGetAlertDialog.Parameters
    searchStudiesSearchResultsDbIdGetParameters()
    {
        if (null == this.searchStudiesSearchResultsDbIdGetParametersInstance)
            this.searchStudiesSearchResultsDbIdGetParametersInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .SearchStudiesSearchResultsDbIdGetAlertDialog.Parameters();
        return this.searchStudiesSearchResultsDbIdGetParametersInstance;
    }

    private void showSearchStudiesSearchResultsDbIdGetAlertDialog()
    {
        this.searchStudiesSearchResultsDbIdGetAlertDialog().show(
            this.searchStudiesSearchResultsDbIdGetParameters());
    }
    // endregion

    // region seasonsGet() Private Methods
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
    io.swagger.client.model.SeasonsResponse> seasonsResponseCallback()
    {
        if (null == this.seasonsResponseCallbackInstance) this.seasonsResponseCallbackInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
                io.swagger.client.model.SeasonsResponse>() {};
        return this.seasonsResponseCallbackInstance;
    }

    private void seasonsGet()
    {
        if (null != this.seasonsGetAlertDialogParametersInstance)
            try
            {
                this.studiesApi().seasonsGetAsync(
                    /* seasonDbId => */
                        this.seasonsGetAlertDialogParametersInstance.getSeasonDbId(),
                    /* season   => */ this.seasonsGetAlertDialogParametersInstance.getSeason  (),
                    /* year     => */ this.seasonsGetAlertDialogParametersInstance.getYear    (),
                    /* page     => */ this.seasonsGetAlertDialogParametersInstance.getPage    (),
                    /* pageSize => */ this.seasonsGetAlertDialogParametersInstance.getPageSize(),
                    /* authorization => */ this.authorization          (),
                    /* callback      => */ this.seasonsResponseCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog
    seasonsGetAlertDialog()
    {
        if (null == this.seasonsGetAlertDialogInstance) this.seasonsGetAlertDialogInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog(
                this.getActivity(), new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .SeasonsGetAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                .Fragment.this.seasonsGet();
                        }
                    });
        return this.seasonsGetAlertDialogInstance;
    }

    private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog.Parameters
    seasonsGetAlertDialogParameters()
    {
        if (null == this.seasonsGetAlertDialogParametersInstance)
            this.seasonsGetAlertDialogParametersInstance = new org.wheatgenetics
                .androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog.Parameters();
        return this.seasonsGetAlertDialogParametersInstance;
    }

    private void showSeasonsGetAlertDialog()
    { this.seasonsGetAlertDialog().show(this.seasonsGetAlertDialogParameters()); }
    // endregion

    // region studiesGet() Private Methods
    private void studiesGet()
    {
        if (null != this.studiesGetAlertDialogParametersInstance)
            try
            {
                this.studiesApi().studiesGetAsync(
                    /* commonCropName => */
                        this.studiesGetAlertDialogParametersInstance.getCommonCropName(),
                    /* studyType     => */null,
                    /* studyTypeDbId => */
                        this.studiesGetAlertDialogParametersInstance.getStudyTypeDbId(),
                    /* programDbId => */
                        this.studiesGetAlertDialogParametersInstance.getProgramDbId(),
                    /* locationDbId => */
                        this.studiesGetAlertDialogParametersInstance.getLocationDbId(),
                    /* seasonDbId => */
                        this.studiesGetAlertDialogParametersInstance.getSeasonDbId(),
                    /* trialDbId => */ this.studiesGetAlertDialogParametersInstance.getTrialDbId(),
                    /* studyDbId => */ this.studiesGetAlertDialogParametersInstance.getStudyDbId(),
                    /* germplasmDbIds           => */null,
                    /* observationVariableDbIds => */null,
                    /* active    => */ this.studiesGetAlertDialogParametersInstance.getActive   (),
                    /* sortBy    => */ this.studiesGetAlertDialogParametersInstance.getSortBy   (),
                    /* sortOrder => */ this.studiesGetAlertDialogParametersInstance.getSortOrder(),
                    /* page      => */ this.studiesGetAlertDialogParametersInstance.getPage     (),
                    /* pageSize  => */ this.studiesGetAlertDialogParametersInstance.getPageSize (),
                    /* authorization => */ this.authorization          (),
                    /* callback      => */ this.studiesResponseCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
    studiesGetAlertDialog()
    {
        if (null == this.studiesGetAlertDialogInstance) this.studiesGetAlertDialogInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog(
                this.getActivity(), new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .StudiesGetAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                .Fragment.this.studiesGet();
                        }
                    });
        return this.studiesGetAlertDialogInstance;
    }

    private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog.Parameters
    studiesGetAlertDialogParameters()
    {
        if (null == this.studiesGetAlertDialogParametersInstance)
            this.studiesGetAlertDialogParametersInstance = new org.wheatgenetics
                .androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog.Parameters();
        return this.studiesGetAlertDialogParametersInstance;
    }

    private void showStudiesGetAlertDialog()
    { this.studiesGetAlertDialog().show(this.studiesGetAlertDialogParameters());}
    // endregion

    // region studiesStudyDbIdGet() Private Methods
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
    io.swagger.client.model.StudyResponse> studyResponseCallback()
    {
        if (null == this.studyResponseCallbackInstance) this.studyResponseCallbackInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
                io.swagger.client.model.StudyResponse>() {};
        return this.studyResponseCallbackInstance;
    }

    private void studiesStudyDbIdGet()
    {
        if (null != this.studiesStudyDbIdGetParametersInstance)
            try
            {
                this.studiesApi().studiesStudyDbIdGetAsync(
                    /* studyDbId => */ this.studiesStudyDbIdGetParametersInstance.getStudyDbId(),
                    /* authorization => */ this.authorization        (),
                    /* callback      => */ this.studyResponseCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdGetAlertDialog
    studiesStudyDbIdGetAlertDialog()
    {
        if (null == this.studiesStudyDbIdGetAlertDialogInstance)
            this.studiesStudyDbIdGetAlertDialogInstance = new org.wheatgenetics
                .androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdGetAlertDialog(
                this.getActivity(), new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .StudiesStudyDbIdGetAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                .Fragment.this.studiesStudyDbIdGet();
                        }
                    });
        return this.studiesStudyDbIdGetAlertDialogInstance;
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .StudiesStudyDbIdGetAlertDialog.Parameters studiesStudyDbIdGetParameters()
    {
        if (null == this.studiesStudyDbIdGetParametersInstance)
            this.studiesStudyDbIdGetParametersInstance = new org.wheatgenetics
                .androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdGetAlertDialog.Parameters();
        return this.studiesStudyDbIdGetParametersInstance;
    }

    private void showStudiesStudyDbIdGetAlertDialog()
    { this.studiesStudyDbIdGetAlertDialog().show(this.studiesStudyDbIdGetParameters()); }
    // endregion

    // region studiesStudyDbIdGermplasmGet(), studiesStudyDbIdLayoutsGet() and studiesStudyDbIdObservationvariablesGet() Private Method
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .StudyDbIdPagePageSizeAlertDialog.Parameters studyDbIdPagePageSizeParameters()
    {
        if (null == this.studyDbIdPagePageSizeParametersInstance)
            this.studyDbIdPagePageSizeParametersInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .StudyDbIdPagePageSizeAlertDialog.Parameters();
        return this.studyDbIdPagePageSizeParametersInstance;
    }
    // endregion

    // region studiesStudyDbIdGermplasmGet() Private Methods
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
    io.swagger.client.model.GermplasmSummaryListResponse> germplasmSummaryListResponseCallback()
    {
        if (null == this.germplasmSummaryListResponseCallbackInstance)
            this.germplasmSummaryListResponseCallbackInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
                    io.swagger.client.model.GermplasmSummaryListResponse>() {};
        return this.germplasmSummaryListResponseCallbackInstance;
    }

    private void studiesStudyDbIdGermplasmGet()
    {
        if (null != this.studyDbIdPagePageSizeParametersInstance)
            try
            {
                this.studiesApi().studiesStudyDbIdGermplasmGetAsync(
                    /* studyDbId => */ this.studyDbIdPagePageSizeParametersInstance.getStudyDbId(),
                    /* page      => */ this.studyDbIdPagePageSizeParametersInstance.getPage     (),
                    /* pageSize  => */ this.studyDbIdPagePageSizeParametersInstance.getPageSize (),
                    /* authorization => */ this.authorization                       (),
                    /* callback      => */ this.germplasmSummaryListResponseCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog
    studiesStudyDbIdGermplasmGetAlertDialog()
    {
        if (null == this.studiesStudyDbIdGermplasmGetAlertDialogInstance)
            this.studiesStudyDbIdGermplasmGetAlertDialogInstance = new org.wheatgenetics
                .androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog(
                    this.getActivity(), new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                        .StudyDbIdPagePageSizeAlertDialog.Handler()
                        {
                            @java.lang.Override public void handleDone()
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                    .Fragment.this.studiesStudyDbIdGermplasmGet();
                            }
                        },"StudiesApi.studiesStudyDbIdGermplasmGet()");
        return this.studiesStudyDbIdGermplasmGetAlertDialogInstance;
    }

    private void showStudiesStudyDbIdGermplasmGetAlertDialog()
    { this.studiesStudyDbIdGermplasmGetAlertDialog().show(this.studyDbIdPagePageSizeParameters()); }
    // endregion

    // region studiesStudyDbIdLayoutsGet() Private Methods
    private void setStudiesStudyDbIdLayoutsPutButtonEnabled(final boolean enabled)
    {
        this.setPutButtonEnabled(this.studiesStudyDbIdLayoutsPutButton, enabled);
        this.disablePutButton   (this.studiesStudyDbIdObservationsPutButton    );
        this.disablePutButton   (this.studiesStudyDbIdObservationunitsPutButton);
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
    io.swagger.client.model.ObservationUnitPositionsResponse> studiesStudyDbIdLayoutsGetCallback()
    {
        if (null == this.studiesStudyDbIdLayoutsGetCallbackInstance)
            this.studiesStudyDbIdLayoutsGetCallbackInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3
                    .studies.Fragment.StudiesStudyDbIdLayoutsGetCallback();
        return this.studiesStudyDbIdLayoutsGetCallbackInstance;
    }

    private void studiesStudyDbIdLayoutsGet()
    {
        if (null != this.studyDbIdPagePageSizeParametersInstance)
            try
            {
                this.studiesApi().studiesStudyDbIdLayoutsGetAsync(
                    /* studyDbId => */ this.studyDbIdPagePageSizeParametersInstance.getStudyDbId(),
                    /* page      => */ this.studyDbIdPagePageSizeParametersInstance.getPage     (),
                    /* pageSize  => */ this.studyDbIdPagePageSizeParametersInstance.getPageSize (),
                    /* authorization => */ this.authorization                     (),
                    /* callback      => */ this.studiesStudyDbIdLayoutsGetCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog
    studiesStudyDbIdLayoutsGetAlertDialog()
    {
        if (null == this.studiesStudyDbIdLayoutsGetAlertDialogInstance)
            this.studiesStudyDbIdLayoutsGetAlertDialogInstance = new org.wheatgenetics
                .androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog(
                    this.getActivity(), new org.wheatgenetics.androidlibrarybuilder
                    .brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                .Fragment.this.studiesStudyDbIdLayoutsGet();
                        }
                    },"StudiesApi.studiesStudyDbIdLayoutsGet()");
        return this.studiesStudyDbIdLayoutsGetAlertDialogInstance;
    }

    private void showStudiesStudyDbIdLayoutsGetAlertDialog()
    { this.studiesStudyDbIdLayoutsGetAlertDialog().show(this.studyDbIdPagePageSizeParameters()); }
    // endregion

    // region studiesStudyDbIdLayoutsPut() Private Methods
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .Fragment.StudiesStudyDbIdLayoutsPutCallback studiesStudyDbIdLayoutsPutCallback()
    {
        if (null == this.studiesStudyDbIdLayoutsPutCallbackInstance)
            this.studiesStudyDbIdLayoutsPutCallbackInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .Fragment.StudiesStudyDbIdLayoutsPutCallback();
        return this.studiesStudyDbIdLayoutsPutCallbackInstance;
    }

    private void studiesStudyDbIdLayoutsPut(
    final io.swagger.client.model.StudyLayoutRequest studyLayoutRequest)
    {
        if (null != studyLayoutRequest)
            try
            {
                this.studiesApi().studiesStudyDbIdLayoutsPutAsync(
                    /* studyDbId => */ this.studyDbIdPagePageSizeParametersInstance.getStudyDbId(),
                    /* StudyLayoutRequest => */ studyLayoutRequest                       ,
                    /* authorization      => */ this.authorization                     (),
                    /* callback           => */ this.studiesStudyDbIdLayoutsPutCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private android.content.Intent studyLayoutRequestListIntent()
    {
        if (null == this.studyLayoutRequestListIntentInstance)
            this.studyLayoutRequestListIntentInstance = new android.content.Intent(
                this.getActivity()                                                     ,
                org.wheatgenetics.brapi1_3.studies.StudyLayoutRequestListActivity.class);
        return this.studyLayoutRequestListIntentInstance;
    }

    private void showStudyLayoutRequestListActivity()
    {
        this.startActivityForResult(this.studyLayoutRequestListIntent(),
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
                .STUDY_LAYOUT_REQUEST_LIST_ACTIVITY_REQUEST_CODE);
    }
    // endregion

    // region studiesStudyDbIdObservationsGet() Private Methods
    private void setStudiesStudyDbIdObservationsPutButtonEnabled(final boolean enabled)
    {
        this.disablePutButton   (this.studiesStudyDbIdLayoutsPutButton              );
        this.setPutButtonEnabled(this.studiesStudyDbIdObservationsPutButton, enabled);
        this.disablePutButton   (this.studiesStudyDbIdObservationunitsPutButton     );
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
    io.swagger.client.model.ObservationsResponse> observationsResponseCallback()
    {
        if (null == this.observationsResponseCallbackInstance)
            this.observationsResponseCallbackInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
                    io.swagger.client.model.ObservationsResponse>()
                    {
                        @java.lang.Override @android.support.annotation.RestrictTo(
                            android.support.annotation.RestrictTo.Scope.SUBCLASSES)
                        protected void handleSuccess(
                            final io.swagger.client.model.ObservationsResponse result)
                        {
                            {
                                final boolean enableStudiesStudyDbIdObservationsPutButton;
                                {
                                    final org.wheatgenetics.brapi1_3.studies.Application
                                        application = org.wheatgenetics.androidlibrarybuilder
                                            .brapi1_3.studies.Fragment.this.application();
                                    if (null == application)
                                        enableStudiesStudyDbIdObservationsPutButton = false;
                                    else
                                    {
                                        application.makeNewObservationsRequest(result);

                                        final org.wheatgenetics.javalib.mstrdtl.Items items =
                                            application.mstrdtlItems();
                                        // noinspection SimplifiableConditionalExpression
                                        enableStudiesStudyDbIdObservationsPutButton =
                                            null == items ? false : items.size() > 0;
                                    }
                                }
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.
                                    Fragment.this.setStudiesStudyDbIdObservationsPutButtonEnabled(
                                        enableStudiesStudyDbIdObservationsPutButton);
                            }
                            super.handleSuccess(result);
                        }
                    };
        return this.observationsResponseCallbackInstance;
    }

    private void studiesStudyDbIdObservationsGet()
    {
        if (null != this.studiesStudyDbIdObservationsGetParametersInstance)
            try
            {
                this.studiesApi().studiesStudyDbIdObservationsGetAsync(
                    /* studyDbId => */
                        this.studiesStudyDbIdObservationsGetParametersInstance.getStudyDbId(),
                    /* observationVariableDbIds => */
                        this.studiesStudyDbIdObservationsGetParametersInstance
                            .getObservationVariableDbIds(),
                    /* page => */
                        this.studiesStudyDbIdObservationsGetParametersInstance.getPage(),
                    /* pageSize => */
                        this.studiesStudyDbIdObservationsGetParametersInstance.getPageSize(),
                    /* authorization => */ this.authorization               (),
                    /* callback      => */ this.observationsResponseCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .StudiesStudyDbIdObservationsGetAlertDialog studiesStudyDbIdObservationsGetAlertDialog()
    {
        if (null == this.studiesStudyDbIdObservationsGetAlertDialogInstance)
            this.studiesStudyDbIdObservationsGetAlertDialogInstance = new org.wheatgenetics
                .androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdObservationsGetAlertDialog(
                    this.getActivity(), new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .StudiesStudyDbIdObservationsGetAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                .Fragment.this.studiesStudyDbIdObservationsGet();
                        }
                    });
        return this.studiesStudyDbIdObservationsGetAlertDialogInstance;
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .StudiesStudyDbIdObservationsGetAlertDialog.Parameters
    studiesStudyDbIdObservationsGetParameters()
    {
        if (null == this.studiesStudyDbIdObservationsGetParametersInstance)
            this.studiesStudyDbIdObservationsGetParametersInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .StudiesStudyDbIdObservationsGetAlertDialog.Parameters();
        return this.studiesStudyDbIdObservationsGetParametersInstance;
    }

    private void showStudiesStudyDbIdObservationsGetAlertDialog()
    {
        this.studiesStudyDbIdObservationsGetAlertDialog().show(
            this.studiesStudyDbIdObservationsGetParameters());
    }
    // endregion

    // region studiesStudyDbIdObservationsPut() Private Methods
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
    io.swagger.client.model.NewObservationDbIdsResponse> newObservationDbIdsResponseCallback()
    {
        if (null == this.newObservationDbIdsResponseCallbackInstance)
            this.newObservationDbIdsResponseCallbackInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
                    io.swagger.client.model.NewObservationDbIdsResponse>() {};
        return this.newObservationDbIdsResponseCallbackInstance;
    }

    private void studiesStudyDbIdObservationsPut(
    final io.swagger.client.model.NewObservationsRequest newObservationsRequest)
    {
        if (null != newObservationsRequest)
            try
            {
                this.studiesApi().studiesStudyDbIdObservationsPutAsync(
                    /* studyDbId => */
                        this.studiesStudyDbIdObservationsGetParametersInstance.getStudyDbId(),
                    /* body          => */ newObservationsRequest                    ,
                    /* authorization => */ this.authorization                      (),
                    /* callback      => */ this.newObservationDbIdsResponseCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private android.content.Intent newObservationsRequestListIntent()
    {
        if (null == this.newObservationsRequestListIntentInstance)
            this.newObservationsRequestListIntentInstance = new android.content.Intent(
                this.getActivity()                                                         ,
                org.wheatgenetics.brapi1_3.studies.NewObservationsRequestListActivity.class);
        return this.newObservationsRequestListIntentInstance;
    }

    private void showNewObservationsRequestListActivity()
    {
        this.startActivityForResult(this.newObservationsRequestListIntent(),
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
                .NEW_OBSERVATIONS_REQUEST_LIST_ACTIVITY_REQUEST_CODE);
    }
    // endregion

    // region studiesStudyDbIdObservationunitsGet() Private Methods
    private void setStudiesStudyDbIdObservationunitsPutButtonEnabled(final boolean enabled)
    {
        this.disablePutButton   (this.studiesStudyDbIdLayoutsPutButton                  );
        this.disablePutButton   (this.studiesStudyDbIdObservationsPutButton             );
        this.setPutButtonEnabled(this.studiesStudyDbIdObservationunitsPutButton, enabled);
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
    io.swagger.client.model.ObservationUnitsResponse1> observationUnitsResponse1Callback()
    {
        if (null == this.observationUnitsResponse1CallbackInstance)
            this.observationUnitsResponse1CallbackInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
                    io.swagger.client.model.ObservationUnitsResponse1>()
                {
                    @java.lang.Override @android.support.annotation.RestrictTo(
                        android.support.annotation.RestrictTo.Scope.SUBCLASSES)
                    protected void handleSuccess(
                        final io.swagger.client.model.ObservationUnitsResponse1 result)
                    {
                        {
                            final boolean enableStudiesStudyDbIdObservationunitsPutButton;
                            {
                                final org.wheatgenetics.brapi1_3.studies.Application
                                    application = org.wheatgenetics.androidlibrarybuilder
                                        .brapi1_3.studies.Fragment.this.application();
                                if (null == application)
                                    enableStudiesStudyDbIdObservationunitsPutButton = false;
                                else
                                {
                                    // TODO application.makeNewObservationUnitRequests(result);

                                    final org.wheatgenetics.javalib.mstrdtl.Items items =
                                        application.mstrdtlItems();
                                    // noinspection SimplifiableConditionalExpression
                                    enableStudiesStudyDbIdObservationunitsPutButton =
                                        null == items ? false : items.size() > 0;
                                }
                            }
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.
                                Fragment.this.setStudiesStudyDbIdObservationunitsPutButtonEnabled(
                                    enableStudiesStudyDbIdObservationunitsPutButton);
                        }
                        super.handleSuccess(result);
                    }
                };
        return this.observationUnitsResponse1CallbackInstance;
    }

    private void studiesStudyDbIdObservationunitsGet()
    {
        if (null != this.studiesStudyDbIdObservationunitsGetParametersInstance)
            try
            {
                this.studiesApi().studiesStudyDbIdObservationunitsGetAsync(
                    /* studyDbId => */
                        this.studiesStudyDbIdObservationunitsGetParametersInstance.getStudyDbId(),
                    /* observationLevel => */
                        this.studiesStudyDbIdObservationunitsGetParametersInstance
                            .getObservationLevel(),
                    /* page => */
                        this.studiesStudyDbIdObservationunitsGetParametersInstance.getPage(),
                    /* pageSize => */
                        this.studiesStudyDbIdObservationunitsGetParametersInstance.getPageSize(),
                    /* authorization => */ this.authorization                    (),
                    /* callback      => */ this.observationUnitsResponse1Callback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .StudiesStudyDbIdObservationunitsGetAlertDialog
    studiesStudyDbIdObservationunitsGetAlertDialog()
    {
        if (null == this.studiesStudyDbIdObservationunitsGetAlertDialogInstance)
            this.studiesStudyDbIdObservationunitsGetAlertDialogInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .StudiesStudyDbIdObservationunitsGetAlertDialog(this.getActivity(),
                        new org.wheatgenetics.brapi1_3.AlertDialog.Handler()
                        {
                            @java.lang.Override public void handleDone()
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                    .Fragment.this.studiesStudyDbIdObservationunitsGet();
                            }
                        });
        return this.studiesStudyDbIdObservationunitsGetAlertDialogInstance;
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .StudiesStudyDbIdObservationunitsGetAlertDialog.Parameters
    studiesStudyDbIdObservationunitsGetParameters()
    {
        if (null == this.studiesStudyDbIdObservationunitsGetParametersInstance)
            this.studiesStudyDbIdObservationunitsGetParametersInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .StudiesStudyDbIdObservationunitsGetAlertDialog.Parameters();
        return this.studiesStudyDbIdObservationunitsGetParametersInstance;
    }

    private void showStudiesStudyDbIdObservationUnitsGetAlertDialog()
    {
        this.studiesStudyDbIdObservationunitsGetAlertDialog().show(
            this.studiesStudyDbIdObservationunitsGetParameters());
    }
    // endregion

    // region studiesStudyDbIdObservationvariablesGet() Private Methods
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
    io.swagger.client.model.StudyObservationVariablesResponse>
    studyObservationVariablesResponseCallback()
    {
        if (null == this.studyObservationVariablesResponseCallbackInstance)
            this.studyObservationVariablesResponseCallbackInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
                    io.swagger.client.model.StudyObservationVariablesResponse>() {};
        return this.studyObservationVariablesResponseCallbackInstance;
    }

    private void studiesStudyDbIdObservationvariablesGet()
    {
        if (null != this.studyDbIdPagePageSizeParametersInstance)
            try
            {
                this.studiesApi().studiesStudyDbIdObservationvariablesGetAsync(
                    /* studyDbId => */ this.studyDbIdPagePageSizeParametersInstance.getStudyDbId(),
                    /* page      => */ this.studyDbIdPagePageSizeParametersInstance.getPage     (),
                    /* pageSize  => */ this.studyDbIdPagePageSizeParametersInstance.getPageSize (),
                    /* authorization => */ this.authorization                            (),
                    /* callback      => */ this.studyObservationVariablesResponseCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog
    studiesStudyDbIdObservationvariablesGetAlertDialog()
    {
        if (null == this.studiesStudyDbIdObservationvariablesGetAlertDialogInstance)
            this.studiesStudyDbIdObservationvariablesGetAlertDialogInstance = new org.wheatgenetics
                .androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog(
                    this.getActivity(), new org.wheatgenetics.androidlibrarybuilder
                    .brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog.Handler()
                    {
                        @java.lang.Override public void handleDone()
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                .Fragment.this.studiesStudyDbIdObservationvariablesGet();
                        }
                    },"StudiesApi.studiesStudyDbIdObservationvariablesGet()");
        return this.studiesStudyDbIdObservationvariablesGetAlertDialogInstance;
    }

    private void showStudiesStudyDbIdObservationvariablesGetAlertDialog()
    {
        this.studiesStudyDbIdObservationvariablesGetAlertDialog().show(
            this.studyDbIdPagePageSizeParameters());
    }
    // endregion

    // region studytypesGet() Private Methods
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
    io.swagger.client.model.StudyTypesResponse> studyTypesResponseCallback()
    {
        if (null == this.studyTypesResponseCallbackInstance)
            this.studyTypesResponseCallbackInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.ApiCallback<
                    io.swagger.client.model.StudyTypesResponse>() {};
        return this.studyTypesResponseCallbackInstance;
    }

    private void studytypesGet()
    {
        if (null != this.studytypesGetParametersInstance)
            try
            {
                this.studiesApi().studytypesGetAsync(
                    /* studyTypeDbId => */ this.studytypesGetParametersInstance.getStudyTypeDbId(),
                    /* page          => */ this.studytypesGetParametersInstance.getPage         (),
                    /* pageSize      => */ this.studytypesGetParametersInstance.getPageSize     (),
                    /* authorization => */ this.authorization                                   (),
                    /* callback      => */ this.studyTypesResponseCallback                      ());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewTextFromThread(t); }
    }

    private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudytypesGetAlertDialog
    studytypesGetAlertDialog()
    {
        if (null == this.studytypesGetAlertDialogInstance) this.studytypesGetAlertDialogInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudytypesGetAlertDialog(
                this.getActivity(), new org.wheatgenetics.androidlibrarybuilder
                .brapi1_3.studies.StudytypesGetAlertDialog.Handler()
                {
                    @java.lang.Override public void handleDone()
                    {
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3
                            .studies.Fragment.this.studytypesGet();
                    }
                });
        return this.studytypesGetAlertDialogInstance;
    }

    private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudytypesGetAlertDialog.Parameters
    studytypesGetParameters()
    {
        if (null == this.studytypesGetParametersInstance) this.studytypesGetParametersInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.StudytypesGetAlertDialog.Parameters();
        return this.studytypesGetParametersInstance;
    }

    private void showStudytypesGetAlertDialog()
    { this.studytypesGetAlertDialog().show(this.studytypesGetParameters()); }
    // endregion
    // endregion

    public Fragment() {}

    // region Overridden Method
    @java.lang.Override @android.support.annotation.Nullable public android.view.View onCreateView(
    @android.support.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @android.support.annotation.Nullable final android.view.ViewGroup      container         ,
    @android.support.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = this.inflate(inflater, container,
            org.wheatgenetics.androidlibrarybuilder.R.layout.fragment_brapi1_3_studies);
        if (null != rootView)
        {
            // The following eighteen ids are from fragment_brapi1_3_studies.xml.
            {
                final android.widget.Button searchStudiesPostButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.searchStudiesPostButton);
                if (null != searchStudiesPostButton) searchStudiesPostButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
                                .this.showStudySearchRequestAlertDialog();
                        }
                    });
            }
            {
                final android.widget.Button searchStudiesSearchResultsDbIdGetButton =
                    rootView.findViewById(org.wheatgenetics.androidlibrarybuilder
                        .R.id.searchStudiesSearchResultsDbIdGetButton);
                if (null != searchStudiesSearchResultsDbIdGetButton)
                    searchStudiesSearchResultsDbIdGetButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
                                    .this.showSearchStudiesSearchResultsDbIdGetAlertDialog();
                            }
                        });
            }
            {
                final android.widget.Button seasonsGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.seasonsGetButton);
                if (null != seasonsGetButton) seasonsGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
                                .this.showSeasonsGetAlertDialog();
                        }
                    });
            }
            {
                final android.widget.Button studiesGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.studiesGetButton);
                if (null != studiesGetButton) studiesGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
                                .this.showStudiesGetAlertDialog();
                        }
                    });
            }
            {
                final android.widget.Button studiesStudyDbIdGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudyDbIdGetButton);
                if (null != studiesStudyDbIdGetButton) studiesStudyDbIdGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
                                .this.showStudiesStudyDbIdGetAlertDialog();
                        }
                    });
            }
            {
                final android.widget.Button studiesStudyDbIdGermplasmGetButton =
                    rootView.findViewById(org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudyDbIdGermplasmGetButton);
                if (null != studiesStudyDbIdGermplasmGetButton)
                    studiesStudyDbIdGermplasmGetButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                    .Fragment.this.showStudiesStudyDbIdGermplasmGetAlertDialog();
                            }
                        });
            }
            {
                final android.widget.Button studiesStudyDbIdLayoutsGetButton =
                    rootView.findViewById(org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudyDbIdLayoutsGetButton);
                if (null != studiesStudyDbIdLayoutsGetButton)
                    studiesStudyDbIdLayoutsGetButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                    .Fragment.this.showStudiesStudyDbIdLayoutsGetAlertDialog();
                            }
                        });
            }
            {
                this.studiesStudyDbIdLayoutsPutButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudyDbIdLayoutsPutButton);
                if (null != this.studiesStudyDbIdLayoutsPutButton)
                    this.studiesStudyDbIdLayoutsPutButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                    .Fragment.this.showStudyLayoutRequestListActivity();
                            }
                        });
            }
            {
                final android.widget.Button studiesStudyDbIdObservationsGetButton =
                    rootView.findViewById(org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudyDbIdObservationsGetButton);
                if (null != studiesStudyDbIdObservationsGetButton)
                    studiesStudyDbIdObservationsGetButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                    .Fragment.this.showStudiesStudyDbIdObservationsGetAlertDialog();
                            }
                        });
            }
            {
                this.studiesStudyDbIdObservationsPutButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudyDbIdObservationsPutButton);
                if (null != this.studiesStudyDbIdObservationsPutButton)
                    this.studiesStudyDbIdObservationsPutButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                    .Fragment.this.showNewObservationsRequestListActivity();
                            }
                        });
            }
            {
                final android.widget.Button studiesStudyDbIdObservationunitsGetButton =
                    rootView.findViewById(org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudyDbIdObservationunitsGetButton);
                if (null != studiesStudyDbIdObservationunitsGetButton)
                    studiesStudyDbIdObservationunitsGetButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
                                    .this.showStudiesStudyDbIdObservationUnitsGetAlertDialog();
                            }
                        });
            }
            {
                this.studiesStudyDbIdObservationunitsPutButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudyDbIdObservationunitsPutButton);
                if (null != this.studiesStudyDbIdObservationunitsPutButton)
                    this.studiesStudyDbIdObservationunitsPutButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        { @java.lang.Override public void onClick(final android.view.View v) {} });
            }
            {
                final android.widget.Button studiesStudyDbIdObservationunitsZipPostButton =
                    rootView.findViewById(org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudyDbIdObservationunitsZipPostButton);
                if (null != studiesStudyDbIdObservationunitsZipPostButton)
                    studiesStudyDbIdObservationunitsZipPostButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        { @java.lang.Override public void onClick(final android.view.View v) {} });
            }
            {
                final android.widget.Button studiesStudyDbIdObservationvariablesGetButton =
                    rootView.findViewById(org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudyDbIdObservationvariablesGetButton);
                if (null != studiesStudyDbIdObservationvariablesGetButton)
                    studiesStudyDbIdObservationvariablesGetButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
                                    .this.showStudiesStudyDbIdObservationvariablesGetAlertDialog();
                            }
                        });
            }
            {
                final android.widget.Button studiesStudyDbIdTableGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudyDbIdTableGetButton);
                if (null != studiesStudyDbIdTableGetButton)
                    studiesStudyDbIdTableGetButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        { @java.lang.Override public void onClick(final android.view.View v) {} });
            }
            {
                final android.widget.Button studiesStudyDbIdTablePostButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudyDbIdTablePostButton);
                if (null != studiesStudyDbIdTablePostButton)
                    studiesStudyDbIdTablePostButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    { @java.lang.Override public void onClick(final android.view.View v) {} });
            }
            {
                final android.widget.Button studytypesGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.studytypesGetButton);
                if (null != studytypesGetButton) studytypesGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
                                .this.showStudytypesGetAlertDialog();
                        }
                    });
            }
            this.findResponseTextViewById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesResponseTextView);
        }
        return rootView;
    }

    @java.lang.Override public void onActivityResult(final int requestCode,
    final int resultCode, final android.content.Intent data)
    {
        switch (requestCode)
        {
            case org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
            .STUDY_LAYOUT_REQUEST_LIST_ACTIVITY_REQUEST_CODE:
                {
                    final org.wheatgenetics.javalib.mstrdtl.Items items = this.items();
                    if (null != items) this.studiesStudyDbIdLayoutsPut(
                        (io.swagger.client.model.StudyLayoutRequest) items);
                } break;

            case org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
            .NEW_OBSERVATIONS_REQUEST_LIST_ACTIVITY_REQUEST_CODE:
                {
                    final org.wheatgenetics.javalib.mstrdtl.Items items = this.items();
                    if (null != items) this.studiesStudyDbIdObservationsPut(
                        (io.swagger.client.model.NewObservationsRequest) items);
                } break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    // endregion
}