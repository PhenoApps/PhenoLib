package org.wheatgenetics.brapi1_3;

/**
 * Uses:
 * android.app.Activity
 * android.content.DialogInterface
 * android.content.DialogInterface.OnClickListener
 * android.support.annotation.RestrictTo
 * android.support.annotation.RestrictTo.Scope
 * android.text.Editable
 * android.widget.EditText
 *
 * org.wheatgenetics.androidlibrary.AlertDialog
 */
public abstract class AlertDialog extends org.wheatgenetics.androidlibrary.AlertDialog
{
    @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) public interface Handler
    { public abstract void handleDone(); }

    private final org.wheatgenetics.brapi1_3.AlertDialog.Handler handler;

    private static java.util.ArrayList<java.lang.String> arrayList(
    final java.util.ArrayList<java.lang.String> arrayList)
    { return null == arrayList ? new java.util.ArrayList<java.lang.String>() : arrayList; }

    // region Protected Methods
    // region setEditTextText() Protected Methods
    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    protected static void setEditTextText(final android.widget.EditText editText,
    final java.lang.String text) { if (null != editText) editText.setText(text); }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"}) protected static void setEditTextText(
    final android.widget.EditText editText, final java.lang.Integer text)
    {
        org.wheatgenetics.brapi1_3.AlertDialog.setEditTextText(
            editText, null == text ? null : text.toString());
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
    @java.lang.SuppressWarnings({"WeakerAccess"})
    protected static java.lang.Integer getEditTextIntText(final android.widget.EditText editText)
    {
        final java.lang.String stringText =
            org.wheatgenetics.brapi1_3.AlertDialog.getEditTextStringText(editText);
        return null == stringText ? null : java.lang.Integer.valueOf(stringText);
    }

    @android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.SuppressWarnings({"WeakerAccess"})
    protected static java.util.ArrayList<java.lang.String> getEditTextStringListText(
    final android.widget.EditText editText)
    {
        final java.lang.String stringText =
            org.wheatgenetics.brapi1_3.AlertDialog.getEditTextStringText(editText);
        if (null == stringText)
            return null;
        else
        {
            @java.lang.SuppressWarnings({"Convert2Diamond"})
            java.util.ArrayList<java.lang.String> arrayList = null;
            {
                      int endIndex      = stringText.indexOf('\n');
                final int notFoundIndex = -1                      ;
                if (endIndex == notFoundIndex)
                {
                    // noinspection ConstantConditions
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
                        beginIndex = endIndex + 1                            ;
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
    protected void handlePositiveButtonClick()
    { if (null != this.handler) this.handler.handleDone(); }
    // endregion

    @java.lang.SuppressWarnings({"WeakerAccess"}) public AlertDialog(
    final android.app.Activity                           activity,
    final org.wheatgenetics.brapi1_3.AlertDialog.Handler handler )
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