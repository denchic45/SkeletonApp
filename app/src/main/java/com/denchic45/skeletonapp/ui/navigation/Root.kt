package com.denchic45.skeletonapp.ui.navigation

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.denchic45.skeletonapp.ui.screen.greeting.GreetingComponent

@Parcelize
sealed class RootConfig : Parcelable {
    object Greeting : RootConfig()
}

sealed class RootChild {
    class Greeting(private val component: GreetingComponent) : RootChild()
}