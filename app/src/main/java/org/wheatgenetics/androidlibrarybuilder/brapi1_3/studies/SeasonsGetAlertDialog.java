package org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies;

/**
 * Uses:
 * android.app.Activity
 * android.view.View
 * android.widget.EditText
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.brapi1_3.PagedAlertDialog
 * org.wheatgenetics.brapi1_3.PagedAlertDialog.Handler
 */
class SeasonsGetAlertDialog extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    static class SeasonsGetParameters
    {
        // region Fields
        private java.lang.String  seasonDbId, season, year;
        private java.lang.Integer pageSize, page          ;
        // endregion

        // region Getter Package Methods
        java.lang.String  getSeasonDbId() { return this.seasonDbId; }
        java.lang.String  getSeason    () { return this.season    ; }
        java.lang.String  getYear      () { return this.year      ; }
        java.lang.Integer getPageSize  () { return this.pageSize  ; }
        java.lang.Integer getPage      () { return this.page      ; }
        // endregion
    }

    // region Fields
    private android.widget.EditText seasonDbIdEditText, seasonEditText, yearEditText;
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
        .SeasonsGetAlertDialog.SeasonsGetParameters seasonsGetParameters = null;
    // endregion

    SeasonsGetAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.PagedAlertDialog.Handler handler) { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle("StudiesApi.seasonsGet()");
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_studies_seasons_get);

            assert null != view;
            if (null == this.seasonDbIdEditText) this.seasonDbIdEditText = view.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesSeasonsGetSeasonDbIdEditText);
            if (null == this.seasonEditText) this.seasonEditText = view.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesSeasonsGetSeasonEditText);
            if (null == this.yearEditText) this.yearEditText = view.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesSeasonsGetYearEditText);
            this.findPageEditTextById(view,
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesSeasonsGetPageEditText);
            this.findPageSizeEditTextById(view,
                org.wheatgenetics.androidlibrarybuilder.R.id.studiesSeasonsGetPageSizeEditText);

            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.seasonsGetParameters)
        {
            this.seasonsGetParameters.seasonDbId = org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.SeasonsGetAlertDialog.getEditTextStringText(this.seasonDbIdEditText);
            this.seasonsGetParameters.season = org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.SeasonsGetAlertDialog.getEditTextStringText(this.seasonEditText);
            this.seasonsGetParameters.year = org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.SeasonsGetAlertDialog.getEditTextStringText(this.yearEditText);
            this.seasonsGetParameters.page     = this.getPageEditTextIntText    ();
            this.seasonsGetParameters.pageSize = this.getPageSizeEditTextIntText();

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies
    .SeasonsGetAlertDialog.SeasonsGetParameters seasonsGetParameters)
    {
        if (null != seasonsGetParameters)
        {
            this.seasonsGetParameters = seasonsGetParameters;

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog
                .setEditTextText(this.seasonDbIdEditText,
                    this.seasonsGetParameters.getSeasonDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog
                .setEditTextText(this.seasonEditText, this.seasonsGetParameters.getSeason());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog
                .setEditTextText(this.yearEditText, this.seasonsGetParameters.getYear());
            this.setPageEditTextText    (this.seasonsGetParameters.getPage()    );
            this.setPageSizeEditTextText(this.seasonsGetParameters.getPageSize());

            this.show();
        }
    }
}