package com.dao;

import com.daoAPI.IBookDAO;
import com.model.*;
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

    public List<Book> getAllBooks(Integer firstResult, Integer maxResults) throws Exception {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        List<Book> bookList = criteria.list();
        return bookList;
    }

    public List<Book> getBooksByAuthor(Author author) throws Exception {
        Criteria criteria = getSession().createCriteria(Book.class)
                .add(Restrictions.eq("author", author));
        List<Book> bookList = criteria.list();
        return bookList;
    }

    public Book getBookWithFeedbacks(Integer id) throws Exception {

        Criteria criteria = getSession().createCriteria(Book.class, "b")
                .add(Restrictions.eq("id", id))
                .createAlias("b.feedbackList", "feedbackList", JoinType.LEFT_OUTER_JOIN);

        return (Book) criteria.uniqueResult();
    }

    public List<Book> getBooksByGenre(BookGenre genre) throws Exception {
        Criteria criteria = getSession().createCriteria(Book.class)
                .add(Restrictions.eq("genre", genre));
        List<Book> bookList = criteria.list();
        return bookList;
    }

}
