package com.vk.directop.validateform.presentation.books

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BooksMainScreen(
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier: Modifier
) {
    when (booksUiState) {
        is BooksUiState.Loading -> LoadingScreen(modifier)
        is BooksUiState.Success -> BooksGridScreen(
            books = booksUiState.bookSearch,
            modifier = modifier
        )
        is BooksUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
    }
}