package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * Uses:
 * android.app.Activity
 * android.content.Context
 * android.content.Intent
 * android.view.View
 * android.view.View.OnClickListener
 *
 * androidx.annotation.IntRange
 * androidx.annotation.NonNull
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope

 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Adapter
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment
 * org.wheatgenetics.androidlibrary.mstrdtl.Utils
 */
public abstract class OnePaneAdapter extends org.wheatgenetics.androidlibrary.mstrdtl.Adapter
{
    static final int REQUEST_CODE = 1;

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    protected abstract java.lang.Class concreteItemActivityClass();

    protected OnePaneAdapter(@androidx.annotation.NonNull
    final org.wheatgenetics.javalib.mstrdtl.Items items) { super(items); }

    @java.lang.Override android.view.View.OnClickListener makeOnClickListener(
    @androidx.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        return new android.view.View.OnClickListener()
            {
                @java.lang.Override public void onClick(final android.view.View view)
                {
                    if (null != view)
                    {
                        final android.content.Context context = view.getContext();
                        if (context instanceof android.app.Activity)
                        {
                            final android.content.Intent intent = new android.content.Intent(
                                context, org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
                                    .this.concreteItemActivityClass() /* polymorphism */);
                            intent.putExtra(
                                org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.POSITION_KEY,
                                position                                                          );
                            ((android.app.Activity) context).startActivityForResult(
                                org.wheatgenetics.androidlibrary.mstrdtl.Utils.putJsonIntoIntent(
                                    /* items => */ org.wheatgenetics.androidlibrary
                                        .mstrdtl.OnePaneAdapter.this.getItems(),
                                    /* intent => */ intent),
                                org.wheatgenetics.androidlibrary.mstrdtl
                                    .OnePaneAdapter.REQUEST_CODE);
                        }
                    }
                }
            };
    }
}