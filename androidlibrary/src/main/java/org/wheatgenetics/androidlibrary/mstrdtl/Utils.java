package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * Uses:
 * android.content.Intent
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Consts
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Utils extends java.lang.Object
{
    @android.support.annotation.NonNull public static android.content.Intent putJsonIntoIntent(
    @android.support.annotation.Nullable final java.lang.String       json  ,
    @android.support.annotation.NonNull  final android.content.Intent intent)
    {
        if (null == json)
            return intent;
        else
        {
            final java.lang.String trimmedJson = json.trim();
            return trimmedJson.length() <= 0 ? intent : intent.putExtra(
                org.wheatgenetics.androidlibrary.mstrdtl.Consts.JSON_KEY, trimmedJson);
        }
    }

    @android.support.annotation.NonNull public static android.content.Intent putJsonIntoIntent(
    @android.support.annotation.Nullable final org.wheatgenetics.javalib.mstrdtl.Items items ,
    @android.support.annotation.NonNull  final android.content.Intent                  intent)
    {
        if (null == items)
            return intent;
        else
            return org.wheatgenetics.androidlibrary.mstrdtl.Utils.putJsonIntoIntent(
                items.toJson(), intent);
    }
}