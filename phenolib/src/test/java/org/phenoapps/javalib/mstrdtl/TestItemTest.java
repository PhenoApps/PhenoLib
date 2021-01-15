package org.phenoapps.javalib.mstrdtl;

import org.phenoapps.mstrdtl.TestItem;

/**
 * Uses:
 * org.junit.Assert
 * org.junit.Test
 *
 * org.wheatgenetics.javalib.mstrdtl.TestItem
 * org.wheatgenetics.javalib.mstrdtl.TestItem.Container
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class TestItemTest extends java.lang.Object
{
    private TestItem.Container
        falseContainerInstance = null, trueContainerInstance = null;                   // lazy loads

    // region Private Methods
    private TestItem.Container falseContainer()
    {
        if (null == this.falseContainerInstance) this.falseContainerInstance =
            new TestItem.Container()
            {
                @java.lang.Override public boolean canMoveDown(final int position)
                { return false; }

                @java.lang.Override public void moveUp  (final int position) {}
                @java.lang.Override public void moveDown(final int position) {}
                @java.lang.Override public void delete  (final int position) {}
            };
        return this.falseContainerInstance;
    }

    private TestItem.Container trueContainer()
    {
        if (null == this.trueContainerInstance) this.trueContainerInstance =
            new TestItem.Container()
            {
                @java.lang.Override public boolean canMoveDown(final int position)
                { return true; }

                @java.lang.Override public void moveUp  (final int position) {}
                @java.lang.Override public void moveDown(final int position) {}
                @java.lang.Override public void delete  (final int position) {}
            };
        return this.trueContainerInstance;
    }
    // endregion

    // region org.wheatgenetics.javalib.mstrdtl.Item Overridden Method Tests
    // region setPosition() org.wheatgenetics.javalib.mstrdtl.Item Overridden Method Tests
    @org.junit.Test(expected = java.lang.IndexOutOfBoundsException.class)
    public void tooSmallPositionSetPositionThrows()
    {
        final TestItem testItem =
            new TestItem(null);
        testItem.setPosition(-2);
    }

    @org.junit.Test() public void tooSmallPositionSetPositionHasCorrectMessage()
    {
        final TestItem testItem =
            new TestItem(null);
        try { testItem.setPosition(-5); }
        catch (final java.lang.IndexOutOfBoundsException e)
        {
            org.junit.Assert.assertEquals(
                TestItem.TOO_SMALL_POSITION_MESSAGE,
                e.getMessage()                                                       );
        }
    }

    @org.junit.Test() public void setPositionWorks()
    {
        final TestItem testItem =
            new TestItem(null);
        testItem.setPosition(0);
        org.junit.Assert.assertEquals( 0 , testItem.getPosition        ());
        org.junit.Assert.assertEquals("0", testItem.getPositionAsString());

        testItem.setPosition(2);
        org.junit.Assert.assertEquals( 2 , testItem.getPosition        ());
        org.junit.Assert.assertEquals("2", testItem.getPositionAsString());
    }
    // endregion

    // region canMoveUp() org.wheatgenetics.javalib.mstrdtl.Item Overridden Method Tests
    @org.junit.Test() public void nullContainerCanMoveUpIsFalse()
    {
        org.junit.Assert.assertFalse(
            new TestItem(null).canMoveUp());
    }

    @org.junit.Test() public void zeroPositionCanMoveUpIsFalse()
    {
        final TestItem testItem =
            new TestItem(this.trueContainer());
        testItem.setPosition(0); org.junit.Assert.assertFalse(testItem.canMoveUp());
    }

    @org.junit.Test() public void nonZeroPositionCanMoveUpIsTrue()
    {
        final TestItem testItem =
            new TestItem(this.trueContainer());
        testItem.setPosition(55); org.junit.Assert.assertTrue(testItem.canMoveUp());
    }
    // endregion

    // region canMoveDown() org.wheatgenetics.javalib.mstrdtl.Item Overridden Method Tests
    @org.junit.Test() public void nullContainerCanMoveDownIsFalse()
    {
        org.junit.Assert.assertFalse(
            new TestItem(null).canMoveDown());
    }

    @org.junit.Test() public void falseContainerCanMoveDownIsFalse()
    {
        final TestItem testItem =
            new TestItem(this.falseContainer());
        org.junit.Assert.assertFalse(testItem.canMoveDown());
    }

    @org.junit.Test() public void trueContainerCanMoveDownIsTrue()
    {
        final TestItem testItem =
            new TestItem(this.trueContainer());
        org.junit.Assert.assertTrue(testItem.canMoveDown());
    }
    // endregion
    // endregion

    // region Package Method Tests
    // region containersAreTheSame() Package Method Tests
    @org.junit.Test() public void nullContainersAreTheSame()
    {
        final TestItem testItem =
            new TestItem(null);
        org.junit.Assert.assertFalse(testItem.containersAreTheSame(this.falseContainer()));
        org.junit.Assert.assertFalse(testItem.containersAreTheSame(this.trueContainer ()));
        org.junit.Assert.assertTrue (testItem.containersAreTheSame(null                 ));
    }

    @org.junit.Test() public void nonNullContainersAreTheSame()
    {
        final TestItem testItem =
            new TestItem(this.falseContainer());
        org.junit.Assert.assertTrue (testItem.containersAreTheSame(this.falseContainer()));
        org.junit.Assert.assertFalse(testItem.containersAreTheSame(this.trueContainer ()));
        org.junit.Assert.assertFalse(testItem.containersAreTheSame(null                 ));
    }
    // endregion

    @org.junit.Test() public void setTitleAndContentWorks()
    {
        final TestItem testItem =
            new TestItem(null);
        testItem.setPosition(0); testItem.setTitleAndContent();
        org.junit.Assert.assertEquals("Item 1", testItem.getTitle());
        org.junit.Assert.assertEquals("Content of Item 1:\nMore information here.",
            testItem.getContent());

        testItem.setPosition(2); testItem.setTitleAndContent();
        org.junit.Assert.assertEquals("Item 3", testItem.getTitle());
        org.junit.Assert.assertEquals("Content of Item 3:" +
                "\nMore information here.\nMore information here.\nMore information here.",
            testItem.getContent());
    }
    // endregion

    // region setContent() Tests
    @org.junit.Test() public void nullSetContentWorks()
    {
        final TestItem testItem =
            new TestItem(null);
                                   org.junit.Assert.assertNotNull(testItem.getContent());
        testItem.setContent(null); org.junit.Assert.assertNotNull(testItem.getContent());
    }

    @org.junit.Test() public void setContentWorks()
    {
        final java.lang.String                           testContent = "testContent";
        final TestItem testItem    =
            new TestItem(null);
        testItem.setContent(testContent);
        org.junit.Assert.assertEquals(testContent, testItem.getContent());
    }
    // endregion
}