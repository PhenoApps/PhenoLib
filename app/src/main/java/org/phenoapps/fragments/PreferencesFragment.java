package org.phenoapps.fragments;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import org.phenoapps.androidlibrarybuilder.R;
import org.phenoapps.sharedpreferences.dialogs.NeutralButtonEditTextDialog;
import org.phenoapps.sharedpreferences.dialogs.NeutralButtonEditTextDialogFragmentCompat;

public class PreferencesFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener {

    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    PreferenceManager prefMgr;
    Context context;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("Settings");

        setPreferencesFromResource(R.xml.preferences, rootKey);
        PreferenceManager.setDefaultValues(getActivity(), R.xml.preferences, true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Occurs before the on create function. We get the context this way.
        PreferencesFragment.this.context = context;
    }

    @Override
    public void onDisplayPreferenceDialog(Preference preference) {
        // check if dialog is already showing
        if (getFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG) != null) {
            return;
        }

        final DialogFragment f;

        if (preference instanceof NeutralButtonEditTextDialog) {
            f = NeutralButtonEditTextDialogFragmentCompat.Companion.newInstance(preference.getKey(), (dialog, text) -> {

                Toast.makeText(context, "Neutral Pressed!", Toast.LENGTH_SHORT).show();

                if (dialog != null)
                    dialog.dismiss();

                return null;
            }, (dialog, text) -> {

                Toast.makeText(context, "Positive Pressed!", Toast.LENGTH_SHORT).show();

                if (dialog != null)
                    dialog.dismiss();

                return null;
            }, (dialog, text) -> {

                Toast.makeText(context, "Negative Pressed!", Toast.LENGTH_SHORT).show();

                if (dialog != null)
                    dialog.dismiss();

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

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        return false;
    }
}