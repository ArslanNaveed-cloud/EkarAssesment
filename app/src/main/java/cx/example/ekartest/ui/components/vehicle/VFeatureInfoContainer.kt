package cx.example.ekartest.ui.components.vehicle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cx.example.ekartest.model.VehicleResponseData
import cx.example.ekartest.ui.theme.VehicleBackground
import cx.example.ekartest.ui.theme.VehicleText

/**
 * Composable function to display information about features of vehicle in a container UI.
 * @param vehicleInfoData The data to be displayed in the container
 */
@Composable
fun VFeatureInfoContainer(vehicleInfoData: VehicleResponseData) {
//key feature column to display main information regarding features
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.Start,
    ) {

        Text(
            modifier = Modifier.padding(start = 22.dp),
            text = "Key Features",
            fontWeight = FontWeight.Bold,
            color = VehicleText,
            fontSize = 18.sp
        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .padding(start = 22.dp)
            .padding(end = 22.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly, ) {
            Box(
                modifier = Modifier

                    .clip(CircleShape)
                    .background(VehicleBackground),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Keyless Entry",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 10.sp

                )
            }

            Box(
                modifier = Modifier

                    .clip(CircleShape)
                    .background(VehicleBackground),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Bluetooth",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 10.sp

                )
            }

            Box(
                modifier = Modifier

                    .clip(CircleShape)
                    .background(VehicleBackground),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Power Windows",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 10.sp

                )
            }

            Box(
                modifier = Modifier

                    .clip(CircleShape)
                    .background(VehicleBackground),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "ABS Brakes",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 10.sp

                )
            }
        }



    }
    //key feature section ends here

}