/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import moe.rukamori.archivetune.innertube.YouTube
import moe.rukamori.archivetune.innertube.pages.MoodAndGenres
import com.sonettas.app.utils.reportException
import javax.inject.Inject

@HiltViewModel
class MoodAndGenresViewModel
    @Inject
    constructor() : ViewModel() {
        val moodAndGenres = MutableStateFlow<List<MoodAndGenres.Item>?>(null)

        init {
            viewModelScope.launch {
                YouTube
                    .explore()
                    .onSuccess {
                        moodAndGenres.value = it.moodAndGenres
                    }.onFailure {
                        reportException(it)
                    }
            }
        }
    }
