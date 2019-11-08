package org.wheatgenetics.brapi1_3.studies.nour.o;               // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.app.Activity activity
 * android.view.View
 * android.widget.EditText
 *
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.Season
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 */
class SeasonAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    // region Fields
    private android.widget.EditText        seasonEditText, seasonDbIdEditText, yearEditText;
    private io.swagger.client.model.Season season = null                                   ;
    // endregion

    SeasonAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog.Handler handler)
    { super(activity, handler);}

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.SeasonAlertDialogTitle);
        {
            final android.view.View view = this.inflate(
                org.wheatgenetics.androidlibrary.R.layout.alert_dialog_brapi1_3_season);
            if (null != view)
            {
                if (null == this.seasonEditText) this.seasonEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesSeasonSeasonEditText);
                if (null == this.seasonDbIdEditText) this.seasonDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesSeasonSeasonDbIdEditText);
                if (null == this.yearEditText) this.yearEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studiesSeasonYearEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.season)
        {
            this.season.setSeason(
                org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog.getEditTextStringText(
                    this.seasonEditText));
            this.season.setSeasonDbId(
                org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog.getEditTextStringText(
                    this.seasonDbIdEditText));
            this.season.setYear(
                org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog.getEditTextStringText(
                    this.yearEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final io.swagger.client.model.Season season)
    {
        if (null != season)
        {
            this.season = season;

            org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog.setEditTextText(
                this.seasonEditText, this.season.getSeason());
            org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog.setEditTextText(
                this.seasonDbIdEditText, this.season.getSeasonDbId());
            org.wheatgenetics.brapi1_3.studies.nour.o.SeasonAlertDialog.setEditTextText(
                this.yearEditText, this.season.getYear());

            this.show();
        }
    }
}