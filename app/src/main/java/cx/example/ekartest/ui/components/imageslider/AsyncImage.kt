package cx.example.ekartest.ui.components.imageslider

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.Transformation
import cx.example.ekartest.model.Image
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi

/**
 * Composable function that displays an image asynchronously using Coil.
 *
 * @param images the list of images to display.
 * @param index the index of the current image to display.
 */


@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class, InternalCoroutinesApi::class)
@Composable
fun AsyncImage(
    images: List<Image>,
    index: Int
) {
    Log.d("Hey ", "AsyncImage: "+images[index].link)
    Image(
        painter = rememberImagePainter(
            data = images[index].link,
            builder = {
            }
        ),
        contentDescription = null,
        contentScale = ContentScale.Inside,
        modifier = Modifier.height(170.dp)
    )
}