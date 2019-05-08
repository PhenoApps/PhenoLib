package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

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
 * android.widget.EditText
 *
 * io.swagger.client.ApiCallback
 * io.swagger.client.ApiException
 * io.swagger.client.api.ProgramsApi
 * io.swagger.client.model.ProgramsResponse
 * io.swagger.client.model.ProgramsSearchRequest
 * io.swagger.client.model.SuccessfulSearchResponse
 *
 * org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog
 * org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog.Handler
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment
 */
public class ProgramsFragment
extends    org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment
implements org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog.Handler
{
    // region Fields
    private io.swagger.client.api.ProgramsApi programsApiInstance = null;               // lazy load
    private io.swagger.client.ApiCallback<io.swagger.client.model.ProgramsResponse>
        programsResponseCallbackInstance = null;                                        // lazy load

    // region programsGet() Fields
    private android.widget.EditText commonCropNameEditText,
        programNameEditText, abbreviationEditText;
    // endregion

    // region searchProgramsPost() Fields
    private io.swagger.client.model.ProgramsSearchRequest programsSearchRequestInstance = null;// ll
    private org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog
        programsSearchRequestAlertDialogInstance = null;                                // lazy load
    private io.swagger.client.ApiCallback<io.swagger.client.model.SuccessfulSearchResponse>
        successfulSearchResponseCallbackInstance = null;                                // lazy load
    // endregion

    // region searchProgramsSearchResultsDbIdGet() Fields
    private android.widget.EditText searchResultsDbIdEditText,
        searchProgramsSearchResultsDbIdGetPageEditText,
        searchProgramsSearchResultsDbIdGetPageSizeEditText;
    // endregion
    // endregion

    // region Private Methods
    private io.swagger.client.api.ProgramsApi programsApi()
    {
        if (null == this.programsApiInstance)
            this.programsApiInstance = new io.swagger.client.api.ProgramsApi(this.apiClient());
        return this.programsApiInstance;
    }

    private void setResponseTextViewText(
    final io.swagger.client.model.ProgramsResponse programsResponse)
    {
        this.setResponseTextViewTextFromThread(
            null == programsResponse ? "null" : programsResponse.toString());
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.ProgramsResponse>
    programsResponseCallback()
    {
        if (null == this.programsResponseCallbackInstance) this.programsResponseCallbackInstance =
            new io.swagger.client.ApiCallback<io.swagger.client.model.ProgramsResponse>()
            {
                @java.lang.Override public void onFailure(
                final io.swagger.client.ApiException e, final int i,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment
                        .this.setResponseTextViewTextFromThread(e);
                }

                @java.lang.Override public void onSuccess(
                final io.swagger.client.model.ProgramsResponse programsResponse, final int i,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment
                        .this.setResponseTextViewText(programsResponse);
                }

                @java.lang.Override public void onUploadProgress(
                final long l, final long l1, final boolean b) {}

                @java.lang.Override public void onDownloadProgress(
                final long l, final long l1, final boolean b) {}
            };
        return this.programsResponseCallbackInstance;
    }

    // region programsGet() Private Method
    private void programsGet()
    {
        try
        {
            this.programsApi().programsGetAsync(
                /* commonCropName => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment.getString(
                        this.commonCropNameEditText),
                /* programName => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment.getString(
                        this.programNameEditText),
                /* abbreviation => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment.getString(
                        this.abbreviationEditText),
                /* page          => */ this.getPageEditTextIntText    (),
                /* pageSize      => */ this.getPageSizeEditTextIntText(),
                /* authorization => */ this.authorization             (),
                /* callback      => */ this.programsResponseCallback  ());
        }
        catch (final java.lang.Throwable t) { this.setResponseTextViewText(t); }
    }
    // endregion

    // region searchProgramsPost() Private Methods
    private io.swagger.client.model.ProgramsSearchRequest programsSearchRequest()
    {
        if (null == this.programsSearchRequestInstance) this.programsSearchRequestInstance =
            new io.swagger.client.model.ProgramsSearchRequest();
        return this.programsSearchRequestInstance;
    }

    private org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog
    programsSearchRequestAlertDialog()
    {
        if (null == this.programsSearchRequestAlertDialogInstance)
            this.programsSearchRequestAlertDialogInstance =
                new org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog(
                    this.getActivity(),this);
        return this.programsSearchRequestAlertDialogInstance;
    }

    private void showProgramsSearchRequestAlertDialog()
    { this.programsSearchRequestAlertDialog().show(this.programsSearchRequest()); }

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
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment
                            .this.setResponseTextViewTextFromThread(e);
                    }

                    @java.lang.Override public void onSuccess(
                    final io.swagger.client.model.SuccessfulSearchResponse successfulSearchResponse,
                    final int                                              i                       ,
                    final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map    )
                    {
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment
                            .this.setResponseTextViewText(successfulSearchResponse);
                    }

                    @java.lang.Override public void onUploadProgress(
                    final long l, final long l1, final boolean b) {}

                    @java.lang.Override public void onDownloadProgress(
                    final long l, final long l1, final boolean b) {}
                };
        return this.successfulSearchResponseCallbackInstance;
    }
    // endregion

    // region searchProgramsSearchResultsDbIdGet() Private Method
    private void searchProgramsSearchResultsDbIdGet()
    {
        try
        {
            this.programsApi().searchProgramsSearchResultsDbIdGetAsync(
                /* searchResultsDbId => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment.getString(
                        this.searchResultsDbIdEditText),
                /* page => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment.getInteger(
                        this.searchProgramsSearchResultsDbIdGetPageEditText),
                /* pageSize => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment.getInteger(
                        this.searchProgramsSearchResultsDbIdGetPageSizeEditText),
                /* authorization => */ this.authorization           (),
                /* callback      => */ this.programsResponseCallback());
        }
        catch (final java.lang.Throwable e) { this.setResponseTextViewText(e); }
    }
    // endregion
    // endregion

    public ProgramsFragment() {}

    // region Overridden Methods
    @java.lang.Override @android.support.annotation.Nullable public android.view.View onCreateView(
    @android.support.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @android.support.annotation.Nullable final android.view.ViewGroup      container         ,
    @android.support.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = this.inflate(inflater, container,
            org.wheatgenetics.androidlibrarybuilder.R.layout.fragment_brapi1_3_programs);

        if (null != rootView)
        {
            // The following twelve ids are from fragment_brapi1_3_programs.xml.
            this.commonCropNameEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.programsCommonCropNameEditText);
            this.programNameEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.programsProgramNameEditText);
            this.abbreviationEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.programsAbbreviationEditText);
            this.findPageEditTextById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.programsGetPageEditText);
            this.findPageSizeEditTextById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.programsGetPageSizeEditText);
            {
                final android.widget.Button programsGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.programsGetButton);
                if (null != programsGetButton) programsGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment
                                .this.programsGet();
                        }
                    });
            }

            {
                final android.widget.Button searchProgramsPostButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.searchProgramsPostButton);
                if (null != searchProgramsPostButton) searchProgramsPostButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment
                                .this.showProgramsSearchRequestAlertDialog();
                        }
                    }
                );
            }

            this.searchResultsDbIdEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.programsSearchResultsDbIdEditText);
            this.searchProgramsSearchResultsDbIdGetPageEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder
                    .R.id.searchProgramsSearchResultsDbIdGetPageEditText);
            this.searchProgramsSearchResultsDbIdGetPageSizeEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.
                    R.id.searchProgramsSearchResultsDbIdGetPageSizeEditText);
            {
                final android.widget.Button searchProgramsSearchResultsDbIdGetButton =
                    rootView.findViewById(org.wheatgenetics.androidlibrarybuilder
                        .R.id.searchProgramsSearchResultsDbIdGetButton);
                if (null != searchProgramsSearchResultsDbIdGetButton)
                    searchProgramsSearchResultsDbIdGetButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment
                                    .this.searchProgramsSearchResultsDbIdGet();
                            }
                        });
            }

            this.findResponseTextViewById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.programsResponseTextView);
        }

        return rootView;
    }

    // region org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog.Handler Overridden Method
    @java.lang.Override public void handleDone()
    {
        try
        {
            this.programsApi().searchProgramsPostAsync(
                /* body          => */ this.programsSearchRequestInstance     ,
                /* authorization => */ this.authorization                   (),
                /* callback      => */ this.successfulSearchResponseCallback());
        }
        catch (final java.lang.Throwable t) { this.setResponseTextViewText(t); }
    }
    // endregion
    // endregion
}