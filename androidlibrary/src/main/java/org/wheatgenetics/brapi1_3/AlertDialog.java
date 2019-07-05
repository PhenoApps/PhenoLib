package org.wheatgenetics.brapi1_3;

/**
 * Uses:
 * android.app.Activity
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.text.Editable
 * android.util.Log
 * android.widget.EditText
 *
 * org.threeten.bp.Instant
 * org.threeten.bp.OffsetDateTime
 * org.threeten.bp.ZoneOffset
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 */
public abstract class AlertDialog extends org.wheatgenetics.androidlibrary.AlertDialog
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Handler
    { public abstract void handleDone(); }

    private final org.wheatgenetics.brapi1_3.AlertDialog.Handler handler;

    // region Private Methods
    private static void log(final java.lang.String msg)
    { android.util.Log.i("brapi1_3.AlertDialog", null == msg ? "null" : msg); }

    private static java.util.ArrayList<java.lang.String> arrayList(
    final java.util.ArrayList<java.lang.String> arrayList)
    { return null == arrayList ? new java.util.ArrayList<java.lang.String>() : arrayList; }
    // endregion

    // region Protected Methods
    // region setEditTextText() Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected static void setEditTextText(final android.widget.EditText editText,
    final java.lang.String text) { if (null != editText) editText.setText(text); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected static void setEditTextText(
    final android.widget.EditText editText, final java.lang.Integer text)
    {
        org.wheatgenetics.brapi1_3.AlertDialog.setEditTextText(
            editText, null == text ? null : text.toString());
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected static void setEditTextText(
    final android.widget.EditText editText, final org.threeten.bp.OffsetDateTime text)
    {
        final java.lang.String offsetDateTimeText = null == text ? null : text.toString();
        org.wheatgenetics.brapi1_3.AlertDialog.log            (          offsetDateTimeText);
        org.wheatgenetics.brapi1_3.AlertDialog.setEditTextText(editText, offsetDateTimeText);
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected static void setEditTextText(final android.widget.EditText editText,
    final java.util.List<java.lang.String> text)
    {
        if (null == text)
            org.wheatgenetics.brapi1_3.AlertDialog.setEditTextText(
                editText, (java.lang.String) null);
        else
        {
            final int listSize = text.size();
            if (listSize <= 0)
                org.wheatgenetics.brapi1_3.AlertDialog.setEditTextText(
                    editText, (java.lang.String) null);
            else
            {
                final java.lang.String firstElement;
                {
                    final int firstIndex = 0;
                    firstElement = text.get(firstIndex);
                }
                if (1 == listSize)
                    org.wheatgenetics.brapi1_3.AlertDialog.setEditTextText(editText, firstElement);
                else
                {
                    final java.lang.StringBuilder stringBuilder =
                        new java.lang.StringBuilder(firstElement);
                    {
                        final int secondIndex = 1, lastIndex = listSize - 1;
                        for (int i = secondIndex; i <= lastIndex; i++)
                            stringBuilder.append('\n').append(text.get(i));
                    }
                    org.wheatgenetics.brapi1_3.AlertDialog.setEditTextText(
                        editText, stringBuilder.toString());
                }
            }
        }
    }
    // endregion

    // region getEditTextText() Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected static java.lang.String getEditTextStringText(final android.widget.EditText editText)
    {
        if (null == editText)
            return null;
        else
        {
            final android.text.Editable editable = editText.getText();
            if (null == editable)
                return null;
            else
            {
                java.lang.String stringText = editable.toString();
                if (stringText.equals(""))
                    return null;
                else
                {
                    stringText = stringText.trim();
                    return stringText.equals("") ? null : stringText;
                }
            }
        }
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected static java.lang.Integer getEditTextIntText(final android.widget.EditText editText)
    {
        final java.lang.String stringText =
            org.wheatgenetics.brapi1_3.AlertDialog.getEditTextStringText(editText);
        return null == stringText ? null : java.lang.Integer.valueOf(stringText);
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected static org.threeten.bp.OffsetDateTime getEditTextTimeStampText
    (final android.widget.EditText editText)
    {
        final org.threeten.bp.OffsetDateTime result;
        {
            final java.lang.String stringText =
                org.wheatgenetics.brapi1_3.AlertDialog.getEditTextStringText(editText);
            result = null == stringText ? null : org.threeten.bp.OffsetDateTime.ofInstant(
                org.threeten.bp.Instant.parse(stringText), org.threeten.bp.ZoneOffset.UTC);
        }
        org.wheatgenetics.brapi1_3.AlertDialog.log(null == result ? null : result.toString());
        return result;
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected static java.util.ArrayList<java.lang.String> getEditTextStringListText(
    final android.widget.EditText editText)
    {
        final java.lang.String stringText =
            org.wheatgenetics.brapi1_3.AlertDialog.getEditTextStringText(editText);
        if (null == stringText)
            return null;
        else
        {
            java.util.ArrayList<java.lang.String> arrayList = null;
            {
                      int endIndex      = stringText.indexOf('\n');
                final int notFoundIndex = -1                      ;
                if (endIndex == notFoundIndex)
                {
                    arrayList = org.wheatgenetics.brapi1_3.AlertDialog.arrayList(arrayList);
                    arrayList.add(stringText);
                }
                else
                {
                    int beginIndex = 0;
                    do
                    {
                        final java.lang.String substring;
                        try { substring = stringText.substring(beginIndex, endIndex); }
                        catch (final java.lang.IndexOutOfBoundsException e) { break; }
                        if (substring.length() > 0)
                        {
                            arrayList = org.wheatgenetics.brapi1_3.AlertDialog.arrayList(arrayList);
                            arrayList.add(substring);
                        }
                        beginIndex = endIndex + 1;
                        endIndex   = stringText.indexOf('\n', beginIndex);
                        if (endIndex == notFoundIndex) endIndex = stringText.length();
                    }
                    while (true);
                }
            }
            return arrayList;
        }
    }
    // endregion

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected org.wheatgenetics.brapi1_3.AlertDialog.Handler getHandler() { return this.handler; }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected void handlePositiveButtonClick()
    {
        final org.wheatgenetics.brapi1_3.AlertDialog.Handler handler = this.getHandler();
        if (null != handler) handler.handleDone();
    }
    // endregion

    public AlertDialog(final android.app.Activity activity,
    final org.wheatgenetics.brapi1_3.AlertDialog.Handler handler)
    { super(activity); this.handler = handler; }

    @java.lang.Override public void configure()
    {
        this.setOKPositiveButton(new android.content.DialogInterface.OnClickListener()
            {
                @java.lang.Override
                public void onClick(final android.content.DialogInterface dialog, final int which)
                { org.wheatgenetics.brapi1_3.AlertDialog.this.handlePositiveButtonClick(); }
            }).setCancelNegativeButton();
    }
}