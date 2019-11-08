package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.os.Bundle
 * android.view.LayoutInflater
 * android.view.View
 * android.view.View.OnClickListener
 * android.view.ViewGroup
 * android.widget.Button
 * android.widget.EditText
 *
 * androidx.annotation.NonNull
 * androidx.annotation.Nullable
 *
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

    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment.ApiCallback< // lazy
        io.swagger.client.model.LocationsResponse> locationsResponseCallbackInstance = null;//  load
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment.ApiCallback< // lazy
        io.swagger.client.model.LocationResponse> locationResponseCallbackInstance = null;  //  load
    // endregion

    // region Private Methods
    private io.swagger.client.api.LocationsApi locationsApi()
    {
        if (null == this.locationsApiInstance)
            this.locationsApiInstance = new io.swagger.client.api.LocationsApi(this.apiClient());
        return this.locationsApiInstance;
    }

    // region locationsGet() Private Methods
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment.ApiCallback<
    io.swagger.client.model.LocationsResponse> locationsResponseCallback()
    {
        if (null == this.locationsResponseCallbackInstance) this.locationsResponseCallbackInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment.ApiCallback<
                io.swagger.client.model.LocationsResponse>() {};
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
    private org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment.ApiCallback<
    io.swagger.client.model.LocationResponse> locationResponseCallback()
    {
        if (null == this.locationResponseCallbackInstance) this.locationResponseCallbackInstance =
            new org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment.ApiCallback<
                io.swagger.client.model.LocationResponse>() {};
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

    @java.lang.Override @androidx.annotation.Nullable public android.view.View onCreateView(
    @androidx.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @androidx.annotation.Nullable final android.view.ViewGroup      container         ,
    @androidx.annotation.Nullable final android.os.Bundle           savedInstanceState)
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