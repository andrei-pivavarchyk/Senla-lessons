package com.dao;

import com.daoAPI.IAuthorDAO;
import com.model.Author;
import com.model.Book;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAO extends BaseDAO<Author> implements IAuthorDAO {

    public AuthorDAO() {
        super(Author.class);
    }

    public List<Author> getAllAuthors() {
        Criteria criteria = getSession().createCriteria(Author.class);
        List<Author> allAuthors = criteria.list();
        return allAuthors;
    }
}
