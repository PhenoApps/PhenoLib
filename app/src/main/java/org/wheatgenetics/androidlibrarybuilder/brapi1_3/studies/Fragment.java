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
 * io.swagger.client.model.StudiesResponse
 * io.swagger.client.model.StudySearchRequest
 * io.swagger.client.model.SuccessfulSearchResponse
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.brapi1_3.PagedAlertDialog.Handler
 * org.wheatgenetics.brapi1_3.StudySearchRequestAlertDialog
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Fragment
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .SearchStudiesSearchResultsDbIdGetAlertDialog
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
 *     .SearchStudiesSearchResultsDbIdGetAlertDialog.Parameters
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

    // region searchStudiesSearchResultsDbIdGet() Fields
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .SearchStudiesSearchResultsDbIdGetAlertDialog
            searchStudiesSearchResultsDbIdGetAlertDialogInstance = null;
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .SearchStudiesSearchResultsDbIdGetAlertDialog.Parameters
            searchStudiesSearchResultsDbIdGetParametersInstance = null;
    private io.swagger.client.ApiCallback<io.swagger.client.model.StudiesResponse>
        studiesResponseCallbackInstance = null;
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
                    new org.wheatgenetics.brapi1_3.PagedAlertDialog.Handler()
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

    // region searchStudiesSearchResultsDbIdGet() Private Methods
    private void setResponseTextViewText(final io.swagger.client.model.StudiesResponse
    studiesResponse)
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
                final io.swagger.client.model.StudiesResponse studiesResponse,
                final int                                                               i  ,
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
                new SearchStudiesSearchResultsDbIdGetAlertDialog(this.getActivity(),
                    new org.wheatgenetics.brapi1_3.PagedAlertDialog.Handler()
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
                { @java.lang.Override public void onClick(final android.view.View v) {} });
        }
        {
            final android.widget.Button studiesGetButton = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesGetButton);
            if (null != studiesGetButton) studiesGetButton.setOnClickListener(
                new android.view.View.OnClickListener()
                { @java.lang.Override public void onClick(final android.view.View v) {} });
        }
        {
            final android.widget.Button studiesStudyDbIdGetButton = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudyDbIdGetButton);
            if (null != studiesStudyDbIdGetButton) studiesStudyDbIdGetButton.setOnClickListener(
                new android.view.View.OnClickListener()
                { @java.lang.Override public void onClick(final android.view.View v) {} });
        }
        {
            final android.widget.Button studiesStudyDbIdGermplasmGetButton = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudyDbIdGermplasmGetButton);
            if (null != studiesStudyDbIdGermplasmGetButton)
                studiesStudyDbIdGermplasmGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    { @java.lang.Override public void onClick(final android.view.View v) {} });
        }
        {
            final android.widget.Button studiesStudyDbIdLayoutsGetButton = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesStudyDbIdLayoutsGetButton);
            if (null != studiesStudyDbIdLayoutsGetButton)
                studiesStudyDbIdLayoutsGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    { @java.lang.Override public void onClick(final android.view.View v) {} });
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