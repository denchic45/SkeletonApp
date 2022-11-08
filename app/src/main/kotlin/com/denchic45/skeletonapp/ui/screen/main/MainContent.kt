package com.denchic45.skeletonapp.ui.screen.main

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.GetApp
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Upload
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.denchic45.skeletonapp.ui.navigation.RootChild
import com.denchic45.skeletonapp.ui.screen.greeting.GreetingScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalDecomposeApi::class)
@Composable
fun MainContent(mainComponent: MainComponent) {
    val childStack by mainComponent.childStack.subscribeAsState()
    val child = childStack.active.instance
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Заголовк") }) },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(selected = child is RootChild.Greeting,
                    onClick = mainComponent::onItem1Click,
                    label = { Text("Item 1") },
                    icon = { Icon(Icons.Outlined.Message, "") })
                NavigationBarItem(selected = child is RootChild.Upload,
                    label = { Text("Item 2") },
                    onClick = mainComponent::onItem2Click,
                    icon = { Icon(Icons.Outlined.Upload, "") })
                NavigationBarItem(selected = child is RootChild.Get,
                    label = { Text("Item 3") },
                    onClick = mainComponent::onItem3Click,
                    icon = { Icon(Icons.Outlined.GetApp, "") })
            }
        }
    ) {
        Children(stack = childStack) {
            when (child) {
                is RootChild.Greeting -> GreetingScreen(child.component)
                is RootChild.Upload -> RootChild.Upload(child.component)
                is RootChild.Get -> RootChild.Get(child.component)
            }
        }
    }
}