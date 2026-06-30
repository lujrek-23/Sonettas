/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Home screen — 4 sections max (NOT 10 like Huasic).
 * Bold sans greeting, shadow cards, clean layout.
 */

package com.sonettas.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sonettas.app.R
import com.sonettas.app.ui.component.GreetingBar
import com.sonettas.app.ui.component.SectionCard
import com.sonettas.app.ui.theme.CardShadowColor
import com.sonettas.app.ui.theme.Gray400
import com.sonettas.app.ui.theme.Gray50
import com.sonettas.app.ui.theme.NearBlack
import com.sonettas.app.ui.theme.Orange
import com.sonettas.app.ui.theme.SonettasPadding
import com.sonettas.app.ui.theme.SonettasRadius
import com.sonettas.app.ui.theme.SonettasType
import com.sonettas.app.ui.theme.White

@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(bottom = 80.dp),
    ) {
        // Greeting — bold sans, NOT serif
        item { GreetingBar() }

        // Section 1: Recently Played — horizontal scroll cards
        item {
            SectionCard(title = "Baru diputar") {
                // Placeholder — will be replaced with real data
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    repeat(3) { index ->
                        PlaceholderTrackRow(index = index)
                    }
                }
            }
        }

        item { Spacer(modifier = Modifier.height(20.dp)) }

        // Section 2: Quick Picks
        item {
            SectionCard(title = "Pilihan cepat") {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    repeat(2) { index ->
                        PlaceholderTrackRow(index = index + 10)
                    }
                }
            }
        }

        item { Spacer(modifier = Modifier.height(20.dp)) }

        // Section 3: For You (YouTube sections)
        item {
            SectionCard(title = "Untuk kamu") {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    repeat(3) { index ->
                        PlaceholderTrackRow(index = index + 20)
                    }
                }
            }
        }

        item { Spacer(modifier = Modifier.height(20.dp)) }

        // Section 4: New Releases
        item {
            SectionCard(title = "Rilis baru") {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    repeat(2) { index ->
                        PlaceholderTrackRow(index = index + 30)
                    }
                }
            }
        }
    }
}

@Composable
private fun PlaceholderTrackRow(index: Int) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(1.dp, RoundedCornerShape(SonettasRadius.sm), spotColor = CardShadowColor),
        shape = RoundedCornerShape(SonettasRadius.sm),
        color = Gray50,
    ) {
        androidx.compose.foundation.layout.Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            // Album art placeholder
            Surface(
                shape = RoundedCornerShape(SonettasRadius.sm),
                color = if (index % 3 == 0) Orange.copy(alpha = 0.2f) else Gray50,
                modifier = Modifier.size(48.dp),
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        painter = painterResource(R.drawable.ic_play),
                        contentDescription = null,
                        tint = if (index % 3 == 0) Orange else Gray400,
                        modifier = Modifier.size(20.dp),
                    )
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Lagu ${index + 1}",
                    style = SonettasType.bodyBold,
                    color = NearBlack,
                )
                Text(
                    text = "Artis ${index + 1}",
                    style = SonettasType.caption,
                    color = Gray400,
                )
            }
            Text(
                text = "3:2${index % 10}",
                style = SonettasType.mono,
                color = Gray400,
            )
        }
    }
}
