/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.db.entities

import androidx.room.Embedded
import androidx.room.Relation

data class PlaylistSong(
    @Embedded val map: PlaylistSongMap,
    @Relation(
        parentColumn = "songId",
        entityColumn = "id",
        entity = SongEntity::class,
    )
    val song: Song,
)
