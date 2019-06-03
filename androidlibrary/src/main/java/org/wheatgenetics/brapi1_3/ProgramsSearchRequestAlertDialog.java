package org.wheatgenetics.brapi1_3;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.widget.EditText
 *
 * io.swagger.client.model.ProgramsSearchRequest
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.PagedAlertDialog
 */
public class ProgramsSearchRequestAlertDialog extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    // region Fields
    private android.widget.EditText abbreviationsEditText, commonCropNamesEditText,
        leadPersonDbIdsEditText, leadPersonNamesEditText, objectivesEditText, programDbIdsEditText,
        programNamesEditText;
    private io.swagger.client.model.ProgramsSearchRequest programsSearchRequest = null;
    // endregion

    public ProgramsSearchRequestAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden methods
    @java.lang.Override public void configure()
    {
        this.setTitle(
            org.wheatgenetics.androidlibrary.R.string.ProgramsSearchRequestAlertDialogTitle);
        {
            final android.view.View view = this.inflate(
                org.wheatgenetics.androidlibrary.R.layout.alert_dialog_programs_search_request);

            if (null != view)
            {
                if (null == this.abbreviationsEditText) this.abbreviationsEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R
                        .id.programsSearchRequestAbbreviationsEditText);
                if (null == this.commonCropNamesEditText)
                    this.commonCropNamesEditText = view.findViewById(org.wheatgenetics
                        .androidlibrary.R.id.programsSearchRequestCommonCropNamesEditText);
                if (null == this.leadPersonDbIdsEditText)
                    this.leadPersonDbIdsEditText = view.findViewById(org.wheatgenetics
                        .androidlibrary.R.id.programsSearchRequestLeadPersonDbIdsEditText);
                if (null == this.leadPersonNamesEditText)
                    this.leadPersonNamesEditText = view.findViewById(org.wheatgenetics
                        .androidlibrary.R.id.programsSearchRequestLeadPersonNamesEditText);
                if (null == this.objectivesEditText) this.objectivesEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.programsSearchRequestObjectivesEditText);
                this.findPageEditTextById(view,
                    org.wheatgenetics.androidlibrary.R.id.programsSearchRequestPageEditText);
                this.findPageSizeEditTextById(view,
                    org.wheatgenetics.androidlibrary.R.id.programsSearchRequestPageSizeEditText);
                if (null == this.programDbIdsEditText) this.programDbIdsEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary
                        .R.id.programsSearchRequestProgramDbIdsEditText);
                if (null == this.programNamesEditText) this.programNamesEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary
                        .R.id.programsSearchRequestProgramNamesEditText);
            }

            this.setView(view);
        }
        super.configure();
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.programsSearchRequest)
        {
            this.programsSearchRequest.setAbbreviations(org.wheatgenetics.brapi1_3
                .ProgramsSearchRequestAlertDialog.getEditTextStringListText(
                    this.abbreviationsEditText));
            this.programsSearchRequest.setCommonCropNames(org.wheatgenetics.brapi1_3
                .ProgramsSearchRequestAlertDialog.getEditTextStringListText(
                    this.commonCropNamesEditText));
            this.programsSearchRequest.setLeadPersonDbIds(org.wheatgenetics.brapi1_3
                .ProgramsSearchRequestAlertDialog.getEditTextStringListText(
                    this.leadPersonDbIdsEditText));
            this.programsSearchRequest.setLeadPersonNames(org.wheatgenetics.brapi1_3
                .ProgramsSearchRequestAlertDialog.getEditTextStringListText(
                    this.leadPersonNamesEditText));
            this.programsSearchRequest.setObjectives(org.wheatgenetics.brapi1_3
                .ProgramsSearchRequestAlertDialog.getEditTextStringListText(
                    this.objectivesEditText));
            this.programsSearchRequest.setPage       (this.getPageEditTextIntText    ());
            this.programsSearchRequest.setPageSize   (this.getPageSizeEditTextIntText());
            this.programsSearchRequest.setProgramDbIds(org.wheatgenetics.brapi1_3
                .ProgramsSearchRequestAlertDialog.getEditTextStringListText(
                    this.programDbIdsEditText));
            this.programsSearchRequest.setProgramNames(org.wheatgenetics.brapi1_3
                .ProgramsSearchRequestAlertDialog.getEditTextStringListText(
                    this.programNamesEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    public void show(final io.swagger.client.model.ProgramsSearchRequest programsSearchRequest)
    {
        if (null != programsSearchRequest)
        {
            this.programsSearchRequest = programsSearchRequest;

            org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog.setEditTextText(
                this.abbreviationsEditText, this.programsSearchRequest.getAbbreviations());
            org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog.setEditTextText(
                this.commonCropNamesEditText, this.programsSearchRequest.getCommonCropNames());
            org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog.setEditTextText(
                this.leadPersonDbIdsEditText, this.programsSearchRequest.getLeadPersonDbIds());
            org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog.setEditTextText(
                this.leadPersonNamesEditText, this.programsSearchRequest.getLeadPersonNames());
            org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog.setEditTextText(
                this.objectivesEditText, this.programsSearchRequest.getObjectives());
            this.setPageEditTextText    (this.programsSearchRequest.getPage    ());
            this.setPageSizeEditTextText(this.programsSearchRequest.getPageSize());
            org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog.setEditTextText(
                this.programDbIdsEditText, this.programsSearchRequest.getProgramDbIds());
            org.wheatgenetics.brapi1_3.ProgramsSearchRequestAlertDialog.setEditTextText(
                this.programNamesEditText, this.programsSearchRequest.getProgramNames());

            this.show();
        }
    }
}