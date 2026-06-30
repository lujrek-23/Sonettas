/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 *
 * MainActivity — navigation host with 3 tabs.
 * Standard bottom nav (NOT floating toolbar like Huasic).
 */

package com.sonettas.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sonettas.app.ui.Screen
import com.sonettas.app.ui.component.SonettasBottomNav
import com.sonettas.app.ui.screens.HomeScreen
import com.sonettas.app.ui.screens.LibraryScreen
import com.sonettas.app.ui.screens.SearchScreen
import com.sonettas.app.ui.theme.SonettasTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SonettasTheme {
                SonettasApp()
            }
        }
    }
}

@Composable
fun SonettasApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            SonettasBottomNav(
                currentRoute = currentRoute,
                onNavigate = { route ->
                    if (route != currentRoute) {
                        navController.navigate(route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
            )
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.fillMaxSize().padding(innerPadding),
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    onNavigate = { route -> navController.navigate(route) },
                )
            }
            composable(Screen.Search.route) {
                SearchScreen(
                    onNavigate = { route -> navController.navigate(route) },
                )
            }
            composable(Screen.Library.route) {
                LibraryScreen(
                    onNavigate = { route -> navController.navigate(route) },
                )
            }
        }
    }

    companion object {
        const val ACTION_SEARCH = "com.sonettas.app.action.SEARCH"
        const val ACTION_LIBRARY = "com.sonettas.app.action.LIBRARY"
        const val ACTION_AOD_MODE = "com.sonettas.app.action.AOD_MODE"
    }
}
