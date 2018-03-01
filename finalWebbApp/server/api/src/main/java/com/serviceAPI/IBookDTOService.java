package com.serviceAPI;

import com.model.Book;
import com.model.Feedback;

import java.util.ArrayList;
import java.util.List;

public interface IBookDTOService {

    Book getBookDTO(Book book);
    public List<Book> getBookList(List<Book> bookList) ;
    List<Feedback> getFeedBackList(List<Feedback> feedbackList);
}