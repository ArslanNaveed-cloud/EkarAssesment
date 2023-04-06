package cx.example.ekartest.callbacks

import cx.example.ekartest.model.VehicleResponseData

// This interface defines callbacks for when vehicle data is loaded or failed to load
interface VehicleDataCallback {

    // This method is called when vehicle data is successfully loaded
    fun onDataLoaded(vehicleResponseData: VehicleResponseData)

    // This method is called when vehicle data fails to load
    fun onDataFailed()
}