package cx.example.ekartest.ui.components

import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import java.security.MessageDigest

/**
 * Composable function that displays an alert dialog with a message to the user.
 *
 * @param title the title of the alert dialog
 * @param body the body text of the alert dialog
 */
@Composable
fun MessageDialog(
    title: String,
    body: String,
) {
    val openDialog = remember { mutableStateOf(true) }
    if(openDialog.value) {
        androidx.compose.material.AlertDialog(
            modifier = Modifier.wrapContentSize(),
            onDismissRequest = {
                openDialog.value = false
            },
            title = { Text(title) },
            text = {
                Box(Modifier.wrapContentSize()) {
                    Text(body)
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Ok")
                }
            }
        )
    }
}
