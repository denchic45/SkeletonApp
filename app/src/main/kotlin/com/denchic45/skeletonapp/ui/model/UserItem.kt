package com.denchic45.skeletonapp.ui.model

data class UserItem(
    val id: String,
    val title: String,
    val photoUrl: String,
    val subtitle: String? = null,
)