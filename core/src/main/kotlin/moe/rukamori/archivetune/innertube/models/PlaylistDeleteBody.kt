/*
 * Huasic (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package moe.rukamori.archivetune.innertube.models.body

import kotlinx.serialization.Serializable
import moe.rukamori.archivetune.innertube.models.Context

@Serializable
data class PlaylistDeleteBody(
    val context: Context,
    val playlistId: String,
)
