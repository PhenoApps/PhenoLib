package org.wheatgenetics.androidlibrary;

/**
 * Uses:
 * android.app.Activity
 * android.app.AlertDialog
 * android.app.AlertDialog.Builder
 * android.content.DialogInterface.OnClickListener
 * android.content.DialogInterface.OnMultiChoiceClickListener
 * android.view.LayoutInflater
 * android.view.View
 * android.view.View.OnClickListener
 * android.view.Window
 * android.view.WindowManager.LayoutParams
 * android.widget.LinearLayout
 *
 * androidx.annotation.LayoutRes
 * androidx.annotation.Size
 * androidx.annotation.StringRes
 *
 * org.wheatgenetics.androidlibrary.BuildConfig
 * org.wheatgenetics.androidlibrary.R
 * org.wheatgenetics.androidlibrary.Utils
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
public abstract class AlertDialog extends java.lang.Object
{
    // region Fields
    private final android.app.Activity activityInstance;

    private android.app.AlertDialog.Builder builderInstance                 = null ;
    private android.view.LayoutInflater     layoutInflaterInstance          = null ;
    private android.app.AlertDialog         alertDialog                     = null ;
    private boolean                         positiveOnClickListenerReplaced = false;
    // endregion

    // region Private Methods
    private android.app.AlertDialog.Builder builder()
    {
        if (null == this.builderInstance)
            this.builderInstance = new android.app.AlertDialog.Builder(this.activityInstance);
        return this.builderInstance;
    }

    private void createAlertDialog()
    {
        this.alertDialog = this.builder().create(); assert null != this.alertDialog;
        this.positiveOnClickListenerReplaced = false;
    }

    private void replaceOnClickListener(final int whichButton,
    final android.view.View.OnClickListener onClickListener)
    {
        if (null != this.alertDialog)
            this.alertDialog.getButton(whichButton).setOnClickListener(onClickListener);
    }
    // endregion

    @java.lang.SuppressWarnings({"WeakerAccess", "RedundantSuppression"})
    public AlertDialog(final android.app.Activity activity)
    { super(); this.activityInstance = activity; this.configure(); }

    // region Public Methods
    @java.lang.SuppressWarnings({"WeakerAccess", "RedundantSuppression"})
    public abstract void configure();

    public android.app.Activity activity()
    { assert null != this.activityInstance; return this.activityInstance; }

    @java.lang.SuppressWarnings({"WeakerAccess", "RedundantSuppression"})
    public java.lang.String getString(@androidx.annotation.StringRes final int resId)
    { return this.activity().getString(resId); }

    // region set() Public Methods
    public org.wheatgenetics.androidlibrary.AlertDialog setTitle(final java.lang.String title)
    { this.builder().setTitle(title); return this; }

    public org.wheatgenetics.androidlibrary.AlertDialog setTitle(
    @androidx.annotation.StringRes final int resId)
    { this.builder().setTitle(resId); return this; }

    public org.wheatgenetics.androidlibrary.AlertDialog setCancelableToFalse()
    { this.builder().setCancelable(false); return this; }

    public org.wheatgenetics.androidlibrary.AlertDialog setCancelableToTrue()
    { this.builder().setCancelable(true); return this; }

    @java.lang.SuppressWarnings({"WeakerAccess"})
    public org.wheatgenetics.androidlibrary.AlertDialog setMessage(final java.lang.String message)
    { this.builder().setMessage(message); return this; }

    @java.lang.SuppressWarnings({"unused"})
    public org.wheatgenetics.androidlibrary.AlertDialog setMessage(
    @androidx.annotation.StringRes final int resId)
    { return this.setMessage(this.getString(resId)); }

    @java.lang.SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
    public org.wheatgenetics.androidlibrary.AlertDialog setItems(
    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
        @androidx.annotation.Size(min = 1) final java.lang.String items[],

    final android.content.DialogInterface.OnClickListener onClickListener)
    { this.builder().setItems(items, onClickListener); return this; }

    @java.lang.SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
    public org.wheatgenetics.androidlibrary.AlertDialog setItems(
    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
        @androidx.annotation.Size(min = 1) final int itemIds[],

    final android.content.DialogInterface.OnClickListener onClickListener)
    {
        if (null != itemIds)
        {
            final int itemIdsLength = itemIds.length;
            if (itemIdsLength > 0)
            {
                @java.lang.SuppressWarnings({"Convert2Diamond"})
                final java.util.ArrayList<java.lang.String> arrayList =
                    new java.util.ArrayList<java.lang.String>(itemIdsLength);
                for (@androidx.annotation.StringRes final java.lang.Integer itemId: itemIds)
                    arrayList.add(this.getString(itemId));

                @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
                    final java.lang.String items[] = new java.lang.String[arrayList.size()];
                this.setItems(arrayList.toArray(items), onClickListener);
            }
        }
        return this;
    }

    @java.lang.SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
    public org.wheatgenetics.androidlibrary.AlertDialog setMultiChoiceItems(
    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"})
        @androidx.annotation.Size(min = 1) final java.lang.CharSequence items[],

    @java.lang.SuppressWarnings({"CStyleArrayDeclaration"}) final boolean checkedItems[],

    final android.content.DialogInterface.OnMultiChoiceClickListener listener)
    {
        if (null != items)
        {
            if (org.wheatgenetics.androidlibrary.BuildConfig.DEBUG) if (null != checkedItems)
                if (checkedItems.length != items.length) { throw new java.lang.AssertionError(); }
            this.builder().setMultiChoiceItems(items, checkedItems, listener);
        }
        return this;
    }

    @java.lang.SuppressWarnings({"UnusedReturnValue"})
    public org.wheatgenetics.androidlibrary.AlertDialog setView(final android.view.View view)
    { this.builder().setView(view); return this; }

    public org.wheatgenetics.androidlibrary.AlertDialog setPositiveButton(
    @androidx.annotation.StringRes final int              resId          ,
    final android.content.DialogInterface.OnClickListener onClickListener)
    { this.builder().setPositiveButton(resId, onClickListener); return this; }

    @java.lang.SuppressWarnings({"unused"})
    public org.wheatgenetics.androidlibrary.AlertDialog setPositiveButton(
    @androidx.annotation.StringRes final int resId)
    { return this.setPositiveButton(resId,null); }

    public org.wheatgenetics.androidlibrary.AlertDialog setOKPositiveButton(
    final android.content.DialogInterface.OnClickListener onClickListener)
    {
        return this.setPositiveButton(
            org.wheatgenetics.androidlibrary.R.string.okButtonText, onClickListener);
    }

    @java.lang.SuppressWarnings({"unused"})
    public org.wheatgenetics.androidlibrary.AlertDialog setOKPositiveButton()
    {
        return this.setOKPositiveButton(
            org.wheatgenetics.androidlibrary.Utils.cancellingOnClickListener());
    }

    public org.wheatgenetics.androidlibrary.AlertDialog setNegativeButton(
    @androidx.annotation.StringRes final int              resId          ,
    final android.content.DialogInterface.OnClickListener onClickListener)
    { this.builder().setNegativeButton(resId, onClickListener); return this; }

    @java.lang.SuppressWarnings({"WeakerAccess"})
    public org.wheatgenetics.androidlibrary.AlertDialog setCancelNegativeButton(
    final android.content.DialogInterface.OnClickListener onClickListener)
    {
        return this.setNegativeButton(org.wheatgenetics.androidlibrary.R.string.cancelButtonText,
            onClickListener);
    }

    @java.lang.SuppressWarnings({"UnusedReturnValue"})
    public org.wheatgenetics.androidlibrary.AlertDialog setCancelNegativeButton()
    {
        return this.setCancelNegativeButton(
            org.wheatgenetics.androidlibrary.Utils.cancellingOnClickListener());
    }

    @java.lang.SuppressWarnings({"UnusedReturnValue"})
    public org.wheatgenetics.androidlibrary.AlertDialog setOKNegativeButton()
    {
        return this.setNegativeButton(org.wheatgenetics.androidlibrary.R.string.okButtonText,
            org.wheatgenetics.androidlibrary.Utils.dismissingOnClickListener());
    }

    @java.lang.SuppressWarnings({"WeakerAccess"})
    public org.wheatgenetics.androidlibrary.AlertDialog setNeutralButton(
    @androidx.annotation.StringRes final int              resId          ,
    final android.content.DialogInterface.OnClickListener onClickListener)
    { this.builder().setNeutralButton(resId, onClickListener); return this; }

    @java.lang.SuppressWarnings({"unused"})
    public org.wheatgenetics.androidlibrary.AlertDialog setNeutralButton(
    @androidx.annotation.StringRes final int resId)
    { return this.setNeutralButton(resId,null); }
    // endregion

    // region Inflater Public Methods
    @java.lang.SuppressWarnings({"WeakerAccess"})
    public android.view.LayoutInflater layoutInflater()
    {
        if (null == this.layoutInflaterInstance)
            this.layoutInflaterInstance = this.activity().getLayoutInflater();
        return this.layoutInflaterInstance;
    }

    @java.lang.SuppressWarnings({"unused"}) public android.view.View inflate(
    @androidx.annotation.LayoutRes final int resource)
    {
        return this.layoutInflater().inflate(
            /* resource     => */ resource                                        ,
            /* root         => */ new android.widget.LinearLayout(this.activity()),
            /* attachToRoot => */false);
    }
    // endregion

    // region show() Public Methods
    public void show()
    { if (null == this.alertDialog) this.createAlertDialog(); this.alertDialog.show(); }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public void createShow()
    { this.createAlertDialog(); this.alertDialog.show(); }

    @java.lang.SuppressWarnings({"unused"}) public void createModifyShow()
    {
        this.createAlertDialog();
        {
            final android.view.Window window = this.alertDialog.getWindow();
            if (null != window) window.setSoftInputMode(
                android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        }
        this.alertDialog.show();
    }
    // endregion

    // region showToast() Public Methods
    @java.lang.SuppressWarnings({"WeakerAccess"}) public void showToast(final java.lang.String text)
    { org.wheatgenetics.androidlibrary.Utils.showLongToast(this.activityInstance, text); }

    @java.lang.SuppressWarnings({"WeakerAccess"})
    public void showToast(@androidx.annotation.StringRes final int resId)
    { this.showToast(this.getString(resId)); }
    // endregion

    // region Public Methods Used To Keep Alert Dialog From Dismissing
    @java.lang.SuppressWarnings({"WeakerAccess", "BooleanMethodIsAlwaysInverted"})
    public boolean positiveOnClickListenerHasBeenReplaced()
    { return this.positiveOnClickListenerReplaced; }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public void replacePositiveOnClickListener(
    final android.view.View.OnClickListener onClickListener)
    {
        if (null != this.alertDialog)
        {
            this.replaceOnClickListener(android.app.AlertDialog.BUTTON_POSITIVE, onClickListener);
            this.positiveOnClickListenerReplaced = true;
        }
    }

    @java.lang.SuppressWarnings({"unused"}) public void replaceNeutralOnClickListener(
    final android.view.View.OnClickListener onClickListener)
    { this.replaceOnClickListener(android.app.AlertDialog.BUTTON_NEUTRAL, onClickListener); }

    @java.lang.SuppressWarnings({"WeakerAccess"}) public void cancelAlertDialog()
    { if (null != this.alertDialog) this.alertDialog.cancel(); }
    // endregion
    // endregion
}