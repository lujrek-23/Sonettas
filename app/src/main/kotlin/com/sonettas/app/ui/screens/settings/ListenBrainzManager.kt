/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * STUB — ListenBrainz manager removed.
 */

package com.sonettas.app.ui.screens.settings

import android.content.Context
import com.sonettas.app.db.entities.Song

object ListenBrainzManager {
    fun isEnabled(): Boolean = false
    fun setEnabled(enabled: Boolean) {}
    fun setToken(token: String) {}
    fun getToken(): String = ""

    fun submitPlayingNow(
        context: Context,
        token: String,
        song: Song,
        positionMs: Long,
    ) {}

    fun submitPlayingNow(
        context: Context,
        token: String,
        title: String,
        artists: List<String>,
        album: String?,
        durationMs: Long,
        positionMs: Long,
    ) {}

    fun submitFinished(
        context: Context,
        token: String,
        song: Song,
        startMs: Long,
        endMs: Long,
    ) {}

    fun flush() {}
}

