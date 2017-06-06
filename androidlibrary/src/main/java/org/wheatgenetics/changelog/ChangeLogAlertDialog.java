package org.wheatgenetics.changelog;

/**
 * Uses:
 * android.app.AlertDialog
 * android.app.AlertDialog.Builder
 * android.content.Context
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 * android.content.res.Resources
 * android.widget.LinearLayout
 * android.widget.LinearLayout.LayoutParams
 * android.widget.ScrollView
 * android.widget.TextView
 *
 * org.wheatgenetics.androidlibrary.BuildConfig
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.changelog.ChangeLog
 * org.wheatgenetics.changelog.ChangeLog.LineHandler
 */

public class ChangeLogAlertDialog extends java.lang.Object
{
    class ScrollView extends java.lang.Object
    {
        class LineHandler extends java.lang.Object
        implements org.wheatgenetics.changelog.ChangeLog.LineHandler
        {
            // region Private Fields
            private final android.content.Context                  context, applicationContext;
            private final android.widget.LinearLayout              linearLayout               ;
            private       android.widget.LinearLayout.LayoutParams layoutParams = null        ;
            // endregion

            // region Private Method
            private android.widget.TextView makeTextView()
            {
                if (this.layoutParams == null)
                {
                    this.layoutParams = new android.widget.LinearLayout.LayoutParams(
                        /* width  => */ android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                        /* height => */ android.widget.LinearLayout.LayoutParams.MATCH_PARENT);
                    this.layoutParams.setMargins(/* left => */ 20,
                        /* top => */ 5, /* right => */ 20, /* bottom => */ 0);
                }

                final android.widget.TextView textView = new android.widget.TextView(this.context);
                textView.setLayoutParams(this.layoutParams);
                return textView;
            }
            // endregion

            // region Public Overridden Methods
            @java.lang.Override
            public void handleBlankLine()
            {
                final android.widget.TextView spacerTextView = this.makeTextView();
                if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == spacerTextView)
                    throw new java.lang.AssertionError();
                spacerTextView.setTextSize(5);
                spacerTextView.setText("\n");

                if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == linearLayout)
                    throw new java.lang.AssertionError();
                this.linearLayout.addView(spacerTextView);
            }

            @java.lang.Override
            public void handleVersionLine(final java.lang.String version)
            {
                final android.widget.TextView headerTextView = this.makeTextView();
                if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == headerTextView)
                    throw new java.lang.AssertionError();
                headerTextView.setTextAppearance(this.applicationContext,
                    org.wheatgenetics.androidlibrary.R.style.changeLogAlertDialogVersionLine);
                headerTextView.setText(version);

                if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == linearLayout)
                    throw new java.lang.AssertionError();
                this.linearLayout.addView(headerTextView);
            }

            @java.lang.Override
            public void handleContentLine(final java.lang.String content)
            {
                final android.widget.TextView contentTextView = this.makeTextView();
                if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == contentTextView)
                    throw new java.lang.AssertionError();
                contentTextView.setTextAppearance(this.applicationContext,
                  org.wheatgenetics.androidlibrary.R.style.changeLogAlertDialogContentLine);
                contentTextView.setText(content);

                if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == linearLayout)
                    throw new java.lang.AssertionError();
                this.linearLayout.addView(contentTextView);
            }
            // endregion

            // region Package Constructor Method
            LineHandler(final android.content.Context context,
            final android.widget.LinearLayout linearLayout)
            {
                super();

                if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == context)
                    throw new java.lang.AssertionError();
                this.context = context;

                this.applicationContext = this.context.getApplicationContext();

                if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == linearLayout)
                    throw new java.lang.AssertionError();
                this.linearLayout = linearLayout;
            }
            // endregion
        }

        // region Private Fields
        private final android.content.Context context               ;
        private final int                     changeLogRawResourceId;

        private android.widget.LinearLayout linearLayout = null;
        private android.widget.ScrollView   scrollView   = null;

        private org.wheatgenetics.changelog.ChangeLogAlertDialog.ScrollView.LineHandler
            lineHandler = null;
        private org.wheatgenetics.changelog.ChangeLog changeLog = null;
        // endregion

        // region Package Methods
        ScrollView(final android.content.Context context, final int changeLogRawResourceId)
        {
            super();

            if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == context)
                throw new java.lang.AssertionError();
            this.context = context;

            this.changeLogRawResourceId = changeLogRawResourceId;
        }

        android.widget.ScrollView get() throws java.io.IOException
        {
            if (null == this.scrollView)
            {
                this.scrollView = new android.widget.ScrollView(this.context);
                this.scrollView.removeAllViews();

                if (null == this.linearLayout)
                    this.linearLayout = new android.widget.LinearLayout(this.context);
                this.scrollView.addView(this.linearLayout);
            }

            if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == this.linearLayout)
                throw new java.lang.AssertionError();
            this.linearLayout.setOrientation(android.widget.LinearLayout.VERTICAL);

            if (null == this.changeLog)
            {
                if (null == this.lineHandler) this.lineHandler =
                    new org.wheatgenetics.changelog.ChangeLogAlertDialog.ScrollView.LineHandler(
                        this.context, this.linearLayout);

                if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == this.context)
                    throw new java.lang.AssertionError();
                final android.content.res.Resources resources = this.context.getResources();

                if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == resources)
                    throw new java.lang.AssertionError();
                this.changeLog = new org.wheatgenetics.changelog.ChangeLog(
                    new java.io.InputStreamReader(resources.openRawResource(
                        this.changeLogRawResourceId)),
                    this.lineHandler);
            }

            this.changeLog.iterate();                                  // throws java.io.IOException
            return this.scrollView;
        }
        // endregion
    }

    // region Private Fields
    // region scrollView Private Fields
    private final android.content.Context context               ;
    private final int                     changeLogRawResourceId;

    private org.wheatgenetics.changelog.ChangeLogAlertDialog.ScrollView scrollView = null;
    // endregion

    private android.app.AlertDialog.Builder builder     = null;
    private android.app.AlertDialog         alertDialog = null;
    // endregion

    // region Public Methods
    public ChangeLogAlertDialog(final android.content.Context context,
    final int changeLogRawResourceId)
    {
        super();

        if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == context)
            throw new java.lang.AssertionError();
        this.context = context;

        this.changeLogRawResourceId = changeLogRawResourceId;
    }

    public void show() throws java.io.IOException
    {
        if (null == this.alertDialog)
        {
            if (null == this.builder)
            {
                if (null == this.scrollView) this.scrollView =
                    new org.wheatgenetics.changelog.ChangeLogAlertDialog.ScrollView(
                        this.context, this.changeLogRawResourceId);

                this.builder = new android.app.AlertDialog.Builder(this.context);
                {
                    if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == this.context)
                        throw new java.lang.AssertionError();
                    final android.content.res.Resources resources = this.context.getResources();

                    if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == resources)
                        throw new java.lang.AssertionError();
                    this.builder.setTitle(resources.getString(
                            org.wheatgenetics.androidlibrary.R.string.changeLogAlertDialogTitle))
                        .setView(this.scrollView.get())                // throws java.io.IOException
                        .setCancelable(true)
                        .setPositiveButton(resources.getString(org.wheatgenetics.androidlibrary.
                                R.string.changeLogAlertDialogPositiveButtonText),
                            new android.content.DialogInterface.OnClickListener()
                            {
                                @java.lang.Override
                                public void onClick(final android.content.DialogInterface dialog,
                                final int which)
                                {
                                    if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG
                                    && null == dialog)
                                        throw new java.lang.AssertionError();
                                    dialog.dismiss();
                                }
                            });
                }
            }
            this.alertDialog = this.builder.create();
            if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG && null == this.alertDialog)
                throw new java.lang.AssertionError();
        }
        this.alertDialog.show();
    }
    // endregion
}