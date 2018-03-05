package com.service;

import com.daoAPI.IBookDAO;
import com.daoAPI.IUserDataDAO;
import com.model.Author;
import com.model.Book;
import com.model.BookGenre;
import com.serviceAPI.IBookService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
            log.error(e.toString());
        }
    }

    public List<Book> getAllBooks(Integer firstResult,Integer maxResults) {
        List<Book> bookList = null;
        try {
            bookList = this.bookDAO.getAllBooks(firstResult,maxResults);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return bookList;
    }

    public List<Book> getBooksByAuthor(Author author) {
        List<Book> bookList = null;
        try {
            bookList = this.bookDAO.getBooksByAuthor(author);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return bookList;
    }

    public Book getBookWithFeedbacks(Integer id) {
        Book book= null;
        try {
            book = this.bookDAO.getBookWithFeedbacks(id);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return book;
    }

    public List<Book> getAllBooksByGenre(BookGenre genre) {
        List<Book> bookList = null;
        try {
            bookList = this.bookDAO.getBooksByGenre(genre);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return bookList;
    }

}
