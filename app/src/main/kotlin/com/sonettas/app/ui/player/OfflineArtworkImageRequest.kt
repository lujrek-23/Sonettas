/*
 * Huasic (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.ui.player

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import coil3.request.CachePolicy
import coil3.request.ImageRequest

@Composable
internal fun rememberOfflineArtworkImageRequest(imageUrl: String?): ImageRequest? {
    val context = LocalContext.current
    return remember(context, imageUrl) {
        imageUrl
            ?.trim()
            ?.takeIf(String::isNotBlank)
            ?.let { url ->
                ImageRequest
                    .Builder(context)
                    .data(url)
                    .memoryCacheKey(url)
                    .diskCacheKey(url)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .networkCachePolicy(CachePolicy.ENABLED)
                    .build()
            }
    }
}
