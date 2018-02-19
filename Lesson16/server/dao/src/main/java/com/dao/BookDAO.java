package com.dao;

import com.daoAPI.IBookDAO;
import com.model.Book;

public class BookDAO extends BaseDAO<Book> implements IBookDAO {
    public BookDAO() {
        super(Book.class);
    }
}
