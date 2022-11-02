package com.denchic45.skeletonapp.di

import com.denchic45.skeletonapp.data.api.TestService
import me.tatarka.inject.annotations.Component

@Component
abstract class AppComponent(
    @Component val commonComponent: CommonComponent,
    @Component val networkComponent: NetworkComponent,
    @Component val dataComponent: DataComponent
) {
    abstract val testService: TestService
}