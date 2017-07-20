package org.wheatgenetics.about;

/**
 * Uses:
 * android.app.AlertDialog
 * android.app.AlertDialog.Builder
 * android.content.Context
 * android.content.Intent
 * android.net.Uri
 * android.support.annotation.NonNull
 * android.view.LayoutInflater
 * android.view.View
 * android.view.ViewGroup
 * android.widget.AdapterView
 * android.widget.AdapterView.OnItemClickListener
 * android.widget.ArrayAdapter
 * android.widget.ImageView
 * android.widget.ListView
 * android.widget.TextView
 *
 * org.wheatgenetics.about.OtherApps
 * org.wheatgenetics.about.OtherApps.Index
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.Utils
 */

public class OtherAppsAlertDialog extends java.lang.Object
{
    private static class ListView extends android.widget.ListView
    {
        // region Types
        private static class ArrayAdapter extends android.widget.ArrayAdapter<java.lang.String>
        {
            private final org.wheatgenetics.about.OtherApps otherApps;

            ArrayAdapter(final android.content.Context context,
            @android.support.annotation.NonNull org.wheatgenetics.about.OtherApps otherApps)
            {
                super(
                    /* context  => */ context,
                    /* resource => */
                        org.wheatgenetics.androidlibrary.R.layout.other_apps_alert_dialog);

                assert null != otherApps;
                this.otherApps = otherApps;

                this.addAll(this.otherApps.getTexts());
            }

            @java.lang.Override
            public @android.support.annotation.NonNull android.view.View getView(
            final int position, final android.view.View convertView,
            @android.support.annotation.NonNull final android.view.ViewGroup parent)
            {
                android.view.View appView;
                {
                    final android.view.LayoutInflater layoutInflater = (android.view.LayoutInflater)
                        this.getContext().getSystemService(
                            android.content.Context.LAYOUT_INFLATER_SERVICE);
                    assert null != layoutInflater;
                    appView = layoutInflater.inflate(
                        org.wheatgenetics.androidlibrary.R.layout.other_apps_alert_dialog,
                        null, true);
                }
                assert null != appView;
                {
                    final android.widget.TextView textView =
                        (android.widget.TextView) appView.findViewById(
                            org.wheatgenetics.androidlibrary.R.id.otherAppsTextView);
                    assert null != this.otherApps;
                    assert null != textView      ;
                    textView.setText(this.otherApps.getTexts()[position]);
                }
                {
                    final android.widget.ImageView imageView =
                        (android.widget.ImageView) appView.findViewById(
                            org.wheatgenetics.androidlibrary.R.id.otherAppsImageView);
                    assert null != imageView;
                    imageView.setImageResource(this.otherApps.getResIds()[position]);
                }
                return appView;
            }
        }

        private static class OnItemClickListener extends java.lang.Object
        implements android.widget.AdapterView.OnItemClickListener
        {
            // region Fields
            private final android.content.Context           context  ;
            private final org.wheatgenetics.about.OtherApps otherApps;
            // endregion

            OnItemClickListener(
            @android.support.annotation.NonNull final android.content.Context           context  ,
            @android.support.annotation.NonNull final org.wheatgenetics.about.OtherApps otherApps)
            {
                super();

                assert null != context;
                this.context = context;

                assert null != otherApps;
                this.otherApps = otherApps;
            }

            @java.lang.Override
            public void onItemClick(final android.widget.AdapterView<?> parent,
            final android.view.View view, final int position, final long id)
            {
                assert null != this.otherApps;
                assert null != this.context  ;
                this.context.startActivity(new android.content.Intent(
                    android.content.Intent.ACTION_VIEW                       ,
                    android.net.Uri.parse(this.otherApps.getUris()[position])));
            }
        }
        // endregion

        private ListView(final android.content.Context context,
        @android.support.annotation.NonNull org.wheatgenetics.about.OtherApps.Index suppressIndex)
        {
            super(context);

            this.setDivider      (null);
            this.setDividerHeight(   0);

            final org.wheatgenetics.about.OtherApps otherApps =
                new org.wheatgenetics.about.OtherApps(suppressIndex);
            this.setAdapter(new org.wheatgenetics.about.OtherAppsAlertDialog.ListView.ArrayAdapter(
                context, otherApps));
            this.setOnItemClickListener(
                new org.wheatgenetics.about.OtherAppsAlertDialog.ListView.OnItemClickListener(
                    context, otherApps));
        }
    };

    // region Fields
    private final android.content.Context                 context      ;
    private final org.wheatgenetics.about.OtherApps.Index suppressIndex;

    private android.app.AlertDialog.Builder builder     = null;
    private android.app.AlertDialog         alertDialog = null;
    // endregion

    // region Public Methods
    public OtherAppsAlertDialog(
    @android.support.annotation.NonNull final android.content.Context context,
    @android.support.annotation.NonNull
    final org.wheatgenetics.about.OtherApps.Index suppressIndex)
    {
        super();

        assert null != context;
        this.context = context;

        assert null != suppressIndex;
        this.suppressIndex = suppressIndex;
    }

    public void show()
    {
        if (null == this.alertDialog)
        {
            if (null == this.builder)
            {
                this.builder = new android.app.AlertDialog.Builder(this.context);
                this.builder.setCancelable(true)
                    .setTitle(org.wheatgenetics.androidlibrary.R.string.otherAppsAlertDialogTitle)
                    .setView (new org.wheatgenetics.about.OtherAppsAlertDialog.ListView(
                        this.context, this.suppressIndex))
                    .setNegativeButton(org.wheatgenetics.androidlibrary.R.string.okButtonText,
                        org.wheatgenetics.androidlibrary.Utils.dismissingOnClickListener());
            }
            this.alertDialog = this.builder.create();
            assert null != this.alertDialog;
        }
        this.alertDialog.show();
    }
    // endregion
}