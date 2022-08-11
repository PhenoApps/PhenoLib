package org.phenoapps.interfaces.usb.camera

import android.graphics.SurfaceTexture
import android.view.TextureView

interface CameraSurfaceListener: TextureView.SurfaceTextureListener {
    override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int)
    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) = Unit
    override fun onSurfaceTextureDestroyed(surfaceTexture: SurfaceTexture): Boolean = true
    override fun onSurfaceTextureUpdated(surfaceTexture: SurfaceTexture)
}