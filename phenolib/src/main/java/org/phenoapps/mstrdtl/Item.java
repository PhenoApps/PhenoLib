package org.phenoapps.mstrdtl;

@java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Item
{
    interface Container
    {
        boolean canMoveDown(int position);

        @java.lang.SuppressWarnings({"unused"}) void moveUp  (int position);
        @java.lang.SuppressWarnings({"unused"}) void moveDown(int position);
        @java.lang.SuppressWarnings({"unused"}) void delete  (int position);
    }

    // region Constants
    public static final int              MIN_POSITION               = 0;
    public static final java.lang.String TOO_SMALL_POSITION_MESSAGE =
        "position must be non-negative";
    // endregion

    // region Public Methods
    public void setContainer(Item.Container container);

    public int getPosition(); public void setPosition(int position);

    public java.lang.String getPositionAsString();
    public java.lang.String getTitle           ();
    public java.lang.String getContent         ();

    public boolean canMoveUp(); public boolean canMoveDown();
    // endregion
}