package cx.example.ekartest.ui.components.imageslider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cx.example.ekartest.ui.theme.EkarPrimary

/**
 * Composable that displays a horizontal row of dots representing an indicator for a carousel or
 * image slider. The selected dot is highlighted with the [selectedColor], while all the others are
 * colored with [unSelectedColor].
 *
 * @param modifier Modifier for the row of dots.
 * @param totalDots The total number of dots to display.
 * @param selectedIndex The index of the selected dot.
 * @param selectedColor The color for the selected dot.
 * @param unSelectedColor The color for the unselected dots.
 * @param dotSize The size of each dot.
 */

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color = EkarPrimary,
    unSelectedColor: Color = Color.Gray,
    dotSize: Dp
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        items(totalDots) { index ->
            IndicatorDot(
                color = if (index == selectedIndex) selectedColor else unSelectedColor,
                size = dotSize
            )

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}