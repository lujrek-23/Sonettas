/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Material3 theme wrapper — Sonettas identity.
 * Pure white, vibrant orange, Hanken Grotesk.
 *
 * Accepts the legacy Huasic-style theme parameters (pureBlack,
 * themeColor, seedPalette, disableAnimations, fontPreference,
 * customFontUri) for backward compatibility with ported code, but
 * Sonettas ignores the dynamic-color ones and always renders its
 * fixed Orange palette.
 */

package com.sonettas.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.sonettas.app.constants.AppFontPreference

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

/**
 * SonettasTheme — accepts legacy Huasic parameters but ignores the
 * dynamic-color ones (themeColor, seedPalette, pureBlack, disableAnimations,
 * fontPreference, customFontUri) because Sonettas uses a fixed palette.
 *
 * All parameters are kept optional with defaults so existing call sites
 * compile without modification.
 */
@Composable
fun SonettasTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    pureBlack: Boolean = false,
    themeColor: Color = DefaultThemeColor,
    seedPalette: ThemeSeedPalette? = null,
    disableAnimations: Boolean = false,
    fontPreference: AppFontPreference = AppFontPreference.DEFAULT,
    customFontUri: String = "",
    content: @Composable () -> Unit,
) {
    // Sonettas ignores themeColor/seedPalette/pureBlack/disableAnimations/
    // fontPreference/customFontUri — the palette is fixed Orange.
    // The parameters are accepted solely so ported call sites compile.
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    val ignored =
        listOf(pureBlack, themeColor, seedPalette, disableAnimations, fontPreference, customFontUri)

    val colors = if (darkTheme) SonettasDarkColors else SonettasLightColors
    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content,
    )
}
