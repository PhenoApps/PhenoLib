package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * Uses:
 * android.app.Activity
 * android.content.Intent
 * android.os.Bundle
 * android.support.annotation.IdRes
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.support.v7.app.AppCompatActivity
 * android.util.Log
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Consts
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper
 * org.wheatgenetics.androidlibrary.mstrdtl.Utils
 */
abstract class Activity extends android.support.v7.app.AppCompatActivity
implements org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper
{
    // region Fields
    private java.lang.String                                      json = null ;
    private org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment itemFragment;
    // endregion

    // region Private Methods
    private void log(@android.support.annotation.NonNull final java.lang.String msg)
    { android.util.Log.d(this.getClass().getName(), msg); }

    private java.lang.String jsonFromItems()
    {
        final java.lang.String result;
        {
            final java.lang.String json = this.items().toJson();
            if (null == json)
                return null;
            else
                result = json.trim();
        }
        return result.length() <= 0 ? null : result;
    }

    @android.support.annotation.NonNull private android.content.Intent putJsonIntoIntent(
    @android.support.annotation.NonNull final android.content.Intent intent)
    {
        final java.lang.String json = this.jsonFromItems();
        this.log("setResultFromJson(): putJsonIntoIntent(): " + json);
        return org.wheatgenetics.androidlibrary.mstrdtl.Utils.putJsonIntoIntent(json, intent);
    }
    // endregion

    // region Package Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void setJsonFromIntent(
    @android.support.annotation.NonNull final java.lang.String       source,
    @android.support.annotation.NonNull final android.content.Intent intent)
    {
        {
            final java.lang.String JSON_KEY =
                org.wheatgenetics.androidlibrary.mstrdtl.Consts.JSON_KEY;
            this.json = intent.hasExtra(JSON_KEY) ? intent.getStringExtra(JSON_KEY) : null;
        }
        this.log(source + ": setJsonFromIntent(): " + this.json);
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void setResultFromJson()
    {
        this.setResult(android.app.Activity.RESULT_OK,
            this.putJsonIntoIntent(new android.content.Intent()));
    }

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

    /** Called by ListActivity.setAndReplaceItemFragment(). */
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void setAndReplaceItemFragment(@android.support.annotation.IdRes final int containerViewId,
    @android.support.annotation.NonNull
        final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment itemFragment)
    {
        this.itemFragment = itemFragment;
        this.getSupportFragmentManager().beginTransaction().replace(
            containerViewId, this.itemFragment).commit();
    }

    /** Called by ChangeableListActivity.delete(). */
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void removeAndClearItemFragment()
    {
        this.getSupportFragmentManager().beginTransaction().remove(this.itemFragment).commit();
        this.itemFragment = null;
    }

    /**
     * Called by ListActivity.refreshSinceItemsHaveChanged() and
     * ChangeableItemActivity.refreshSinceItemsHaveChanged().
     */
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    void refreshSinceItemsHaveChanged()
    { if (null != this.itemFragment) this.itemFragment.refreshSinceItemsHaveChanged(); }
    // endregion

    // region Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @android.support.annotation.NonNull
    protected abstract org.wheatgenetics.javalib.mstrdtl.Items items();

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected java.lang.String getJson() { return this.json; }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected void refreshSinceItemHasChanged()
    { if (null != this.itemFragment) this.itemFragment.refreshSinceItemHasChanged(); }
    // endregion

    // region Overridden Methods
    @java.lang.Override protected void onCreate(
    @android.support.annotation.Nullable final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (null == savedInstanceState)
            this.setJsonFromIntent("onCreate()", this.getIntent());
        else
        {
            final java.lang.String JSON_KEY =
                org.wheatgenetics.androidlibrary.mstrdtl.Consts.JSON_KEY;
            this.json = savedInstanceState.containsKey(JSON_KEY) ?
                savedInstanceState.getString(JSON_KEY) : null;
        }
    }

    @java.lang.Override protected void onSaveInstanceState(final android.os.Bundle outState)
    {
        if (null != outState)
        {
            final java.lang.String json = this.jsonFromItems();
            if (null != json) outState.putString(
                org.wheatgenetics.androidlibrary.mstrdtl.Consts.JSON_KEY, json);
        }
        super.onSaveInstanceState(outState);
    }

    @java.lang.Override public void onBackPressed()
    { this.setResultFromJson(); super.onBackPressed(); }

    // region org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.Helper Overridden Method
    @java.lang.Override public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
    final int position) { return this.items().get(position); }
    // endregion
    // endregion
}