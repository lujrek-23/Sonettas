/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.library

import androidx.compose.runtime.Immutable
import com.google.common.collect.ImmutableList
import com.sonettas.app.models.MediaMetadata

@Immutable
data class LibraryTopMix(
    val id: String,
    val title: String,
    val description: String,
    val tracks: ImmutableList<MediaMetadata>,
)

@Immutable
data class GeneratedLibraryTopMix(
    val id: String,
    val title: String,
    val description: String,
    val tracks: ImmutableList<MediaMetadata>,
)
