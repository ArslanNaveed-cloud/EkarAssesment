package cx.example.ekartest.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cx.example.ekartest.ui.theme.EkarPrimary
/**
 * Composable function to display a loading circular progress loader while the data operations are performed.
 * @param isDisplayed Identifier For the progress bar to be displayed or not
 */
@Composable
fun CircularProgressBar(
    isDisplayed: Boolean
){
    if(isDisplayed){
        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularProgressIndicator(
                color =EkarPrimary
            )
        }
    }

}