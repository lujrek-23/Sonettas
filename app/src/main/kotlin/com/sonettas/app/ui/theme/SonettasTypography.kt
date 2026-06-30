/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Typography — Fraunces (display) + DM Sans (body).
 * Different from Huasic (Newsreader + Spline Sans).
 * Fraunces is more expressive, DM Sans is more geometric.
 */

package com.sonettas.app.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sonettas.app.R

// Font families — DIFFERENT from Huasic
val SonettasDisplayFamily = FontFamily(
    Font(R.font.fraunces_variable, FontWeight.Normal),
    Font(R.font.fraunces_variable, FontWeight.SemiBold),
    Font(R.font.fraunces_variable, FontWeight.Bold),
)

val SonettasBodyFamily = FontFamily(
    Font(R.font.dm_sans_variable, FontWeight.Normal),
    Font(R.font.dm_sans_variable, FontWeight.Medium),
    Font(R.font.dm_sans_variable, FontWeight.SemiBold),
    Font(R.font.dm_sans_variable, FontWeight.Bold),
)

val SonettasMonoFamily = FontFamily(
    Font(R.font.dm_mono_variable, FontWeight.Normal),
    Font(R.font.dm_mono_variable, FontWeight.Medium),
)

object SonettasType {
    // ── Display (Fraunces) — bolder, more expressive than Huasic ────────
    val hero = TextStyle(
        fontFamily = SonettasDisplayFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        letterSpacing = (-1).sp,  // Tight tracking (Huasic uses +2sp)
        lineHeight = 52.sp,
    )

    val titleLarge = TextStyle(
        fontFamily = SonettasDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        letterSpacing = (-0.5).sp,
        lineHeight = 34.sp,
    )

    val title = TextStyle(
        fontFamily = SonettasDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        letterSpacing = 0.sp,
        lineHeight = 26.sp,
    )

    // ── Body (DM Sans) — geometric, clean (Huasic uses Spline Sans) ─────
    val bodyLarge = TextStyle(
        fontFamily = SonettasBodyFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        lineHeight = 24.sp,
    )

    val body = TextStyle(
        fontFamily = SonettasBodyFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        lineHeight = 20.sp,
    )

    val bodyBold = TextStyle(
        fontFamily = SonettasBodyFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        lineHeight = 20.sp,
    )

    // ── Label — BOLD sans, NOT letter-spaced eyebrow like Huasic ────────
    val label = TextStyle(
        fontFamily = SonettasBodyFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 16.sp,
    )

    val caption = TextStyle(
        fontFamily = SonettasBodyFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        lineHeight = 16.sp,
    )

    // ── Mono ─────────────────────────────────────────────────────────────
    val mono = TextStyle(
        fontFamily = SonettasMonoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        letterSpacing = 0.sp,
        lineHeight = 18.sp,
    )
}
