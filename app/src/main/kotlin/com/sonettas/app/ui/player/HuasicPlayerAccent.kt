/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * Player accent components — editorial style.
 * Paper, ink, terracotta palette.
 */

package com.sonettas.app.ui.player

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonettas.app.ui.theme.Ink
import com.sonettas.app.ui.theme.PaperRaised
import com.sonettas.app.ui.theme.Stone
import com.sonettas.app.ui.theme.Terracotta
import com.sonettas.app.ui.theme.TerracottaDeep
import com.sonettas.app.ui.theme.Vellum

/**
 * Editorial progress bar — terracotta fill on vellum track, no rounded ends.
 */
@Composable
fun SonettasAccentBar(
    progress: Float,
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 2.dp,
) {
    val clampedProgress = progress.coerceIn(0f, 1f)
    Box(
        modifier =
            modifier
                .fillMaxWidth()
                .height(height)
                .clip(RoundedCornerShape(0.dp))
                .background(Vellum),
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxWidth(clampedProgress)
                    .height(height)
                    .background(Terracotta),
        )
    }
}

/**
 * Editorial card — paper background, vellum border, no shadow.
 */
@Composable
fun SonettasGlassContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier =
            modifier
                .clip(RoundedCornerShape(4.dp))
                .background(PaperRaised)
                .border(1.dp, Vellum, RoundedCornerShape(4.dp)),
    ) {
        content()
    }
}

/**
 * Track title — serif, ink, restrained.
 */
@Composable
fun SonettasTrackTitle(
    title: String,
    modifier: Modifier = Modifier,
    fontSize: androidx.compose.ui.unit.TextUnit = 20.sp,
    fontWeight: FontWeight = FontWeight.Medium,
) {
    Text(
        text = title,
        color = Ink,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontFamily = FontFamily.Serif,
        modifier = modifier,
    )
}

/**
 * Mini equalizer — terracotta bars, no animation (static indicator).
 */
@Composable
fun SonettasPlayingIndicator(
    modifier: Modifier = Modifier,
    barCount: Int = 4,
    isPlaying: Boolean = true,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val heights = if (barCount == 4) listOf(6, 10, 8, 5) else listOf(5, 8, 10, 8, 5)
        heights.forEachIndexed { index, h ->
            Box(
                modifier =
                    Modifier
                        .width(2.dp)
                        .height(if (isPlaying) h.dp else (h / 2).dp)
                        .background(Terracotta),
            )
        }
    }
}
