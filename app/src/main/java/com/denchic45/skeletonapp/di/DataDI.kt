package com.denchic45.skeletonapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.denchic45.skeletonapp.data.preference.AppDataStore
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@DataScope
@Component
abstract class DataDI {

    fun providePreferenceStore(context: Context): PreferenceStore = context.appPreferenceStore

    @DataScope
    @Provides
    fun provideAppDataStore(): AppDataStore {
        return AppDataStore(providePreferenceStore(TODO()))
    }

    private val Context.appPreferenceStore: PreferenceStore by preferencesDataStore(name = "app")
}

typealias PreferenceStore = DataStore<Preferences>