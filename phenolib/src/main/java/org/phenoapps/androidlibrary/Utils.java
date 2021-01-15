package org.phenoapps.androidlibrary;

/**
 * Uses:
 * android.content.Context
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 * android.content.Intent
 * android.media.MediaScannerConnection
 * android.net.Uri
 * android.text.format.DateFormat
 * android.widget.EditText
 * android.widget.TextView
 * android.widget.Toast
 *
 * org.wheatgenetics.javalib.Utils
 *
 * org.wheatgenetics.androidlibrary.R
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class Utils extends java.lang.Object
{
    private static android.content.DialogInterface.OnClickListener
        dismissingOnClickListenerInstance = null, cancellingOnClickListenerInstance = null;

    // region OnClickListener Methods
    public static android.content.DialogInterface.OnClickListener dismissingOnClickListener()
    {
        if (null == org.phenoapps.androidlibrary.Utils.dismissingOnClickListenerInstance)
            org.phenoapps.androidlibrary.Utils.dismissingOnClickListenerInstance =
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override public void onClick(
                    final android.content.DialogInterface dialog, final int which)
                    { if (null != dialog) dialog.dismiss(); }
                };
        return org.phenoapps.androidlibrary.Utils.dismissingOnClickListenerInstance;
    }

    @java.lang.SuppressWarnings({"WeakerAccess"})
    public static android.content.DialogInterface.OnClickListener cancellingOnClickListener()
    {
        if (null == org.phenoapps.androidlibrary.Utils.cancellingOnClickListenerInstance)
            org.phenoapps.androidlibrary.Utils.cancellingOnClickListenerInstance =
                new android.content.DialogInterface.OnClickListener()
                {
                    @java.lang.Override public void onClick(
                    final android.content.DialogInterface dialog, final int which)
                    { if (null != dialog) dialog.cancel(); }
                };
        return org.phenoapps.androidlibrary.Utils.cancellingOnClickListenerInstance;
    }
    // endregion

    // region Toast Methods
    private static void showToast(final android.content.Context context,
    final java.lang.CharSequence text, final int duration)
    { android.widget.Toast.makeText(context, text, duration).show(); }

    public static void showLongToast(final android.content.Context context,
    final java.lang.CharSequence text)
    {
        org.phenoapps.androidlibrary.Utils.showToast(
            context, text, android.widget.Toast.LENGTH_LONG);
    }

    public static void showShortToast(final android.content.Context context,
    final java.lang.CharSequence text)
    {
        org.phenoapps.androidlibrary.Utils.showToast(
            context, text, android.widget.Toast.LENGTH_SHORT);
    }
    // endregion

    // region File Methods
    @java.lang.SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
    public static java.io.File makeFileDiscoverable(final android.content.Context context,
    final java.io.File file)
    {
        if (null != file)
        {
            android.media.MediaScannerConnection.scanFile(
                /* context   => */ context                                                    ,
                /* paths     => */ org.phenoapps.androidlibrary.Utils.stringArray(file.getPath()),
                /* mimeTypes => */null,
                /* callback  => */null);
            if (null != context) context.sendBroadcast(new android.content.Intent(
                /* action => */ android.content.Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                /* uri    => */ android.net.Uri.fromFile(file)                       ));
        }
        return file;
    }

    @java.lang.SuppressWarnings({"unused"}) public static void shareFile(
    final android.content.Context context, final android.net.Uri uri)
    {
        final android.content.Intent intent = new android.content.Intent(
            android.content.Intent.ACTION_SEND).setType("text/plain").putExtra(
                android.content.Intent.EXTRA_STREAM, uri);

        if (null != context) context.startActivity(android.content.Intent.createChooser(
            intent, context.getString(org.phenoapps.androidlibrary.R.string.sendingFile)));
    }
    // endregion

    // region getText() Methods
    @java.lang.SuppressWarnings({"unused"})
    public static java.lang.String getText(final android.widget.TextView textView)
    {
        return null == textView ? null :
            org.phenoapps.androidlibrary.Utils.adjust(textView.getText().toString());
    }

    public static java.lang.String getText(final android.widget.EditText editText)
    {
        return null == editText ? null :
            org.phenoapps.androidlibrary.Utils.adjust(editText.getText().toString());
    }
    // endregion

    @java.lang.SuppressWarnings({"unused"})
    public static java.lang.CharSequence formatDate(final long date)
    {
        return android.text.format.DateFormat.format(
            "yyyy-MM-dd", new java.util.Date(date));
    }

    private static java.text.SimpleDateFormat SIMPLE_DATE_FORMAT = null;

    public static class Response extends java.lang.Object
    {
        private final java.lang.String contentTypeInstance,
                contentEncodingInstance, contentInstance;

        private Response(final java.lang.String contentType,
                         final java.lang.String contentEncoding, final java.lang.String content)
        {
            super();

            this.contentTypeInstance     = contentType    ;
            this.contentEncodingInstance = contentEncoding;
            this.contentInstance         = content        ;
        }

        public java.lang.String contentType    () { return this.contentTypeInstance    ; }
        public java.lang.String contentEncoding() { return this.contentEncodingInstance; }
        public java.lang.String content        () { return this.contentInstance        ; }
    }

    // region IfNull Methods
    @java.lang.SuppressWarnings({"WeakerAccess"}) public static java.lang.String replaceIfNull(
            final java.lang.String s, final java.lang.String valueIfNull)
    { return null == s ? valueIfNull : s; }

    public static java.lang.String makeEmptyIfNull(final java.lang.String s)
    { return org.phenoapps.androidlibrary.Utils.replaceIfNull(s,""); }

    public static java.lang.String adjust(final java.lang.String unadjusted)
    { return org.phenoapps.androidlibrary.Utils.makeEmptyIfNull(unadjusted).trim(); }
    // endregion

    // region convert() Methods
    /** See <a href="https://stackoverflow.com/questions/4266756/can-we-make-unsigned-byte-in-java">https://stackoverflow.com/questions/4266756/can-we-make-unsigned-byte-in-java</a>. */
    @java.lang.SuppressWarnings({"WeakerAccess"})
    public static int interpretAsUnsigned(final byte signedByte) { return signedByte & 0x000000FF; }

    @java.lang.SuppressWarnings({"unused"}) public static java.lang.String convert(
            @java.lang.SuppressWarnings({"CStyleArrayDeclaration"}) final byte buffer[], int length)
    {
        if (null == buffer)
            return null;
        else
        {
            length = java.lang.Math.max(0     , length       );          // Handle too small length.
            length = java.lang.Math.min(length, buffer.length);          // Handle too big   length.

            final java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
            {
                final int first = 0, last = length - 1;
                for (int i = first; i <= last; i++)
                {
                    final java.lang.String s = java.lang.Integer.toString(
                            org.phenoapps.androidlibrary.Utils.interpretAsUnsigned(buffer[i]));
                    if (i >= 1) stringBuilder.append(","); stringBuilder.append(s);
                }
            }
            return stringBuilder.toString();
        }
    }

    @java.lang.SuppressWarnings({"unused"}) public static int convert(final java.lang.String s)
    {
        try                                             { return java.lang.Integer.parseInt(s); }
        catch (final java.lang.NumberFormatException e) { return                            -1; }
    }
    // endregion

    // region stringArray() Methods
    @java.lang.SuppressWarnings({"WeakerAccess"})
    public static java.lang.String[] stringArray(final java.lang.String element)
    { return new java.lang.String[] {element}; }

    @java.lang.SuppressWarnings({"unused"})
    public static java.lang.String[] stringArray(final int element)
    { return org.phenoapps.androidlibrary.Utils.stringArray(java.lang.String.valueOf(element)); }

    @java.lang.SuppressWarnings({"unused"})
    public static java.lang.String[] stringArray(final long element)
    { return org.phenoapps.androidlibrary.Utils.stringArray(java.lang.String.valueOf(element)); }
    // endregion

    @java.lang.SuppressWarnings({"unused"}) public static java.lang.String getDateTime()
    {
        if (null == org.phenoapps.androidlibrary.Utils.SIMPLE_DATE_FORMAT)
            org.phenoapps.androidlibrary.Utils.SIMPLE_DATE_FORMAT = new java.text.SimpleDateFormat(
                    "yyyy-MM-dd-hh-mm-ss", java.util.Locale.getDefault());
        return org.phenoapps.androidlibrary.Utils.SIMPLE_DATE_FORMAT.format(
                java.util.Calendar.getInstance().getTime());
    }

    // region get() Methods
    private static java.net.HttpURLConnection makeHttpURLConnection(final java.net.URL url)
            throws java.io.IOException
    {
        if (null == url)
            return null;
        else
            return (java.net.HttpURLConnection) url.openConnection();  // throws java.io.IOException
    }

    private static org.phenoapps.androidlibrary.Utils.Response get(
            final java.net.HttpURLConnection httpURLConnection) throws java.io.IOException
    {
        try { httpURLConnection.connect() /* throws java.io.IOException */; }
        catch (final java.net.SocketTimeoutException e)
        {
            return new org.phenoapps.androidlibrary.Utils.Response(
                    null,null,"timeout");
        }

        final int responseCode = httpURLConnection.getResponseCode();  // throws java.io.IOException
        if (responseCode != java.net.HttpURLConnection.HTTP_OK)
            throw new java.io.IOException(java.lang.String.format("Response code is %d, not %d",
                    responseCode, java.net.HttpURLConnection.HTTP_OK));
        else
        {
            final java.io.InputStream inputStream = httpURLConnection.getInputStream(); // throws
            if (null == inputStream)                                                    //  java.io-
                return null;                                                            //  .IOEx-
            else                                                                        //  ception
                try
                {
                    final java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                    {
                        class InputStreamReader extends java.lang.Object
                        {
                            private final java.io.InputStreamReader inputStreamReader;

                            private InputStreamReader(final java.io.InputStream inputStream)
                            {
                                super();
                                this.inputStreamReader = new java.io.InputStreamReader(inputStream);
                            }

                            private java.lang.String read()
                            {
                                final int length = 1024;

                                @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
                                final char cbuf[] = new char[length];
                                try
                                {
                                    final int numberOfCharactersRead =
                                            this.inputStreamReader.read(cbuf,0, length);// throws ja-
                                    if (-1 == numberOfCharactersRead)                  //  va.io.IO-
                                        return null;                                   //  Exception
                                    else
                                        return new java.lang.String(
                                                cbuf,0, numberOfCharactersRead);
                                }
                                catch (final java.io.IOException e) { return null; }
                            }
                        }
                        final InputStreamReader inputStreamReader =
                                new InputStreamReader(inputStream);
                        java.lang.String chunk;
                        while (null != (chunk = inputStreamReader.read()))
                            stringBuilder.append(chunk);
                    }
                    return new org.phenoapps.androidlibrary.Utils.Response(
                            httpURLConnection.getContentType    (),
                            httpURLConnection.getContentEncoding(),
                            stringBuilder.toString              ());
                }
                finally { inputStream.close() /* throws java.io.IOException */; }
        }
    }

    @java.lang.SuppressWarnings({"WeakerAccess", "RedundantSuppression"})
    public static org.phenoapps.androidlibrary.Utils.Response get(final java.net.URL url)
            throws java.io.IOException
    {
        final java.net.HttpURLConnection httpURLConnection =
                org.phenoapps.androidlibrary.Utils.makeHttpURLConnection(url);
        return null == httpURLConnection ? null :
                org.phenoapps.androidlibrary.Utils.get(httpURLConnection);
    }

    @java.lang.SuppressWarnings({"WeakerAccess", "RedundantSuppression"})
    public static org.phenoapps.androidlibrary.Utils.Response get(
            final java.net.URL url, final int timeout) throws java.io.IOException
    {
        final java.net.HttpURLConnection httpURLConnection =
                org.phenoapps.androidlibrary.Utils.makeHttpURLConnection(url);
        if (null == httpURLConnection)
            return null;
        else
        {
            httpURLConnection.setConnectTimeout(timeout);
            return org.phenoapps.androidlibrary.Utils.get(httpURLConnection);
        }
    }

    // region threadedGet() Methods
    private abstract static class BaseThread extends java.lang.Thread
    {
        // region Fields
        private final java.net.URL                             url            ;
        private       org.phenoapps.androidlibrary.Utils.Response response = null;
        // endregion

        // region Package Methods
        java.net.URL getUrl() { return this.url; }

        void setResponse(final org.phenoapps.androidlibrary.Utils.Response response)
        { this.response = response; }
        // endregion

        private BaseThread(final java.net.URL url) { super(); this.url = url; }

        org.phenoapps.androidlibrary.Utils.Response getResponse() { return this.response; }
    }

    private static class DefaultTimeoutThread extends org.phenoapps.androidlibrary.Utils.BaseThread
    {
        DefaultTimeoutThread(final java.net.URL url) { super(url); }

        @java.lang.Override public void run()
        {
            try
            { this.setResponse(org.phenoapps.androidlibrary.Utils.get(this.getUrl()) /* throws */); }
            catch (final java.io.IOException e) { this.setResponse(null); }
        }
    }

    private static class CustomTimeoutThread extends org.phenoapps.androidlibrary.Utils.BaseThread
    {
        final int timeout;

        CustomTimeoutThread(final java.net.URL url, final int timeout)
        { super(url); this.timeout = timeout; }

        @java.lang.Override public void run()
        {
            try
            {
                this.setResponse(org.phenoapps.androidlibrary.Utils.get(
                        this.getUrl(), this.timeout) /* throws */);
            }
            catch (final java.io.IOException e) { this.setResponse(null); }
        }
    }

    private static org.phenoapps.androidlibrary.Utils.Response threadedGet(
            final org.phenoapps.androidlibrary.Utils.BaseThread thread)
    {
        if (null == thread)
            return null;
        else
        {
            thread.start();
            try { thread.join(); } catch (final java.lang.InterruptedException e) { return null; }

            return thread.getResponse();
        }
    }

    @java.lang.SuppressWarnings({"unused"})
    public static org.phenoapps.androidlibrary.Utils.Response threadedGet(final java.net.URL url)
    {
        return org.phenoapps.androidlibrary.Utils.threadedGet(
                new org.phenoapps.androidlibrary.Utils.DefaultTimeoutThread(url));
    }

    public static org.phenoapps.androidlibrary.Utils.Response threadedGet(
            final java.net.URL url, final int timeout)
    {
        return org.phenoapps.androidlibrary.Utils.threadedGet(
                new org.phenoapps.androidlibrary.Utils.CustomTimeoutThread(url, timeout));
    }
    // endregion
    // endregion
}