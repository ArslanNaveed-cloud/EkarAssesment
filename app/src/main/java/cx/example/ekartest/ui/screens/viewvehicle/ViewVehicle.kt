package cx.example.ekartest.ui.screens.viewvehicle


import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cx.example.ekartest.model.VehicleImageResponseData
import cx.example.ekartest.model.VehicleResponseData
import cx.example.ekartest.theme.EkarTestTheme
import cx.example.ekartest.ui.components.AppToolbar
import cx.example.ekartest.ui.components.CircularProgressBar
import cx.example.ekartest.ui.components.vehicle.VAboutInfoContainer
import cx.example.ekartest.ui.components.vehicle.VFeatureInfoContainer
import cx.example.ekartest.ui.components.vehicle.VFooterInfoContainer
import cx.example.ekartest.ui.components.vehicle.VTopInfoContainer

@Composable
fun ViewVehicle(navController: NavController){

    EkarTestTheme {
        Column (modifier = Modifier
            .background(White)
            .padding(bottom = 35.dp)){
            Rendertoolbar(navController)

            RenderMainView(navController)
        }
        }

}

@Composable
fun RenderMainView(navController: NavController) {
    var viewModel = VehicleViewModel()
    val shouldShowLoading = remember { mutableStateOf(true) }

    var vehicleInfoData by remember {
        mutableStateOf<VehicleResponseData?>(null)
    }

    var vehicleImageData by remember {
        mutableStateOf<VehicleImageResponseData?>(null)
    }


    Box(modifier = Modifier.fillMaxSize()) {
    if(vehicleInfoData!=null && vehicleImageData?.images!!.isNotEmpty()) {
        LaunchedEffect(true) {
            shouldShowLoading.value = false
        }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                /*these components are used to display the top , middle and footer
             columns/sections/components for the general info of the vehicles
            * */
                VTopInfoContainer(vehicleInfoData!!, vehicleImageData!!.images.take(4))
                VAboutInfoContainer(vehicleInfoData!!)
                VFeatureInfoContainer(vehicleInfoData!!)//we dont have any info regarding the key features in api, setting default
                VFooterInfoContainer(navController,vehicleInfoData!!)
            }


        }else{
        LaunchedEffect(Unit) {

            Log.d("HELLO", "RenderMainView: Calling the method")
            viewModel.getVehicleData { vehicleData,vehicleImage ->
                vehicleInfoData = vehicleData
                vehicleImageData = vehicleImage
            }

        }
        }
        CircularProgressBar(isDisplayed = shouldShowLoading.value)
    }



    }




@Composable
fun Rendertoolbar(navController: NavController){

    AppToolbar(showbtn = "backbtn", navController = navController)

}