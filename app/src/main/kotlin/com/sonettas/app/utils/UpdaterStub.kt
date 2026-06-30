/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * STUB — Update checker removed from Huasic.
 * Provides no-op compatibility for code that still references Updater.
 */

package com.sonettas.app.utils

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object UpdaterStub {
    val lastCheckTime: Long = Long.MAX_VALUE

    fun getLatestVersionName(): Result<String> = Result.success("1.0.0")

    fun getLatestDailyNightlyVersionName(): Result<String> = Result.success("1.0.0")

    fun getLatestReleaseNotes(): Result<String> = Result.success("")

    fun getLatestDailyNightlyReleaseNotes(): Result<String> = Result.success("")

    fun isUpdateAvailable(
        latest: String,
        current: String,
    ): Boolean = false

    fun getLatestDownloadUrl(): String? = null

    fun getLatestDailyNightlyDownloadUrl(): String? = null

    suspend fun getAllReleases(forceRefresh: Boolean = false): Result<List<Any>> = Result.success(emptyList())

    suspend fun getAllDailyNightlyReleases(forceRefresh: Boolean = false): Result<List<Any>> = Result.success(emptyList())

    fun getCachedReleases(): List<Any> = emptyList()

    fun getCachedDailyNightlyReleases(): List<Any> = emptyList()

    val latestVersionNameFlow: StateFlow<String?> = MutableStateFlow(null)

    val releaseNotesFlow: StateFlow<String?> = MutableStateFlow(null)
}
