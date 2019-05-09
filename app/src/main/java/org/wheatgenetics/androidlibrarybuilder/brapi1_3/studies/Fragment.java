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
 * io.swagger.client.ApiCallback
 * io.swagger.client.ApiException
 * io.swagger.client.api.StudiesApi
 * io.swagger.client.model.GermplasmSummaryListResponse
 * io.swagger.client.model.ObservationUnitPositionsResponse
 * io.swagger.client.model.SeasonsResponse
 * io.swagger.client.model.StudiesResponse
 * io.swagger.client.model.StudyLayoutRequest
 * io.swagger.client.model.StudyResponse
 * io.swagger.client.model.StudySearchRequest
 * io.swagger.client.model.SuccessfulSearchResponse
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.ItemsProvider
 *
 * org.wheatgenetics.brapi1_3.studies.Application
 * org.wheatgenetics.brapi1_3.studies.ListActivity
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
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .StudyDbIdPagePageSizeAlertDialog.Parameters
 */
public class Fragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
{
    // region Types
    @java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
    private class StudiesStudyDbIdLayoutsPutCallback extends java.lang.Object implements
    io.swagger.client.ApiCallback<io.swagger.client.model.ObservationUnitPositionsResponse>
    {
        // region Private Methods
        private void setResponseTextViewText(final
        io.swagger.client.model.ObservationUnitPositionsResponse observationUnitPositionsResponse)
        {
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.this
                .setResponseTextViewTextFromThread(null == observationUnitPositionsResponse ?
                    "null" : observationUnitPositionsResponse.toString());
        }

        @android.support.annotation.RestrictTo(
            android.support.annotation.RestrictTo.Scope.SUBCLASSES)
        void handleSuccess(final
        io.swagger.client.model.ObservationUnitPositionsResponse observationUnitPositionsResponse)
        { this.setResponseTextViewText(observationUnitPositionsResponse); }
        // endregion

        // region Overridden Methods
        @java.lang.Override public void onFailure(final io.swagger.client.ApiException e,
        final int i, final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
        {
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .Fragment.this.setResponseTextViewTextFromThread(e);
        }

        @java.lang.Override public void onSuccess(
        final io.swagger.client.model.ObservationUnitPositionsResponse
            observationUnitPositionsResponse,
        final int i, final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
        { this.handleSuccess(observationUnitPositionsResponse) /* polymorphism */; }

        @java.lang.Override public void onUploadProgress(
        final long l, final long l1, final boolean b) {}

        @java.lang.Override public void onDownloadProgress(
        final long l, final long l1, final boolean b) {}
        // endregion
    }

    private class StudiesStudyDbIdLayoutsGetCallback extends org.wheatgenetics
    .androidlibrarybuilder.brapi1_3.studies.Fragment.StudiesStudyDbIdLayoutsPutCallback
    {
        @java.lang.Override void handleSuccess(final
        io.swagger.client.model.ObservationUnitPositionsResponse observationUnitPositionsResponse)
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
                        application.makeStudyLayoutRequest(observationUnitPositionsResponse);

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
            super.handleSuccess(observationUnitPositionsResponse);
        }
    }
    // endregion

    private static final int LIST_ACTIVITY_REQUEST_CODE = 1000;

    // region Fields
    private io.swagger.client.api.StudiesApi studiesApiInstance = null;                 // lazy load

    // region searchStudiesPost() Fields
    private org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog
        studySearchRequestAlertDialogInstance = null;                                   // lazy load
    private io.swagger.client.model.StudySearchRequest studySearchRequestInstance = null;      // ll
    private io.swagger.client.ApiCallback<io.swagger.client.model.SuccessfulSearchResponse>
        successfulSearchResponseCallbackInstance = null;                                // lazy load
    // endregion

    // region searchStudiesSearchResultsDbIdGet() and studiesGet() Field
    private io.swagger.client.ApiCallback<io.swagger.client.model.StudiesResponse>
        studiesResponseCallbackInstance = null;                                         // lazy load
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
    private io.swagger.client.ApiCallback<io.swagger.client.model.SeasonsResponse>
        seasonsResponseCallbackInstance = null;                                         // lazy load
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
    private io.swagger.client.ApiCallback<io.swagger.client.model.StudyResponse>
        studyResponseCallbackInstance = null;                                           // lazy load
    // endregion

    // region studiesStudyDbIdGermplasmGet() and studiesStudyDbIdLayoutsGet() Field
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies                    // lazy load
        .StudyDbIdPagePageSizeAlertDialog.Parameters studyDbIdPagePageSizeParametersInstance = null;
    // endregion

    // region studiesStudyDbIdGermplasmGet() Fields
    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog
            studiesStudyDbIdGermplasmGetAlertDialogInstance = null;                     // lazy load
    private io.swagger.client.ApiCallback<io.swagger.client.model.GermplasmSummaryListResponse>
        germplasmSummaryListResponseCallbackInstance = null;                            // lazy load
    // endregion
    
    // region studiesStudyDbIdLayoutsGet() Fields
    private android.widget.Button                          studiesStudyDbIdLayoutsPutButton;
    private org.wheatgenetics.brapi1_3.studies.Application applicationInstance = null      ;   // ll
    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudyDbIdPagePageSizeAlertDialog
            studiesStudyDbIdLayoutsGetAlertDialogInstance = null;                       // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
        .StudiesStudyDbIdLayoutsGetCallback studiesStudyDbIdLayoutsGetCallbackInstance = null; // ll
    // endregion

    // region studiesStudyDbIdLayoutsPut() Field
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
        .StudiesStudyDbIdLayoutsPutCallback studiesStudyDbIdLayoutsPutCallbackInstance = null; // ll
    private android.content.Intent listIntentInstance = null;                           // lazy load
    // endregion
    // endregion

    // region Private Methods
    private io.swagger.client.api.StudiesApi studiesApi()
    {
        if (null == this.studiesApiInstance)
            this.studiesApiInstance = new io.swagger.client.api.StudiesApi(this.apiClient());
        return this.studiesApiInstance;
    }

    // region searchStudiesPost() Private Methods
    private void setResponseTextViewText(
    final io.swagger.client.model.SuccessfulSearchResponse successfulSearchResponse)
    {
        this.setResponseTextViewTextFromThread(
            null == successfulSearchResponse ? "null" : successfulSearchResponse.toString());
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.SuccessfulSearchResponse>
    successfulSearchResponseCallback()
    {
        if (null == this.successfulSearchResponseCallbackInstance)
            this.successfulSearchResponseCallbackInstance = new
                io.swagger.client.ApiCallback<io.swagger.client.model.SuccessfulSearchResponse>()
                {
                    @java.lang.Override public void onFailure(
                    final io.swagger.client.ApiException e, final int i,
                    final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                    {
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                            .Fragment.this.setResponseTextViewTextFromThread(e);
                    }

                    @java.lang.Override public void onSuccess(
                    final io.swagger.client.model.SuccessfulSearchResponse successfulSearchResponse,
                    final int                                                               i  ,
                    final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                    {
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                            .Fragment.this.setResponseTextViewText(successfulSearchResponse);
                    }

                    @java.lang.Override public void onUploadProgress(
                    final long l, final long l1, final boolean b) {}

                    @java.lang.Override public void onDownloadProgress(
                    final long l, final long l1, final boolean b) {}
                };
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

    // region searchStudiesSearchResultsDbIdGet() and studiesGet() Private Methods
    private void setResponseTextViewText(
    final io.swagger.client.model.StudiesResponse studiesResponse)
    {
        this.setResponseTextViewTextFromThread(
            null == studiesResponse ? "null" : studiesResponse.toString());
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.StudiesResponse>
    studiesResponseCallback()
    {
        if (null == this.studiesResponseCallbackInstance) this.studiesResponseCallbackInstance =
            new io.swagger.client.ApiCallback<io.swagger.client.model.StudiesResponse>()
            {
                @java.lang.Override public void onFailure(final io.swagger.client.ApiException e,
                final int                                                               i  ,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                        .Fragment.this.setResponseTextViewTextFromThread(e);
                }

                @java.lang.Override public void onSuccess(
                final io.swagger.client.model.StudiesResponse studiesResponse, final int i,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                        .Fragment.this.setResponseTextViewText(studiesResponse);
                }

                @java.lang.Override public void onUploadProgress(
                final long l, final long l1, final boolean b) {}

                @java.lang.Override public void onDownloadProgress(
                final long l, final long l1, final boolean b) {}
            };
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
    private void setResponseTextViewText(
    final io.swagger.client.model.SeasonsResponse studiesResponse)
    {
        this.setResponseTextViewTextFromThread(
            null == studiesResponse ? "null" : studiesResponse.toString());
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.SeasonsResponse>
    seasonsResponseCallback()
    {
        if (null == this.seasonsResponseCallbackInstance) this.seasonsResponseCallbackInstance =
            new io.swagger.client.ApiCallback<io.swagger.client.model.SeasonsResponse>()
            {
                @java.lang.Override public void onFailure(final io.swagger.client.ApiException e,
                final int                                                               i  ,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                        .Fragment.this.setResponseTextViewTextFromThread(e);
                }

                @java.lang.Override public void onSuccess(
                final io.swagger.client.model.SeasonsResponse seasonsResponse, final int i,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                        .Fragment.this.setResponseTextViewText(seasonsResponse);
                }

                @java.lang.Override public void onUploadProgress(
                final long l, final long l1, final boolean b) {}

                @java.lang.Override public void onDownloadProgress(
                final long l, final long l1, final boolean b) {}
            };
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
    private void setResponseTextViewText(final io.swagger.client.model.StudyResponse studyResponse)
    {
        this.setResponseTextViewTextFromThread(
            null == studyResponse ? "null" : studyResponse.toString());
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.StudyResponse>
    studyResponseCallback()
    {
        if (null == this.studyResponseCallbackInstance) this.studyResponseCallbackInstance =
            new io.swagger.client.ApiCallback<io.swagger.client.model.StudyResponse>()
            {
                @java.lang.Override public void onFailure(final io.swagger.client.ApiException e,
                final int                                                               i  ,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                        .Fragment.this.setResponseTextViewTextFromThread(e);
                }

                @java.lang.Override public void onSuccess(
                final io.swagger.client.model.StudyResponse studyResponse, final int i,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                        .Fragment.this.setResponseTextViewText(studyResponse);
                }

                @java.lang.Override public void onUploadProgress(
                final long l, final long l1, final boolean b) {}

                @java.lang.Override public void onDownloadProgress(
                final long l, final long l1, final boolean b) {}
            };
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

    // region studiesStudyDbIdGermplasmGet() and studiesStudyDbIdLayoutsGet() Private Method
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
    private void setResponseTextViewText(
    final io.swagger.client.model.GermplasmSummaryListResponse germplasmSummaryListResponse)
    {
        this.setResponseTextViewTextFromThread(null == germplasmSummaryListResponse ?
            "null" : germplasmSummaryListResponse.toString());
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.GermplasmSummaryListResponse>
    germplasmSummaryListCallback()
    {
        if (null == this.germplasmSummaryListResponseCallbackInstance)
            this.germplasmSummaryListResponseCallbackInstance = new io.swagger.client.ApiCallback<
                io.swagger.client.model.GermplasmSummaryListResponse>()
                {
                    @java.lang.Override public void onFailure(
                    final io.swagger.client.ApiException e, final int i,
                    final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                    {
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                            .Fragment.this.setResponseTextViewTextFromThread(e);
                    }

                    @java.lang.Override public void onSuccess(
                    final io.swagger.client.model.GermplasmSummaryListResponse
                        germplasmSummaryListResponse,
                    final int                                                               i  ,
                    final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                    {
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                            .Fragment.this.setResponseTextViewText(germplasmSummaryListResponse);
                    }

                    @java.lang.Override public void onUploadProgress(
                    final long l, final long l1, final boolean b) {}

                    @java.lang.Override public void onDownloadProgress(
                    final long l, final long l1, final boolean b) {}
                };
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
                    /* authorization => */ this.authorization               (),
                    /* callback      => */ this.germplasmSummaryListCallback());
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

    private void setStudiesStudyDbIdLayoutsPutButtonEnabled(final boolean enabled)
    {
        if (null != this.studiesStudyDbIdLayoutsPutButton)
        {
            final android.app.Activity activity = this.getActivity();
            if (null != activity) activity.runOnUiThread(new java.lang.Runnable()
                {
                    @java.lang.Override public void run()
                    {
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                            .Fragment.this.studiesStudyDbIdLayoutsPutButton.setEnabled(enabled);
                    }
                });
        }
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.ObservationUnitPositionsResponse>
    studiesStudyDbIdLayoutsGetCallback()
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
    private io.swagger.client.ApiCallback<io.swagger.client.model.ObservationUnitPositionsResponse>
    studiesStudyDbIdLayoutsPutCallback()
    {
        if (null == this.studiesStudyDbIdLayoutsPutCallbackInstance)
            this.studiesStudyDbIdLayoutsPutCallbackInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3
                    .studies.Fragment.StudiesStudyDbIdLayoutsPutCallback();
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

    private android.content.Intent listIntent()
    {
        if (null == this.listIntentInstance) this.listIntentInstance = new android.content.Intent(
            this.getActivity(), org.wheatgenetics.brapi1_3.studies.ListActivity.class);
        return this.listIntentInstance;
    }

    private void showListActivity()
    {
        this.startActivityForResult(this.listIntent(), org.wheatgenetics
            .androidlibrarybuilder.brapi1_3.studies.Fragment.LIST_ACTIVITY_REQUEST_CODE);
    }
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
                                    .Fragment.this.showListActivity();
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
                        { @java.lang.Override public void onClick(final android.view.View v) {} });
            }
            {
                final android.widget.Button studiesStudyDbIdObservationsPutButton =
                    rootView.findViewById(org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudyDbIdObservationsPutButton);
                if (null != studiesStudyDbIdObservationsPutButton)
                    studiesStudyDbIdObservationsPutButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        { @java.lang.Override public void onClick(final android.view.View v) {} });
            }
            {
                final android.widget.Button studiesStudyDbIdObservationunitsGetButton =
                    rootView.findViewById(org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudyDbIdObservationunitsGetButton);
                if (null != studiesStudyDbIdObservationunitsGetButton)
                    studiesStudyDbIdObservationunitsGetButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        { @java.lang.Override public void onClick(final android.view.View v) {} });
            }
            {
                final android.widget.Button studiesStudyDbIdObservationunitsPutButton =
                    rootView.findViewById(org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesStudyDbIdObservationunitsPutButton);
                if (null != studiesStudyDbIdObservationunitsPutButton)
                    studiesStudyDbIdObservationunitsPutButton.setOnClickListener(
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
                        { @java.lang.Override public void onClick(final android.view.View v) {} });
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
                    { @java.lang.Override public void onClick(final android.view.View v) {} });
            }
            this.findResponseTextViewById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesResponseTextView);
        }
        return rootView;
    }

    @java.lang.Override public void onActivityResult(final int requestCode,
    final int resultCode, final android.content.Intent data)
    {
        if (
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.LIST_ACTIVITY_REQUEST_CODE
        == requestCode)
        {
            final org.wheatgenetics.javalib.mstrdtl.Items items;
            {
                final org.wheatgenetics.brapi1_3.studies.Application application =
                    this.application();
                items = null == application ? null : application.mstrdtlItems();
            }
            if (null != items)
                this.studiesStudyDbIdLayoutsPut((io.swagger.client.model.StudyLayoutRequest) items);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    // endregion
}