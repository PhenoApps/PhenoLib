package org.wheatgenetics.brapi1_3.studies;

/**
 * Uses:
 * android.support.annotation.IntRange
 *
 * io.swagger.client.model.StudyLayoutRequestLayout
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 */
public class StudyLayoutRequestLayout extends io.swagger.client.model.StudyLayoutRequestLayout
implements org.wheatgenetics.javalib.mstrdtl.Item
{
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
    private final int position;

    public StudyLayoutRequestLayout(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position) { super(); this.position = position; }

    // region Overridden Methods
    @java.lang.Override public java.lang.String getTitle()
    { return java.lang.Integer.toString(this.getBlockNumber()); }

    @java.lang.Override public java.lang.String getContent() { return this.toString(); }

    @java.lang.Override public java.lang.String getPositionAsString()
    { return java.lang.String.valueOf(this.getPosition()); }
    // endregion

    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
    int getPosition() { return this.position; }
}