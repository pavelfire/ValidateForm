package com.vk.directop.validateform.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vk.directop.validateform.ui.theme.ValidateFormTheme

@Composable
fun AnimatedCircles() {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val size by infiniteTransition.animateFloat(
        initialValue = 1.0f,
        targetValue = 0.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Circle(size)
        Circle(size)
        Circle(size)
    }
}

@Composable
fun Circle(scale: Float) {
    Box(
        modifier = Modifier
            .scale(scale)
            .size(50.dp)
            .padding(10.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)

    )
}

@Preview(showBackground = true)
@Composable
fun AnimatedCirclesPreview() {
    ValidateFormTheme {
        AnimatedCircles()
    }
}

@Composable
fun AnimatedCircles2() {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val sizes = listOf(
        infiniteTransition.animateFloat(
            initialValue = 1.0f,
            targetValue = 0.5f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 999, easing = LinearEasing, delayMillis = 333),
                //repeatMode = RepeatMode.Reverse
            ), label = ""
        ),
        infiniteTransition.animateFloat(
            initialValue = 1.0f,
            targetValue = 0.5f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 999, easing = LinearEasing, delayMillis = 666),
                repeatMode = RepeatMode.Reverse
            ), label = ""
        ),
        infiniteTransition.animateFloat(
            initialValue = 1.0f,
            targetValue = 0.5f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 999, easing = LinearEasing),
                //repeatMode = RepeatMode.Reverse
            ), label = ""
        )
    )
//    val size1 by infiniteTransition.animateFloat(
//        initialValue = 1.0f,
//        targetValue = 0.5f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 1000, easing = LinearEasing),
//            repeatMode = RepeatMode.Reverse
//        ), label = ""
//    )
//    val size2 by infiniteTransition.animateFloat(
//        initialValue = 1.0f,
//        targetValue = 0.5f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 1000, easing = LinearEasing),
//            repeatMode = RepeatMode.Reverse
//        ), label = ""
//    )
//    val size3 by infiniteTransition.animateFloat(
//        initialValue = 1.0f,
//        targetValue = 0.5f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 1000, easing = LinearEasing),
//            repeatMode = RepeatMode.Reverse
//        ), label = ""
//    )

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        sizes.forEach { size ->
            Circle(size.value)
        }
//        Circle(size1)
//        Circle(size2)
//        Circle(size3)
    }
}