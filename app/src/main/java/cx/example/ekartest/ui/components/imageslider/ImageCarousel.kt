package cx.example.ekartest.ui.components.imageslider

import android.view.Surface
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

// This function takes in a list of names and ages and returns a map that maps each name to its corresponding age.
// It first creates an empty map and then loops through the list, adding each name and age to the map.

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageCarousel(
    modifier: Modifier = Modifier,
    pagerState: PagerState = remember { PagerState() },
    itemsCount: Int,
    itemContent: @Composable (index: Int) -> Unit,
) {
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    Column(
    ) {
        Box(
            modifier = modifier.fillMaxWidth(),
        ) {
            HorizontalPager(count = itemsCount, state = pagerState) { page ->
                itemContent(page)
            }

        }
        DotsIndicator(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            totalDots = itemsCount,
            selectedIndex = if (isDragged) pagerState.currentPage else pagerState.targetPage,
            dotSize = 8.dp
        )
    }

}