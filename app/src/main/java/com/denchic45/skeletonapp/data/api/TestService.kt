package com.denchic45.skeletonapp.data.api

import com.denchic45.skeletonapp.di.AuthHttpClient
import io.ktor.client.call.*
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

    suspend fun testUploadMedia(byteArray: ByteArray) {
        client.post {
            parameter("dir", "test directory")
            setBody(byteArray)
        }
    }

    suspend fun testGetUrlMedia(dir: String, name: String): String {
        return client.get {
            parameter("dir", dir)
            parameter("name", name)
        }.body()
    }
}