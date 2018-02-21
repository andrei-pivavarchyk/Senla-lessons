package com.serviceAPI;

import com.model.Book;

public interface IBookService {
    public void addBook(Book book);
    void removeBook(Book book);
}