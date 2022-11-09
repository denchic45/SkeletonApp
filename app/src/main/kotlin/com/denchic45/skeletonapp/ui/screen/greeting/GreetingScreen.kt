package com.denchic45.skeletonapp.ui.screen.greeting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.denchic45.skeletonapp.ui.component.CardItem
import com.denchic45.skeletonapp.ui.theme.spacing

@Composable
fun GreetingScreen(component: GreetingComponent) {
    Column(Modifier.fillMaxWidth()) {
        Greeting(name = "Android")
        CardItem(
            Modifier.padding(
                start = MaterialTheme.spacing.normal,
                end = MaterialTheme.spacing.normal,
                bottom = MaterialTheme.spacing.normal
            ),
            onClick = {}
        ) {
            Column(Modifier.padding(16.dp)) {
                Text(text = "Sample text", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "Lorem impsum... and any text".repeat(3),
                    style = MaterialTheme.typography.bodyLarge
                )
                Button(onClick = { /*TODO*/ }) {
                    Text("Sample text")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}