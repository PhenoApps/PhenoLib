package org.wheatgenetics.about;

/**
 * Uses:
 * android.app.AlertDialog
 * android.app.AlertDialog.Builder
 * android.content.Context
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
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.Utils
 */

public class OtherAppsAlertDialog extends java.lang.Object
{
    public interface Handler { public abstract void handleItemClick(java.lang.String uriString); }

    private static class ListView extends android.widget.ListView
    {
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
                    assert null != this.otherApps;
                    assert null != imageView     ;
                    imageView.setImageResource(this.otherApps.getResIds()[position]);
                }
                return appView;
            }
        }

        private static class OnItemClickListener extends java.lang.Object
        implements android.widget.AdapterView.OnItemClickListener
        {
            private final org.wheatgenetics.about.OtherApps                    otherApps;
            private final org.wheatgenetics.about.OtherAppsAlertDialog.Handler handler  ;

            OnItemClickListener(@android.support.annotation.NonNull
                final org.wheatgenetics.about.OtherAppsAlertDialog.Handler handler,
            @android.support.annotation.NonNull org.wheatgenetics.about.OtherApps otherApps)
            {
                super();

                assert null != otherApps;
                this.otherApps = otherApps;

                assert null != handler;
                this.handler = handler;
            }

            @java.lang.Override
            public void onItemClick(final android.widget.AdapterView<?> parent,
            final android.view.View view, final int position, final long id)
            {
                assert null != this.handler;
                this.handler.handleItemClick(this.otherApps.getUris()[position]);
            }
        }

        public ListView(final android.content.Context context,
        @android.support.annotation.NonNull org.wheatgenetics.about.OtherApps otherApps,
        @android.support.annotation.NonNull
            final org.wheatgenetics.about.OtherAppsAlertDialog.Handler handler)
        {
            super(context);

            this.setDivider      (null);
            this.setDividerHeight(   0);
            this.setAdapter(new org.wheatgenetics.about.OtherAppsAlertDialog.ListView.ArrayAdapter(
                context, otherApps));
            this.setOnItemClickListener(
                new org.wheatgenetics.about.OtherAppsAlertDialog.ListView.OnItemClickListener(
                    handler, otherApps));
        }
    };

    private final android.content.Context                              context  ;
    private final org.wheatgenetics.about.OtherApps                    otherApps;
    private final org.wheatgenetics.about.OtherAppsAlertDialog.Handler handler  ;

    private android.app.AlertDialog.Builder builder     = null;
    private android.app.AlertDialog         alertDialog = null;

    public OtherAppsAlertDialog(
    @android.support.annotation.NonNull final android.content.Context           context  ,
    @android.support.annotation.NonNull final org.wheatgenetics.about.OtherApps otherApps,
    @android.support.annotation.NonNull
        final org.wheatgenetics.about.OtherAppsAlertDialog.Handler handler)
    {
        super();

        assert null != context;
        this.context = context;

        assert null != otherApps;
        this.otherApps = otherApps;

        assert null != handler;
        this.handler = handler;
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
                        this.context, this.otherApps, this.handler))
                    .setNegativeButton(org.wheatgenetics.androidlibrary.R.string.okButtonText,
                        org.wheatgenetics.androidlibrary.Utils.dismissingOnClickListener());
            }
            this.alertDialog = this.builder.create();
            assert null != this.alertDialog;
        }
        this.alertDialog.show();
    }
}