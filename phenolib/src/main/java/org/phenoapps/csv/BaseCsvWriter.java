package org.phenoapps.csv;

/**
 * Uses:
 * org.phenoapps.csv.CsvWriter
 */
@java.lang.SuppressWarnings({"unused"}) public class BaseCsvWriter extends CsvWriter
{
    // region Constructors
    @java.lang.SuppressWarnings({"WeakerAccess", "unused"})
    public BaseCsvWriter(final java.io.Writer writer)
    { super(/* outputStream => */ writer, /* delimiter => */','); }

    @java.lang.SuppressWarnings({"unused"})
    public BaseCsvWriter(final java.io.File file) throws java.io.IOException
    {
        this(
            /* writer => */ new java.io.FileWriter(file,false) /* throws java.io.IOException */);
    }
    // endregion

    // region Public Methods
    @java.lang.SuppressWarnings({"unused"}) public void write() throws java.io.IOException
    { this.write("") /* throws java.io.IOException */; }

    @java.lang.SuppressWarnings({"unused"})
    public void write(final int content) throws java.io.IOException
    { this.write(java.lang.String.valueOf(content)) /* throws java.io.IOException */; }

    @java.lang.SuppressWarnings({"unused"}) public void write(final java.lang.String format,
    final java.lang.Object... args) throws java.io.IOException
    { this.write(java.lang.String.format(format, args)) /* throws java.io.IOException */; }
    // endregion
}