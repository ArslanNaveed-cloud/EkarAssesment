package cx.example.ekartest.ui.screens.viewonboard

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cx.example.ekartest.R
import cx.example.ekartest.ui.components.AppToolbar
import cx.example.ekartest.ui.components.alerts.ImagePrompAlert
import cx.example.ekartest.ui.theme.*
import cx.example.ekartest.utils.helper

/**
 * Composable function to display information about vehicle in a container UI.
 * @param vehicleInfoData The data to be displayed in the container
 */
@Composable
fun ViewOnBoard(navController: NavController) {

    var text by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var showImagePrompt by remember {mutableStateOf(false)}


    if(showImagePrompt){
        Log.d("1234", "ViewOnBoard: "+showImagePrompt)
        ImagePrompAlert(title = "Note",
            body = "Please take clear picture to avoid any issues",
            ){
                showImagePrompt = false
        }
    }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(White, RectangleShape)
            ,
        ) {
            Rendertoolbar(navController = navController)

            Text(
                modifier = Modifier
                    .padding(start = 22.dp)
                    .padding(end = 22.dp)
                    .padding(top = 15.dp)

                ,
                text = "Please upload clear pictures of your vehicle to avoid any liability of any damages caused before starting your reservation",
                fontWeight = FontWeight.Light,
                color = Color.Black,
                fontSize = 12.sp,

                )

            Card(
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(5),
                backgroundColor = White,
                border = BorderStroke(1.dp,Color.LightGray),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {


                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {


                        TextButton(onClick = {
                            showImagePrompt = true

                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.front_left),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.size(150.dp),

                                )
                        }



                        TextButton(onClick = {
                            showImagePrompt = true
                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.front_right),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.size(150.dp),

                                )
                        }

                    }


                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        TextButton(onClick = {  showImagePrompt = true }) {
                            Image(
                                painter = painterResource(id = R.drawable.back_left),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.size(150.dp),

                                )
                        }

                        TextButton(onClick = {  showImagePrompt = true }) {
                            Image(
                                painter = painterResource(id = R.drawable.back_right),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.size(150.dp),

                                )
                        }

                    }
                }

            }



                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                        .padding(start = 22.dp),
                    text = "Leave a comment",
                    fontWeight = FontWeight.Light,
                    color = Black,
                    fontSize = 12.sp
                )


            TextField(

                value = text,
                onValueChange = { text = it; showError = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
                    .padding(end = 8.dp),
                textStyle = TextStyle.Default.copy(fontSize = 14.sp),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
                isError = showError && text.isBlank()
            )

            Button(
                modifier = Modifier
                    .padding(top = 26.dp)
                    .fillMaxWidth()
                    .padding(start = 12.dp)
                    .padding(end = 12.dp),

                onClick = { if(text.isBlank()){
                    Toast.makeText(helper.application,"Please enter a comment and pictures",Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(helper.application,"Your record was saved sucessfully",Toast.LENGTH_SHORT).show()

                } },
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(backgroundColor = EkarPrimary)


            ) {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    text = "Submit"
                )
            }
        }
    }


@Composable
fun Rendertoolbar(navController: NavController){

    AppToolbar(showbtn = "crossbtn", navController = navController)

}