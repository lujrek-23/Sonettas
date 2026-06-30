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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.sonettas.app.db.MusicDatabase
import moe.rukamori.archivetune.innertube.YouTube
import moe.rukamori.archivetune.innertube.models.AlbumItem
import moe.rukamori.archivetune.innertube.models.PlaylistItem
import moe.rukamori.archivetune.innertube.models.YTItem
import moe.rukamori.archivetune.innertube.utils.completed
import com.sonettas.app.utils.reportException
import javax.inject.Inject

@HiltViewModel
class BrowseViewModel
    @Inject
    constructor(
        savedStateHandle: SavedStateHandle,
    ) : ViewModel() {
        private val browseId: String? = savedStateHandle.get<String>("browseId")

        val items = MutableStateFlow<List<YTItem>?>(emptyList())
        val title = MutableStateFlow<String?>("")

        init {
            viewModelScope.launch {
                browseId?.let {
                    YouTube
                        .browse(browseId, null)
                        .onSuccess { result ->
                            // Store the title
                            title.value = result.title

                            // Flatten the nested structure to get all YTItems
                            val allItems = result.items.flatMap { it.items }
                            items.value = allItems
                        }.onFailure {
                            reportException(it)
                        }
                }
            }
        }
    }
