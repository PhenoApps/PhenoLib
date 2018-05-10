package org.wheatgenetics.zxing;

/**
 * Uses:
 * android.app.Activity
 * android.app.AlertDialog
 * android.content.Intent
 *
 * com.google.zxing.integration.android.IntentIntegrator
 * com.google.zxing.integration.android.IntentResult
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public class BarcodeScanner extends java.lang.Object
{
    private final android.app.Activity                                  activity               ;
    private       com.google.zxing.integration.android.IntentIntegrator intentIntegrator = null;

    public BarcodeScanner(final android.app.Activity activity)
    { super(); this.activity = activity; }

    public android.app.AlertDialog scan()
    {
        if (null == this.intentIntegrator) this.intentIntegrator =
            new com.google.zxing.integration.android.IntentIntegrator(this.activity);
        return this.intentIntegrator.initiateScan();
    }

    public static java.lang.String parseActivityResult(final int requestCode,
    final int resultCode, final android.content.Intent data)
    {
        final com.google.zxing.integration.android.IntentResult intentResult =
            com.google.zxing.integration.android.IntentIntegrator.parseActivityResult(
                requestCode, resultCode, data);
        return null == intentResult ? null : intentResult.getContents();
    }
}
