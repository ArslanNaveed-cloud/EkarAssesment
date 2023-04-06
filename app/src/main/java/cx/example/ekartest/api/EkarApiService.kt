package cx.example.ekartest.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cx.example.ekartest.model.VehicleImageResponseData
import cx.example.ekartest.model.VehicleResponseData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

// This interface defines the API endpoints that are used to retrieve data about vehicles
interface EkarApiService {

    // This endpoint retrieves data about a specific vehicle
    @GET("specs")
    suspend fun getVehicleData(
        @Query("key") key: String, // The API key required to access the endpoint
        @Query("vin") vin: String, // The VIN (Vehicle Identification Number) of the vehicle

    ): VehicleResponseData // The response data type, which is a model object that contains the vehicle data

    // This endpoint retrieves images of a specific vehicle
    @GET("images")
    suspend fun getVehicleImageData(
        @Query("key") key: String, // The API key required to access the endpoint
        @Query("make") make: String, // The make of the vehicle
        @Query("model") model: String, // The model of the vehicle
        @Query("year") year: String, // The year of the vehicle
        @Query("trim") trim: String, // The trim level of the vehicle
        @Query("color") color: String, // The color of the vehicle
        @Query("transparent") transparent: Boolean, // Whether or not to retrieve transparent images

    ): VehicleImageResponseData // The response data type, which is a model object that contains the vehicle image data
}