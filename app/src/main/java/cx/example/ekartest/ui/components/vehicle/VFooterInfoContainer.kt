package cx.example.ekartest.ui.components.vehicle

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cx.example.ekartest.R
import cx.example.ekartest.model.VehicleResponseData
import cx.example.ekartest.ui.theme.VehicleButtonColor
import cx.example.ekartest.utils.ScreenNames

/**
 * Composable function to display information about type and model of vehicle in a container UI.
 * @param vehicleInfoData The data to be displayed in the container
 */
@Composable
fun VFooterInfoContainer(navController:NavController,vehicleInfoData: VehicleResponseData) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp), elevation = 4.dp
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .padding(top = 15.dp)
                .padding(start = 44.dp)

        ) {
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(start = 20.dp)
                    .padding(end = 20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.toyota),
                        modifier = Modifier.size(60.dp),
                        contentDescription = "company_logo"
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()

                            .background(Color.White),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = vehicleInfoData.attributes.make,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 16.sp

                            )
                            Text(
                                text = " "+vehicleInfoData.attributes.model,
                                color = Color.Black,
                                fontSize = 16.sp

                            )

                        }

                        Text(
                            text = vehicleInfoData.attributes.style,
                            color = Color.Black,
                            fontSize = 14.sp

                        )
                    }
                }

                Button(
                    onClick = {  navController.navigate(route = ScreenNames.viewOnBoard.route) },
                    shape = RoundedCornerShape(20),
                    colors = ButtonDefaults.buttonColors(backgroundColor = VehicleButtonColor)


                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        text = "Proceed with your selection"
                    )
                }

            }


        }
    }
}