package com.denchic45.skeletonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.denchic45.skeletonapp.di.*
import com.denchic45.skeletonapp.ui.screen.main.MainContent
import com.denchic45.skeletonapp.ui.theme.SkeletonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkeletonAppTheme {
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
                    MainContent(appDI.mainComponent)
                }
            }
        }
    }
}