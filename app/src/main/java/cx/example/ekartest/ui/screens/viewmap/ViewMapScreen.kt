package cx.example.ekartest.ui.screens.viewmap

import android.content.Context
import android.graphics.BitmapFactory
import android.location.Location
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import cx.example.ekartest.ui.components.AppToolbar
import cx.example.ekartest.ui.components.CircularProgressBar
import cx.example.ekartest.ui.components.MessageDialog
import cx.example.ekartest.ui.theme.EkarTestTheme
import cx.example.ekartest.utils.ScreenNames

/**
 * Composable function to display the maps
 * @param navController For controlling the navigation
 */
@Composable
fun ViewMapScreen(
    navController: NavController
){
    var viewModel = MapViewModel()
     var context = LocalContext.current
    MapsInitializer.initialize(context)

    EkarTestTheme {
                Column {


                    Rendertoolbar(navController)
                    var currentLocation by remember {
                        mutableStateOf<Location?>(null)
                    }

                    val shouldShowLoading = remember { mutableStateOf(true) }


                    LaunchedEffect(true) {
                        viewModel.getDeviceLocation(context) {
                            currentLocation = it
                        }

                    }

                    Box(modifier = Modifier.fillMaxSize()) {
                        if (currentLocation != null) {
                            LaunchedEffect(true) {
                                shouldShowLoading.value = false
                            }
                            Log.d("www", "onCreate: $currentLocation")
                            RenderMap(
                                context,
                                currentLocation!!.latitude,
                                currentLocation!!.longitude,
                                navController
                            )
                        }

                        CircularProgressBar(isDisplayed = shouldShowLoading.value)
                    }

                }
        }





    }



@Composable
fun Rendertoolbar(navController: NavController){

    AppToolbar(showbtn="", navController =navController)

}
@Composable
fun RenderMap(context: Context, latitude: Double, longitude: Double, navController: NavController){

    val initialLocation = LatLng(38.685516,-101.072234)
    val currentLocation = LatLng(latitude, longitude)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialLocation, 6f)
    }

    LaunchedEffect(key1 = true) {
        cameraPositionState.animate(
            update = CameraUpdateFactory.newCameraPosition(
                CameraPosition(currentLocation, 15f, 0f, 0f)
            ),
            durationMs = 1000
        )
    }
    val customMarkerBitmap = BitmapFactory.decodeResource(context.resources, cx.example.ekartest.R.drawable.gps_icon_2)
    val customMarker = BitmapDescriptorFactory.fromBitmap(customMarkerBitmap)


    GoogleMap(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        cameraPositionState = cameraPositionState,
    ) {
        Marker(

            state = MarkerState(position = currentLocation),
            title = "Enkar",
            snippet = "Marker in Enkar",
            icon = customMarker,
            onClick = {
                navController.navigate(route = ScreenNames.viewVehicle.route)
                true
            }
            )
    }
}
