package com.dao;

import com.daoAPI.IBookDAO;
import com.model.Author;
import com.model.Book;
import com.model.User;
import com.model.UserData;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAO extends BaseDAO<Book> implements IBookDAO {
    public BookDAO() {
        super(Book.class);
    }
    public List<Book> getAllBooks(){
        Criteria criteria = getSession().createCriteria(Book.class);

        List<Book> bookList = criteria.list();
        return bookList;
    }
    public List<Book> getBooksByAuthor(Author author){
        Criteria criteria = getSession().createCriteria(Book.class)
                .add(Restrictions.eq("author", author));
        List<Book> bookList = criteria.list();
        return bookList;
    }
    public Book getBookWithFeedbacks(Integer id){

        Criteria criteria = getSession().createCriteria(Book.class, "b")
                .add(Restrictions.eq("id", id))
                .createAlias("b.feedbackList", "feedbackList", JoinType.LEFT_OUTER_JOIN);

        return (Book)criteria.uniqueResult();

    }
}
