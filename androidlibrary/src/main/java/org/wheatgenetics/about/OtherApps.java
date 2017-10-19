package org.wheatgenetics.about;

/**
 * Uses:
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.androidlibrary.R
 */
@java.lang.SuppressWarnings("ClassExplicitlyExtendsObject")
public class OtherApps extends java.lang.Object
{
    public enum Index
    {
        NONE(-1), FIELD_BOOK(0), INVENTORY(1), COORDINATE(2), ONE_KK(3);
        private final int position;
        private Index(final int position) { this.position = position; }
    }

    // region Constants
    private static final java.lang.String allTexts[] =
        {"Field Book", "Inventory", "Coordinate", "1KK"};
    private static final java.lang.Integer allResIds[] = {
        org.wheatgenetics.androidlibrary.R.drawable.ic_field_book,
        org.wheatgenetics.androidlibrary.R.drawable.ic_inventory ,
        org.wheatgenetics.androidlibrary.R.drawable.ic_coordinate,
        org.wheatgenetics.androidlibrary.R.drawable.ic_1kk       };
    private static final java.lang.String allUris[] = {
        "https://play.google.com/store/apps/details?id=com.fieldbook.tracker"       ,
        "https://play.google.com/store/apps/details?id=org.wheatgenetics.inventory" ,
        "https://play.google.com/store/apps/details?id=org.wheatgenetics.coordinate",
        "https://play.google.com/store/apps/details?id=org.wheatgenetics.onekk"     };
    // endregion

    // region Fields
    private final java.lang.String  texts[], uris[];
    private final java.lang.Integer resIds[]       ;
    // endregion

    private static <T> T[] removeElement(@android.support.annotation.NonNull
    final T inputArray[], final org.wheatgenetics.about.OtherApps.Index suppressIndex)
    {
        if (null == inputArray)
            return null;
        else
        {
            final T outputArray[] = java.util.Arrays.copyOf(inputArray, inputArray.length - 1);
            {
                int i = 0;
                for (final org.wheatgenetics.about.OtherApps.Index index :
                org.wheatgenetics.about.OtherApps.Index.values())
                    if (org.wheatgenetics.about.OtherApps.Index.NONE != index
                    &&  suppressIndex                                != index)
                        outputArray[i++] = inputArray[index.position];
            }
            return outputArray;
        }
    }

    OtherApps(final org.wheatgenetics.about.OtherApps.Index suppressIndex)
    {
        super();

        if (org.wheatgenetics.about.OtherApps.Index.NONE == suppressIndex)
        {
            this.texts  = org.wheatgenetics.about.OtherApps.allTexts ;
            this.resIds = org.wheatgenetics.about.OtherApps.allResIds;
            this.uris   = org.wheatgenetics.about.OtherApps.allUris  ;
        }
        else
        {
            this.texts = org.wheatgenetics.about.OtherApps.<java.lang.String>removeElement(
                org.wheatgenetics.about.OtherApps.allTexts, suppressIndex);
            this.resIds = org.wheatgenetics.about.OtherApps.<java.lang.Integer>removeElement(
                org.wheatgenetics.about.OtherApps.allResIds, suppressIndex);
            this.uris = org.wheatgenetics.about.OtherApps.<java.lang.String>removeElement(
                org.wheatgenetics.about.OtherApps.allUris, suppressIndex);
        }
    }

    // region Package Methods
    java.lang.String [] getTexts () { return this.texts ; }
    java.lang.Integer[] getResIds() { return this.resIds; }
    java.lang.String [] getUris  () { return this.uris  ; }
    // endregion
}