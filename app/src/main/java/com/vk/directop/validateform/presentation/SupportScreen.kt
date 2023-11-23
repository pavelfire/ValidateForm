package com.vk.directop.validateform.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vk.directop.validateform.data.Category
import com.vk.directop.validateform.presentation.components.TrackItem

@Composable
fun SupportScreen(
    categories: List<Category>,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = "Support Screen",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        )
        TrackItem()
        TrackItem(
            artistName = "Frank Reyes",
            trackName = "Mujer de las mil batallas"
        )
    }
}