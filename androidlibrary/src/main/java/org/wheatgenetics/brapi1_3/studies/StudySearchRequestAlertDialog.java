package org.wheatgenetics.brapi1_3.studies;

/**
 * Uses:
 * android.app.Activity
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 * android.support.annotation.IdRes
 * android.support.annotation.IntRange
 * android.support.annotation.RestrictTo.Scope
 * android.support.annotation.RestrictTo.Scope.SUBCLASSES
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.Button
 * android.widget.EditText
 * android.widget.RadioGroup
 * android.widget.TextView
 *
 * io.swagger.client.model.StudySearchRequest
 * io.swagger.client.model.StudySearchRequest.SortByEnum
 * io.swagger.client.model.StudySearchRequest.SortOrderEnum
 *
 * org.wheatgenetics.androidlibrary.ItemsAlertDialog
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.PagedAlertDialog
 */
public class StudySearchRequestAlertDialog extends org.wheatgenetics.brapi1_3.PagedAlertDialog
{
    private static class SortByAlertDialog extends org.wheatgenetics.androidlibrary.ItemsAlertDialog
    {
        @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
        private java.lang.String itemsInstance[] = null;                                // lazy load

        private java.lang.String[] items()
        {
            if (null == this.itemsInstance)
            {
                @java.lang.SuppressWarnings({"Convert2Diamond"})
                final java.util.ArrayList<java.lang.String> arrayList =
                    new java.util.ArrayList<java.lang.String>();
                arrayList.add("null");
                {
                    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
                    final io.swagger.client.model.StudySearchRequest.SortByEnum sortByEnums[] =
                        io.swagger.client.model.StudySearchRequest.SortByEnum.values();
                    for (final io.swagger.client.model.StudySearchRequest.SortByEnum sortByEnum:
                    sortByEnums)
                        arrayList.add(sortByEnum.toString());
                }
                this.itemsInstance = new java.lang.String[arrayList.size()];
                this.itemsInstance = arrayList.toArray(this.itemsInstance);
            }
            return this.itemsInstance;
        }

        private SortByAlertDialog(final android.app.Activity activity) { super(activity); }

        // region Overridden Methods
        @java.lang.Override public void configure()
        {
            this.setTitle(org.wheatgenetics.androidlibrary
                .R.string.StudySearchRequestAlertDialogSortByLabelTextViewText);
            this.setCancelNegativeButton();
        }

        @java.lang.Override public void show() { super.show(this.items()); }
        // endregion

        private io.swagger.client.model.StudySearchRequest.SortByEnum item(
        @android.support.annotation.IntRange(from = 0) final int i)
        {
            return 0 == i ? null :
                io.swagger.client.model.StudySearchRequest.SortByEnum.fromValue(this.items()[i]);
        }
    }

    // region Fields
    private android.widget.RadioGroup activeRadioGroup;
    private android.widget.EditText   commonCropNamesEditText, germplasmDbIdsEditText,
        locationDbIdsEditText, observationVariableDbIdsEditText, programDbIdsEditText,
        programNamesEditText, seasonDbIdsEditText;
    private android.widget.TextView   sortByTextView     ;
    private android.widget.RadioGroup sortOrderRadioGroup;
    private android.widget.EditText   studyDbIdsEditText, studyNamesEditText,
        studyTypeDbIdsEditText, studyTypeNamesEditText, trialDbIdsEditText;

    private io.swagger.client.model.StudySearchRequest            studySearchRequest = null;
    private io.swagger.client.model.StudySearchRequest.SortByEnum sortByEnum         = null;

    private org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.SortByAlertDialog
        sortByAlertDialogInstance = null;                                               // lazy load
    // endregion

    // region Private Methods
    // region sortByAlertDialog Private Methods
    private org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.SortByAlertDialog
    sortByAlertDialog()
    {
        if (null == this.sortByAlertDialogInstance)
        {
            this.sortByAlertDialogInstance = new
                org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.SortByAlertDialog(
                    this.activity());
            this.sortByAlertDialogInstance.setOnClickListener(
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override public void onClick(
                    final android.content.DialogInterface dialog, final int which)
                    {
                        org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog
                            .this.setSortByEnum(which);
                    }
                });
        }
        return this.sortByAlertDialogInstance;
    }

    private void showSortByAlertDialog() { this.sortByAlertDialog().show(); }
    // endregion

    // region set() Private Methods
    // region active set() Private Methods
    private static void setActiveRadioGroup(final android.widget.RadioGroup radioGroup,
    final java.lang.Boolean active)
    {
        if (null != radioGroup)
        {
            @android.support.annotation.IdRes final int id;
            if (null == active)
                id = org.wheatgenetics.androidlibrary.R.id.studySearchRequestNullActiveRadioButton;
            else
                id = active ?
                    org.wheatgenetics.androidlibrary.R.id.studySearchRequestTrueActiveRadioButton :
                    org.wheatgenetics.androidlibrary.R.id.studySearchRequestFalseActiveRadioButton;
            radioGroup.check(id);
        }
    }

    private void setActiveRadioGroup(final java.lang.Boolean active)
    {
        org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setActiveRadioGroup(
            this.activeRadioGroup, active);
    }
    // endregion

    // region sortBy set() Private Methods
    private void setSortByTextViewText(
    final io.swagger.client.model.StudySearchRequest.SortByEnum sortByEnum)
    {
        if (null != this.sortByTextView) this.sortByTextView.setText(
            null == sortByEnum ? "null" : sortByEnum.toString());
    }

    private void setSortByEnum(final io.swagger.client.model.StudySearchRequest.SortByEnum
    sortByEnum) { this.sortByEnum = sortByEnum; this.setSortByTextViewText(this.sortByEnum); }

    private void setSortByEnum(@android.support.annotation.IntRange(from = 0) final int i)
    { this.setSortByEnum(this.sortByAlertDialog().item(i)); }
    // endregion

    // region sortOrder set() Private Methods
    private static void setSortOrderRadioGroup(final android.widget.RadioGroup radioGroup,
    final io.swagger.client.model.StudySearchRequest.SortOrderEnum sortOrderEnum)
    {
        if (null != radioGroup)
        {
            @android.support.annotation.IdRes final int id;
            {
                @android.support.annotation.IdRes final int nullSortOrderRadioButton =
                    org.wheatgenetics.androidlibrary
                        .R.id.studySearchRequestNullSortOrderRadioButton;
                if (null == sortOrderEnum)
                    id = nullSortOrderRadioButton;
                else
                    switch (sortOrderEnum)
                    {
                        case ASC: id = org.wheatgenetics.androidlibrary
                            .R.id.studySearchRequestAscSortOrderRadioButton; break;

                        case DESC: id = org.wheatgenetics.androidlibrary
                            .R.id.studySearchRequestDescSortOrderRadioButton; break;

                        default: id = nullSortOrderRadioButton; break;
                    }
            }
            radioGroup.check(id);
        }
    }

    private void setSortOrderRadioGroup(
    final io.swagger.client.model.StudySearchRequest.SortOrderEnum sortOrderEnum)
    {
        org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setSortOrderRadioGroup(
            this.sortOrderRadioGroup, sortOrderEnum);
    }
    // endregion
    // endregion

    // region get() Private Methods
    // region active get() Private Methods
    private static java.lang.Boolean getActive(final android.widget.RadioGroup radioGroup)
    {
        if (null == radioGroup)
            return null;
        else
        {
            @android.support.annotation.IdRes final int checkedRadioButtonId =
                radioGroup.getCheckedRadioButtonId();
            if (org.wheatgenetics.androidlibrary.R.id.studySearchRequestFalseActiveRadioButton
            ==  checkedRadioButtonId)
                return false;
            else
                if (org.wheatgenetics.androidlibrary.R.id.studySearchRequestTrueActiveRadioButton
                ==  checkedRadioButtonId)
                    return true;
                else
                    return null;
        }
    }

    private java.lang.Boolean getActive()
    {
        return org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.getActive(
            this.activeRadioGroup);
    }
    // endregion

    // region sortOrder get() Private Methods
    private static io.swagger.client.model.StudySearchRequest.SortOrderEnum getSortOrder(
    final android.widget.RadioGroup radioGroup)
    {
        if (null == radioGroup)
            return null;
        else
        {
            @android.support.annotation.IdRes final int checkedRadioButtonId =
                radioGroup.getCheckedRadioButtonId();
            if (org.wheatgenetics.androidlibrary.R.id.studySearchRequestAscSortOrderRadioButton
            ==  checkedRadioButtonId)
                return io.swagger.client.model.StudySearchRequest.SortOrderEnum.ASC;
            else
                if (org.wheatgenetics.androidlibrary.R.id.studySearchRequestDescSortOrderRadioButton
                ==  checkedRadioButtonId)
                    return io.swagger.client.model.StudySearchRequest.SortOrderEnum.DESC;
                else
                    return null;
        }
    }

    private io.swagger.client.model.StudySearchRequest.SortOrderEnum getSortOrder()
    {
        return org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.getSortOrder(
            this.sortOrderRadioGroup);
    }
    // endregion
    // endregion
    // endregion

    public StudySearchRequestAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden methods
    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.StudySearchRequestAlertDialogTitle);
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrary
                .R.layout.alert_dialog_brapi1_3_studies_study_search_request);

            if (null != view)
            {
                if (null == this.activeRadioGroup) this.activeRadioGroup = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studySearchRequestActiveRadioGroup);
                if (null == this.commonCropNamesEditText) this.commonCropNamesEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary
                        .R.id.studySearchRequestCommonCropNamesEditText);
                if (null == this.germplasmDbIdsEditText) this.germplasmDbIdsEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary
                        .R.id.studySearchRequestGermplasmDbIdsEditText);
                if (null == this.locationDbIdsEditText) this.locationDbIdsEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary
                        .R.id.studySearchRequestLocationDbIdsEditText);
                if (null == this.observationVariableDbIdsEditText)
                    this.observationVariableDbIdsEditText = view.findViewById(org.wheatgenetics
                        .androidlibrary.R.id.studySearchRequestObservationVariableDbIdsEditText);
                this.findPageEditTextById(view,
                    org.wheatgenetics.androidlibrary.R.id.studySearchRequestPageEditText);
                this.findPageSizeEditTextById(view,
                    org.wheatgenetics.androidlibrary.R.id.studySearchRequestPageSizeEditText);
                if (null == this.programDbIdsEditText) this.programDbIdsEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary
                        .R.id.studySearchRequestProgramDbIdsEditText);
                if (null == this.programNamesEditText) this.programNamesEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary
                        .R.id.studySearchRequestProgramNamesEditText);
                if (null == this.seasonDbIdsEditText) this.seasonDbIdsEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studySearchRequestSeasonDbIdsEditText);
                if (null == this.sortByTextView) this.sortByTextView = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studySearchRequestSortByValueTextView);
                {
                    final android.widget.Button changeSortByButton = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id.studySearchRequestChangeSortByButton);
                    if (null != changeSortByButton) changeSortByButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog
                                    .this.showSortByAlertDialog();
                            }
                        });
                }
                if (null == this.sortOrderRadioGroup) this.sortOrderRadioGroup = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studySearchRequestSortOrderRadioGroup);
                if (null == this.studyDbIdsEditText) this.studyDbIdsEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studySearchRequestStudyDbIdsEditText);
                if (null == this.studyNamesEditText) this.studyNamesEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studySearchRequestStudyNamesEditText);
                if (null == this.studyNamesEditText) this.studyNamesEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studySearchRequestStudyNamesEditText);
                if (null == this.studyTypeDbIdsEditText) this.studyTypeDbIdsEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary
                        .R.id.studySearchRequestStudyTypeDbIdsEditText);
                if (null == this.studyTypeNamesEditText) this.studyTypeNamesEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary
                        .R.id.studySearchRequestStudyTypeNamesEditText);
                if (null == this.trialDbIdsEditText) this.trialDbIdsEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.studySearchRequestTrialDbIdsEditText);
            }

            this.setView(view);
        }
        super.configure();
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.studySearchRequest)
        {
            this.studySearchRequest.setActive         (this.getActive());
            this.studySearchRequest.setCommonCropNames(org.wheatgenetics.brapi1_3.studies
                .StudySearchRequestAlertDialog.getEditTextStringListText(
                    this.commonCropNamesEditText));
            this.studySearchRequest.setGermplasmDbIds(org.wheatgenetics.brapi1_3.studies
                .StudySearchRequestAlertDialog.getEditTextStringListText(
                    this.germplasmDbIdsEditText));
            this.studySearchRequest.setLocationDbIds(org.wheatgenetics.brapi1_3.studies
                .StudySearchRequestAlertDialog.getEditTextStringListText(
                    this.locationDbIdsEditText));
            this.studySearchRequest.setObservationVariableDbIds(org.wheatgenetics.brapi1_3.studies
                .StudySearchRequestAlertDialog.getEditTextStringListText(
                    this.observationVariableDbIdsEditText));
            this.studySearchRequest.setPage        (this.getPageEditTextIntText    ());
            this.studySearchRequest.setPageSize    (this.getPageSizeEditTextIntText());
            this.studySearchRequest.setProgramDbIds(org.wheatgenetics.brapi1_3.studies
                .StudySearchRequestAlertDialog.getEditTextStringListText(
                    this.programDbIdsEditText));
            this.studySearchRequest.setProgramNames(org.wheatgenetics.brapi1_3.studies
                .StudySearchRequestAlertDialog.getEditTextStringListText(
                    this.programNamesEditText));
            this.studySearchRequest.setSeasonDbIds(org.wheatgenetics.brapi1_3.studies
                .StudySearchRequestAlertDialog.getEditTextStringListText(this.seasonDbIdsEditText));
            this.studySearchRequest.setSortBy    (this.sortByEnum    );
            this.studySearchRequest.setSortOrder (this.getSortOrder());
            this.studySearchRequest.setStudyDbIds(org.wheatgenetics.brapi1_3.studies
                .StudySearchRequestAlertDialog.getEditTextStringListText(this.studyDbIdsEditText));
            this.studySearchRequest.setStudyNames(org.wheatgenetics.brapi1_3.studies
                .StudySearchRequestAlertDialog.getEditTextStringListText(this.studyNamesEditText));
            this.studySearchRequest.setStudyTypeDbIds(org.wheatgenetics.brapi1_3.studies
                .StudySearchRequestAlertDialog.getEditTextStringListText(
                    this.studyTypeDbIdsEditText));
            this.studySearchRequest.setStudyTypeNames(org.wheatgenetics.brapi1_3.studies
                .StudySearchRequestAlertDialog.getEditTextStringListText(
                    this.studyTypeNamesEditText));
            this.studySearchRequest.setTrialDbIds(org.wheatgenetics.brapi1_3.studies
                .StudySearchRequestAlertDialog.getEditTextStringListText(this.trialDbIdsEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    public void show(final io.swagger.client.model.StudySearchRequest studySearchRequest)
    {
        if (null != studySearchRequest)
        {
            this.studySearchRequest = studySearchRequest;

            this.setActiveRadioGroup(this.studySearchRequest.isActive());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.commonCropNamesEditText, this.studySearchRequest.getCommonCropNames());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.germplasmDbIdsEditText, this.studySearchRequest.getGermplasmDbIds());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.locationDbIdsEditText, this.studySearchRequest.getLocationDbIds());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.observationVariableDbIdsEditText                ,
                this.studySearchRequest.getObservationVariableDbIds());
            this.setPageEditTextText    (this.studySearchRequest.getPage    ());
            this.setPageSizeEditTextText(this.studySearchRequest.getPageSize());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.programDbIdsEditText, this.studySearchRequest.getProgramDbIds());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.programNamesEditText, this.studySearchRequest.getProgramNames());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.seasonDbIdsEditText, this.studySearchRequest.getSeasonDbIds());
            this.setSortByEnum         (this.studySearchRequest.getSortBy   ());
            this.setSortOrderRadioGroup(this.studySearchRequest.getSortOrder());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.studyDbIdsEditText, this.studySearchRequest.getStudyDbIds());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.studyDbIdsEditText, this.studySearchRequest.getStudyDbIds());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.studyNamesEditText, this.studySearchRequest.getStudyNames());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.studyTypeDbIdsEditText, this.studySearchRequest.getStudyTypeDbIds());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.studyTypeNamesEditText, this.studySearchRequest.getStudyTypeNames());
            org.wheatgenetics.brapi1_3.studies.StudySearchRequestAlertDialog.setEditTextText(
                this.trialDbIdsEditText, this.studySearchRequest.getTrialDbIds());

            this.show();
        }
    }
}