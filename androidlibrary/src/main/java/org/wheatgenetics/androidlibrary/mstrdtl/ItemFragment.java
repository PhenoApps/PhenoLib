package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * A fragment representing item content.  This fragment is contained in either a
 * {@link ListActivity} in two-pane mode or in an {@link ItemActivity} in one-pane mode.
 *
 * Uses:
 * android.content.Context
 * android.os.Bundle
 * android.util.Log
 * android.view.LayoutInflater
 * android.view.View
 * android.view.View.OnClickListener
 * android.view.ViewGroup
 * android.widget.Button
 * android.widget.TextView
 *
 * androidx.annotation.IntRange
 * androidx.annotation.NonNull
 * androidx.annotation.Nullable
 * androidx.fragment.app.Fragment
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.R
 */
public class ItemFragment extends androidx.fragment.app.Fragment
{
    // region Types
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Helper
    {
        public org.wheatgenetics.javalib.mstrdtl.Item get(@androidx.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);

        public void setToolbarTitle  (final java.lang.CharSequence title);
        public void clearToolbarTitle()                                  ;
    }

    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface HelperChanger
    extends org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper
    {
        public void moveUp(@androidx.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);

        public void moveDown(@androidx.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);

        public void change(
        @androidx.annotation.NonNull org.wheatgenetics.javalib.mstrdtl.Item item);

        public void delete(@androidx.annotation.IntRange(
        from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) int position);
    }
    // endregion

    /** Key to the bundle argument that has the position of the item. */
    static final java.lang.String POSITION_KEY = "position";

    // region Fields
    private org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper        helper = null;
    private org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.HelperChanger
        helperChanger = null;

    private int                                    position     =   -1;
    private org.wheatgenetics.javalib.mstrdtl.Item itemInstance = null;                 // lazy load

    private android.widget.TextView contentTextView = null;
    private android.widget.Button   upButton = null, downButton = null,
        changeItemButton = null, deleteItemButton = null;
    // endregion

    // region private Methods
    private static void log(@androidx.annotation.NonNull final java.lang.String msg)
    { android.util.Log.i("ItemFragment", msg); }

    private boolean changerIsImplemented()
    { return null == this.helper && null != this.helperChanger; }

    private org.wheatgenetics.javalib.mstrdtl.Item get()
    {
        final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper helper =
            null == this.helper ? this.helperChanger : this.helper;
        return null == helper ? null : helper.get(this.position);
    }

    private org.wheatgenetics.javalib.mstrdtl.Item item()
    {
        if (null == this.itemInstance)
            try { this.itemInstance = this.get(); }
            catch (final java.lang.IndexOutOfBoundsException e) { /* Leave set to null. */ }
        return this.itemInstance;
    }

    private void moveUp()
    {
        if (this.changerIsImplemented())
        {
            final org.wheatgenetics.javalib.mstrdtl.Item item = this.item();
            if (null != item)
            {
                this.helperChanger.moveUp(item.getPosition());
                this.position = item.getPosition();
            }
        }
    }

    private void moveDown()
    {
        if (this.changerIsImplemented())
        {
            final org.wheatgenetics.javalib.mstrdtl.Item item = this.item();
            if (null != item)
            {
                this.helperChanger.moveDown(item.getPosition());
                this.position = item.getPosition();
            }
        }
    }

    private void changeItem()
    {
        if (this.changerIsImplemented())
        {
            final org.wheatgenetics.javalib.mstrdtl.Item item = this.item();
            if (null != item) this.helperChanger.change(item);
        }
    }

    private void deleteItem()
    {
        if (this.changerIsImplemented())
        {
            final org.wheatgenetics.javalib.mstrdtl.Item item = this.item();
            if (null != item)
            {
                this.helperChanger.delete(item.getPosition());
                this.position = -1; this.itemInstance = null;
            }
        }
    }

    private void setToolbarTitle(final java.lang.CharSequence title)
    {
        final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper helper =
            null == this.helper ? this.helperChanger : this.helper;
        if (null != helper) helper.setToolbarTitle(title);
    }

    private void clearToolbarTitle()
    {
        final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper helper =
            null == this.helper ? this.helperChanger : this.helper;
        if (null != helper) helper.clearToolbarTitle();
    }
    // endregion

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g., upon
     * screen orientation changes).
     */
    public ItemFragment() {}

    // region Overridden Methods
    @java.lang.Override public void onAttach(
    @androidx.annotation.NonNull final android.content.Context context)
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
            throw new java.lang.RuntimeException(context.toString() + " must implement Helper");
    }

    @java.lang.Override public void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        @androidx.annotation.NonNull final java.lang.String positionMsg;
        {
            final java.lang.String POSITION_KEY =
                org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.POSITION_KEY;
            if (null == savedInstanceState)
            {
                final android.os.Bundle arguments = this.getArguments();
                if (null == arguments)
                    positionMsg = "arguments is null";
                else
                    if (arguments.containsKey(POSITION_KEY))
                    {
                        this.position = arguments.getInt(POSITION_KEY);
                        positionMsg   = "position: " + this.position  ;
                    }
                    else positionMsg = "arguments does not contain " + POSITION_KEY;
            }
            else
                if (savedInstanceState.containsKey(POSITION_KEY))
                {
                    this.position = savedInstanceState.getInt(POSITION_KEY);
                    positionMsg   = "position: " + this.position           ;
                }
                else positionMsg = "savedInstanceState does not contain " + POSITION_KEY;
        }
        org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.log(positionMsg);
    }

    @java.lang.Override public android.view.View onCreateView(
    @androidx.annotation.NonNull  final android.view.LayoutInflater inflater          ,
    @androidx.annotation.Nullable final android.view.ViewGroup      container         ,
    @androidx.annotation.Nullable final android.os.Bundle           savedInstanceState)
    {
        final android.view.View rootView = inflater.inflate(
            org.wheatgenetics.androidlibrary.R.layout.mstrdtl_item_fragment,
            container, /* attachToRoot => */false);
        if (null != rootView)
        {
            this.contentTextView = rootView.findViewById(
                org.wheatgenetics.androidlibrary.R.id.masterDetailItemContentTextView);

            if (this.changerIsImplemented())
            {
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

                this.changeItemButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.changeItemButton);
                if (null != this.changeItemButton) this.changeItemButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View view)
                        { org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.this.changeItem(); }
                    });

                this.deleteItemButton = rootView.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.deleteItemButton);
                if (null != this.deleteItemButton) this.deleteItemButton.setOnClickListener(
                    new android.view.View.OnClickListener()
                    {
                        @java.lang.Override public void onClick(final android.view.View view)
                        { org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.this.deleteItem(); }
                    });
            }

            this.refreshSinceItemsHaveChanged();
        }
        return rootView;
    }

    @java.lang.Override public void onResume()
    { super.onResume(); this.refreshSinceItemHasChanged(); }

    @java.lang.Override public void onSaveInstanceState(
    @androidx.annotation.NonNull final android.os.Bundle outState)
    {
        outState.putInt(
            org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.POSITION_KEY, this.position);
        super.onSaveInstanceState(outState);
    }

    @java.lang.Override public void onDetach()
    { this.helper = this.helperChanger = null; super.onDetach(); }
    // endregion

    // region Package Methods
    void refreshSinceItemHasChanged()
    {
        final boolean enable;
        {
            final boolean itemIsNotNull;
            {
                final org.wheatgenetics.javalib.mstrdtl.Item item = this.item();
                itemIsNotNull = null != item;

                if (itemIsNotNull)
                    this.setToolbarTitle(item.getTitle());
                else
                    this.clearToolbarTitle();

                if (null != this.contentTextView)
                    this.contentTextView.setText(itemIsNotNull ? item.getContent() : null);
            }
            enable = this.changerIsImplemented() && itemIsNotNull;
        }
        if (null != this.changeItemButton) this.changeItemButton.setEnabled(enable);
        if (null != this.deleteItemButton) this.deleteItemButton.setEnabled(enable);
    }

    void refreshSinceItemsHaveChanged()
    {
        final boolean canMoveUp, canMoveDown;
        {
            final org.wheatgenetics.javalib.mstrdtl.Item item = this.item();
            if (null == item)
                { canMoveUp = canMoveDown = false; }
            else
                { canMoveUp = item.canMoveUp(); canMoveDown = item.canMoveDown(); }
        }
        if (null != this.upButton  ) this.upButton.setEnabled  (canMoveUp  );
        if (null != this.downButton) this.downButton.setEnabled(canMoveDown);
    }
    // endregion
}