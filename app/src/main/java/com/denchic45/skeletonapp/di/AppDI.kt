package com.denchic45.skeletonapp.di

import com.denchic45.skeletonapp.data.api.TestService
import com.denchic45.skeletonapp.ui.screen.main.MainComponent
import me.tatarka.inject.annotations.Component

@Component
abstract class AppDI(
    @Component val commonDI: CommonDI,
    @Component val networkDI: NetworkDI,
    @Component val dataDI: DataDI
) {
    abstract val testService: TestService

    abstract val mainComponent: MainComponent
}