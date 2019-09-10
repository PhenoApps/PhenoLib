package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * An activity representing item content.  This activity is only used in one-pane mode.  In two-pane
 * mode item content is presented side-by-side with a list of items in a {@link ListActivity}.
 *
 * Uses:
 * android.app.Activity
 * android.content.Intent
 * android.os.Bundle
 * android.R
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.support.design.widget.CollapsingToolbarLayout
 * android.support.v4.app.NavUtils
 * android.support.v7.app.ActionBar
 * android.view.MenuItem
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Activity
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment
 */
public abstract class ItemActivity extends org.wheatgenetics.androidlibrary.mstrdtl.Activity
{
    private android.support.design.widget.CollapsingToolbarLayout collapsingToolbarLayout = null;

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected abstract java.lang.Class listActivityClass();

    // region Overridden Methods
    @java.lang.Override protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibrary.R.layout.mstrdtl_item_activity);

        {
            // Show the Up button in the action bar.
            final android.support.v7.app.ActionBar actionBar = this.getSupportActionBar();
            if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        }

        this.collapsingToolbarLayout = this.findViewById(
            org.wheatgenetics.androidlibrary.R.id.masterDetailItemCollapsingToolbarLayout);

        // savedInstanceState is non-null when there is fragment state saved from previous
        // configurations of this activity (e.g., when rotating the screen from portrait to
        // landscape).  In this case, the fragment will automatically be re-added to its container
        // so we don't need to manually add it.  If savedInstanceState is null then there is no
        // state saved from previous configurations of this activity.  In this case, the fragment
        // will not be automatically re-added to its container so we do need to manually add it.
        // For more information, see the Fragments API guide at
        // http://developer.android.com/guide/components/fragments.html.
        if (null == savedInstanceState)
        {
            // Create the fragment and add it to the activity using a fragment transaction.
            final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment itemFragment =
                new org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment();
            {
                final android.os.Bundle arguments = new android.os.Bundle();
                {
                    final java.lang.String POSITION_KEY =
                        org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.POSITION_KEY;
                    arguments.putInt(POSITION_KEY, this.getIntent().getIntExtra(
                        POSITION_KEY, /* defaultValue => */-1));
                }
                itemFragment.setArguments(arguments);
            }
            this.setAndAddItemFragment(
                org.wheatgenetics.androidlibrary.R.id.masterDetailNestedScrollView, itemFragment);
        }
    }

    @java.lang.Override public boolean onOptionsItemSelected(
    @android.support.annotation.NonNull final android.view.MenuItem menuItem)
    {
        if (menuItem.getItemId() == android.R.id.home)
        {
            // This id represents the Home or Up button.  In the case of this activity, the Up
            // button is shown.  Use NavUtils to allow users to navigate up one level in the
            // application structure.  For more details, see the Navigation pattern on Android
            // Design (http://developer.android.com/design/patterns/navigation.html#up-vs-back).
             android.support.v4.app.NavUtils.navigateUpTo(this, this.putJsonIntoIntent(
                 new android.content.Intent(this, this.listActivityClass())));
            return true;
        }
        else return super.onOptionsItemSelected(menuItem);
    }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper Overridden Methods
    @java.lang.Override public void delete(@android.support.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        super.delete(position);
        this.setResult(android.app.Activity.RESULT_OK, new android.content.Intent().putExtra(
            android.content.Intent.EXTRA_DATA_REMOVED,true));
        this.finish();
    }

    @java.lang.Override public void setToolbarTitle(final java.lang.CharSequence title)
    { if (null != this.collapsingToolbarLayout) this.collapsingToolbarLayout.setTitle(title); }

    @java.lang.Override public void clearToolbarTitle()
    { if (null != this.collapsingToolbarLayout) this.collapsingToolbarLayout.setTitle(null); }
    // endregion
    // endregion
}