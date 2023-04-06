package cx.example.ekartest.utils


/**
 * A general object that creates the class names which are to be passed into the .navigate method of navigation
 */
sealed class ScreenNames(val route: String){
    object viewMap : ScreenNames("ViewMap")
    object viewVehicle : ScreenNames("ViewVehicle")
    object viewOnBoard : ScreenNames("ViewOnBoard")

}
