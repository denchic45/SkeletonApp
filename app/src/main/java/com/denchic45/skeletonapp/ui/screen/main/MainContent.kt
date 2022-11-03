package com.denchic45.skeletonapp.ui.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.denchic45.skeletonapp.ui.screen.greeting.GreetingScreen

@Composable
fun MainContent(mainComponent: MainComponent) {
    val state by mainComponent.childStack.subscribeAsState()
    when (val child = state.active.instance) {
        else -> GreetingScreen(child.component)
    }
}