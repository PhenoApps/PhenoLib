package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * Uses:
 * android.os.Bundle
 * android.support.annotation.IdRes
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.support.v7.app.AppCompatActivity
 *
 * org.wheatgenetics.javalib.mstrdtl.Consts
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper
 */
abstract class Activity extends android.support.v7.app.AppCompatActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper
{
    // region Fields
    private java.lang.String                                      json = null ;
    private org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment itemFragment;
    // endregion

    private java.lang.String jsonFromItems()
    {
        final org.wheatgenetics.javalib.mstrdtl.Items items = this.items();
        if (null == items)
            return null;
        else
        {
            final java.lang.String json = items.toJson();
            if (null == json)
                return null;
            else
            {
                final java.lang.String trimmedJson = json.trim();
                return trimmedJson.length() <= 0 ? null : trimmedJson;
            }
        }
    }

    // region Package Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void refreshSinceItemsHaveChanged()
    { if (null != this.itemFragment) this.itemFragment.refreshSinceItemsHaveChanged(); }

    /** Called by ItemActivity.onCreate(). */
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void setAndAddItemFragment(@android.support.annotation.IdRes final int containerViewId,
    @android.support.annotation.NonNull
        final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment itemFragment)
    {
        this.itemFragment = itemFragment;
        this.getSupportFragmentManager().beginTransaction().add(
            containerViewId, this.itemFragment).commit();
    }

    /** Called by ListActivity.onCreate(). */
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void setAndReplaceItemFragment(@android.support.annotation.IdRes final int containerViewId,
    @android.support.annotation.NonNull
        final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment itemFragment)
    {
        this.itemFragment = itemFragment;
        this.getSupportFragmentManager().beginTransaction().replace(
            containerViewId, this.itemFragment).commit();
    }

    /** Called by ListActivity.delete(). */
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void removeAndClearItemFragment()
    {
        this.getSupportFragmentManager().beginTransaction().remove(this.itemFragment).commit();
        this.itemFragment = null;
    }

    /** Called by ItemActivity.delete() and ListActivity.delete(). */
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    boolean deleteWasSuccessful(@android.support.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        final org.wheatgenetics.javalib.mstrdtl.Items items = this.items();
        if (null == items)
            return false;
        else
            { items.delete(position); return true; }
    }
    // endregion

    // region Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected java.lang.String getJson() { return this.json; }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected abstract org.wheatgenetics.javalib.mstrdtl.Items items();

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected void refreshSinceItemHasChanged()
    { if (null != this.itemFragment) this.itemFragment.refreshSinceItemHasChanged(); }
    // endregion

    // region Overridden Methods
    @java.lang.Override protected void onCreate(
    @android.support.annotation.Nullable final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (null != savedInstanceState) this.json = savedInstanceState.getString(
            org.wheatgenetics.androidlibrary.mstrdtl.Consts.JSON_KEY);
    }

    @java.lang.Override protected void onSaveInstanceState(final android.os.Bundle outState)
    {
        if (null != outState)
        {
            final java.lang.String json = this.jsonFromItems();
            if (null != json)
                outState.putString(org.wheatgenetics.androidlibrary.mstrdtl.Consts.JSON_KEY, json);
        }
        super.onSaveInstanceState(outState);
    }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper Overridden Methods
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        final org.wheatgenetics.javalib.mstrdtl.Items items = this.items();
        return null == items ? null : items.get(position);
    }

    @java.lang.Override public void moveUp(@android.support.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        final org.wheatgenetics.javalib.mstrdtl.Items items = this.items();
        if (null != items) { items.moveUp(position); this.refreshSinceItemsHaveChanged(); }
    }

    @java.lang.Override public void moveDown(@android.support.annotation.IntRange(
    from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION) final int position)
    {
        final org.wheatgenetics.javalib.mstrdtl.Items items = this.items();
        if (null != items) { items.moveDown(position); this.refreshSinceItemsHaveChanged(); }
    }
    // endregion
    // endregion
}