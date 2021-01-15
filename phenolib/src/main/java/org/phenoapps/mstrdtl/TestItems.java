package org.phenoapps.mstrdtl;

/**
 * Uses:
 * com.google.gson.Gson
 * com.google.gson.GsonBuilder
 * com.google.gson.reflect.TypeToken
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 * org.wheatgenetics.javalib.mstrdtl.TestItem
 * org.wheatgenetics.javalib.mstrdtl.Utils
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class TestItems extends java.lang.Object implements Items
{
    // region Fields
    private java.util.List<TestItem> listInstance = null;    // ll
    private com.google.gson.Gson                                       gsonInstance = null;    // ll
    private java.lang.reflect.Type                                     typeInstance = null;    // ll
    // endregion

    // region Private Methods
    private java.util.List<TestItem> list()
    {
        if (null == this.listInstance)
            // noinspection Convert2Diamond
            this.listInstance =
                new java.util.ArrayList<TestItem>();
        return this.listInstance;
    }

    private com.google.gson.Gson gson()
    {
        if (null == this.gsonInstance)
            this.gsonInstance = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
        return this.gsonInstance;
    }

    private Items clear()
    { if (null != this.listInstance) this.listInstance.clear(); return this; }

    private java.lang.reflect.Type type()
    {
        if (null == this.typeInstance) this.typeInstance = new com.google.gson.reflect.TypeToken<
            java.util.List<TestItem>>(){}.getType();
        return this.typeInstance;
    }
    // endregion

    @java.lang.SuppressWarnings({"WeakerAccess"}) public TestItems() { super(); }

    // region org.wheatgenetics.javalib.mstrdtl.Items Overridden Methods
    @java.lang.Override public boolean canMoveDown(final int position)
    { return org.phenoapps.mstrdtl.Utils.canMoveDown(position, this.size()); }

    @java.lang.Override public void moveUp(final int position)
    {
        if (org.phenoapps.mstrdtl.Utils.canMoveUp(position, this.size()))
            org.phenoapps.mstrdtl.Utils.swap(
                this.listInstance, position,position - 1);
    }

    @java.lang.Override public void moveDown(final int position)
    {
        if (org.phenoapps.mstrdtl.Utils.canMoveDown(position, this.size()))
            org.phenoapps.mstrdtl.Utils.swap(
                this.listInstance, position,position + 1);
    }

    @java.lang.Override public void delete(final int position)
    { org.phenoapps.mstrdtl.Utils.delete(this.listInstance, position); }

    @java.lang.Override public void append(final Item item)
    {
        if (item instanceof TestItem)
        {
            final TestItem testItem =
                (TestItem) item;
            if (testItem.containersAreTheSame(this))
            {
                testItem.setPosition(this.size()); testItem.setTitleAndContent();
                this.list().add(testItem);
            }
        }
    }

    @java.lang.Override public void append()
    { this.append(new TestItem(this)); }

    @java.lang.Override public int size()
    { return null == this.listInstance ? 0 : this.listInstance.size(); }

    @java.lang.Override public Item get(final int position)
    {
        final int nonNegativePosition =
            org.phenoapps.mstrdtl.Utils.nonNegativePosition(position);         // throws
        return null == this.listInstance ? null : this.listInstance.get(nonNegativePosition);
    }

    @java.lang.Override public java.lang.String toJson()
    { return this.gson().toJson(this.listInstance); }

    @java.lang.Override
    public Items fromJson(final java.lang.String json)
    {
        if (null == json)
            return this.clear();
        else
        {
            final java.lang.String trimmedJson = json.trim();
            if (trimmedJson.length() <= 0)
                return this.clear();
            else
            {
                final java.util.List<TestItem> list =
                    this.gson().fromJson(trimmedJson, this.type());
                if (null == list)
                    return this.clear();
                else
                    if (list.size() <= 0)
                        return this.clear();
                    else
                    {
                        for (final TestItem testItem: list)
                            testItem.setContainer(this);
                        this.clear(); this.list().addAll(list); return this;
                    }
            }
        }
    }
    // endregion
}