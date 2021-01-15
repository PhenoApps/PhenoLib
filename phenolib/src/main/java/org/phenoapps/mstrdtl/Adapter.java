package org.phenoapps.mstrdtl;

/**
 * Uses:
 * android.view.LayoutInflater
 * android.view.View.OnClickListener
 * android.view.ViewGroup
 *
 * androidx.annotation.IntRange
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 * androidx.recyclerview.widget.RecyclerView.Adapter
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.ViewHolder
 */
abstract class Adapter extends androidx.recyclerview.widget.RecyclerView.Adapter<
        ViewHolder>
{
    @androidx.annotation.NonNull private final Items items;

    // region Package Methods
    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    abstract android.view.View.OnClickListener makeOnClickListener(@androidx.annotation.IntRange(
    from = Item.MIN_POSITION) final int position);

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @androidx.annotation.NonNull
    Items getItems()
    { return this.items; }
    // endregion

    Adapter(@androidx.annotation.NonNull final Items items)
    { super(); this.items = items; }

    // region Overridden Methods
    @java.lang.Override @androidx.annotation.NonNull
    public ViewHolder onCreateViewHolder(
    @androidx.annotation.NonNull final android.view.ViewGroup parent, final int viewType)
    {
        return new ViewHolder(
            android.view.LayoutInflater.from(parent.getContext()).inflate(
                org.phenoapps.androidlibrary.R.layout.mstrdtl_list_item,
                parent, /* attachToRoot => */false));
    }

    @java.lang.Override public void onBindViewHolder(@androidx.annotation.NonNull
    final ViewHolder viewHolder,
    final int                                                 position  )
    {
        viewHolder.bind(
            /* item            => */ this.getItems().get     (position)                    ,
            /* onClickListener => */ this.makeOnClickListener(position) /* polymorphism */);
    }

    @java.lang.Override public int getItemCount() { return this.getItems().size(); }
    // endregion
}