/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * STUB — Spotify feature has been removed from Huasic.
 */

package com.sonettas.app.spotify

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class SpotifyPlaylist(
    val id: String,
    val name: String,
    val description: String? = null,
    val tracks: SpotifyPlaylistTracks? = null,
    val images: List<SpotifyImage> = emptyList(),
)

data class SpotifyPlaylistTracks(val total: Int = 0)
data class SpotifyImage(val url: String)

object SpotifyMapper {
    fun getPlaylistThumbnail(playlist: SpotifyPlaylist): String? =
        playlist.images.firstOrNull()?.url
}

object SpotifyAuth {
    const val LOGIN_URL = "https://accounts.spotify.com/en/login"
}

data class SpotifyAccountUiState(
    val isAuthenticated: Boolean = false,
    val accountName: String = "",
    val accountAvatarUrl: String? = null,
    val isLoading: Boolean = false,
    val playlistCount: Int = 0,
    val errorMessage: String? = null,
)

@HiltViewModel
class SpotifyAccountViewModel
    @Inject
    constructor(
        app: Application,
    ) : AndroidViewModel(app) {
        val uiState = kotlinx.coroutines.flow.MutableStateFlow(SpotifyAccountUiState())

        fun reloadPlaylists() {}
        fun logout() {}
        fun dismissError() {}
        fun connectWithCookies(spDc: String, spKey: String) {}
    }

@HiltViewModel
class SpotifyLibraryViewModel
    @Inject
    constructor(
        app: Application,
    ) : AndroidViewModel(app) {
        val playlists = kotlinx.coroutines.flow.MutableStateFlow<List<SpotifyPlaylist>>(emptyList())
    }

@HiltViewModel
class SpotifyPlaylistViewModel
    @Inject
    constructor(
        app: Application,
    ) : AndroidViewModel(app)

class SpotifyPlaylistQueue
class SpotifyPlaybackResolver
