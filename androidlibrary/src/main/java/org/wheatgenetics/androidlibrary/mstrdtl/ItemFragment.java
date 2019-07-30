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
 * android.view.View.OnClickListener
 * android.view.ViewGroup
 * android.widget.Button
 * android.widget.TextView
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.R
 */
public class ItemFragment extends android.support.v4.app.Fragment
{
    // region Types
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Getter
    {
        public org.wheatgenetics.javalib.mstrdtl.Item get(@android.support.annotation.IntRange(
            from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);
    }

    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface GetterChanger
    extends org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter
    {
        public void change(
        @android.support.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item);
    }
    // endregion

    /**
     * Keys to the bundle arguments that have 1) the position of the item and 2) the id of the
     * CollapsingToolbarLayout.
     */
    static final java.lang.String POSITION_KEY = "position",
        COLLAPSING_TOOLBAR_LAYOUT_ID_KEY = "collapsingToolbarLayoutId";

    // region Fields
    private org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter        getter = null;
    private org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger
        getterChanger = null;

    private org.wheatgenetics.javalib.mstrdtl.Item item = null;

    private android.support.design.widget.CollapsingToolbarLayout collapsingToolbarLayout = null;
    private android.widget.TextView                               contentTextView         = null;
    // endregion

    // region private Methods
    private org.wheatgenetics.javalib.mstrdtl.Item get(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter getter =
            null == this.getter ? this.getterChanger : this.getter;
        return null == getter ? null : getter.get(position);
    }

    private void setToolbarTitle()
    {
        if (null != this.item && null != this.collapsingToolbarLayout)
            this.collapsingToolbarLayout.setTitle(this.item.getTitle());
    }

    private void setContentTextViewText()
    {
        if (null != this.item) if (null != this.contentTextView)
            this.contentTextView.setText(this.item.getContent());
    }

    private boolean changerIsImplemented()
    { return null == this.getter && null != this.getterChanger; }

    private void changeItem()
    {
        if (null != this.item)
            if (this.changerIsImplemented()) this.getterChanger.change(this.item);
    }
    // endregion

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
            if (context instanceof
            org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger)
                this.getterChanger =
                    (org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.GetterChanger) context;
            else
                this.getter =
                    (org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Getter) context;
        else
            throw new java.lang.RuntimeException(null == context ? "context" :
                context.toString() + " must implement Getter");
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

            final java.lang.String COLLAPSING_TOOLBAR_LAYOUT_ID_KEY = org.wheatgenetics
                .androidlibrary.mstrdtl.ItemFragment.COLLAPSING_TOOLBAR_LAYOUT_ID_KEY;
            if (arguments.containsKey(COLLAPSING_TOOLBAR_LAYOUT_ID_KEY))
            {
                {
                    final android.app.Activity activity = this.getActivity();
                    if (null != activity) this.collapsingToolbarLayout = activity.findViewById(
                        arguments.getInt(COLLAPSING_TOOLBAR_LAYOUT_ID_KEY));
                }
                this.setToolbarTitle();
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
        if (null != rootView)
        {
            this.contentTextView = rootView.findViewById(
                org.wheatgenetics.androidlibrary.R.id.masterDetailItemContentTextView);
            this.setContentTextViewText();

            if (this.changerIsImplemented())
            {
                final android.widget.Button changeItemButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.changeItemButton);
                if (null != changeItemButton)
                {
                    changeItemButton.setEnabled(true);
                    changeItemButton.setOnClickListener(new android.view.View.OnClickListener()
                        {
                            @java.lang.Override public void onClick(final android.view.View v)
                            {
                                org.wheatgenetics.androidlibrary.mstrdtl
                                    .ItemFragment.this.changeItem();
                            }
                        });
                }
            }
        }
        return rootView;
    }

    @java.lang.Override public void onDetach()
    { this.getter = this.getterChanger = null; super.onDetach(); }
    // endregion

    void refreshSinceItemHasChanged() { this.setToolbarTitle(); this.setContentTextViewText(); }
}