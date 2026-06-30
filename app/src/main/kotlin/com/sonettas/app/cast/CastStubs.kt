/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * STUB FILE — Cast feature has been removed from Huasic.
 * These types exist only to keep MusicService.kt compiling during the
 * transitional cleanup period. All operations are no-ops.
 */

package com.sonettas.app.cast

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.session.MediaSession

object CastPlaybackRepositoryLocator {
    fun get(context: Context): CastPlaybackRepository = CastPlaybackRepository()
}

class CastPlaybackRepository {
    fun isCastSessionActive(): Boolean = false
    fun release() {}
}

class CastMediaItemResolver(
    private val resolver: (MediaItem) -> MediaItem = { it },
) {
    fun resolve(item: MediaItem): MediaItem = resolver(item)
}

object CastSessionState {
    const val INACTIVE = 0
    const val ACTIVE = 1
}

class CastMediaSessionCallback : MediaSession.Callback
