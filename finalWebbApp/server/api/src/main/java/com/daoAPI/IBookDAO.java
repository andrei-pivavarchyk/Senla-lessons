package com.daoAPI;

import com.model.Author;
import com.model.Book;
import com.model.BookGenre;

import java.util.List;

public interface IBookDAO extends IBaseDAO<Book>  {
    List<Book> getAllBooks(Integer firstResult,Integer maxResults)throws Exception ;
    List<Book> getBooksByAuthor(Author author)throws Exception ;
    Book getBookWithFeedbacks(Integer id)throws Exception ;
    List<Book> getBooksByGenre(BookGenre genre)throws Exception ;
}
