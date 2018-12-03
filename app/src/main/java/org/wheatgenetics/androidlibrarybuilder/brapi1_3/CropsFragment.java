package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.os.Bundle
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.view.LayoutInflater
 * android.view.View
 * android.view.View.OnClickListener
 * android.view.ViewGroup
 * android.widget.Button
 *
 * io.swagger.client.ApiCallback
 * io.swagger.client.ApiException
 * io.swagger.client.api.CropsApi
 * io.swagger.client.model.CommonCropNamesResponse
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment
 */
public class CropsFragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment
implements android.view.View.OnClickListener
{
    // region Fields
    private io.swagger.client.api.CropsApi cropsApiInstance = null;
    private io.swagger.client.ApiCallback<io.swagger.client.model.CommonCropNamesResponse>
        callbackInstance = null;
    // endregion

    // region Private Methods
    private io.swagger.client.api.CropsApi cropsApi()
    {
        if (null == this.cropsApiInstance)
            this.cropsApiInstance = new io.swagger.client.api.CropsApi();
        return this.cropsApiInstance;
    }

    private void setResponseTextViewText(final io.swagger.client.model.CommonCropNamesResponse
        commonCropNamesResponse)
    {
        this.setResponseTextViewTextFromThread(
            null == commonCropNamesResponse ? "null" : commonCropNamesResponse.toString());
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.CommonCropNamesResponse>
    callback()
    {
        if (null == this.callbackInstance) this.callbackInstance =
            new io.swagger.client.ApiCallback<io.swagger.client.model.CommonCropNamesResponse>()
            {
                @java.lang.Override public void onFailure(
                final io.swagger.client.ApiException                                    e  ,
                final int                                                               i  ,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.CropsFragment
                        .this.setResponseTextViewTextFromThread(e);
                }

                @java.lang.Override public void onSuccess(
                final io.swagger.client.model.CommonCropNamesResponse commonCropNamesResponse,
                final int                                                               i    ,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map  )
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.CropsFragment
                        .this.setResponseTextViewText(commonCropNamesResponse);
                }

                @java.lang.Override public void onUploadProgress(
                final long l, final long l1, final boolean b) {}

                @java.lang.Override public void onDownloadProgress(
                final long l, final long l1, final boolean b) {}
            };
        return this.callbackInstance;
    }
    // endregion

    public CropsFragment() {}

    // region Overridden Methods
    @android.support.annotation.Nullable @java.lang.Override public android.view.View onCreateView(
    @android.support.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @android.support.annotation.Nullable final android.view.ViewGroup      container         ,
    @android.support.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = this.inflate(inflater, container,
            org.wheatgenetics.androidlibrarybuilder.R.layout.fragment_brapi1_3_crops);

        // The following four ids are from fragment_brapi1_3_crops.xml.
        assert null != rootView; this.findPageEditTextById(rootView,
            org.wheatgenetics.androidlibrarybuilder.R.id.cropsPageEditText);
        this.findPageSizeEditTextById(rootView,
            org.wheatgenetics.androidlibrarybuilder.R.id.cropsPageSizeEditText);
        {
            final android.widget.Button commoncropnamesGetButton = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.commoncropnamesGetButton);
            if (null != commoncropnamesGetButton) commoncropnamesGetButton.setOnClickListener(this);
        }
        this.findResponseTextViewById(rootView,
            org.wheatgenetics.androidlibrarybuilder.R.id.cropsResponseTextView);

        return rootView;
    }

    @java.lang.Override public void onClick(final android.view.View v)
    {
        try
        {
            this.cropsApi().commoncropnamesGetAsync(
                /* page          => */ this.getPageEditTextIntText    (),
                /* pageSize      => */ this.getPageSizeEditTextIntText(),
                /* authorization => */null,
                /* callback      => */ this.callback());
        }
        catch (final java.lang.Throwable e) { this.setResponseTextViewText(e); }
    }
    // endregion
}