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
 * android.widget.EditText
 *
 * io.swagger.client.ApiCallback
 * io.swagger.client.ApiException
 * io.swagger.client.api.LocationsApi
 * io.swagger.client.model.LocationResponse
 * io.swagger.client.model.LocationsResponse
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment
 */
public class LocationsFragment
extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment
{
    // region Fields
    private android.widget.EditText locationTypeEditText, locationDbIdEditText;

    private io.swagger.client.api.LocationsApi locationsApiInstance = null;             // lazy load

    private io.swagger.client.ApiCallback<io.swagger.client.model.LocationsResponse>
        locationsResponseCallbackInstance = null;                                       // lazy load
    private io.swagger.client.ApiCallback<io.swagger.client.model.LocationResponse>
        locationResponseCallbackInstance = null;                                        // lazy load
    // endregion

    // region Private Methods
    private io.swagger.client.api.LocationsApi locationsApi()
    {
        if (null == this.locationsApiInstance)
            this.locationsApiInstance = new io.swagger.client.api.LocationsApi(this.apiClient());
        return this.locationsApiInstance;
    }

    // region locationsGet() Private Methods
    private void setResponseTextViewTextFromThread(
    final io.swagger.client.model.LocationsResponse locationsResponse)
    {
        this.setResponseTextViewTextFromThread(
            null == locationsResponse ? "null" : locationsResponse.toString());
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.LocationsResponse>
    locationsResponseCallback()
    {
        if (null == this.locationsResponseCallbackInstance) this.locationsResponseCallbackInstance =
            new io.swagger.client.ApiCallback<io.swagger.client.model.LocationsResponse>()
            {
                @java.lang.Override public void onFailure(final io.swagger.client.ApiException e,
                final int                                                               i  ,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment
                        .this.setResponseTextViewTextFromThread(e);
                }

                @java.lang.Override public void onSuccess(
                final io.swagger.client.model.LocationsResponse locationsResponse, final int i,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment
                        .this.setResponseTextViewTextFromThread(locationsResponse);
                }

                @java.lang.Override public void onUploadProgress(
                final long l, final long l1, final boolean b) {}

                @java.lang.Override public void onDownloadProgress(
                final long l, final long l1, final boolean b) {}
            };
        return this.locationsResponseCallbackInstance;
    }

    private void locationsGet()
    {
        try
        {
            this.locationsApi().locationsGetAsync(
                /* locationType => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment.getString(
                        this.locationTypeEditText),
                /* page          => */ this.getPageEditTextIntText    (),
                /* pageSize      => */ this.getPageSizeEditTextIntText(),
                /* authorization => */ this.authorization             (),
                /* callback      => */ this.locationsResponseCallback ());
        }
        catch (final java.lang.Throwable t) { this.setResponseTextViewText(t); }
    }
    // endregion

    // region locationsLocationDbIdGet() Private Methods
    private void setResponseTextViewTextFromThread(
    final io.swagger.client.model.LocationResponse locationResponse)
    {
        this.setResponseTextViewTextFromThread(
            null == locationResponse ? "null" : locationResponse.toString());
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.LocationResponse>
    locationResponseCallback()
    {
        if (null == this.locationResponseCallbackInstance) this.locationResponseCallbackInstance =
            new io.swagger.client.ApiCallback<io.swagger.client.model.LocationResponse>()
            {
                @java.lang.Override public void onFailure(final io.swagger.client.ApiException e,
                final int                                                               i  ,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment
                        .this.setResponseTextViewTextFromThread(e);
                }

                @java.lang.Override public void onSuccess(
                final io.swagger.client.model.LocationResponse locationResponse, final int i,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment
                        .this.setResponseTextViewTextFromThread(locationResponse);
                }

                @java.lang.Override public void onUploadProgress(
                final long l, final long l1, final boolean b) {}

                @java.lang.Override public void onDownloadProgress(
                final long l, final long l1, final boolean b) {}
            };
        return this.locationResponseCallbackInstance;
    }

    private void locationsLocationDbIdGet()
    {
        try
        {
            this.locationsApi().locationsLocationDbIdGetAsync(
                /* locationDbId => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment.getString(
                        this.locationDbIdEditText),
                /* authorization => */ this.authorization           (),
                /* callback      => */ this.locationResponseCallback());
        }
        catch (final java.lang.Throwable t) { this.setResponseTextViewText(t); }
    }
    // endregion
    // endregion

    public LocationsFragment() {}

    @java.lang.Override @android.support.annotation.Nullable public android.view.View onCreateView(
    @android.support.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @android.support.annotation.Nullable final android.view.ViewGroup      container         ,
    @android.support.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = this.inflate(inflater, container,
            org.wheatgenetics.androidlibrarybuilder.R.layout.fragment_brapi1_3_locations);

        if (null != rootView)
        {
            // The following seven ids are from fragment_brapi1_3_locations.xml.
            this.locationTypeEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.locationTypeEditText);
            this.findPageEditTextById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.locationsPageEditText);
            this.findPageSizeEditTextById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.locationsPageSizeEditText);
            {
                final android.widget.Button locationsGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.locationsGetButton);
                if (null != locationsGetButton) locationsGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .LocationsFragment.this.locationsGet();
                        }
                    });
            }

            this.locationDbIdEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.locationsLocationDbIdEditText);
            {
                final android.widget.Button locationsLocationDbIdGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.locationsLocationDbIdGetButton);
                if (null != locationsLocationDbIdGetButton)
                    locationsLocationDbIdGetButton.setOnClickListener(
                        new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                    .LocationsFragment.this.locationsLocationDbIdGet();
                            }
                        });
            }

            this.findResponseTextViewById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.locationsResponseTextView);
        }

        return rootView;
    }
}