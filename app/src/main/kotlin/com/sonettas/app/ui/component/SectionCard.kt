/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Section card — shadow-based, rounded 12dp.
 * NOT hairline border like Sonettas.
 */

package com.sonettas.app.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.sonettas.app.ui.theme.SonettasPadding
import com.sonettas.app.ui.theme.SonettasRadius
import com.sonettas.app.ui.theme.SonettasType
import com.sonettas.app.ui.theme.NearBlack
import com.sonettas.app.ui.theme.White
import com.sonettas.app.ui.theme.CardShadowColor

@Composable
fun SectionCard(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = SonettasPadding.screen),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        // Bold sans title — NOT eyebrow + serif + hairline like Sonettas
        Text(
            text = title,
            style = SonettasType.titleLarge,
            color = NearBlack,
        )
        // Shadow card — NOT hairline border
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(SonettasRadius.md),
                    spotColor = CardShadowColor,
                ),
            shape = RoundedCornerShape(SonettasRadius.md),
            color = White,
        ) {
            Column(
                modifier = Modifier.padding(SonettasPadding.card),
            ) {
                content()
            }
        }
    }
}
