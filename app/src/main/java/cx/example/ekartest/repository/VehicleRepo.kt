package cx.example.ekartest.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cx.example.ekartest.R
import cx.example.ekartest.api.EkarApiService
import cx.example.ekartest.callbacks.VehicleDataCallback
import cx.example.ekartest.model.VehicleImageResponseData
import cx.example.ekartest.model.VehicleResponseData
import cx.example.ekartest.utils.helper
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

class VehicleRepo(context: Context): CoroutineScope {
    val context = context
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    // Configures the OkHttp client with a read timeout and a connection timeout
    var client = OkHttpClient.Builder()
        .connectTimeout(2, TimeUnit.MINUTES)
        .readTimeout(2, TimeUnit.MINUTES).build()

    // Configures the Retrofit instance with the base URL, Gson converter, and OkHttp client
    private val apiService: EkarApiService = Retrofit.Builder()
        .baseUrl("https://api.carsxe.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(EkarApiService::class.java)

    // Fetches vehicle data using the VIN and the EkarApiService instance
    // Runs on a separate thread using coroutines and returns the vehicle data
    // If an exception occurs, it prints the stack trace and returns null
    suspend fun getVehicleDetails(): VehicleResponseData = withContext(Dispatchers.IO) {
        try {
            apiService.getVehicleData(context.getString(R.string.key), context.getString(R.string.vin))
        } catch (e: Exception) {
            e.printStackTrace()
            // You might want to return an error response here instead of null
            null
        }!!
    }

    // Fetches vehicle image data using make, model, year, trim, color, and transparent
    // Runs on a separate thread using coroutines and returns the vehicle image data
    // If an exception occurs, it prints the stack trace and returns null
    suspend fun getVehicleImageDetails(make:String,model:String,year:String,transparent:Boolean,color:String,trim:String): VehicleImageResponseData = withContext(Dispatchers.IO) {
        try {
            apiService.getVehicleImageData(context.getString(R.string.key), make,model,year,trim,color,transparent)
        } catch (e: Exception) {
            e.printStackTrace()
            // You might want to return an error response here instead of null
            null
        }!!
    }
}