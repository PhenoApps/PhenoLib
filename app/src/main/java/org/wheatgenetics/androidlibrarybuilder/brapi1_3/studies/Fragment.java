package org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies;

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
 * io.swagger.client.ApiCallback
 * io.swagger.client.ApiException
 * io.swagger.client.api.StudiesApi
 * io.swagger.client.model.GermplasmSummaryListResponse
 * io.swagger.client.model.ObservationUnitPositionsResponse
 * io.swagger.client.model.SeasonsResponse
 * io.swagger.client.model.StudiesResponse
 * io.swagger.client.model.StudyResponse
 * io.swagger.client.model.StudySearchRequest
 * io.swagger.client.model.SuccessfulSearchResponse
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.brapi1_3.StudySearchRequestAlertDialog
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
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdPagePageSizeAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .StudiesStudyDbIdPagePageSizeAlertDialog.Handler
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .StudiesStudyDbIdPagePageSizeAlertDialog.Parameters
 */
public class Fragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
{
    // region Fields
    private io.swagger.client.api.StudiesApi studiesApiInstance = null;

    // region searchStudiesPost() Fields
    private org.wheatgenetics.brapi1_3.StudySearchRequestAlertDialog
        studySearchRequestAlertDialogInstance = null;
    private io.swagger.client.model.StudySearchRequest studySearchRequestInstance = null;
    private io.swagger.client.ApiCallback<io.swagger.client.model.SuccessfulSearchResponse>
        successfulSearchResponseCallbackInstance = null;
    // endregion

    // region searchStudiesSearchResultsDbIdGet() and studiesGet() Field
    private io.swagger.client.ApiCallback<io.swagger.client.model.StudiesResponse>
        studiesResponseCallbackInstance = null;
    // endregion

    // region searchStudiesSearchResultsDbIdGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .SearchStudiesSearchResultsDbIdGetAlertDialog
            searchStudiesSearchResultsDbIdGetAlertDialogInstance = null;
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .SearchStudiesSearchResultsDbIdGetAlertDialog.Parameters
            searchStudiesSearchResultsDbIdGetParametersInstance = null;
    // endregion

    // region seasonsGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog
        seasonsGetAlertDialogInstance = null;
    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog.Parameters
            seasonsGetAlertDialogParametersInstance = null;
    private io.swagger.client.ApiCallback<io.swagger.client.model.SeasonsResponse>
        seasonsResponseCallbackInstance = null;
    // endregion

    // region studiesGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog
        studiesGetAlertDialogInstance = null;
    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesGetAlertDialog.Parameters
            studiesGetAlertDialogParametersInstance = null;
    // endregion

    // region studiesStudyDbIdGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdGetAlertDialog
        studiesStudyDbIdGetAlertDialogInstance = null;
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdGetAlertDialog.Parameters studiesStudyDbIdGetParametersInstance = null;
    private io.swagger.client.ApiCallback<io.swagger.client.model.StudyResponse>
        studyResponseCallbackInstance = null;
    // endregion

    // region studiesStudyDbIdGermplasmGet() and studiesStudyDbIdLayoutsGet() Field
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdPagePageSizeAlertDialog.Parameters
            studiesStudyDbIdPagePageSizeParametersInstance = null;
    // endregion

    // region studiesStudyDbIdGermplasmGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdPagePageSizeAlertDialog
            studiesStudyDbIdGermplasmGetAlertDialogInstance = null;
    private io.swagger.client.ApiCallback<io.swagger.client.model.GermplasmSummaryListResponse>
        germplasmSummaryListResponseCallbackInstance = null;
    // endregion
    
    // region studiesStudyDbIdLayoutsGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .StudiesStudyDbIdPagePageSizeAlertDialog
            studiesStudyDbIdLayoutsGetAlertDialogInstance = null;
    private io.swagger.client.ApiCallback<io.swagger.client.model.ObservationUnitPositionsResponse>
        observationUnitPositionsResponseCallbackInstance = null;
    // endregion
    // endregion

    // region Private Methods
    private io.swagger.client.api.StudiesApi studiesApi()
    {
        if (null == this.studiesApiInstance)
            this.studiesApiInstance = new io.swagger.client.api.StudiesApi();
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
                /* body          => */ this.studySearchRequestInstance,
                /* authorization => */null,
                /* callback      => */ this.successfulSearchResponseCallback());
        }
        catch (final java.lang.Throwable t) { this.setResponseTextViewText(t); }
    }

    private org.wheatgenetics.brapi1_3.StudySearchRequestAlertDialog
    studySearchRequestAlertDialog()
    {
        if (null == this.studySearchRequestAlertDialogInstance)
            this.studySearchRequestAlertDialogInstance =
                new org.wheatgenetics.brapi1_3.StudySearchRequestAlertDialog(this.getActivity(),
                    new org.wheatgenetics.brapi1_3.StudySearchRequestAlertDialog.Handler()
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
                    /* authorization => */null,
                    /* callback      => */ this.studiesResponseCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewText(t); }
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
                    /* authorization => */null,
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
                    /* authorization => */null,
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
                    /* authorization => */null,
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
    .StudiesStudyDbIdPagePageSizeAlertDialog.Parameters studiesStudyDbIdPagePageSizeParameters()
    {
        if (null == this.studiesStudyDbIdPagePageSizeParametersInstance)
            this.studiesStudyDbIdPagePageSizeParametersInstance =
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                    .StudiesStudyDbIdPagePageSizeAlertDialog.Parameters();
        return this.studiesStudyDbIdPagePageSizeParametersInstance;
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
        if (null != this.studiesStudyDbIdPagePageSizeParametersInstance)
            try
            {
                this.studiesApi().studiesStudyDbIdGermplasmGetAsync(
                    /* studyDbId => */
                        this.studiesStudyDbIdPagePageSizeParametersInstance.getStudyDbId(),
                    /* page     => */ this.studiesStudyDbIdPagePageSizeParametersInstance.getPage(),
                    /* pageSize => */
                        this.studiesStudyDbIdPagePageSizeParametersInstance.getPageSize(),
                    /* authorization => */null,
                    /* callback      => */this.germplasmSummaryListCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewText(t); }
    }

    private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdPagePageSizeAlertDialog
    studiesStudyDbIdGermplasmGetAlertDialog()
    {
        if (null == this.studiesStudyDbIdGermplasmGetAlertDialogInstance)
            this.studiesStudyDbIdGermplasmGetAlertDialogInstance = new org.wheatgenetics
                .androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdPagePageSizeAlertDialog(
                    this.getActivity(), new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                        .StudiesStudyDbIdPagePageSizeAlertDialog.Handler()
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
    {
        this.studiesStudyDbIdGermplasmGetAlertDialog().show(
            this.studiesStudyDbIdPagePageSizeParameters());
    }
    // endregion

    // region studiesStudyDbIdLayoutsGet() Private Methods
    private void setResponseTextViewText(
    final io.swagger.client.model.ObservationUnitPositionsResponse observationUnitPositionsResponse)
    {
        this.setResponseTextViewTextFromThread(null == observationUnitPositionsResponse ?
            "null" : observationUnitPositionsResponse.toString());
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.ObservationUnitPositionsResponse>
    observationUnitPositionsResponseCallback()
    {
        if (null == this.observationUnitPositionsResponseCallbackInstance)
            this.observationUnitPositionsResponseCallbackInstance =
                new io.swagger.client.ApiCallback<
                    io.swagger.client.model.ObservationUnitPositionsResponse>()
                    {
                        @java.lang.Override public void onFailure(
                        final io.swagger.client.ApiException e, final int i,
                        final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                                .Fragment.this.setResponseTextViewText(e);
                        }

                        @java.lang.Override public void onSuccess(
                        final io.swagger.client.model.ObservationUnitPositionsResponse
                            observationUnitPositionsResponse,
                        final int                                                               i  ,
                        final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
                                .this.setResponseTextViewText(observationUnitPositionsResponse);
                        }

                        @java.lang.Override public void onUploadProgress(
                        final long l, final long l1, final boolean b) {}

                        @java.lang.Override public void onDownloadProgress(
                        final long l, final long l1, final boolean b) {}
                    };
        return this.observationUnitPositionsResponseCallbackInstance;
    }

    private void studiesStudyDbIdLayoutsGet()
    {
        if (null != this.studiesStudyDbIdPagePageSizeParametersInstance)
            try
            {
                this.studiesApi().studiesStudyDbIdLayoutsGetAsync(
                    /* studyDbId => */
                        this.studiesStudyDbIdPagePageSizeParametersInstance.getStudyDbId(),
                    /* page     => */ this.studiesStudyDbIdPagePageSizeParametersInstance.getPage(),
                    /* pageSize => */
                        this.studiesStudyDbIdPagePageSizeParametersInstance.getPageSize(),
                    /* authorization => */null,
                    /* callback      => */this.observationUnitPositionsResponseCallback());
            }
            catch (final java.lang.Throwable t) { this.setResponseTextViewText(t); }
    }

    private
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdPagePageSizeAlertDialog
    studiesStudyDbIdLayoutsGetAlertDialog()
    {
        if (null == this.studiesStudyDbIdLayoutsGetAlertDialogInstance)
            this.studiesStudyDbIdLayoutsGetAlertDialogInstance = new org.wheatgenetics
                .androidlibrarybuilder.brapi1_3.studies.StudiesStudyDbIdPagePageSizeAlertDialog(
                    this.getActivity(), new org.wheatgenetics.brapi1_3.AlertDialog.Handler()
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
    {
        this.studiesStudyDbIdLayoutsGetAlertDialog().show(
            this.studiesStudyDbIdPagePageSizeParameters());
    }
    // endregion
    // endregion

    public Fragment() {}

    @android.support.annotation.Nullable @java.lang.Override public android.view.View onCreateView(
    @android.support.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @android.support.annotation.Nullable final android.view.ViewGroup      container         ,
    @android.support.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = this.inflate(inflater, container,
            org.wheatgenetics.androidlibrarybuilder.R.layout.fragment_brapi1_3_studies);

        // The following eighteen ids are from fragment_brapi1_3_studies.xml.
        {
            assert null != rootView;
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
            final android.widget.Button studiesStudyDbIdGermplasmGetButton = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudyDbIdGermplasmGetButton);
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
            final android.widget.Button studiesStudyDbIdLayoutsGetButton = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudyDbIdLayoutsGetButton);
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
            final android.widget.Button studiesStudyDbIdLayoutsPutButton = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudyDbIdLayoutsPutButton);
            if (null != studiesStudyDbIdLayoutsPutButton)
                studiesStudyDbIdLayoutsPutButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    { @java.lang.Override public void onClick(final android.view.View v) {} });
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

        return rootView;
    }
}