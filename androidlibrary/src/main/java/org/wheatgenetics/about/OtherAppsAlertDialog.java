package org.wheatgenetics.about;

/**
 * Uses:
 * android.app.Activity
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
 * org.wheatgenetics.androidlibrary.AlertDialog
 * org.wheatgenetics.androidlibrary.R
 *
 * org.wheatgenetics.about.OtherApps
 * org.wheatgenetics.about.OtherApps.Index
 */
public class OtherAppsAlertDialog extends org.wheatgenetics.androidlibrary.AlertDialog
{
    public OtherAppsAlertDialog(
    @android.support.annotation.NonNull final android.app.Activity activity,
    @android.support.annotation.NonNull
        final org.wheatgenetics.about.OtherApps.Index suppressIndex)
    {
        super(activity);

        @java.lang.SuppressWarnings({"ViewConstructor"})
        class ListView extends android.widget.ListView
        {
            private ListView(final android.content.Context context,
            @android.support.annotation.NonNull
                final org.wheatgenetics.about.OtherApps.Index suppressIndex)
            {
                super(context); this.setDivider(null); this.setDividerHeight(0);

                final org.wheatgenetics.about.OtherApps otherApps =
                    new org.wheatgenetics.about.OtherApps(suppressIndex);

                {
                    class ArrayAdapter extends android.widget.ArrayAdapter<java.lang.String>
                    {
                        private final org.wheatgenetics.about.OtherApps otherApps;

                        private ArrayAdapter(final android.content.Context context,
                        @android.support.annotation.NonNull
                            final org.wheatgenetics.about.OtherApps otherApps)
                        {
                            super(
                                /* context  => */ context,
                                /* resource => */ org.wheatgenetics.androidlibrary
                                    .R.layout.alert_dialog_other_apps);

                            this.otherApps = otherApps;
                            this.addAll(this.otherApps.getTexts());
                        }

                        @android.annotation.SuppressLint({"InflateParams", "ViewHolder"})
                        @java.lang.Override
                        public @android.support.annotation.NonNull android.view.View
                        getView(final int position, final android.view.View convertView,
                        @android.support.annotation.NonNull final android.view.ViewGroup parent)
                        {
                            final android.view.View result;
                            {
                                final android.view.LayoutInflater layoutInflater =
                                    (android.view.LayoutInflater)
                                        this.getContext().getSystemService(
                                            android.content.Context.LAYOUT_INFLATER_SERVICE);
                                assert null != layoutInflater;
                                result = layoutInflater.inflate(org.wheatgenetics.
                                        androidlibrary.R.layout.alert_dialog_other_apps,
                                    null,true);
                            }
                            assert null != result;
                            {
                                final android.widget.TextView textView = result.findViewById(
                                    org.wheatgenetics.androidlibrary.R.id.otherAppsTextView);
                                assert null != this.otherApps; assert null != textView;
                                textView.setText(this.otherApps.getTexts()[position]);
                            }
                            {
                                final android.widget.ImageView imageView = result.findViewById(
                                    org.wheatgenetics.androidlibrary.R.id.otherAppsImageView);
                                assert null != imageView; imageView.setImageResource(
                                    this.otherApps.getResIds()[position]);
                            }
                            return result;
                        }
                    }
                    this.setAdapter(new ArrayAdapter(context, otherApps));
                }

                @java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
                class OnItemClickListener extends java.lang.Object
                implements android.widget.AdapterView.OnItemClickListener
                {
                    // region Fields
                    private final android.content.Context           context  ;
                    private final org.wheatgenetics.about.OtherApps otherApps;
                    // endregion

                    private OnItemClickListener(@android.support.annotation.NonNull
                        final android.content.Context context,
                    @android.support.annotation.NonNull
                        final org.wheatgenetics.about.OtherApps otherApps)
                    { super(); this.context = context; this.otherApps = otherApps; }

                    @java.lang.Override public void onItemClick(
                    final android.widget.AdapterView<?> parent, final android.view.View view,
                    final int position, final long id)
                    {
                        assert null != this.otherApps; assert null != this.context;
                        this.context.startActivity(new android.content.Intent(
                            android.content.Intent.ACTION_VIEW                       ,
                            android.net.Uri.parse(this.otherApps.getUris()[position])));
                    }
                }
                this.setOnItemClickListener(new OnItemClickListener(context, otherApps));
            }
        }
        this.setView(new ListView(this.activity(), suppressIndex));
    }

    @java.lang.Override public void configure()
    {
        this.setTitle(org.wheatgenetics.androidlibrary.R.string.otherAppsAlertDialogTitle)
            .setCancelableToTrue().setOKNegativeButton();
    }
}