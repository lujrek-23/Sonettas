/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app.library

import kotlinx.coroutines.flow.Flow
import com.sonettas.app.repository.LibraryTopMixRepository
import javax.inject.Inject

class ObserveLibraryTopMixesUseCase
    @Inject
    constructor(
        private val repository: LibraryTopMixRepository,
    ) {
        operator fun invoke(): Flow<List<LibraryTopMix>> = repository.observePersistedTopMixes()
    }
