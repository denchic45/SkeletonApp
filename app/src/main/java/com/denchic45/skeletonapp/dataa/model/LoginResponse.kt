package com.denchic45.skeletonapp.dataa.model

@kotlinx.serialization.Serializable
data class LoginResponse(val token: String, val role: String)
