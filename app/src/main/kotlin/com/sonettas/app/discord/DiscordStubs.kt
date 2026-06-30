/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * STUB FILE — Discord feature has been removed from Huasic.
 * These types exist only to keep MainActivity.kt and MusicService.kt
 * compiling during the transitional cleanup period. All operations are no-ops.
 */

package com.sonettas.app.discord

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import com.sonettas.app.models.MediaMetadata

class DiscordOAuthCallbackActivity : android.app.Activity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        finish()
    }
}

class DiscordOAuthRepository(context: Context) {
    fun isLoggedIn(): Boolean = false
    fun logout() {}
    fun startAuth(): String? = null
    fun exchangeCode(code: String): Boolean = false
}

class DiscordAssetRegistrar(context: Context) {
    fun register(mediaMetadata: MediaMetadata): String? = null
}

class DiscordSocialPresenceClient(
    private val context: Context,
    private val repository: DiscordOAuthRepository,
    private val assetRegistrar: DiscordAssetRegistrar,
) {
    fun connect() {}
    fun disconnect() {}
    fun updateActivity(mediaMetadata: MediaMetadata?, isPlaying: Boolean, positionMs: Long) {}
}

object DiscordPresenceManager {
    val lastRpcStartTimeFlow: Flow<Long?> = flowOf(null)
    val lastRpcEndTimeFlow: Flow<Long?> = flowOf(null)

    fun isRunning(): Boolean = false
    fun start() {}
    fun stop() {}
    fun updateActivity(
        mediaMetadata: MediaMetadata?,
        isPlaying: Boolean,
        positionMs: Long,
    ) {}
}
