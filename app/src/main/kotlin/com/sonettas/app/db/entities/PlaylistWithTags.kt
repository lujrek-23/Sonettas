/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.db.entities

data class PlaylistWithTags(
    val playlist: Playlist,
    val tags: List<TagEntity>,
)
