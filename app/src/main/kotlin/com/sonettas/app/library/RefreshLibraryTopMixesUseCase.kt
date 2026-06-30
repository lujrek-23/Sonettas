/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.library

import dagger.hilt.android.qualifiers.ApplicationContext
import android.content.Context
import com.sonettas.app.repository.LibraryTopMixRepository
import javax.inject.Inject

/**
 * Stub implementation — AI-powered library top mixes were removed in Sonettas.
 * Always returns Failure so callers degrade gracefully.
 */
class RefreshLibraryTopMixesUseCase
    @Inject
    constructor(
        @ApplicationContext private val context: Context,
        private val repository: LibraryTopMixRepository,
    ) {
        suspend operator fun invoke(): RefreshLibraryTopMixesResult =
            RefreshLibraryTopMixesResult.Failure(TopMixGenerationFailure.AI_NOT_CONFIGURED)
    }

sealed interface RefreshLibraryTopMixesResult {
    data object Success : RefreshLibraryTopMixesResult

    data class Failure(
        val reason: TopMixGenerationFailure,
        val cause: Throwable? = null,
    ) : RefreshLibraryTopMixesResult
}

enum class TopMixGenerationFailure {
    AI_NOT_CONFIGURED,
    NO_RECENT_HISTORY,
    NO_VALID_MIXES,
    AI_REQUEST_FAILED,
}
