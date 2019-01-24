package org.wheatgenetics.brapi1_3.studies;

/**
 * Uses:
 * android.support.annotation.IntRange
 * android.support.annotation.NonNull
 * android.support.annotation.Nullable
 *
 * io.swagger.client.model.StudyLayoutRequest
 * io.swagger.client.model.StudyLayoutRequestLayout
 *
 * org.wheatgenetics.javalib.mstrdtl.Item
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.brapi1_3.studies.StudyLayoutRequestLayout
 */
public class StudyLayoutRequest extends io.swagger.client.model.StudyLayoutRequest
implements org.wheatgenetics.javalib.mstrdtl.Items
{
    // region Overridden Methods
    @java.lang.Override public void add(
    @android.support.annotation.NonNull final org.wheatgenetics.javalib.mstrdtl.Item item)
    { this.addLayoutItem((org.wheatgenetics.brapi1_3.studies.StudyLayoutRequestLayout) item); }

    @java.lang.Override public void append()
    { this.add(new org.wheatgenetics.brapi1_3.studies.StudyLayoutRequestLayout(this.size())); }

    @java.lang.Override public int size()
    {
        final java.util.List<io.swagger.client.model.StudyLayoutRequestLayout> layout =
            this.getLayout();
        return null == layout ? 0 : layout.size();
    }

    @android.support.annotation.Nullable @java.lang.Override
    public org.wheatgenetics.javalib.mstrdtl.Item get(
    @android.support.annotation.IntRange(from = org.wheatgenetics.javalib.mstrdtl.Item.MIN_POSITION)
        final int position)
    {
        final java.util.List<io.swagger.client.model.StudyLayoutRequestLayout> layout =
            this.getLayout();
        return null == layout ? null :
            (org.wheatgenetics.brapi1_3.studies.StudyLayoutRequestLayout) layout.get(position);
    }
    // endregion
}