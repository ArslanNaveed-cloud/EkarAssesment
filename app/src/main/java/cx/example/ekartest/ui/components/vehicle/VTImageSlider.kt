package cx.example.ekartest.ui.components.vehicle

import android.widget.Toast
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import cx.example.ekartest.model.Image
import cx.example.ekartest.ui.components.imageslider.AsyncImage
import cx.example.ekartest.ui.components.imageslider.ImageCarousel
import cx.example.ekartest.ui.theme.VehicleBackground

/**
 * Composable function to display information about top slider of images of vehicle in a container UI.
 * @param vehicleInfoData The data to be displayed in the container
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun VTImageSlider(images:List<Image>){

    Card(
        modifier = Modifier.padding(16.dp),
        shape = RectangleShape,
        backgroundColor = VehicleBackground
    ) {
        ImageCarousel(
            itemsCount = images.size,
            itemContent = { index ->
                AsyncImage(
                    images,
                    index

                )
            }
        )
    }
}