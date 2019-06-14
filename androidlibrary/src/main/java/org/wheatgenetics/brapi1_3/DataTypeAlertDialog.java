package org.wheatgenetics.brapi1_3;                                // TODO: Inherit from superclass?

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.IntRange
 *
 * io.swagger.client.model.WSMIMEDataTypes
 *
 * org.wheatgenetics.androidlibrary.ItemsAlertDialog
 * org.wheatgenetics.androidlibrary.R
 */
public class DataTypeAlertDialog extends org.wheatgenetics.androidlibrary.ItemsAlertDialog
{
    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
    private java.lang.String itemsInstance[] = null;                                    // lazy load

    private java.lang.String[] items()
    {
        if (null == this.itemsInstance)
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
            this.itemsInstance = new java.lang.String[arrayList.size()];
            this.itemsInstance = arrayList.toArray(this.itemsInstance);
        }
        return this.itemsInstance;
    }

    public DataTypeAlertDialog(final android.app.Activity activity) { super(activity); }

    // region Overridden Methods
    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.DataTypeAlertDialogTitle);
        this.setCancelNegativeButton();
    }

    @java.lang.Override public void show() { this.show(this.items()); }
    // endregion

    public io.swagger.client.model.WSMIMEDataTypes item(
    @android.support.annotation.IntRange(from = 0) final int i)
    { return 0 == i ? null : io.swagger.client.model.WSMIMEDataTypes.fromValue(this.items()[i]); }
}