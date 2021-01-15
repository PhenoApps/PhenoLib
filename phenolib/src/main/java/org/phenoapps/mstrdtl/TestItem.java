package org.phenoapps.mstrdtl;

/**
 * Uses:
 * org.wheatgenetics.javalib.Utils
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Utils
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class TestItem extends java.lang.Object implements Item
{
    // region Fields
    private transient TestItem.Container container;

    private int              position           ;
    private java.lang.String title, content = "";
    // endregion

    TestItem(final TestItem.Container container)
    { super(); this.setContainer(container); }

    // region org.wheatgenetics.javalib.mstrdtl.Item Overridden Methods
    @java.lang.Override public void setContainer(
    final TestItem.Container container)
    { this.container = container; }

    @java.lang.Override public int getPosition() { return this.position; }

    @java.lang.Override public void setPosition(final int position)
    { this.position = org.phenoapps.mstrdtl.Utils.nonNegativePosition(position); }

    @java.lang.Override public java.lang.String getPositionAsString()
    { return java.lang.String.valueOf(this.getPosition()); }

    @java.lang.Override public java.lang.String getTitle  () { return this.title  ; }
    @java.lang.Override public java.lang.String getContent() { return this.content; }

    @java.lang.Override public boolean canMoveUp()
    {
        return org.phenoapps.mstrdtl.Utils.canMoveUp(
            this.container, this.getPosition());
    }

    @java.lang.Override public boolean canMoveDown()
    {
        return org.phenoapps.mstrdtl.Utils.canMoveDown(
            this.container, this.getPosition());
    }
    // endregion

    // region Package Methods
    boolean containersAreTheSame(
    final TestItem.Container container)
    { return container == this.container; }

    @java.lang.SuppressWarnings({"DefaultLocale"}) void setTitleAndContent()
    {
        final java.lang.StringBuilder builder;
        {
            final int position = this.getPosition();
            this.title = java.lang.String.format("Item %d",position + 1);

            builder = new java.lang.StringBuilder("Content of ")
                .append(this.getTitle()).append(':');
            for (int i = Item.MIN_POSITION; i <= position; i++)
                builder.append("\nMore information here.");
        }
        this.content = builder.toString();
    }
    // endregion

    public void setContent(final java.lang.String content)
    { this.content = org.phenoapps.androidlibrary.Utils.makeEmptyIfNull(content); }
}