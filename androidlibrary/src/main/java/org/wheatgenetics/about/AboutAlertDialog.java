package org.wheatgenetics.about;

/**
 * Uses:
 * android.annotation.SuppressLint
 * android.app.Activity
 * android.view.LayoutInflater
 * android.view.View
 * android.view.View.OnClickListener
 * android.widget.LinearLayout
 * android.widget.TextView
 *
 * androidx.annotation.IdRes
 * androidx.annotation.NonNull
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.about.OtherApps.Index
 * org.wheatgenetics.about.OtherAppsOnClickListener
 */
public class AboutAlertDialog extends org.wheatgenetics.androidlibrary.AlertDialog
{
    @android.annotation.SuppressLint({"SetTextI18n"}) public AboutAlertDialog(
    @androidx.annotation.NonNull final android.app.Activity activity   ,
    @androidx.annotation.NonNull final java.lang.String     title      ,
    @androidx.annotation.NonNull final java.lang.String     versionName,
    @androidx.annotation.NonNull @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
        final java.lang.String msgs[],
    @androidx.annotation.NonNull final org.wheatgenetics.about.OtherApps.Index    suppressIndex,
    @androidx.annotation.NonNull final android.view.View.OnClickListener versionOnClickListener)
    {
        super(activity);

        final android.view.View aboutView =
            android.view.LayoutInflater.from(this.activity()).inflate(
                /* resource     => */ org.wheatgenetics.androidlibrary.R.layout.alert_dialog_about,
                /* root         => */ new android.widget.LinearLayout(activity)                   ,
                /* attachToRoot => */false);
        if (null != aboutView)
        {
            {
                final android.widget.TextView versionTextView = aboutView.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.aboutVersionTextView);
                if (null != versionTextView)
                {
                    versionTextView.setText(versionTextView.getText() + " " + versionName);
                    versionTextView.setOnClickListener(versionOnClickListener);
                }
            }
            {
                final android.widget.TextView otherAppsTextView = aboutView.findViewById(
                    org.wheatgenetics.androidlibrary.R.id.aboutOtherAppsTextView);
                if (null != otherAppsTextView) otherAppsTextView.setOnClickListener(
                    new org.wheatgenetics.about.OtherAppsOnClickListener(activity, suppressIndex));
            }
            {
                @java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
                class MsgSetter extends java.lang.Object
                {
                    // region Fields
                    @androidx.annotation.NonNull private final android.view.View aboutView;
                    @androidx.annotation.NonNull @java.lang.SuppressWarnings(
                        {"CStyleArrayDeclaration"}) private final java.lang.String msgs[];
                    // endregion

                    private MsgSetter(
                    @androidx.annotation.NonNull final android.view.View aboutView,
                    @androidx.annotation.NonNull @java.lang.SuppressWarnings(
                        {"CStyleArrayDeclaration"}) final java.lang.String msgs[])
                    { super(); this.aboutView = aboutView; this.msgs = msgs; }

                    private void execute()
                    {
                        if (this.msgs.length > 0)
                        {
                            int i = 1;
                            for (final java.lang.String msg: this.msgs)
                                if (i > 3)
                                    break;
                                else
                                {
                                    final android.widget.TextView msgTextView;
                                    {
                                        @androidx.annotation.IdRes final int msgTextViewId;
                                        switch (i++)
                                        {
                                            case 1: msgTextViewId = org.wheatgenetics
                                                .androidlibrary.R.id.aboutMsg1TextView; break;

                                            case 2: msgTextViewId = org.wheatgenetics
                                                .androidlibrary.R.id.aboutMsg2TextView; break;

                                            case 3: msgTextViewId = org.wheatgenetics
                                                .androidlibrary.R.id.aboutMsg3TextView; break;

                                            default: return;
                                        }
                                        msgTextView = this.aboutView.findViewById(msgTextViewId);
                                    }
                                    if (null != msgTextView)
                                    {
                                        msgTextView.setText(msg);
                                        msgTextView.setVisibility(android.view.View.VISIBLE);
                                    }
                                }
                        }
                    }
                }
                new MsgSetter(aboutView, msgs).execute();
            }
            this.setTitle(title).setView(aboutView);
        }
    }

    @java.lang.Override public void configure()
    { this.setCancelableToTrue().setOKNegativeButton(); }
}