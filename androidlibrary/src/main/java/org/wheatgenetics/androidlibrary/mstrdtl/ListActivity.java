package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * An activity representing a list of items.  This activity has different presentations for one-pane
 * and two-pane mode.  In one-pane mode, the activity presents a list of items which, when tapped,
 * opens an {@link ItemActivity} that presents item content.  In two-pane mode, the activity
 * presents the list of items and item content side-by-side using two vertical panes.
 *
 * Uses:
 * android.app.Activity
 * android.content.Intent
 * android.os.Bundle
 * android.support.annotation.IntRange
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.support.v7.widget.RecyclerView
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.Button
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Activity
 * org.wheatgenetics.androidlibrary.mstrdtl.Adapter
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 * org.wheatgenetics.androidlibrary.mstrdtl.TwoPaneAdapter
 * org.wheatgenetics.androidlibrary.mstrdtl.TwoPaneAdapter.Helper
 */
public abstract class ListActivity extends org.wheatgenetics.androidlibrary.mstrdtl.Activity
{
    private org.wheatgenetics.androidlibrary.mstrdtl.Adapter adapter;

    // region Private Methods
    private void setAndReplaceItemFragment(
    final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment itemFragment)
    {
        this.setAndReplaceItemFragment(
            org.wheatgenetics.androidlibrary.R.id.content_container, itemFragment);
    }

    private void append() { this.items().append(); this.refreshSinceItemsHaveChanged(); }

    private void notifyDataSetChanged()
    { if (null != this.adapter) this.adapter.notifyDataSetChanged(); }

    private void initializeItems() { this.items().fromJson(this.getJson()); }
    // endregion

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected abstract org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter();

    // region Overridden Methods
    @java.lang.Override protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibrary.R.layout.mstrdtl_list_activity);

        {
            // The item content container view will be present only in the wide-screen layouts
            // (res/values-w900dp).  If this view is present then the activity should be in two-pane
            // mode.
            final boolean twoPane = null != this.findViewById(
                org.wheatgenetics.androidlibrary.R.id.content_container);    // From layout-w900dp-
            this.adapter = twoPane ?                                         //  list_container.xml.
                new org.wheatgenetics.androidlibrary.mstrdtl.TwoPaneAdapter(this.items(),
                    new org.wheatgenetics.androidlibrary.mstrdtl.TwoPaneAdapter.Helper()
                    {
                        @java.lang.Override public void replace(final
                        org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment itemFragment)
                        {
                            org.wheatgenetics.androidlibrary.mstrdtl.ListActivity
                                .this.setAndReplaceItemFragment(itemFragment);
                        }
                    }) :
                this.makeOnePaneAdapter();
        }
        {
            final android.support.v7.widget.RecyclerView recyclerView = this.findViewById(
                org.wheatgenetics.androidlibrary.R.id.masterDetailRecyclerView);
            if (null != recyclerView) recyclerView.setAdapter(this.adapter);
        }

        final android.widget.Button appendItemButton = this.findViewById(
            org.wheatgenetics.androidlibrary.R.id.appendItemButton);
        if (null != appendItemButton)
        {
            appendItemButton.setEnabled(true);
            appendItemButton.setOnClickListener(new android.view.View.OnClickListener()
                {
                    @java.lang.Override public void onClick(final android.view.View view)
                    { org.wheatgenetics.androidlibrary.mstrdtl.ListActivity.this.append(); }
                });
        }
    }

    @java.lang.Override protected void onActivityResult(final int requestCode, final int resultCode,
    @android.support.annotation.Nullable final android.content.Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter.REQUEST_CODE == requestCode
        &&  android.app.Activity.RESULT_OK                                       == resultCode
        &&  null                                                                 != data       )
        {
            this.setJsonFromIntent("onActivityResult()", data);
            this.initializeItems(); this.refreshSinceItemsHaveChanged();
        }
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override void refreshSinceItemsHaveChanged()
    { super.refreshSinceItemsHaveChanged(); this.notifyDataSetChanged(); }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper Overridden Methods
    @java.lang.Override public void delete(@android.support.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    { super.delete(position); this.removeAndClearItemFragment(); this.notifyDataSetChanged(); }

    @java.lang.Override public void setToolbarTitle  (final java.lang.CharSequence title) {}
    @java.lang.Override public void clearToolbarTitle()                                   {}
    // endregion
    // endregion
}