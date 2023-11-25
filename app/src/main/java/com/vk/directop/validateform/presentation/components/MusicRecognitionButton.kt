package com.vk.directop.validateform.presentation.components

//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.expandHorizontally
//import androidx.compose.animation.shrinkHorizontally
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue

//@Composable
//fun MusicRecognitionButton(
//    onClick: () -> Unit,
//    function: () -> Unit
//) {
//    var expanded by remember { mutableStateOf(true) }
//    MusicRecognitionButton(onClick = { expanded = !expanded }) {
//        MyCheckbox()
//        AnimatedVisibility(
//            visible = expanded,
//            enter = expandHorizontally(),
//            exit = shrinkHorizontally()
//        ) {
//            Text(text = "Recognize music")
//        }
//    }
//}