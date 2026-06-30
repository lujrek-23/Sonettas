/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Greeting bar — bold sans, NOT serif like Sonettas.
 * Simple: "Hai, apa yang diputar?" — one line, no eyebrow, no hairline.
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
import com.sonettas.app.ui.theme.SonettasPadding
import com.sonettas.app.ui.theme.SonettasType
import com.sonettas.app.ui.theme.NearBlack
import com.sonettas.app.ui.theme.Gray400

@Composable
fun GreetingBar(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = SonettasPadding.screen, vertical = SonettasPadding.section),
    ) {
        // Bold sans greeting — NOT serif, NOT eyebrow
        Text(
            text = "Hai, apa yang diputar?",
            style = SonettasType.hero,
            color = NearBlack,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Sonettas",
            style = SonettasType.caption,
            color = Gray400,
        )
    }
}
