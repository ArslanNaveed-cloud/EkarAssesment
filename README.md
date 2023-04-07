# Project for assessment for EKAR

This assessment has been created in **Kotlin using MVVM architecture**. Three composable screens were made, namely **ViewMap** for displaying maps and custom icons, **ViewVehicle** for showing vehicle information (i.e., images and textual information), and **ViewOnBoard** for displaying information about the application's images.

# Technologies Used

StackEdit stores your files in your browser, which means all your files are automatically saved locally and are accessible **offline!**

## Create files and folders

The file explorer is accessible using the button in left corner of the navigation bar. You can create a new file by clicking the **New file** button in the file explorer. You can also create folders by clicking the **New folder** button.


## Technologies Used

- Architecture: **MVVM** architecture following **repositories** and **data model classes**.
- User interface: Kotlin Compose.
- Maps and Marker: Google Maps API and custom marker.
- In-app Navigation: Moving between screens using Navigation library of Kotlin Compose.
- Image Loading: Coil library for displaying pictures.
- Network Calling: Retrofit is used to call apis

# Project Details
	 Project is made with minSdk 24 
	 The target sdk of appliation is targetSdk 33
	 The compileSdk is 33
### File Stucture

There are a total of 7 packages in the project

- **api**: this package has the basic setup of retrofit apis that are used for getting vehicle data
- **callback**: this package has the classes for handling different usecases i.e success/failed etc
- **model**: this package has data classes for containing the data accessed from the apis
- **repository**: this package handles all the background tasks i.e **(calling apis, getting data to their respective data classes)**
- **theme**: this package has the basic information about the application colors and main theme of the application
- **ui**: This package has sub packages
		1) components: this package has the separate containers i.e (columns, rows) that are a part of design screens
		2) navigation: this package has the classes/composable functions for creating and managing navigation in the application
		3) screens: this package has further sub packages:
				3.1) viewmap: this package has the main screen for viewing the map.
				3.2) viewvehicle: this package has the main screen for viewing the details of a vehicle and the viewmodel for handling all the logical operation
- **utils**: this package has the helper classes for creating general context of the application and also the screen names class which holds the name for UI screens that would be used for navigation. 

## Flow of Operation
### ViewMap Composable Screen

The app opens and checks if the user has given the **location permission**. If not, the app asks for the location permission. If granted, the app checks for **GPS settings**. In case the settings are enabled, the app takes the **current location** of the user and makes **API calls** to the Google Maps API and sets a custom marker to the current location.


### ViewVehicle Composable Screen

After the user clicks on the marker, the app takes the user to ViewVehicle using navigate method of google navigation library, which makes an API call to https://api.carsxe.com/specs? using view model and repository to the API service. In case of successful data loading, the app again makes an API call to get the images using API http://api.carsxe.com/images?. After the data is loaded properly, the data is then displayed in the containers/widgets of ViewVehicle Screen.

### ViewOnBoard Composable Screen

f the user clicks on "Proceed with selection," the app takes the user to the ViewOnBoard screen, where information regarding images for the application is mentioned.

# View Screens + Video
Screenshots can be found in the above folder of images and video respectively
