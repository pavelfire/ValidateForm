package com.vk.directop.validateform.presentation.components

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun MyCheckbox () {
    var checked = remember{ mutableStateOf(true) }
    Checkbox(checked = checked.value,
        onCheckedChange = {
            checked.value = it
        })

}