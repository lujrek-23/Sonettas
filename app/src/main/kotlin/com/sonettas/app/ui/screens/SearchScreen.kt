/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Search screen — clean search bar + results.
 * NOT tabbed online/local like Huasic. Single search.
 */

package com.sonettas.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sonettas.app.R
import com.sonettas.app.ui.theme.Gray200
import com.sonettas.app.ui.theme.Gray400
import com.sonettas.app.ui.theme.Gray50
import com.sonettas.app.ui.theme.NearBlack
import com.sonettas.app.ui.theme.Orange
import com.sonettas.app.ui.theme.SonettasPadding
import com.sonettas.app.ui.theme.SonettasType
import com.sonettas.app.ui.theme.White

@Composable
fun SearchScreen(
    onNavigate: (String) -> Unit,
) {
    var query by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = SonettasPadding.screen, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        // Search bar — outlined, rounded, orange focus
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = stringResource(R.string.search_hint),
                    style = SonettasType.body,
                    color = Gray400,
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = null,
                    tint = Gray400,
                )
            },
            shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Orange,
                unfocusedBorderColor = Gray200,
                focusedContainerColor = White,
                unfocusedContainerColor = Gray50,
                cursorColor = Orange,
            ),
            textStyle = SonettasType.bodyLarge,
            singleLine = true,
        )

        // Results or recent
        if (query.isBlank()) {
            // Recent searches placeholder
            Text(
                text = stringResource(R.string.search_recent),
                style = SonettasType.title,
                color = NearBlack,
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(5) { index ->
                    Text(
                        text = "Pencarian ${index + 1}",
                        style = SonettasType.body,
                        color = Gray400,
                        modifier = Modifier.padding(vertical = 8.dp),
                    )
                }
            }
        } else {
            // Search results placeholder
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(8) { index ->
                    androidx.compose.foundation.layout.Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                    ) {
                        Surface(
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
                            color = if (index % 3 == 0) Orange.copy(alpha = 0.15f) else Gray50,
                            modifier = Modifier.size(40.dp),
                        ) {}
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Hasil ${index + 1} untuk \"$query\"",
                                style = SonettasType.bodyBold,
                                color = NearBlack,
                            )
                            Text(
                                text = "Artis • Lagu",
                                style = SonettasType.caption,
                                color = Gray400,
                            )
                        }
                    }
                }
            }
        }
    }
}
