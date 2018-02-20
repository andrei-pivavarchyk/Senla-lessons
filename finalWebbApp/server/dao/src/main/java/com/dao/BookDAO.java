package com.dao;

import com.daoAPI.IBookDAO;
import com.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO extends BaseDAO<Book> implements IBookDAO {
    public BookDAO() {
        super(Book.class);
    }
}
