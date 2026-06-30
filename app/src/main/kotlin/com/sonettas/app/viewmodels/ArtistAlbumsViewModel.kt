/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import com.sonettas.app.db.MusicDatabase
import javax.inject.Inject

@HiltViewModel
class ArtistAlbumsViewModel
    @Inject
    constructor(
        database: MusicDatabase,
        savedStateHandle: SavedStateHandle,
    ) : ViewModel() {
        private val artistId = savedStateHandle.get<String>("artistId")!!
        val artist =
            database
                .artist(artistId)
                .stateIn(viewModelScope, SharingStarted.Lazily, null)

        val albums =
            database
                .artistAlbumsPreview(artistId)
                .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    }
