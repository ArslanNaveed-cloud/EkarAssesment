package cx.example.ekartest.model

// This data class represents Vehicle Response Data of a vehicle

data class VehicleResponseData(

    val success: Boolean,
    val input: InputData,
    val attributes: AttributesData,
    val colors: List<ColorData>,
    val equipment: EquipmentData
)
