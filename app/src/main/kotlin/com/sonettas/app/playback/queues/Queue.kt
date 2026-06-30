/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.playback.queues

import androidx.media3.common.MediaItem
import com.sonettas.app.extensions.ExtraIsMusicVideo
import com.sonettas.app.extensions.metadata
import com.sonettas.app.models.MediaMetadata

interface Queue {
    val preloadItem: MediaMetadata?

    suspend fun getInitialStatus(): Status

    fun shouldExpandToFullQueueWhenAutoLoadMoreDisabled(): Boolean = false

    fun hasNextPage(): Boolean

    suspend fun nextPage(): List<MediaItem>

    data class Status(
        val title: String?,
        val items: List<MediaItem>,
        val mediaItemIndex: Int,
        val position: Long = 0L,
    ) {
        fun filterExplicit(enabled: Boolean = true) =
            if (enabled) {
                filterItems { it.metadata?.explicit != true }
            } else {
                this
            }

        fun filterVideo(enabled: Boolean = true) =
            if (enabled) {
                filterItems { it.mediaMetadata.extras?.getBoolean(ExtraIsMusicVideo, false) != true }
            } else {
                this
            }

        private inline fun filterItems(keep: (MediaItem) -> Boolean): Status {
            if (items.isEmpty()) return this

            val currentIndex = mediaItemIndex.coerceIn(items.indices)
            var filteredIndex = 0
            val filteredItems =
                buildList(items.size) {
                    items.forEachIndexed { index, item ->
                        if (keep(item)) {
                            if (index < currentIndex) {
                                filteredIndex++
                            }
                            add(item)
                        }
                    }
                }

            if (filteredItems.isEmpty()) {
                return copy(items = emptyList(), mediaItemIndex = 0)
            }

            return copy(
                items = filteredItems,
                mediaItemIndex = filteredIndex.coerceIn(filteredItems.indices),
            )
        }
    }
}

fun List<MediaItem>.filterExplicit(enabled: Boolean = true) =
    if (enabled) {
        filterNot {
            it.metadata?.explicit == true
        }
    } else {
        this
    }

fun List<MediaItem>.filterVideo(enabled: Boolean = true) =
    if (enabled) {
        filterNot {
            it.mediaMetadata.extras?.getBoolean(ExtraIsMusicVideo, false) == true
        }
    } else {
        this
    }
