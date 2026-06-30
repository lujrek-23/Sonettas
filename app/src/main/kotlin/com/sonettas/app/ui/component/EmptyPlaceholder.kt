/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Empty placeholder — Sonettas style.
 * Per interaction-design.md: empty state is an invitation to act.
 * Per polish.md: consistent with design tokens.
 * Per colorize.md: orange for icon (state indicator), gray for text.
 */

package com.sonettas.app.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sonettas.app.ui.theme.Gray400
import com.sonettas.app.ui.theme.Gray50
import com.sonettas.app.ui.theme.Orange
import com.sonettas.app.ui.theme.SonettasFontFamily
import com.sonettas.app.ui.theme.SonettasPadding
import com.sonettas.app.ui.theme.SonettasRadius
import com.sonettas.app.ui.theme.SonettasSpacing
import com.sonettas.app.ui.theme.SonettasType

@Composable
fun EmptyPlaceholder(
    @DrawableRes icon: Int,
    text: String,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = SonettasPadding.screen, vertical = SonettasSpacing.xxxl),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            // Rounded square icon container (NOT circle — Sonettas uses 12dp radius)
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(SonettasRadius.md))
                    .background(Orange.copy(alpha = 0.08f)),
            ) {
                Image(
                    painter = painterResource(icon),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Orange.copy(alpha = 0.6f)),
                    modifier = Modifier.size(36.dp),
                )
            }

            Spacer(Modifier.height(SonettasSpacing.lg))

            Text(
                text = text,
                style = SonettasType.body,
                fontFamily = SonettasFontFamily,
                fontWeight = FontWeight.Medium,
                color = Gray400,
                textAlign = TextAlign.Center,
            )
        }
    }
}
