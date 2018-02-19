package com.dao;

import com.daoAPI.IAuthorDAO;
import com.model.Author;

public class AuthorDAO extends BaseDAO<Author> implements IAuthorDAO {
    public AuthorDAO() {
        super(Author.class);
    }
}
