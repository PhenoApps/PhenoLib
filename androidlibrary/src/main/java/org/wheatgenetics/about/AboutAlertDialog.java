package org.wheatgenetics.about;

/**
 * Uses:
 * android.app.Activity
 * android.support.annotation.IdRes
 * android.support.annotation.NonNull
 * android.view.LayoutInflater
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.LinearLayout
 * android.widget.TextView
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.about.OtherApps.Index
 * org.wheatgenetics.about.OtherAppsOnClickListener
 */
public class AboutAlertDialog extends org.wheatgenetics.androidlibrary.AlertDialog
{
    public AboutAlertDialog(
    @android.support.annotation.NonNull final android.app.Activity activity   ,
    @android.support.annotation.NonNull final java.lang.String     title      ,
    @android.support.annotation.NonNull final java.lang.String     versionName,
    @android.support.annotation.NonNull final java.lang.String     msgs[]     ,
    @android.support.annotation.NonNull
        final org.wheatgenetics.about.OtherApps.Index suppressIndex,
    @android.support.annotation.NonNull
        final android.view.View.OnClickListener versionOnClickListener)
    {
        super(activity);

        final android.view.View aboutView = android.view.LayoutInflater.from(activity).inflate(
            /* resource     => */ org.wheatgenetics.androidlibrary.R.layout.about_alert_dialog,
            /* root         => */ new android.widget.LinearLayout(activity)                   ,
            /* attachToRoot => */ false                                                       );
        {
            assert null != aboutView;
            final android.widget.TextView versionTextView = (android.widget.TextView)
                aboutView.findViewById(org.wheatgenetics.androidlibrary.R.id.aboutVersionTextView);
            assert null != versionTextView;
            versionTextView.setText(versionTextView.getText() + " " + versionName);
            versionTextView.setOnClickListener(versionOnClickListener);
        }
        {
            final android.widget.TextView otherAppsTextView = (android.widget.TextView)
                aboutView.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.aboutOtherAppsTextView);
            assert null != otherAppsTextView; otherAppsTextView.setOnClickListener(
                new org.wheatgenetics.about.OtherAppsOnClickListener(activity, suppressIndex));
        }
        {
            @java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
            class MsgSetter extends java.lang.Object
            {
                // region Fields
                private final android.view.View aboutView;
                private final java.lang.String  msgs[]   ;
                // endregion

                private MsgSetter(final android.view.View aboutView, final java.lang.String msgs[])
                { super(); this.aboutView = aboutView; this.msgs = msgs; }

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
                            final android.widget.TextView msgTextView;
                            {
                                @android.support.annotation.IdRes final int msgTextViewId;
                                switch (i++)
                                {
                                    case 1: msgTextViewId =
                                        org.wheatgenetics.androidlibrary.R.id.aboutMsg1TextView;
                                        break;

                                    case 2: msgTextViewId =
                                        org.wheatgenetics.androidlibrary.R.id.aboutMsg2TextView;
                                        break;

                                    case 3: msgTextViewId =
                                        org.wheatgenetics.androidlibrary.R.id.aboutMsg3TextView;
                                        break;

                                    default: msgTextViewId = 0; return;
                                }
                                msgTextView = (android.widget.TextView)
                                    this.aboutView.findViewById(msgTextViewId);
                            }
                            assert null != msgTextView; msgTextView.setText(msg);
                        }
                    }
                }
            }
            new MsgSetter(aboutView, msgs).execute();
        }
        this.setTitle(title).setView(aboutView);
    }

    @java.lang.Override
    public void configure() { this.setCancelableToTrue().setOKNegativeButton(); }
}