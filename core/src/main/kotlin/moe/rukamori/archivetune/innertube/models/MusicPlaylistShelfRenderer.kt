/*
 * Huasic (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package moe.rukamori.archivetune.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicPlaylistShelfRenderer(
    val playlistId: String?,
    val contents: List<MusicShelfRenderer.Content> = emptyList(),
    val collapsedItemCount: Int? = null,
    val continuations: List<Continuation>? = null,
)
