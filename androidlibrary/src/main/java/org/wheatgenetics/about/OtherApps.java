package org.wheatgenetics.about;

/**
 * Uses:
 * org.wheatgenetics.androidlibrary.R
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class OtherApps extends java.lang.Object
{
    @java.lang.SuppressWarnings({"UnnecessaryEnumModifier"})
    public enum Index
    {
        NONE(-1), FIELD_BOOK(0), INVENTORY(1), COORDINATE(2), ONE_KK(3);
        private final int position;
        private Index(final int position) { this.position = position; }
    }

    // region Constants
    private static final java.lang.String ALL_TEXTS[] =
        {"Field Book", "Inventory", "Coordinate", "1KK"};
    private static final java.lang.Integer ALL_RES_IDS[] = {
        org.wheatgenetics.androidlibrary.R.drawable.ic_field_book,
        org.wheatgenetics.androidlibrary.R.drawable.ic_inventory ,
        org.wheatgenetics.androidlibrary.R.drawable.ic_coordinate,
        org.wheatgenetics.androidlibrary.R.drawable.ic_1kk       };
    private static final java.lang.String ALL_URIS[] = {
        "https://play.google.com/store/apps/details?id=com.fieldbook.tracker"       ,
        "https://play.google.com/store/apps/details?id=org.wheatgenetics.inventory" ,
        "https://play.google.com/store/apps/details?id=org.wheatgenetics.coordinate",
        "https://play.google.com/store/apps/details?id=org.wheatgenetics.onekk"     };
    // endregion

    // region Fields
    private final java.lang.String  texts[], uris[];
    private final java.lang.Integer resIds[]       ;
    // endregion

    private static <T> T[] removeElement(final T allTs[],
    final org.wheatgenetics.about.OtherApps.Index suppressIndex)
    {
        if (null == allTs)
            return null;
        else
        {
            final T result[] = java.util.Arrays.copyOf(allTs, allTs.length - 1);
            {
                int i = 0;
                for (final org.wheatgenetics.about.OtherApps.Index index:
                org.wheatgenetics.about.OtherApps.Index.values())
                    if (org.wheatgenetics.about.OtherApps.Index.NONE != index
                    &&  suppressIndex                                != index)
                        result[i++] = allTs[index.position];
            }
            return result;
        }
    }

    OtherApps(final org.wheatgenetics.about.OtherApps.Index suppressIndex)
    {
        super();

        if (org.wheatgenetics.about.OtherApps.Index.NONE == suppressIndex)
        {
            this.texts  = org.wheatgenetics.about.OtherApps.ALL_TEXTS  ;
            this.resIds = org.wheatgenetics.about.OtherApps.ALL_RES_IDS;
            this.uris   = org.wheatgenetics.about.OtherApps.ALL_URIS   ;
        }
        else
        {
            this.texts = org.wheatgenetics.about.OtherApps.<java.lang.String>removeElement(
                org.wheatgenetics.about.OtherApps.ALL_TEXTS, suppressIndex);
            this.resIds = org.wheatgenetics.about.OtherApps.<java.lang.Integer>removeElement(
                org.wheatgenetics.about.OtherApps.ALL_RES_IDS, suppressIndex);
            this.uris = org.wheatgenetics.about.OtherApps.<java.lang.String>removeElement(
                org.wheatgenetics.about.OtherApps.ALL_URIS, suppressIndex);
        }
    }

    // region Package Methods
    java.lang.String [] getTexts () { return this.texts ; }
    java.lang.Integer[] getResIds() { return this.resIds; }
    java.lang.String [] getUris  () { return this.uris  ; }
    // endregion
}