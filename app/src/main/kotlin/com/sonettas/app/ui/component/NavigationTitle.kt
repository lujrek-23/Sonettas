/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Section header — Sonettas style.
 * Per brand.md: NOT editorial-typographic (no eyebrow, no hairline, no serif).
 * Per layout.md: bold sans, clean, functional.
 * Per polish.md: consistent with design system tokens.
 *
 * Used across all screens: Home, Library, Album, Artist, Playlist, Search, etc.
 */

package com.sonettas.app.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sonettas.app.R
import com.sonettas.app.ui.theme.Gray400
import com.sonettas.app.ui.theme.Gray600
import com.sonettas.app.ui.theme.NearBlack
import com.sonettas.app.ui.theme.Orange
import com.sonettas.app.ui.theme.SonettasFontFamily
import com.sonettas.app.ui.theme.SonettasPadding
import com.sonettas.app.ui.theme.SonettasSpacing
import com.sonettas.app.ui.theme.SonettasType

@Composable
fun NavigationTitle(
    title: String,
    modifier: Modifier = Modifier,
    label: String? = null,
    subtitle: String? = null,
    thumbnail: (@Composable () -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.systemBars.only(WindowInsetsSides.Horizontal))
            .then(if (onClick != null) Modifier.focusable() else Modifier)
            .clickable(enabled = onClick != null) { onClick?.invoke() }
            .padding(horizontal = SonettasPadding.screen, vertical = SonettasSpacing.md),
    ) {
        thumbnail?.let {
            it()
            Spacer(modifier = Modifier.height(SonettasSpacing.sm))
        }

        // Title row — bold sans + optional "Lihat semua" link
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = title,
                style = SonettasType.titleLarge,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SonettasFontFamily,
                color = NearBlack,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.weight(1f),
            )

            if (onClick != null) {
                Text(
                    text = "Lihat semua",
                    style = SonettasType.label,
                    fontFamily = SonettasFontFamily,
                    color = Orange,
                )
            }
        }

        // Subtitle — gray, small
        subtitle?.let {
            Spacer(modifier = Modifier.height(SonettasSpacing.xs))
            Text(
                text = it,
                style = SonettasType.caption,
                fontFamily = SonettasFontFamily,
                color = Gray400,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        }
    }
}
