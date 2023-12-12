package com.vk.directop.validateform.presentation.books

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.vk.directop.validateform.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksApp(
    modifier: Modifier = Modifier
) {
    val booksViewModel: BooksViewModel = BooksViewModel(BookRepositoryImpl())// =
       // viewModel(factory = BooksViewModel.Factory)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar (
                title = {
                    Text(text = stringResource(id = R.string.book_title))
                }
            )
        }

    ) {
        Surface(modifier = modifier
            .fillMaxSize()
            .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            BooksMainScreen(
                booksUiState = booksViewModel.booksUiState,
                retryAction = { booksViewModel.getBooks() },
                modifier = modifier
            )
        }
    }
}