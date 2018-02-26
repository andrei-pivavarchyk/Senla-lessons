package com.daoAPI;

import com.model.Author;

import java.util.List;

public interface IAuthorDAO extends IBaseDAO<Author> {
    List<Author> getAllAuthors();

}
