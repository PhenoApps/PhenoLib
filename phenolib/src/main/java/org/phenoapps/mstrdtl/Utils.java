package org.phenoapps.mstrdtl;

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
                Consts.JSON_KEY, trimmedJson);
        }
    }

    @androidx.annotation.NonNull public static android.content.Intent putJsonIntoIntent(
    @androidx.annotation.Nullable final Items items ,
    @androidx.annotation.NonNull  final android.content.Intent                  intent)
    {
        if (null == items)
            return intent;
        else
            return Utils.putJsonIntoIntent(
                items.toJson(), intent);
    }

    private static boolean canMoveUp(final int position)
    { return position > Item.MIN_POSITION; }

    // region Public Methods
    public static int nonNegativePosition(final int position)
    {
        if (position < Item.MIN_POSITION)
            throw new java.lang.IndexOutOfBoundsException(
                    Item.TOO_SMALL_POSITION_MESSAGE);
        else
            return position;
    }

    public static boolean canMoveUp(
            final Item.Container container, final int position)
    { return null != container && org.phenoapps.mstrdtl.Utils.canMoveUp(position); }

    public static boolean canMoveDown(
            final Item.Container container, final int position)
    {
        // noinspection SimplifiableConditionalExpression
        return null == container ? false : container.canMoveDown(position);
    }

    public static boolean canMoveUp(final int position, final int size)
    {
        // noinspection SimplifiableConditionalExpression
        return org.phenoapps.mstrdtl.Utils.canMoveUp(position) ? size > 0 : false;
    }

    public static boolean canMoveDown(final int position, final int size)
    {
        if (position < Item.MIN_POSITION)
            return false;
        else
        if (size <= 0)
            return false;
        else
        {
            final int lastPosition = size - 1;
            return position < lastPosition;
        }
    }

    @java.lang.SuppressWarnings({"TypeParameterExplicitlyExtendsObject"})
    public static <T extends java.lang.Object> void swap(
            final java.util.List<T> list, final int positionA, final int positionB)
    {
        if (null != list)
        {
            final Item
                    itemA = (Item) list.get(positionA),
                    itemB = (Item) list.get(positionB);
            java.util.Collections.swap(list, positionA, positionB);
            itemA.setPosition(positionB); itemB.setPosition(positionA);
        }
    }

    @java.lang.SuppressWarnings({"TypeParameterExplicitlyExtendsObject"}) public static<
            T extends java.lang.Object> void delete(final java.util.List<T> list, final int position)
    {
        if (null != list)
        {
            list.remove(position);

            // noinspection UnnecessaryLocalVariable
            final int firstPosition = position, lastPosition = list.size() - 1;
            for (int i = firstPosition; i <= lastPosition; i++)
                ((Item) list.get(i)).setPosition(i);
        }
    }
    // endregion


}