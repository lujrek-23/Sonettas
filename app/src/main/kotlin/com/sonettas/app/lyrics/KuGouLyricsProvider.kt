/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.lyrics

import android.content.Context
import com.sonettas.app.constants.EnableKugouKey
import com.sonettas.app.kugou.KuGou
import com.sonettas.app.utils.dataStore
import com.sonettas.app.utils.get

object KuGouLyricsProvider : LyricsProvider {
    override val name = "Kugou"

    override fun isEnabled(context: Context): Boolean = context.dataStore[EnableKugouKey] ?: true

    override suspend fun getLyrics(
        id: String,
        title: String,
        artist: String,
        album: String?,
        duration: Int,
    ): Result<String> = KuGou.getLyrics(title, artist, duration)

    override suspend fun getAllLyrics(
        id: String,
        title: String,
        artist: String,
        album: String?,
        duration: Int,
        callback: (String) -> Unit,
    ) {
        KuGou.getAllPossibleLyricsOptions(title, artist, duration, callback)
    }
}
