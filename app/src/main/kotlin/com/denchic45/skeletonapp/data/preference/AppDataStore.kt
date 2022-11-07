package com.denchic45.skeletonapp.data.preference

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.denchic45.skeletonapp.di.PreferenceStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppDataStore(private val preferenceStore: PreferenceStore) {

    var token: Flow<String?> = preferenceStore.data.map { it[TOKEN] }

    suspend fun setToken(token: String) {
        preferenceStore.edit { it[TOKEN] = token }
    }

    companion object {
        val TOKEN = stringPreferencesKey("token")
    }
}