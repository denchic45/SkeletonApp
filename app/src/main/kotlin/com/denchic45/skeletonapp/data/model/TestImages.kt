package com.denchic45.skeletonapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TestImagesResponse(val images: List<PublicUrlResponse>)

@Serializable
data class PublicUrlResponse(val publicUrl: String)