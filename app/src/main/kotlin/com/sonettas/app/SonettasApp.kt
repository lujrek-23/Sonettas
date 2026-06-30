/*
 * Sonettas (2026)
 * © Huanime Company
 * GPL-3.0 License
 */

package com.sonettas.app

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.core.edit
import com.sonettas.app.constants.dataStore
import com.sonettas.app.utils.clearPlaybackAuthSession
import com.sonettas.app.utils.clearPlaybackWebAuthSession
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltAndroidApp
class SonettasApp : Application() {
    companion object {
        lateinit var instance: SonettasApp
            private set

        /**
         * Clears all playback-auth and account-identity state. Used by the
         * "Forget account" action in Settings → Account.
         */
        fun forgetAccount(
            context: Context,
            clearWebAuthSession: Boolean = true,
        ) {
            if (clearWebAuthSession) {
                clearPlaybackWebAuthSession(context)
            }
            CoroutineScope(Dispatchers.IO).launch {
                context.dataStore.edit { settings ->
                    settings.clearPlaybackAuthSession()
                }
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
