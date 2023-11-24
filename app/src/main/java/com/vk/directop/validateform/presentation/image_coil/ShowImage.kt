package com.vk.directop.validateform.presentation.image_coil

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

val imageUrl = "https://ru.ml-vehicle.com/Content/uploads/2023931296/20230523153749d5d15dedfa0d44df9e77e9425d71a4c9.png"

@Composable
fun ShowImage(

) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1280f/847f)
    )
}