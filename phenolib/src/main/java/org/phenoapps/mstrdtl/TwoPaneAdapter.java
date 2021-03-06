package org.phenoapps.mstrdtl;

/**
 * Uses:
 * android.os.Bundle
 * android.view.View
 * android.view.View.OnClickListener
 *
 * androidx.annotation.IntRange
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Adapter
 * org.wheatgenetics.androidlibrary.mstrdtl.ItemFragment
 */
class TwoPaneAdapter extends Adapter
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) interface Helper
    { public void replace(ItemFragment itemFragment); }

    private final TwoPaneAdapter.Helper helper;

    private void replace(final ItemFragment itemFragment)
    { if (null != this.helper) this.helper.replace(itemFragment); }

    TwoPaneAdapter(
    @androidx.annotation.NonNull final Items items ,
    final TwoPaneAdapter.Helper       helper)
    { super(items); this.helper = helper; }

    @java.lang.Override android.view.View.OnClickListener makeOnClickListener(
    @androidx.annotation.IntRange(from = Item.MIN_POSITION)
        final int position)
    {
        return new android.view.View.OnClickListener()
            {
                @java.lang.Override public void onClick(final android.view.View view)
                {
                    final ItemFragment itemFragment =
                        new ItemFragment();
                    {
                        final android.os.Bundle arguments = new android.os.Bundle();
                        arguments.putInt(
                            ItemFragment.POSITION_KEY,
                            position                                                          );
                        itemFragment.setArguments(arguments);
                    }
                    TwoPaneAdapter.this.replace(
                        itemFragment);
                }
            };
    }
}