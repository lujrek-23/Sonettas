/*
 * Huasic (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package moe.rukamori.archivetune.innertube.models.body

import kotlinx.serialization.Serializable
import moe.rukamori.archivetune.innertube.models.Context
import moe.rukamori.archivetune.innertube.models.Continuation

@Serializable
data class BrowseBody(
    val context: Context,
    val browseId: String?,
    val params: String?,
    val continuation: String?,
)
