/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Greeting bar — bold sans, simple, confident.
 * Per brand.md: NOT editorial-typographic. No serif, no eyebrow, no hairline.
 * Per layout.md: tight grouping for greeting + label, generous space after.
 */

package com.sonettas.app.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sonettas.app.ui.theme.Gray400
import com.sonettas.app.ui.theme.NearBlack
import com.sonettas.app.ui.theme.SonettasFontFamily
import com.sonettas.app.ui.theme.SonettasPadding
import com.sonettas.app.ui.theme.SonettasSpacing
import com.sonettas.app.ui.theme.SonettasType
import androidx.compose.ui.text.font.FontWeight

@Composable
fun GreetingBar(
    accountName: String? = null,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = SonettasPadding.screen, vertical = SonettasSpacing.xl),
    ) {
        Text(
            text = "Hai, apa yang diputar?",
            style = SonettasType.hero,
            fontFamily = SonettasFontFamily,
            fontWeight = FontWeight.Bold,
            color = NearBlack,
        )
        Spacer(modifier = Modifier.height(SonettasSpacing.xs))
        Text(
            text = "Sonettas",
            style = SonettasType.caption,
            fontFamily = SonettasFontFamily,
            color = Gray400,
        )
    }
}
