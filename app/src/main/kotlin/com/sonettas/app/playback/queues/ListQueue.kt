/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.playback.queues

import androidx.media3.common.MediaItem
import com.sonettas.app.models.MediaMetadata

class ListQueue(
    val title: String? = null,
    val items: List<MediaItem>,
    val startIndex: Int = 0,
    val position: Long = 0L,
) : Queue {
    override val preloadItem: MediaMetadata? = null

    override suspend fun getInitialStatus(): Queue.Status {
        val safeStartIndex =
            if (items.isEmpty()) {
                0
            } else {
                startIndex.coerceIn(items.indices)
            }

        return Queue.Status(title, items, safeStartIndex, position)
    }

    override fun hasNextPage(): Boolean = false

    override suspend fun nextPage() = throw UnsupportedOperationException()
}
