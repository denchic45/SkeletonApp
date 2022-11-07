package com.denchic45.skeletonapp.data.model

@kotlinx.serialization.Serializable
data class LoginResponse(val token: String, val role: String)
