/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sonettas.app.ui.component.shimmer.ShimmerHost

/**
 * Editorial loading skeleton for the Sonettas home screen.
 * Renders a column of placeholder rows that match the typical
 * home-screen layout (title bar, quick chips, two card rows,
 * a list section, another card row).
 */
@Composable
fun SonettasHomeLoadingSkeleton(modifier: Modifier = Modifier) {
    val cardShape = RoundedCornerShape(20.dp)
    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        // Top bar skeleton (greeting + avatar)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                Modifier
                    .height(28.dp)
                    .width(180.dp)
                    .shimmer(),
            )
            Box(
                Modifier
                    .size(40.dp)
                    .shimmer(),
            )
        }

        // Quick chip row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            repeat(4) {
                Box(
                    Modifier
                        .height(32.dp)
                        .width(72.dp)
                        .shimmer(),
                )
            }
        }

        // Section title
        Box(
            Modifier
                .height(20.dp)
                .width(160.dp)
                .shimmer(),
        )

        // Two large cards row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            repeat(2) {
                Box(
                    Modifier
                        .weight(1f)
                        .height(180.dp)
                        .shimmer(),
                )
            }
        }

        // List section
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            repeat(5) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Box(
                        Modifier
                            .size(48.dp)
                            .shimmer(),
                    )
                    Column(
                        Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                    ) {
                        Box(
                            Modifier
                                .height(14.dp)
                                .fillMaxWidth(0.7f)
                                .shimmer(),
                        )
                        Box(
                            Modifier
                                .height(12.dp)
                                .fillMaxWidth(0.4f)
                                .shimmer(),
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun Modifier.shimmer(): Modifier =
    this.then(
        Modifier.background(
            color = MaterialTheme.colorScheme.surfaceContainerHighest.copy(alpha = 0.6f),
            shape = RoundedCornerShape(8.dp),
        ),
    )
