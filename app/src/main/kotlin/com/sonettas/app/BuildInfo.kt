/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app

import com.sonettas.app.constants.UpdateChannel

private val DailyNightlyVersionRegex = Regex("""^N\d{8}$""")

internal val isDailyNightlyBuild: Boolean
    get() = DailyNightlyVersionRegex.matches(BuildConfig.VERSION_NAME)

internal val defaultUpdateChannel: UpdateChannel
    get() = if (isDailyNightlyBuild) UpdateChannel.DAILY_NIGHTLY else UpdateChannel.STABLE

internal val currentBuildHash: String?
    get() = BuildConfig.NIGHTLY_BUILD_HASH.takeIf { it.isNotBlank() }

internal fun formatVersionName(
    versionName: String = BuildConfig.VERSION_NAME,
    buildHash: String? = currentBuildHash,
): String = listOfNotNull(versionName.takeIf { it.isNotBlank() }, buildHash).joinToString(" ")
