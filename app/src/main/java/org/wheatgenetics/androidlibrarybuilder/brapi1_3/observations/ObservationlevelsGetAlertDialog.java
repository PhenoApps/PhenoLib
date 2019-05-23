package org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations;

/**
 * Uses:
 * android.app.Activity
 * android.view.View
 *
 * org.wheatgenetics.brapi1_3.PagedAlertDialog
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 */
class ObservationlevelsGetAlertDialog extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    static class Parameters
    {
        private java.lang.Integer page, pageSize;

        // region Getter Package Methods
        java.lang.Integer getPage    () { return this.page    ; }
        java.lang.Integer getPageSize() { return this.pageSize; }
        // endregion
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
        .ObservationlevelsGetAlertDialog.Parameters parameters = null;

    ObservationlevelsGetAlertDialog(final android.app.Activity activity, final org.wheatgenetics
    .androidlibrarybuilder.brapi1_3.observations.ObservationlevelsGetAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle("ObservationsApi.observationlevelsGet()");
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrarybuilder
                .R.layout.alert_dialog_brapi1_3_observations_observationlevels_get);
            if (null != view)
            {
                this.findPageEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                    .R.id.observationsObservationlevelsGetPageEditText);
                this.findPageSizeEditTextById(view, org.wheatgenetics.androidlibrarybuilder
                    .R.id.observationsObservationlevelsGetPageSizeEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.parameters)
        {
            this.parameters.page     = this.getPageEditTextIntText    ();
            this.parameters.pageSize = this.getPageSizeEditTextIntText();

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations
    .ObservationlevelsGetAlertDialog.Parameters parameters)
    {
        if (null != parameters)
        {
            this.parameters = parameters;

            this.setPageEditTextText    (this.parameters.getPage    ());
            this.setPageSizeEditTextText(this.parameters.getPageSize());

            this.show();
        }
    }
}