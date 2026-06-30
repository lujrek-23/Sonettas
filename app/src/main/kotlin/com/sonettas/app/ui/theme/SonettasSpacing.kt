/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Spacing & motion tokens.
 * Different corner radius (12dp vs Huasic's 4dp).
 * Different spacing scale.
 */

package com.sonettas.app.ui.theme

import androidx.compose.ui.unit.dp

object SonettasSpacing {
    val xs = 4.dp
    val sm = 8.dp
    val md = 12.dp
    val lg = 16.dp
    val xl = 20.dp
    val xxl = 28.dp
    val xxxl = 40.dp
    val huge = 56.dp
}

object SonettasPadding {
    val screen = 20.dp       // Huasic uses 24dp
    val card = 16.dp         // Huasic uses 24dp
    val cardLarge = 20.dp
    val section = 28.dp      // Huasic uses 32dp
}

// Huasic: 2/4/8dp (sharp, editorial)
// Sonettas: 8/12/16dp (rounded, modern)
object SonettasRadius {
    val sm = 8.dp
    val md = 12.dp
    val lg = 16.dp
    val xl = 20.dp
    val pill = 999.dp
}

object SonettasTapTarget {
    val min = 48.dp
    val comfortable = 56.dp
}

object SonettasMotion {
    object Duration {
        const val instant = 0
        const val fast = 150
        const val normal = 250
        const val slow = 400
    }
}
