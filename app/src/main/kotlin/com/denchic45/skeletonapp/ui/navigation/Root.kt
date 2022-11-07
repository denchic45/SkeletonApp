package com.denchic45.skeletonapp.ui.navigation

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.denchic45.skeletonapp.ui.screen.getmediatest.GetMediaTestComponent
import com.denchic45.skeletonapp.ui.screen.greeting.GreetingComponent
import com.denchic45.skeletonapp.ui.screen.uploadmediatest.UploadMediaTestComponent

@Parcelize
sealed class RootConfig : Parcelable {
    object Greeting : RootConfig()
    object Upload : RootConfig()
    object Get : RootConfig()
}

sealed class RootChild {
    class Greeting(val component: GreetingComponent) : RootChild()
    class Upload(val component: UploadMediaTestComponent) : RootChild()
    class Get(val component: GetMediaTestComponent) : RootChild()
}