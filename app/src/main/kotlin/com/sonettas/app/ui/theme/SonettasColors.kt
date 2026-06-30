/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Design tokens — Restrained color strategy.
 * Per colorize.md: Orange reserved for primary action, selection, state ONLY.
 * 60% White, 30% NearBlack, 10% Orange.
 */

package com.sonettas.app.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// ── 60% Background ────────────────────────────────────────────────────────
val White = Color(0xFFFFFFFF)
val WhiteSoft = Color(0xFFFAFAFA)
val Gray50 = Color(0xFFF9F9F9)
val Gray100 = Color(0xFFF5F5F5)
val Gray200 = Color(0xFFE5E5E5)
val Gray300 = Color(0xFFD4D4D4)
val Gray400 = Color(0xFFA3A3A3)
val Gray500 = Color(0xFF737373)
val Gray600 = Color(0xFF525252)
val Gray700 = Color(0xFF404040)
val Gray800 = Color(0xFF262626)

// ── 30% Foreground ────────────────────────────────────────────────────────
val NearBlack = Color(0xFF0A0A0A)
val BlackSoft = Color(0xFF171717)
val BlackPure = Color(0xFF000000)

// ── 10% Accent — RESTRICTED use ───────────────────────────────────────────
// Per colorize.md: primary action, current selection, state indicators ONLY
// NOT for decoration, NOT for backgrounds, NOT for borders
val Orange = Color(0xFFFF6B00)
val OrangeDeep = Color(0xFFE55A00)
val OrangeLight = Color(0xFFFFF0E5)
val OrangeGradient = Brush.horizontalGradient(
    colors = listOf(Orange, OrangeDeep),
)

// ── Semantic — each color has ONE consistent meaning ──────────────────────
val Success = Color(0xFF22C55E)
val Warning = Color(0xFFF59E0B)
val Error = Color(0xFFEF4444)
val Info = Color(0xFF3B82F6)

// ── Shadows ───────────────────────────────────────────────────────────────
// Per polish.md: subtle, not heavy
val CardShadowColor = Color(0x0A000000)    // 4% black
val ElevatedShadowColor = Color(0x14000000) // 8% black

// ── Hairline ──────────────────────────────────────────────────────────────
val HairlineColor = Gray200
