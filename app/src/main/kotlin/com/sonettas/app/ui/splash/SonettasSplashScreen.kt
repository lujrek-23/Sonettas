/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * Splash screen — Anthropic Claude-inspired editorial style.
 * Paper background, ink emblem reveal, terracotta hairline accent.
 *
 * Composition:
 * - Top: hairline terracotta tick
 * - Upper third: Sonettas Seal (drawn with stroke animation)
 * - Center: wordmark in serif
 * - Below: hairline divider + establishment mark
 */

package com.sonettas.app.ui.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

// Sonettas palette
private val Paper = Color(0xFFFFFFFF)
private val Vellum = Color(0xFFE5E5E5)
private val Ink = Color(0xFF0A0A0A)
private val Stone = Color(0xFF525252)
private val Terracotta = Color(0xFFFF6B00)

/**
 * Editorial splash — paper background, ink seal that draws itself,
 * serif wordmark, terracotta hairlines.
 */
@Composable
fun SonettasSplashScreen(
    onFinished: () -> Unit,
    durationMs: Long = 2200L,
) {
    var showSeal by remember { mutableStateOf(false) }
    var showWordmark by remember { mutableStateOf(false) }
    var showRule by remember { mutableStateOf(false) }
    var startFadeOut by remember { mutableStateOf(false) }

    // Seal draw animation — controls stroke progress 0→1
    val sealProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        // Phase 1: Hairline tick appears
        delay(150)
        showRule = true

        // Phase 2: Seal draws itself (1.0s)
        delay(200)
        showSeal = true
        sealProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(1000, easing = LinearEasing),
        )

        // Phase 3: Wordmark fades in (400ms)
        delay(150)
        showWordmark = true

        // Phase 4: Hold
        delay(durationMs - 1900)

        // Phase 5: Fade out (300ms)
        startFadeOut = true
        delay(300)
        onFinished()
    }

    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Paper),
        contentAlignment = Alignment.Center,
    ) {
        AnimatedVisibility(
            visible = !startFadeOut,
            enter = fadeIn(tween(200)),
            exit = fadeOut(tween(300)),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                // Top hairline tick (terracotta)
                AnimatedVisibility(
                    visible = showRule,
                    enter = fadeIn(tween(200)),
                ) {
                    Box(
                        modifier =
                            Modifier
                                .width(1.dp)
                                .height(48.dp)
                                .background(Terracotta),
                    )
                }

                Spacer(modifier = Modifier.height(48.dp))

                // Seal canvas — drawn with stroke animation
                if (showSeal) {
                    SonettasSealCanvas(
                        progress = sealProgress.value,
                        modifier = Modifier.size(220.dp),
                    )
                }

                Spacer(modifier = Modifier.height(64.dp))

                // Eyebrow label (small, stone color, letter-spaced)
                AnimatedVisibility(
                    visible = showWordmark,
                    enter = fadeIn(tween(400)),
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "— A PLAYER FOR THE THOUGHTFUL LISTENER —",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Normal,
                            color = Stone,
                            letterSpacing = 3.sp,
                            fontFamily = SonettasFontFamily,
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        // Wordmark — serif, ink, restrained
                        Text(
                            text = "Sonettas",
                            fontSize = 56.sp,
                            fontWeight = FontWeight.Medium,
                            color = Ink,
                            letterSpacing = 2.sp,
                            fontFamily = SonettasFontFamily,
                            fontStyle = FontStyle.Normal,
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        // Hairline divider (terracotta)
                        Box(
                            modifier =
                                Modifier
                                    .width(80.dp)
                                    .height(1.dp)
                                    .background(Terracotta),
                        )
                        Spacer(modifier = Modifier.height(12.dp))

                        // Establishment mark
                        Text(
                            text = "HUANIME COMPANY · EST. MMXXVI",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Normal,
                            color = Stone,
                            letterSpacing = 3.sp,
                            fontFamily = SonettasFontFamily,
                        )
                    }
                }
            }
        }
    }
}

/**
 * Draw the Sonettas Seal — outer ring + Greek meander + central waveform/tuning fork.
 * Stroke progress animates the draw.
 */
@Composable
private fun SonettasSealCanvas(
    progress: Float,
    modifier: Modifier = Modifier,
) {
    Canvas(modifier = modifier) {
        val center = Offset(size.width / 2f, size.height / 2f)
        val radius = size.minDimension / 2f * 0.92f
        val strokePx = (size.minDimension / 220f) * 2f

        // Outer ring — drawn first (0.0 to 0.3)
        val ringProgress = (progress / 0.3f).coerceIn(0f, 1f)
        if (ringProgress > 0f) {
            drawArc(
                color = Ink,
                startAngle = -90f,
                sweepAngle = 360f * ringProgress,
                useCenter = false,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = androidx.compose.ui.geometry.Size(radius * 2, radius * 2),
                style = Stroke(width = strokePx, cap = StrokeCap.Round),
            )
        }

        // Greek meander hooks — drawn second (0.3 to 0.6)
        val meanderProgress = ((progress - 0.3f) / 0.3f).coerceIn(0f, 1f)
        if (meanderProgress > 0f) {
            val hookCount = 12
            val hooksToDraw = (hookCount * meanderProgress).toInt()
            val meanderRadius = radius * 0.86f
            for (i in 0 until hooksToDraw) {
                val angle = (i * 360f / hookCount) * (PI / 180f)
                val cx = center.x + (meanderRadius * cos(angle - PI / 2)).toFloat()
                val cy = center.y + (meanderRadius * sin(angle - PI / 2)).toFloat()
                // Small hook shape — rotated
                drawCircle(
                    color = Ink,
                    radius = strokePx * 1.5f,
                    center = Offset(cx, cy),
                )
            }
        }

        // Inner hairline ring — drawn third (0.6 to 0.7)
        val innerRingProgress = ((progress - 0.6f) / 0.1f).coerceIn(0f, 1f)
        if (innerRingProgress > 0f) {
            val innerRadius = radius * 0.62f
            drawArc(
                color = Ink.copy(alpha = 0.4f),
                startAngle = -90f,
                sweepAngle = 360f * innerRingProgress,
                useCenter = false,
                topLeft = Offset(center.x - innerRadius, center.y - innerRadius),
                size = androidx.compose.ui.geometry.Size(innerRadius * 2, innerRadius * 2),
                style = Stroke(width = strokePx * 0.4f),
            )
        }

        // Central waveform — drawn fourth (0.7 to 0.95)
        val waveProgress = ((progress - 0.7f) / 0.25f).coerceIn(0f, 1f)
        if (waveProgress > 0f) {
            val waveWidth = radius * 0.55f
            val waveHeight = radius * 0.18f
            val segments = 60
            val segmentsToDraw = (segments * waveProgress).toInt()
            for (i in 0 until segmentsToDraw) {
                val t1 = i.toFloat() / segments
                val t2 = (i + 1).toFloat() / segments
                val x1 = center.x - waveWidth + t1 * waveWidth * 2
                val x2 = center.x - waveWidth + t2 * waveWidth * 2
                val y1 = center.y + (sin(t1 * PI * 4) * waveHeight).toFloat()
                val y2 = center.y + (sin(t2 * PI * 4) * waveHeight).toFloat()
                drawLine(
                    color = Ink,
                    start = Offset(x1, y1),
                    end = Offset(x2, y2),
                    strokeWidth = strokePx * 1.2f,
                    cap = StrokeCap.Round,
                )
            }
        }

        // Terracotta seal dot — drawn last (0.95 to 1.0)
        val dotProgress = ((progress - 0.95f) / 0.05f).coerceIn(0f, 1f)
        if (dotProgress > 0f) {
            drawCircle(
                color = Terracotta.copy(alpha = dotProgress),
                radius = strokePx * 1.8f,
                center = Offset(center.x, center.y + radius * 0.35f),
            )
        }
    }
}
