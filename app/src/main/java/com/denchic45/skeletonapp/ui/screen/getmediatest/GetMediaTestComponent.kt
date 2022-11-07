package com.denchic45.skeletonapp.ui.screen.getmediatest

import com.arkivanov.decompose.ComponentContext
import com.denchic45.skeletonapp.data.api.TestService
import com.denchic45.skeletonapp.util.componentScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Inject

@Inject
class GetMediaTestComponent(
    private val testService: TestService,
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val coroutineScope = componentScope()

    val dir = MutableStateFlow("")
    val name = MutableStateFlow("")

    fun onGetClick() {
        coroutineScope.launch { testService.testGetUrlMedia(dir.value, name.value) }
    }

    fun onDirChange(newDir: String) {
        dir.value = newDir
    }

    fun onNameChange(newName: String) {
        name.value = newName
    }
}