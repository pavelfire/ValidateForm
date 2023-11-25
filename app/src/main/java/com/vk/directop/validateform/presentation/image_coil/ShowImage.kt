package com.vk.directop.validateform.presentation.image_coil

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.imageLoader
import coil.memory.MemoryCache
import com.vk.directop.validateform.presentation.components.ColorBox
import com.vk.directop.validateform.presentation.components.SpringLike
import com.vk.directop.validateform.presentation.components.UserPic

const val imageUrl =
    "https://ru.ml-vehicle.com/Content/uploads/2023931296/20230523153749d5d15dedfa0d44df9e77e9425d71a4c9.png"
const val imageUrl2 =
    "https://hips.hearstapps.com/hmg-prod/images/2024-hyundai-kona-electric-148-642b13cd7c51f.jpg?crop=0.861xw:0.726xh;0.0673xw,0.197xh&resize=700:*"
const val imageUrl3 = "https://i.insider.com/63484454f900fa001814c676?width=1136&format=jpeg"

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ShowImage(

) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        SubcomposeAsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .aspectRatio(1280f / 847f),
            loading = {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(44.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.secondary,
                )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            SubcomposeAsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1280f / 847f)
                    .rotate(degrees = 20.0f)
                    .offset((34).dp, (70).dp)
                    .clip(RoundedCornerShape(8.dp)),
                loading = {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(44.dp)
                            .align(Alignment.Center),
                        color = MaterialTheme.colorScheme.secondary,
                    )
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            SubcomposeAsyncImage(
                model = imageUrl2,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1280f / 847f)
                    .rotate(degrees = -14.0f)
                    .offset((10).dp, (40).dp)
                    .clip(RoundedCornerShape(8.dp)),
                loading = {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(44.dp)
                            .align(Alignment.Center),
                        color = MaterialTheme.colorScheme.secondary,
                    )
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            AsyncImage(
                model = imageUrl3,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1280f / 847f)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(modifier = Modifier.align(Alignment.CenterVertically),
                onClick = {
                    // remove by key
                    context.imageLoader.diskCache?.remove(imageUrl)
                    context.imageLoader.memoryCache?.remove(MemoryCache.Key(imageUrl))
                }) {
                Text(text = "Remove from cache blue car")
            }
            SpringLike()
            ColorBox()
            UserPic()
            UserPic()

        }
        SubcomposeAsyncImage(
            model = imageUrl2,
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .aspectRatio(1280f / 847f),
            loading = {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(44.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.secondary,
                )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        AsyncImage(
            model = imageUrl3,
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .aspectRatio(1280f / 847f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {
                context.imageLoader.diskCache?.clear()
                context.imageLoader.memoryCache?.clear()
            }) {
            Text(text = "Clear cache")
        }
    }
}