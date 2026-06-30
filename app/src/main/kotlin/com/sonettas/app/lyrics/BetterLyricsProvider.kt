/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.lyrics

import android.content.Context
import android.util.Log
import moe.rukamori.archivetune.betterlyrics.BetterLyrics
import com.sonettas.app.constants.EnableBetterLyricsKey
import com.sonettas.app.utils.GlobalLog
import com.sonettas.app.utils.dataStore
import com.sonettas.app.utils.get

object BetterLyricsProvider : LyricsProvider {
    init {
        BetterLyrics.logger = { message ->
            GlobalLog.append(Log.INFO, "BetterLyrics", message)
        }
    }

    override val name = "BetterLyrics"

    override fun isEnabled(context: Context): Boolean = context.dataStore[EnableBetterLyricsKey] ?: true

    override suspend fun getLyrics(
        id: String,
        title: String,
        artist: String,
        album: String?,
        duration: Int,
    ): Result<String> = BetterLyrics.getLyrics(title = title, artist = artist, album = album, durationSeconds = duration)

    override suspend fun getAllLyrics(
        id: String,
        title: String,
        artist: String,
        album: String?,
        duration: Int,
        callback: (String) -> Unit,
    ) {
        BetterLyrics.getAllLyrics(
            title = title,
            artist = artist,
            album = album,
            durationSeconds = duration,
            callback = callback,
        )
    }
}
