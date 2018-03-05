package com.service.dtoService;

import com.model.Author;
import com.model.Book;
import com.model.Feedback;
import com.serviceAPI.IBookDTOService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookDTOService implements IBookDTOService{

    public Book getBookDTO(Book book) {

        Book book2=new Book();

        book2.setBookCost(book.getBookCost());
        book2.setBookDescription(book.getBookDescription());
        book2.setBookName(book.getBookName());
        book2.setBookStatus(book.getBookStatus());
        book2.setGenre(book.getGenre());
        Author author=new Author();
        author.setName(book.getAuthor().getName());
        author.setSurname(book.getAuthor().getSurname());
        book2.setAuthor(author);
        return null;
    }

    public List<Feedback> getFeedBackList(List<Feedback> feedbackList){
        List<Feedback> feedbacks=new ArrayList<>();
        for(Feedback feedback:feedbackList){
            Feedback feedback2=new Feedback();
            feedback2.setBook(feedback.getBook());
            feedback2.setFeedback(feedback.getFeedback());
            feedback2.setTitle(feedback.getTitle());
            feedback2.setId(feedback.getId());
            feedbacks.add(feedback2);
        }
        return feedbacks;
    }
    public List<Book> getBookList(List<Book> bookList) {
        List<Book>userDataBookList=new ArrayList<>();
        for (Book book : bookList) {
            Book book2 = new Book();
            book2.setId(book.getId());
            book2.setGenre(book.getGenre());
            book2.setAuthor(book.getAuthor());
            book2.setBookCost(book.getBookCost());
            book2.setBookDescription(book.getBookDescription());
            book2.setBookName(book.getBookName());
            book2.setBookStatus(book.getBookStatus());
            userDataBookList.add(book2);
        }
        return userDataBookList;
    }
}