package com.denchic45.skeletonapp.ui.screen.getmediatest

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.denchic45.skeletonapp.data.model.PublicUrlResponse

@Composable
fun GetMediaScreen(component: GetMediaTestComponent) {
    val items by component.images.collectAsState(initial = emptyList())

    LazyColumn(Modifier.fillMaxWidth()) {
        items(items, PublicUrlResponse::publicUrl) {
            AsyncImage(model = it.publicUrl, contentDescription = "", Modifier.size(300.dp))
        }
    }
}