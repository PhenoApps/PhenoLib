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
 * android.widget.RadioGroup
 *
 * io.swagger.client.ApiCallback
 * io.swagger.client.ApiException
 * io.swagger.client.api.TrialsApi
 * io.swagger.client.model.TrialResponse
 * io.swagger.client.model.TrialsResponse
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment
 */
public class TrialsFragment extends org.wheatgenetics.androidlibrarybuilder.brapi1_3.PagedFragment
{
    // region Fields
    private android.widget.EditText commonCropNameEditText, programDbIdEditText,
        locationDbIdEditText, sortByEditText, sortOrderEditText, trialDbIdEditText;
    private android.widget.RadioGroup activeRadioGroup;

    private io.swagger.client.api.TrialsApi trialsApiInstance = null;                   // lazy load

    private io.swagger.client.ApiCallback<io.swagger.client.model.TrialsResponse>
        trialsResponseCallbackInstance = null;                                          // lazy load
    private io.swagger.client.ApiCallback<io.swagger.client.model.TrialResponse>
        trialResponseCallbackInstance = null;                                           // lazy load
    // endregion

    // region Private Methods
    private io.swagger.client.api.TrialsApi trialsApi()
    {
        if (null == this.trialsApiInstance)
            this.trialsApiInstance = new io.swagger.client.api.TrialsApi();
        return this.trialsApiInstance;
    }

    // region trialsGet() Private Methods
    private static java.lang.Boolean getBoolean(final android.widget.RadioGroup radioGroup)
    {
        if (null == radioGroup)
            return null;
        else
            switch (radioGroup.getCheckedRadioButtonId())
            {
                case org.wheatgenetics.androidlibrarybuilder.R.id.trialsFalseActiveRadioButton:
                    return false;

                case org.wheatgenetics.androidlibrarybuilder.R.id.trialsTrueActiveRadioButton:
                    return true;

                default: return null;
            }
    }

    private void setResponseTextViewTextFromThread(
    final io.swagger.client.model.TrialsResponse trialsResponse)
    {
        this.setResponseTextViewTextFromThread(
            null == trialsResponse ? "null" : trialsResponse.toString());
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.TrialsResponse>
    trialsResponseCallback()
    {
        if (null == this.trialsResponseCallbackInstance) this.trialsResponseCallbackInstance =
            new io.swagger.client.ApiCallback<io.swagger.client.model.TrialsResponse>()
            {
                @java.lang.Override public void onFailure(final io.swagger.client.ApiException e,
                final int                                                               i  ,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment
                        .this.setResponseTextViewTextFromThread(e);
                }

                @java.lang.Override public void onSuccess(
                final io.swagger.client.model.TrialsResponse trialsResponse, final int i,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment
                        .this.setResponseTextViewTextFromThread(trialsResponse);
                }

                @java.lang.Override public void onUploadProgress(
                final long l, final long l1, final boolean b) {}

                @java.lang.Override public void onDownloadProgress(
                final long l, final long l1, final boolean b) {}
            };
        return this.trialsResponseCallbackInstance;
    }

    private void trialsGet()
    {
        try
        {
            this.trialsApi().trialsGetAsync(
                /* commonCropName => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment.getString(
                        this.commonCropNameEditText),
                /* programDbId => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment.getString(
                        this.programDbIdEditText),
                /* locationDbId => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment.getString(
                        this.locationDbIdEditText),
                /* active => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment.getBoolean(
                        this.activeRadioGroup),
                /* sortBy => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment.getString(
                        this.sortByEditText),
                /* sortOrder => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment.getString(
                        this.sortOrderEditText),
                /* page          => */ this.getPageEditTextIntText    (),
                /* pageSize      => */ this.getPageSizeEditTextIntText(),
                /* authorization => */null,
                /* callback      => */ this.trialsResponseCallback());
        }
        catch (final java.lang.Throwable t) { this.setResponseTextViewText(t); }
    }
    // endregion

    // region trialsTrialDbIdGet() Private Methods
    private void setResponseTextViewTextFromThread(
    final io.swagger.client.model.TrialResponse trialResponse)
    {
        this.setResponseTextViewTextFromThread(
            null == trialResponse ? "null" : trialResponse.toString());
    }

    private io.swagger.client.ApiCallback<io.swagger.client.model.TrialResponse>
    trialResponseCallback()
    {
        if (null == this.trialResponseCallbackInstance) this.trialResponseCallbackInstance =
            new io.swagger.client.ApiCallback<io.swagger.client.model.TrialResponse>()
            {
                @java.lang.Override public void onFailure(final io.swagger.client.ApiException e,
                final int                                                               i  ,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment
                        .this.setResponseTextViewTextFromThread(e);
                }

                @java.lang.Override public void onSuccess(
                final io.swagger.client.model.TrialResponse trialResponse, final int i,
                final java.util.Map<java.lang.String, java.util.List<java.lang.String>> map)
                {
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment
                        .this.setResponseTextViewTextFromThread(trialResponse);
                }

                @java.lang.Override public void onUploadProgress(
                final long l, final long l1, final boolean b) {}

                @java.lang.Override public void onDownloadProgress(
                final long l, final long l1, final boolean b) {}
            };
        return this.trialResponseCallbackInstance;
    }

    private void trialsTrialDbIdGet()
    {
        try
        {
            this.trialsApi().trialsTrialDbIdGetAsync(
                /* trialDbId => */
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment.getString(
                        this.trialDbIdEditText),
                /* authorization => */null,
                /* callback      => */ this.trialResponseCallback());
        }
        catch (final java.lang.Throwable t) { this.setResponseTextViewText(t); }
    }
    // endregion
    // endregion

    public TrialsFragment() {}

    @java.lang.Override @android.support.annotation.Nullable public android.view.View onCreateView(
    @android.support.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @android.support.annotation.Nullable final android.view.ViewGroup      container         ,
    @android.support.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = this.inflate(inflater, container,
            org.wheatgenetics.androidlibrarybuilder.R.layout.fragment_brapi1_3_trials);

        if (null != rootView)
        {
            // The following twelve ids are from fragment_brapi1_3_trials.xml.
            this.commonCropNameEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.trialsCommonCropNameEditText);
            this.programDbIdEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.trialsProgramDbIdEditText);
            this.locationDbIdEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.trialsLocationDbIdEditText);
            this.activeRadioGroup = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.trialsActiveRadioGroup);
            this.sortByEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.trialsSortByEditText);
            this.sortOrderEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.trialsSortOrderEditText);
            this.findPageEditTextById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.trialsPageEditText);
            this.findPageSizeEditTextById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.trialsPageSizeEditText);
            {
                final android.widget.Button trialsGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.trialsGetButton);
                if (null != trialsGetButton) trialsGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .TrialsFragment.this.trialsGet();
                        }
                    });
            }

            this.trialDbIdEditText = rootView.findViewById(
                org.wheatgenetics.androidlibrarybuilder.R.id.trialsTrialDbIdEditText);
            {
                final android.widget.Button trialsTrialDbIdGetButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrarybuilder.R.id.trialsTrialDbIdGetButton);
                if (null != trialsTrialDbIdGetButton) trialsTrialDbIdGetButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View v)
                        {
                            org.wheatgenetics.androidlibrarybuilder.brapi1_3
                                .TrialsFragment.this.trialsTrialDbIdGet();
                        }
                    });
            }

            this.findResponseTextViewById(rootView,
                org.wheatgenetics.androidlibrarybuilder.R.id.trialsResponseTextView);
        }

        return rootView;
    }
}