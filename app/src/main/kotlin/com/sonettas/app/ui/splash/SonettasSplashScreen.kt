/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Splash screen — Sonettas identity.
 * Per brand.md: NOT editorial-typographic. NOT a seal/emblem.
 * Clean, confident, minimal. Sonnet Wave logo + wordmark.
 *
 * Animation per animate.md:
 * - Hero moment: logo scale-in (400ms)
 * - Wordmark fade-in (200ms, 100ms delay)
 * - Total: 1.5s then dismiss
 */

package com.sonettas.app.ui.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonettas.app.R
import com.sonettas.app.ui.theme.Gray400
import com.sonettas.app.ui.theme.NearBlack
import com.sonettas.app.ui.theme.Orange
import com.sonettas.app.ui.theme.SonettasFontFamily
import com.sonettas.app.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun SonettasSplashScreen(
    onFinished: () -> Unit,
    durationMs: Long = 1500L,
) {
    var showWordmark by remember { mutableStateOf(false) }
    val logoScale = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        // Logo scale-in (400ms) — hero moment
        logoScale.animateTo(
            targetValue = 1f,
            animationSpec = tween(400),
        )
        // Wordmark fade-in (100ms delay, 200ms)
        delay(100)
        showWordmark = true
        // Hold
        delay(durationMs - 700)
        onFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            // Sonnet Wave logo — scale-in animation
            Box(
                modifier = Modifier.scale(logoScale.value),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(R.mipmap.ic_launcher),
                    contentDescription = "Sonettas",
                    modifier = Modifier.size(96.dp),
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Wordmark — fade-in, bold sans, tight tracking
            if (showWordmark) {
                Text(
                    text = "Sonettas",
                    fontFamily = SonettasFontFamily,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = NearBlack,
                    letterSpacing = (-0.5).sp,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Huanime Company",
                    fontFamily = SonettasFontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Gray400,
                )
            }
        }
    }
}
