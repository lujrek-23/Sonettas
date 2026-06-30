/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * STUB — News repository removed.
 */

package com.sonettas.app.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import com.sonettas.app.models.NewsItem

class NewsRepository {
    fun newsFlow(): Flow<List<NewsItem>> = flowOf(emptyList())
    suspend fun refresh() {}
}
