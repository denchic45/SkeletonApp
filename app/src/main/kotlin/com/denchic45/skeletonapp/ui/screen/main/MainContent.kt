package com.denchic45.skeletonapp.ui.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.denchic45.skeletonapp.ui.navigation.RootChild
import com.denchic45.skeletonapp.ui.screen.getmediatest.GetMediaScreen
import com.denchic45.skeletonapp.ui.screen.greeting.GreetingScreen
import com.denchic45.skeletonapp.ui.screen.uploadmediatest.UploadMediaTestScreen

@Composable
fun MainContent(mainComponent: MainComponent) {
    val state by mainComponent.childStack.subscribeAsState()
    when (val child = state.active.instance) {
        is RootChild.Greeting -> GreetingScreen(child.component)
        is RootChild.Upload -> RootChild.Upload(child.component)
        is RootChild.Get -> RootChild.Get(child.component)
    }
    val childStack by mainComponent.childStack.subscribeAsState()
    when(val child = childStack.active.instance) {
        is RootChild.Greeting -> GreetingScreen(child.component)
        is RootChild.Get -> GetMediaScreen(child.component)
        is RootChild.Upload -> UploadMediaTestScreen(child.component)
    }
}