/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * Struktur pengaturan Sonettas — 3 grup:
 * 1. "Personalisasi" — Akun, Tampilan, Pemutaran, Lirik
 * 2. "Konten & Jaringan" — Integrasi, Konten, Internet, Penyimpanan
 * 3. "Sistem & Tentang" — Statistik, Backup, Pengembang, Tentang
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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.sonettas.app.R
import com.sonettas.app.ui.theme.Ink
import com.sonettas.app.ui.theme.Stone
import com.sonettas.app.ui.theme.Terracotta

@Composable
fun buildSettingsGroups(
    navController: NavController,
    isAndroid12OrLater: Boolean,
    hasUpdate: Boolean,
    context: Context,
): List<SettingsGroup> =
    buildList {
        // Grup 1: Personalisasi — kustomisasi tampilan & pengalaman
        add(
            SettingsGroup(
                title = "Personalisasi",
                items =
                    listOf(
                        SettingsItem(
                            key = "account",
                            icon = painterResource(R.drawable.account),
                            title = "Akun",
                            subtitle = "Kelola akun YouTube Music Anda",
                            accentColor = Terracotta,
                            onClick = { navController.navigate("settings/account") },
                        ),
                        SettingsItem(
                            key = "appearance",
                            icon = painterResource(R.drawable.palette),
                            title = "Tampilan",
                            subtitle = "Tema, warna, dan layout Sonettas",
                            accentColor = Ink,
                            onClick = { navController.navigate("settings/appearance") },
                        ),
                        SettingsItem(
                            key = "playback",
                            icon = painterResource(R.drawable.music_note),
                            title = "Pemutaran",
                            subtitle = "Kontrol audio, normalisasi, crossfade",
                            accentColor = Stone,
                            onClick = { navController.navigate("settings/player") },
                        ),
                        SettingsItem(
                            key = "lyrics",
                            icon = painterResource(R.drawable.lyrics),
                            title = "Lirik",
                            subtitle = "Penyedia lirik dan animasi",
                            accentColor = Ink,
                            onClick = { navController.navigate("settings/lyrics") },
                        ),
                    ),
            ),
        )

        // Grup 2: Konten & Jaringan
        add(
            SettingsGroup(
                title = "Konten & Jaringan",
                items =
                    listOf(
                        SettingsItem(
                            key = "integration",
                            icon = painterResource(R.drawable.auto_awesome),
                            title = "Integrasi",
                            subtitle = "Last.fm scrobbling",
                            accentColor = Terracotta,
                            onClick = { navController.navigate("settings/integration") },
                        ),
                        SettingsItem(
                            key = "content",
                            icon = painterResource(R.drawable.language),
                            title = "Konten",
                            subtitle = "Bahasa dan wilayah konten",
                            accentColor = Stone,
                            onClick = { navController.navigate("settings/content") },
                        ),
                        SettingsItem(
                            key = "internet",
                            icon = painterResource(R.drawable.wifi_proxy),
                            title = "Internet",
                            subtitle = "Proxy, DNS, dan koneksi",
                            accentColor = Ink,
                            onClick = { navController.navigate("settings/internet") },
                        ),
                        SettingsItem(
                            key = "po_token",
                            icon = painterResource(R.drawable.token),
                            title = "PoToken",
                            subtitle = "Token verifikasi YouTube",
                            accentColor = Terracotta,
                            onClick = { navController.navigate("settings/po_token") },
                        ),
                        SettingsItem(
                            key = "storage",
                            icon = painterResource(R.drawable.storage),
                            title = "Penyimpanan",
                            subtitle = "Cache, unduhan, dan lokasi",
                            accentColor = Stone,
                            onClick = { navController.navigate("settings/storage") },
                        ),
                    ),
            ),
        )

        // Grup 3: Sistem & Tentang
        add(
            SettingsGroup(
                title = "Sistem & Tentang",
                items =
                    buildList {
                        add(
                            SettingsItem(
                                key = "behavior",
                                icon = painterResource(R.drawable.swipe),
                                title = "Perilaku & Privasi",
                                subtitle = "Gestur, riwayat, dan privasi",
                                accentColor = Ink,
                                onClick = { navController.navigate("settings/privacy") },
                            ),
                        )
                        add(
                            SettingsItem(
                                key = "stats",
                                icon = painterResource(R.drawable.stats),
                                title = "Statistik",
                                subtitle = "Riwayat dan statistik mendengarkan",
                                accentColor = Terracotta,
                                onClick = { navController.navigate("stats") },
                            ),
                        )
                        add(
                            SettingsItem(
                                key = "backup_restore",
                                icon = painterResource(R.drawable.backup),
                                title = "Backup & Pulihkan",
                                subtitle = "Cadangkan data Anda",
                                accentColor = Stone,
                                onClick = { navController.navigate("settings/backup_restore") },
                            ),
                        )
                        add(
                            SettingsItem(
                                key = "developer_options",
                                icon = painterResource(R.drawable.experiment),
                                title = "Opsi Pengembang",
                                subtitle = "Alat debug dan diagnostik",
                                accentColor = Ink,
                                onClick = { navController.navigate("settings/misc") },
                            ),
                        )
                        if (isAndroid12OrLater) {
                            add(
                                SettingsItem(
                                    key = "default_links",
                                    icon = painterResource(R.drawable.link),
                                    title = "Tautan Default",
                                    subtitle = "Buka tautan yang didukung",
                                    accentColor = Terracotta,
                                    onClick = {
                                        try {
                                            val intent =
                                                Intent(
                                                    Settings.ACTION_APP_OPEN_BY_DEFAULT_SETTINGS,
                                                    Uri.parse("package:${context.packageName}"),
                                                )
                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                            context.startActivity(intent)
                                        } catch (e: Exception) {
                                            Toast
                                                .makeText(
                                                    context,
                                                    R.string.open_app_settings_error,
                                                    Toast.LENGTH_LONG,
                                                ).show()
                                        }
                                    },
                                ),
                            )
                        }
                        add(
                            SettingsItem(
                                key = "about",
                                icon = painterResource(R.drawable.info),
                                title = "Tentang Sonettas",
                                subtitle = "Versi, lisensi, dan kredit",
                                accentColor = Stone,
                                onClick = { navController.navigate("settings/about") },
                            ),
                        )
                    },
            ),
        )
    }
