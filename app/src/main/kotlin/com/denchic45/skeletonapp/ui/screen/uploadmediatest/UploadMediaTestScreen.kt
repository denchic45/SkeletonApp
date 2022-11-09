package com.denchic45.skeletonapp.ui.screen.uploadmediatest

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.denchic45.skeletonapp.domain.MediaItem
import com.denchic45.skeletonapp.util.FilesAndroid
import com.denchic45.skeletonapp.util.toBitmap
import com.denchic45.skeletonapp.util.toByteArray


@Composable
fun UploadMediaTestScreen(component: UploadMediaTestComponent) {

    val context = LocalContext.current
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            if (Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
            } else {
                Log.d("lol", "PATH: ${FilesAndroid.getFilePath(context, uri)}")
                val source = ImageDecoder.createSource(context.contentResolver, uri)
                component.onImagePicked(
                    MediaItem(
                        ImageDecoder.decodeBitmap(source).toByteArray(),
                        context.contentResolver.getType(uri)!!
                    )
                )
            }
        }
    }

    Column(Modifier.fillMaxWidth()) {
        val media by component.media.collectAsState()
        when (val media = media) {
            MediaState.Nothing -> {
                Toast.makeText(context, "nothing", Toast.LENGTH_SHORT).show()
            }
            is MediaState.Bytes -> {
                Toast.makeText(context, "bytes", Toast.LENGTH_SHORT).show()
                Image(
                    bitmap = media.mediaItem.byteArray.toBitmap().asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                        .padding(20.dp)
                )
            }
            is MediaState.Url -> {
                Toast.makeText(context, "url", Toast.LENGTH_SHORT).show()
                AsyncImage(
                    model = media.url,
                    contentDescription = null
                )
            }
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