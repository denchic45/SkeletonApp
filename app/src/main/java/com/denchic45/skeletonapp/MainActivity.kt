package com.denchic45.skeletonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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
                    val dataDI = DataDI::class.create()
                    val appDI = AppDI::class.create(
                        CommonDI::class.create(LocalContext.current),
                        NetworkDI::class.create(dataDI),
                        dataDI
                    )
                    MainContent(appDI.mainComponent)
                }
            }
        }
    }
}