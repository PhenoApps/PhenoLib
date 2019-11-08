package org.wheatgenetics.brapi1_3;

/**
 * Uses:
 * android.app.Activity
 *
 * androidx.annotation.IntRange
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * io.swagger.client.model.WSMIMEDataTypes
 *
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.brapi1_3.TypeAlertDialog
 */
public class DataTypeAlertDialog extends org.wheatgenetics.brapi1_3.TypeAlertDialog
{
    public DataTypeAlertDialog(final android.app.Activity activity) { super(activity); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.DataTypeAlertDialogTitle);
        super.configure();
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.String[] items()
    {
        if (this.itemsIsNull())
        {
            // noinspection Convert2Diamond
            final java.util.ArrayList<java.lang.String> arrayList =
                new java.util.ArrayList<java.lang.String>();

            arrayList.add("null");
            {
                @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
                final io.swagger.client.model.WSMIMEDataTypes dataTypes[] =
                    io.swagger.client.model.WSMIMEDataTypes.values();
                for (final io.swagger.client.model.WSMIMEDataTypes dataType: dataTypes)
                    arrayList.add(dataType.toString());
            }

            this.createItems(arrayList);
        }
        return super.items();
    }
    // endregion

    public io.swagger.client.model.WSMIMEDataTypes item(
    @androidx.annotation.IntRange(from = 0) final int i)
    { return 0 == i ? null : io.swagger.client.model.WSMIMEDataTypes.fromValue(this.items()[i]); }
}