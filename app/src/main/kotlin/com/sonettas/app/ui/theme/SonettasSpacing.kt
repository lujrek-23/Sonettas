/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Spacing & motion tokens.
 * Per layout.md: 4pt base scale (4,8,12,16,24,32,48,64,96).
 * Per animate.md: 150-250ms transitions, one hero moment.
 */

package com.sonettas.app.ui.theme

import androidx.compose.ui.unit.dp

// ── 4pt base spacing scale ────────────────────────────────────────────────
// Per layout.md: 4pt is better than 8pt (more flexibility for 12px gaps)
object SonettasSpacing {
    val xs = 4.dp
    val sm = 8.dp
    val md = 12.dp
    val lg = 16.dp
    val xl = 24.dp
    val xxl = 32.dp
    val xxxl = 48.dp
    val huge = 64.dp
    val mega = 96.dp
}

object SonettasPadding {
    val screen = 20.dp
    val card = 16.dp
    val cardLarge = 20.dp
    val section = 24.dp
    val sectionLarge = 32.dp
    val fabClearance = 80.dp
}

// ── Shape ─────────────────────────────────────────────────────────────────
// Per shape.md: consistent radius across all components
object SonettasRadius {
    val sm = 8.dp       // inputs, chips, small elements
    val md = 12.dp      // cards, sheets, dialogs
    val lg = 16.dp      // large cards, bottom sheets
    val xl = 20.dp      // modals
    val pill = 999.dp   // pills, badges
}

// ── Tap targets ───────────────────────────────────────────────────────────
// Per interaction-design.md: minimum 48dp
object SonettasTapTarget {
    val min = 48.dp
    val comfortable = 56.dp
}

// ── Motion ────────────────────────────────────────────────────────────────
// Per animate.md: 150-250ms for most transitions
// Hero moment: Player expand (400ms)
// Stagger: 50ms per item, cap 500ms total
object SonettasMotion {
    object Duration {
        const val instant = 0
        const val micro = 100       // tap feedback start
        const val fast = 150        // tap feedback, chip select
        const val normal = 200      // state changes, sheet expand
        const val slow = 250        // screen transitions
        const val hero = 400        // player expand, splash
        const val stagger = 50      // per-item delay
        const val staggerCap = 500  // max total stagger time
    }

    // Easing — Material standard
    // cubic-bezier(0.4, 0, 0.2, 1)
    const val StandardEasing = 0.4f  // placeholder, use Compose easings in code
}

// ── Elevation ─────────────────────────────────────────────────────────────
// Per polish.md: subtle shadows, not heavy
object SonettasElevation {
    val none = 0.dp
    val hairline = 0.5.dp
    val raised = 1.dp     // cards at rest
    val hover = 2.dp      // cards on hover/active
    val floating = 4.dp   // FAB, modals
    val dragged = 8.dp    // dragged elements
}
