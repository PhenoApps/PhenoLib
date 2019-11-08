package org.wheatgenetics.brapi1_3.studies.nour;                 // nour: NewObservationUnitRequests

/**
 * Uses:
 * android.annotation.SuppressLint
 * android.app.Activity
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.Button
 * android.widget.EditText
 * android.widget.TextView
 *
 * androidx.annotation.IntRange
 * androidx.annotation.NonNull
 * androidx.annotation.Nullable
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateXTypeEnum
 * io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateYTypeEnum
 * io.swagger.client.model.Observation
 * io.swagger.client.model.ObservationTreatment
 * io.swagger.client.model.ObservationUnitXref
 *
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
 * org.wheatgenetics.brapi1_3.studies.nour.o.Observations
 * org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments
 * org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefs
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 * org.wheatgenetics.brapi1_3.TypeAlertDialog
 */
class NewObservationUnitRequestAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    // region Types
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) interface ActivityHandler
    {
        public abstract void showObservationUnitXrefListActivity(
        org.wheatgenetics.brapi1_3.studies.nour.oux.ObservationUnitXrefs observationUnitXrefs);

        public abstract void showObservationsListActivity(
        org.wheatgenetics.brapi1_3.studies.nour.o.Observations observations);

        public abstract void showObservationTreatmentsListActivity(
        org.wheatgenetics.brapi1_3.studies.nour.ot.ObservationTreatments observationTreatments);
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
                .NewObservationUnitRequestAlertDialogPositionCoordinateXTypeLabelTextViewText);
            super.configure();
        }

        @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
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
                    io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateXTypeEnum
                        positionCoordinateXTypeEnums[] = io.swagger.client.model
                            .NewObservationUnitRequest.PositionCoordinateXTypeEnum.values();
                    for (final
                    io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateXTypeEnum
                    positionCoordinateXTypeEnum: positionCoordinateXTypeEnums)
                        arrayList.add(positionCoordinateXTypeEnum.toString());
                }

                this.createItems(arrayList);
            }
            return super.items();
        }
        // endregion

        private io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateXTypeEnum item(
        @androidx.annotation.IntRange(from = 0) final int i)
        {
            return 0 == i ? null : io.swagger.client.model.NewObservationUnitRequest
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
                .NewObservationUnitRequestAlertDialogPositionCoordinateYTypeLabelTextViewText);
            super.configure();
        }

        @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
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
                    io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateYTypeEnum
                        positionCoordinateYTypeEnums[] = io.swagger.client.model
                            .NewObservationUnitRequest.PositionCoordinateYTypeEnum.values();
                    for (final
                    io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateYTypeEnum
                    positionCoordinateYTypeEnum: positionCoordinateYTypeEnums)
                        arrayList.add(positionCoordinateYTypeEnum.toString());
                }

                this.createItems(arrayList);
            }
            return super.items();
        }
        // endregion

        private io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateYTypeEnum item(
        @androidx.annotation.IntRange(from = 0) final int i)
        {
            return 0 == i ? null : io.swagger.client.model.NewObservationUnitRequest
                .PositionCoordinateYTypeEnum.fromValue(this.items()[i]);
        }
    }
    // endregion

    // region Fields
    private final
        org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog.ActivityHandler
            activityHandler;

    private android.widget.EditText blockNumberEditText, entryNumberEditText, entryTypeEditText,
        germplasmDbIdEditText, observationLevelEditText, observationUnitDbIdEditText,
        observationUnitNameEditText;
    private android.widget.TextView observationUnitXrefTextView, observationsTextView;
    private android.widget.EditText plantNumberEditText, plotNumberEditText,
        positionCoordinateXEditText;
    private android.widget.TextView positionCoordinateXTypeTextView     ;
    private android.widget.EditText positionCoordinateYEditText         ;
    private android.widget.TextView positionCoordinateYTypeTextView     ;
    private android.widget.EditText replicateEditText, studyDbIdEditText;
    private android.widget.TextView observationTreatmentsTextView       ;

    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
        permanentNewObservationUnitRequest = null, temporaryNewObservationUnitRequest = null;
    private io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateXTypeEnum
        positionCoordinateXTypeEnum = null;
    private io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateYTypeEnum
        positionCoordinateYTypeEnum = null;

    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
        .PositionCoordinateXTypeAlertDialog positionCoordinateXTypeAlertDialogInstance = null; // ll
    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
        .PositionCoordinateYTypeAlertDialog positionCoordinateYTypeAlertDialogInstance = null; // ll
    // endregion

    // region Private Methods
    @android.annotation.SuppressLint({"DefaultLocale"}) private static <T> void setTextViewText(
    @androidx.annotation.Nullable final android.widget.TextView textView,
    @androidx.annotation.Nullable final java.util.List<T>       list    ,
    @androidx.annotation.NonNull  final java.lang.String        label   )
    {
        if (null != textView) textView.setText(null == list ? "null" :
            java.lang.String.format("%d %s(s)", list.size(), label));
    }

    private static void setTextViewText(
    @androidx.annotation.Nullable final android.widget.TextView textView,
    @androidx.annotation.Nullable final java.lang.Object        object  )
    { if (null != textView) textView.setText(null == object ? "null" : object.toString()); }

    // region observationUnitXref Private Methods
    private void showObservationUnitXrefListActivity()
    {
        this.activityHandler.showObservationUnitXrefListActivity(
            null == this.temporaryNewObservationUnitRequest ? null :
                this.temporaryNewObservationUnitRequest.getObservationUnitXrefsAsItems());
    }

    private void setObservationUnitXrefTextViewText(@androidx.annotation.Nullable
    final java.util.List<io.swagger.client.model.ObservationUnitXref> observationUnitXref)
    {
        org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
            .setTextViewText(this.observationUnitXrefTextView,
                observationUnitXref,"observationUnitXref");
    }

    private void setObservationUnitXrefTextViewText()
    {
        this.setObservationUnitXrefTextViewText(null == this.temporaryNewObservationUnitRequest ?
            null : this.temporaryNewObservationUnitRequest.getObservationUnitXref());
    }
    // endregion

    // region observations Private Methods
    private void showObservationsListActivity()
    {
        this.activityHandler.showObservationsListActivity(
            null == this.temporaryNewObservationUnitRequest ? null :
                this.temporaryNewObservationUnitRequest.getObservationsAsItems());
    }

    private void setObservationsTextViewText(@androidx.annotation.Nullable
    final java.util.List<io.swagger.client.model.Observation> observations)
    {
        org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
            .setTextViewText(this.observationsTextView, observations,"observation");
    }

    private void setObservationsTextViewText()
    {
        this.setObservationsTextViewText(null == this.temporaryNewObservationUnitRequest ?
            null : this.temporaryNewObservationUnitRequest.getObservations());
    }
    // endregion

    // region positionCoordinateXType Private Methods
    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
    .PositionCoordinateXTypeAlertDialog positionCoordinateXTypeAlertDialog()
    {
        if (null == this.positionCoordinateXTypeAlertDialogInstance)
        {
            this.positionCoordinateXTypeAlertDialogInstance = new org.wheatgenetics.brapi1_3.studies
                .nour.NewObservationUnitRequestAlertDialog.PositionCoordinateXTypeAlertDialog(
                    this.activity());
            this.positionCoordinateXTypeAlertDialogInstance.setOnClickListener(
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override public void onClick(
                    final android.content.DialogInterface dialog, final int which)
                    {
                        org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                            .this.setPositionCoordinateXTypeEnum(which);
                    }
                }
            );
        }
        return this.positionCoordinateXTypeAlertDialogInstance;
    }

    private void showPositionCoordinateXTypeAlertDialog()
    { this.positionCoordinateXTypeAlertDialog().show(); }

    private void setPositionCoordinateXTypeTextViewText(
    final io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateXTypeEnum
    positionCoordinateXTypeEnum)
    {
        org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
            .setTextViewText(this.positionCoordinateXTypeTextView, positionCoordinateXTypeEnum);
    }

    private void setPositionCoordinateXTypeEnum(
    final io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateXTypeEnum
    positionCoordinateXTypeEnum)
    {
        this.setPositionCoordinateXTypeTextViewText(
            this.positionCoordinateXTypeEnum = positionCoordinateXTypeEnum);
    }

    private void setPositionCoordinateXTypeEnum(@androidx.annotation.IntRange(from = 0) final int i)
    { this.setPositionCoordinateXTypeEnum(this.positionCoordinateXTypeAlertDialog().item(i)); }
    // endregion

    // region positionCoordinateYType Private Methods
    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
    .PositionCoordinateYTypeAlertDialog positionCoordinateYTypeAlertDialog()
    {
        if (null == this.positionCoordinateYTypeAlertDialogInstance)
        {
            this.positionCoordinateYTypeAlertDialogInstance = new org.wheatgenetics.brapi1_3.studies
                .nour.NewObservationUnitRequestAlertDialog.PositionCoordinateYTypeAlertDialog(
                this.activity());
            this.positionCoordinateYTypeAlertDialogInstance.setOnClickListener(
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override public void onClick(
                        final android.content.DialogInterface dialog, final int which)
                    {
                        org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                            .this.setPositionCoordinateYTypeEnum(which);
                    }
                }
            );
        }
        return this.positionCoordinateYTypeAlertDialogInstance;
    }

    private void showPositionCoordinateYTypeAlertDialog()
    { this.positionCoordinateYTypeAlertDialog().show(); }

    private void setPositionCoordinateYTypeTextViewText(
    final io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateYTypeEnum
    positionCoordinateYTypeEnum)
    {
        org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
            .setTextViewText(this.positionCoordinateYTypeTextView, positionCoordinateYTypeEnum);
    }

    private void setPositionCoordinateYTypeEnum(
    final io.swagger.client.model.NewObservationUnitRequest.PositionCoordinateYTypeEnum
    positionCoordinateYTypeEnum)
    {
        this.setPositionCoordinateYTypeTextViewText(
            this.positionCoordinateYTypeEnum = positionCoordinateYTypeEnum);
    }

    private void setPositionCoordinateYTypeEnum(@androidx.annotation.IntRange(from = 0) final int i)
    { this.setPositionCoordinateYTypeEnum(this.positionCoordinateYTypeAlertDialog().item(i)); }
    // endregion

    // region observationTreatments Private Methods
    private void showObservationTreatmentsListActivity()
    {
        this.activityHandler.showObservationTreatmentsListActivity(
            null == this.temporaryNewObservationUnitRequest ? null :
                this.temporaryNewObservationUnitRequest.getObservationTreatmentsAsItems());
    }

    private void setObservationTreatmentsTextViewText(@androidx.annotation.Nullable
    final java.util.List<io.swagger.client.model.ObservationTreatment> observationTreatments)
    {
        org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
            .setTextViewText(this.observationTreatmentsTextView,
                observationTreatments,"observationTreatment");
    }

    private void setObservationTreatmentsTextViewText()
    {
        this.setObservationTreatmentsTextViewText(null == this.temporaryNewObservationUnitRequest ?
            null : this.temporaryNewObservationUnitRequest.getTreatments());
    }
    // endregion
    // endregion

    NewObservationUnitRequestAlertDialog(final android.app.Activity activity, final
    org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog.Handler handler,
    @androidx.annotation.NonNull final
        org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog.ActivityHandler
        activityHandler) { super(activity, handler); this.activityHandler = activityHandler; }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(
            org.wheatgenetics.androidlibrary.R.string.NewObservationUnitRequestAlertDialogTitle);
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrary
                .R.layout.alert_dialog_brapi1_3_studies_new_observation_unit_request);
            if (null != view)
            {
                if (null == this.blockNumberEditText) this.blockNumberEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestBlockNumberEditText);
                if (null == this.entryNumberEditText) this.entryNumberEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestEntryNumberEditText);
                if (null == this.entryTypeEditText) this.entryTypeEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestEntryTypeEditText);
                if (null == this.germplasmDbIdEditText) this.germplasmDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestGermplasmDbIdEditText);
                if (null == this.observationLevelEditText) this.observationLevelEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestObservationLevelEditText);
                if (null == this.observationUnitDbIdEditText) this.observationUnitDbIdEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestObservationUnitDbIdEditText);
                if (null == this.observationUnitNameEditText) this.observationUnitNameEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestObservationUnitNameEditText);

                if (null == this.observationUnitXrefTextView) this.observationUnitXrefTextView =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestObservationUnitXrefValueTextView);
                {
                    final android.widget.Button changeObservationUnitXrefButton = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .studiesNewObservationUnitRequestChangeObservationUnitXrefButton);
                    if (null != changeObservationUnitXrefButton)
                        changeObservationUnitXrefButton.setOnClickListener(
                            new android.view.View.OnClickListener()
                            {
                                @java.lang.Override public void onClick(final android.view.View v)
                                {
                                    org.wheatgenetics.brapi1_3.studies.nour
                                        .NewObservationUnitRequestAlertDialog
                                        .this.showObservationUnitXrefListActivity();
                                }
                            });
                }

                if (null == this.observationsTextView) this.observationsTextView =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestObservationsValueTextView);
                {
                    final android.widget.Button changeObservationsButton = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .studiesNewObservationUnitRequestChangeObservationsButton);
                    if (null != changeObservationsButton)
                        changeObservationsButton.setOnClickListener(
                            new android.view.View.OnClickListener()
                            {
                                @java.lang.Override public void onClick(final android.view.View v)
                                {
                                    org.wheatgenetics.brapi1_3.studies.nour
                                        .NewObservationUnitRequestAlertDialog
                                        .this.showObservationsListActivity();
                                }
                            });
                }

                if (null == this.plantNumberEditText) this.plantNumberEditText = view.findViewById
                    (org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestPlantNumberEditText);
                if (null == this.plotNumberEditText) this.plotNumberEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestPlotNumberEditText);
                if (null == this.positionCoordinateXEditText) this.positionCoordinateXEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestPositionCoordinateXEditText);

                if (null == this.positionCoordinateXTypeTextView)
                    this.positionCoordinateXTypeTextView = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .studiesNewObservationUnitRequestPositionCoordinateXTypeValueTextView);
                {
                    final android.widget.Button changePositionCoordinateXTypeButton =
                        view.findViewById(org.wheatgenetics.androidlibrary.R.id
                            .studiesNewObservationUnitRequestChangePositionCoordinateXTypeButton);
                    if (null != changePositionCoordinateXTypeButton)
                        changePositionCoordinateXTypeButton.setOnClickListener(
                            new android.view.View.OnClickListener()
                            {
                                @java.lang.Override public void onClick(final android.view.View v)
                                {
                                    org.wheatgenetics.brapi1_3.studies.nour
                                        .NewObservationUnitRequestAlertDialog.this
                                        .showPositionCoordinateXTypeAlertDialog();
                                }
                            }
                        );
                }

                if (null == this.positionCoordinateYEditText) this.positionCoordinateYEditText =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestPositionCoordinateYEditText);

                if (null == this.positionCoordinateYTypeTextView)
                    this.positionCoordinateYTypeTextView = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .studiesNewObservationUnitRequestPositionCoordinateYTypeValueTextView);
                {
                    final android.widget.Button changePositionCoordinateYTypeButton =
                        view.findViewById(org.wheatgenetics.androidlibrary.R.id
                            .studiesNewObservationUnitRequestChangePositionCoordinateYTypeButton);
                    if (null != changePositionCoordinateYTypeButton)
                        changePositionCoordinateYTypeButton.setOnClickListener(
                            new android.view.View.OnClickListener()
                            {
                                @java.lang.Override public void onClick(final android.view.View v)
                                {
                                    org.wheatgenetics.brapi1_3.studies.nour
                                        .NewObservationUnitRequestAlertDialog.this
                                        .showPositionCoordinateYTypeAlertDialog();
                                }
                            }
                        );
                }

                if (null == this.replicateEditText) this.replicateEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestReplicateEditText);
                if (null == this.studyDbIdEditText) this.studyDbIdEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestStudyDbIdEditText);

                if (null == this.observationTreatmentsTextView) this.observationTreatmentsTextView =
                    view.findViewById(org.wheatgenetics.androidlibrary.R.id
                        .studiesNewObservationUnitRequestObservationTreatmentsValueTextView);
                {
                    final android.widget.Button changeObservationTreatmentsButton =
                        view.findViewById(org.wheatgenetics.androidlibrary.R.id
                            .studiesNewObservationUnitRequestChangeObservationTreatmentsButton);
                    if (null != changeObservationTreatmentsButton)
                        changeObservationTreatmentsButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.brapi1_3.studies.nour
                                    .NewObservationUnitRequestAlertDialog
                                    .this.showObservationTreatmentsListActivity();
                            }
                        });
                }
            }
            this.setView(view);
        }
        super.configure();
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.permanentNewObservationUnitRequest)
        {
            this.permanentNewObservationUnitRequest.setBlockNumber(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.blockNumberEditText));
            this.permanentNewObservationUnitRequest.setEntryNumber(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.entryNumberEditText));
            this.permanentNewObservationUnitRequest.setEntryType(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.entryTypeEditText));
            this.permanentNewObservationUnitRequest.setGermplasmDbId(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.germplasmDbIdEditText));
            this.permanentNewObservationUnitRequest.setObservationLevel(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.observationLevelEditText));
            this.permanentNewObservationUnitRequest.setObservationUnitDbId(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.observationUnitDbIdEditText));
            this.permanentNewObservationUnitRequest.setObservationUnitName(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.observationUnitNameEditText));
            this.permanentNewObservationUnitRequest.setObservationUnitXrefsAsItems(
                this.temporaryNewObservationUnitRequest.getObservationUnitXrefsAsItems());
            this.permanentNewObservationUnitRequest.setObservationsAsItems(
                this.temporaryNewObservationUnitRequest.getObservationsAsItems());
            this.permanentNewObservationUnitRequest.setPlantNumber(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.plantNumberEditText));
            this.permanentNewObservationUnitRequest.setPlotNumber(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.plotNumberEditText));
            this.permanentNewObservationUnitRequest.setPositionCoordinateX(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.positionCoordinateXEditText));
            this.permanentNewObservationUnitRequest.setPositionCoordinateXType(
                this.positionCoordinateXTypeEnum);
            this.permanentNewObservationUnitRequest.setPositionCoordinateY(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.positionCoordinateYEditText));
            this.permanentNewObservationUnitRequest.setPositionCoordinateYType(
                this.positionCoordinateYTypeEnum);
            this.permanentNewObservationUnitRequest.setReplicate(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.replicateEditText));
            this.permanentNewObservationUnitRequest.setStudyDbId(
                org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                    .getEditTextStringText(this.studyDbIdEditText));
            this.permanentNewObservationUnitRequest.setObservationTreatmentsAsItems(
                this.temporaryNewObservationUnitRequest.getObservationTreatmentsAsItems());

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    // region Package Methods
    // region set() and clear() Package Methods
    void setObservationUnitXrefs(final java.lang.String json)
    {
        if (null != this.temporaryNewObservationUnitRequest)
            this.temporaryNewObservationUnitRequest.setObservationUnitXrefsAsItems(json);
        this.setObservationUnitXrefTextViewText();
    }

    void clearObservationUnitXrefs()
    {
        if (null != this.temporaryNewObservationUnitRequest)
            this.temporaryNewObservationUnitRequest.clearObservationUnitXrefsAsItems();
        this.setObservationUnitXrefTextViewText();
    }

    void setObservations(final java.lang.String json)
    {
        if (null != this.temporaryNewObservationUnitRequest)
            this.temporaryNewObservationUnitRequest.setObservationsAsItems(json);
        this.setObservationsTextViewText();
    }

    void clearObservations()
    {
        if (null != this.temporaryNewObservationUnitRequest)
            this.temporaryNewObservationUnitRequest.clearObservationsAsItems();
        this.setObservationsTextViewText();
    }

    void setObservationTreatments(final java.lang.String json)
    {
        if (null != this.temporaryNewObservationUnitRequest)
            this.temporaryNewObservationUnitRequest.setObservationTreatmentsAsItems(json);
        this.setObservationTreatmentsTextViewText();
    }

    void clearObservationTreatments()
    {
        if (null != this.temporaryNewObservationUnitRequest)
            this.temporaryNewObservationUnitRequest.clearObservationTreatmentsAsItems();
        this.setObservationTreatmentsTextViewText();
    }
    // endregion

    void show(final org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
    permanentNewObservationUnitRequest)
    {
        if (null != permanentNewObservationUnitRequest)
        {
            this.permanentNewObservationUnitRequest = permanentNewObservationUnitRequest;
            this.temporaryNewObservationUnitRequest =
                new org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest(
                    this.permanentNewObservationUnitRequest);

            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.blockNumberEditText,
                    this.temporaryNewObservationUnitRequest.getBlockNumber());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.entryNumberEditText,
                    this.temporaryNewObservationUnitRequest.getEntryNumber());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.entryTypeEditText,
                    this.temporaryNewObservationUnitRequest.getEntryType());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.germplasmDbIdEditText,
                    this.temporaryNewObservationUnitRequest.getGermplasmDbId());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.observationLevelEditText,
                    this.temporaryNewObservationUnitRequest.getObservationLevel());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.observationUnitDbIdEditText,
                    this.temporaryNewObservationUnitRequest.getObservationUnitDbId());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.observationUnitNameEditText,
                    this.temporaryNewObservationUnitRequest.getObservationUnitName());
            this.setObservationUnitXrefTextViewText();
            this.setObservationsTextViewText       ();
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.plantNumberEditText,
                    this.temporaryNewObservationUnitRequest.getPlantNumber());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.plotNumberEditText,
                    this.temporaryNewObservationUnitRequest.getPlotNumber());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.positionCoordinateXEditText,
                    this.temporaryNewObservationUnitRequest.getPositionCoordinateX());
            this.setPositionCoordinateXTypeEnum(
                this.temporaryNewObservationUnitRequest.getPositionCoordinateXType());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.positionCoordinateYEditText,
                    this.temporaryNewObservationUnitRequest.getPositionCoordinateY());
            this.setPositionCoordinateYTypeEnum(
                this.temporaryNewObservationUnitRequest.getPositionCoordinateYType());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.replicateEditText,
                    this.temporaryNewObservationUnitRequest.getReplicate());
            org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequestAlertDialog
                .setEditTextText(this.studyDbIdEditText,
                    this.temporaryNewObservationUnitRequest.getStudyDbId());
            this.setObservationTreatmentsTextViewText();

            this.show();
        }
    }
    // endregion
}