/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.playback.queues

import androidx.media3.common.MediaItem
import com.sonettas.app.models.MediaMetadata

object EmptyQueue : Queue {
    override val preloadItem: MediaMetadata? = null

    override suspend fun getInitialStatus() = Queue.Status(null, emptyList(), -1)

    override fun hasNextPage() = false

    override suspend fun nextPage() = emptyList<MediaItem>()
}
