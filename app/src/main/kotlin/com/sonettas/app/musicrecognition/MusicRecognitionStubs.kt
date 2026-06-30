/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * STUB — Music Recognition (Shazam) feature has been removed from Sonettas.
 */

package com.sonettas.app.musicrecognition

import android.content.Context
import android.content.Intent
import android.service.quicksettings.TileService
import androidx.activity.ComponentActivity

const val MusicRecognitionRoute = "music_recognition"
const val ACTION_MUSIC_RECOGNITION = "com.sonettas.app.action.MUSIC_RECOGNITION"

class MusicRecognitionEntryPoint {
    companion object {
        fun launch(activity: ComponentActivity) {}
    }
}

class MusicRecognitionTileService : TileService() {
    override fun onStartListening() {}
    override fun onStopListening() {}
}

/**
 * No-op extension to open music recognition.
 * Returns immediately since feature is removed.
 */
fun openMusicRecognition(context: Context) {
    // Sonettas: Music recognition removed — no-op
}

/**
 * No-op extension to open music recognition from intent.
 */
fun Intent.openMusicRecognition(): Intent = this

