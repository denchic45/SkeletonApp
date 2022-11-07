package com.denchic45.skeletonapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.denchic45.skeletonapp.ui.theme.SkeletonAppTheme


@Preview
@Composable
fun PreviewButtons() = SkeletonAppTheme {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button({}) {
            IconWithTextButtonContent(Icons.Default.GridView, "Hello")
        }
        OutlinedButton({}) {
            IconWithTextButtonContent(Icons.Default.Timer, "Hello")
        }
        FilledTonalButton({}) {
            IconWithTextButtonContent(Icons.Default.Home, "Hello")
        }
        TextButton({}) {
            IconWithTextButtonContent(Icons.Default.Explore, "Hello")
        }
        ElevatedButton({}) {
            IconWithTextButtonContent(Icons.Default.DesignServices, "Hello")
        }
    }
}

@Composable
fun IconWithTextButtonContent(icon: Painter, text: String) {
    Icon(painter = icon, null, Modifier.size(ButtonDefaults.IconSize))
    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
    Text(text, style = MaterialTheme.typography.labelLarge)
}

@Composable
fun IconWithTextButtonContent(icon: ImageVector, text: String) {
    Icon(imageVector = icon, null, Modifier.size(ButtonDefaults.IconSize))
    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
    Text(text, style = MaterialTheme.typography.labelLarge)
}

@Composable
fun TextButtonContent(text: String) {
    Text(text, style = MaterialTheme.typography.labelLarge)
}