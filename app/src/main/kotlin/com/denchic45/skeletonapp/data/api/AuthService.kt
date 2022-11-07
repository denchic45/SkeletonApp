package com.denchic45.skeletonapp.data.api

import com.denchic45.skeletonapp.data.model.LoginRequest
import com.denchic45.skeletonapp.data.model.LoginResponse
import com.denchic45.skeletonapp.data.preference.AppDataStore
import com.denchic45.skeletonapp.di.GuestHttpClient
import com.denchic45.skeletonapp.util.Defaults
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import me.tatarka.inject.annotations.Inject

@Inject
class AuthService(
    private val guestHttpClient: GuestHttpClient,
    private val appDataStore: AppDataStore
) {

    suspend fun login(email: String, password: String) {
        guestHttpClient.post(Defaults.url + "/auth/login") {
            contentType(ContentType.Application.Json)
            setBody(LoginRequest(email, password))
        }.apply {
            appDataStore.setToken(body<LoginResponse>().token)
        }
    }
}