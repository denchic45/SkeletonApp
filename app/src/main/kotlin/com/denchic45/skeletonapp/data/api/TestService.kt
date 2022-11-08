package com.denchic45.skeletonapp.data.api

import com.denchic45.skeletonapp.data.model.PublicUrlResponse
import com.denchic45.skeletonapp.di.AuthHttpClient
import com.denchic45.skeletonapp.domain.MediaItem
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import me.tatarka.inject.annotations.Inject

@Inject
class TestService(
    private val client: AuthHttpClient,
) {

    suspend fun checkInfo() {
        client.get("/info/test")
            .bodyAsText().apply { println("info test: $this") }
    }

    suspend fun testUploadMedia(mediaItem: MediaItem, type: String) {
        client.submitFormWithBinaryData(url = "info/test-upload", formData = formData {
            append("file", mediaItem.byteArray, Headers.build {
                append(HttpHeaders.ContentType, mediaItem.mime)
                append(HttpHeaders.ContentDisposition, "filename=\"image.png\"")
            })
            append("type", type)
        }).apply {
            println("status: $status")
            println("body: ${bodyAsText()}")
        }
    }

    suspend fun testGetUrlMedia(dir: String, name: String): String {
        return client.get {
            parameter("dir", dir)
            parameter("name", name)
        }.body()
    }

    suspend fun testUploads(): List<PublicUrlResponse> {
        return client.get("/info/uploads").body()
    }
}