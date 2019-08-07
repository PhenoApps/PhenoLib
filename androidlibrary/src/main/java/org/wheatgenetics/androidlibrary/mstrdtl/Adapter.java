package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * Uses:
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.support.v7.widget.RecyclerView.Adapter
 * android.view.LayoutInflater
 * android.view.View.OnClickListener
 * android.view.ViewGroup
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ViewHolder
 */
abstract class Adapter extends android.support.v7.widget.RecyclerView.Adapter<
org.wheatgenetics.androidlibrary.mstrdtl.ViewHolder>
{
    private final org.wheatgenetics.javalib.mstrdtl.Items items;

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    abstract android.view.View.OnClickListener makeOnClickListener(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position);

    Adapter(@android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Items items)
    { super(); this.items = items; }

    // region Overridden Methods
    @java.lang.Override @android.support.annotation.NonNull
    public org.wheatgenetics.androidlibrary.mstrdtl.ViewHolder onCreateViewHolder(
    @android.support.annotation.NonNull final android.view.ViewGroup parent, final int viewType)
    {
        return new org.wheatgenetics.androidlibrary.mstrdtl.ViewHolder(
            android.view.LayoutInflater.from(parent.getContext()).inflate(
                org.wheatgenetics.androidlibrary.R.layout.mstrdtl_list_item,
                parent, /* attachToRoot => */false));
    }

    @java.lang.Override public void onBindViewHolder(@android.support.annotation.NonNull
    final org.wheatgenetics.androidlibrary.mstrdtl.ViewHolder viewHolder,
    final int                             position                      )
    {
        if (null != this.items) viewHolder.bind(
            /* item            => */ this.items.get          (position)                    ,
            /* onClickListener => */ this.makeOnClickListener(position) /* polymorphism */);
    }

    @java.lang.Override public int getItemCount()
    { return null == this.items ? 0 : this.items.size(); }
    // endregion
}