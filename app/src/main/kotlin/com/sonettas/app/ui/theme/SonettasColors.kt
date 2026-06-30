/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Design tokens — clean, modern, vibrant.
 * Pure white, near black, vibrant orange.
 * NOT Anthropic warm editorial — this is Sonettas' own identity.
 */

package com.sonettas.app.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// ── Core palette ──────────────────────────────────────────────────────────
// Pure white background (NOT warm paper like Sonettas)
val White = Color(0xFFFFFFFF)
val WhiteSoft = Color(0xFFF9F9F9)
val Gray50 = Color(0xFFF5F5F5)
val Gray100 = Color(0xFFE5E5E5)
val Gray200 = Color(0xFFD4D4D4)
val Gray400 = Color(0xFFA3A3A3)
val Gray600 = Color(0xFF525252)
val NearBlack = Color(0xFF0A0A0A)
val BlackSoft = Color(0xFF171717)

// ── Accent ────────────────────────────────────────────────────────────────
// Vibrant orange (NOT warm terracotta like Sonettas)
val Orange = Color(0xFFFF6B00)
val OrangeDeep = Color(0xFFE55A00)
val OrangeLight = Color(0xFFFFF0E5)
val OrangeGradient = Brush.horizontalGradient(
    colors = listOf(Orange, OrangeDeep),
)

// ── Semantic ──────────────────────────────────────────────────────────────
val Success = Color(0xFF22C55E)
val Warning = Color(0xFFF59E0B)
val Error = Color(0xFFEF4444)

// ── Shadows (Sonettas uses hairline, Sonettas uses shadows) ────────────────
val ShadowColor = Color(0xFF000000)
val CardShadowColor = Color(0x0A000000)  // 4% black
val ElevatedShadowColor = Color(0x14000000)  // 8% black
