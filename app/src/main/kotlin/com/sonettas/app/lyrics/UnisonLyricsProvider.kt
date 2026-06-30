/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.lyrics

import android.content.Context
import android.util.Log
import com.sonettas.app.constants.EnableUnisonLyricsKey
import moe.rukamori.archivetune.unison.Unison
import com.sonettas.app.utils.GlobalLog
import com.sonettas.app.utils.dataStore
import com.sonettas.app.utils.get

object UnisonLyricsProvider : LyricsProvider {
    init {
        Unison.logger = { message ->
            GlobalLog.append(Log.INFO, "Unison", message)
        }
    }

    override val name = "Unison"

    override fun isEnabled(context: Context): Boolean = context.dataStore[EnableUnisonLyricsKey] ?: true

    override suspend fun getLyrics(
        id: String,
        title: String,
        artist: String,
        album: String?,
        duration: Int,
    ): Result<String> =
        Unison.getLyrics(
            videoId = id,
            title = title,
            artist = artist,
            album = album,
            durationSeconds = duration,
        )

    override suspend fun getAllLyrics(
        id: String,
        title: String,
        artist: String,
        album: String?,
        duration: Int,
        callback: (String) -> Unit,
    ) {
        Unison.getAllLyrics(
            videoId = id,
            title = title,
            artist = artist,
            album = album,
            durationSeconds = duration,
            callback = callback,
        )
    }
}
