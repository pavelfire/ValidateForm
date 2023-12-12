package com.vk.directop.validateform.presentation.books

interface BookRepository {

    suspend fun getBook(name: String): Book

    suspend fun getBooks(query: String, maxCount: Int): List<Book>

}
