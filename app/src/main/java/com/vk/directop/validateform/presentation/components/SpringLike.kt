package com.vk.directop.validateform.presentation.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.spring
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale

@Composable
fun SpringLike(
    isLiked: Boolean = false,
    onClick: () -> Unit
) {
    var filledLikeSize by remember { mutableStateOf(0f) }
    var showEmptyLike by remember { mutableStateOf(true) }

    LaunchedEffect(isLiked) {
        if (isLiked) {
            animate(0f, 1f, animationSpec = spring(Spring.DampingRatioHighBouncy)) { value, _ ->
                if (value >= 1f) showEmptyLike = false
                filledLikeSize = value
            }
        } else {
            filledLikeSize = 0f; showEmptyLike = true
        }
    }

    if (showEmptyLike) {
        Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
    }

    if (filledLikeSize > 0f) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            modifier = Modifier.scale(filledLikeSize)
        )
    }
}