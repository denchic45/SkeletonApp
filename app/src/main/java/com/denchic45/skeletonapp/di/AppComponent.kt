package com.denchic45.skeletonapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.denchic45.skeletonapp.dataa.api.TestService
import com.denchic45.skeletonapp.dataa.preference.AppDataStore
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.serialization.json.Json
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@AppScope
@Component
abstract class AppComponent(
    @Component val networkComponent: NetworkComponent,
    @get:Provides val context: Context,
) {

    @AppScope
    @Provides
    fun provideComponentContext(): ComponentContext {
        return DefaultComponentContext(LifecycleRegistry())
    }

    @AppScope
    @Provides
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

    @AppScope
    @Provides
    fun provideDataStore(context: Context): PreferenceStore {
        return context.dataStore
    }

    @AppScope
    @Provides
    fun provideAppDataStore(context: Context): AppDataStore {
        return AppDataStore(context)
    }

    private val Context.dataStore: PreferenceStore by preferencesDataStore(name = "app")

    @Provides
    fun provideAuthClient(appDataStore: AppDataStore): HttpClient = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(DefaultRequest) {
            url("https://3d79-176-214-128-79.eu.ngrok.io")
        }
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                encodeDefaults = true
            })
        }
        install(Auth) {
            bearer {
                loadTokens {
                    appDataStore.token.filterNotNull().first().let { token ->
                        BearerTokens(token, "")
                    }

                }
            }
        }
    }


    abstract val testService: TestService

    companion object
}

typealias PreferenceStore = DataStore<Preferences>

