/*
 * Sonettas (2026)
 * © Huanime Company
 *
 * STUB — Cast player menu action removed.
 */

package com.sonettas.app.ui.menu

import androidx.compose.runtime.Composable

/**
 * No-op cast player menu action.
 * Returns null since cast feature is removed.
 */
@Composable
fun rememberCastPlayerMenuAction(): CastPlayerMenuAction? = null

/**
 * Stub class for cast player menu action.
 */
sealed class CastPlayerMenuAction {
    data object Connect : CastPlayerMenuAction()
    data object Disconnect : CastPlayerMenuAction()
}
