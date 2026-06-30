/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Navigation routes — 3 main tabs + detail routes.
 * Flat structure, no nested nav graphs.
 */

package com.sonettas.app.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.sonettas.app.R

@Immutable
sealed class Screen(
    @StringRes val titleRes: Int,
    @DrawableRes val iconRes: Int,
    @DrawableRes val activeIconRes: Int,
    val route: String,
) {
    object Home : Screen(
        titleRes = R.string.tab_home,
        iconRes = R.drawable.ic_home,
        activeIconRes = R.drawable.ic_home,
        route = "home",
    )

    object Search : Screen(
        titleRes = R.string.tab_search,
        iconRes = R.drawable.ic_search,
        activeIconRes = R.drawable.ic_search,
        route = "search",
    )

    object Library : Screen(
        titleRes = R.string.tab_library,
        iconRes = R.drawable.ic_library,
        activeIconRes = R.drawable.ic_library,
        route = "library",
    )

    companion object {
        val tabs = listOf(Home, Search, Library)
    }
}
