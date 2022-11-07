package com.denchic45.skeletonapp.ui.screen.getmediatest

import com.arkivanov.decompose.ComponentContext
import com.denchic45.skeletonapp.data.api.TestService
import com.denchic45.skeletonapp.data.model.PublicUrlResponse
import com.denchic45.skeletonapp.data.model.TestImagesResponse
import com.denchic45.skeletonapp.util.componentScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.tatarka.inject.annotations.Inject

@Inject
class GetMediaTestComponent(
    private val testService: TestService,
    componentContext: ComponentContext,
) : ComponentContext by componentContext {

    private val coroutineScope = componentScope()

    val images: Flow<List<PublicUrlResponse>> = flow { emit(testService.testUploads()) }
}