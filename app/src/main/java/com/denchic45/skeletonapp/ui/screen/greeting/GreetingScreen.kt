package com.denchic45.skeletonapp.ui.screen.greeting

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun GreetingScreen(greetingComponent: GreetingComponent) {
    Greeting(name = "Android")
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}