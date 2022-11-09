package com.denchic45.skeletonapp.ui.screen.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.essenty.backhandler.BackHandler
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
    private val navigation: StackNavigation<RootConfig>,
    componentContext: ComponentContext,
    override val backHandler: BackHandler
) : ComponentContext by componentContext {

    val childStack = childStack(
        source = navigation,
        handleBackButton = true,
        initialConfiguration = RootConfig.Greeting,
        childFactory = { config, _ ->
            when (config) {
                RootConfig.Greeting -> RootChild.Greeting(greetingComponent())
                RootConfig.Upload -> RootChild.Upload(uploadMediaTestComponent())
                RootConfig.Get -> RootChild.Get(getMediaTestComponent())
            }
        })

    fun onItem1Click() {
        navigation.bringToFront(RootConfig.Greeting)
    }

    fun onItem2Click() {
        navigation.bringToFront(RootConfig.Upload)
    }

    fun onItem3Click() {
        navigation.bringToFront(RootConfig.Get)
    }
}