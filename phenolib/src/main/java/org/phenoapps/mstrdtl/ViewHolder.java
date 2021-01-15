package org.phenoapps.mstrdtl;

/**
 * Uses:
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.TextView
 *
 * androidx.annotation.NonNull
 * androidx.annotation.Nullable
 * androidx.recyclerview.widget.RecyclerView.ViewHolder
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.R
 */
class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder
{
    private final android.widget.TextView positionTextView, titleTextView;

    ViewHolder(@androidx.annotation.NonNull final android.view.View itemView)
    {
        super(itemView);

        this.positionTextView = this.itemView.findViewById(
            org.phenoapps.androidlibrary.R.id.masterDetailListItemPositionTextView);
        this.titleTextView = this.itemView.findViewById(
            org.phenoapps.androidlibrary.R.id.masterDetailListItemTitleTextView);
    }

    void bind(
    @androidx.annotation.Nullable final Item item           ,
    @androidx.annotation.Nullable final android.view.View.OnClickListener      onClickListener)
    {
        {
            @androidx.annotation.Nullable final java.lang.String position, title;
            if (null == item)
                position = title = null;
            else
                { position = item.getPositionAsString(); title = item.getTitle(); }

            if (null != this.positionTextView) this.positionTextView.setText(position);
            if (null != this.titleTextView   ) this.titleTextView.setText   (title   );
        }

        this.itemView.setOnClickListener(onClickListener);
    }
}