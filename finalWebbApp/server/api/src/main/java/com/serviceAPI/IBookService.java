package com.serviceAPI;

import com.model.Author;
import com.model.Book;

import java.util.List;

public interface IBookService {
    public void addBook(Book book);
    void removeBook(Book book);
    List<Book> getAllBooks();
    List<Book> getBooksByAuthor(Author author);
    Book getBookWithFeedbacks(Integer id);
}