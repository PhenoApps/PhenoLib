package org.phenoapps.androidlibrarybuilder;

/**
 * Uses:
 * android.content.Intent
 * android.os.Bundle
 * android.webkit.WebView
 *
 * androidx.annotation.Nullable
 * androidx.appcompat.app.AppCompatActivity
 *
 * org.wheatgenetics.androidlibrarybuilder.R
 */
public class WebViewActivity extends androidx.appcompat.app.AppCompatActivity
{
    static final java.lang.String CONTENT = "content", ENCODING = "encoding";

    @java.lang.Override protected void onCreate(
    @androidx.annotation.Nullable final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.phenoapps.androidlibrarybuilder.R.layout.activity_web_view);

        final android.content.Intent intent  = this.getIntent();
        final android.webkit.WebView webView =
            this.findViewById(org.phenoapps.androidlibrarybuilder.R.id.webView);
        assert null != webView; webView.loadData(
            /* data => */ intent.getStringExtra(
                org.phenoapps.androidlibrarybuilder.WebViewActivity.CONTENT),
            /* mimeType => */ "text/html",
            /* encoding => */ intent.getStringExtra(
                org.phenoapps.androidlibrarybuilder.WebViewActivity.ENCODING));
    }
}