/*
 * Huasic (2026)
 * © Huanime Company
 *
 * STUB — DiscordPresenceManager moved to discord package as a stub.
 * This file keeps the old import path working for transition.
 */

package com.sonettas.app.ui.screens.settings

import com.sonettas.app.discord.DiscordPresenceManager

// Re-export for legacy callers
val DiscordPresenceManagerLastRpcStartTimeFlow get() = DiscordPresenceManager.lastRpcStartTimeFlow
val DiscordPresenceManagerLastRpcEndTimeFlow get() = DiscordPresenceManager.lastRpcEndTimeFlow

fun isDiscordPresenceRunning(): Boolean = DiscordPresenceManager.isRunning()
