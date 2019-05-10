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
 */
class SeasonsGetAlertDialog extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    static class Parameters
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
    private
        org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog.Parameters
            parameters = null;
    // endregion

    SeasonsGetAlertDialog(final android.app.Activity activity, final
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle("StudiesApi.seasonsGet()");
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_studies_seasons_get);
            if (null != view)
            {
                if (null == this.seasonDbIdEditText) this.seasonDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder
                        .R.id.studiesSeasonsGetSeasonDbIdEditText);
                if (null == this.seasonEditText) this.seasonEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.studiesSeasonsGetSeasonEditText);
                if (null == this.yearEditText) this.yearEditText = view.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.studiesSeasonsGetYearEditText);
                this.findPageEditTextById(view,
                    org.wheatgenetics.androidlibrarybuilder.R.id.studiesSeasonsGetPageEditText);
                this.findPageSizeEditTextById(view,
                    org.wheatgenetics.androidlibrarybuilder.R.id.studiesSeasonsGetPageSizeEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.parameters)
        {
            this.parameters.seasonDbId = org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.SeasonsGetAlertDialog.getEditTextStringText(this.seasonDbIdEditText);
            this.parameters.season = org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.SeasonsGetAlertDialog.getEditTextStringText(this.seasonEditText);
            this.parameters.year = org.wheatgenetics.androidlibrarybuilder.brapi1_3
                .studies.SeasonsGetAlertDialog.getEditTextStringText(this.yearEditText);
            this.parameters.page     = this.getPageEditTextIntText    ();
            this.parameters.pageSize = this.getPageSizeEditTextIntText();

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(
    final org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog.Parameters
        parameters)
    {
        if (null != parameters)
        {
            this.parameters = parameters;

            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog
                .setEditTextText(this.seasonDbIdEditText, this.parameters.getSeasonDbId());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog
                .setEditTextText(this.seasonEditText, this.parameters.getSeason());
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.SeasonsGetAlertDialog
                .setEditTextText(this.yearEditText, this.parameters.getYear());
            this.setPageEditTextText    (this.parameters.getPage()    );
            this.setPageSizeEditTextText(this.parameters.getPageSize());

            this.show();
        }
    }
}