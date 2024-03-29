package org.phenoapps.androidlibrarybuilder;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;

import org.phenoapps.mstrdtl.Consts;
import org.phenoapps.mstrdtl.TestItems;
import org.phenoapps.mstrdtl.Utils;
import org.phenoapps.permissions.Dir;
import org.phenoapps.permissions.PermissionDir;
import org.phenoapps.permissions.RequestDir;

import org.phenoapps.activities.PreferencesActivity;

/**
 * Uses:
 * android.app.Activity
 * android.content.Intent
 * android.content.pm.PackageInfo
 * android.content.pm.PackageManager
 * android.content.pm.PackageManager.NameNotFoundException
 * android.Manifest.permission
 * android.os.Bundle
 * android.util.Log
 * android.view.Menu
 * android.view.MenuInflater
 * android.view.MenuItem
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.Button
 * android.widget.EditText
 * android.widget.TextView
 *
 * androidx.annotation.IntRange
 * androidx.annotation.NonNull
 * androidx.annotation.Nullable
 * androidx.appcompat.app.AppCompatActivity
 *
 * org.wheatgenetics.javalib.Dir
 * org.wheatgenetics.javalib.Dir.PermissionException
 * org.wheatgenetics.javalib.Utils
 * org.wheatgenetics.javalib.Utils.Response
 * org.wheatgenetics.javalib.mstrdtl.TestItems
 *
 * org.wheatgenetics.about.AboutAlertDialog
 * org.wheatgenetics.about.OtherApps.Index
 * org.wheatgenetics.about.OtherAppsAlertDialog
 * org.wheatgenetics.androidlibrary.DebouncingEditorActionListener
 * org.wheatgenetics.androidlibrary.DebouncingEditorActionListener.Receiver
 * org.wheatgenetics.androidlibrary.PermissionDir
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.RequestDir
 * org.wheatgenetics.androidlibrary.Utils
 * org.wheatgenetics.androidlibrary.mstrdtl.Consts
 * org.wheatgenetics.androidlibrary.mstrdtl.Utils
 * org.wheatgenetics.changelog.ChangeLogAlertDialog
 * org.wheatgenetics.usb.DeviceListTester
 * org.wheatgenetics.usb.DeviceReaderTester
 * org.wheatgenetics.usb.DeviceReaderTester.Publisher
 * org.wheatgenetics.usb.ExtraDeviceTester
 * org.wheatgenetics.usb.ScaleReaderTester
 * org.wheatgenetics.usb.ScaleReaderTester.Publisher
 * org.wheatgenetics.usb.ScaleTester
 * org.wheatgenetics.zxing.BarcodeScanner
 *
 * org.wheatgenetics.androidlibrarybuilder.brapi1_3.Activity
 *
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ChangeableListActivity
 * org.wheatgenetics.androidlibrarybuilder.mstrdtl.ListActivity
 *
 * org.wheatgenetics.androidlibrarybuilder.BuildConfig
 * org.wheatgenetics.androidlibrarybuilder.R
 * org.wheatgenetics.androidlibrarybuilder.WebViewActivity
 */
public class MainActivity extends androidx.appcompat.app.AppCompatActivity
implements org.phenoapps.androidlibrary.DebouncingEditorActionListener.Receiver
{
    // region Constants
    private static final int MIN_BUTTON_STATE = 0,
        PERMISSIONS_REQUEST_CODE = 1, ACTIVITY_REQUEST_CODE = 2;
    private static final java.lang.String TEXT_VIEW_TEXT_KEY = "textViewText",
        BUTTON_STATES_KEY = "buttonStates", EDIT_TEXT_TEXT_KEY = "editTextText";
    // endregion

    // region Fields
    private android.widget.TextView textView = null;
    private android.widget.Button   button = null, otherAppsButton = null,
        deviceListButton = null, scaleButton = null, scaleReaderButton = null;
    private android.widget.EditText editText = null;

    private PermissionDir permissionDir        = null;
    private RequestDir requestDir           = null;
    private org.phenoapps.usb.DeviceListTester           deviceListTester     = null;
    private org.phenoapps.usb.ExtraDeviceTester          extraDeviceTester    = null;
    private org.phenoapps.usb.ScaleTester                scaleTester          = null;
    private org.phenoapps.usb.DeviceReaderTester         deviceReaderTester   = null;
    private org.phenoapps.usb.ScaleReaderTester          scaleReaderTester    = null;

    @androidx.annotation.IntRange(
    from = org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE) private int
        buttonState = org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE,
        otherAppsButtonState =
            org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE,
        deviceListButtonState =
            org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE,
        scaleButtonState = org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE,
        scaleReaderButtonState =
            org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE;

    private TestItems testItemsInstance = null;
    private android.content.Intent                      webIntentInstance = null,
        listIntentInstance = null, changeableListIntentInstance = null,
        brAPI1_3IntentInstance = null;
    // endregion

    // region Private Methods
    private static void log(@androidx.annotation.NonNull final java.lang.String msg)
    { android.util.Log.d("MainActivity", msg); }

    // region Button Private Methods
    private static void setButtonText(final android.widget.Button button,
    final java.lang.CharSequence text) { if (null != button) button.setText(text); }


    private void setButtonText(final java.lang.CharSequence text)
    { org.phenoapps.androidlibrarybuilder.MainActivity.setButtonText(this.button, text); }

    private void setOtherAppsButtonText(final java.lang.CharSequence text)
    {
        org.phenoapps.androidlibrarybuilder.MainActivity.setButtonText(
            this.otherAppsButton, text);
    }

    private void setDeviceListButtonText(final java.lang.CharSequence text)
    {
        org.phenoapps.androidlibrarybuilder.MainActivity.setButtonText(
            this.deviceListButton, text);
    }

    private void setScaleButtonText(final java.lang.CharSequence text)
    { org.phenoapps.androidlibrarybuilder.MainActivity.setButtonText(this.scaleButton, text); }

    private void setScaleReaderButtonText(final java.lang.CharSequence text)
    {
        org.phenoapps.androidlibrarybuilder.MainActivity.setButtonText(
            this.scaleReaderButton, text);
    }


    private void resetButtonText          () { this.setButtonText          ("Short Toast"      ); }
    private void resetOtherAppsButtonText () { this.setOtherAppsButtonText ("Other Apps"       ); }
    private void resetDeviceListButtonText() { this.setDeviceListButtonText("DeviceList.size()"); }

    private void resetScaleButtonText() { this.setScaleButtonText("ExtraDevice.information()"); }

    private void resetScaleReaderButtonText()
    { this.setScaleReaderButtonText("DeviceReader.execute()"); }
    // endregion

    // region textView Private Methods
    private void setTextViewText(final java.lang.CharSequence text)
    { if (null != this.textView) this.textView.setText(text); }

    private void setAndInvalidateTextViewText(final java.lang.CharSequence text)
    { this.setTextViewText(text); if (null != this.textView) this.textView.invalidate(); }
    // endregion

    private void listAll(final Dir dir)
    {
        if (null != dir)
        {
            java.lang.String text;

            try
            {
                dir.createIfMissing();                    // throws IOException, PermissionException
                // noinspection CStyleArrayDeclaration
                final java.lang.String lines[] = dir.list();           // throws PermissionException

                if (null == lines)
                    text = "null";
                else
                    if (lines.length < 1)
                        text = "null";
                    else
                    {
                        final java.lang.StringBuilder stringBuilder;
                        {
                            final int first = 0;
                            stringBuilder = new java.lang.StringBuilder(lines[first]);
                        }
                        {
                            final int second = 1, last = lines.length - 1;
                            for (int i = second; i <= last; i++)
                                stringBuilder.append(',').append(lines[i]);
                        }
                        text = stringBuilder.toString();
                    }
            }
            catch (final java.io.IOException | Dir.PermissionException e)
            { text = e.getMessage(); }

            this.setTextViewText(text);
        }
    }

    // region Intent Private Methods
    private android.content.Intent webIntent(
    final java.lang.String content, final java.lang.String encoding)
    {
        if (null == this.webIntentInstance) this.webIntentInstance = new android.content.Intent(
            this, org.phenoapps.androidlibrarybuilder.WebViewActivity.class);

        this.webIntentInstance.putExtra(
            org.phenoapps.androidlibrarybuilder.WebViewActivity.CONTENT, content);
        this.webIntentInstance.putExtra(
            org.phenoapps.androidlibrarybuilder.WebViewActivity.ENCODING, encoding);

        return this.webIntentInstance;
    }

    @androidx.annotation.NonNull private TestItems testItems()
    {
        if (null == this.testItemsInstance)
            this.testItemsInstance = new TestItems();
        return this.testItemsInstance;
    }

    @androidx.annotation.NonNull private android.content.Intent putJsonIntoIntent(
    @androidx.annotation.NonNull final java.lang.String       source    ,
    @androidx.annotation.NonNull final android.content.Intent listIntent)
    {
        final java.lang.String json = this.testItems().toJson();
        org.phenoapps.androidlibrarybuilder.MainActivity.log(
            source + ": putJsonIntoIntent(): " + json);
        return Utils.putJsonIntoIntent(json, listIntent);
    }

    private android.content.Intent listIntent()
    {
        if (null == this.listIntentInstance) this.listIntentInstance =
            new android.content.Intent(this,
                org.phenoapps.androidlibrarybuilder.mstrdtl.ListActivity.class);
        return this.putJsonIntoIntent("listIntent()", this.listIntentInstance);
    }

    private android.content.Intent changeableListIntent()
    {
        if (null == this.changeableListIntentInstance) this.changeableListIntentInstance =
            new android.content.Intent(this,
                org.phenoapps.androidlibrarybuilder.mstrdtl.ChangeableListActivity.class);
        return this.putJsonIntoIntent("changeableListIntent()",
            this.changeableListIntentInstance);
    }

    private void makeTestItemsFromJson(
    @androidx.annotation.NonNull  final java.lang.String source,
    @androidx.annotation.Nullable final java.lang.String json  )
    {
        org.phenoapps.androidlibrarybuilder.MainActivity.log(
            source + ": makeTestItemsFromJson(): " + json);
        this.testItems().fromJson(json);
    }

    // endregion

    // region make*ButtonReflectCurrentButtonState() Private Methods
    private void makeButtonReflectCurrentButtonState()
    {
        switch (this.buttonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
                this.resetButtonText(); break;
            case  1: this.setButtonText("Long Toast"                   ); break;
            case  2: this.setButtonText("permissionDir.list()"         ); break;
            case  3: this.setButtonText("requestDir.list() 1 of 3"     ); break;
            case  4: this.setButtonText("requestDir.list() 2 of 3"     ); break;
            case  5: this.setButtonText("requestDir.list() 3 of 3"     ); break;
            case  6: this.setButtonText("http://www.example.org/"      ); break;
            case  7: this.setButtonText("Master-Detail Flow"           ); break;
            case  8: this.setButtonText("Changeable Master-Detail Flow"); break;
            case  9: this.setButtonText("BrAPI 1.3"                    ); break;
            case 10: this.setButtonText("ChangeLog"                    ); break;
        }
    }

    private void makeOtherAppsButtonReflectCurrentButtonState()
    {
        switch (this.otherAppsButtonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
                this.resetOtherAppsButtonText(); break;
            case 1: this.setOtherAppsButtonText("About"); break;
        }
    }

    private void makeDeviceListButtonReflectCurrentButtonState()
    {
        // noinspection SwitchStatementWithTooFewBranches
        switch (this.deviceListButtonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
                this.resetDeviceListButtonText(); break;
            default: this.setDeviceListButtonText("DeviceList.information()"); break;
        }
    }

    private void makeScaleButtonReflectCurrentButtonState()
    {
        switch (this.scaleButtonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
                this.resetScaleButtonText(); break;
            case 1 : this.setScaleButtonText("ExtraDevice.formattedRead()"); break;
            case 2 : this.setScaleButtonText("Scale.information()"        ); break;
            case 3 : this.setScaleButtonText("Scale.formattedRead()"      ); break;
            default: this.setScaleButtonText("Error!"                     ); break;
        }
    }

    private void makeScaleReaderButtonReflectCurrentButtonState()
    {
        switch (this.scaleReaderButtonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
                this.resetScaleReaderButtonText(); break;
            case 1 : this.setScaleReaderButtonText("DeviceReader.cancel()"); break;
            case 2 : this.setScaleReaderButtonText("ScaleReader.execute()"); break;
            case 3 : this.setScaleReaderButtonText("ScaleReader.cancel()" ); break;
            default: this.setScaleReaderButtonText("Error!"               ); break;
        }
    }
    // endregion
    // endregion

    // region Overridden Methods
    @java.lang.Override protected void onCreate(
    @androidx.annotation.Nullable final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(org.phenoapps.androidlibrarybuilder.R.layout.activity_main_old);

        // region Find views.
        this.textView = this.findViewById(org.phenoapps.androidlibrarybuilder.R.id.textView);

        this.button = this.findViewById(org.phenoapps.androidlibrarybuilder.R.id.button);
        this.otherAppsButton =
            this.findViewById(org.phenoapps.androidlibrarybuilder.R.id.otherAppsButton);
        this.deviceListButton =
            this.findViewById(org.phenoapps.androidlibrarybuilder.R.id.deviceListButton);
        this.scaleButton =
            this.findViewById(org.phenoapps.androidlibrarybuilder.R.id.scaleButton);
        this.scaleReaderButton =
            this.findViewById(org.phenoapps.androidlibrarybuilder.R.id.scaleReaderButton);

        this.editText = this.findViewById(org.phenoapps.androidlibrarybuilder.R.id.editText);
        new org.phenoapps.androidlibrary.DebouncingEditorActionListener(this.editText,
            this, org.phenoapps.androidlibrarybuilder.BuildConfig.DEBUG,
            /* delayMillis => */1000);
        // endregion

        {
            final java.lang.String
                name = "AndroidLibraryBuilder", blankHiddenFileName = ".androidlibrarybuilder";
            this.permissionDir = new PermissionDir(
                /* activity => */this, name, blankHiddenFileName);
            this.requestDir = new RequestDir(
                /* activity    => */this, name, blankHiddenFileName,
                /* requestCode => */
                    org.phenoapps.androidlibrarybuilder.MainActivity.PERMISSIONS_REQUEST_CODE);
        }

        if (null != savedInstanceState)
        {
            {
                final java.lang.String TEXT_VIEW_TEXT_KEY =
                    org.phenoapps.androidlibrarybuilder.MainActivity.TEXT_VIEW_TEXT_KEY;
                this.setTextViewText(savedInstanceState.containsKey(TEXT_VIEW_TEXT_KEY) ?
                    savedInstanceState.getCharSequence(TEXT_VIEW_TEXT_KEY) : null);
            }

            {
                final java.lang.String EDIT_TEXT_TEXT_KEY =
                    org.phenoapps.androidlibrarybuilder.MainActivity.EDIT_TEXT_TEXT_KEY;
                this.editText.setText(savedInstanceState.containsKey(EDIT_TEXT_TEXT_KEY) ?
                    savedInstanceState.getCharSequence(EDIT_TEXT_TEXT_KEY) : null);
            }

            {
                final java.lang.String BUTTON_STATES_KEY =
                    org.phenoapps.androidlibrarybuilder.MainActivity.BUTTON_STATES_KEY;
                if (savedInstanceState.containsKey(BUTTON_STATES_KEY))
                {
                    // noinspection CStyleArrayDeclaration
                    final int buttonStates[] = savedInstanceState.getIntArray(BUTTON_STATES_KEY);
                    if (null != buttonStates)
                    {
                        this.buttonState            = buttonStates[0];
                        this.otherAppsButtonState   = buttonStates[1];
                        this.deviceListButtonState  = buttonStates[2];
                        this.scaleButtonState       = buttonStates[3];
                        this.scaleReaderButtonState = buttonStates[4];

                        if (1 == this.scaleReaderButtonState || 3 == this.scaleReaderButtonState)
                            this.scaleReaderButtonState = this.scaleReaderButtonState - 1;
                    }
                }
                else this.buttonState = this.otherAppsButtonState = this.deviceListButtonState =
                    this.scaleButtonState = this.scaleReaderButtonState = 0;
            }

            {
                final java.lang.String JSON_KEY =
                    Consts.JSON_KEY;
                this.makeTestItemsFromJson("onCreate()",
                    savedInstanceState.containsKey(JSON_KEY) ?
                        savedInstanceState.getString(JSON_KEY) : null);
            }
        }

        // region Make buttons reflect current button states.
        this.makeButtonReflectCurrentButtonState           ();
        this.makeOtherAppsButtonReflectCurrentButtonState  ();
        this.makeDeviceListButtonReflectCurrentButtonState ();
        this.makeScaleButtonReflectCurrentButtonState      ();
        this.makeScaleReaderButtonReflectCurrentButtonState();
        // endregion
    }

    @java.lang.Override public boolean onCreateOptionsMenu(final android.view.Menu menu)
    {
        new android.view.MenuInflater(this).inflate(
            org.phenoapps.androidlibrary.R.menu.camera_options_menu, menu);
        return true;
    }

    @java.lang.Override public void onRequestPermissionsResult(final int requestCode,
    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"}) @androidx.annotation.NonNull
        final java.lang.String permissions[],
    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"}) @androidx.annotation.NonNull
        final int grantResults[]) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (MainActivity.PERMISSIONS_REQUEST_CODE
                == requestCode) {
            boolean permissionFound = false;
            for (final String permission : permissions)
                if (Manifest.permission.WRITE_EXTERNAL_STORAGE.equals(permission)) {
                    permissionFound = true;
                    break;
                }

            if (permissionFound) for (final int grantResult : grantResults)
                if (PackageManager.PERMISSION_GRANTED == grantResult) {
                    this.listAll(this.requestDir);
                    break;
                }
        }
    }

    @java.lang.Override protected void onSaveInstanceState(
    @androidx.annotation.NonNull final android.os.Bundle outState)
    {
        if (null != this.textView) outState.putCharSequence(
            org.phenoapps.androidlibrarybuilder.MainActivity.TEXT_VIEW_TEXT_KEY,
            this.textView.getText()                                                );
        if (null != this.editText) outState.putCharSequence(
            org.phenoapps.androidlibrarybuilder.MainActivity.EDIT_TEXT_TEXT_KEY,
            this.editText.getText()                                                );
        outState.putIntArray(org.phenoapps.androidlibrarybuilder.MainActivity.BUTTON_STATES_KEY,
            new int[]{this.buttonState, this.otherAppsButtonState, this.deviceListButtonState,
                this.scaleButtonState, this.scaleReaderButtonState});
        if (null != this.testItemsInstance)
        {
            final java.lang.String json = this.testItemsInstance.toJson();
            org.phenoapps.androidlibrarybuilder.MainActivity.log(
                "onSaveInstanceState(): " + json);
            if (null != json)
                outState.putString(Consts.JSON_KEY, json);
        }

        super.onSaveInstanceState(outState);
    }

    // region org.wheatgenetics.androidlibrary.DebouncingEditorActionListener.Receiver Overridden Method
    @java.lang.Override public void receiveText(final java.lang.String text)
    { this.setTextViewText(text); if (null != this.editText) this.editText.requestFocus(); }
    // endregion
    // endregion

    // region Event Handlers
    public void onButtonClick(@java.lang.SuppressWarnings({"unused"}) final android.view.View view)
    {
        switch (this.buttonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
                org.phenoapps.androidlibrary.Utils.showShortToast(this,"short");
                break;

            case 1: org.phenoapps.androidlibrary.Utils.showLongToast(this,"long");
                break;

            case 2:                 this.listAll(this.permissionDir); break;
            case 3: case 4: case 5: this.listAll(this.requestDir   ); break;

            case 6:
                final org.phenoapps.androidlibrary.Utils.Response response;
                {
                    java.net.URL url;
                    try
                    {
                        url = new java.net.URL(             // throws java.net.MalformedURLException
                            /* protocol => */"http",
                            /* host     => */"www.example.org",
                            /* file     => */"index.html");
                    }
                    catch (final java.net.MalformedURLException e) { url = null; }
                    response = org.phenoapps.androidlibrary.Utils.threadedGet(url,500);
                }
                if (null == response)
                    this.setTextViewText("response is null");
                else
                    this.startActivity(this.webIntent(
                        response.content(), response.contentEncoding()));
                break;

            case 7: this.startActivityForResult(this.listIntent(),
                org.phenoapps.androidlibrarybuilder.MainActivity.ACTIVITY_REQUEST_CODE); break;

            case 8: this.startActivityForResult(this.changeableListIntent(),
                org.phenoapps.androidlibrarybuilder.MainActivity.ACTIVITY_REQUEST_CODE); break;
        }

        switch (this.buttonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
            case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
                this.buttonState++; break;

            default: this.buttonState =
                org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE; break;
        }
        this.makeButtonReflectCurrentButtonState();
    }

    public void onDeviceListButtonClick(
    @java.lang.SuppressWarnings({"unused"}) final android.view.View view)
    {
        if (null == this.deviceListTester)
            this.deviceListTester = new org.phenoapps.usb.DeviceListTester(this);

        switch (this.deviceListButtonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
                this.setTextViewText(this.deviceListTester.size()); break;
            case 1: this.setTextViewText(this.deviceListTester.information()); break;
        }

        // noinspection SwitchStatementWithTooFewBranches
        switch (this.deviceListButtonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
                this.deviceListButtonState++; break;

            default: this.deviceListButtonState =
                org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE; break;
        }
        this.makeDeviceListButtonReflectCurrentButtonState();
    }

    public void onScaleButtonClick(
    @java.lang.SuppressWarnings({"unused"}) final android.view.View view)
    {
        switch (this.scaleButtonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE: case 1:
                if (null == this.extraDeviceTester) this.extraDeviceTester =
                    new org.phenoapps.usb.ExtraDeviceTester(this);
                break;

            case 2: case 3: if (null == this.scaleTester) this.scaleTester =
                new org.phenoapps.usb.ScaleTester(this); break;
        }

        switch (this.scaleButtonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
                this.setTextViewText(this.extraDeviceTester.information()); break;
            case 1: this.setTextViewText(this.extraDeviceTester.handlingFormattedRead()); break;
            case 2: this.setTextViewText(this.scaleTester.information                ()); break;
            case 3: this.setTextViewText(this.scaleTester.handlingFormattedRead      ()); break;
        }

        switch (this.scaleButtonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
            case 1: case 2: this.scaleButtonState++; break;

            default: this.scaleButtonState =
                org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE; break;
        }
        this.makeScaleButtonReflectCurrentButtonState();
    }

    public void onPreferenceClick(View view) {

        Intent i = new Intent(this, PreferencesActivity.class);

        startActivity(i);
    }

    public void onScaleReaderButtonClick(
    @java.lang.SuppressWarnings({"unused"}) final android.view.View view)
    {
        switch (this.scaleReaderButtonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE: case 1:
                if (null == this.deviceReaderTester) this.deviceReaderTester =
                    new org.phenoapps.usb.DeviceReaderTester(this,
                        new org.phenoapps.usb.DeviceReaderTester.Publisher()
                        {
                            @java.lang.Override public void publish(final java.lang.String data)
                            {
                                org.phenoapps.androidlibrarybuilder.MainActivity
                                    .this.setAndInvalidateTextViewText(data);
                            }
                        }); break;

            case 2: case 3: if (null == this.scaleReaderTester)
                this.scaleReaderTester = new org.phenoapps.usb.ScaleReaderTester(this,
                    new org.phenoapps.usb.ScaleReaderTester.Publisher()
                    {
                        @java.lang.Override public void publish(final java.lang.String data)
                        {
                            org.phenoapps.androidlibrarybuilder.MainActivity
                                .this.setAndInvalidateTextViewText(data);
                        }
                    }); break;
        }

        switch (this.scaleReaderButtonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
                this.deviceReaderTester.executeReader(); break;
            case 1: this.deviceReaderTester.cancelReader(); break;
            case 2: this.scaleReaderTester.executeReader(); break;
            case 3: this.scaleReaderTester.cancelReader (); break;
        }

        switch (this.scaleReaderButtonState)
        {
            case org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE:
            case 1: case 2: this.scaleReaderButtonState++; break;

            default: this.scaleReaderButtonState =
                org.phenoapps.androidlibrarybuilder.MainActivity.MIN_BUTTON_STATE; break;
        }
        this.makeScaleReaderButtonReflectCurrentButtonState();
    }
    // endregion
}