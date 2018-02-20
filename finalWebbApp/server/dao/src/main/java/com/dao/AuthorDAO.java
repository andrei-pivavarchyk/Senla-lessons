package com.dao;

import com.daoAPI.IAuthorDAO;
import com.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAO extends BaseDAO<Author> implements IAuthorDAO {
    public AuthorDAO() {
        super(Author.class);
    }
}
