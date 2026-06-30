/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Stub — Hi-Res Lossless playback resolver disabled.
 * External audio query (Bandcamp/SoundCloud) was removed.
 */

package com.sonettas.app.playback

import com.sonettas.app.utils.YTPlayerUtils

object HiResLosslessPlaybackResolver {
    data class TrackIdentity(
        val title: String,
        val artists: List<String>,
        val durationSeconds: Int?,
    )

    fun resolve(identity: TrackIdentity): Result<YTPlayerUtils.PlaybackData> =
        Result.failure(UnsupportedOperationException("Hi-Res Lossless resolver not available in Huasic"))
}
