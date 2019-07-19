package org.wheatgenetics.brapi1_3.studies;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.widget.EditText
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.AlertDialog
 *
 * org.wheatgenetics.brapi1_3.studies.NewObservationsTableRequest
 */
public class NewObservationsTableRequestAlertDialog extends org.wheatgenetics.brapi1_3.AlertDialog
{
    public enum Format { CSV, TSV }

    // region Fields
    private android.widget.EditText headerRowEditText,
        observationVariableDbIdsEditText, dataEditText;

    private org.wheatgenetics.brapi1_3.studies.NewObservationsTableRequest
        newObservationsTableRequest = null;
    private org.wheatgenetics.brapi1_3.studies.NewObservationsTableRequestAlertDialog.Format format;
    // endregion

    public NewObservationsTableRequestAlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.studies.NewObservationsTableRequestAlertDialog.Handler handler)
    { super(activity, handler); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(
            org.wheatgenetics.androidlibrary.R.string.NewObservationsTableRequestAlertDialogTitle);
        {
            final android.view.View view = this.inflate(org.wheatgenetics.androidlibrary
                .R.layout.alert_dialog_brapi1_3_studies_new_observations_table_request);
            if (null != view)
            {
                if (null == this.headerRowEditText) this.headerRowEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id
                        .newObservationsTableRequestHeaderRowEditText);
                if (null == this.observationVariableDbIdsEditText)
                    this.observationVariableDbIdsEditText = view.findViewById(
                        org.wheatgenetics.androidlibrary.R.id
                            .newObservationsTableRequestObservationVariableDbIdsEditText);
                if (null == this.dataEditText) this.dataEditText = view.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.newObservationsTableRequestDataEditText);
            }
            this.setView(view);
        }
        super.configure();
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected void handlePositiveButtonClick()
    {
        if (null != this.newObservationsTableRequest)
        {
            final java.lang.String
                headerRow = org.wheatgenetics.brapi1_3.studies
                    .NewObservationsTableRequestAlertDialog.getEditTextStringText(
                        this.headerRowEditText),
                observationVariableDbIds = org.wheatgenetics.brapi1_3.studies
                    .NewObservationsTableRequestAlertDialog.getEditTextStringText(
                        this.observationVariableDbIdsEditText),
                data = org.wheatgenetics.brapi1_3.studies
                    .NewObservationsTableRequestAlertDialog.getEditTextStringText(
                        this.dataEditText);

            // noinspection SwitchStatementWithTooFewBranches
            switch (this.format)
            {
                case TSV:
                    this.newObservationsTableRequest.setHeaderRowFromTSV               (headerRow);
                    this.newObservationsTableRequest.setObservationVariableDbIdsFromTSV(
                        observationVariableDbIds);
                    this.newObservationsTableRequest.setDataFromTSV(data); break;

                default:
                    this.newObservationsTableRequest.setHeaderRowFromCSV               (headerRow);
                    this.newObservationsTableRequest.setObservationVariableDbIdsFromCSV(
                        observationVariableDbIds);
                    this.newObservationsTableRequest.setDataFromCSV(data); break;
            }

            super.handlePositiveButtonClick();
        }
    }
    // endregion

    // region Public Methods
    public void show(final
    org.wheatgenetics.brapi1_3.studies.NewObservationsTableRequest newObservationsTableRequest,
    final org.wheatgenetics.brapi1_3.studies.NewObservationsTableRequestAlertDialog.Format format)
    {
        if (null != newObservationsTableRequest)
        {
            this.newObservationsTableRequest = newObservationsTableRequest;
            this.format                      = format                     ;

            {
                final java.lang.String headerRow, observationVariableDbIds, data;

                // noinspection SwitchStatementWithTooFewBranches
                switch (this.format)
                {
                    case TSV:
                        headerRow = this.newObservationsTableRequest.getHeaderRowAsTSV();
                        observationVariableDbIds =
                            this.newObservationsTableRequest.getObservationVariableDbIdsAsTSV();
                        data = this.newObservationsTableRequest.getDataAsTSV(); break;

                    default:
                        headerRow = this.newObservationsTableRequest.getHeaderRowAsCSV();
                        observationVariableDbIds =
                            this.newObservationsTableRequest.getObservationVariableDbIdsAsCSV();
                        data = this.newObservationsTableRequest.getDataAsCSV(); break;
                }

                org.wheatgenetics.brapi1_3.studies.NewObservationsTableRequestAlertDialog
                    .setEditTextText(this.headerRowEditText, headerRow);
                org.wheatgenetics.brapi1_3.studies.NewObservationsTableRequestAlertDialog
                    .setEditTextText(
                        this.observationVariableDbIdsEditText, observationVariableDbIds);
                org.wheatgenetics.brapi1_3.studies.NewObservationsTableRequestAlertDialog
                    .setEditTextText(this.dataEditText, data);
            }
            this.show();
        }
    }

    public void show(final
    org.wheatgenetics.brapi1_3.studies.NewObservationsTableRequest newObservationsTableRequest,
    @android.support.annotation.Nullable final java.lang.String stringFormat)
    {
        final org.wheatgenetics.brapi1_3.studies.NewObservationsTableRequestAlertDialog.Format
            enumFormat;
        if (null == stringFormat)
            enumFormat = org.wheatgenetics.brapi1_3.studies
                .NewObservationsTableRequestAlertDialog.Format.CSV;
        else
            enumFormat = stringFormat.trim().toLowerCase().equals("tsv") ?
                org.wheatgenetics.brapi1_3.studies
                    .NewObservationsTableRequestAlertDialog.Format.TSV :
                org.wheatgenetics.brapi1_3.studies
                    .NewObservationsTableRequestAlertDialog.Format.CSV;
        this.show(newObservationsTableRequest, enumFormat);
    }
    // endregion
}