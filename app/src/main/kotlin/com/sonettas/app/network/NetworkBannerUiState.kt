/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.network

sealed interface NetworkBannerUiState {
    data object Hidden : NetworkBannerUiState

    data object Offline : NetworkBannerUiState

    data object BackOnline : NetworkBannerUiState
}
