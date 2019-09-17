package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * Uses:
 * android.os.Bundle
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.view.View
 * android.view.View.OnClickListener
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Adapter
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment
 */
class TwoPaneAdapter extends org.wheatgenetics.androidlibrary.mstrdtl.Adapter
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) interface Helper
    { public void replace(org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment itemFragment); }

    private final org.wheatgenetics.androidlibrary.mstrdtl.TwoPaneAdapter.Helper helper;

    private void replace(final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment itemFragment)
    { if (null != this.helper) this.helper.replace(itemFragment); }

    TwoPaneAdapter(@android.support.annotation.NonNull
    final org.wheatgenetics.javalib.mstrdtl.Items                        items ,
    final org.wheatgenetics.androidlibrary.mstrdtl.TwoPaneAdapter.Helper helper)
    { super(items); this.helper = helper; }

    @java.lang.Override android.view.View.OnClickListener makeOnClickListener(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        return new android.view.View.OnClickListener()
            {
                @java.lang.Override public void onClick(final android.view.View view)
                {
                    final org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment itemFragment =
                        new org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment();
                    {
                        final android.os.Bundle arguments = new android.os.Bundle();
                        arguments.putInt(
                            org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment.POSITION_KEY,
                            position                                                          );
                        itemFragment.setArguments(arguments);
                    }
                    org.wheatgenetics.androidlibrary.mstrdtl.TwoPaneAdapter.this.replace(
                        itemFragment);
                }
            };
    }
}