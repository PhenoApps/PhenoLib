package org.wheatgenetics.changelog;

/**
 * Uses:
 * android.app.Activity
 * android.content.Context
 * android.content.res.Resources
 * android.widget.LinearLayout
 * android.widget.LinearLayout.LayoutParams
 * android.widget.ScrollView
 * android.widget.TextView
 *
 * androidx.annotation.NonNull
 * androidx.annotation.RawRes
 * androidx.annotation.StyleRes
 *
 * org.wheatgenetics.changelog.ChangeLog
 * org.wheatgenetics.changelog.ChangeLog.LineHandler
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.Utils
 */
public class ChangeLogAlertDialog extends org.wheatgenetics.androidlibrary.AlertDialog
{
    public ChangeLogAlertDialog(
    @androidx.annotation.NonNull final android.app.Activity activity              ,
    @androidx.annotation.RawRes  final int                  changeLogRawResourceId)
    {
        super(activity);

        @java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
        class ScrollView extends java.lang.Object
        {
            // region Fields
            @androidx.annotation.NonNull private final android.app.Activity activity              ;
            @androidx.annotation.RawRes  private final int                  changeLogRawResourceId;

            private android.widget.LinearLayout           linearLayout = null;
            private org.wheatgenetics.changelog.ChangeLog changeLog    = null;
            private android.widget.ScrollView             scrollView   = null;
            // endregion

            private ScrollView(
            @androidx.annotation.NonNull final android.app.Activity activity              ,
            @androidx.annotation.RawRes  final int                  changeLogRawResourceId)
            {
                super();
                this.activity = activity; this.changeLogRawResourceId = changeLogRawResourceId;
            }

            private android.widget.ScrollView get()
            {
                if (null == this.linearLayout)
                {
                    this.linearLayout = new android.widget.LinearLayout(this.activity);
                    this.linearLayout.setOrientation(android.widget.LinearLayout.VERTICAL);
                }

                if (null == this.changeLog)
                {
                    final java.io.InputStreamReader inputStreamReader;
                    {
                        final android.content.res.Resources resources =
                            this.activity.getResources();

                        inputStreamReader = null == resources ? null :
                            new java.io.InputStreamReader(
                                resources.openRawResource(this.changeLogRawResourceId));
                    }

                    class LineHandler extends java.lang.Object
                    implements org.wheatgenetics.changelog.ChangeLog.LineHandler
                    {
                        // region Fields
                        @androidx.annotation.NonNull private final android.app.Activity activity;
                        @androidx.annotation.NonNull private final
                            android.widget.LinearLayout linearLayout;
                        private final android.content.Context applicationContext;

                        private android.widget.LinearLayout.LayoutParams layoutParams = null;
                        // endregion

                        // region Private Methods
                        @androidx.annotation.NonNull
                        private android.widget.TextView makeTextView()
                        {
                            if (null == this.layoutParams)
                            {
                                this.layoutParams = new android.widget.LinearLayout.LayoutParams(
                                    /* width => */
                                        android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                                    /* height => */
                                        android.widget.LinearLayout.LayoutParams.MATCH_PARENT);
                                this.layoutParams.setMargins(
                                    /* left   => */20,
                                    /* top    => */5,
                                    /* right  => */20,
                                    /* bottom => */0);
                            }

                            final android.widget.TextView result =
                                new android.widget.TextView(this.activity);
                            result.setLayoutParams(this.layoutParams);
                            return result;
                        }

                        private void handleLine(
                        @androidx.annotation.StyleRes final int                    resId,
                                                      final java.lang.CharSequence text )
                        {
                            final android.widget.TextView textView = this.makeTextView();
                            textView.setTextAppearance(this.applicationContext, resId);
                            textView.setText(text);

                            this.linearLayout.addView(textView);
                        }
                        // endregion

                        private LineHandler(
                        @androidx.annotation.NonNull final android.app.Activity        activity    ,
                        @androidx.annotation.NonNull final android.widget.LinearLayout linearLayout)
                        {
                            super();

                            this.activity           = activity                             ;
                            this.applicationContext = this.activity.getApplicationContext();
                            this.linearLayout       = linearLayout                         ;
                        }

                        // region org.wheatgenetics.changelog.ChangeLog.LineHandler Overridden Methods
                        @java.lang.Override public void handleBlankLine()
                        {
                            final android.widget.TextView spacerTextView = this.makeTextView();
                            spacerTextView.setTextSize(5); spacerTextView.setText("\n");
                            this.linearLayout.addView(spacerTextView);
                        }

                        @java.lang.Override
                        public void handleVersionLine(final java.lang.String version)
                        {
                            this.handleLine(org.wheatgenetics.androidlibrary.
                                R.style.changeLogAlertDialogVersionLine, version);
                        }

                        @java.lang.Override
                        public void handleContentLine(final java.lang.String content)
                        {
                            this.handleLine(org.wheatgenetics.androidlibrary.
                                R.style.changeLogAlertDialogContentLine, content);
                        }
                        // endregion
                    }

                    this.changeLog = new org.wheatgenetics.changelog.ChangeLog(
                        /* inputStreamReader => */ inputStreamReader,
                        /* lineHandler => */ new LineHandler(this.activity, this.linearLayout));
                }
                try { this.changeLog.iterate() /* throws java.io.IOException */; }
                catch (final java.io.IOException e) { return null; }

                if (null == this.scrollView)
                {
                    this.scrollView = new android.widget.ScrollView(this.activity);
                    this.scrollView.removeAllViews(); this.scrollView.addView(this.linearLayout);
                }
                return this.scrollView;
            }
        }
        this.setView(new ScrollView(activity, changeLogRawResourceId).get());
    }

    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.changeLogAlertDialogTitle)
            .setCancelableToTrue().setOKPositiveButton(
                org.wheatgenetics.androidlibrary.Utils.dismissingOnClickListener());
    }
}