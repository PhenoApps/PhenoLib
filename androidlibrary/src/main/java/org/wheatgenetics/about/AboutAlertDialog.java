package org.wheatgenetics.about;

/**
 * Uses:
 * android.app.AlertDialog
 * android.app.AlertDialog.Builder
 * android.content.Context
 * android.support.annotation.NonNull
 * android.view.LayoutInflater
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.LinearLayout
 * android.widget.TextView
 *
 * org.wheatgenetics.about.OtherApps.Index
 * org.wheatgenetics.about.OtherAppsOnClickListener
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.Utils
 */
public class AboutAlertDialog extends java.lang.Object
{
    // region Fields
    private final android.content.Context                 context                   ;
    private final java.lang.String                        title, versionName, msgs[];
    private final org.wheatgenetics.about.OtherApps.Index suppressIndex             ;
    private final android.view.View.OnClickListener       versionOnClickListener    ;

    private android.app.AlertDialog.Builder builder     = null;
    private android.app.AlertDialog         alertDialog = null;
    // endregion

    // region Public Methods
    public AboutAlertDialog(
    @android.support.annotation.NonNull final android.content.Context context,
    @android.support.annotation.NonNull final java.lang.String title         ,
    @android.support.annotation.NonNull final java.lang.String versionName   ,
    @android.support.annotation.NonNull final java.lang.String msgs[]        ,
    @android.support.annotation.NonNull
        final org.wheatgenetics.about.OtherApps.Index suppressIndex,
    @android.support.annotation.NonNull
        final android.view.View.OnClickListener versionOnClickListener)
    {
        super();

        this.context = context;

        this.title       = title      ;
        this.versionName = versionName;
        this.msgs        = msgs       ;

        this.suppressIndex = suppressIndex;

        this.versionOnClickListener = versionOnClickListener;
    }

    public void show()
    {
        if (null == this.alertDialog)
        {
            if (null == this.builder)
            {
                this.builder = new android.app.AlertDialog.Builder(this.context);
                {
                    final android.view.View aboutView =
                        android.view.LayoutInflater.from(this.context).inflate(
                            /* resource => */
                                org.wheatgenetics.androidlibrary.R.layout.about_alert_dialog,
                            /* root         => */ new android.widget.LinearLayout(this.context),
                            /* attachToRoot => */ false                                        );
                    {
                        assert null != aboutView;
                        final android.widget.TextView versionTextView = (android.widget.TextView)
                            aboutView.findViewById(
                                org.wheatgenetics.androidlibrary.R.id.aboutVersionTextView);
                        assert null != versionTextView;
                        versionTextView.setText(versionTextView.getText() + " " + this.versionName);
                        versionTextView.setOnClickListener(this.versionOnClickListener);
                    }
                    {
                        final android.widget.TextView otherAppsTextView = (android.widget.TextView)
                            aboutView.findViewById(
                                org.wheatgenetics.androidlibrary.R.id.aboutOtherAppsTextView);
                        assert null != otherAppsTextView;
                        otherAppsTextView.setOnClickListener(
                            new org.wheatgenetics.about.OtherAppsOnClickListener(
                                this.context, this.suppressIndex));
                    }
                    {
                        class MsgSetter extends java.lang.Object
                        {
                            private final android.view.View aboutView;
                            private final java.lang.String  msgs[]   ;

                            private MsgSetter(final android.view.View aboutView,
                            final java.lang.String msgs[])
                            {
                                super();

                                this.aboutView = aboutView;
                                this.msgs      = msgs     ;
                            }

                            private void execute()
                            {
                                if (null != this.msgs) if (this.msgs.length > 0)
                                {
                                    assert null != this.aboutView;
                                    int i = 1;
                                    for (final java.lang.String msg: this.msgs) if (i > 3)
                                        break;
                                    else
                                    {
                                        android.widget.TextView msgTextView;
                                        {
                                            int msgTextViewId;
                                            switch (i++)
                                            {
                                                case 1: msgTextViewId = org.wheatgenetics.
                                                    androidlibrary.R.id.aboutMsg1TextView; break;
                                                case 2: msgTextViewId = org.wheatgenetics.
                                                    androidlibrary.R.id.aboutMsg2TextView; break;
                                                case 3: msgTextViewId = org.wheatgenetics.
                                                    androidlibrary.R.id.aboutMsg3TextView; break;
                                                default: msgTextViewId = 0; return;
                                            }
                                            msgTextView = (android.widget.TextView)
                                                this.aboutView.findViewById(msgTextViewId);
                                        }
                                        assert null != msgTextView;
                                        msgTextView.setText(msg);
                                    }
                                }
                            }
                        }
                        new MsgSetter(aboutView, this.msgs).execute();
                    }
                    builder.setCancelable(true)
                        .setTitle(this.title)
                        .setView (aboutView );
                }
                this.builder.setNegativeButton(
                    org.wheatgenetics.androidlibrary.R.string.okButtonText            ,
                    org.wheatgenetics.androidlibrary.Utils.dismissingOnClickListener());
            }
            this.alertDialog = this.builder.create();
            assert null != this.alertDialog;
        }
        this.alertDialog.show();
    }
    // endregion
}