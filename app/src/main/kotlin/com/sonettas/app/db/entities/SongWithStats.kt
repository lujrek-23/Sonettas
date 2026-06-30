/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.db.entities

import androidx.compose.runtime.Immutable

@Immutable
data class SongWithStats(
    val id: String,
    val title: String,
    val thumbnailUrl: String,
    val songCountListened: Int,
    val timeListened: Long?,
)
