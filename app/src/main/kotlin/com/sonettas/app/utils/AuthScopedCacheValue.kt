/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.utils

data class AuthScopedCacheValue(
    val url: String,
    val expiresAtMs: Long,
    val authFingerprint: String,
) {
    fun isValidFor(
        authFingerprint: String,
        nowMs: Long = System.currentTimeMillis(),
        minimumRemainingMs: Long = 0L,
    ): Boolean = this.authFingerprint == authFingerprint && expiresAtMs > nowMs + minimumRemainingMs
}
