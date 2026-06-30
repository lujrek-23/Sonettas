/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.lyrics

import android.content.Context
import com.sonettas.app.constants.EnablePaxsenixSpotifyLyricsKey
import moe.rukamori.archivetune.paxsenix.PaxsenixLyrics
import com.sonettas.app.utils.dataStore
import com.sonettas.app.utils.get

object PaxsenixSpotifyLyricsProvider : LyricsProvider {
    override val name = "Paxsenix: Spotify"

    override fun isEnabled(context: Context): Boolean = context.dataStore[EnablePaxsenixSpotifyLyricsKey] ?: true

    override suspend fun getLyrics(
        id: String,
        title: String,
        artist: String,
        album: String?,
        duration: Int,
    ): Result<String> = PaxsenixLyrics.getSpotifyLyrics(title, artist, duration)

    override suspend fun getAllLyrics(
        id: String,
        title: String,
        artist: String,
        album: String?,
        duration: Int,
        callback: (String) -> Unit,
    ) {
        getLyrics(id, title, artist, album, duration).onSuccess(callback)
    }
}
