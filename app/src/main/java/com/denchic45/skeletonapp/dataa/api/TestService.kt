package com.denchic45.skeletonapp.dataa.api

import com.denchic45.skeletonapp.dataa.model.Login
import com.denchic45.skeletonapp.dataa.model.LoginResponse
import com.denchic45.skeletonapp.dataa.preference.AppDataStore
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import me.tatarka.inject.annotations.Inject

@Inject
class TestService(
    private val client: HttpClient,
    private val appDataStore: AppDataStore,
    private val coroutineScope: CoroutineScope,
) {

    private val httpClient = HttpClient(Android) {
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
        defaultRequest { url("https://3d79-176-214-128-79.eu.ngrok.io") }
    }

//    init {
//        coroutineScope.launch(Dispatchers.IO) {
//          try {
//              val status = client.get("vk.com").status
//              println("status: $status")
//          } catch (t:Throwable) {
//              t.printStackTrace()
//          }
//
//        }
//    }

    fun start() {

        println("start:")
        coroutineScope.launch {
            httpClient.post("/auth/login") {
                contentType(ContentType.Application.Json)
                setBody(Login("admin", "admin"))
            }.apply {
                println("end: $status")
                appDataStore.setToken(body<LoginResponse>().token)
            }



            client.get("/info/test") { println("check header: ${headers["Authorization"]}") }.bodyAsText().apply { println("info test: $this") }
        }
    }
}