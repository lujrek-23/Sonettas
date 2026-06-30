/*
 * Huasic (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package moe.rukamori.archivetune.innertube.models.response

import kotlinx.serialization.Serializable
import moe.rukamori.archivetune.innertube.models.MusicShelfRenderer

@Serializable
data class ContinuationResponse(
    val onResponseReceivedActions: List<ResponseAction>?,
) {
    @Serializable
    data class ResponseAction(
        val appendContinuationItemsAction: ContinuationItems?,
    )

    @Serializable
    data class ContinuationItems(
        val continuationItems: List<MusicShelfRenderer.Content>?,
    )
}
