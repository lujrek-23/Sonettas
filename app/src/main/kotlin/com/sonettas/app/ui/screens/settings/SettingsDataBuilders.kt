/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Settings — minimal, flat, 6 items only.
 * NO groups, NO nested screens, NO 27 sub-pages.
 * Everything inline or one tap deep.
 */

package com.sonettas.app.ui.screens.settings

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.sonettas.app.R
import com.sonettas.app.ui.theme.NearBlack
import com.sonettas.app.ui.theme.Orange
import com.sonettas.app.ui.theme.Gray600
import androidx.compose.ui.graphics.Color

@Composable
fun buildSettingsGroups(
    navController: NavController,
    isAndroid12OrLater: Boolean,
    hasUpdate: Boolean,
    context: Context,
): List<SettingsGroup> =
    listOf(
        SettingsGroup(
            title = "",
            items = listOf(
                // 1. Account — YouTube Music login
                SettingsItem(
                    key = "account",
                    icon = painterResource(R.drawable.account),
                    title = "Akun",
                    subtitle = "Login YouTube Music",
                    accentColor = Orange,
                    onClick = { navController.navigate("settings/account") },
                ),
                // 2. Appearance — theme color, dark mode, font
                SettingsItem(
                    key = "appearance",
                    icon = painterResource(R.drawable.palette),
                    title = "Tampilan",
                    subtitle = "Tema, warna, font",
                    accentColor = NearBlack,
                    onClick = { navController.navigate("settings/appearance") },
                ),
                // 3. Playback — normalization, crossfade, skip silence
                SettingsItem(
                    key = "playback",
                    icon = painterResource(R.drawable.music_note),
                    title = "Pemutaran",
                    subtitle = "Audio, crossfade, normalisasi",
                    accentColor = Gray600,
                    onClick = { navController.navigate("settings/player") },
                ),
                // 4. Lyrics — provider toggles, font size
                SettingsItem(
                    key = "lyrics",
                    icon = painterResource(R.drawable.lyrics),
                    title = "Lirik",
                    subtitle = "Penyedia dan tampilan lirik",
                    accentColor = Orange,
                    onClick = { navController.navigate("settings/lyrics") },
                ),
                // 5. Storage — cache size, clear cache, download location
                SettingsItem(
                    key = "storage",
                    icon = painterResource(R.drawable.storage),
                    title = "Penyimpanan",
                    subtitle = "Cache, unduhan, lokasi",
                    accentColor = NearBlack,
                    onClick = { navController.navigate("settings/storage") },
                ),
                // 6. About — version, license, credits
                SettingsItem(
                    key = "about",
                    icon = painterResource(R.drawable.info),
                    title = "Tentang",
                    subtitle = "Versi, lisensi, kredit",
                    accentColor = Gray600,
                    onClick = { navController.navigate("settings/about") },
                ),
            ),
        ),
    )
