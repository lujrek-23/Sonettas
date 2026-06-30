/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.sonettas.app.lyrics.LyricsHelper
import com.sonettas.app.lyrics.LyricsPreloadManager

@EntryPoint
@InstallIn(SingletonComponent::class)
interface LyricsHelperEntryPoint {
    fun lyricsHelper(): LyricsHelper

    fun lyricsPreloadManager(): LyricsPreloadManager
}
