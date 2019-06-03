package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.app.Activity
 * android.view.View
 *
 * org.wheatgenetics.brapi1_3.PagedAlertDialog
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 */
public class PagePageSizeAlertDialog extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    public static class Parameters
    {
        private java.lang.Integer page, pageSize;

        // region Getter Public Methods
        public java.lang.Integer getPage    () { return this.page    ; }
        public java.lang.Integer getPageSize() { return this.pageSize; }
        // endregion
    }

    // region Fields
    private final java.lang.String title;
    private       org.wheatgenetics.androidlibrarybuilder.brapi1_3
        .PagePageSizeAlertDialog.Parameters parameters = null;
    // endregion

    public PagePageSizeAlertDialog(final android.app.Activity activity, final org.wheatgenetics
    .androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Handler handler,
    final java.lang.String title) { super(activity, handler); this.title = title; }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        {
            final android.view.View view = this.inflate(org.wheatgenetics
                .androidlibrarybuilder.R.layout.alert_dialog_brapi1_3_page_pagesize);
            if (null != view)
            {
                this.findPageEditTextById(view,
                    org.wheatgenetics.androidlibrarybuilder.R.id.pagePageSizePageEditText);
                this.findPageSizeEditTextById(view,
                    org.wheatgenetics.androidlibrarybuilder.R.id.pagePageSizePageSizeEditText);
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

    public void show(final
    org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagePageSizeAlertDialog.Parameters parameters)
    {
        if (null != parameters)
        {
            this.setTitle(this.title);

            this.parameters = parameters;

            this.setPageEditTextText    (this.parameters.getPage    ());
            this.setPageSizeEditTextText(this.parameters.getPageSize());

            this.show();
        }
    }
}