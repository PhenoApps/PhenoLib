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
 * android.util.Log
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
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Helper
    {
        public org.wheatgenetics.javalib.mstrdtl.Item get(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);

        public void moveUp(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);

        public void moveDown(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);

        public void delete(@android.support.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);
    }

    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface HelperChanger
    extends org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper
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
    private org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper        helper = null;
    private org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger
        helperChanger = null;

    private org.wheatgenetics.javalib.mstrdtl.Item item = null;

    private android.widget.TextView contentTextView = null;
    private android.widget.Button   upButton = null, downButton = null,
        changeItemButton = null, deleteItemButton = null;
    // endregion

    // region private Methods
    private static void log(@android.support.annotation.NonNull final java.lang.String msg)
    { android.util.Log.i("ItemFragment", msg); }

    private static void log(
    @android.support.annotation.NonNull final java.lang.String positionMsg                 ,
    @android.support.annotation.NonNull final java.lang.String collapsingToolbarLayoutIdMsg)
    {
        org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.log(
            "position                 : " + positionMsg);
        org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.log(
            "collapsingToolbarLayoutId: " + collapsingToolbarLayoutIdMsg);
    }

    private org.wheatgenetics.javalib.mstrdtl.Item get(@android.support.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper helper =
            null == this.helper ? this.helperChanger : this.helper;
        return null == helper ? null : helper.get(position);
    }

    private void moveUp()
    {
        if (null != this.item)
        {
            final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper helper =
                null == this.helper ? this.helperChanger : this.helper;
            if (null != helper) helper.moveUp(this.item.getPosition());
        }
    }

    private void moveDown()
    {
        if (null != this.item)
        {
            final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper helper =
                null == this.helper ? this.helperChanger : this.helper;
            if (null != helper) helper.moveDown(this.item.getPosition());
        }
    }

    private boolean changerIsImplemented()
    { return null == this.helper && null != this.helperChanger; }

    private void changeItem()
    {
        if (null != this.item)
            if (this.changerIsImplemented()) this.helperChanger.change(this.item);
    }

    private void deleteItem()
    {
        if (null != this.item)
        {
            final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper helper =
                null == this.helper ? this.helperChanger : this.helper;
            if (null != helper) helper.delete(this.item.getPosition());
        }
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

        if (context instanceof org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper)
            if (context instanceof
            org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger)
                this.helperChanger =
                    (org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger) context;
            else
                this.helper =
                    (org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper) context;
        else
            throw new java.lang.RuntimeException(null == context ?
                "context" : context.toString() + " must implement Helper");
    }

    @java.lang.Override public void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        final java.lang.String positionMsg, collapsingToolbarLayoutIdMsg;
        {
            final android.os.Bundle arguments = this.getArguments();
            if (null == arguments)
                positionMsg = collapsingToolbarLayoutIdMsg = "arguments is null";
            else
            {
                {
                    final java.lang.String POSITION_KEY =
                        org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.POSITION_KEY;
                    if (arguments.containsKey(POSITION_KEY))
                    {
                        final int position = arguments.getInt(POSITION_KEY);
                        try { this.item = this.get(position); }
                        catch (final java.lang.IndexOutOfBoundsException e) { this.item = null; }
                        positionMsg = java.lang.String.valueOf(position);
                    }
                    else positionMsg = "arguments does not contain " + POSITION_KEY;
                }

                if (null == this.item)
                    collapsingToolbarLayoutIdMsg = "this.item is null";
                else
                {
                    final android.support.design.widget.CollapsingToolbarLayout
                        collapsingToolbarLayout;
                    {
                        final java.lang.String COLLAPSING_TOOLBAR_LAYOUT_ID_KEY = org.wheatgenetics
                            .androidlibrary.mstrdtl.ItemFragment.COLLAPSING_TOOLBAR_LAYOUT_ID_KEY;
                        if (arguments.containsKey(COLLAPSING_TOOLBAR_LAYOUT_ID_KEY))
                        {
                            final int collapsingToolbarLayoutId =
                                arguments.getInt(COLLAPSING_TOOLBAR_LAYOUT_ID_KEY);
                            {
                                final android.app.Activity activity = this.getActivity();
                                if (null == activity)
                                    collapsingToolbarLayout = null;
                                else
                                    collapsingToolbarLayout =
                                        activity.findViewById(collapsingToolbarLayoutId);
                            }
                            collapsingToolbarLayoutIdMsg =
                                java.lang.String.valueOf(collapsingToolbarLayoutId);
                        }
                        else
                        {
                            collapsingToolbarLayout      = null;
                            collapsingToolbarLayoutIdMsg =
                                "arguments does not contain " + COLLAPSING_TOOLBAR_LAYOUT_ID_KEY;
                        }
                    }
                    if (null != collapsingToolbarLayout)
                        collapsingToolbarLayout.setTitle(this.item.getTitle());
                }
            }
        }
        org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.log(
            positionMsg, collapsingToolbarLayoutIdMsg);
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

            if (null == this.upButton) this.upButton = rootView.findViewById(
                org.wheatgenetics.androidlibrary.R.id.upItemButton);
            if (null != this.upButton) this.upButton.setOnClickListener(
                new android.view.View.OnClickListener()
                {
                    @java.lang.Override public void onClick(final android.view.View view)
                    { org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.this.moveUp(); }
                });

            if (null == this.downButton) this.downButton = rootView.findViewById(
                org.wheatgenetics.androidlibrary.R.id.downItemButton);
            if (null != this.downButton) this.downButton.setOnClickListener(
                new android.view.View.OnClickListener()
                {
                    @java.lang.Override public void onClick(final android.view.View view)
                    { org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.this.moveDown(); }
                });

            this.refreshSinceItemsHaveChanged();

            if (this.changerIsImplemented())
            {
                this.changeItemButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.changeItemButton);
                if (null != this.changeItemButton) this.changeItemButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View view)
                        { org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.this.changeItem(); }
                    });
            }

            this.deleteItemButton = rootView.findViewById(
                org.wheatgenetics.androidlibrary.R.id.deleteItemButton);
            if (null != this.deleteItemButton) this.deleteItemButton.setOnClickListener(
                new android.view.View.OnClickListener()
                {
                    @java.lang.Override public void onClick(final android.view.View view)
                    { org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.this.deleteItem(); }
                });
        }
        return rootView;
    }

    @java.lang.Override public void onResume()
    { super.onResume(); this.refreshSinceItemHasChanged(); }

    @java.lang.Override public void onDetach()
    { this.helper = this.helperChanger = null; super.onDetach(); }
    // endregion

    // region Package Methods
    void refreshSinceItemHasChanged()
    {
        final boolean itemIsNotNull = null != this.item;

        if (null != this.contentTextView)
            this.contentTextView.setText(itemIsNotNull ? this.item.getContent() : null);
        if (null != this.changeItemButton) this.changeItemButton.setEnabled(itemIsNotNull);
        if (null != this.deleteItemButton) this.deleteItemButton.setEnabled(itemIsNotNull);
    }

    void refreshSinceItemsHaveChanged()
    {
        final boolean canMoveUp, canMoveDown;

        if (null == this.item)
            { canMoveUp = canMoveDown = false; }
        else
            { canMoveUp = this.item.canMoveUp(); canMoveDown = this.item.canMoveDown(); }

        if (null != this.upButton  ) this.upButton.setEnabled  (canMoveUp  );
        if (null != this.downButton) this.downButton.setEnabled(canMoveDown);
    }
    // endregion
}