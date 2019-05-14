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
    private io.swagger.client.api.CropsApi cropsApiInstance = null;                     // lazy load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.CropsFragment.ApiCallback<
        io.swagger.client.model.CommonCropNamesResponse> callbackInstance = null;       // lazy load
    // endregion

    // region Private Methods
    private io.swagger.client.api.CropsApi cropsApi()
    {
        if (null == this.cropsApiInstance)
            this.cropsApiInstance = new io.swagger.client.api.CropsApi(this.apiClient());
        return this.cropsApiInstance;
    }

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.CropsFragment.ApiCallback<
    io.swagger.client.model.CommonCropNamesResponse> callback()
    {
        if (null == this.callbackInstance) this.callbackInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.CropsFragment.ApiCallback<
                io.swagger.client.model.CommonCropNamesResponse>() {};
        return this.callbackInstance;
    }
    // endregion

    public CropsFragment() {}

    // region Overridden Methods
    @java.lang.Override @android.support.annotation.Nullable public android.view.View onCreateView(
    @android.support.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @android.support.annotation.Nullable final android.view.ViewGroup      container         ,
    @android.support.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = this.inflate(inflater, container,
            org.wheatgenetics.androidlibrarybuilder.R.layout.fragment_brapi1_3_crops);
        if (null != rootView)
        {
            // The following four ids are from fragment_brapi1_3_crops.xml.
            this.findPageEditTextById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.cropsPageEditText);
            this.findPageSizeEditTextById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.cropsPageSizeEditText);
            {
                final android.widget.Button commoncropnamesGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.commoncropnamesGetButton);
                if (null != commoncropnamesGetButton)
                    commoncropnamesGetButton.setOnClickListener(this);
            }
            this.findResponseTextViewById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.cropsResponseTextView);
        }
        return rootView;
    }

    // region android.view.View.OnClickListener Overridden Method
    @java.lang.Override public void onClick(final android.view.View v)
    {
        try
        {
            this.cropsApi().commoncropnamesGetAsync(
                /* page          => */ this.getPageEditTextIntText    (),
                /* pageSize      => */ this.getPageSizeEditTextIntText(),
                /* authorization => */ this.authorization             (),
                /* callback      => */ this.callback                  ());
        }
        catch (final java.lang.Throwable e) { this.setResponseTextViewText(e); }
    }
    // endregion
    // endregion
}