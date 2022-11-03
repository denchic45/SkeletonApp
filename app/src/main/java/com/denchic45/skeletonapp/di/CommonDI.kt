package com.denchic45.skeletonapp.di

import android.content.Context
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.denchic45.skeletonapp.ui.navigation.RootConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@AppScope
@Component
abstract class CommonDI(
    @get:Provides val context: Context,
) {

    @AppScope
    @Provides
    fun provideComponentContext(): ComponentContext {
        return DefaultComponentContext(LifecycleRegistry())
    }

    @AppScope
    @Provides
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

    @AppScope
    @Provides
    fun provideNavigation(): StackNavigation<RootConfig> {
        return StackNavigation()
    }
}



