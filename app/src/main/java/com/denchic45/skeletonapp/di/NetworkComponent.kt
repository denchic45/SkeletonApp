package com.denchic45.skeletonapp.di

import com.denchic45.skeletonapp.data.preference.AppDataStore
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@NetworkScope
@Component
abstract class NetworkComponent(
    @Component val dataComponent: DataComponent
) {

    @NetworkScope
    @Provides
    fun provideGuestClient(): GuestHttpClient = HttpClient(Android) {
        defaultConfig()
    }

    @NetworkScope
    @Provides
    fun provideAuthClient(
        appDataStore: AppDataStore
    ): AuthHttpClient = HttpClient(Android) {
//        defaultConfig()
//        install(DefaultRequest) {
//            url(Defaults.url)
//        }
//        install(Auth) {
//            bearer {
//                loadTokens {
//                    appDataStore.token.filterNotNull().first().let { token ->
//                        BearerTokens(token, "")
//                    }
//                }
//            }
//        }
    }

    private fun HttpClientConfig<AndroidEngineConfig>.defaultConfig() {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                encodeDefaults = true
            })
        }
    }
}

typealias AuthHttpClient = HttpClient
typealias GuestHttpClient = HttpClient