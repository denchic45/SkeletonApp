package com.denchic45.skeletonapp.dataa.preference

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.denchic45.skeletonapp.di.PreferenceStore
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class AppDataStore(private val context: Context) {

    private val Context.dataStore: PreferenceStore by preferencesDataStore(name = "app")

    var token: Flow<String?> = context.dataStore.data.map { it[TOKEN] }

    fun setToken(token: String) {
        GlobalScope.launch {
            context.dataStore.updateData { it.toMutablePreferences().apply { set(TOKEN, token) } }
        }
    }

    companion object {
        val TOKEN = stringPreferencesKey("token")
    }
}