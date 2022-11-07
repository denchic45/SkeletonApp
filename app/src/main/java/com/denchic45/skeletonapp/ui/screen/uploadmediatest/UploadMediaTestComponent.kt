package com.denchic45.skeletonapp.ui.screen.uploadmediatest

import com.arkivanov.decompose.ComponentContext
import com.denchic45.skeletonapp.data.api.TestService
import com.denchic45.skeletonapp.util.componentScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Inject

@Inject
class TestMediaComponent(
    private val testService: TestService,
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val coroutineScope = componentScope()

    val media = MutableStateFlow<MediaState>(MediaState.Nothing)
    val uploadAvailable = media.map { it !is MediaState.Bytes }

    fun onUploadClick() {
        coroutineScope.launch {
            testService.testUploadMedia((media.value as MediaState.Bytes).byteArray)
        }
    }

    fun onImagePicked(bytes: ByteArray) {
        media.update { MediaState.Bytes(bytes) }
    }

}

sealed class MediaState {
    object Nothing : MediaState()
    class Url(val url: String) : MediaState()
    class Bytes(val byteArray: ByteArray) : MediaState()
}