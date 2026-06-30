/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Bottom navigation — standard NavigationBar.
 * Per layout.md: predictable, consistent, familiar navigation.
 * Per interaction-design.md: 8 states for each tab.
 * Per colorize.md: Orange for selected state ONLY (Restrained).
 */

package com.sonettas.app.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sonettas.app.ui.Screen
import com.sonettas.app.ui.theme.Gray400
import com.sonettas.app.ui.theme.NearBlack
import com.sonettas.app.ui.theme.Orange
import com.sonettas.app.ui.theme.SonettasFontFamily
import com.sonettas.app.ui.theme.SonettasType
import com.sonettas.app.ui.theme.White

@Composable
fun SonettasBottomNav(
    currentRoute: String?,
    onNavigate: (String) -> Unit,
) {
    NavigationBar(
        containerColor = White,
        tonalElevation = 0.dp,
    ) {
        Screen.tabs.forEach { screen ->
            val isSelected = currentRoute == screen.route
            NavigationBarItem(
                selected = isSelected,
                onClick = { onNavigate(screen.route) },
                icon = {
                    Icon(
                        painter = painterResource(screen.iconRes),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                    )
                },
                label = {
                    Text(
                        text = stringResource(screen.titleRes),
                        style = SonettasType.label,
                        fontFamily = SonettasFontFamily,
                        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Orange,
                    selectedTextColor = Orange,
                    unselectedIconColor = Gray400,
                    unselectedTextColor = Gray400,
                    indicatorColor = White,
                ),
            )
        }
    }
}
