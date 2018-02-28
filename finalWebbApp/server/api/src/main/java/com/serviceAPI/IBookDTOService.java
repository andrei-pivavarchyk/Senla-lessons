package com.serviceAPI;

import com.model.Book;

import java.util.ArrayList;
import java.util.List;

public interface IBookDTOService {

    Book getBookDTO(Book book);



    public List<Book> getBookList(List<Book> bookList) ;
}