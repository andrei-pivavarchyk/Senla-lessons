package com.service;

import com.daoAPI.IBookDAO;
import com.daoAPI.IUserDataDAO;
import com.model.Book;
import com.serviceAPI.IBookService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class BookService implements IBookService {
    private static Logger log = Logger.getLogger(BookService.class);
    @Autowired
    private IBookDAO bookDAO;

    public BookService() {
    }

    public void addBook(Book book) {

        try {
            this.bookDAO.addEntity(book);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public void removeBook(Book book) {
        try {
            this.bookDAO.deleteEntity(book.getId());
        } catch (Exception e) {

        }
    }

}
