package com.controller;

import com.model.Book;
import com.model.BookGenre;
import com.serviceAPI.IBookDTOService;
import com.serviceAPI.IBookService;
import com.serviceAPI.IUserDataDTOService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserDataDTOService userDataDTOService;

    @Autowired
    private IBookDTOService bookDTOService;

    private static Logger log = Logger.getLogger(UserController.class);

    public BookController() {

    }

    @RequestMapping(
            value = {"books"},
            method = {RequestMethod.GET}
    )

    @ResponseBody

    public List<Book> getAllBooks(HttpServletResponse response, @RequestParam("first") int first, @RequestParam("max") int max) {
        List<Book> bookList = this.bookDTOService.getBookList(this.bookService.getAllBooks(first, max));
        if (bookList.isEmpty()) {
            response.setStatus(204);
            return new ArrayList<>();
        } else {
            return bookList;
        }
    }

    @RequestMapping(
            value = {"books-by-genre"},
            method = {RequestMethod.GET}
    )

    @ResponseBody

    public List<Book> getAllBooksByGenre(HttpServletResponse response, HttpServletRequest request, @RequestParam("genre") String bookGenre) {

        if (bookGenre != null) {

            BookGenre genre = BookGenre.valueOf(bookGenre.toUpperCase());
            response.setContentType("application/json");
            List<Book> bookList = this.bookDTOService.getBookList(this.bookService.getAllBooksByGenre(genre));
            if (bookList.isEmpty()) {
                response.setStatus(204);
                return new ArrayList<>();
            } else {
                return bookList;
            }
        } else {
            response.setStatus(500);
            return new ArrayList<>();
        }
    }
}