package cx.example.ekartest.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import cx.example.ekartest.R
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cx.example.ekartest.ui.components.AlertDialog
import cx.example.ekartest.ui.navigation.SetupNavGraph
import cx.example.ekartest.ui.screens.viewmap.MapViewModel
import cx.example.ekartest.ui.theme.EkarTestTheme


class MainActivity : ComponentActivity() {
    // Define class variables
    private lateinit var context: Context
    private lateinit var viewModel: MapViewModel
     lateinit var permissionGranted: MutableState<Boolean>
     lateinit var isLocationEnabled: MutableState<Boolean>
     lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize class variables
        context = this
        viewModel = MapViewModel()
        // Set content of the activity
        setContent {
            EkarTestTheme {
                // Check if location permission is granted and if location is enabled
                permissionGranted = remember { mutableStateOf(AskPermissions()) }
                    isLocationEnabled = remember { mutableStateOf(checkLocationEnabled(context)) }

                // If location permission is granted and location is enabled, set up the navigation graph

                if (permissionGranted.value && isLocationEnabled.value) {
                        navController = rememberNavController()
                        SetupNavGraph(navController)
                    }
                // If location permission is not granted, request it

                else if (!permissionGranted.value) {
                        AskPermissions()
                    }
                // If location permission is granted but location is not enabled, show the alert dialog

                else if (permissionGranted.value && !isLocationEnabled.value) {
                        AlertDialog(
                            context = context,
                            title = context.getString(R.string.title_text),
                            body = context.getString(R.string.body_text),
                            isLocationEnabled = isLocationEnabled
                        )
                    }
                }

        }
    }
        // Use ActivityResultContracts to request location permission

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            permissionGranted.value = true
            isLocationEnabled.value = checkLocationEnabled(context)

        }else{
            // Show a toast message if permission is not granted

            Toast.makeText(this,"Please give location permission to use Ekar",Toast.LENGTH_LONG).show()
        }
    }
        // Check if location permission is granted

    private fun AskPermissions(
    ):Boolean {
        val permissionCheckResult = ContextCompat.checkSelfPermission(context,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        // If location permission is granted, return true

        if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {

            return true

        }
        // Request a location permission if not granted

        else {
            // Request a permission
            val result= requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            Log.d("1234", "AskPermissions: $result")


        }

        return false
    }
}

// Check if location is enabled
fun checkLocationEnabled(context: Context): Boolean {
    val locationMode: Int = try {
        Settings.Secure.getInt(context.contentResolver, Settings.Secure.LOCATION_MODE)
    } catch (e: Settings.SettingNotFoundException) {
        e.printStackTrace()
        return false
    }
    return locationMode != Settings.Secure.LOCATION_MODE_OFF
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {

}