package com.denchic45.skeletonapp.ui.screen.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.denchic45.skeletonapp.ui.navigation.RootChild
import com.denchic45.skeletonapp.ui.navigation.RootConfig
import com.denchic45.skeletonapp.ui.screen.greeting.GreetingComponent
import me.tatarka.inject.annotations.Inject


@Inject
class MainComponent(
    greetingComponent: () -> GreetingComponent,
    navigation: StackNavigation<RootConfig>, componentContext: ComponentContext
) : ComponentContext by componentContext {

    val childStack = childStack(
        source = navigation,
        initialConfiguration = RootConfig.Greeting,
        childFactory = { config, _ ->
            when (config) {
                RootConfig.Greeting -> RootChild.Greeting(greetingComponent())
            }
        })
}