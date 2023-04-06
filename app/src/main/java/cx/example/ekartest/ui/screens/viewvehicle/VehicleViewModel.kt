package cx.example.ekartest.ui.screens.viewvehicle
/**

This file contains the VehicleViewModel class which is responsible for managing and providing data for the VehicleFragment.
 */
import android.content.Context
import android.location.Location
import android.util.Log
import androidx.lifecycle.*
import cx.example.ekartest.model.VehicleImageResponseData
import cx.example.ekartest.model.VehicleResponseData
import cx.example.ekartest.repository.VehicleRepo
import cx.example.ekartest.utils.helper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
/**

This class is responsible for managing and providing data for the VehicleFragment.
 */
class VehicleViewModel:ViewModel(),CoroutineScope {
    var context: Context
    private val job = Job()

    var repo:VehicleRepo
    /**

    Initializes the VehicleViewModel by setting the context and creating a new instance of VehicleRepo.
     */
    init {
        context = helper.application
        repo = VehicleRepo(context)
    }
    /**

    The coroutine context to run the coroutines on.
     */
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    /**

    Retrieves vehicle data and images using the VehicleRepo, and provides it through the callback.

    @param callback The callback function to provide the retrieved data through.
     */
    fun getVehicleData(
        callback: (VehicleResponseData?,VehicleImageResponseData?)->Unit
    ){
       launch {
         val response = repo.getVehicleDetails()

           if(response.success){
               val images = repo.getVehicleImageDetails(response.attributes.make,response.attributes.model,response.attributes.year,true,"Black",response.attributes.trim)
               Log.d("HELLO", "getVehicleData: "+images.images.get(0).thumbnailLink)
               if (images.images.isNotEmpty()){
                   callback(response,images)
               }
           }
       }
         }



}