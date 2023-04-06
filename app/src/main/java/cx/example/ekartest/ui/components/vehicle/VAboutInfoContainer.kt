package cx.example.ekartest.ui.components.vehicle

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cx.example.ekartest.R
import cx.example.ekartest.model.VehicleResponseData
import cx.example.ekartest.ui.theme.VehicleBackground
import cx.example.ekartest.ui.theme.VehicleText

/**
 * Composable function to display information about a vehicle in a container UI.
 * @param vehicleInfoData The data to be displayed in the container
 */
@Composable
fun VAboutInfoContainer(vehicleInfoData: VehicleResponseData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.Start,
    ) {
// Header text for the section
        Column {
            Text(
                modifier = Modifier.padding(start = 22.dp),
                text = "About the Vehicle",
                fontWeight = FontWeight.Bold,
                color = VehicleText,
                fontSize = 22.sp
            )
// Row to hold all the vehicle information boxes
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
// Information box for the engine type
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 28.dp)
                        .clip(RectangleShape)
                        .background(VehicleBackground)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_car),
                            contentDescription = "car"
                        )
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = vehicleInfoData.attributes.engine.substring(0, 6),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 12.sp

                        )
                    }
                }
// Information box for the number of seats
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 8.dp)
                        .clip(RectangleShape)
                        .background(VehicleBackground)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_seat),
                            contentDescription = "car"
                        )
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = vehicleInfoData.attributes.standard_seating + " Seats",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 12.sp

                        )
                    }
                }
// Information box for the fuel type
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 8.dp)
                        .clip(RectangleShape)
                        .background(VehicleBackground)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_settings),
                            modifier = Modifier.size(24.dp),
                            contentDescription = "car"
                        )
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = vehicleInfoData.attributes.fuel_type + " Petrol",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 12.sp

                        )
                    }
                }
// Information box for the transmission type
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 8.dp)
                        .padding(end = 22.dp)
                        .clip(RectangleShape)
                        .background(VehicleBackground)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_fuel),
                            modifier = Modifier.size(24.dp),
                            contentDescription = "car"
                        )
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = vehicleInfoData.attributes.transmission_short,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 12.sp

                        )
                    }
                }
            }
        }
    }//about the vehicle column ends

}