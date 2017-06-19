package org.wheatgenetics.changelog;

/**
 * Uses:
 * android.app.AlertDialog
 * android.app.AlertDialog.Builder
 * android.content.Context
 * android.content.res.Resources
 * android.support.annotation.NonNull
 * android.widget.LinearLayout
 * android.widget.LinearLayout.LayoutParams
 * android.widget.ScrollView
 * android.widget.TextView
 *
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.Utils
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
                if (null == this.layoutParams)
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
                assert null != spacerTextView;
                spacerTextView.setTextSize(5);
                spacerTextView.setText("\n");

                assert null != this.linearLayout;
                this.linearLayout.addView(spacerTextView);
            }

            @java.lang.Override
            public void handleVersionLine(final java.lang.String version)
            {
                final android.widget.TextView headerTextView = this.makeTextView();
                assert null != headerTextView;
                headerTextView.setTextAppearance(this.applicationContext,
                    org.wheatgenetics.androidlibrary.R.style.changeLogAlertDialogVersionLine);
                headerTextView.setText(version);

                assert null != this.linearLayout;
                this.linearLayout.addView(headerTextView);
            }

            @java.lang.Override
            public void handleContentLine(final java.lang.String content)
            {
                final android.widget.TextView contentTextView = this.makeTextView();
                assert null != contentTextView;
                contentTextView.setTextAppearance(this.applicationContext,
                  org.wheatgenetics.androidlibrary.R.style.changeLogAlertDialogContentLine);
                contentTextView.setText(content);

                assert null != this.linearLayout;
                this.linearLayout.addView(contentTextView);
            }
            // endregion

            // region Package Constructor Method
            LineHandler(@android.support.annotation.NonNull final android.content.Context context,
            @android.support.annotation.NonNull final android.widget.LinearLayout linearLayout)
            {
                super();

                assert null != context;
                this.context = context;

                this.applicationContext = this.context.getApplicationContext();

                assert null != linearLayout;
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
        ScrollView(@android.support.annotation.NonNull final android.content.Context context,
        @android.support.annotation.NonNull final int changeLogRawResourceId)
        {
            super();

            assert null != context;
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

            assert null != this.linearLayout;
            this.linearLayout.setOrientation(android.widget.LinearLayout.VERTICAL);

            if (null == this.changeLog)
            {
                if (null == this.lineHandler) this.lineHandler =
                    new org.wheatgenetics.changelog.ChangeLogAlertDialog.ScrollView.LineHandler(
                        this.context, this.linearLayout);

                assert null != this.context;
                final android.content.res.Resources resources = this.context.getResources();

                assert null != resources;
                this.changeLog = new org.wheatgenetics.changelog.ChangeLog(
                    new java.io.InputStreamReader(resources.openRawResource(
                        this.changeLogRawResourceId)),
                    this.lineHandler                 );
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
    public ChangeLogAlertDialog(@android.support.annotation.NonNull
    final android.content.Context context, final int changeLogRawResourceId)
    {
        super();

        assert null != context;
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
                this.builder.setTitle(
                        org.wheatgenetics.androidlibrary.R.string.changeLogAlertDialogTitle)
                    .setView          (this.scrollView.get())          // throws java.io.IOException
                    .setCancelable    (true                 )
                    .setPositiveButton(org.wheatgenetics.androidlibrary.R.string.okButtonText,
                        org.wheatgenetics.androidlibrary.Utils.dismissingOnClickListener());
            }
            this.alertDialog = this.builder.create();
            assert null != this.alertDialog;
        }
        this.alertDialog.show();
    }
    // endregion
}