/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Material3 theme wrapper — Sonettas identity.
 * Pure white, vibrant orange, Fraunces + DM Sans.
 */

package com.sonettas.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Sonettas light color scheme — pure white based
private val SonettasLightColors = lightColorScheme(
    primary = Orange,
    onPrimary = Color.White,
    primaryContainer = OrangeLight,
    onPrimaryContainer = OrangeDeep,
    secondary = Gray600,
    onSecondary = Color.White,
    secondaryContainer = Gray50,
    onSecondaryContainer = NearBlack,
    tertiary = OrangeDeep,
    onTertiary = Color.White,
    background = White,
    onBackground = NearBlack,
    surface = White,
    onSurface = NearBlack,
    surfaceVariant = Gray50,
    onSurfaceVariant = Gray600,
    surfaceContainerLowest = White,
    surfaceContainerLow = WhiteSoft,
    surfaceContainer = Gray50,
    surfaceContainerHigh = Gray100,
    surfaceContainerHighest = Gray200,
    outline = Gray200,
    outlineVariant = Gray100,
    error = Error,
    onError = Color.White,
)

// Sonettas dark color scheme — near black based
private val SonettasDarkColors = darkColorScheme(
    primary = Orange,
    onPrimary = Color.White,
    primaryContainer = OrangeDeep,
    onPrimaryContainer = OrangeLight,
    secondary = Gray400,
    onSecondary = NearBlack,
    background = NearBlack,
    onBackground = White,
    surface = BlackSoft,
    onSurface = White,
    surfaceVariant = BlackSoft,
    onSurfaceVariant = Gray400,
    outline = Gray600,
    outlineVariant = BlackSoft,
    error = Error,
    onError = Color.White,
)

@Composable
fun SonettasTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) SonettasDarkColors else SonettasLightColors
    MaterialTheme(
        colorScheme = colors,
        content = content,
    )
}
