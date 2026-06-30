/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Typography — Hanken Grotesk (single family, all roles).
 * Per brand.md: NOT on reflex-reject list. Warm geometric, distinctive.
 * Brand voice: precise, warm, confident.
 *
 * 4 sizes, 2 weights per role:
 * - Display: Bold (700) — hero, screen titles
 * - Body: Medium (500) — primary text
 * - Body: Regular (400) — secondary text
 * - Label: SemiBold (600) — section headers, buttons
 */

package com.sonettas.app.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sonettas.app.R

val SonettasFontFamily = FontFamily(
    Font(R.font.hanken_grotesk_variable, FontWeight.Normal),    // 400
    Font(R.font.hanken_grotesk_variable, FontWeight.Medium),    // 500
    Font(R.font.hanken_grotesk_variable, FontWeight.SemiBold),  // 600
    Font(R.font.hanken_grotesk_variable, FontWeight.Bold),      // 700
    Font(R.font.hanken_grotesk_variable, FontWeight.ExtraBold), // 800
)

val SonettasDisplayFamily = SonettasFontFamily
val SonettasBodyFamily = SonettasFontFamily
val SonettasMonoFamily = SonettasFontFamily

object SonettasType {
    val hero = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 38.sp,
        letterSpacing = (-1).sp,
        lineHeight = 44.sp,
    )

    val titleLarge = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        letterSpacing = (-0.3).sp,
        lineHeight = 30.sp,
    )

    val title = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp,
        letterSpacing = 0.sp,
        lineHeight = 22.sp,
    )

    val bodyLarge = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        letterSpacing = 0.sp,
        lineHeight = 22.sp,
    )

    val body = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.Normal,
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

    val label = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        letterSpacing = 0.3.sp,
        lineHeight = 16.sp,
    )

    val caption = TextStyle(
        fontFamily = SonettasFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        lineHeight = 16.sp,
    )

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
