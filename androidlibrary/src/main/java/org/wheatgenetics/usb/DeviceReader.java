package org.wheatgenetics.usb;

/**
 * Uses:
 * android.os.AsyncTask
 * android.os.SystemClock
 * android.support.annotation.NonNull
 *
 * org.wheatgenetics.usb.Device.Exception
 */

class DeviceReader extends java.lang.Object
{
    // region Types
    public interface Handler
    {
        public abstract void publish        (java.lang.String                       data);
        public abstract void reportException(org.wheatgenetics.usb.Device.Exception e   );
    }

    interface DataSource
    {
        public abstract java.lang.String formattedRead()
            throws org.wheatgenetics.usb.Device.Exception;
    }

    static class Cancelled extends org.wheatgenetics.usb.Device.Exception
    { Cancelled() { super("Cancelled."); }}

    private static class AsyncTask extends android.os.AsyncTask<
    java.lang.Void, java.lang.String, org.wheatgenetics.usb.Device.Exception>
    {
        private final org.wheatgenetics.usb.DeviceReader.Handler    handler   ;
        private final org.wheatgenetics.usb.DeviceReader.DataSource dataSource;

        private java.lang.String oldData = "";

        private AsyncTask(@android.support.annotation.NonNull
            final org.wheatgenetics.usb.DeviceReader.Handler handler,
        @android.support.annotation.NonNull
            final org.wheatgenetics.usb.DeviceReader.DataSource dataSource)
        {
            super();

            assert null != handler;
            this.handler = handler;

            assert null != dataSource;
            this.dataSource = dataSource;
        }

        @java.lang.Override
        protected org.wheatgenetics.usb.Device.Exception doInBackground(
        final java.lang.Void... params)
        {
            java.lang.String newData;
            assert null != this.dataSource;
            while (!this.isCancelled())
            {
                try { newData = this.dataSource.formattedRead(); }
                catch (final org.wheatgenetics.usb.Device.Exception e) { return e; }
                if (!this.oldData.equals(newData)) this.publishProgress(newData);
                android.os.SystemClock.sleep(/* ms => */ 500);
            }
            return null;
        }

        @java.lang.Override
        protected void onProgressUpdate(final java.lang.String... values)
        {
            final java.lang.String newData = values[0];
            assert null != this.handler;
            this.handler.publish(newData);
            this.oldData = newData;
        }

        @java.lang.Override
        protected void onPostExecute(final org.wheatgenetics.usb.Device.Exception e)
        {
            if (null != e)
            {
                assert null != this.handler;
                this.handler.reportException(e);
            }
        }

        @java.lang.Override
        protected void onCancelled()
        {
            assert null != this.handler;
            this.handler.reportException(new org.wheatgenetics.usb.DeviceReader.Cancelled());
        }
    }
    // endregion

    private org.wheatgenetics.usb.DeviceReader.Handler    handler    = null;
    private org.wheatgenetics.usb.DeviceReader.DataSource dataSource = null;
    private org.wheatgenetics.usb.DeviceReader.AsyncTask  asyncTask  = null;

    // region Package Methods
    // region Constructor Package Methods
    DeviceReader(
    @android.support.annotation.NonNull org.wheatgenetics.usb.DeviceReader.Handler handler      ,
    @android.support.annotation.NonNull org.wheatgenetics.usb.DeviceReader.DataSource dataSource)
    {
        super();

        assert null != handler;
        this.handler = handler;

        this.setDataSource(dataSource);
    }

    DeviceReader(@android.support.annotation.NonNull
    final org.wheatgenetics.usb.DeviceReader.Handler handler)
    {
        super();

        assert null != handler;
        this.handler = handler;
    }
    // endregion

    void setDataSource(@android.support.annotation.NonNull
    final org.wheatgenetics.usb.DeviceReader.DataSource dataSource)
    {
        assert null != dataSource;
        this.dataSource = dataSource;
    }
    // endregion

    // region Public Methods
    public void execute()
    {
        if (null == this.asyncTask) if (null != this.handler && null != this.dataSource)
        {
            this.asyncTask = new org.wheatgenetics.usb.DeviceReader.AsyncTask(
                this.handler, this.dataSource);
            this.asyncTask.execute();
        }
    }

    public boolean cancel()
    {
        boolean cancelled;

        if (null == this.asyncTask)
            cancelled = false;
        else
        {
            cancelled = this.asyncTask.cancel(/* mayInterruptIfRunning => */ true);
            this.asyncTask = null;
        }

        return cancelled;
    }
    // endregion
}