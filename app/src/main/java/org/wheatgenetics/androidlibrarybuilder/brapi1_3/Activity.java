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
 * android.support.v7.app.AppCompatActivity
 * android.support.v7.widget.Toolbar
 * android.view.Menu
 * android.view.MenuItem
 *
 * io.swagger.client.ApiClient
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.observations.Fragment
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.studies.Fragment
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
public class Activity extends android.support.v7.app.AppCompatActivity
implements org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier
{
    private static final int FIRST_FRAGMENT_NAME_INDEX = 0, LAST_FRAGMENT_NAME_INDEX = 20;

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

                case 8: return
                    org.wheatgenetics.androidlibrarybuilder.brapi1_3.StubFragment.instantiate(
                        "ObservationVariables");

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

    private android.support.v7.widget.Toolbar toolbar   = null;
    private android.support.v4.view.ViewPager viewPager = null;

    private       java.lang.String            authorizationInstance = null                         ;
    private final io.swagger.client.ApiClient apiClientInstance = new io.swagger.client.ApiClient();
    private final java.lang.CharSequence      testServerBasePathInstance =
        this.apiClientInstance.getBasePath();
    // endregion

    // region Private Methods
    private void setToolBarTitle(@android.support.annotation.IntRange(
    from = org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.FIRST_FRAGMENT_NAME_INDEX,
    to   = org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.LAST_FRAGMENT_NAME_INDEX )
    final int i)
    {
        if (null != this.fragmentNames && null != this.toolbar)
            this.toolbar.setTitle(this.getString(
                /* resId => */
                    org.wheatgenetics.androidlibrarybuilder.R.string.title_toolbar_brapi1_3,
                /* formatArgs => */ this.apiClient().getBasePath(), this.fragmentNames[i]));
    }

    private void setToolbarTitleToFirst()
    {
        this.setToolBarTitle(
            org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.FIRST_FRAGMENT_NAME_INDEX);
    }

    private void setPage(@android.support.annotation.NonNull
    @android.support.annotation.Size(min = 1) final java.lang.CharSequence selectedFragmentName)
    {
        if (null != this.fragmentNames && null != this.viewPager)
        {
            @android.support.annotation.IntRange(
            from =
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.FIRST_FRAGMENT_NAME_INDEX,
            to = org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.LAST_FRAGMENT_NAME_INDEX)
            int i =
                org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity.FIRST_FRAGMENT_NAME_INDEX;
            for (final java.lang.String fragmentName: this.fragmentNames)
            {
                if (selectedFragmentName.equals(fragmentName))
                    { this.viewPager.setCurrentItem(i); break; }
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

        {
            final android.content.res.Resources resources = this.getResources();
            if (null != resources) this.fragmentNames = resources.getStringArray(
                org.wheatgenetics.androidlibrarybuilder.R.array.fragmentNames);
        }

        this.toolbar = this.findViewById(
            org.wheatgenetics.androidlibrarybuilder.R.id.toolbar);            // From layout/acti-
        this.setSupportActionBar(this.toolbar);                               //  vity_brapi1_3.xml.
        this.setToolbarTitleToFirst();

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
                    public void onPageScrolled(final int var1, final float var2, final int var3) {}

                    @java.lang.Override public void onPageSelected(final int var1)
                    {
                        org.wheatgenetics.androidlibrarybuilder.brapi1_3
                            .Activity.this.setToolBarTitle(var1);
                    }

                    @java.lang.Override public void onPageScrollStateChanged(final int var1) {}
                });
        }
    }

    @java.lang.Override public boolean onCreateOptionsMenu(final android.view.Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.getMenuInflater().inflate(
            org.wheatgenetics.androidlibrarybuilder.R.menu.menu_brapi1_3, menu);
        return true;
    }

    @java.lang.Override public boolean onOptionsItemSelected(final android.view.MenuItem menuItem)
    {
        // Handle action bar menuItem clicks here.  The action bar will automatically handle clicks
        // on the Home/Up button so long as you specify a parent activity in AndroidManifest.xml.
        if (null != menuItem)
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

    @java.lang.Override protected void onDestroy()
    { if (null != this.viewPager) this.viewPager.clearOnPageChangeListeners(); super.onDestroy(); }

    // region org.wheatgenetics.androidlibrarybuilder.brapi1_3.ConnectionFragment.Supplier Overridden Methods
    @java.lang.Override public java.lang.String authorization()
    { return this.authorizationInstance; }

    @java.lang.Override @android.support.annotation.NonNull
    public io.swagger.client.ApiClient apiClient() { return this.apiClientInstance; }

    @java.lang.Override public java.lang.CharSequence testServerBasePath()
    { return this.testServerBasePathInstance; }

    @java.lang.Override public void setBasePath(final java.lang.String basePath)
    { this.apiClient().setBasePath(basePath); this.setToolbarTitleToFirst(); }

    @java.lang.Override public void setAuthorization(final java.lang.String authorization)
    { this.authorizationInstance = authorization; }
    // endregion
    // endregion
}