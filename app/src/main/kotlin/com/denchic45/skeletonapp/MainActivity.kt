package com.denchic45.skeletonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.arkivanov.essenty.backhandler.BackHandler
import com.denchic45.skeletonapp.di.*
import com.denchic45.skeletonapp.ui.screen.main.MainContent
import com.denchic45.skeletonapp.ui.theme.SkeletonAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkeletonAppTheme {
                // Remember a SystemUiController
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = !isSystemInDarkTheme()
                val systemBarColor = MaterialTheme.colorScheme.surface
                val navBarColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)

                DisposableEffect(systemUiController, useDarkIcons) {
                    // Update all of the system bar colors to be transparent, and use
                    // dark icons if we're in light theme
                    systemUiController.setStatusBarColor(
                        color = systemBarColor,
                        darkIcons = useDarkIcons
                    )

                    systemUiController.setNavigationBarColor(
                        color = navBarColor,
                        darkIcons = useDarkIcons
                    )

                    onDispose {}
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val commonDI = CommonDI::class.create(LocalContext.current)
                    val dataDI = DataDI::class.create(commonDI)
                    val appDI = AppDI::class.create(
                        commonDI,
                        NetworkDI::class.create(dataDI),
                        dataDI
                    )

                    MainContent(appDI.mainComponent(BackHandler(onBackPressedDispatcher)))
                }
            }
        }
    }
}