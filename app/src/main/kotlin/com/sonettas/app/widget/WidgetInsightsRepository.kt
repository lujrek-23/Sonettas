/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.widget

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import com.sonettas.app.db.MusicDatabase
import com.sonettas.app.db.entities.Artist
import com.sonettas.app.db.entities.LibraryTopMixEntity
import com.sonettas.app.db.entities.ListeningTotals
import com.sonettas.app.db.entities.Song
import com.sonettas.app.db.entities.SongWithStats
import java.time.Duration
import javax.inject.Inject

internal class WidgetInsightsRepository
    @Inject
    constructor(
        private val database: MusicDatabase,
    ) {
        suspend fun load(nowMs: Long): WidgetInsightsData =
            withContext(Dispatchers.IO) {
                val fromMs = nowMs - Duration.ofDays(30).toMillis()
                WidgetInsightsData(
                    recentSongs = database.recentSongs(limit = 4).first(),
                    totals = database.listeningTotals(fromTimestamp = fromMs, toTimestamp = nowMs).first(),
                    topSongs = database.mostPlayedSongsStats(fromTimeStamp = fromMs, limit = 4, toTimeStamp = nowMs).first(),
                    recommendations = database.quickPicks(now = nowMs).first().take(6),
                    topArtists = database.mostPlayedArtists(fromTimeStamp = fromMs, limit = 6, toTimeStamp = nowMs).first(),
                    topMixes = database.libraryTopMixes(limit = 4).first(),
                )
            }
    }

internal data class WidgetInsightsData(
    val recentSongs: List<Song>,
    val totals: ListeningTotals,
    val topSongs: List<SongWithStats>,
    val recommendations: List<Song>,
    val topArtists: List<Artist>,
    val topMixes: List<LibraryTopMixEntity>,
)
