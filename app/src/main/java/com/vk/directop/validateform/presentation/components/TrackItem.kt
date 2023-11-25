package com.vk.directop.validateform.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TrackItem(
    artistName: String = "Bebe Rexha",
    trackName: String = "Fuck fake friends"
) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(2.dp, Color.Green, CircleShape)
                    .border(4.dp, Color.Red, CircleShape),
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "avatar"
            )
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(text = trackName, fontSize = 16.sp)
                Text(text = artistName, fontSize = 14.sp, color = Color(0x79000000))
            }
        }

        IconButton(onClick = { }) {
            Icon(Icons.Default.ThumbUp, null)
        }
    }
}