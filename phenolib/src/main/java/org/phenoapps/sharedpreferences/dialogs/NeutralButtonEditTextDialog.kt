package org.phenoapps.sharedpreferences.dialogs

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import androidx.preference.DialogPreference
import androidx.preference.PreferenceViewHolder
import org.phenoapps.androidlibrary.R

/**
 * A replacement for EditTextPreference that also includes a neutral button.
 *
 * Current class defines the xml/widget code, where the fragment code is NeutralButtonEditTextDialogFragmentCompat.
 *
 * This class sets the dialog layout xml in init, sets the default neg/pos button text to empty.
 * This class also parses the attribute for settings neg/pos/neutral texts from styleable attrs/NeutralButtonEditTextDialog
 *
 * Current attributes are strings:
 *  neutralButtonText
 *  positiveButtonText
 *  negativeButtonText
 *
 * author: Chaney
 * date: 10/28/2021
 */
open class NeutralButtonEditTextDialog : DialogPreference {

    var mNeutralText: String? = null
    var mPositiveText: String? = null
    var mNegativeText: String? = null

    init {

        //set the dialog layout resource which defines the et, and three buttons in a constraint layout
        dialogLayoutResource = R.layout.dialog_neutral_button_edit_text_preference

        //the actual preference list item can have a custom view too using widgetLayoutResource
        //widgetLayoutResource

        //defaults the button text to empty for all buttons
        mNeutralText = ""
        mPositiveText = ""
        mNegativeText = ""

        //these are the inherited dialog preference buttons, AOSP didn't include a neutral button
        negativeButtonText = ""
        positiveButtonText = ""
    }

    constructor(ctx: Context): this(ctx, null)
    constructor(ctx: Context, attributeSet: AttributeSet?): super(ctx, attributeSet) {

        //parse attributes and set to global fields, these are used in frag compat to populate the dialog fragment ui
        attributeSet?.let { attrs ->
            val styled = ctx.obtainStyledAttributes(attrs, R.styleable.NeutralButtonEditTextDialog)

            mNeutralText = styled.getString(R.styleable.NeutralButtonEditTextDialog_neutralButtonText)
            mPositiveText = styled.getString(R.styleable.NeutralButtonEditTextDialog_positiveButtonText)
            mNegativeText = styled.getString(R.styleable.NeutralButtonEditTextDialog_negativeButtonText)

            styled.recycle()
        }
    }

    open fun getText() = getPersistedString("")

    open fun setText(text: String) {
        persistString(text)
    }
}