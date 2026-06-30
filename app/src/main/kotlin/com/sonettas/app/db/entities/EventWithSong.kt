/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.db.entities

import androidx.compose.runtime.Immutable
import androidx.room.Embedded
import androidx.room.Relation

@Immutable
data class EventWithSong(
    @Embedded
    val event: Event,
    @Relation(
        entity = SongEntity::class,
        parentColumn = "songId",
        entityColumn = "id",
    )
    val song: Song,
)
