/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Settings screen — single flat page, 6 items, no banners, no groups.
 * Clean, minimal, Sonettas identity.
 */

@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.sonettas.app.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sonettas.app.LocalPlayerAwareWindowInsets
import com.sonettas.app.R
import com.sonettas.app.ui.component.IconButton
import com.sonettas.app.ui.theme.SonettasDisplayFamily
import com.sonettas.app.ui.theme.SonettasType
import com.sonettas.app.ui.utils.backToMain

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController,
    scrollBehavior: TopAppBarScrollBehavior,
    latestVersionName: String,
    onClearUpdateBadge: () -> Unit = {},
) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val listState = rememberLazyListState()

    val settingsGroups = buildSettingsGroups(
        navController = navController,
        isAndroid12OrLater = false,
        hasUpdate = false,
        context = context,
    )
    val settingsItems = settingsGroups.flatMap { it.items }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = MaterialTheme.colorScheme.surface,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pengaturan",
                        style = SonettasType.titleLarge,
                        fontFamily = SonettasDisplayFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = navController::navigateUp,
                        onLongClick = navController::backToMain,
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.arrow_back),
                            contentDescription = null,
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface,
                ),
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        LazyColumn(
            state = listState,
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(
                    LocalPlayerAwareWindowInsets.current.only(
                        WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom,
                    ),
                ),
            contentPadding = PaddingValues(
                top = innerPadding.calculateTopPadding(),
                bottom = 80.dp,
            ),
        ) {
            itemsIndexed(
                items = settingsItems,
                key = { _, item -> item.key },
                contentType = { _, _ -> "settings_item" },
            ) { index, settingsItem ->
                SettingsSegmentedItem(
                    item = settingsItem,
                    index = index,
                    count = settingsItems.size,
                    modifier = Modifier.padding(horizontal = 20.dp),
                )
            }
        }
    }
}
