package org.wheatgenetics.brapi1_3.studies.slr;                           // slr: StudyLayoutRequest

/**
 * Uses:
 * android.app.Activity
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 * android.support.annotation.IntRange
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.Button
 * android.widget.EditText
 * android.widget.TextView
 *
 * io.swagger.client.model.StudyLayoutRequestLayout
 * io.swagger.client.model.StudyLayoutRequestLayout.EntryTypeEnum
 * io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateXTypeEnum
 * io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateYTypeEnum
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 * org.wheatgenetics.brapi1_3.TypeAlertDialog
 */
class StudyLayoutRequestLayoutAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    // region Types
    private static class EntryTypeAlertDialog extends org.wheatgenetics.brapi1_3.TypeAlertDialog
    {
        private EntryTypeAlertDialog(final android.app.Activity activity) { super(activity); }

        // region Overridden Methods
        @java.lang.Override public void configure()
        {
            this.setTitle(org.wheatgenetics.androidlibrary
                .R.string.StudyLayoutRequestLayoutAlertDialogEntryTypeLabelTextViewText);
            super.configure();
        }

        @android.support.annotation.RestrictTo(
            android.support.annotation.RestrictTo.Scope.SUBCLASSES)
        @java.lang.Override protected java.lang.String[] items()
        {
            if (this.itemsIsNull())
            {
                // noinspection Convert2Diamond
                final java.util.ArrayList<java.lang.String> arrayList =
                    new java.util.ArrayList<java.lang.String>();

                arrayList.add("null");
                {
                    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
                    final io.swagger.client.model.StudyLayoutRequestLayout.EntryTypeEnum
                        entryTypeEnums[] =
                            io.swagger.client.model.StudyLayoutRequestLayout.EntryTypeEnum.values();
                    for (final io.swagger.client.model.StudyLayoutRequestLayout.EntryTypeEnum
                    entryTypeEnum: entryTypeEnums)
                        arrayList.add(entryTypeEnum.toString());
                }

                this.createItems(arrayList);
            }
            return super.items();
        }
        // endregion

        private io.swagger.client.model.StudyLayoutRequestLayout.EntryTypeEnum item(
        @android.support.annotation.IntRange(from = 0) final int i)
        {
            return 0 == i ? null :
                io.swagger.client.model.StudyLayoutRequestLayout.EntryTypeEnum.fromValue(
                    this.items()[i]);
        }
    }

    private static class PositionCoordinateXTypeAlertDialog
    extends org.wheatgenetics.brapi1_3.TypeAlertDialog
    {
        private PositionCoordinateXTypeAlertDialog(final android.app.Activity activity)
        { super(activity); }

        // region Overridden Methods
        @java.lang.Override public void configure()
        {
            this.setTitle(org.wheatgenetics.androidlibrary.R.string
                .StudyLayoutRequestLayoutAlertDialogPositionCoordinateXTypeLabelTextViewText);
            super.configure();
        }

        @android.support.annotation.RestrictTo(
            android.support.annotation.RestrictTo.Scope.SUBCLASSES)
        @java.lang.Override protected java.lang.String[] items()
        {
            if (this.itemsIsNull())
            {
                // noinspection Convert2Diamond
                final java.util.ArrayList<java.lang.String> arrayList =
                    new java.util.ArrayList<java.lang.String>();

                arrayList.add("null");
                {
                    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"}) final
                       io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateXTypeEnum
                            positionCoordinateXTypeEnums[] = io.swagger.client.model
                                .StudyLayoutRequestLayout.PositionCoordinateXTypeEnum.values();
                    for (final
                    io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateXTypeEnum
                    positionCoordinateXTypeEnum: positionCoordinateXTypeEnums)
                        arrayList.add(positionCoordinateXTypeEnum.toString());
                }

                this.createItems(arrayList);
            }
            return super.items();
        }
        // endregion

        private io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateXTypeEnum item(
        @android.support.annotation.IntRange(from = 0) final int i)
        {
            return 0 == i ? null : io.swagger.client.model.StudyLayoutRequestLayout
                .PositionCoordinateXTypeEnum.fromValue(this.items()[i]);
        }
    }

    private static class PositionCoordinateYTypeAlertDialog
    extends org.wheatgenetics.brapi1_3.TypeAlertDialog
    {
        private PositionCoordinateYTypeAlertDialog(final android.app.Activity activity)
        { super(activity); }

        // region Overridden Methods
        @java.lang.Override public void configure()
        {
            this.setTitle(org.wheatgenetics.androidlibrary.R.string
                .StudyLayoutRequestLayoutAlertDialogPositionCoordinateYTypeLabelTextViewText);
            super.configure();
        }

        @android.support.annotation.RestrictTo(
            android.support.annotation.RestrictTo.Scope.SUBCLASSES)
        @java.lang.Override protected java.lang.String[] items()
        {
            if (this.itemsIsNull())
            {
                // noinspection Convert2Diamond
                final java.util.ArrayList<java.lang.String> arrayList =
                    new java.util.ArrayList<java.lang.String>();

                arrayList.add("null");
                {
                    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"}) final
                        io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateYTypeEnum
                            positionCoordinateYTypeEnums[] = io.swagger.client.model
                                .StudyLayoutRequestLayout.PositionCoordinateYTypeEnum.values();
                    for (final
                    io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateYTypeEnum
                    positionCoordinateYTypeEnum: positionCoordinateYTypeEnums)
                        arrayList.add(positionCoordinateYTypeEnum.toString());
                }

                this.createItems(arrayList);
            }
            return super.items();
        }
        // endregion

        private io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateYTypeEnum item(
        @android.support.annotation.IntRange(from = 0) final int i)
        {
            return 0 == i ? null : io.swagger.client.model.StudyLayoutRequestLayout
                .PositionCoordinateYTypeEnum.fromValue(this.items()[i]);
        }
    }
    // endregion

    // region Fields
    private android.widget.EditText blockNumberEditText                                     ;
    private android.widget.TextView entryTypeTextView                                       ;
    private android.widget.EditText observationUnitDbIdEditText, positionCoordinateXEditText;
    private android.widget.TextView positionCoordinateXTypeTextView                         ;
    private android.widget.EditText positionCoordinateYEditText                             ;
    private android.widget.TextView positionCoordinateYTypeTextView                         ;
    private android.widget.EditText replicateEditText                                       ;

    private io.swagger.client.model.StudyLayoutRequestLayout    studyLayoutRequestLayout = null;
    private io.swagger.client.model.StudyLayoutRequestLayout.EntryTypeEnum entryTypeEnum = null;
    private io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateXTypeEnum
        positionCoordinateXTypeEnum = null;
    private io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateYTypeEnum
        positionCoordinateYTypeEnum = null;

    private org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
        .EntryTypeAlertDialog entryTypeAlertDialogInstance = null;                      // lazy load
    private org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
        .PositionCoordinateXTypeAlertDialog positionCoordinateXTypeAlertDialogInstance = null; // ll
    private org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
        .PositionCoordinateYTypeAlertDialog positionCoordinateYTypeAlertDialogInstance = null; // ll
    // endregion

    // region Private Methods
    // region AlertDialog Private Methods
    // region entryTypeAlertDialog Private Methods
    private
    org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog.EntryTypeAlertDialog
    entryTypeAlertDialog()
    {
        if (null == this.entryTypeAlertDialogInstance)
        {
            this.entryTypeAlertDialogInstance =
                new org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
                    .EntryTypeAlertDialog(this.activity());
            this.entryTypeAlertDialogInstance.setOnClickListener(
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override public void onClick(
                    final android.content.DialogInterface dialog, final int which)
                    {
                        org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
                            .this.setEntryTypeEnum(which);
                    }
                });
        }
        return this.entryTypeAlertDialogInstance;
    }

    private void showEntryTypeAlertDialog() { this.entryTypeAlertDialog().show(); }
    // endregion

    // region positionCoordinateXTypeAlertDialog Private Methods
    private org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
        .PositionCoordinateXTypeAlertDialog positionCoordinateXTypeAlertDialog()
    {
        if (null == this.positionCoordinateXTypeAlertDialogInstance)
        {
            this.positionCoordinateXTypeAlertDialogInstance =
                new org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
                    .PositionCoordinateXTypeAlertDialog(this.activity());
            this.positionCoordinateXTypeAlertDialogInstance.setOnClickListener(
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override public void onClick(
                    final android.content.DialogInterface dialog, final int which)
                    {
                        org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
                            .this.setPositionCoordinateXTypeEnum(which);
                    }
                });
        }
        return this.positionCoordinateXTypeAlertDialogInstance;
    }

    private void showPositionCoordinateXTypeAlertDialog()
    { this.positionCoordinateXTypeAlertDialog().show(); }
    // endregion

    // region positionCoordinateYTypeAlertDialog Private Methods
    private org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
        .PositionCoordinateYTypeAlertDialog positionCoordinateYTypeAlertDialog()
    {
        if (null == this.positionCoordinateYTypeAlertDialogInstance)
        {
            this.positionCoordinateYTypeAlertDialogInstance =
                new org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
                    .PositionCoordinateYTypeAlertDialog(this.activity());
            this.positionCoordinateYTypeAlertDialogInstance.setOnClickListener(
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override public void onClick(
                    final android.content.DialogInterface dialog, final int which)
                    {
                        org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
                            .this.setPositionCoordinateYTypeEnum(which);
                    }
                });
        }
        return this.positionCoordinateYTypeAlertDialogInstance;
    }

    private void showPositionCoordinateYTypeAlertDialog()
    { this.positionCoordinateYTypeAlertDialog().show(); }
    // endregion
    // endregion

    // region set() Private Methods
    // region entryType set() Private Methods
    private void setEntryTypeTextViewText(
    final io.swagger.client.model.StudyLayoutRequestLayout.EntryTypeEnum entryTypeEnum)
    {
        if (null != this.entryTypeTextView) this.entryTypeTextView.setText(
            null == entryTypeEnum ? "null" : entryTypeEnum.toString());
    }

    private void setEntryTypeEnum(
    final io.swagger.client.model.StudyLayoutRequestLayout.EntryTypeEnum entryTypeEnum)
    { this.entryTypeEnum = entryTypeEnum; this.setEntryTypeTextViewText(this.entryTypeEnum); }

    private void setEntryTypeEnum(@android.support.annotation.IntRange(from = 0) final int i)
    { this.setEntryTypeEnum(this.entryTypeAlertDialog().item(i)); }
    // endregion

    // region positionCoordinateXType set() Private Methods
    private void setPositionCoordinateXTypeTextViewText(
    final io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateXTypeEnum
        positionCoordinateXTypeEnum)
    {
        if (null != this.positionCoordinateXTypeTextView)
            this.positionCoordinateXTypeTextView.setText(null == positionCoordinateXTypeEnum ?
                "null" : positionCoordinateXTypeEnum.toString());
    }

    private void setPositionCoordinateXTypeEnum(
    final io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateXTypeEnum
        positionCoordinateXTypeEnum)
    {
        this.setPositionCoordinateXTypeTextViewText(
            this.positionCoordinateXTypeEnum = positionCoordinateXTypeEnum);
    }

    private void setPositionCoordinateXTypeEnum(
    @android.support.annotation.IntRange(from = 0) final int i)
    { this.setPositionCoordinateXTypeEnum(this.positionCoordinateXTypeAlertDialog().item(i)); }
    // endregion

    // region positionCoordinateYType set() Private Methods
    private void setPositionCoordinateYTypeTextViewText(
    final io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateYTypeEnum
        positionCoordinateYTypeEnum)
    {
        if (null != this.positionCoordinateYTypeTextView)
            this.positionCoordinateYTypeTextView.setText(null == positionCoordinateYTypeEnum ?
                "null" : positionCoordinateYTypeEnum.toString());
    }

    private void setPositionCoordinateYTypeEnum(
    final io.swagger.client.model.StudyLayoutRequestLayout.PositionCoordinateYTypeEnum
        positionCoordinateYTypeEnum)
    {
        this.setPositionCoordinateYTypeTextViewText(
            this.positionCoordinateYTypeEnum = positionCoordinateYTypeEnum);
    }

    private void setPositionCoordinateYTypeEnum(
    @android.support.annotation.IntRange(from = 0) final int i)
    { this.setPositionCoordinateYTypeEnum(this.positionCoordinateYTypeAlertDialog().item(i)); }
    // endregion
    // endregion
    // endregion

    StudyLayoutRequestLayoutAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.studies.slr
        .StudyLayoutRequestLayoutAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden methods
    @java.lang.Override public void configure()
    {
        this.setTitle(
            org.wheatgenetics.androidlibrary.R.string.StudyLayoutRequestLayoutAlertDialogTitle);
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrary
                .R.layout.alert_dialog_brapi1_3_studies_study_layout_request_layout);

            if (null != view)
            {
                if (null == this.blockNumberEditText) this.blockNumberEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary
                        .R.id.studiesStudyLayoutRequestLayoutBlockNumberEditText);

                if (null == this.entryTypeTextView) this.entryTypeTextView = view.findViewById(
                    org.wheatgenetics.androidlibrary
                        .R.id.studiesStudyLayoutRequestLayoutEntryTypeValueTextView);
                {
                    final android.widget.Button changeEntryTypeButton = view.findViewById(
                        org.wheatgenetics.androidlibrary
                            .R.id.studiesStudyLayoutRequestLayoutChangeEntryTypeButton);
                    if (null != changeEntryTypeButton) changeEntryTypeButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.brapi1_3.studies.slr
                                    .StudyLayoutRequestLayoutAlertDialog.this
                                    .showEntryTypeAlertDialog();
                            }
                        });
                }

                if (null == this.observationUnitDbIdEditText) this.observationUnitDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary
                        .R.id.studiesStudyLayoutRequestLayoutObservationUnitDbIdEditText);

                if (null == this.positionCoordinateXEditText) this.positionCoordinateXEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary
                        .R.id.studiesStudyLayoutRequestLayoutPositionCoordinateXEditText);

                if (null == this.positionCoordinateXTypeTextView)
                    this.positionCoordinateXTypeTextView = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .studiesStudyLayoutRequestLayoutPositionCoordinateXTypeValueTextView);
                {
                    final android.widget.Button changePositionCoordinateXTypeButton =
                        view.findViewById(org.wheatgenetics.androidlibrary.R.id
                            .studiesStudyLayoutRequestLayoutChangePositionCoordinateXTypeButton);
                    if (null != changePositionCoordinateXTypeButton)
                        changePositionCoordinateXTypeButton.setOnClickListener(
                            new android.view.View.OnClickListener()
                            {
                                @java.lang.Override public void onClick(final android.view.View v)
                                {
                                    org.wheatgenetics.brapi1_3.studies.slr
                                        .StudyLayoutRequestLayoutAlertDialog.this
                                        .showPositionCoordinateXTypeAlertDialog();
                                }
                            });
                }

                if (null == this.positionCoordinateYEditText) this.positionCoordinateYEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary
                        .R.id.studiesStudyLayoutRequestLayoutPositionCoordinateYEditText);

                if (null == this.positionCoordinateYTypeTextView)
                    this.positionCoordinateYTypeTextView = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .studiesStudyLayoutRequestLayoutPositionCoordinateYTypeValueTextView);
                {
                    final android.widget.Button changePositionCoordinateYTypeButton =
                        view.findViewById(org.wheatgenetics.androidlibrary.R.id
                            .studiesStudyLayoutRequestLayoutChangePositionCoordinateYTypeButton);
                    if (null != changePositionCoordinateYTypeButton)
                        changePositionCoordinateYTypeButton.setOnClickListener(
                            new android.view.View.OnClickListener()
                            {
                                @java.lang.Override public void onClick(final android.view.View v)
                                {
                                    org.wheatgenetics.brapi1_3.studies.slr
                                        .StudyLayoutRequestLayoutAlertDialog.this
                                        .showPositionCoordinateYTypeAlertDialog();
                                }
                            });
                }

                if (null == this.replicateEditText) this.replicateEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary
                        .R.id.studiesStudyLayoutRequestLayoutReplicateEditText);
            }

            this.setView(view);
        }
        super.configure();
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.studyLayoutRequestLayout)
        {
            this.studyLayoutRequestLayout.setBlockNumber(org.wheatgenetics.brapi1_3.studies.slr
                .StudyLayoutRequestLayoutAlertDialog.getEditTextIntText(this.blockNumberEditText));
            this.studyLayoutRequestLayout.setEntryType(this.entryTypeEnum);
            this.studyLayoutRequestLayout.setObservationUnitDbId(org.wheatgenetics.brapi1_3.studies
                .slr.StudyLayoutRequestLayoutAlertDialog.getEditTextStringText(
                    this.observationUnitDbIdEditText));
            this.studyLayoutRequestLayout.setPositionCoordinateX(org.wheatgenetics.brapi1_3.studies
                .slr.StudyLayoutRequestLayoutAlertDialog.getEditTextStringText(
                    this.positionCoordinateXEditText));
            this.studyLayoutRequestLayout.setPositionCoordinateXType(
                this.positionCoordinateXTypeEnum);
            this.studyLayoutRequestLayout.setPositionCoordinateY(org.wheatgenetics.brapi1_3.studies
                .slr.StudyLayoutRequestLayoutAlertDialog.getEditTextStringText(
                    this.positionCoordinateYEditText));
            this.studyLayoutRequestLayout.setPositionCoordinateYType(
                this.positionCoordinateYTypeEnum);
            this.studyLayoutRequestLayout.setReplicate(org.wheatgenetics.brapi1_3.studies.slr
                .StudyLayoutRequestLayoutAlertDialog.getEditTextIntText(this.replicateEditText));

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    void show(final io.swagger.client.model.StudyLayoutRequestLayout studyLayoutRequestLayout)
    {
        if (null != studyLayoutRequestLayout)
        {
            this.studyLayoutRequestLayout = studyLayoutRequestLayout;

            org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
                .setEditTextText(this.blockNumberEditText,
                    this.studyLayoutRequestLayout.getBlockNumber());
            this.setEntryTypeEnum(this.studyLayoutRequestLayout.getEntryType());
            org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
                .setEditTextText(this.observationUnitDbIdEditText,
                    this.studyLayoutRequestLayout.getObservationUnitDbId());
            org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
                .setEditTextText(this.positionCoordinateXEditText,
                    this.studyLayoutRequestLayout.getPositionCoordinateX());
            this.setPositionCoordinateXTypeEnum(
                this.studyLayoutRequestLayout.getPositionCoordinateXType());
            org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
                .setEditTextText(this.positionCoordinateYEditText,
                    this.studyLayoutRequestLayout.getPositionCoordinateY());
            this.setPositionCoordinateYTypeEnum(
                this.studyLayoutRequestLayout.getPositionCoordinateYType());
            org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequestLayoutAlertDialog
                .setEditTextText(this.replicateEditText,
                    this.studyLayoutRequestLayout.getReplicate());

            this.show();
        }
    }
}