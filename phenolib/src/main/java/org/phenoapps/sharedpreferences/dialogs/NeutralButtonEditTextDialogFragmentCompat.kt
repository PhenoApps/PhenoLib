package org.phenoapps.sharedpreferences.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.preference.PreferenceDialogFragmentCompat
import org.phenoapps.androidlibrary.R

/**
 * Used the same pattern as the NumberPicker preference in FieldBook.
 * This class deals with the dialog ui bound after clicking the NeutralButtonEditText preference.
 * To successfully utilize this class it must be registered as such in the preference fragment:
 *  @Override
    public void onDisplayPreferenceDialog(Preference preference) {

        // check if dialog is already showing
        if (getFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG) != null) {
            return;
        }

        final DialogFragment f;

        if (preference instanceof NeutralButtonEditTextDialog) {
            f = NeutralButtonEditTextDialogFragmentCompat.Companion.newInstance(preference.getKey(), () -> {

                Utils.makeToast(context, "Neutral Pressed!");

                return null;
            }, () -> {

                Utils.makeToast(context, "Positive Pressed!");

                return null;
            }, () -> {

                Utils.makeToast(context, "Negative Pressed!");

                return null;
            });

        } else {
            f = null;
        }

        if (f != null) {
            f.setTargetFragment(this, 0);
            f.show(getFragmentManager(), DIALOG_FRAGMENT_TAG);
        } else {
            super.onDisplayPreferenceDialog(preference);
        }
    }
 *
 *
 * The neutral, positive, and negative button on click listeners are set in the newInstance call as lambdas.
 * They all must return null since the callbacks are defined as () -> Unit in Kotlin.
 *
 * author: Chaney
 * date: 10/28/2021
 */
open class NeutralButtonEditTextDialogFragmentCompat: PreferenceDialogFragmentCompat() {

    private var mEditText: EditText? = null

    private var mNeutralOnClick: ((Dialog?, String) -> Unit)? = null
    private var mPositiveOnClick: ((Dialog?, String) -> Unit)? = null
    private var mNegativeOnClick: ((Dialog?, String) -> Unit)? = null

    override fun onCreateDialogView(context: Context): View? {
        return super.onCreateDialogView(context)
    }

    override fun onBindDialogView(view: View) {
        super.onBindDialogView(view)

        val key = arguments?.getString(ARG_KEY)

        val dialog = preference as NeutralButtonEditTextDialog

        dialog.negativeButtonText = ""
        dialog.positiveButtonText = ""

        mEditText = view.findViewById(R.id.dialog_neutral_button_edit_text_et)

        mEditText?.setText(preference.sharedPreferences?.getString(key, ""))

        view.findViewById<Button>(R.id.dialog_neutral_button_edit_text_neutral_btn)?.let { button ->
            button.text = dialog.mNeutralText
            button.setOnClickListener {
                mNeutralOnClick?.invoke(this@NeutralButtonEditTextDialogFragmentCompat.dialog,
                    mEditText?.text.toString())
            }
        }

        view.findViewById<Button>(R.id.dialog_neutral_button_edit_text_positive_btn)?.let { button ->
            button.text = dialog.mPositiveText
            button.setOnClickListener {
                preference.sharedPreferences?.edit()?.putString(key, mEditText?.text?.toString() ?: "")?.apply()
                mPositiveOnClick?.invoke(this@NeutralButtonEditTextDialogFragmentCompat.dialog,
                    mEditText?.text.toString())
            }
        }

        view.findViewById<Button>(R.id.dialog_neutral_button_edit_text_negative_btn)?.let { button ->
            button.text = dialog.mNegativeText
            button.setOnClickListener {
                mNegativeOnClick?.invoke(this@NeutralButtonEditTextDialogFragmentCompat.dialog,
                    mEditText?.text.toString())
            }
        }
    }

    override fun onDialogClosed(positiveResult: Boolean) {}

    /**
     * On clicks are saved in globals since newInstance is called before binding happens.
     * Left these functions as open in-case this is extended to do something internally.
     */
    open fun setNeutralOnClick(onClick: (Dialog?, String) -> Unit) {
        mNeutralOnClick = onClick
    }

    open fun setPositiveOnClick(onClick: (Dialog?, String) -> Unit) {
        mPositiveOnClick = onClick
    }

    open fun setNegativeOnClick(onClick: (Dialog?, String) -> Unit) {
        mNegativeOnClick = onClick
    }

    companion object {
        fun newInstance(key: String,
                        onNeutralClick: (Dialog?, String) -> Unit,
                        onPositiveClick: (Dialog?, String) -> Unit,
                        onNegativeClick: (Dialog?, String) -> Unit): NeutralButtonEditTextDialogFragmentCompat {

            val fragment = NeutralButtonEditTextDialogFragmentCompat()

            val args = Bundle(1)

            args.putString(ARG_KEY, key)

            fragment.arguments = args

            fragment.setNeutralOnClick(onNeutralClick)
            fragment.setNegativeOnClick(onNegativeClick)
            fragment.setPositiveOnClick(onPositiveClick)

            return fragment
        }
    }
}