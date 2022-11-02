package com.denchic45.skeletonapp.data.api

import com.denchic45.skeletonapp.data.preference.AppDataStore
import com.denchic45.skeletonapp.di.AuthHttpClient
import io.ktor.client.request.*
import io.ktor.client.statement.*
import me.tatarka.inject.annotations.Inject

@Inject
class TestService(
    private val client: AuthHttpClient
) {

    suspend fun checkInfo() {
        client.get("/info/test")
            .bodyAsText().apply { println("info test: $this") }
    }
}