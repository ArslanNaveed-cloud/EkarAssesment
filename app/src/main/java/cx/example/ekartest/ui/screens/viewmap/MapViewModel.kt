package cx.example.ekartest.ui.screens.viewmap

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.FusedLocationProviderClient

import com.google.android.gms.location.LocationServices


class MapViewModel: ViewModel() {

    private lateinit var lastKnownLocation: Location
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationManager: LocationManager
    fun getDeviceLocation(
        context: Context,
        callback: (Location?)->Unit
    ) {
        /*
         * Get the best and most recent location of the device, which may be null in rare
         * cases when a location is not available.
         */

        try {
            locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

            val locationListener = object : LocationListener {
                override fun onLocationChanged(location: Location) {
                    callback(location)
                    locationManager.removeUpdates(this)
                }

                override fun onProviderEnabled(provider: String) {}

                override fun onProviderDisabled(provider: String) {
                    callback(null)
                }

                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
            }


            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                0L,
                0f,
                locationListener
            )

        } catch (e: SecurityException) {
            callback(null)
            Log.d("3344", "getDeviceLocation: "+e.message)
            // Show error
            e.printStackTrace()
        }
    }

}