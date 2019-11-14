package org.wheatgenetics.androidlibrarybuilder;

/**
 * Uses:
 * android.content.Intent
 * android.os.Bundle
 * android.webkit.WebView
 *
 * androidx.appcompat.app.AppCompatActivity
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 */
public class WebViewActivity extends androidx.appcompat.app.AppCompatActivity
{
    static final java.lang.String CONTENT = "content", ENCODING = "encoding";

    @java.lang.Override protected void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.wheatgenetics.androidlibrarybuilder.R.layout.activity_web_view);

        final android.content.Intent intent  = this.getIntent();
        final android.webkit.WebView webView =
            this.findViewById(org.wheatgenetics.androidlibrarybuilder.R.id.webView);
        assert null != webView; webView.loadData(
            /* data => */ intent.getStringExtra(
                org.wheatgenetics.androidlibrarybuilder.WebViewActivity.CONTENT),
            /* mimeType => */ "text/html",
            /* encoding => */ intent.getStringExtra(
                org.wheatgenetics.androidlibrarybuilder.WebViewActivity.ENCODING));
    }
}