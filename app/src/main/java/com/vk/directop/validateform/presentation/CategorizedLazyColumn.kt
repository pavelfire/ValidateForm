package com.vk.directop.validateform.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vk.directop.validateform.data.Category

@Composable
private fun CategoryHeader(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
    )
}

@Composable
private fun CategoryItem(
    text: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .background(
                if (isSelected) MaterialTheme.colorScheme.inversePrimary
                else MaterialTheme.colorScheme.background
            )
            .padding(16.dp)
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategorizedLazyColumn(
    categories: List<Category>,
    modifier: Modifier = Modifier
) {
    var selectedName by remember { mutableStateOf<String?>(null) }
    LazyColumn(modifier) {
        categories.forEach { category ->
            stickyHeader {
                CategoryHeader(text = category.name)
            }
            items(category.items) { text ->
                CategoryItem(text = text,
                    isSelected = text == selectedName,
                    onClick = { selectedName = text }
                )
            }
        }
    }
}