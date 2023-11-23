package com.vk.directop.validateform.presentation.fibonacci

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FibonacciScreen(
    modifier: Modifier = Modifier
) {

    val viewModel = viewModel<FibonacciViewModel>()
    val state = viewModel.state
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Fibonacci Screen",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        )
        OutlinedTextField(
            value = state.givenNumber.toString(), onValueChange = {
                viewModel.onEvent(FibonacciEvent.NumberChanged(it))
            },
            label = { Text("Enter n to calculate Fibonacci number") },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "n less than $MAX_CALCULATED_NUMBER")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.onEvent(FibonacciEvent.Calculate)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Calculate")
        }
        Text(
            text = state.resultNumber.toString(),
            fontSize = 34.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(34.dp)
                .align(Alignment.CenterHorizontally)
        )
        if (state.loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(64.dp)
                    .align(Alignment.CenterHorizontally),
                color = MaterialTheme.colorScheme.secondary,
            )
        }

    }
}