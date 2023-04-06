package cx.example.ekartest.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cx.example.ekartest.ui.checkLocationEnabled

// This composable function displays an AlertDialog that prompts the user to enable location services.
// It takes in a context, title, body and a mutable state isLocationEnabled which is updated based on user's choice.
@Composable
fun AlertDialog(
    context: Context,
    title: String,
    body: String,
    isLocationEnabled: MutableState<Boolean>
){
    // The openDialog variable is used to determine whether the AlertDialog should be displayed or not.
    // It is set to true initially to show the AlertDialog when this composable is first called.
    val openDialog = remember { mutableStateOf(true) }

    // Check if the AlertDialog should be displayed.
    if(openDialog.value){

        // Create a launcher for the location settings activity result.
        val locationSettingsLauncher = rememberLauncherForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { activityResult ->
            Log.d("1233", "AlertDialog: "+activityResult.resultCode)

            // Check if the location services are enabled after the user has returned from the location settings activity.
            if (checkLocationEnabled(context)) {
                isLocationEnabled.value = true
            }else{
                Toast.makeText(context,"Enable Location to Use the Application",LENGTH_LONG).show()
            }
        }

        // Show the AlertDialog with title, body, and a button to enable location services.
        AlertDialog(
            modifier = Modifier.wrapContentSize(),
            onDismissRequest = {
                // When the AlertDialog is dismissed, set the openDialog variable to false to prevent it from being displayed again.
                openDialog.value = false
            },
            title = { Text(title) },
            text = {
                Box(Modifier.wrapContentSize()) {
                    Text(body)
                }
            },
            confirmButton = {
                Button(
                    onClick = {

                        // Launch the location settings activity when the user clicks the button to enable location services.
                        var intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                        locationSettingsLauncher.launch(intent)
                    }
                ) {
                    Text("Enable Location Services")
                }
            }
        )
    }
}
