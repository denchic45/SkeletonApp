package com.denchic45.skeletonapp.ui.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.GetApp
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Upload
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.denchic45.skeletonapp.ui.navigation.RootChild
import com.denchic45.skeletonapp.ui.screen.getmediatest.GetMediaScreen
import com.denchic45.skeletonapp.ui.screen.greeting.GreetingScreen
import com.denchic45.skeletonapp.ui.screen.uploadmediatest.UploadMediaTestScreen

@OptIn(ExperimentalMaterial3Api::class, ExperimentalDecomposeApi::class)
@Composable
fun MainContent(component: MainComponent) {

    val childStack by component.childStack.subscribeAsState()
    val activeComponent = childStack.active.instance

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Заголовок") }) },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = activeComponent is RootChild.Greeting,
                    onClick = { component.onItem1Click() },
                    label = { Text("Item 1") },
                    icon = { Icon(Icons.Outlined.Message, "") })
                NavigationBarItem(
                    selected = activeComponent is RootChild.Upload,
                    label = { Text("Item 2") },
                    onClick = { component.onItem2Click() },
                    icon = { Icon(Icons.Outlined.Upload, "") })
                NavigationBarItem(
                    selected = activeComponent is RootChild.Get,
                    label = { Text("Item 3") },
                    onClick = { component.onItem3Click() },
                    icon = { Icon(Icons.Outlined.GetApp, "") })
            }
        }
    ) { paddingValues ->
        Children(
            stack = childStack,
            Modifier.padding(paddingValues),
            animation = stackAnimation(fade() + scale())
        ) {
            when (val child = it.instance) {
                is RootChild.Greeting -> GreetingScreen(child.component)
                is RootChild.Upload -> UploadMediaTestScreen(child.component)
                is RootChild.Get -> GetMediaScreen(child.component)
            }
        }
    }
}