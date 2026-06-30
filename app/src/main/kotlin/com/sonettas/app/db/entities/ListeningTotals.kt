/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.db.entities

data class ListeningTotals(
    val totalPlayCount: Int,
    val totalUniqueSongs: Int,
    val totalListeningTimeMs: Long,
)
