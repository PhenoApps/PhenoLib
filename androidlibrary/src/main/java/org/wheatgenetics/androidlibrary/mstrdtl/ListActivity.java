package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * An activity representing a list of items.  This activity has different presentations for one-pane
 * and two-pane mode.  In one-pane mode, the activity presents a list of items which, when tapped,
 * opens an {@link ItemActivity} that presents item content.  In two-pane mode, the activity
 * presents the list of items and item content side-by-side using two vertical panes.
 *
 * Uses:
 * android.os.Bundle
 * android.support.annotation.IntRange
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.support.v7.app.AppCompatActivity
 * android.support.v7.widget.RecyclerView
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Adapter
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 * org.wheatgenetics.androidlibrary.mstrdtl.TwoPaneAdapter
 * org.wheatgenetics.androidlibrary.mstrdtl.TwoPaneAdapter.Helper
 */
public abstract class ListActivity extends android.support.v7.app.AppCompatActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter
{
    // region Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected abstract org.wheatgenetics.javalib.mstrdtl.Items items();

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected abstract org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter makeOnePaneAdapter();
    // endregion

    // region Overridden Methods
    @java.lang.Override protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibrary.R.layout.mstrdtl_list_activity);

        final org.wheatgenetics.androidlibrary.mstrdtl.Adapter adapter;
        {
            // The item content container view will be present only in the wide-screen layouts
            // (res/values-w900dp).  If this view is present then the activity should be in
            // two-pane mode.
            final boolean twoPane = null != this.findViewById(
                org.wheatgenetics.androidlibrary.R.id.content_container);    // From layout-w900dp-
            adapter = twoPane ?                                              //  list_container.xml.
                new org.wheatgenetics.androidlibrary.mstrdtl.TwoPaneAdapter(this.items(),
                    new org.wheatgenetics.androidlibrary.mstrdtl.TwoPaneAdapter.Helper()
                    {
                        @java.lang.Override public void replace(
                        final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment itemFragment)
                        {
                            org.wheatgenetics.androidlibrary.mstrdtl.ListActivity.this
                                .getSupportFragmentManager().beginTransaction().replace(
                                    org.wheatgenetics.androidlibrary.R.id.content_container,
                                    itemFragment).commit();
                        }
                    }) :
                this.makeOnePaneAdapter();
        }
        final android.support.v7.widget.RecyclerView recyclerView = this.findViewById(
            org.wheatgenetics.androidlibrary.R.id.masterDetailRecyclerView);
        assert null != recyclerView; recyclerView.setAdapter(adapter);
    }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter Overridden Method
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position) { return this.items().get(position); }
    // endregion
    // endregion
}