package org.phenoapps.fragments.examples

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import org.phenoapps.androidlibrary.R
import org.phenoapps.fragments.toolbar.IndexNavFragment
import org.phenoapps.utils.BaseDocumentTreeUtil
import org.phenoapps.utils.IntentUtil

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class PhenoLibIndexHomeFragment(
    override val navMenuId: Int = R.menu.menu_phenolib_index,
    override val selectedActionId: Int = R.id.index_home_action,
    override val navMap: Map<Int, NavDirections> =
        mapOf(R.id.index_preference_action to PhenoLibIndexHomeFragmentDirections
            .globalActionToPreferencesFragment())
) : IndexNavFragment() {

    override val containedFragment: Fragment = PhenoLibIndexHomeFragment()

    companion object class PhenoLibIndexHomeFragment: Fragment(R.layout.fragment_phenolib_index_home) {

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val bluetoothHardwareButton = view.findViewById<Button>(R.id.frag_main_hardware_bluetooth_btn)
            bluetoothHardwareButton.setOnClickListener {

                findNavController().navigate(PhenoLibIndexHomeFragmentDirections
                    .actionFromIndexToBluetoothHardwareFragment())
            }

            val gattButton = view.findViewById<Button>(R.id.frag_main_hardware_gatt_btn)
            gattButton.setOnClickListener {

                findNavController().navigate(PhenoLibIndexHomeFragmentDirections
                    .actionFromIndexToGattFragment())
            }

            val indigoButton = view.findViewById<Button>(R.id.frag_main_hardware_indigo_btn)
            indigoButton.setOnClickListener {
                findNavController().navigate(PhenoLibIndexHomeFragmentDirections
                    .actionFromIndexToIndigoFragment())
            }

            val shareFileButton = view.findViewById<Button>(R.id.frag_main_intent_share_file_btn)
            shareFileButton.setOnClickListener {
                IntentUtil.appTestShareFile(context)
            }

            val shareFileChooserButton = view.findViewById<Button>(R.id.frag_main_intent_share_file_chooser_btn)
            shareFileChooserButton.setOnClickListener {
                IntentUtil.appTestShareFileChooser(context)
            }

            val locationProvidersButton = view.findViewById<Button>(R.id.frag_main_intent_location_provider_btn)
            locationProvidersButton.setOnClickListener {
                IntentUtil.testSystemLocation(context)
            }

            val bluetoothEnableButton = view.findViewById<Button>(R.id.frag_main_intent_bluetooth_btn)
            bluetoothEnableButton.setOnClickListener {
                IntentUtil.testSystemBluetooth(context)
            }

            val ttsButton = view.findViewById<Button>(R.id.frag_main_tts_btn)
            ttsButton.setOnClickListener {
                findNavController().navigate(PhenoLibIndexHomeFragmentDirections
                    .actionFromIndexToTts())
            }

            val usbCameraButton = view.findViewById<Button>(R.id.frag_main_hardware_usb_camera_btn)
            usbCameraButton.setOnClickListener {
                findNavController().navigate(PhenoLibIndexHomeFragmentDirections
                    .actionFromIndexToUsbCamera())
            }
        }
    }
}