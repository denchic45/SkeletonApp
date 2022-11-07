package com.denchic45.skeletonapp.ui.screen.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.denchic45.skeletonapp.ui.navigation.RootChild
import com.denchic45.skeletonapp.ui.navigation.RootConfig
import com.denchic45.skeletonapp.ui.screen.getmediatest.GetMediaTestComponent
import com.denchic45.skeletonapp.ui.screen.greeting.GreetingComponent
import com.denchic45.skeletonapp.ui.screen.uploadmediatest.UploadMediaTestComponent
import me.tatarka.inject.annotations.Inject


@Inject
class MainComponent(
    greetingComponent: () -> GreetingComponent,
    uploadMediaTestComponent: () -> UploadMediaTestComponent,
    getMediaTestComponent: () -> GetMediaTestComponent,
    navigation: StackNavigation<RootConfig>, componentContext: ComponentContext
) : ComponentContext by componentContext {

    val childStack = childStack(
        source = navigation,
        initialConfiguration = RootConfig.Greeting,
        childFactory = { config, _ ->
            when (config) {
                RootConfig.Greeting -> RootChild.Greeting(greetingComponent())
                RootConfig.Upload -> RootChild.Upload(uploadMediaTestComponent())
                RootConfig.Get -> RootChild.Get(getMediaTestComponent())
            }
        })
}