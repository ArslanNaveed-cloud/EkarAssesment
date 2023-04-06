package cx.example.ekartest.ui.components.alerts

import androidx.compose.foundation.layout.Box
import androidx.compose.material.AlertDialog
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import cx.example.ekartest.ui.theme.EkarPrimary

@Composable
fun ImagePrompAlert(
    title: String,
    body: String,
    onDismiss: () -> Unit
) {
    // State to keep track of whether the dialog is open or not
    var openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        // Display the alert dialog if it's open
        AlertDialog(
            modifier = Modifier.wrapContentSize(),
            onDismissRequest = {
                // Close the dialog when the user dismisses it
                openDialog.value = false
                onDismiss()
            },
            title = { Text(title) },
            text = {
                Box(Modifier.wrapContentSize()) {
                    Text(body)
                }
            },
            confirmButton = {
                Button(
                    // Set the background color of the confirm button to the primary color
                    colors = ButtonDefaults.buttonColors(backgroundColor = EkarPrimary),
                    onClick = {
                        // Close the dialog and perform the dismiss action when the user clicks "Okay"
                        openDialog.value = false
                        onDismiss()
                    }
                ) {
                    Text("Okay")
                }
            },
            dismissButton = {
                Button(
                    // Set the background color of the cancel button to light gray
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                    onClick = {
                        // Close the dialog and perform the dismiss action when the user clicks "Cancel"
                        openDialog.value = false
                        onDismiss()
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}
