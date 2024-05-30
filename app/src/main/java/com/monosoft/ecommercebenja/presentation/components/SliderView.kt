package com.monosoft.ecommercebenja.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.monosoft.ecommercebenja.R
import com.monosoft.ecommercebenja.presentation.ui.theme.Gray100


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SliderView(state: PagerState, images: List<String>) {

    val imageUrl = remember { mutableStateOf("") }
    HorizontalPager(
        state = state,//count = images.size,
         modifier = Modifier
            .height(325.dp)
            .fillMaxWidth()
            .background(color = Gray100)
    ) { page ->
        imageUrl.value = images[page]

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.BottomCenter) {

                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = imageUrl.value)
                        .apply(block = fun ImageRequest.Builder.() {
                            placeholder(R.drawable.user_image)
                            scale(Scale.FIT)
                        }).build()
                )
                Image(
                    modifier = Modifier.fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop,
                    painter = painter,
                    contentDescription = "",
                )
            }
        }
    }
}

