package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 */

public class Utils extends java.lang.Object
{
    private static android.content.DialogInterface.OnClickListener
        dismissingOnClickListenerInstance = null, cancellingOnClickListenerInstance = null;

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
}