package com.denchic45.skeletonapp.ui.screen.getmediatest

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetMediaScreen(component: GetMediaTestComponent) {
    Row {
        val dir by component.dir.collectAsState()
        TextField(value = dir, onValueChange = component::onDirChange)

        val name by component.name.collectAsState()
        TextField(value = name, onValueChange = component::onNameChange)

        Button(onClick = component::onGetClick) {
            Text(text = "Upload")
        }
    }
}