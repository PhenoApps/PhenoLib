package org.phenoapps.mstrdtl;

/**
 * Uses:
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Item.Container
 */
@java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"})
public interface Items extends Item.Container
{
    // region Overridden Methods
    @java.lang.Override public boolean canMoveDown(int position);

    @java.lang.Override public void moveUp  (int position);
    @java.lang.Override public void moveDown(int position);
    @java.lang.Override public void delete  (int position);
    // endregion

    // region Public Methods
    public void append(Item item); public void append();

    public int                                    size()            ;
    public Item get (int position);

    public java.lang.String toJson();

    public Items fromJson(java.lang.String json);
    // endregion
}