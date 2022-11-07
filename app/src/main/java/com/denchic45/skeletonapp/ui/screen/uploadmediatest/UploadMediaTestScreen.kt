package com.denchic45.skeletonapp.ui.screen.uploadmediatest

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.denchic45.skeletonapp.util.toByteArray


@Composable
fun UploadMediaTestScreen(component: TestMediaComponent) {

    val context = LocalContext.current
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (Build.VERSION.SDK_INT < 28) {
            bitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
        } else {
            val source = ImageDecoder.createSource(context.contentResolver, uri!!)
            component.onImagePicked(ImageDecoder.decodeBitmap(source).toByteArray())
        }
    }

    Row {
        val media by component.media.collectAsState()
        when (val media = media) {
            MediaState.Nothing -> {}
            is MediaState.Bytes -> {
                bitmap.value?.let { btm ->
                    Image(
                        bitmap = btm.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .size(400.dp)
                            .padding(20.dp)
                    )
                }
            }
            is MediaState.Url -> AsyncImage(
                model = media.url,
                contentDescription = null
            )
        }

        val uploadAvailable by component.uploadAvailable.collectAsState(false)

        if (uploadAvailable) {
            Button(onClick = component::onUploadClick) {
                Text(text = "Upload")
            }
        } else {
            Button(onClick = { launcher.launch("image/*") }) {
                Text(text = "Choose")
            }
        }
    }
}