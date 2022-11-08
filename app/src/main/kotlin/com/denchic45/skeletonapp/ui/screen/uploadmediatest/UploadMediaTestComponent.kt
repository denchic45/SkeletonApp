package com.denchic45.skeletonapp.ui.screen.uploadmediatest

import com.arkivanov.decompose.ComponentContext
import com.denchic45.skeletonapp.data.api.AuthService
import com.denchic45.skeletonapp.data.api.TestService
import com.denchic45.skeletonapp.domain.MediaItem
import com.denchic45.skeletonapp.util.componentScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import me.tatarka.inject.annotations.Inject

@Inject
class UploadMediaTestComponent(
    private val testService: TestService,
    private val authService: AuthService,
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val coroutineScope = componentScope()

    val media = MutableStateFlow<MediaState>(MediaState.Nothing)
    val uploadAvailable = media.map { it is MediaState.Bytes }

    fun onUploadClick() {
//        coroutineScope.launch {
//            authService.login("admin","admin")
//            testService.testUploadMedia((media.value as MediaState.Bytes).mediaItem, "Сертификат")
//        }
    }

    fun onImagePicked(bytes: MediaItem) {
        media.update { MediaState.Bytes(bytes) }
    }

}

sealed class MediaState {
    object Nothing : MediaState()
    class Url(val url: String) : MediaState()
    class Bytes(val mediaItem: MediaItem) : MediaState()
}