/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Library screen — 5 tabs with pager.
 * Clean tabs, NOT chip-style like Huasic.
 */

package com.sonettas.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sonettas.app.ui.theme.Gray200
import com.sonettas.app.ui.theme.Gray400
import com.sonettas.app.ui.theme.NearBlack
import com.sonettas.app.ui.theme.Orange
import com.sonettas.app.ui.theme.SonettasPadding
import com.sonettas.app.ui.theme.SonettasType
import com.sonettas.app.ui.theme.White

private val libTabs = listOf("Semua", "Playlist", "Lagu", "Artis", "Album")

@Composable
fun LibraryScreen(
    onNavigate: (String) -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = { libTabs.size })

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Tab row — clean, orange indicator (NOT chip-style like Huasic)
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = White,
            contentColor = Orange,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    color = Orange,
                    height = 3.dp,
                )
            },
            divider = {},
        ) {
            libTabs.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { },
                    text = {
                        Text(
                            text = title,
                            style = SonettasType.bodyBold,
                            color = if (pagerState.currentPage == index) NearBlack else Gray400,
                        )
                    },
                )
            }
        }

        // Pager content
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
        ) { page ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = SonettasPadding.screen, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(15) { index ->
                    LibraryPlaceholderRow(
                        title = "${libTabs[page]} ${index + 1}",
                        subtitle = "Item ${index + 1}",
                    )
                }
            }
        }
    }
}

@Composable
private fun LibraryPlaceholderRow(
    title: String,
    subtitle: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
        Text(
            text = title,
            style = SonettasType.bodyBold,
            color = NearBlack,
        )
        Text(
            text = subtitle,
            style = SonettasType.caption,
            color = Gray400,
        )
    }
}
