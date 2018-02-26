package com.daoAPI;

import com.model.Book;

import java.util.List;

public interface IBookDAO extends IBaseDAO<Book> {
    List<Book> getAllBooks();
}
