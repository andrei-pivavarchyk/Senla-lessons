package com.serviceAPI;

import com.model.Author;

import java.util.List;

public interface IAuthorService {
    void addAuthor(Author author);
    void removeAuthor(Author author);
    List<Author> getAllAuthors();
}