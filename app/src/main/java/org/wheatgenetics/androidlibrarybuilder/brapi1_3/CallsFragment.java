package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 * android.os.Bundle
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.view.LayoutInflater
 * android.view.View
 * android.view.View.OnClickListener
 * android.view.ViewGroup
 * android.widget.Button
 * android.widget.TextView
 *
 * io.swagger.client.api.CallsApi
 * io.swagger.client.model.CallsResponse
 * io.swagger.client.model.WSMIMEDataTypes
 *
 * org.wheatgenetics.brapi1_3.DataTypeAlertDialog
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment.ApiCallback
 */
public class CallsFragment
extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment
{
    // region Fields
    private android.widget.TextView dataTypeTextView;

    private io.swagger.client.model.WSMIMEDataTypes        dataType                    = null;
    private org.wheatgenetics.brapi1_3.DataTypeAlertDialog dataTypeAlertDialogInstance = null; // ll

    private io.swagger.client.api.CallsApi callsApiInstance = null;                     // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment.ApiCallback<
        io.swagger.client.model.CallsResponse> callbackInstance = null;                 // lazy load
    // endregion

    // region Private Methods
    // region dataType Private Methods
    private void setDataType(@android.support.annotation.IntRange(from = 0) final int i)
    {
        this.dataType = this.dataTypeAlertDialog().item(i);
        if (null != this.dataTypeTextView) this.dataTypeTextView.setText(
            null == this.dataType ? "null" : this.dataType.toString());
    }

    private org.wheatgenetics.brapi1_3.DataTypeAlertDialog dataTypeAlertDialog()
    {
        if (null == this.dataTypeAlertDialogInstance)
        {
            this.dataTypeAlertDialogInstance =
                new org.wheatgenetics.brapi1_3.DataTypeAlertDialog(this.getActivity());
            this.dataTypeAlertDialogInstance.setOnClickListener(
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override public void onClick(
                    final android.content.DialogInterface dialog, final int which)
                    {
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3
                            .CallsFragment.this.setDataType(which);
                    }
                });
        }
        return this.dataTypeAlertDialogInstance;
    }

    private void showDataTypeAlertDialog() { this.dataTypeAlertDialog().show(); }
    // endregion

    // region callsGet() Private Methods
    private io.swagger.client.api.CallsApi callsApi()
    {
        if (null == this.callsApiInstance)
            this.callsApiInstance = new io.swagger.client.api.CallsApi(this.apiClient());
        return this.callsApiInstance;
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment.ApiCallback<
    io.swagger.client.model.CallsResponse> callback()
    {
        if (null == this.callbackInstance) this.callbackInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment.ApiCallback<
                io.swagger.client.model.CallsResponse>() {};
        return this.callbackInstance;
    }

    private void callsGet()
    {
        try
        {
            this.callsApi().callsGetAsync(
                /* datatype      => */null,
                /* dataType      => */ this.dataType                    ,
                /* page          => */ this.getPageEditTextIntText    (),
                /* pageSize      => */ this.getPageSizeEditTextIntText(),
                /* authorization => */ this.authorization             (),
                /* callback      => */ this.callback                  ());
        }
        catch (final java.lang.Throwable e) { this.setResponseTextViewText(e); }
    }
    // endregion
    // endregion

    public CallsFragment() {}

    @java.lang.Override @android.support.annotation.Nullable public android.view.View onCreateView(
    @android.support.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @android.support.annotation.Nullable final android.view.ViewGroup      container         ,
    @android.support.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = this.inflate(inflater, container,
            org.wheatgenetics.androidlibrarybuilder.R.layout.fragment_brapi1_3_calls);
        if (null != rootView)
        {
            // The following six ids are from fragment_brapi1_3_calls.xml.
            this.dataTypeTextView = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.callsDataTypeValueTextView);
            {
                final android.widget.Button changeDataTypeButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.callsChangeDataTypeButton);
                if (null != changeDataTypeButton) changeDataTypeButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .CallsFragment.this.showDataTypeAlertDialog();
                        }
                    });
            }
            this.findPageEditTextById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.callsPageEditText);
            this.findPageSizeEditTextById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.callsPageSizeEditText);
            {
                final android.widget.Button callsGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.callsGetButton);
                if (null != callsGetButton) callsGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .CallsFragment.this.callsGet();
                        }
                    });
            }
            this.findResponseTextViewById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.callsResponseTextView);
        }
        return rootView;
    }
}