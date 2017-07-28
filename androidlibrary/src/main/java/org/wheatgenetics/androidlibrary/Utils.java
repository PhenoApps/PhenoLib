package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.content.Context
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 * android.widget.Toast
 */

public class Utils extends java.lang.Object
{
    private static android.content.DialogInterface.OnClickListener
        dismissingOnClickListenerInstance = null, cancellingOnClickListenerInstance = null;

    // region OnClickListener Methods
    public static android.content.DialogInterface.OnClickListener dismissingOnClickListener()
    {
        if (null == org.wheatgenetics.androidlibrary.Utils.dismissingOnClickListenerInstance)
            org.wheatgenetics.androidlibrary.Utils.dismissingOnClickListenerInstance =
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override
                    public void onClick(final android.content.DialogInterface dialog,
                    final int which)
                    {
                        assert dialog != null;
                        dialog.dismiss();
                    }
                };
        return org.wheatgenetics.androidlibrary.Utils.dismissingOnClickListenerInstance;
    }

    public static android.content.DialogInterface.OnClickListener cancellingOnClickListener()
    {
        if (null == org.wheatgenetics.androidlibrary.Utils.cancellingOnClickListenerInstance)
            org.wheatgenetics.androidlibrary.Utils.cancellingOnClickListenerInstance =
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override
                    public void onClick(final android.content.DialogInterface dialog,
                    final int which)
                    {
                        assert dialog != null;
                        dialog.cancel();
                    }
                };
        return org.wheatgenetics.androidlibrary.Utils.cancellingOnClickListenerInstance;
    }
    // endregion

    // region Toast Methods
    private static void showToast(final android.content.Context context,
    final java.lang.CharSequence text, final int duration)
    { android.widget.Toast.makeText(context, text, duration).show(); }

    public static void showLongToast(final android.content.Context context,
    final java.lang.CharSequence text)
    {
        org.wheatgenetics.androidlibrary.Utils.showToast(
            context, text, android.widget.Toast.LENGTH_LONG);
    }

    public static void showShortToast(final android.content.Context context,
        final java.lang.CharSequence text)
    {
        org.wheatgenetics.androidlibrary.Utils.showToast(
            context, text, android.widget.Toast.LENGTH_SHORT);
    }
    // endregion
}