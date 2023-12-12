package com.vk.directop.validateform.presentation.books

class BookRepositoryImpl : BookRepository {


    override suspend fun getBook(name: String): Book =
        Book("dsf", "df", "dfdf")


    override suspend fun getBooks(query: String, maxCount: Int): List<Book> =
        emptyList<Book>()


}
