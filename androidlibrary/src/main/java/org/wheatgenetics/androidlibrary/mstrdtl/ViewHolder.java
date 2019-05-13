package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * Uses:
 * android.support.annotation.NonNull
 * android.support.v7.widget.RecyclerView.ViewHolder
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.TextView
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 *
 * org.wheatgenetics.androidlibrary.R
 */
class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
{
    private final android.widget.TextView positionTextView, titleTextView;

    ViewHolder(@android.support.annotation.NonNull final android.view.View itemView)
    {
        super(itemView);

        this.positionTextView = this.itemView.findViewById(
            org.wheatgenetics.androidlibrary.R.id.masterDetailListItemPositionTextView);
        this.titleTextView = this.itemView.findViewById(
            org.wheatgenetics.androidlibrary.R.id.masterDetailListItemTitleTextView);
    }

    void bind(final org.wheatgenetics.javalib.mstrdtl.Item item,
    final android.view.View.OnClickListener onClickListener)
    {
        {
            final java.lang.String position, title;
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