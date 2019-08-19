package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * Uses:
 * android.content.Context
 * android.content.Intent
 * android.support.annotation.IntRange
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.view.View
 * android.view.View.OnClickListener
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Adapter
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment
 */
public abstract class OnePaneAdapter extends org.wheatgenetics.androidlibrary.mstrdtl.Adapter
{
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected abstract java.lang.Class concreteItemActivityClass();

    protected OnePaneAdapter(final org.wheatgenetics.javalib.mstrdtl.Items items) { super(items); }

    @java.lang.Override android.view.View.OnClickListener makeOnClickListener(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        return new android.view.View.OnClickListener()
            {
                @java.lang.Override public void onClick(final android.view.View view)
                {
                    if (null != view)
                    {
                        final android.content.Context context = view.getContext();

                        final android.content.Intent intent = new android.content.Intent(
                            context, org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
                                .this.concreteItemActivityClass() /* polymorphism */);
                        intent.putExtra(
                            org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.POSITION_KEY,
                            position                                                          );

                        if (null != context) context.startActivity(intent);
                    }
                }
            };
    }
}
