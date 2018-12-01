package org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies;

/**
 * Uses:
 * android.app.Activity
 * android.view.View
 * android.widget.EditText
 *
 * org.wheatgenetics.brapi1_3.PagedAlertDialog
 * org.wheatgenetics.brapi1_3.PagedAlertDialog.Handler
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 */
class SearchStudiesSearchResultsDbIdGetAlertDialog
extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    static class Parameters
    {
        // region Fields
        private java.lang.String  searchResultsDbId;
        private java.lang.Integer page, pageSize   ;
        // endregion

        // region Getter Package Methods
        java.lang.String getSearchResultsDbId() { return this.searchResultsDbId; }

        java.lang.Integer getPage    () { return this.page    ; }
        java.lang.Integer getPageSize() { return this.pageSize; }
        // endregion
    }

    // region Fields
    private android.widget.EditText searchResultsDbIdEditText;

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .SearchStudiesSearchResultsDbIdGetAlertDialog.Parameters parameters = null;
    // endregion

    SearchStudiesSearchResultsDbIdGetAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.PagedAlertDialog.Handler handler) { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle("StudiesApi.searchStudiesSearchResultsDbIdGet()");
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_studies_search_studies_searchresultsdbid_get);

            assert null != view;
            if (null == this.searchResultsDbIdEditText) this.searchResultsDbIdEditText = 
                view.findViewById(org.wheatgenetics.androidlibrarybuilder
                    .R.id.studiesSearchStudiesSearchResultsDbIdGetSearchResultsDbIdEditText);
            this.findPageEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                .R.id.studiesSearchStudiesSearchResultsDbIdGetPageEditText);
            this.findPageSizeEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                .R.id.studiesSearchStudiesSearchResultsDbIdGetPageSizeEditText);

            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.parameters)
        {
            this.parameters.searchResultsDbId = org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.SearchStudiesSearchResultsDbIdGetAlertDialog.getEditTextStringText(
                    this.searchResultsDbIdEditText);
            this.parameters.page     = this.getPageEditTextIntText    ();
            this.parameters.pageSize = this.getPageSizeEditTextIntText();

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .SearchStudiesSearchResultsDbIdGetAlertDialog.Parameters parameters)
    {
        if (null != parameters)
        {
            this.parameters = parameters;

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
                .SearchStudiesSearchResultsDbIdGetAlertDialog.setEditTextText(
                    this.searchResultsDbIdEditText, this.parameters.getSearchResultsDbId());
            this.setPageEditTextText    (this.parameters.getPage    ());
            this.setPageSizeEditTextText(this.parameters.getPageSize());

            this.show();
        }
    }
}