package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * A fragment representing item content.  This fragment is contained in either a
 * {@link ListActivity} in two-pane mode or in an {@link ItemActivity} in one-pane mode.
 *
 * Uses:
 * android.app.Activity
 * android.content.Context
 * android.os.Bundle
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.design.widget.CollapsingToolbarLayout
 * android.support.v4.app.Fragment
 * android.view.LayoutInflater
 * android.view.View
 * android.view.ViewGroup
 * android.widget.TextView
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.R
 */
public class ItemFragment extends android.support.v4.app.Fragment
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) interface Getter
    {
        public org.wheatgenetics.javalib.mstrdtl.Item get(@android.support.annotation.IntRange(
            from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);
    }

    // region Constants
    /**
     * Keys to the bundle arguments that have 1) the position of the item and 2) the id of the
     * CollapsingToolbarLayout.
     */
    static final java.lang.String POSITION_KEY = "position",
        COLLAPSING_TOOLBAR_LAYOUT_ID_KEY = "collapsingToolbarLayoutId";
    // endregion

    // region Fields
    private org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter getter = null;
    private org.wheatgenetics.javalib.mstrdtl.Item                       item   = null;
    // endregion

    private org.wheatgenetics.javalib.mstrdtl.Item get(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    { assert null != this.getter; return this.getter.get(position); }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g., upon
     * screen orientation changes).
     */
    public ItemFragment() {}

    // region Overridden Methods
    @java.lang.Override public void onAttach(final android.content.Context context)
    {
        super.onAttach(context);

        if (context instanceof org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter)
            this.getter = (org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter) context;
        else
        {
            assert null != context;
            throw new java.lang.RuntimeException(context.toString() + " must implement Getter");
        }
    }

    @java.lang.Override public void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        final android.os.Bundle arguments = this.getArguments();
        if (null != arguments)
        {
            {
                final java.lang.String POSITION_KEY =
                    org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.POSITION_KEY;
                if (arguments.containsKey(POSITION_KEY))
                    try { this.item = this.get(arguments.getInt(POSITION_KEY)); }
                    catch (final java.lang.IndexOutOfBoundsException e) { this.item = null; }
            }

            if (null != this.item)
            {
                final java.lang.String COLLAPSING_TOOLBAR_LAYOUT_ID_KEY = org.wheatgenetics
                    .androidlibrary.mstrdtl.ItemFragment.COLLAPSING_TOOLBAR_LAYOUT_ID_KEY;
                if (arguments.containsKey(COLLAPSING_TOOLBAR_LAYOUT_ID_KEY))
                {
                    final android.support.design.widget.CollapsingToolbarLayout
                        collapsingToolbarLayout;
                    {
                        final android.app.Activity activity = this.getActivity();
                        assert null != activity; collapsingToolbarLayout = activity.findViewById(
                            arguments.getInt(COLLAPSING_TOOLBAR_LAYOUT_ID_KEY));
                    }
                    if (collapsingToolbarLayout != null)
                        collapsingToolbarLayout.setTitle(this.item.getTitle());
                }
            }
        }
    }

    @java.lang.Override public android.view.View onCreateView(
    @android.support.annotation.NonNull final android.view.LayoutInflater inflater,
    final android.view.ViewGroup container, final android.os.Bundle savedInstanceState)
    {
        final android.view.View rootView = inflater.inflate(
            org.wheatgenetics.androidlibrary.R.layout.mstrdtl_item_fragment,
            container, /* attachToRoot => */false);

        if (null != this.item)
        {
            assert null != rootView;
            final android.widget.TextView contentTextView = rootView.findViewById(
                org.wheatgenetics.androidlibrary.R.id.masterDetailItemContentTextView);

            assert null != contentTextView; contentTextView.setText(this.item.getContent());
        }

        return rootView;
    }
    // endregion
}