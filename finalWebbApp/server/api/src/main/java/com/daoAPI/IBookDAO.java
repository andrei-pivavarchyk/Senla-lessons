package com.daoAPI;

import com.model.Author;
import com.model.Book;
import com.model.BookGenre;

import java.util.List;

public interface IBookDAO extends IBaseDAO<Book> {
    List<Book> getAllBooks();
    List<Book> getBooksByAuthor(Author author);
    Book getBookWithFeedbacks(Integer id);
    List<Book> getBooksByGenre(BookGenre genre);
}
