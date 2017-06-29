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
    interface Handler
    {
        public abstract java.lang.String formattedRead()
            throws org.wheatgenetics.usb.Device.Exception;
        public abstract void publish        (java.lang.String data   );
        public abstract void reportException(java.lang.String message);
    }

    private static class AsyncTask extends android.os.AsyncTask<
    java.lang.Void, java.lang.String, org.wheatgenetics.usb.Device.Exception>
    {
        private final org.wheatgenetics.usb.DeviceReader.Handler handler     ;
        private       java.lang.String                           oldData = "";

        private void reportCancelled()
        {
            assert null != this.handler;
            this.handler.reportException("cancelled");
        }

        private AsyncTask(@android.support.annotation.NonNull
        final org.wheatgenetics.usb.DeviceReader.Handler handler)
        {
            super();

            assert null != handler;
            this.handler = handler;
        }

        @java.lang.Override
        protected org.wheatgenetics.usb.Device.Exception doInBackground(
        final java.lang.Void... params)
        {
            java.lang.String newData;
            assert null != this.handler;
            while (!this.isCancelled())
            {
                try { newData = this.handler.formattedRead(); }
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
            if (null == e)
                this.reportCancelled();
            else
            {
                assert null != this.handler;
                this.handler.reportException(e.getMessage());
            }
        }

        @java.lang.Override
        protected void onCancelled() { this.reportCancelled(); }
    }

    private org.wheatgenetics.usb.DeviceReader.Handler   handler   = null;
    private org.wheatgenetics.usb.DeviceReader.AsyncTask asyncTask = null;

    // region Package Methods
    // region Constructor Package Methods
    DeviceReader() { super(); }

    DeviceReader(@android.support.annotation.NonNull
    final org.wheatgenetics.usb.DeviceReader.Handler handler)
    {
        super();
        this.setHandler(handler);
    }
    // endregion

    void setHandler(@android.support.annotation.NonNull
    final org.wheatgenetics.usb.DeviceReader.Handler handler)
    {
        assert null != handler;
        this.handler = handler;
    }

    void execute()
    {
        if (null == this.asyncTask) if (null != this.handler)
        {
            this.asyncTask = new org.wheatgenetics.usb.DeviceReader.AsyncTask(this.handler);
            this.asyncTask.execute();
        }
    }

    boolean cancel()
    {
        if (null == this.asyncTask)
            return false;
        else
        {
            final boolean result = this.asyncTask.cancel(/* mayInterruptIfRunning => */ true);
            this.asyncTask = null;
            return result;
        }
    }
    // endregion
}