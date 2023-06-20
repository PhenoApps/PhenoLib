package org.phenoapps.fragments.gopro

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGatt
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.*
import android.net.wifi.WifiConfiguration
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSource
import kotlinx.coroutines.*
import okhttp3.*
import org.phenoapps.androidlibrary.R
import org.phenoapps.interfaces.gatt.GattCallbackInterface
import org.phenoapps.security.Security
import java.io.File
import java.io.FileOutputStream
import java.util.*

/**
 * References:
 * https://gopro.github.io/OpenGoPro/
 * https://github.com/sepp89117/GoEasyPro_Android
 * https://github.com/KonradIT/goprowifihack
 */
@RequiresApi(Build.VERSION_CODES.Q)
class GoProFragment: Fragment(R.layout.go_pro_fragment),
    GattCallbackInterface,
    GoProHelper.OnGoProStreamReady,
    GoProGatt.GoProGattController,
    CoroutineScope by MainScope() {

    companion object {
        const val TAG = "GoProFragment"

        //https://gopro.github.io/OpenGoPro/http_2_0#keep-alive
        const val KEEP_ALIVE_MESSAGE_INTERVAL = 3000L
    }

    private var networkJob: Job? = null

    private val goProGatt by lazy { GoProGatt(this) }

    //ui components
    private lateinit var playerView: StyledPlayerView
    private lateinit var toolbar: Toolbar
    //buttons
    private lateinit var connectButton: Button
    private lateinit var previewButton: Button
    private lateinit var shutterButton: Button
    private lateinit var wifiButton: Button

    //awaiting flag
    private var isAwaitingAp = false

    private var player: ExoPlayer? = null
    private var streamStarted = false

    private val advisor by Security().secureBluetooth()

    private lateinit var goProHelper: GoProHelper

    override fun onAttach(context: Context) {
        super.onAttach(context)
        goProHelper = GoProHelper(context, this)
    }

    private fun initializeConnectButton() {

        //reset ui component states
        player?.clearMediaItems()
        player?.clearVideoSurface()
        player = null
        playerView.player = null

        connectButton.text = "Connect"

        //buttons other than connect are gone until feature is available
        previewButton.visibility = View.GONE
        wifiButton.visibility = View.GONE
        shutterButton.visibility = View.GONE

        //reset global flags
        //this.wifiBound = false
        this.streamStarted = false

        //start connection flow when button is pressed
        connectButton.setOnClickListener {

            connect()
        }
    }

    private fun connect() {

        //ensure bluetooth is enabled
        advisor.discoverWith { adapter ->

            if (!goProHelper.isBluetoothEnabled(adapter)) {

                //if not enabled, start intent for settings
                context?.startActivity(
                    Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE))

            } else {

                activity?.let { act ->

                    //start discovering and find a go pro device
                    adapter.startDiscovery()

                    //search for go pro device
                    goProHelper.scanForGoPros(act) { selectedDevice ->

                        if (selectedDevice == null) {

                            Toast.makeText(context, "Device was not selected.", Toast.LENGTH_LONG).show()

                        } else {

                            goProHelper.connectToGoPro(selectedDevice, goProGatt.callback)

                            adapter.cancelDiscovery()

                            connectButton.text = "Disconnect"

                            connectButton.setOnClickListener {

                                clearResources()

                                initializeConnectButton()

                            }

                            //initializeShutterButton()
                            //initializeApButton()
                        }
                    }
                }
            }
        }
    }

    private fun initializeApButton() {

        wifiButton.text = "Start AP"

        wifiButton.visibility = View.VISIBLE

        isAwaitingAp = false

        wifiButton.setOnClickListener {

            if (goProGatt.bssid == null) {

                Toast.makeText(requireContext(), "Waiting for GoPro BSSID...", Toast.LENGTH_LONG).show()

            }

            goProGatt.bssid?.let { bssid ->

                goProGatt.enableAp()

                goProHelper.awaitGoProAp(goProGatt.ssid, goProGatt.password, bssid) {

                    activity?.runOnUiThread {

                        initializePreviewButton()

                    }
                }

                isAwaitingAp = true

                wifiButton.text = "Stop AP"

                wifiButton.setOnClickListener {

                    stopAp()

                    initializeApButton()
                }
            }

        }
    }

    private fun initializeCameraShutterButton() {

        shutterButton.text = "Shutter On"

        shutterButton.visibility = View.VISIBLE

        shutterButton.setOnClickListener {

            goProGatt.shutterOn()

            Handler(Looper.getMainLooper()).postDelayed({

                goProHelper.queryMedia()

            }, 3000)

//            shutterButton.text = "Shutter Off"
//
//            shutterButton.setOnClickListener {
//
//                goProGatt.shutterOff()
//
//                initializeCameraShutterButton()
//
//                //when shutter is turned off, access media list if wifi is enabled to find new file
//                //goProHelper.queryMedia()
//            }
        }
    }

    //initialize camera control buttons
    private fun initializePreviewButton() {

        previewButton.text = "Start Preview"

        previewButton.visibility = View.VISIBLE

        previewButton.setOnClickListener {

            goProHelper.requestStream()

            previewButton.text = "Stop Preview"

            //createPlayer()

            previewButton.setOnClickListener {

                initializePreviewButton()

                playerView.player?.stop()
            }
        }
    }

    private fun initializeShutterButton() {

        shutterButton.text = "Shutter On"

        shutterButton.visibility = View.VISIBLE

        shutterButton.setOnClickListener {

            goProGatt.shutterOn()

//            shutterButton.text = "Shutter Off"
//
//            shutterButton.setOnClickListener {
//
//                goProGatt.shutterOff()
//
//                initializeShutterButton()
//            }
        }
    }

    private fun clearResources() {

        stopAp()

        //cancel coroutine jobs
        networkJob?.cancel()

        if (player != null) {
            player!!.stop()
            player!!.release()
        }

        //player = null

        goProGatt.clear()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //intialize ui components
        shutterButton = view.findViewById(R.id.go_pro_shutter_btn)
        connectButton = view.findViewById(R.id.go_pro_connect_btn)
        playerView = view.findViewById(R.id.player_view)
        toolbar = view.findViewById(R.id.go_pro_tb)
        previewButton = view.findViewById(R.id.go_pro_preview_btn)
        wifiButton = view.findViewById(R.id.go_pro_ap_btn)

        initializeConnectButton()
        initializeNetworkWatcher()
        initializeToolbar()
    }

    private fun setToolbarConnectionStatus(status: Boolean) {

        toolbar.menu.findItem(R.id.action_go_pro_wifi_connected).setIcon(
            if (status) R.drawable.wifi else R.drawable.wifi_strength_off)

    }

    private fun initializeToolbar() {

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_go_pro_wifi_connected -> {
                    toolbar.menu.findItem(R.id.action_go_pro_wifi_connected).setIcon(R.drawable.wifi_strength_off)
                   true
                }
                else -> false
            }
        }
    }

    //use coroutine to constantly monitor available networks
    //if the saved go pro network exists, don't try to start AP mode
    private fun initializeNetworkWatcher() {

        networkJob?.cancel()

        networkJob = launch {

            withContext(Dispatchers.IO) {

                goProHelper.wifiManager.startScan()

                do {

                    val scanResults = goProHelper.wifiManager.scanResults

                    val goProNetwork = scanResults.find { it.SSID == goProGatt.ssid }

                    //check if job was canceled
                    ensureActive()

                    activity?.runOnUiThread {

                        val networkAvailable = goProNetwork != null

                        setToolbarConnectionStatus(networkAvailable)

                        Log.d(TAG, goProNetwork.toString())
                    }

                    delay(5000)

                } while (true)
            }
        }
    }

    private fun createPlayer() {

        var ffmpeg_output_uri = "udp://@localhost:8555"

        //Max. Buffer: The maximum duration, in milliseconds, of the media the player is attempting to buffer. Once the buffer reaches Max Buffer, it will stop filling it up.
        //min Buffer: The minimum length of media that the player will ensure is buffered at all times, in milliseconds.
        //Playback Buffer: The default amount of time, in milliseconds, of media that needs to be buffered in order for playback to start or resume after a user action such as a seek.
        //Buffer for playback after rebuffer: The duration of the media that needs to be buffered in order for playback to continue after a rebuffer, in milliseconds.

        val loadControl: DefaultLoadControl = DefaultLoadControl.Builder()
            .setPrioritizeTimeOverSizeThresholds(true)
            .setBufferDurationsMs(500, 1000, 500, 500)
            .build()

        val trackSelector: TrackSelector = DefaultTrackSelector(requireContext())
        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(DefaultDataSource.Factory(requireContext())).createMediaSource(
            MediaItem.fromUri(
                Uri.parse(ffmpeg_output_uri)
            )
        )

        player?.stop()
        player?.release()

        player = ExoPlayer.Builder(requireContext())
            .setTrackSelector(trackSelector)
            .setLoadControl(loadControl)
            .build()

        playerView.player = player.also {
            it?.addListener(playerListener)
            it?.setMediaSource(mediaSource)
            it?.playWhenReady = true
            it?.prepare()
        }

        playerView.requestFocus()

        Log.i(TAG, "Player created")
    }

    private val playerListener: Player.Listener = object : Player.Listener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            super.onPlaybackStateChanged(playbackState)
            when (playbackState) {
                Player.STATE_IDLE, Player.STATE_ENDED -> Log.d(TAG, "Player Idle/Ended")//findNavController().navigateUp() //this@PreviewActivity.finish()
                Player.STATE_BUFFERING -> if (!streamStarted) {
                    Log.d(TAG, "Player Buffering")
                    Log.d(TAG, "Requesting start stream.")
                    streamStarted = true
                    goProHelper.requestStream()
                }
                Player.STATE_READY -> {
                    Log.d(TAG, "Player Ready")
                }
            }
        }
    }

    private fun stopAp() {

        previewButton.text = "Start Preview"

        previewButton.visibility = View.GONE

        //todo stop stream needed?
        goProHelper.stopStream()

        playerView.player?.stop()
        playerView.player?.release()

        goProGatt.disableAp()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        clearResources()
        goProHelper.onDestroy()
    }

    override fun onStreamReady() {

        Log.d(TAG, "Stream ready")

        activity?.runOnUiThread {

            createPlayer()

        }
        //initializePreviewButton()
    }

    override fun onImageRequestReady(bitmap: Bitmap, data: Map<String, String>) {

        val f = File(requireContext().externalCacheDir, "temp.jpg")

        val uri = FileProvider.getUriForFile(requireContext(), "org.phenoapps.phenolib.provider", f)

        context?.contentResolver?.openOutputStream(uri)?.use { output ->

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, output)

        }

        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(uri, "image/jpeg")
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(intent)

    }

    //use clicked the start ap button, and char was written
    override fun onApRequested() {

        activity?.runOnUiThread {

            initializePreviewButton()
        }
    }

    override fun onCredentialsAcquired() {

        //make sure system wifi is enabled
        if (!goProHelper.checkWifiEnabled()) {

            goProHelper.enableWifi()

        }

        activity?.runOnUiThread {

            initializeApButton()

            initializeCameraShutterButton()

        }
    }

    override fun onModelId(modelID: Int) {}

    override fun onModelName(modelName: String) {}

    override fun onBoardType(boardType: String) {}

    override fun onFirmware(firmware: String) {}

    override fun onSerialNumber(serialNumber: String) {}

    override fun onSsid(wifiSSID: String) {}

    override fun onBssid(wifiBSSID: String) {}
}