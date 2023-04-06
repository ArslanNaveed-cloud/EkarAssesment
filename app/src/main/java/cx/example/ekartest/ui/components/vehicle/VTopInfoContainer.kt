package cx.example.ekartest.ui.components.vehicle

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cx.example.ekartest.R
import cx.example.ekartest.model.Image
import cx.example.ekartest.model.VehicleResponseData
import cx.example.ekartest.ui.theme.VehicleBackground
import cx.example.ekartest.ui.theme.VehicleButtonColor
import cx.example.ekartest.ui.theme.VehicleSavingsBackground
import cx.example.ekartest.ui.theme.VehicleText
import cx.example.ekartest.utils.helper


/**
 * Composable function to display information about general information of vehicle in a container UI.
 * @param vehicleInfoData The data to be displayed in the container
 */
@Composable
fun VTopInfoContainer(
    vehicleInfoData: VehicleResponseData, vehicleImageData: List<Image>) {



    Column (modifier = Modifier
        .fillMaxWidth()
        .background(VehicleBackground),
        horizontalAlignment = Alignment.CenterHorizontally,

        ){
        VTImageSlider(vehicleImageData)

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(start = 22.dp),
                text = "Year - "+vehicleInfoData.attributes.year,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                fontSize = 12.sp,

                )


            Row(
                modifier = Modifier.padding(end = 22.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Available colors",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    fontSize = 12.sp

                )
                Spacer(modifier = Modifier.size(10.dp))
                for (colors in vehicleInfoData.colors.subList(3,6)){
                    val colorResId = when (colors.name) {
                        "white" -> R.color.white
                        "black" -> R.color.black
                        "Barcelona Red Met" -> R.color.red
                        "Blizzard Pearl" -> R.color.pearl
                        "Blue Ribbon Metallic" -> R.color.blue
                        // add more cases for other color names
                        else -> R.color.black // fallback color
                    }
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .clip(CircleShape)
                            .background(colorResource(id = colorResId)),
                        contentAlignment = Alignment.Center
                    ) {
                        // You can add any content you want to show inside the colored dot here
                    }
                    Spacer(modifier = Modifier.size(3.dp))
                }
                Spacer(modifier = Modifier.size(10.dp))
            }

        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(start = 22.dp),
                text = "Base Price",
                fontWeight = FontWeight.Bold,
                color = VehicleText,
                fontSize = 14.sp
            )

            Text(
                modifier = Modifier.padding(end = 22.dp),
                text = "Contract Length",
                fontWeight = FontWeight.Bold,
                color = VehicleText,
                fontSize = 14.sp

            )
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    modifier = Modifier.padding(start = 22.dp),

                    text = vehicleInfoData.attributes.invoice_price,
                    fontWeight = FontWeight.Bold,
                    color = VehicleText,
                    fontSize = 22.sp
                )

//                Text(
//                    modifier = Modifier.padding(start = 8.dp),
//                    text = "AED/ MONTH",
//                    fontWeight = FontWeight.Bold,
//                    color = VehicleText,
//                    fontSize = 14.sp
//                )
            }

            Row(
                modifier = Modifier.padding(end = 22.dp),
                verticalAlignment = Alignment.Bottom

            ) {
                Text(
                    modifier = Modifier.padding(start = 22.dp),
                    text = "3",//no info regarding contract length, setting default
                    fontWeight = FontWeight.Bold,
                    color = VehicleText,
                    fontSize = 22.sp
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "MONTHS",
                    fontWeight = FontWeight.Bold,
                    color = VehicleText,
                    fontSize = 14.sp
                )
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .padding(start = 22.dp)
            .padding(end = 22.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Tenure",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    fontSize = 16.sp

                )
                Text(
                    modifier = Modifier.padding(top=3.dp),
                    text = "1 to 9 Months",
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    fontSize = 14.sp

                )
            }
            Box(
                modifier = Modifier

                    .clip(CircleShape)
                    .background(VehicleSavingsBackground),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "SAVINGS OF AED 1,500",//no info in the api regarding saving price, settign default
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    fontSize = 12.sp

                )
            }

        }


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .padding(start = 22.dp)
            .padding(end = 22.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Booking Fee",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    fontSize = 16.sp

                )
                Row(
                    verticalAlignment = Alignment.Bottom

                ) {
//                    Text(
//                        modifier = Modifier.padding(start = 8.dp),
//                        text = "AED",
//                        fontWeight = FontWeight.Bold,
//                        color = VehicleText,
//                        fontSize = 14.sp
//                    )
                    Text(
                        modifier = Modifier.padding(start = 5.dp),
                        text = vehicleInfoData.attributes.manufacturer_suggested_retail_price,
                        fontWeight = FontWeight.Bold,
                        color = VehicleText,
                        fontSize = 14.sp
                    )


                }
            }

            OutlinedButton(
                onClick = {
                          Toast.makeText(helper.application,"How Contract Works Toast Displayed",Toast.LENGTH_LONG).show()
                },
                border = BorderStroke(1.dp, VehicleButtonColor),
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)

            ){
                Text(
                    fontWeight = FontWeight.Bold,
                    color = VehicleButtonColor,
                    text = "how contract works ?")
            }


        }
        Spacer(modifier = Modifier.size(30.dp))
    }
}