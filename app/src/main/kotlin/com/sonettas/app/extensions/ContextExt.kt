/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.sonettas.app.constants.InnerTubeCookieKey
import com.sonettas.app.constants.YtmSyncKey
import moe.rukamori.archivetune.innertube.utils.hasYouTubeLoginCookie
import com.sonettas.app.utils.dataStore
import com.sonettas.app.utils.get

fun Context.isSyncEnabled(): Boolean = dataStore.get(YtmSyncKey, true) && isUserLoggedIn()

fun Context.isUserLoggedIn(): Boolean {
    val cookie = dataStore[InnerTubeCookieKey] ?: ""
    return hasYouTubeLoginCookie(cookie) && isInternetConnected()
}

fun Context.isInternetConnected(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
}
