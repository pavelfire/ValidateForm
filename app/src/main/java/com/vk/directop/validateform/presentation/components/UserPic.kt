package com.vk.directop.validateform.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round

@Composable
fun UserPic(
    modifier: Modifier = Modifier
) {
    Row {
        val gradient = Brush.horizontalGradient(
            .344f to Color(0xFF5351DE),
            .6611f to Color(0xFFC04789),
            .9637f to Color(0xFFFAA630)
        )
        var myOffset by remember { mutableStateOf(Offset.Zero) }
        Image(
            imageVector = Icons.Default.Face,
            modifier = Modifier
                .clickable { }
                .offset { myOffset.round() }
                .pointerInput(Unit) {
                    detectDragGestures(onDrag = { _, drag -> myOffset += drag })
                }
                .padding(32.dp)
                .size(56.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(2.dp, gradient, CircleShape)
                .border(4.dp, Color.White, CircleShape),

            contentDescription = "avatar"
        )
    }
}

@Preview
@Composable
private fun UserPicPreview() {
    MaterialTheme {
        Column {
            UserPic()
        }
    }
}