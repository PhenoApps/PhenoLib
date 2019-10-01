package org.wheatgenetics.androidlibrarybuilder.brapi1_3;

/**
 * Uses:
 * android.content.res.Resources
 * android.os.Bundle
 * android.support.annotation.IntRange
 * android.support.annotation.MenuRes
 * android.support.annotation.NonNull
 * android.support.annotation.Size
 * android.support.v4.app.Fragment
 * android.support.v4.app.FragmentManager
 * android.support.v4.app.FragmentPagerAdapter
 * android.support.v4.view.ViewPager
 * android.support.v4.view.ViewPager.OnPageChangeListener
 * android.support.v7.app.ActionBar
 * android.support.v7.app.AppCompatActivity
 * android.support.v7.widget.Toolbar
 * android.view.Menu
 * android.view.MenuItem
 * android.widget.TextView
 *
 * io.swagger.client.ApiClient
 *
 * org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
 * org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequest
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.observationvariables.Fragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.Helper
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.CallsFragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.CropsFragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment
 */
public class Activity extends android.support.v7.app.AppCompatActivity implements
org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier,
org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.Helper
{
    // region Constants
    private static final int FIRST_FRAGMENT_NAME_INDEX = 0, LAST_FRAGMENT_NAME_INDEX = 20;
    private static final java.lang.String AUTHORIZATION_KEY = "authorization",
        BASE_PATH_KEY = "basePath", STUDY_LAYOUT_REQUEST_KEY = "studyLayoutRequest",
        NEW_OBSERVATIONS_REQUEST_KEY      = "newObservationsRequest"    ,
        NEW_OBSERVATION_UNIT_REQUESTS_KEY = "newObservationUnitRequests";
    // endregion

    private static class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter
    {
        private FragmentPagerAdapter(@android.support.annotation.NonNull
        final android.support.v4.app.FragmentManager fragmentManager) { super(fragmentManager); }

        // region Overridden Methods
        /** getItem() is called to instantiate the fragment for the given page. */
        @java.lang.Override public android.support.v4.app.Fragment getItem(final int position)
        {
            switch (position)
            {
                case org.wheatgenetics.androidlibrarybuilder.brapi1_3
                    .Activity.FIRST_FRAGMENT_NAME_INDEX: return
                        new org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment();

                case 1: return new org.wheatgenetics.androidlibrarybuilder.brapi1_3.CallsFragment();
                case 2: return new org.wheatgenetics.androidlibrarybuilder.brapi1_3.CropsFragment();

                case 3:
                    return new org.wheatgenetics.androidlibrarybuilder.brapi1_3.ProgramsFragment();

                case 4:
                    return new org.wheatgenetics.androidlibrarybuilder.brapi1_3.LocationsFragment();

                case 5:
                    return new org.wheatgenetics.androidlibrarybuilder.brapi1_3.TrialsFragment();

                case 6:
                    return new org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment();

                case 7: return
                    new org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment();

                case 8: return new org.wheatgenetics
                    .androidlibrarybuilder.brapi1_3.observationvariables.Fragment();

                case 9: return
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.instantiate(
                        "Phenotypes");

                case 10: return
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.instantiate(
                        "Germplasm");

                case 11: return
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.instantiate(
                        "GermplasmAttributes");

                case 12: return
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.instantiate(
                        "Markers");

                case 13: return
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.instantiate(
                        "MarkerProfiles");

                case 14: return
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.instantiate(
                        "GenomeMaps");

                case 15: return
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.instantiate(
                        "Samples");

                case 16: return
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.instantiate(
                        "Vendor");

                case 17: return
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.instantiate(
                        "Lists");

                case 18: return
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.instantiate(
                        "Images");

                case 19: return
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.instantiate(
                        "People");

                case org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity
                    .LAST_FRAGMENT_NAME_INDEX: return org.wheatgenetics.androidlibrarybuilder
                        .brapi1_3.StubFragment.instantiate("SearchServices");

                default: return null;
            }
        }

        @java.lang.Override public int getCount()
        {
            return
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.LAST_FRAGMENT_NAME_INDEX -
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.FIRST_FRAGMENT_NAME_INDEX
                + 1;
        }
        // endregion
    }

    // region Fields
    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
    private java.lang.String fragmentNames[] = null;

    private android.widget.TextView           toolBarTextView = null;
    private android.support.v4.view.ViewPager viewPager       = null;

    private       java.lang.String            authorizationInstance = null                         ;
    private final io.swagger.client.ApiClient apiClientInstance = new io.swagger.client.ApiClient();
    private final java.lang.CharSequence      testServerBasePathInstance =
        this.apiClientInstance.getBasePath();

    private org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequest
        studyLayoutRequestInstance = null;
    private org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest
        newObservationsRequestInstance = null;
    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
        newObservationUnitRequestsInstance = null;
    // endregion

    // region Private Methods
    private void setToolBarTitle(@android.support.annotation.IntRange(
    from = org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.FIRST_FRAGMENT_NAME_INDEX,
    to   = org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.LAST_FRAGMENT_NAME_INDEX )
    final int i)
    {
        if (null != this.toolBarTextView) this.toolBarTextView.setText(this.getString(
            /* resId => */ org.wheatgenetics.androidlibrarybuilder.R.string.title_toolbar_brapi1_3,
            /* formatArgs => */
                null == this.fragmentNames ? null : this.fragmentNames[i],
                this.apiClient().getBasePath(), this.authorization()));
    }

    private void setToolbarTitleToFirstFragmentName()
    {
        this.setToolBarTitle(
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.FIRST_FRAGMENT_NAME_INDEX);
    }

    private void setBasePathButNotToolbarTitle(final java.lang.String basePath)
    { this.apiClient().setBasePath(basePath); }

    private org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequest studyLayoutRequest()
    {
        if (this.getStudyLayoutRequest() == null) this.setStudyLayoutRequest(
            new org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequest());
        return this.getStudyLayoutRequest();
    }

    private org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest newObservationsRequest()
    {
        if (this.getNewObservationsRequest() == null) this.setNewObservationsRequest(
            new org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest());
        return this.getNewObservationsRequest();
    }

    private org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
    newObservationUnitRequests()
    {
        if (this.getNewObservationUnitRequests() == null) this.setNewObservationUnitRequests(
            new org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests());
        return this.getNewObservationUnitRequests();
    }

    private void setPage(@android.support.annotation.IntRange(
    from = org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.FIRST_FRAGMENT_NAME_INDEX,
    to   = org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.LAST_FRAGMENT_NAME_INDEX )
    final int page) { if (null != this.viewPager) this.viewPager.setCurrentItem(page); }

    private void setPage(@android.support.annotation.NonNull
    @android.support.annotation.Size(min = 1) final java.lang.CharSequence selectedFragmentName)
    {
        if (null != this.fragmentNames)
        {
            // noinspection UnnecessaryLocalVariable
            final int FIRST_FRAGMENT_NAME_INDEX =
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.FIRST_FRAGMENT_NAME_INDEX;

            @android.support.annotation.IntRange(from = FIRST_FRAGMENT_NAME_INDEX,
            to = org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.LAST_FRAGMENT_NAME_INDEX)
            int i = FIRST_FRAGMENT_NAME_INDEX;

            for (final java.lang.String fragmentName: this.fragmentNames)
            {
                if (selectedFragmentName.equals(fragmentName)) { this.setPage(i); break; }
                i++;
            }
        }
    }
    // endregion

    // region Overridden Methods
    @java.lang.Override protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibrarybuilder.R.layout.activity_brapi1_3);

        // region Initialize this.fragmentNames[].
        {
            final android.content.res.Resources resources = this.getResources();
            if (null != resources) this.fragmentNames = resources.getStringArray(
                org.wheatgenetics.androidlibrarybuilder.R.array.fragmentNames);
        }
        // endregion

        // region Initialize widgets.
        this.setSupportActionBar((android.support.v7.widget.Toolbar) this.findViewById(
            org.wheatgenetics.androidlibrarybuilder.R.id.toolbar));           // From layout/acti-
        {                                                                     //  vity_brapi1_3.xml.
            final android.support.v7.app.ActionBar supportActionBar = this.getSupportActionBar();
            if (null != supportActionBar) supportActionBar.setDisplayShowTitleEnabled(false);
        }

        this.toolBarTextView = this.findViewById(
            org.wheatgenetics.androidlibrarybuilder.R.id.toolBarTextView);

        this.viewPager = this.findViewById(
            org.wheatgenetics.androidlibrarybuilder.R.id.view_pager);         // From layout/acti-
        if (null != this.viewPager)                                           //  vity_brapi1_3.xml.
        {
            this.viewPager.setAdapter(
                new org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.FragmentPagerAdapter(
                    this.getSupportFragmentManager()));

            this.viewPager.addOnPageChangeListener(
                new android.support.v4.view.ViewPager.OnPageChangeListener()
                {
                    @java.lang.Override
                    public void onPageScrolled(final int position,
                    final float positionOffset, final int positionOffsetPixels) {}

                    @java.lang.Override public void onPageSelected(final int position)
                    {
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3
                            .Activity.this.setToolBarTitle(position);
                    }

                    @java.lang.Override public void onPageScrollStateChanged(final int state) {}
                });
        }
        // endregion

        if (null != savedInstanceState)
        {
            {
                final java.lang.String AUTHORIZATION_KEY =
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.AUTHORIZATION_KEY;
                if (savedInstanceState.containsKey(AUTHORIZATION_KEY))
                    this.authorizationInstance = savedInstanceState.getString(AUTHORIZATION_KEY);
            }
            {
                final java.lang.String BASE_PATH_KEY =
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.BASE_PATH_KEY;
                if (savedInstanceState.containsKey(BASE_PATH_KEY))
                    this.setBasePathButNotToolbarTitle(savedInstanceState.getString(BASE_PATH_KEY));
            }
            {
                final java.lang.String STUDY_LAYOUT_REQUEST_KEY = org.wheatgenetics
                    .androidlibrarybuilder.brapi1_3.Activity.STUDY_LAYOUT_REQUEST_KEY;
                if (savedInstanceState.containsKey(STUDY_LAYOUT_REQUEST_KEY))
                    this.studyLayoutRequest().fromJson(
                        savedInstanceState.getString(STUDY_LAYOUT_REQUEST_KEY));
            }
            {
                final java.lang.String NEW_OBSERVATIONS_REQUEST_KEY = org.wheatgenetics
                    .androidlibrarybuilder.brapi1_3.Activity.NEW_OBSERVATIONS_REQUEST_KEY;
                if (savedInstanceState.containsKey(NEW_OBSERVATIONS_REQUEST_KEY))
                    this.newObservationsRequest().fromJson(
                        savedInstanceState.getString(NEW_OBSERVATIONS_REQUEST_KEY));
            }
            final java.lang.String NEW_OBSERVATION_UNIT_REQUESTS_KEY = org.wheatgenetics
                .androidlibrarybuilder.brapi1_3.Activity.NEW_OBSERVATION_UNIT_REQUESTS_KEY;
            if (savedInstanceState.containsKey(NEW_OBSERVATION_UNIT_REQUESTS_KEY))
                this.newObservationUnitRequests().fromJson(
                    savedInstanceState.getString(NEW_OBSERVATION_UNIT_REQUESTS_KEY));
        }
        this.setToolbarTitleToFirstFragmentName();
    }

    @java.lang.Override public boolean onCreateOptionsMenu(final android.view.Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.getMenuInflater().inflate(
            org.wheatgenetics.androidlibrarybuilder.R.menu.menu_brapi1_3, menu);
        return true;
    }

    @java.lang.Override public boolean onOptionsItemSelected(
    @android.support.annotation.NonNull final android.view.MenuItem menuItem)
    {
        // Handle action bar menuItem clicks here.  The action bar will automatically handle clicks
        // on the Home/Up button so long as you specify a parent activity in AndroidManifest.xml.
        {
            @android.support.annotation.MenuRes final int id = menuItem.getItemId();

            // The id values in the following switch statement are from menu/menu_brapi1_3.xml.
            switch (id)
            {
                case org.wheatgenetics.androidlibrarybuilder.R.id.ConnectionMenuItemId          :
                case org.wheatgenetics.androidlibrarybuilder.R.id.CallsMenuItemId               :
                case org.wheatgenetics.androidlibrarybuilder.R.id.CropsMenuItemId               :
                case org.wheatgenetics.androidlibrarybuilder.R.id.ProgramsMenuItemId            :
                case org.wheatgenetics.androidlibrarybuilder.R.id.LocationsMenuItemId           :
                case org.wheatgenetics.androidlibrarybuilder.R.id.TrialsMenuItemId              :
                case org.wheatgenetics.androidlibrarybuilder.R.id.StudiesMenuItemId             :
                case org.wheatgenetics.androidlibrarybuilder.R.id.ObservationsMenuItemId        :
                case org.wheatgenetics.androidlibrarybuilder.R.id.ObservationVariablesMenuItemId:
                case org.wheatgenetics.androidlibrarybuilder.R.id.PhenotypesMenuItemId          :
                case org.wheatgenetics.androidlibrarybuilder.R.id.GermplasmMenuItemId           :
                case org.wheatgenetics.androidlibrarybuilder.R.id.GermplasmAttributesMenuItemId :
                case org.wheatgenetics.androidlibrarybuilder.R.id.MarkersMenuItemId             :
                case org.wheatgenetics.androidlibrarybuilder.R.id.MarkerProfilesMenuItemId      :
                case org.wheatgenetics.androidlibrarybuilder.R.id.GenomeMapsMenuItemId          :
                case org.wheatgenetics.androidlibrarybuilder.R.id.SamplesMenuItemId             :
                case org.wheatgenetics.androidlibrarybuilder.R.id.VendorMenuItemId              :
                case org.wheatgenetics.androidlibrarybuilder.R.id.ListsMenuItemId               :
                case org.wheatgenetics.androidlibrarybuilder.R.id.ImagesMenuItemId              :
                case org.wheatgenetics.androidlibrarybuilder.R.id.PeopleMenuItemId              :
                case org.wheatgenetics.androidlibrarybuilder.R.id.SearchServicesMenuItemId      :
                    this.setPage(menuItem.getTitle()); return true;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @java.lang.Override protected void onSaveInstanceState(final android.os.Bundle outState)
    {
        if (null != outState)
        {
            outState.putString(
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.AUTHORIZATION_KEY,
                this.authorizationInstance                                                 );
            outState.putString(
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.BASE_PATH_KEY,
                this.apiClient().getBasePath()                                         );
            {
                final org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequest studyLayoutRequest =
                    this.getStudyLayoutRequest();
                if (null != studyLayoutRequest)
                {
                    final java.lang.String json = studyLayoutRequest.toJson();
                    if (null != json)
                    {
                        final java.lang.String trimmedJson = json.trim();
                        if (trimmedJson.length() > 0) outState.putString(org.wheatgenetics
                                .androidlibrarybuilder.brapi1_3.Activity.STUDY_LAYOUT_REQUEST_KEY,
                            trimmedJson                                                          );
                    }
                }
            }
            {
                final org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest
                    newObservationsRequest = this.getNewObservationsRequest();
                if (null != newObservationsRequest)
                {
                    final java.lang.String json = newObservationsRequest.toJson();
                    if (null != json)
                    {
                        final java.lang.String trimmedJson = json.trim();
                        if (trimmedJson.length() > 0)
                            outState.putString(org.wheatgenetics.androidlibrarybuilder
                                    .brapi1_3.Activity.NEW_OBSERVATIONS_REQUEST_KEY,
                                trimmedJson                                        );
                    }
                }
            }
            final org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
                newObservationUnitRequests = this.getNewObservationUnitRequests();
            if (null != newObservationUnitRequests)
            {
                final java.lang.String json = newObservationUnitRequests.toJson();
                if (null != json)
                {
                    final java.lang.String trimmedJson = json.trim();
                    if (trimmedJson.length() > 0)
                        outState.putString(org.wheatgenetics.androidlibrarybuilder
                                .brapi1_3.Activity.NEW_OBSERVATION_UNIT_REQUESTS_KEY,
                            trimmedJson                                             );
                }
            }
        }
        super.onSaveInstanceState(outState);
    }

    @java.lang.Override protected void onDestroy()
    { if (null != this.viewPager) this.viewPager.clearOnPageChangeListeners(); super.onDestroy(); }

    // region org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier Overridden Methods
    @java.lang.Override @android.support.annotation.NonNull
    public io.swagger.client.ApiClient apiClient() { return this.apiClientInstance; }

    @java.lang.Override public java.lang.String authorization()
    { return this.authorizationInstance; }

    @java.lang.Override public java.lang.CharSequence testServerBasePath()
    { return this.testServerBasePathInstance; }

    @java.lang.Override public void setBasePath(final java.lang.String basePath)
    { this.setBasePathButNotToolbarTitle(basePath); this.setToolbarTitleToFirstFragmentName(); }

    @java.lang.Override public void setAuthorization(final java.lang.String authorization)
    { this.authorizationInstance = authorization; this.setToolbarTitleToFirstFragmentName(); }
    // endregion

    // region org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment.Helper Overridden Methods
    @java.lang.Override
    public org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequest getStudyLayoutRequest()
    { return this.studyLayoutRequestInstance; }

    @java.lang.Override public void setStudyLayoutRequest(
    final org.wheatgenetics.brapi1_3.studies.slr.StudyLayoutRequest studyLayoutRequest)
    { this.studyLayoutRequestInstance = studyLayoutRequest; }


    @java.lang.Override
    public org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest getNewObservationsRequest()
    { return this.newObservationsRequestInstance; }

    @java.lang.Override public void setNewObservationsRequest(
    final org.wheatgenetics.brapi1_3.studies.nor.NewObservationsRequest newObservationsRequest)
    { this.newObservationsRequestInstance = newObservationsRequest; }


    @java.lang.Override public org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests
    getNewObservationUnitRequests() { return this.newObservationUnitRequestsInstance; }

    @java.lang.Override public void setNewObservationUnitRequests(final
    org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequests newObservationUnitRequests)
    { this.newObservationUnitRequestsInstance = newObservationUnitRequests; }
    // endregion
    // endregion
}