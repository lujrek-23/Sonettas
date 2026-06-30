/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.ui.menu

import com.sonettas.app.db.entities.PlaylistSongMap
import moe.rukamori.archivetune.innertube.YouTube

suspend fun removeSongFromRemotePlaylist(
    playlistBrowseId: String,
    playlistSongMap: PlaylistSongMap,
): Result<Unit> =
    runCatching {
        val setVideoIds =
            playlistSongMap.setVideoId?.let(::listOf)
                ?: YouTube.playlistEntrySetVideoIds(playlistBrowseId, playlistSongMap.songId).getOrThrow()

        setVideoIds
            .distinct()
            .forEach { setVideoId ->
                YouTube.removeFromPlaylist(playlistBrowseId, playlistSongMap.songId, setVideoId).getOrThrow()
            }
    }
