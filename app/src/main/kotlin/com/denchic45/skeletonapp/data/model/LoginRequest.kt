package com.denchic45.skeletonapp.data.model

@kotlinx.serialization.Serializable
data class LoginRequest(private val login: String, private val password: String)
