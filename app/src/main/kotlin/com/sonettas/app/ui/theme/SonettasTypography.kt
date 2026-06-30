/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Typography — Plus Jakarta Sans (single family, all roles).
 * Per brand.md: reject reflex defaults (Fraunces, DM Sans, Inter).
 * Plus Jakarta Sans is NOT on the reject list — distinctive, warm, geometric.
 *
 * 4 sizes, 2 weights per role:
 * - Display: ExtraBold (800) — hero, screen titles
 * - Body: Medium (500) — primary text
 * - Body: Regular (400) — secondary text
 * - Label: Bold (700) — section headers, buttons
 */

package com.sonettas.app.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sonettas.app.R

// Single font family — Plus Jakarta Sans for ALL roles
val SonettasFontFamily = FontFamily(
    Font(R.font.plus_jakarta_sans_variable, FontWeight.Normal),    // 400
    Font(R.font.plus_jakarta_sans_variable, FontWeight.Medium),    // 500
    Font(R.font.plus_jakarta_sans_variable, FontWeight.SemiBold),  // 600
    Font(R.font.plus_jakarta_sans_variable, FontWeight.Bold),      // 700
    Font(R.font.plus_jakarta_sans_variable, FontWeight.ExtraBold), // 800
)

// Alias for display (same family, different usage context)
val SonettasFontFamily = SonettasFontFamily
val SonettasFontFamily = SonettasFontFamily
val SonettasFontFamily = SonettasFontFamily

object SonettasType {
    // ── Display — ExtraBold, tight tracking ──────────────────────────────
    val hero = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 42.sp,
        letterSpacing = (-1.5).sp,
        lineHeight = 48.sp,
    )

    val titleLarge = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        letterSpacing = (-0.5).sp,
        lineHeight = 32.sp,
    )

    val title = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        letterSpacing = 0.sp,
        lineHeight = 24.sp,
    )

    // ── Body — Medium/Regular ────────────────────────────────────────────
    val bodyLarge = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        lineHeight = 24.sp,
    )

    val body = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.Regular,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        lineHeight = 20.sp,
    )

    val bodyBold = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        lineHeight = 20.sp,
    )

    // ── Label — Bold, tight ──────────────────────────────────────────────
    val label = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        letterSpacing = 0.3.sp,
        lineHeight = 16.sp,
    )

    val caption = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.Regular,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        lineHeight = 16.sp,
    )

    // ── Mono (same family, for data) ─────────────────────────────────────
    val mono = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        letterSpacing = 0.sp,
        lineHeight = 18.sp,
    )
}

object SonettasTextOpacity {
    const val Primary = 1.0f
    const val Body = 0.88f
    const val Secondary = 0.60f
    const val Tertiary = 0.38f
}
