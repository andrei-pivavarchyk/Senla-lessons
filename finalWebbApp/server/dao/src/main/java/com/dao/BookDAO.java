package com.dao;

import com.daoAPI.IBookDAO;
import com.model.Book;
import com.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
}
