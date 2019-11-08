package org.wheatgenetics.androidlibrary.mstrdtl;

/**
 * Uses:
 * android.content.Intent
 *
 * androidx.annotation.NonNull
 * androidx.annotation.Nullable
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.Consts
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Utils extends java.lang.Object
{
    @androidx.annotation.NonNull public static android.content.Intent putJsonIntoIntent(
    @androidx.annotation.Nullable final java.lang.String       json  ,
    @androidx.annotation.NonNull  final android.content.Intent intent)
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

    @androidx.annotation.NonNull public static android.content.Intent putJsonIntoIntent(
    @androidx.annotation.Nullable final org.wheatgenetics.javalib.mstrdtl.Items items ,
    @androidx.annotation.NonNull  final android.content.Intent                  intent)
    {
        if (null == items)
            return intent;
        else
            return org.wheatgenetics.androidlibrary.mstrdtl.Utils.putJsonIntoIntent(
                items.toJson(), intent);
    }
}