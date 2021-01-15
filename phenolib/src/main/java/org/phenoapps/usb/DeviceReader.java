package org.phenoapps.usb;

/**
 * Uses:
 * android.os.AsyncTask
 * android.os.SystemClock
 *
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
class DeviceReader extends java.lang.Object
{
    // region Types
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Handler
    {
        public abstract void publish        (java.lang.String                       data);
        public abstract void reportException(org.phenoapps.usb.Device.Exception e   );
    }

    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) interface DataSource
    {
        public abstract java.lang.String formattedRead()
            throws org.phenoapps.usb.Device.Exception;
    }

    private static class Cancelled extends org.phenoapps.usb.Device.Exception
    { private Cancelled() { super("Cancelled."); } }

    private static class AsyncTask extends android.os.AsyncTask<
    java.lang.Void, java.lang.String, org.phenoapps.usb.Device.Exception>
    {
        // region Fields
        @androidx.annotation.NonNull
        private final org.phenoapps.usb.DeviceReader.Handler handler;

        @androidx.annotation.NonNull
        private final org.phenoapps.usb.DeviceReader.DataSource dataSource;

        private java.lang.String oldData = "";
        // endregion

        private AsyncTask(
        @androidx.annotation.NonNull final org.phenoapps.usb.DeviceReader.Handler    handler   ,
        @androidx.annotation.NonNull final org.phenoapps.usb.DeviceReader.DataSource dataSource)
        { super(); this.handler = handler; this.dataSource = dataSource; }

        // region Overridden Methods
        @java.lang.Override protected org.phenoapps.usb.Device.Exception doInBackground(
        final java.lang.Void... params)
        {
            while (!this.isCancelled())
            {
                {
                    final java.lang.String newData;
                    try { newData = this.dataSource.formattedRead(); }
                    catch (final org.phenoapps.usb.Device.Exception e) { return e; }
                    if (!this.oldData.equals(newData)) this.publishProgress(newData);
                }
                android.os.SystemClock.sleep(/* ms => */500);
            }
            return null;
        }

        @java.lang.Override protected void onProgressUpdate(final java.lang.String... values)
        {
            if (null != values)
            {
                final java.lang.String newData = values[0];
                this.handler.publish(newData);
                this.oldData = newData;
            }
        }

        @java.lang.Override
        protected void onPostExecute(final org.phenoapps.usb.Device.Exception e)
        { if (null != e) this.handler.reportException(e); }

        @java.lang.Override protected void onCancelled()
        { this.handler.reportException(new org.phenoapps.usb.DeviceReader.Cancelled()); }
        // endregion
    }
    // endregion

    // region Fields
    @androidx.annotation.NonNull private final org.phenoapps.usb.DeviceReader.Handler handler;

    private org.phenoapps.usb.DeviceReader.DataSource dataSource = null;
    private org.phenoapps.usb.DeviceReader.AsyncTask  asyncTask  = null;
    // endregion

    // region Constructors
    DeviceReader(@androidx.annotation.NonNull
    final org.phenoapps.usb.DeviceReader.Handler handler) { super(); this.handler = handler; }

    DeviceReader(
    @androidx.annotation.NonNull org.phenoapps.usb.DeviceReader.Handler    handler   ,
    @androidx.annotation.NonNull org.phenoapps.usb.DeviceReader.DataSource dataSource)
    { this(handler); this.setDataSource(dataSource); }
    // endregion

    void setDataSource(
    @androidx.annotation.NonNull final org.phenoapps.usb.DeviceReader.DataSource dataSource)
    { this.dataSource = dataSource; }

    // region Public Methods
    public void execute()
    {
        if (null == this.asyncTask && null != this.dataSource)
        {
            this.asyncTask = new org.phenoapps.usb.DeviceReader.AsyncTask(
                this.handler, this.dataSource);
            this.asyncTask.execute();
        }
    }

    public boolean cancel()
    {
        final boolean cancelled;

        if (null == this.asyncTask)
            cancelled = false;
        else
        {
            cancelled = this.asyncTask.cancel(
                /* mayInterruptIfRunning => */true);
            this.asyncTask = null;
        }

        return cancelled;
    }
    // endregion
}