package cx.example.ekartest.ui.components


import android.content.Context
import cx.example.ekartest.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cx.example.ekartest.ui.theme.VehicleButtonColor
import cx.example.ekartest.ui.theme.White
import cx.example.ekartest.utils.ScreenNames

/**
 * Composable function to display information about features of vehicle in a container UI.
 * @param navController For controlling the navigation
 * @param modifier To change the attiributes of UI widgets
 * @param showbtn The identifier for either to show the button or to hide it
 */
@Composable
fun AppToolbar(
    navController: NavController,
    modifier:Modifier = Modifier,
    showbtn:String
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (showbtn.isNullOrEmpty()) Arrangement.SpaceAround else Arrangement.Start,

        modifier = modifier
            .height(54.dp)
            .background(Color.White)
        ) {
        Spacer(
            modifier = Modifier
                .weight(0.05F)
                .height(20.dp)
        )
        if (showbtn.equals("backbtn")) {

            TextButton(
                onClick = {
                    navController.popBackStack()
                }

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "backbutton",
                    tint = Color.DarkGray,
                    modifier = Modifier.size(24.dp)
                )
            }

        }else if(showbtn.equals("crossbtn")){
            TextButton(
                onClick = {
                    navController.popBackStack()
                }

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cancel),
                    contentDescription = "backbutton",
                    tint = Color.DarkGray,
                    modifier = Modifier.size(24.dp)
                )
            }

        }
        else{
            Spacer(
                modifier = Modifier
                    .size(24.dp)
                    .height(20.dp)
            )
        }
        Spacer(
            modifier = Modifier
                .weight(1F)
                .height(20.dp)
        )

            Image(
                painter = painterResource(id = R.drawable.ekar),
                contentDescription = "logo",
                modifier = Modifier.size(58.dp)
            )

        Spacer(
            modifier = Modifier
                .weight(1.25F)
                .height(20.dp)
        )


    }


}
